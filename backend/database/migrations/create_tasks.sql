DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
    id UUID NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    dueDate DATE,
    status VARCHAR(255) NOT NULL,
    priority VARCHAR(255) NOT NULL,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP NOT NULL
);