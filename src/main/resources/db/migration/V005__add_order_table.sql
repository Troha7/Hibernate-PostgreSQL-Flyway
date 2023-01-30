-- Creating a table
CREATE TABLE IF NOT EXISTS my_store.order
(
    id              SERIAL CONSTRAINT order_id_pkey PRIMARY KEY,
    fk_client_id    INTEGER CONSTRAINT client_id_fkey
                    REFERENCES my_store.client (id) ON DELETE CASCADE
);