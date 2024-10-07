# Les chaînes de caractères

## Représentation

En java, la représentation une chaîne de caractères s'effectue par les guillemets.

2 manières d'utilisation : 
- sur une ligne avec le guillemet simple
- sur plusieurs lignes avec l'utilisation de 3 guillemets.

Fichier **[Exemple1.java](src/main/java/Exemple1.java)**

```Java
public class Exemple1 {

    public static void main(String[] args) {
        var phrase = "une phrase sur une ligne";

        var paragraphe = """
                Java a été conçu pour être facile à apprendre et à utiliser efficacement pour les 
                programmeurs professionnels. 
                Il est basé sur C++, ce qui permet de tirer parti de vos connaissances existantes, 
                mais il élimine de nombreuses sources de complexité et de problèmes propres à C++.
                """;
    }
}

```

Au niveau programmatique, une chaîne de caractères **n'est pas une primitive** mais **un objet de type java.lang.String**.

Fichier **[Exemple2.java](src/main/java/Exemple2.java)**

```java
public class Exemple2 {

    public static void main(String[] args) {
        var phrase = "une phrase sur une ligne";

        System.out.println("Type de la variable phrase :  " + phrase.getClass());
    }
}

```

```shell
Type de la variable phrase :  class java.lang.String
```

## La classe String 

La classe String possede de nombreuses méthodes permettant de manipuler la chaine de caractères ([docummentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html)).

| Méthode                                             | Description
|-----------------------------------------------------|--------------------------------------------
| int length()                                        | Retourne le nombre de caractères
| char charAt(int index)                              | Retourne le caractère à la position « index »
| String substring(int beginIndex)                    |  Permet d’extraire une partie de la chaine de caractères
| String substring(int beginIndex, int endIndex)      | Permet d’extraire une partie de la chaine de caractères
| String concat(String str)                           | Permet de concaténer une chaine de caractère
| String replace(char oldChar, char newChar)          | Permet de remplacer un caractère dans la chaine de caractères
| String replaceAll(String regex, String replacement) | Permet de remplacer la partie de chaine de caractères vérifiant l’expression régulière
| String trim()                                       |  Permet de supprimer les espaces en début et fin de chaine
| String toLowerCase()                                | Permet de mettre une chaine de caractères en minuscule
| String toUpperCase()                                |Permet de mettre une chaine de caractères en majuscule

Fichier **[Exemple3.java](src/main/java/Exemple3.java)**

```java
public class Exemple3 {

    public static void main(String[] args) {
        String string = "Java c'est plutôt sympa";
        System.out.println(string.length());

        String[] words = string.split(" ");
        System.out.println(Arrays.toString(words));

        String replaceWord = string.replace("Java", "JavaScript");
        System.out.println(replaceWord);

        String extractWord = string.substring(18);
        System.out.println(extractWord);

        String upper = string.toUpperCase();
        System.out.println(upper);
    }
}
```

```shell
23
[Java, c'est, plutôt, sympa]
JavaScript c'est plutôt sympa
sympa
JAVA C'EST PLUTÔT SYMPA
```

## Manipulation des caractères

Une chaine de caractères, bien que representée en interne par un tableau de caractères, n'est pas un tableau de caractères.

Pour manipuler caractère par caractère, les méthodes **charAt**, **toCharArray**, **chars**  permettent de manipuler caractère par caractère

Fichier **[Exemple4.java](src/main/java/Exemple4.java)**


````java
public class Exemple4 {

    public static void main(String[] args) {
        var phrase = "parcourons les caractères";
        for(int index=0;index<phrase.length();index++){
            System.out.printf("%c ", phrase.charAt(index));
        }
        System.out.println("");
        var tableauChar = phrase.toCharArray();
        for(var car:tableauChar){
            System.out.printf("%c ", car);
        }
        System.out.println("");
        phrase.chars().forEach(c ->  System.out.printf("%c ", c));
    }
}
````

````
p a r c o u r o n s   l e s   c a r a c t è r e s 
p a r c o u r o n s   l e s   c a r a c t è r e s 
p a r c o u r o n s   l e s   c a r a c t è r e s 
````

## L'immutabilité

Une chaine de caractères, une fois initialisée, ne peut plus être modifiée. 

Ainsi, les proprités internes de l'objet (de la chaine de caractères) ne sont pas altérables. 
les méthodes de ces types d'objet retourne le plus souvent une nouvelle objet de la même classe.

On parle alors d'**immutabilité**. C'est le cas de la classe **String**

Fichier **[Exemple5.java](src/main/java/Exemple5.java)**

```java
public class Exemple5 {

    public static void main(String[] args) {
        String chaineEnMinuscules = "une chaine en minuscules.";

        String chaineEnMajuscules = chaineEnMinuscules.toUpperCase();

        System.out.println("Variable chaineEnMinuscules : " + chaineEnMinuscules );
        System.out.println("Variable chaineEnMajuscules : " + chaineEnMajuscules );
    }
}
```
```
Variable chaineEnMinuscules : une chaine en minuscules.
Variable chaineEnMajuscules : UNE CHAINE EN MINUSCULES.
```

> On constate qu'auncune modification n'a été apportée à la variable **chaineEnMinuscules**

## Comparaison

En java, il n'est pas possible de vérifier l'égalité d'un objet avec **==**. 
Une comparaison de valeur avec **==** n'est possible uniquement avec les primitives. 

> Pour des objets, l'utilisation de **==** est possible, mais dans ce cas on ne compare pas l'état (et le type) des objets mais uniquement leur adresses en mémoires.

Une chaine de caractères étant une instance de la classe **String** est un objet et donc si on souhaite vérifier l'égalité de 2 chaines de caractères, il faut utiliser la méthode **equals**.

Fichier **[Exemple6.java](src/main/java/Exemple6.java)**

```java
public class Exemple6 {

    public static void main(String[] args) {
        String chaine1= "2 chaines égales";
        String chaine2= "2 chaines égales";

        if(chaine1.equals(chaine2)){
            System.out.println("Les 2 chaines sont égales");
        }
    }
}
```

```
Les 2 chaines sont égales
```

> Attention, il se pourrait que vous constatiez que l'utilisation de l'égalité **==** fonctionne. 
> Son fonctionnement repose uniquement sur le fait que Java utilise un mécanisme de cache afin d'optimiser la création des chaines de caractéres. La modification du cache ou la manière dont est créée la chaine pourrait ne plus faire fonctionner l'égalité avec **==**

## Concaténation

En java, la concanténation de chaines s'effectue directement avec le symbole **+**
Il est possible de concaténer une chaine de caractères avec n'importe quel type (primitif, objet).

Fichier **[Exemple7.java](src/main/java/Exemple7.java)**

```java
public class Exemple7 {
    public static void main(String[] args) {
        int nb1 = 10;
        int nb2 = 89;
        String chaine = "La somme de " + nb1 + " et " + nb2 + "est égale à " + (nb1+nb2);
        System.out.println(chaine);
    }
}
```
```sh
La somme de 10 et 89est égale à 99
```

### Performance

La concaténation en Java en utilisant le symbole **+** n'est pas **performante**. 
En effet, lors la concaténation, 1 objet intermédiaire est créé en memoire afin de réaliser la nouelle chaine.

Pour optimiser le traitement, il est conseiller d'utiliser les classes : 
- **java.util.StringBuilder** , le plus utilisé et le plus performant
- **java.util.StringBuffer**  , plus lente que la première car elle peut être utilisée dans un contexte multi-threadé

Ces 2 classes possédent : 
- des méthodes **append** afin d'ajouter des élements à ajouter à la chaine finale.
- la méthode **toString** permettant de générer la chaine de caractéres

Fichier **[Exemple8.java](src/main/java/Exemple8.java)**

```java
import java.time.Duration;

public class Exemple8 {

    static String[] items = {"Une", "chaine", "de", "caracteres"};

    static int MAX_ITERATION = 100000;

    public static void calculateDuration(String type, Runnable execute) {
        long start = System.nanoTime();
        execute.run();
        long stop = System.nanoTime();

        var duration = Duration.ofNanos(stop).minus(Duration.ofNanos(start)).toString();
        System.out.println(type + " : " + duration);
    }


    public static void concateWithPlus() {
        String ret = "";
        for (int i = 0; i < MAX_ITERATION; i++) {
            for (var item : items) {
                ret += item + " ";
            }
        }
    }

    public static void concateWithStringBuilder() {
        StringBuilder buiilder = new StringBuilder();
        for (int i = 0; i < MAX_ITERATION; i++) {
            for (var item : items) {
                buiilder.append(item).append(" ");
            }
        }
        var ret = buiilder.toString();
    }

    public static void main(String[] args) {
        calculateDuration("StringBuilder : ", Exemple8::concateWithStringBuilder);
        calculateDuration("Concaténation classique : ", Exemple8::concateWithPlus);
    }
}

```

```
StringBuilder :  : PT0.019722319S
Concaténation classique :  : PT41.799873016S
```

On constate que la concanténation avec StringBuilder  est 2200 fois plus rapide que la concaténation traditionnelle.
