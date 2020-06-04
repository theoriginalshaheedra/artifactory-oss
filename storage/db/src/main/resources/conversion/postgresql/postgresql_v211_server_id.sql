ALTER TABLE artifactory_servers ALTER COLUMN server_id TYPE varchar(128);

CREATE TABLE UI_SESSION (
	SESSION_ID CHAR(36),
	CREATION_TIME BIGINT NOT NULL,
	LAST_ACCESS_TIME BIGINT NOT NULL,
	MAX_INACTIVE_INTERVAL INT NOT NULL,
	PRINCIPAL_NAME VARCHAR(100),
	CONSTRAINT UI_SESSION_PK PRIMARY KEY (SESSION_ID)
);

CREATE INDEX UI_SESSION_IX1 ON UI_SESSION (LAST_ACCESS_TIME);

CREATE TABLE UI_SESSION_ATTRIBUTES (
	SESSION_ID CHAR(36),
	ATTRIBUTE_NAME VARCHAR(200),
	ATTRIBUTE_BYTES BYTEA,
	CONSTRAINT UI_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_ID, ATTRIBUTE_NAME),
	CONSTRAINT UI_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_ID) REFERENCES UI_SESSION(SESSION_ID) ON DELETE CASCADE
);

CREATE INDEX UI_SESSION_ATTRIBUTES_IX1 ON UI_SESSION_ATTRIBUTES (SESSION_ID);