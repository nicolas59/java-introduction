# Les Maps

----


Les maps permettent de représenter des tableaux associatifs. Les élements du tableau sont associés à une clé.

Caractèristiques de la clé :  
* elle est Associé à une clé une valeur
* il n'y a pas de duplication de clés. Chaque clé est unique et associée à une unique valeur.


Quant à la valeur,  elle peut être associée à plusieurs clés.

La clé et la valeur sont des objets.


## Les implémentations principales du JDK

Les implémentations principales :
* HashTable
  * Depuis java 1.0
  * Toutes les méthodes sont synchronisées.
  * Performance médiocre


* HashMap
  * Pour optimiser la recherche d’une clé, la classe range les clés à partir de leur hashcode.
  * Pas de conversation de l’ordre d’insertion


* LinkedHashMap
  * Conservation de l’ordre d’insertion

## Les méthodes

| Méthode                         | Description                                                                                                               |
|---------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| V put(K key, V value)           | Permet d’ajouter une entrée. Dans le cas où la clé est déjà présent, la valeur écrase l’ancienne valeur                   |
| V remove(Object key)            | Permet de supprimer la clé                                                                                                |                                                                       
| int size()                      | Permet d’obtenir la taille de la map                                                                                      |                                                            
| boolean isEmpty()               | Indique si la map est vide                                                                                                |                                                                  
| V get(Object key)               | Permet d’obtenir la valeur associée à la clé. Si la clé n’est pas présente, la valeur null est retournée                  |
| Set<Map.Entry<K, V>> entrySet() | Permet de récupérer un set.Le plus souvent utilisé pour le parcours des éléments de la map enassociant la clé au valeur   |
| Collection<V> values()          | Permet de récupérer toutes les valeurs                                                                                    |
| Set<K> keySet()                 | Permet de récupérer toutes les clés                                                                                       |


## Des exemples

### Recherche de clé

```java
import java.util.HashMap;
import java.util.Map;

public class Main1 {

    public static void main(String[] args) {
        /* 
         * declaration de la map.
         * on indique qu'il s'git d'une map dont le type est une string
         * et la valeur sera également de type string
         */ 
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "James Gosling");
        languages.put("Javascript", "Brendan Eich");
        languages.put("Python", "Guido van Rossum");
        languages.put("C", "Dennis Ritchie");

        //recherche de la valeur à partir de la clé
        String creator = languages.get("Java");
        System.out.println(creator);
    }
}

```
```shell
mvn --quiet compile exec:java -Dexec.mainClass=Main1
James Gosling
```

### Parcourir une map

```java
import java.util.HashMap;

public class Main2 {

    public record Country(String name, String capital, Long population) {
    }

    public static void main(String[] args) {
        var countries = new HashMap<String, Country>();
        countries.put("France", new Country("France", "Paris", 68_000_000L));
        countries.put("Allemagne", new Country("Allemagne", "Berlin", 84_000_000L));
        countries.put("Anglaterre", new Country("Angleterre", "Londres", 57_000_000L));
        countries.put("Belgique", new Country("Belgique", "Bruxelles", 12_000_000L));

        for (var country : countries.entrySet()) {
            System.out.println(country.getKey() + " : \t "+ country.getValue());
        }
    }
}
```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Main2
Allemagne : 	 Country[name=Allemagne, capital=Berlin, population=84000000]
Anglaterre : 	 Country[name=Angleterre, capital=Londres, population=57000000]
France : 	 Country[name=France, capital=Paris, population=68000000]
Belgique : 	 Country[name=Belgique, capital=Bruxelles, population=12000000]
```

> On constate que l'ordre n'est pas respecté. 

> L'interface **Map** propose la méthode **entrySet** permettant de récupérer un set d'objets Map.Entry.
> Map.Entry contient 2 méthodes : getKey pour récupérer la clé et getValue pour récupérer la valeur.