# Introduction

-----

## Helloworld

Pour démarrer l'apprentissage d'un programme rien de tel que l'écriture du fameux HelloWorld.

Fichier **[Helloworld.java](src/main/java/Helloworld.java)**

```java
public class Helloworld {

    /**
     * point d'entrée des programmes java. Il est nécessa&ire de respecter excatement la signature
     * de cette méthode afin que le programme puisse s'exécuter.
     *
     * @param args tableau d'arguments passés lors du lancement du programme
     */
    public static void main(String[] args) {
        System.out.println("Hello world !");
    }
}
```

Pour compiler le programme, il est nécessaire de se positionner dans le repertoire **src**

```sh
cd src/main/java
javac Helloworld.java
java Helloworld
```

> En java, toute ligne d'instruction est terminée par une **virgule**

### Déclaration d'une variable

Pour utiliser des variables, il est nécéssaire de la déclarer et de leur assigner une valeur. 
Lors de la déclaration, on definit le type de la variable (primitif, classe, enum) suivi du nom de la variable.

Fichier **[Variables1.java](src/main/java/Variables1.java)**

```java
public class Variables1 {

    public static void main(String[] args) {
        /**
         * Declaration  et assignaement d'une variable
         */
        int magicNumber = 62;

        /**
         * Une chaine de caractères peut être concaténée à tout type d'élements
         */
        System.out.println("Le nombre magique est " + magicNumber);

        /*
         * L'utilisation de la méthode printf permet d'écrire des chaines de caractères
         * en formattant la chaine de chaine de caratères.
         */
        System.out.printf("Le nombre magique est %d", magicNumber);
    }
}
```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Variables1
Le nombre magique est 62
Le nombre magique est 62
````

Il est tout à fait possible de déclarer puis par la suite assigner une valeur à cette variable.

Fichier **[Variables2.java](src/main/java/Variables2.java)**


```java
public class Variables2 {

    public static void main(String[] args) {
        /**
         * Declaration puis assignement
         */
        String name;
        name = "Java";
        System.out.printf("Un langage toujours au top : %s", name);
    }
}
```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Variables2
Un langage toujours au top : Java
````

> tant qu'une variable, déclarée dans le corps d'une méthode, n'est pas assignée à une valeur, elle ne peut pas être utilisée.

```java
public class Variables3 {

    public static void main(String[] args) {
        /**
         * Declaration sans assignement
         */
        int ageDuCapitaine;
        System.out.printf("L'age du capitaine est %d", ageDuCapitaine);
    }
}
```

Fichier **[Variables3.java](src/main/java/Variables3.java)**


```sh
javac Variables3.java
Variables3.java:8: error: variable ageDuCapitaine might not have been initialized
        System.out.printf("L'age du capitaine est %d", ageDuCapitaine);
```

### Et si on parlait de *null*

Une variable peut : 
- ne pas être définie. 
- être associée à une valeur numerique, booleen, chaine de caractères, enumération, objet.
- être associée à **null**

**null** représente l'absence de valeur. il n'est ni un objet, ni un type. Il répresente une valeur spéciale.
Une variable associée à **null** mal utilisée peut entrainer l'exception **NullPointerException**.

**null** ne peut pas être assigné à une primitive


### Les primitives 

Java n'est pas un lanqage purement objet. 8 primitives sont mises à disposition au déceloppeur.

| Catégorie | Type      | Taille         | Signé    | Min                     | Max                                  
|-----------|-----------|----------------|----------|-------------------------|--------------------------------------
|           | byte      | 2<sup>8</sup>  | signed   | -128                    | 127                                  
|           | char      | 2<sup>16</sup> | unsigned | 0                       | 2<sup>16</sup>-1                     
| Entier    | short     | 2<sup>16</sup> | signed   | -2<sup>15</sup>         | 2<sup>15</sup>-1                     
|           | int       | 2<sup>32</sup> | signed   | 2<sup>2</sup>           | 2<sup>31</sup>-1                     
|           | long      | 2<sup>64</sup> | signed   | -2<sup>63</sup>         | 2<sup>63</sup>-1                     
| Decimaux  | float     | 2<sup>32</sup> | signed   | -3.4 * 10<sup>38</sup>  | 3.4 * 10<sup>38</sup> 
|           | double    | 2<sup>64</sup> | signed   | -1.8 * 10<sup>308</sup> | 1.8 * 10<sup>308</sup> 
| Autre     | boolean   |                |          |                         |


### Le mot clé *var*
Depuis Java5, il est possible d'éviter de déclarer le type d'une variable grâce au mot clé **var**.
Dans ce cas, il est nécessaire d'assigner une valeur afin que le compilateur infère le type de la variable.

Fichier **Variable4.java**

```java
public class Variables4 {

    public static void main(String[] args) {
        var birthday = 1995;
        var author = "James Gosling";

        System.out.printf("birthday :  %s, author : %s\n",   ((Object)birthday).getClass().getName(), author.getClass().getName());

        var message = "Java est apparu en " + birthday + " et un des auteurs est "+ author;
        System.out.println(message);
    }
}

```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Variables4
birthday :  java.lang.Integer, author : java.lang.String
Java est apparu en 1995 et un des auteurs est James Gosling
```

## Loop et conditions

### if / else if / else

Le mot clé **if** permet d'éxécuter un bloc d'instructions si la condition est vraie.

Pour comparer des primitives, on peut utiliser une des comparateurs suivants : 

| Comparateur | Description         |
|-------------|---------------------|
| ==          | Egalité             |
| !=          | Différent           |
| <           | Plus petit          |
| <=          | Plus petit          |
| >           | Plus grand          |
| >=          | Plus grand  ou égal |

> Pour definir un bloc, on utilise les accolades { }

Fichier **[Condition1.java](src/main/java/Condition1.java)**

```java
public class Condition1 {

    public static void main(String[] args) {
        int age1 = 25;
        int age2 = 43;

        if(age1 < age2){
            System.out.printf("La variable age1 (%d) est à une valeur inférieure à la variable age2  (%d) ", age1, age2);
        }
    }
}
```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Condition1
La variable age1 (25) est à une valeur inférieure à la variable age2 
```


Le mot clé **else** permet d'exécuter le second bloc d'instructions dans le cas où la condition du **if** n'est pas réalisée.

Fichier **[Condition2.java](src/main/java/Condition2.java)**

```java
public class Condition2 {

    public static void main(String[] args) {
        int nombre = 19;
        if(nombre % 2 == 0){
            System.out.printf("Le nombre (%d) est un nombre pair ", nombre);
        }else{
            System.out.printf("Le nombre (%d) est un nombre impair ", nombre);
        }
    }
}

```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Condition2
Le nombre (19) est un nombre impair 
```

En utilisant **else if**, il est possible d'enchainer des tests conditionnels et associant un bloc d'instructions à chaque test. 
Dés qu'un test est vrai, le bloc d'instructions est executé. Les conditions suivantes seront ignorées.

Fichier **[Condition3.java](src/main/java/Condition3.java)**

```java

public class Condition3 {

    public static void main(String[] args) {
        int angle = 85;
        if(angle == 90) {
            System.out.println("Angle droit");
        }else if(angle == 0) {
            System.out.println("Angle plat");
        }else if(angle > 90) {
            System.out.println("Angle obtus");
        }else {
            System.out.println("Angle aigu");
        }
    }
}
```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Condition3
Angle aigu
```

> dans le cas d'une succession de **else if**, le mot clé seul **else** sera toujours à la fin de cette succession.

### for

Le mot clé **for** permet d'executer plusieurs fois un même bloc d'instructions. 

Fichier **[Looping1.java](src/main/java/Looping1.java)**

```java
public class Looping1 {

    public static void main(String[] args) {
        for(int index=0; index<5; index++){
            System.out.printf("Hello %d ! \n", index);
        }
    }
}

```
Le bloc de code contenant l'instruction `System.out.printf("Hello %d ! \n", index);` est executé 5 fois (index pouvant varié de 0 à 4)

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Looping1
Hello 0 ! 
Hello 1 ! 
Hello 2 ! 
Hello 3 ! 
Hello 4 ! 
```

Si on decompose les parties de **for**

| statement    | description                                                                                                                                                                                                                        |
|--------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| int index= 0 | bloc de déclaration. La variable **index** est déclarée et sa valeur est initialisée à **0**                                                                                                                                       |
| index<5      | bloc d'évaluation. A chaque itération, la condition est évaluée et tant qu'elle est vraie, le bloc d'instructions sera évalué                                                                                                      |
| index++      | bloc d'instruction. A chaque itération, les instructions dans cette partie sont évaluées. C'est ici que l'on trouve le plus souvent une incrementation. Ici, à chaque passage la valeur de la variable **index** s'incrémente de 1 |


> on utilise la boucle **for** lorsque l'on peut déterminer à l'avance le nombre d'itérations. 

### L'operateur ternaire ?

Il est possible d'évaluer sur une meme ligne et d'assigner une valeur spécifique en fonction de la réalisation d'une condition.
On utilise l'operateur ternaire **?**

Voici un exemple long avec le mot clé **if**

Fichier **[Looping2.java](src/main/java/Looping2.java)**

```java
public class Looping2 {

    public static void main(String[] args) {
        for(int nombre=0; nombre<5; nombre++){
            if(nombre % 2 == 0){
                System.out.printf("Le nombre %d est un nombre pair.\n", nombre);
            }else{
                System.out.printf("Le nombre %d est un nombre impair.\n", nombre);
            }
        }
    }
}

```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Looping2
Le nombre 0 est un nombre pair.
Le nombre 1 est un nombre impair.
Le nombre 2 est un nombre pair.
Le nombre 3 est un nombre impair.
Le nombre 4 est un nombre pair.
```

il est possible d'utiliser l'operateur ternaire à la place du mot clé **if**

Fichier **[Looping3.java](src/main/java/Looping3.java)**

```java
public class Looping3 {

    public static void main(String[] args) {
        for(int nombre=0; nombre<5; nombre++){
            var type = nombre % 2 == 0 ? "pair": "impair";
            System.out.printf("Le nombre %d est un nombre %s.\n", nombre, type);
        }
    }
}

```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Looping3
Le nombre 0 est un nombre pair.
Le nombre 1 est un nombre impair.
Le nombre 2 est un nombre pair.
Le nombre 3 est un nombre impair.
Le nombre 4 est un nombre pair.
```

### While

Le mot clé **while** permet d'itérer tant que la condition associée au **while** est vérifiée.
while est souvent utilisé lorsque le nombre d'itérations ne peut être déterminé.

Fichier **[Looping4.java](src/main/java/Looping4.java)**

```java
public class Looping4 {

    public static void main(String[] args) {
        var total = 0;
        var inc = new SecureRandom().nextInt(10);
        while(total<20){
            total += inc;
        }
        System.out.printf("Inc : %d, Total : %d", inc, total);
    }
}
```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Looping4
Inc : 6, Total : 24
```

> il éxiste également l'instruction **do ...while()**. Le bloc d'instructions sera toujours évalué **au moins une fois**


## Les méthodes

Une méthode est une fonction réalisation un traitement spécifique. 

Une méthode : 
- porte un nom
- prend 0 à n arguments
- peut retourner une valeur.
- posséde des accolades. Les accolades vont introuduire le bloc d'instructions qui sera évalué lors de l'appel de la méthode.
- est déclarée à l'intérieur d'une classe.

Il existe 2 types de méthodes : 
- **les méthodes de classe** Ces méthodes, en fonction de leur portée, peuvent être appelé n'importe où dans le code en utilisant directement la classe.
- **les méthodes d'instance**. Ces méthodes manipules les propriétés d'un objet et altére le comportement de ce dernier. Ces méthodes ne peuvent pas être appelée à partir du nom de la classe.

> Depuis **Java 23**, il est possible de créer la méthode **main** en dehors d'une classe. [JEP - 477](https://openjdk.org/jeps/477)

Squelette d'une méthode : 

```
<scope> (static) <return type> methodName(<parameters>…) {
 ....
}
```

### Les méthodes de classe

Le mot clé **static** permet de definir une mathode de classe.

Une méthode peut ne rien retourner. Dans ce cas, on utilisera le mot clé **void**

Fichier **[Methode1.java](src/main/java/Methode1.java)**

```java

public class Methode1 {

    public static void displayHello(String name){
        System.out.println("Hello " + name  + " !");;
    }

    public static void main(String[] args) {
        displayHello("Bob");
    }
}

```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Methode1
Hello Bob !
```

Elle peut également retourner une donnée. Danc il faut indiquer dans la signature le type (primitif ou classe) que va retourner la méthode

Fichier **[Methode2.java](src/main/java/Methode2.java)**

```java
public class Methode2 {

    public static int sum(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        System.out.printf("Somme 10 + 7 : %d", sum(10, 17));
    }
}
```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Methode2
Somme 10 + 7 : 27
```

Depuis Java5, il est possible de déclarer un nombre infini de paramétre. On parle alors de **vararg**
Un seul vararg est autorisé par méthode et il doit être le dernier paramétre. 

Pour introduire un paramétre **vararg**, il suffit d'ajouter ***...*** apr&s le type du paramatré suivi du nom de celui ci.
Le paramétre sera considéré comme un tableau.

Fichier **[Methode3.java](src/main/java/Methode3.java)**

```java
public class Methode3 {

    public static int substract(int... numbers){
        int ret = 0;
        for(var number: numbers){
            ret -= number;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.printf("Sousoutraction : %d\n", substract(1,3,4,5));
        System.out.printf("Sousoutraction : %d", substract(9, 8));
    }
}

```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Methode3
Sousoutraction : -13
Sousoutraction : -17
```

> Les exemples ci-dessus utilisent la notion de vararg. En effet, la méthode **System.out.printf** est uné méthode avec un vararg.
> Le premier paramétre est la chaine de caractéres, suivi de plusieurs paramétres qui seront utilisés pour remplacer les élements introduits par **%**.