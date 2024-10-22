# Les enum

Les énumerations sont une nouveau type apparu depuis Java 5. 
Elles permettent de representer une liste fini d'élements.

## Les caractèristiques
Les énum peuvent être déclarées à l'intérieur ou à l'extérieur des classes. Elle est définie par le mot clé **enum**. 

Une énumération contient une liste de valeurs figées lors de la compilation. Chaque valeur représent une instance de l'énum.

Une énumération ne peut être altérée lors de l'execution. Elle est implicitement **static** et **final**.

Resemblant à une classe, les contructeurs présents à l'intérieur de l'énumeration ne sont pas accéssible depuis l'extérieur. 
Uniquement les valeurs définies dans l'énumeration pourront accéder aux divers constructeurs.

Une énumaration est **immutable**

## Déclaration

Fichier [Saison](src/main/java/Saison.java)

```java
public enum Saison {
    PRINTEMPS,    // represente les différents valeurs de l'énum Saison
    ETE,
    AUTOMNE,
    HIVER
}
```

Les énurations posséde la méthode **values()** permettant de récupérer un tableau des valeurs constituant l'enumération.

Les valeurs de l'énumeration sont des constantes pointant chacune vers un emplacement mémoire spécifique qui ne changera pas pendant l"execution. Ainsi, on peut comparer les énumerations directement avec le comparateur **==**

Fichier [Exemple1](src/main/java/Exemple1.java)

```java
public class Exemple1 {
    public static void main(String[] args) {
        var saisons = Saison.values();
        for (Saison s : saisons) {
            System.out.println(s);
        }

        var saison = Saison.AUTOMNE; //resolution pqr une valeur de l'énumération

        var automne = Saison.valueOf("AUTOMNE"); // résolution par le nom

        if(saison == Saison.AUTOMNE) {
            System.out.println("C'est bien l'automne");
        }
    }
}

```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Exemple1
PRINTEMPS
ETE
AUTOMNE
HIVER
C'est bien l'automne
```

## Personnalisation d'une enum

Une énumération peut avoir des propriétés

L’initialisation des propriétés est réalisée via un constructeur

Afin de respecter le principe de l’énum, ces propriétés :
* ne doivent pas être modifiable
* Accessible qu’en lecture

Un constructeur n’est utilisable qu’à l’intérieur de l’enum.

Fichier [Exemple2](src/main/java/Exemple2.java)

```java
public class Exemple2{

    enum ColorPanel {
        RED("#FF0000"), GREEN("#FF0000"),
        LIGHT_GREEN("#90EE90"), BLUE("#0000FF");
        private final String hexaCode;

        ColorPanel(String hexaCode) {
            this.hexaCode = hexaCode;
        }
        /**
         * @return the hexaCode
         */
        public String getHexaCode() {
            return hexaCode;
        }

        @Override
        public String toString() {
            return super.toString() + "["+ hexaCode + "]";
        }
    }

    public static void main(String[] args) {
        ColorPanel c = ColorPanel.BLUE;
        System.out.println(c.getHexaCode());
        System.out.println(c);
    }
    
}
```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Exemple2
#0000FF
BLUE[#0000FF]
```

## Utilisation du switch case

Les énumérations peuvent être utilisées avec le classique swicth case.

Fichier [Exemple3](src/main/java/Exemple3.java)

```java
public class Exemple3 {

    public static void main(String[] args) {
        var saison = Saison.ETE;

        switch (saison) {
            case AUTOMNE:
                System.out.println("C'est l'automne");
                break;
            case HIVER:
                System.out.println("C'est hivers");
                break;
            case PRINTEMPS:
                System.out.println("C'est le printemps");
                break;
            case ETE:
                System.out.println("C'est l'été");
                break;
        }
    }
}

```

```shell
mvn --quiet compile exec:java -Dexec.mainClass=Exemple3
C'est l'été
```
