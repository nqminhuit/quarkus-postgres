# quarkus-postgres

Start postgres:
```bash
podman run --replace -d --name pgdb -p 5432:5432 \
    -e POSTGRES_PASSWORD=dev \
    -e POSTGRES_USER=dev \
    -e POSTGRES_DB=art \
    postgres:17.1-alpine3.20
```

Access db:
```bash
podman exec -it pgdb psql -U dev art
```

List all tables:
```sql
\dt
```

Rest API test:
```bash
curl -sSL 'localhost:8080/sitemap' | jq

curl -v -sSL 'localhost:8080/sitemap' \
  -H 'content-type: application/json' \
  -d '[
    {"year":2020,"month":1,"url":"aabc.0.com"},
    {"year":2020,"month":2,"url":"aabc.1.com"},
    {"year":2020,"month":3,"url":"aabc.2.com"},
    {"year":2020,"month":4,"url":"aabc.3.com"},
    {"year":2020,"month":5,"url":"aabc.4.com"}
]'
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-postgres-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- Flyway ([guide](https://quarkus.io/guides/flyway)): Handle your database schema migrations
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- Reactive PostgreSQL client ([guide](https://quarkus.io/guides/reactive-sql-clients)): Connect to the PostgreSQL database using the reactive pattern

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)

