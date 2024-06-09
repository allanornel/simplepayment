CREATE TABLE Users(
    id BIGSERIAL PRIMARY KEY UNIQUE,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    document TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    balance DECIMAL(18,2) NOT NULL,
    user_type TEXT NOT NULL
);