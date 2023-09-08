CREATE TABLE tb_user (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    ranking VARCHAR(255) NOT NULL
);

CREATE TABLE tb_form (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    ext_form_id VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    fill_time BIGINT NOT NULL,
    users_filled INTEGER[] NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

CREATE TABLE tb_response (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    form_id BIGINT NOT NULL,
    date TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user(id),
    FOREIGN KEY (form_id) REFERENCES tb_form(id)
);