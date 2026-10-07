FROM amazoncorretto:17

COPY ./target/classes/com /tmp/com
COPY ./target/dependency /tmp/dependency

WORKDIR /tmp

ENTRYPOINT ["java", "-cp", ".:dependency/*", "com.napier.sem.Main"]