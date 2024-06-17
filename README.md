# Medical Care Service v 0.0.1
## How To Test Locally
1. Build project with gradle using "./gradlew build" command
2. Run "docker-compose up" in /deploy/docker/env/dev.
3. Navigate to localhost:8080/auth with admin:admin credentials to login to keycloak as admin.
4. Create user and set password in "medical-care" realm. Create 2 users: one in group Patient.Read and with roles mapping Patient, another with group Patient.Write, Patient.Read, Patient.Delete and role-mapping Practitioner.
5. Use postman collection to test API in /docs/postman. Don't forget to get token with "Token" request and past into collection authorization bearer token. Update collection variables :current_user" and "current_password" with needed user credentials. Set "test-uuid" UUID for patient you want to test against.

**Note**: if docker "medical-care-service" fails because keycloak not started yet, change healthcheck config according to your machine power and restart all services in docker compose.