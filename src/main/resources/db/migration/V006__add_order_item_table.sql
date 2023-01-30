-- Creating a table
CREATE TABLE IF NOT EXISTS my_store.order_item
(
    id              SERIAL CONSTRAINT order_item_id_pkey PRIMARY KEY,
    fk_order_id     INTEGER CONSTRAINT order_id_fkey
                    REFERENCES my_store.order (id) ON DELETE CASCADE,
    fk_product_id   INTEGER CONSTRAINT product_id_fkey
                    REFERENCES my_store.product (id),
    count           INTEGER
);