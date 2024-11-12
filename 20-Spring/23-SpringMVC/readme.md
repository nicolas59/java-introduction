# Spring MVC

## Dépendance

Afin d'utiliser Spring MVC, il est nécessaire d'ajouter la dépendance suivante dans le fichier **pom.xml**.

```xml
<dependency>
     <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>${spring.boot.version}</version>
</dependency>
```

## Les contrôleurs

Les classes interceptant les appels à http sont souvent appelées des *contrôleurs*.

Les annotations **@RestController** ou **Controller** sont à positionner sur les classes ayant ce rôle.

```java
@RestController
public class GareController {

}
```

Ces classes interceptant des appels http doivent être associes à des urls. 
L'annotation **@RequestMapping** permet de définir l'url associée et également le contenu produit et/ou intercepté.

L'exemple précédent est complété afin d'indiquer que la classe *GareController* interceptera les urls de type **/v1/gares** et produira du contenu json.

```java
@RestController
@RequestMapping(value = "/v1/gares", produces = MediaType.APPLICATION_JSON_VALUE)
public class GareController {

}
```

## Les méthodes

Les méthodes des classes controleurs vont être associées à des appels http. 
Pour chaque type de méthodes http, une annotation spécifique y sera associée.

| Annotation     | Méthode Http | Rôle                                                        |
|----------------|--------------|-------------------------------------------------------------|
| @GetMapping    | GET          | Récupérer un element ou une liste d'éléments                |
| @PostMapping   | POST         | Créer / modifier un élement                                 |
| @PutMapping    | PUT          | Modifier une partie d'un élement                            |
| @DeleteMapping | DELETE       | Supprimer un élement                                        |      
| @HeadMapping   | HEAD         | Verifier si un élement existe. Aucun contenu n'est retourné |


La méthode **search** permet de récupérer un énsemble de gares.

```java
@GetMapping
Page<Gare> search(Pageable page) {
    return gareService.findAll(page);
}
 ```

La méthode **searchById** permet de rechercher une gare à partir de son identifiant. 
L'url sera de la forme "/{id}", l'id représentant l'identifiant de la gare. 
Spring va automatiquement extraire l"identifiant de l'url. 
Par exemple, à partir de l'url http://localhost:8080/v1/gares/87741132, Spring va extraire la valeur **87741132** et l'associer à la variable interceptant la variable du chemin id.

```java
@GetMapping("/{id}")
Gare searchById(@PathVariable("id") Long id) {
    return gareService.findById(id).orElse(null);
}
```

Des annotations sont prévues pour chaque type de variables : 

| Annotation      | Type de variable          | exemple          | 
|-----------------|---------------------------|------------------|
| @PathVariable   | variable dans l'url       | /v1/gares/12446  |
| @RequestParam   | paramétres de la requete  | /v1/gares?page=2 |
| @RequestBody    | corps de l'appel          |                  |
| @RequestHeader  | Paramétre dans l'entête   |                  |

L'annotation doit être positionnée avant le paramétre de la méthode en indiquant si nécessaire le nom de la valeur extrait de l'appel.


> Par defaut l'application s'execute sur le port 8080. La variable **server.port** permet de changer le port.
> Cette variable peut être modifiée dans le fichier application.yml ou passée en parametre

## Jouer avec les codes HTTP

Réaliser des API Rest suppose de respecter 2 régles :
- utilsier correctement les méthodes HTTTP
- s'appuyer sur les codes HTTP pour donner un sens à la résponse.

Par exemple, si un élement n'existe pas, le service retournera le code http 404

Lors de la création d'un élement, le service retournera le code http 401 (CREATED) avec l'url afin de récuperer la resource.

Si une erreur de données, l'application retournera un code du type 4XX.

Pour une erreur serveur non gérée, on sera le plus fréquemment sur une erreur du type 500.

Pour personnaliser les codes retournés, nous avons à notre possession:
- l'utilisation de la classe **ResponseEntity**
- l'utilisation de l'annotation **@ResponseStatus** lors de la déclaration des exceptions.


### La classe **ResponseEntity**

Au lieu de retourner directement l'objet en retour de la méthode interceptant une url, il est possible de retourner une instance de la classe **ResponseEntity** et en personnalisant :
* le code http
* le contenu retourné
* la personnalisation des entêtes http

Par exemple, le code suivant indique une manière pour la création d'une nouvelle resource.

```java
@PostMapping
ResponseEntity<Void> create(@RequestBody Gare gare) {
    this.gareService.save(gare);
    var createdObjectRequest = UriComponentsBuilder.fromPath("/v1/gares/{id}")
            .build(gare.getId());
    return ResponseEntity.created(createdObjectRequest).build();
}
```

Si nous créons la nouvelle gare, 

```shell
curl -X 'POST' \
  'http://localhost:8080/v1/gares' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "libelle": "Nouvelle Gare",
  "supportFret": true,
  "supportVoyageurs": true,
  "codeLigne": "TER1",
  "adresse": {
    "commune": "EPSI City",
    "departement": "Nord"
  }
}' -v
```

nous obtenons en réponse : 
```shell
< HTTP/1.1 201 
< Location: /v1/gares/87988720
< Content-Length: 0
< Date: Tue, 12 Nov 2024 21:26:50 GMT
```

###  L'annotation **@ResponseStatus**

L'annotation **@ResponseStatus** positionnée sur la classe d'une exception permet de définir le code http et le message en cas de la levée de l'exception.

Créons une nouvelle classe d'exception **NotFoundException** qui sera utilisée lorsqu'une gare ne sera pas trouvée.

```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends Exception{
}
```

En modifiant la méthode **findById**, nous indiquons que la méthode peut lever l'exception : 

```java
@Operation(description = "Permet de rechercher une gare à partir de son id")
@ApiResponses({
        @ApiResponse(responseCode = "200",
                content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = Gare.class))}),
        @ApiResponse(responseCode = "404", description = "gare non trouvée", content = @Content())
})
@GetMapping("/{id}")
Gare searchById(@PathVariable("id") Long id) throws NotFoundException{
    return gareService.findById(id).orElseThrow(()-> new NotFoundException());
}
```

En testant avec un identiant de gara inconnu, nous obtenons l'erreur 404.
```shell
curl -X 'GET' \
  'http://localhost:8080/v1/gares/9999999' \
  -H 'accept: application/json' \
  -v
```

```shell
< HTTP/1.1 404 
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Tue, 12 Nov 2024 21:44:40 GMT
< 
* Connection #0 to host localhost left intact
{"timestamp":"2024-11-12T21:44:40.988+00:00","status":404,"error":"Not Found","path":"/v1/gares/9999999"}% 
```

> Afin de réaliser un swagger contenant le plus d'informations sur les services, il est parfois nécessaire d'enrichir la description avec des annotations. Par exemple, l'annotation @ApiResponses permet de décrire les codes http pouvant être retournés.

> L'annotation @ResponseStatus permet dégérer des cas simples de retour http.
> Il est également possible d'utiliser les annotations @ExceptionHandler et @ControllerAdvice qui permettrons de personnaliser plus finement le code http et le contenu retournés.

## swagger-ui

Les applications Java sont essentiellement utilisées pour créer des API Rest.
Pour définir les contrats de services, c'est à dire les urls prises en charge par l'application, des documents swagger sont le plus souvent proposés.. 
Ces documents sont au format Json. 

Il est assez facile d'intégrer des librairies permettant :
- de générer le document Json
- de fournir un visuel type swagger-ui

Pour spring boot 3, ajouter la dépendance : 

```xml
 <dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

Au lancement de l'application, de nouveaux endpoints seront disponibles : 

L'url http://localhost:8080/v3/api-docs permet de visualer le document JSON de définitions des services : 

```json
{
  "openapi": "3.0.1",
  "info": {
    "title": "OpenAPI definition",
    "version": "v0"
  },
  "servers": [
    {
      "url": "http://localhost:8080",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/v1/gares": {
      "get": {
        "tags": [
          "gare-controller"
        ],
        "description": "Permet de rechercher des gares",
        "...": "..."
      }
    }
  }
}
```

L'url http://localhost:8080/swagger-ui/index.html permet de visualiser une page type swagger-ui

![swagger](./assets/swagger.png)

## Créer une application web autonome

Un des objectifs de spring boot est fournir une application au format jar totalement autonome ayant tout le nécessaire pour s'executer.

En executant la commande suivante, un fichier au format jar contenant tout le nécessaire au fonctionnement sera réalisé à la racine du répertoire **target** 
```shell
mvn clean package spring-boot:repackage
```

La commande java permettra de lancer l'application : 

```shell
java -jar target/23-SpringMVC-1.0-SNAPSHOT.jar fr.epsi.spring.demo.Application
```



