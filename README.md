# MiniProjet_SystemesReparties
Ce projet consiste à développer des serveurs et des clients en utilisant trois technologies de communication distribuée en Java : Java RMI, gRPC et les sockets. 
Rapport Comparatif : gRPC vs Java RMI vs Sockets pour un Service de Messagerie
Introduction
Dans le cadre de ce rapport, nous avons comparé trois technologies de communication pour la mise en œuvre d'un service de messagerie : gRPC, Java RMI et les sockets. Chaque technologie a été évaluée en fonction de critères tels que la facilité de développement, la performance, la complexité et la portabilité.

Observations et Conclusions
1. Facilité de Développement :
gRPC : Facile à utiliser grâce à la définition de protocoles RPC dans un fichier proto. Les outils de génération de code simplifient la création des classes Java nécessaires.
Java RMI : Relativement facile à mettre en œuvre pour les applications Java car il s'appuie sur le concept de méthodes distantes. Cependant, la configuration du serveur RMI peut être un peu complexe.
Sockets : La mise en œuvre basée sur les sockets nécessite une gestion manuelle des connexions et des flux de données, ce qui peut être plus complexe que les autres méthodes.
Conclusion : gRPC et Java RMI offrent une facilité de développement supérieure par rapport à l'utilisation directe des sockets.

2. Performance :
gRPC : Performant grâce à l'utilisation du protocole HTTP/2 qui prend en charge la multiplexation et la compression des données. Convient aux applications nécessitant des performances élevées.
Java RMI : Performant pour les communications au sein d'une JVM. Cependant, les performances peuvent être affectées lors de la communication entre des JVM distantes en raison du marshalling/demarshalling et des transferts de données.
Sockets : Offre un contrôle complet sur la communication réseau mais peut être moins performant en termes de gestion des connexions et de sérialisation des données.
Conclusion : gRPC offre généralement des performances supérieures en raison de son protocole optimisé.

3. Complexité :
gRPC : Facilite la gestion des communications grâce à la génération automatique de code et à la définition claire des protocoles. Cependant, la configuration du serveur peut être complexe.
Java RMI : Offre une abstraction plus élevée pour les appels de méthodes distantes, mais la configuration du registre RMI et des politiques de sécurité peut être complexe.
Sockets : Implique une gestion manuelle des connexions, des flux de données et de la sérialisation, ce qui peut être plus complexe que les autres méthodes.
Conclusion : gRPC et Java RMI sont plus simples à utiliser que les sockets en termes de gestion des communications.

4. Portabilité :
gRPC : Offre une bonne portabilité grâce à la prise en charge de plusieurs langages de programmation et de plates-formes.
Java RMI : Limité à l'écosystème Java, ce qui le rend moins portable que gRPC.
Sockets : Dépendant du langage et de la plate-forme, nécessitant souvent des adaptations pour différentes configurations.
Conclusion : gRPC est plus portable que Java RMI et les sockets en raison de son support multiplateforme.

Conclusion Générale
gRPC : Idéal pour les applications nécessitant des performances élevées, une facilité de développement et une portabilité.
Java RMI : Convient aux applications Java internes où la simplicité de l'intégration avec des objets distants est essentielle.
Sockets : Utilisés pour un contrôle fin de la communication réseau mais moins recommandés pour des applications de haut niveau en raison de leur complexité.
Le choix de la technologie dépendra des besoins spécifiques de l'application, des performances requises et de la familiarité de l'équipe de développement avec chaque technologie.


