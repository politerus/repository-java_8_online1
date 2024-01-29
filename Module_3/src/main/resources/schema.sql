CREATE DATABASE Students;

USE Students;

CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255)
);

CREATE TABLE accounts (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255),
                          balance DOUBLE,
                          user_id BIGINT,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE categories (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255),
                            type VARCHAR(255)
);

CREATE TABLE transactions (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              amount DOUBLE,
                              date DATE,
                              account_id BIGINT,
                              category_id BIGINT,
                              FOREIGN KEY (account_id) REFERENCES accounts(id),
                              FOREIGN KEY (category_id) REFERENCES categories(id)
);
