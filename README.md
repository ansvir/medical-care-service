# Medical Care Service v 0.0.1
## About Project

## How To Test Locally

### I. Init PostgreSQL Docker database

Requires Docker installed on machine.

Use next commands to start and init MySql app database:
```shell
docker run -p 5432:5432 --name medical_care_db -e POSTGRES_PASSWORD=root -d postgres:latest
```

Docker container will start on 5432 port.

```shell
docker exec -it medical_care_db bash
```

PostgreSQL database container will be opened in bash

```shell
psql -U postgres
```

Then enter password:
```root```

```postgresql
CREATE DATABASE medical_care_db;
```

This will create empty database.

### II. App is ready to run.