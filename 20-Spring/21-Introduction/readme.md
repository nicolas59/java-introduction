# Introduction

## Spring

Développé depuis plus de 10 ans, [Spring](https://spring.io/why-spring) est le framework le plus connu dans le développement d'applications d'entreprise du monde Java.

Historiquement, et ce qui est encore le coeur du framework, est l'implémentation du design pattern **Inversion Of Control** ou en francais, **Injection de dépendances**

Ce design pattern a pour but de déléguer l'instanciation des classes de services au framework Spring. 
Ainsi, ce n'est plus vous qui créez les instances des classes par le mot clé **new**. Votre rôle consistera à créer les classes de services, à indiquer les relations entre elles (association). Le framework Spring s'occupera de créer les instances et d'injecter automatiquement les instances nécessaires à vos objects.Tel un maitre d'orchestre, il donnera vie à votre programme.

A partir de ce principe, tout un ecosystéme est disponible et permet de couvrir quasiment tout le périmétre nécessaire au developpement.
Cet ecosysteme est matérialisé par un nombre important de librairies. 

Par exemple : 
- Spring MVC pour le developpement d'applications Web
- Spring Security pour la sécurisation
- Spring Data pour faciliter l'accés aux données
- Spring Batch pour le developpement Batch
- Spring Intégration pour gérer les patterns d'entreprises tel que l'Event Driven Architecture
- ...


## Spring Boot

Le developpement d'applications d'entreprise nécessitant le plus souvent l'utilisation combinée de plusieurs librairies **Spring**. 
Comment garantir que la version des librairies peuvent fonctionner correctement ? Comment permettre une configuration facile de celles-ci ?

[Spring Boot](https://spring.io/projects/spring-boot) a été conçu dés 2014 pour répondre à ces problématiques.

Il permet ainsi :
- de garantir une compatibilité entre les versions des librairies
- de fournir un mécanisme de configuration facilement la paramétrage
- de permettre le developpement d'applications dites **standalone**. L'application Java développée a ainsi tous les élements pour fonctionner de manière autonome.


## Spring Initializr

[Spring Initializr](https://start.spring.io/) est un service internet permettant de selectionner vos besoins et de générer automatiquement un projet Java prêt à développer.

![alt initializr](./assets/initializr.png "initializr")

> Spring Initializr est directement intégré dans la version Intellij Ultimate