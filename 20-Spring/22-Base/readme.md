# Les Bases

Le but de Spring est d'instancier lui-meme les classes de services et d'associer celles-ci entre.

Pour detecter qu'une classe doit être géré par Spring, il est nécessaire de déclarer des annotations.

En partant d'un exemple, nous allons découvrir les annoations à utiliser.

> Les premieres versions de Spring, avant l'avénement des annotations, utilisaient des fichiers xml pour associer les instances entre elles.


## Les annotations @Service, @Component et @Repository

Positionnées au-dessus du nom de la classe, elle indique à Spring que la classe doit être instanciés et qu'elle sera utilisé au sein du contexte de l'application.

Fonctionnement quasiment identiques, la différence de noms est surtout présente pour indiquer le rôle que la classe va jouer.
- **@Component** : composant de base. Assure un fonctionnement globale à l'application
- **@Service** : composant indiquant que cette classe va intégrer des régles de gestion lié au périmétre couvert par l'application
- **@Repository** : composant dont l'objectif est de fournir des accés aux données.

La classe **GareRepository** a pour objectif de charger à partir d'un fichier CSV une liste de gares en France. 
Assoicée à de la restituion de données, cette classe est annotée avec l'annotation **@Repository**.
```java 
@Repository
public class GareRepository {

    private List<Gare> gares;

    private final String file;

    public GareRepository(@Value("${demo.file}") String file) {
        this.file = file;
    }

    @PostConstruct
    public void initialize() {
        try (var reader = new BufferedReader(new InputStreamReader(GareRepository.class.getResourceAsStream(this.file)))) {
            var csvReader = new CsvToBeanBuilder<Gare>(reader)
                    .withType(Gare.class)
                    .withSeparator(';')
                    .build();
            this.gares = csvReader.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Gare> findGareByVille(String ville) {
        return gares.stream().filter(gare -> gare.getLibelle().startsWith(ville)).findFirst();
    }
}
```

En mettant l'application en debug, nous constatons qu'une instance à cette classe a été crée par Spring.

![alt GareRepository](./assets/GareRepository.png "GareRepository")

Quant à la classe **GareService**, elle représente la classe de service de l'application de gestion des gares.
Cette classe a besoin d'accés aux données associées aux gares. 
Ainsi, lors du chargement de spring, l'instance de la classe **GareService** aura besoin de la classe **GareRepository** pour être pleinement fonctionnel.
Nous déclarons ainsi un constructeur prenant en paramétre une instance de cette classe. 

```java
@Service
public class GareService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GareService.class);

    private GareRepository gareRepository;

    public GareService(GareRepository gareRepository) {
        this.gareRepository = gareRepository;
    }

    public Optional<Gare> findGareByVille(String ville) {
        LOGGER.debug("Rercherche de la gare commencant par {}", ville);
        return this.gareRepository.findGareByVille(ville);
    }
}
```

Lorsque Spring crérera l'instance de la classe **GareService**, il réalisera les étapes suivantes : 

1. Chargement de la classe **GareService**
2. Detectection du contructeur necessitant en paramétre à la classe **GareRepository**
3. Création d'une instance à la classe **GareRepository**
4. Création d'une instance à la classe  **GareService** en invoquant le constructeur **GareRepository**

Si nous nous mettons en debug, nous constaterons que l'instance à **GareService** posséde bien une instance à la classe **GareRepository**.

![alt GareService](./assets/GareService.png "GareService")

## L'annotation @Autowired

L'annotation **@Autowired** indique à Spring que la propriété doit être renseignée (settée) avec une instance de classe gérée par Spring.

```java
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    GareService gareService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Recherche d'une gare à lille : ");
        System.out.println(this.gareService.findGareByVille("Lille").orElseThrow().toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

```

Dans la classe **Application**, classe de lancement de notre application, l'instance de cette classe utilisera l'instance de la classe **GareService** pour invoquer la méthode **findGareByVille**.

Ainsi, en mettant l'annotation  @Autowired sur cette propriété, Spring injectera l'instance la classe de service.

```java
 @Autowired
 GareService gareService;
```

## Spring Boot et la configuration

Spring Boot fournit un mécanisme avancé de configuration d'applications à travers des fichiers de configuration, des paramétres d'environnement...

Chaque librairie associée à un domaine technique fournit par défait un ensemble de variables afin de faciliter son fonctionnement.

Par exemple, la configuration des logs est facilité par des variables spécifique :

Fichier [application.yml](src/main/resources/application.yml)

```yaml
logging:
    level:
      root: warn
      org.springframework.web: debug
      fr.epsi.spring: debug

```

Il également possible d'ajouter ses propres variables : 

```yaml
demo.file: /liste-des-gares.csv
```

Pour utiliser ces variables, l'annoation @Value indiquera à spring à injecter la valeur associée en allant chercher la valuer dans les élements de configuration.

```java
@Repository
public class GareRepository {

    private List<Gare> gares;

    private final String file;

    public GareRepository(@Value("${demo.file}") String file) {
        this.file = file;
    }
}
```

## l'annotation **@SpringBootApplication**

L'annotation **@SpringBootApplication** indique à Spring que la classe de chargement de l'application. 
On y trouve généralement la méthode **main** utiliséé pour lancer l'application.

```java
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    GareService gareService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Recherche d'une gare à lille : ");
        System.out.println(this.gareService.findGareByVille("Lille").orElseThrow().toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

Il est impossible de positioner du code dans la méthode main pour utiliser les services que nous venons de créer. 
Dans notre exemple, la classe implémente l'interface **CommandLineRunner**. 

Cette interface propose la méthode *run* à implémenter. Aprés le chargement de **Spring**, la méthode sera invoquée par l'application en passant en paramétre les arguments passés lors du changement de l'application (ie les mêmes que ceux de la méthode main) 
 
Ainsi, l'execution de cette classe lancera le programme :

```shell
mvn --quiet compile exec:java -Dexec.mainClass=fr.epsi.spring.base.Application
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-11-06T23:33:13.427+01:00  INFO 6471 --- [           main] fr.epsi.spring.base.Application          : Starting Application using Java 21.0.2 with PID 6471 (/Users/nrousseau1/Documents/03.sources/epsi/java-introduction/20-Spring/22-Base/target/classes started by nrousseau1 in /Users/nrousseau1/Documents/03.sources/epsi/java-introduction)
2024-11-06T23:33:13.430+01:00 DEBUG 6471 --- [           main] fr.epsi.spring.base.Application          : Running with Spring Boot v3.3.0, Spring v6.1.8
2024-11-06T23:33:13.430+01:00  INFO 6471 --- [           main] fr.epsi.spring.base.Application          : No active profile set, falling back to 1 default profile: "default"
2024-11-06T23:33:14.125+01:00  INFO 6471 --- [           main] fr.epsi.spring.base.Application          : Started Application in 1.045 seconds (process running for 1.373)
Recherche d'une gare à lille : 
2024-11-06T23:33:14.127+01:00 DEBUG 6471 --- [           main] f.epsi.spring.base.service.GareService   : Rercherche de la gare commencant par Lille
Gare[adresse=fr.epsi.spring.base.domain.Adresse@3a2b2322, id=0, libelle='Lille-St-Sauveur', supportFret=true, supportVoyageurs=false, codeLigne='277100']
```