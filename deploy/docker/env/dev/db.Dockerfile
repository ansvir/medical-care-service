FROM postgres:latest
COPY ../../../../src/main/resources/db/sql/schema.dev.sql /docker-entrypoint-initdb.d/schema.dev.sql