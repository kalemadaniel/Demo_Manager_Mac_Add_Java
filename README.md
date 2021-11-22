# Demo_Manager_Mac_Add_Java_Mysql
## Introduction 
Chaque appareil qui doit être intégré dans un réseau informatique a besoin d’un adaptateur réseau. Cet adaptateur reçoit du fabricant un numéro d’identification unique au monde, l’adresse MAC. Cela permet d’identifier des appareils dans le réseau et de les adresser selon les besoins. Cet élément est très capital dans la gestion de la base des données pour créer un filtre d'adresses MAC pour que les utilisateurs se voient accorder ou refuser l'accès aux données dans une base des données en fonction de l'adresse MAC du client qu'ils utilisent. Voici un exemple du filtre d’adresses mac fait en Java et MySQL pour illustrer l’idée ;

## Pré-requis

Les applications nécessaires pour contribuer au dévéloppement de ce projet :

- Netbeans (https://www.oracle.com/technetwork/java/javase/downloads/jdk-netbeans-jsp-3413139-esa.html)
- Xampp (https://www.apachefriends.org/fr/download.html)

## Installation

Les étapes pour installer le programme sont :

1. **Télécharger le dossier**
2. **Importer le projet**
3. **Changer les paramètres de connexion** 
4. **Executer le projet**

ET si vous souhaitez constituer un exécutable par la suite il faut faire le ``clean and build ``

## Comment ça marche ?

### Voici mes requêtes SQL 

Ensuite il faut creer la structure SQL qui correspond à notre projet java

```
CREATE OR REPLACE DATABASE bd_Adresse_Mac;
USE bd_Adresse_Mac;
CREATE TABLE tb_adresses_mac 
(
    id_adresse INT AUTO_INCREMENT PRIMARY KEY,
    desi_eqpmt VARCHAR(100),
    adress VARCHAR(17),
    statut VARCHAR(10)
);

```

### La solution interface graphique
Tu peux mettre à jour ta liste des adresses et en les désactivant si possible (ex : Quand l’utilisateur va en congé).

![img1](https://user-images.githubusercontent.com/51014164/142858217-07379e3e-645f-45e3-8939-316d2e5d903f.JPG)

Juste dans le bas j’ai mis une partie qui me permet de vérifier si mon équipement a bien accès à la base des données. Voici quelques exemples illustratifs.
Test 1
![img2](https://user-images.githubusercontent.com/51014164/142858291-282093a4-a3a9-4f02-829c-1e3755347cb7.JPG)

Test 2

![img3](https://user-images.githubusercontent.com/51014164/142858330-045fe90f-bc68-45f3-8039-b36e2821c02e.JPG)

## Pour les contributions

J’accorde aux utilisateurs les droits d'utiliser, d'étudier, de modifier et de distribuer le logiciel et son code source à quiconque et à n'importe quelle fin.

## Versions
Ceci correspond à un état donné de l'évolution du logiciel et j'utilise le versionnage. Ci dessous les versions produites

**Dernière version stable :** 1.0

## Auteurs
le(s) auteur(s) du projet est(sont) :
* **Kalema daniel jonathan** _alias_ [@kalemadaniel](https://github.com/kalemadaniel)

## License

Ce projet est sous licence **``open source``** 

