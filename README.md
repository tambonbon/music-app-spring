# POSTGRESQL Set up
## Docker 
`docker create --name postgres-demo -e POSTGRES_PASSWORD=Welcome -p 5432:5432 postgres:11.5-alpine`

`docker start postgres-demo`

## Create database
`psql> create database music_app;`

`docker exec -it postgres-demo psql -d music_app -f create_tables.sql -U postgres`