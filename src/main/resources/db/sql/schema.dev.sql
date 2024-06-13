CREATE TABLE IF NOT EXISTS patient
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(255),
    gender     VARCHAR(255),
    birth_date TIMESTAMP
);