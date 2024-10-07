__# Les tableaux

Un tableau est une structure de données permettant de stocker une liste d’une longueur finie d’éléments de même type.

Un tableau est un objet possédant la propriété **length**. Cette propriété length permet d’obtenir la taille
du tableau

Les éléments d’un tableau sont accessibles à partir d’un index. 
Le premier élément est à l’index 0 (Zero based index origin)

## Déclaration

La déclaration est identique à celle utilisé dans le langage **C**.

**Syntaxe :**

```java 
type[] name; // syntaxe préconisée `
type name[]; 
```

- type : type des éléments stockés dans le tableau
- Bracket [] symbole indiquant que les éléments vont être stockés dans un tableau

Fichier **[Exemple1.java](src/main/java/Exemple1.java)**

```java
public class Exemple1 {
    public static void main(String[] args) {
        // Tableau d'entiers
        int[] arrayOfInt;
        // Tableau de float
        float distances[];
        // Tableau de double
        double[] values;
        // tableau de chaines de caractéres
        String[] name;
    }
}
```

## Instanciation
Pour instancier un tableau, il est nécessaire d'utiliser le mot clé **new** suivi du type et entre crochets, il faut préciser la taille du tableau.


Fichier **[Exemple2.java](src/main/java/Exemple2.java)**

```java
public class Exemple2 {

    public static void main(String[] args) {
        // Tableau d'entiers
        int[] arrayOfInt = new int[10];
        // Tableau de float
        float distances[] = new float[5];
        // Initialisation directe avec valeur
        double[] values = {1.0, 2, 3.0};
        // tableau de chaines de caractéres
        String[] name;
        name = new String[5];
    }
}
```

Lors de l'initiation, chaque cellule du tableau sera initialisé par la valeur par défaut associée au type.
- numerique (primitive) = 0
- boolean = false
- les objets = null 

### Initialisation des cellules
Pour accéder au cellule du tableau, on utilise les crochets en spécifiant l'index.

Dans le cas où on fait suite du symbole **=**, on va procéder à l'initialisation de la cellule par la valeur se trouvant à droite de ce symbole.

Dans le cas où il n'y a pas de symbole **=**, on récupére la valeur présent dans la céllule.

Fichier **[Exemple3.java](src/main/java/Exemple3.java)**

```java
public class Exemple3 {
    public static void main(String[] args) {
        int[] arrayOfInt = new int[5];
        arrayOfInt[0] = 10;
        arrayOfInt[1] = 20;
        arrayOfInt[3] = 40;
        arrayOfInt[4] = 50;
        arrayOfInt[2] = 30;
        System.out.format("Valeur à l'index 3 : %d", arrayOfInt[3]);
    }
}

```

```
Valeur à l'index 3 : 40
```

## Parcourir un tableau
