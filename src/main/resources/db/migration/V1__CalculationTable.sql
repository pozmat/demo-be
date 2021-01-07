CREATE TABLE calculation (
    userId VARCHAR(100) NOT NULL PRIMARY KEY,
    total INT NOT NULL,
    valuesX INT[] NOT NULL,
    result INT[] NOT NULL
);