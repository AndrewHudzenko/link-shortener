FROM eclipse-temurin:17-jdk

WORKDIR /app

# Копируем весь проект
COPY . .

# Переходим в директорию api-service
WORKDIR /app/api-service

# Даем права на выполнение gradlew
RUN chmod +x ../gradlew

# Собираем приложение
RUN ../gradlew build -x test

# Проверяем созданный JAR файл (обратите внимание на измененный путь)
RUN ls -la ../build/libs/

# Команда для запуска приложения (используем правильный путь к JAR)
CMD ["java", "-jar", "/app/build/libs/api-service-0.0.1-SNAPSHOT.jar"]