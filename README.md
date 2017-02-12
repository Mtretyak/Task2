# Task2
bash commands:
gradle clean build
java -jar build/libs/AccountRestService-1.0-SNAPSHOT.jar

Будет запущен сервис, который принимает запросы на http://localhost:8080 и отвечает на них

Примеры запросов:
  Добавление пользователя:
    POST http://localhost:8080/accounts 
      {"lastName":"tretyak","firstName":"mihail","birthDate":"1996-02-12","email":"tretyak.mihail@gmail.com","password":"2281337"}
  Получить информацию о пользователе по его емейлу:
    GET http://localhost:8080/accounts?email=tretyak.mihail@gmail.com
  Удалить пользователя (по емейлу):
    DELETE http://localhost:8080/accounts?email=tretyak.mihail@gmail.com
