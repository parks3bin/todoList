CREATE TABLE IF NOT EXISTS TODO (
    ID bigint NOT NULL AUTO_INCREMENT,
    TITLE varchar(100) NOT NULL,
    TODO_ORDER int NOT NULL,
    COMPLETED bit NOT NULL,
    PRIMARY KEY (ID)
);