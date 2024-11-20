DROP SCHEMA IF EXISTS "inventory" CASCADE;

CREATE SCHEMA "inventory";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--DROP TYPE IF EXISTS inventory_stock_status;
--CREATE TYPE inventory_stock_status AS ENUM (IN_STOCK, OUT_OF_STOCK, LOW_STOCK);

DROP TABLE IF EXISTS "inventory".inventories CASCADE;

CREATE TABLE "inventory".inventories
(
    id uuid NOT NULL,
    user_id uuid NOT NULL,
    product_id uuid NOT NULL,
    warehouse_id uuid NOT NULL,
    failure_messages character varying COLLATE pg_catalog."default",
    CONSTRAINT inventories_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "inventory".inventory_items CASCADE;

CREATE TABLE "inventory".inventory_items_location
(
    id bigint NOT NULL,
    inventory_id uuid NOT NULL,
    product_id uuid NOT NULL,
    warehouse_id uuid NOT NULL,
    quantity integer NOT NULL,
    CONSTRAINT inventory_items_pkey PRIMARY KEY (id, inventory_id)
);

ALTER TABLE "inventory".inventory_items_location
    ADD CONSTRAINT "FK_INVENTORY_ID" FOREIGN KEY (inventory_id)
        REFERENCES "inventory".inventories (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
    NOT VALID;