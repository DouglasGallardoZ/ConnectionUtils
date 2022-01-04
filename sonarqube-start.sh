#!/bin/bash

mvn clean install sonar:sonar -Dsonar.projectKey=com.dgz:ConnectionUtils -Dsonar.host.url=http://localhost:9000 -Dsonar.login=07f39019cd67a50d450bc1d33b27c243b60dbcf7


