## Стек технологий
- Java 11
- JUnit 4
- RestAssured 5
- Jackson
- Allure Framework
- Maven
- 
Установка и запуск

1. Установить необходимые инструменты
Перед началом убедитесь, что установлены:
Java 11
Maven
Allure Commandline

Проверить установку:
java -version
mvn -v
allure --version

git clone <ссылка-на-репозиторий>
cd Sprint_7

Запкс тестов
mvn clean test

отчет алюр генерится командой
allure serve target/allure-results

