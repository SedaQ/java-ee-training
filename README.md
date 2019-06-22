# java-ee-training
Java EE Training Based on Glassfish Server

## Authors

email | Name 
------------ | -------------
pavelseda@email.cz | Šeda Pavel

## Database migration
Prerequisities running PostgreSQL and created database named 'training' with schema 'public'.
To migrate database data it is necessary to run this command:

```
$ mvn flyway:migrate -Djdbc.url=jdbc:postgresql://{url to DB}/gopas-training -Djdbc.username={username in DB} -Djdbc.password={password to DB}
```
e.g.:
```
$ mvn flyway:migrate -Djdbc.url=jdbc:postgresql://localhost:5432/gopas-training -Djdbc.username=postgres -Djdbc.password=postgres

```
