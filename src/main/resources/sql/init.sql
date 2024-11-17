CREATE TABLE customer
(
    id         BIGSERIAL    NOT NULL,
    name       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    phone      VARCHAR(255) NOT NULL,
    address    VARCHAR(255) NOT NULL,
    birth_date date         NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE account
(
    id             BIGSERIAL      NOT NULL,
    name           VARCHAR(255)   NOT NULL,
    account_number VARCHAR(255)   NOT NULL,
    balance        NUMERIC(19, 2) NOT NULL,
    customer_id    BIGINT         NOT NULL,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

ALTER TABLE account
    ADD CONSTRAINT FK_ACCOUNT_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE account
    ALTER COLUMN balance SET DEFAULT 0;

CREATE TABLE loan
(
    id                 BIGSERIAL      NOT NULL,
    amount             NUMERIC(19, 2) NOT NULL,
    interest_rate      NUMERIC(5, 2)  NOT NULL,
    outstanding_amount NUMERIC(19, 2) NOT NULL,
    customer_id        BIGINT         NOT NULL,
    CONSTRAINT pk_loan PRIMARY KEY (id)
);

ALTER TABLE loan ADD COLUMN description VARCHAR(255);

ALTER TABLE loan
    ADD CONSTRAINT FK_LOAN_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

CREATE TABLE transaction_entry
(
    id          BIGINT                                 NOT NULL,
    description VARCHAR(255)                           NOT NULL,
    amount      DECIMAL                                NOT NULL,
    rrn         VARCHAR(255)                           NOT NULL,
    timestamp   TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL,
    account_id  BIGINT                                 NOT NULL,
    customer_id BIGINT                                 NOT NULL,
    CONSTRAINT pk_transaction_entry PRIMARY KEY (id)
);

ALTER TABLE transaction_entry
    ADD CONSTRAINT FK_TRANSACTION_ENTRY_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES account (id);

ALTER TABLE transaction_entry
    ADD CONSTRAINT FK_TRANSACTION_ENTRY_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);


INSERT INTO customer (id, name, email, phone, address, birth_date)
VALUES (-1, 'Bariq Mbani', 'bariqmbani@hitachi-ch.co.id', '083829357213', 'Jl. Kebon Kacang III No. 84', '1997-01-02');

INSERT INTO account (id, name, account_number, balance, customer_id)
VALUES (-1, 'Rekening Belanja', '3719182891', 1438392, -1);

INSERT INTO account (id, name, account_number, balance, customer_id)
VALUES (-2, 'Rekening Pengeluaran', '3216386212', 2138584, -1);

INSERT INTO transaction_entry
    (id, description, amount, rrn, timestamp, account_id, customer_id)
VALUES (-1, 'Bayar Kos', 1000000, '00000001', current_timestamp, -2, -1);

INSERT INTO transaction_entry
    (id, description, amount, rrn, timestamp, account_id, customer_id)
VALUES (-2, 'Bayar Listrik', 50000, '00000002', current_timestamp, -2, -1);

INSERT INTO transaction_entry
(id, description, amount, rrn, timestamp, account_id, customer_id)
VALUES (-3, 'Beli Sampo', 25000, '00000003', current_timestamp, -1, -1);

INSERT INTO loan
    (id, amount, interest_rate, outstanding_amount, customer_id, description)
VALUES (-1, 1000000, 0.10, 1100000, -1, 'Pinjaman Keuangan');
