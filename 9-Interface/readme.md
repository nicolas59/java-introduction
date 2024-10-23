# Les interfaces

## Introduction

Une interface est un prototype de classe définissant des méthodes devant être
implémentées par les classes réalisant ce prototype.

En java, une interface est introduit par le mot clé **interface**.

Une interface peut contenir :
* Des signatures de méthodes
* Des variables avec « public static final »

Une classe peut implémenter plusieurs interfaces via le mot clé ** implements**

Une interface peut étendre plusieurs interfaces via le mot clés **extends**

## Declaration

Fichier [AutoRoute](src/main/java/AutoRoute.java)

```java
public interface AutoRoute {

    /**
     * retourne la categorie afin de calculer le prix du péage
     *
     * @return
     */
    int getCategorie();
}
```

Fichier [PoidsLourd](src/main/java/PoidsLourd.java)
```java
public class PoidsLourd extends Vehicule
        implements AutoRoute {

    public PoidsLourd(String modele, int nbEssieux) {
        super(modele, nbEssieux);
    }

    @Override
    public int getCategorie() {
        return 2;
    }
}
```

Fichier [Voiture](src/main/java/Voiture.java)
```java
public class Voiture extends Vehicule
        implements AutoRoute {

    public Voiture( String modele, int nbEssieux) {
        super(modele, nbEssieux);
    }
    @Override
    public int getCategorie() {
        return 1;
    }
}
```

Ainsi, les classes **Voiture** et **PoidsLourd** implémentent l'interface **AutoRoute**. 
On a l'obligation de définir la méthode **getCategorie()**.





## Les méthodes par défaut

Depuis Java 8, on peut avoir de méthodes avec une implémentation exploitant les méthodes de l’interface.
La méthode doit avoir le mot clé **default**
