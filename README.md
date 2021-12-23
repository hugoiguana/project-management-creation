# project-management-creation

**Available end points:**

```javascript
Description: Login to the application.

curl --request POST \
  --url http://localhost:8080/login \
  --header 'Content-Type: application/json' \
  --data '{
	"email" : "admin@email.com",
    "password" : "1234"
}'
```



**Docker commands:**

> docker-compose up -d --build 


**Keycloak commands:**
```javascript
Add an admin user via keycloak script:
$ docker exec -it project-management-keycloak /opt/jboss/keycloak/bin/add-user-keycloak.sh -u admin -p admin
$ docker container restart project-management-keycloak
http://localhost:8085/auth/admin
```
