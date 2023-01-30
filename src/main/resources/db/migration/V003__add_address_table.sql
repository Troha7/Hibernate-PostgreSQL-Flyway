-- Creating a table
CREATE TABLE IF NOT EXISTS my_store.address
(
    id              SERIAL CONSTRAINT address_id_pkey PRIMARY KEY,
    country         TEXT NOT NULL,
    city            TEXT NOT NULL,
    street          TEXT NOT NULL,
    house           TEXT NOT NULL
);