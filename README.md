[План тестирования](https://github.com/BelyakovArkadiy/Diplom-draft/blob/master/reports/Plan.md)

## Процедура запуска тестов сервиса покупки путешествий для MySql
* Клонировать [репозиторий](https://github.com/BelyakovArkadiy/Diplom-draft) на свой компьютер.
* Открыть его с помощью JetBrains IntelliJ IDEA 
* Запускаем контейнеры MySql и Node c помощью команды docker-compose up -d --force-recreate.
* Проверяем, что контейнеры запустились командой docker-compose ps.
* Запускаем приложение и передаем данные для подключения базы MySql командой java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -Durl="jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
* Запускаем тесты командой gradlew clean test.
* Формируем отчет командой gradlew allureServe.
* Оцениваем результаты тестирования.



## Процедура запуска тестов сервиса покупки путешествий для PostgreSQL
* Клонировать [репозиторий](https://github.com/BelyakovArkadiy/Diplom-draft) на свой компьютер.
* Открыть его с помощью JetBrains IntelliJ IDEA 
* Запускаем контейнеры PostgreSQL и Node c помощью команды docker-compose up -d --force-recreate.
* Проверяем, что контейнеры запустились командой docker-compose ps.
* Запускаем приложение и передаем данные для подключения базы PostgreSQL командой java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -Durl="jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
* Запускаем тесты командой gradlew clean test.
* Формируем отчет командой gradlew allureServe.
* Оцениваем результаты тестирования.
