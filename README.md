# Diplom_2
## Задание 2: API
Протестировать API [Stellar Burgers](https://stellarburgers.nomoreparties.site/),
[Документация API](https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/api-documentation.pdf).
## Описание
    Java 11
    maven 4.0.0
    JUnit 4.13.2
    RestAssured 5.3.0
    Allure 2.21.0
    gson 2.10.1
### Для запуска автотестов необходимо:
Для запуска автотеста в console прописать команду:
```sh
    mvn clean test
```
Для создания отчета в Allure ввести команду:
```sh
    mvn allure:serve
```
    если не сработало
```sh
    allure serve target/surefire-reports/
```
## Что нужно сделать
*Создай отдельный репозиторий для тестов API.
Создай Maven-проект.
Подключи JUnit 4, RestAssured и Allure.
Напиши тесты.
Сделай отчёт в Allure.*

### Создание пользователя:
* создать уникального пользователя;
* создать пользователя, который уже зарегистрирован;
* создать пользователя и не заполнить одно из обязательных полей.

### Логин пользователя:
* логин под существующим пользователем,
* логин с неверным логином и паролем.

### Изменение данных пользователя:
* с авторизацией,
* без авторизации,
* Для обеих ситуаций нужно проверить, что любое поле можно изменить. Для неавторизованного пользователя — ещё и то, что система вернёт ошибку.

### Создание заказа:
* с авторизацией,
* без авторизации,
* с ингредиентами,
* без ингредиентов,
* с неверным хешем ингредиентов.

### Получение заказов конкретного пользователя:
* авторизованный пользователь,
* неавторизованный пользователь.


Разработал: [Лукашев Виктор Николаевич](https://github.com/lukviktor).
