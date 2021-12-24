# project-management-creation

**Available end points:**

```javascript
# Login to the application:
curl --request POST \
  --url http://localhost:8080/login \
  --header 'Content-Type: application/json' \
  --data '{
	"email" : "admin@email.com",
    "password" : "1234"
}'

# All Projects:
curl --request GET \
  --url http://localhost:8080/projects \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJCUHJhMzkyUHdsMHotWElSV0RzcUN5MFRTUWJaNmhFbjhsRUZrZVY1YzhNIn0.eyJleHAiOjE2NDAyNjkyNzEsImlhdCI6MTY0MDI2ODk3MSwianRpIjoiY2Q1YjM5MmYtMjEzNC00NTJjLTk5MzItNDUxZGVkNGRhODMxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDg1L2F1dGgvcmVhbG1zL3Byb2plY3QtbWFuYWdlbWVudCIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJlMTBmMWUyOS0xZTg4LTQ3Y2QtOWU3Mi04MDEwZDA2YzFlNmIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwcm9qZWN0LW1hbmFnZW1lbnQtY3JlYXRpb24iLCJzZXNzaW9uX3N0YXRlIjoiNTI5N2NjNWItZmJhOC00NjYzLTg5MzEtZDU0ZDIzZjM2YjIwIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vbG9jYWxob3N0OjgwODAiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIlZJRVdFUiIsImRlZmF1bHQtcm9sZXMtcHJvamVjdC1tYW5hZ2VtZW50Iiwib2ZmbGluZV9hY2Nlc3MiLCJDUkVBVElPTiIsIkFETUlOIiwidW1hX2F1dGhvcml6YXRpb24iLCJBUFBST1ZFUiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6IjUyOTdjYzViLWZiYTgtNDY2My04OTMxLWQ1NGQyM2YzNmIyMCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Ikh1Z28gTW90YSIsInByZWZlcnJlZF91c2VybmFtZSI6Imh1Z28xIiwiZ2l2ZW5fbmFtZSI6Ikh1Z28iLCJmYW1pbHlfbmFtZSI6Ik1vdGEifQ.I9G1kIANnMgO6nxN4qhB4w9am211FAxKoyGUfEucJzZHy9FqWd-ntGYRSK2FH0Xf5y10sKWLilDkwRGxc9i7c4s3vwj-V5rEczHZYajx4H2OqGovz4C_scZUW-aBDk5-B_1jHcBb3XXU2kUxl1dJDP0zvaOpfvCJb_OuIOeR8o3XGKziXdfYAObfgnC8wjofRSlSx_Ti9TE8_1cSoGR3cS1fXuCBbNsiP67Q-jGOw89JElOFBLHfDq5itF1N1f04m63gQsF7bGjzclKoAUNi2a2C_yGlUifg2n-Wr4nBXoYhBMpqaDf-MvtqlAqnO9B0J4Su4bQAdJSfQ-zWnQXoYg' \
  --cookie JSESSIONID=10B338FEBBEFA3E2B8082B7F22CDFA36
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
