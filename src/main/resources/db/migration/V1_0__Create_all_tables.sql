CREATE TABLE IF NOT EXISTS Teams (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    name TEXT,
    country TEXT,
    created_at DATE,
    updated_at DATE
    );

CREATE TABLE IF NOT EXISTS Players (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    name TEXT,
    nickname TEXT,
    country TEXT,
    age INT,
    created_at DATE,
    updated_at DATE
    );
