CREATE TABLE seller
(
  id    BIGSERIAL PRIMARY KEY,
  phone VARCHAR(18)
);

CREATE TABLE product
(
  id        BIGSERIAL PRIMARY KEY,
  price     INTEGER,
  model     varchar(255),
  seller_id BIGINT,
  FOREIGN KEY (seller_id) REFERENCES seller (id)
);