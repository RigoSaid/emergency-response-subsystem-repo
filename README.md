# Système d'intervention d'urgence
Ce projetreprésent une base pour le  dévelopement d'un proof of concept du Système d'intervention d'urgence en temps réel.
# Technologie 
Spring boot / Cradle/ Docker / Jenkins
# How to run 
# L'application spring boot
La commande -> gradle assemble docker docker
> Après excution de cette commande on peut avoir accès sur -> localhost:8083
# Le serveur Jenkins CI/DI
Deployé localement via Docker
> docker container run -d -p 8082:8080  -v jenkinsvol1:/var/jenkins_home --name jenkinslocal jenkins/jenkins:lts
  




