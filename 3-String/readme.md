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


## Concaténation