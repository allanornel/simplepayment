CREATE TABLE Transactions(
     id BIGSERIAL PRIMARY KEY,
     amount DECIMAL(18, 2) NOT NULL,
     sender_id BIGINT NOT NULL REFERENCES Users(id),
     receiver_id BIGINT NOT NULL REFERENCES Users(id),
     timestamp TIMESTAMP NOT NULL
);