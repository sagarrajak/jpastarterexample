CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
-- Table to simulate sequence behavior
CREATE TABLE IF NOT EXISTS products_seq (
     next_val BIGINT NOT NULL
);

-- Initial value for the sequence
INSERT INTO products_seq (next_val) VALUES (1);

CREATE TABLE IF NOT EXISTS employee (
      id VARCHAR(50) NOT NULL,
      name VARCHAR(255),
      salery DOUBLE,
      PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS employee_sequence (
    sequence_name VARCHAR(255) NOT NULL,
    next_val BIGINT NOT NULL,
    PRIMARY KEY (sequence_name)
);

# -- Initialize the sequence with the starting value
# INSERT INTO employee_sequence (sequence_name, next_val) VALUES ('employee_sequence', 1);
#

CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);