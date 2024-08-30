CREATE TABLE usr_user(
    usr_id UUID PRIMARY KEY DEFAULT GET_RANDOM_UUID(), 
    usr_username TEXT,
    usr_password TEXT
);

CREATE TABLE pst_post(
    pst_id UUID PRIMARY KEY DEFAULT GET_RANDOM_UUID(),
    usr_id INTEGER REFERENCES usr_user(usr_id),
    pst_title TEXT,
    pst_text TEXT
);

CREATE TABLE cmt_comment(
    cmt_id UUID PRIMARY KEY DEFAULT GET_RANDOM_UUID(),
    usr_id INTEGER REFERENCES usr_user(usr_id),
    pst_id INTEGER REFERENCES pst_post(pst_id),
    cmt_text TEXT
);

