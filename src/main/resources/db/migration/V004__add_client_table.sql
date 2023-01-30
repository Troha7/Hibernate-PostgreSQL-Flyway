-- Creating a table
CREATE TABLE IF NOT EXISTS my_store.client
(
    id              SERIAL CONSTRAINT client_id_pkey PRIMARY KEY,
    fk_address_id   INTEGER CONSTRAINT address_id_fkey
                    REFERENCES my_store.address (id) ON DELETE CASCADE,
    name            TEXT NOT NULL,
    email           TEXT NOT NULL,
    phone           TEXT NOT NULL
);