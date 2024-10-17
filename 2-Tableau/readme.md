# Les tableaux

-----

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
mvn --quiet compile exec:java -Dexec.mainClass=Exemple3
Valeur à l'index 3 : 40
```

## Parcourir un tableau

### for c-like

Le mot clé for en prenant 3 instructions permet de parcouir le tableau en exploitant la taille du tableau.

Fichier **[Exemple4.java](src/main/java/Exemple4.java)**

```java
public class Exemple4 {

    public static void main(String[] args) {
        String[] languages  =  {"Java", "Python", "Rust", "C++"};
        for(int index = 0; index < languages.length; index++){
            System.out.printf("Langage à l'index %d : %s \n", index, languages[index]);
        }
    }
}

```

```sh
mvn --quiet compile exec:java -Dexec.mainClass=Exemple4
Langage à l'index 0 : Java 
Langage à l'index 1 : Python 
Langage à l'index 2 : Rust 
Langage à l'index 3 : C++ 
```

### for each

Depuis Java 5, il est possible de parcourir des élements "itérables" avec le for.

La syntaxe est la suivante :

```
for(<type> variable : elementsIterable)
```

Fichier **[Exemple5.java](src/main/java/Exemple5.java)**

```java
public class Exemple5 {

    public static void main(String[] args) {
        String[] languages  =  {"Java", "Python", "Rust", "C++"};
        for(String language:languages){
            System.out.printf("Langage : %s \n", language);
        }
    }
}
```

```sh
mvn --quiet compile exec:java -Dexec.mainClass=Exemple5
Langage : Java 
Langage : Python 
Langage : Rust 
Langage : C++ 
```

## La classe *java.utils.Arrays*

La classe [java.utils.Arrays](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html) contient un ensemble de méthodes statiques pour manipuler des tableaux.

### La méthode toString ###
Cette méthode permet d'afficher le contenu d'un tableau de manière lisible. Cette méthode va parcourir chaque élement et invoquer la méthode **String.valueOf** sur cet élement.

```java
import java.util.Arrays;

public class Exemple6 {
    public static void main(String[] args) {
        Object[] items = {1, 2, "EPSI", Math.PI, 7.8, null};
        System.out.println(Arrays.toString(items));
    }
}
```

```sh
mvn --quiet compile exec:java -Dexec.mainClass=Exemple6
[1, 2, EPSI, 3.141592653589793, 7.8, null]
```

## Les méthodes sort

Les méthodes **sort** permettent de trier les élements du tableau. 
> Attention : le tableau est directement modifié.

```java
import java.util.Arrays;

public class Exemple7 {
    public static void main(String[] args) {
        double[] notes = {4, 18, 12.5, 20, 15};
        Arrays.sort(notes);
        System.out.println(Arrays.toString(notes));
    }
}
```

```
mvn --quiet compile exec:java -Dexec.mainClass=Exemple7
[4.0, 12.5, 15.0, 18.0, 20.0]
```

Il est également possible de trier les élements en passant en 2 eme paramétre un implementation de l'interface **Comparator**.

```java
import java.util.Arrays;

public class Exemple8 {
    public static void main(String[] args) {
        String[] languages  =  {"Java", "Python", "Rust", "C++"};
        Arrays.sort(languages, (a,b) -> a.length() - b.length()); //Comparator.comparing(String::length)
        System.out.println(Arrays.toString(languages));
    }
}
```

```
mvn --quiet compile exec:java -Dexec.mainClass=Exemple8
[C++, Java, Rust, Python]
```