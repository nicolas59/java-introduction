# Les interfaces

## Introduction

Une interface est un prototype de classe définissant des méthodes devant être
implémentées par les classes réalisant ce prototype.

En java, une interface est introduite par le mot clé **interface**.

Une interface peut contenir :
* Des signatures de méthodes
* Des variables avec *public static final*
* Des méthodes statiques

Une classe peut implémenter plusieurs interfaces via le mot clé **implements**.

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

Depuis Java 8, on peut avoir des méthodes **avec une implémentation** exploitant les méthodes de l’interface.

La méthode doit être préfixée par le mot clé **default**.

Si nous reprenons l'interface **AutoRoute**, nous pouvons ajouter la méthode **calulerPrixPeage** qui sera une méthode par défaut et utilisera la catégorie du vehicule afin de caluler le prix.

```java
public interface AutoRoute {

    /**
     * retourne la categorie afin de calculer le prix du péage
     *
     * @return
     */
    int getCategorie();

    /**
     * calcule le prix du péage.
     *
     * @return prix du péage
     */
    default double calulerPrixPeage(){
        return getCategorie() * 15;
    }
}

```

Les classes **PoidsLourd** et **Voiture** ne sont pas obligées de fournir une implémentation à la méthode **calulerPrixPeage**

> Ainsi, il est désormais possible d'ajouter de nouvelles méthodes sur des interfaces sans que cela n'impacte la compilation des applications. 
> Ce nouveau concept a ainsi permis d'intégrer la philosophie des streams au niveau des collections tout en conservant la rétro compatibilité des classes existantes liées aux collections.