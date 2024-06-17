FROM quay.io/keycloak/keycloak:latest
COPY ../../../../docs/keycloak/realm-export.json /opt/keycloak/data/import/
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start-dev", "--import-realm"]