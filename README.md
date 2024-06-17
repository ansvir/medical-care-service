# Medical Care Service v 0.0.1
## How To Test Locally
1. Run docker-compose up in /deploy/docker/env/dev.
2. Navigate to localhost:8080/auth with admin:admin credentials to login to keycloak as admin.
3. Create user and set password in "medical-care" realm. Create 2 users: one in group Patient.Read and with roles mapping Patient, another with group Patient.Write, Patient.Read, Patient.Delete and role-mapping Practitioner.
4. Use postman collection to test API in /docs/postman. Don't forget to get token with "Token" request and past into collection authorization bearer token. Update collection variables :current_user" and "current_password" with needed user credentials. Set "test-uuid" UUID for patient you want to test against.