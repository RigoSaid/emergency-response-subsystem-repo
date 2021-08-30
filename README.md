# emergency-response-subsystem-repo


Exécuter le PoC comme une spring-boot application sur docker. 

1- -> Gradle assemble docker dockerRun
Exécuter le serveur Jenkins avec la configuration des pipeline automatise les test et les build.

2-> docker container run -d -p 8082:8080 \
>     -v jenkinsvol1:/var/jenkins_home \
>     --name jenkinslocal \
>     jenkins/jenkins:lts
-> 

