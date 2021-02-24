CREATE TABLE albums
(
    album_id SERIAL PRIMARY KEY,
    name    varchar(20) NOT NULL,
    artist  varchar(20) NOT NULL,
    genre   varchar(20) NOT NULL
);

CREATE TABLE songs
(
    song_id SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL,
    duration TIME
);

CREATE TABLE albums_songs
(
    album_id integer NOT NULL REFERENCES albums (album_id),
    song_id integer NOT NULL REFERENCES songs (song_id)
);

