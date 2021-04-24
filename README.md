* [Plan](https://github.com/BelyakovArkadiy/Diplom-draft/blob/master/reports/Plan.md)
* [Report](https://github.com/BelyakovArkadiy/Diplom/blob/master/reports/Report.md)
* [Summary](https://github.com/BelyakovArkadiy/Diplom/blob/master/reports/Summary.md)

## Процедура запуска тестов сервиса покупки путешествий для MySql
* Клонировать [репозиторий](https://github.com/BelyakovArkadiy/Diplom-draft) на свой компьютер.
* Открыть его с помощью JetBrains IntelliJ IDEA 
* Запускаем контейнеры MySql и Node c помощью команды docker-compose up -d --force-recreate.
* Проверяем, что контейнеры запустились командой docker-compose ps.
* Запускаем приложение и передаем данные для подключения базы MySql командой java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -Durl="jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
* Запускаем тесты командой gradlew clean test -Durl="jdbc:mysql://localhost:3306/app" -Duser="user" -Dpassword="pass" --info
* Формируем отчет командой gradlew allureServe(возможно первый раз нужно будет сначала выполнить команду gradlew allureReport, для формирования нужных файлов)
* Оцениваем результаты тестирования.



## Процедура запуска тестов сервиса покупки путешествий для PostgreSQL
* Клонировать [репозиторий](https://github.com/BelyakovArkadiy/Diplom-draft) на свой компьютер.
* Открыть его с помощью JetBrains IntelliJ IDEA 
* Запускаем контейнеры PostgreSQL и Node c помощью команды docker-compose up -d --force-recreate.
* Проверяем, что контейнеры запустились командой docker-compose ps.
* Запускаем приложение и передаем данные для подключения базы PostgreSQL командой java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/appps -Dspring.datasource.username=userps -Dspring.datasource.password=passps -jar artifacts/aqa-shop.jar
* Запускаем тесты командой gradlew clean test -Durl="jdbc:postgresql://localhost:5432/appps" -Duser="userps" -Dpassword="passps" --info
* Формируем отчет командой gradlew allureServe(возможно первый раз нужно будет сначала выполнить команду gradlew allureReport, для формирования нужных файлов).
* Оцениваем результаты тестирования.
