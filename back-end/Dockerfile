FROM eclipse-temurin:17-jdk

WORKDIR /app

# Копируем весь проект, так как gradlew находится в корне back-end
COPY . .

# Переходим в директорию api-service
WORKDIR /app/api-service

# Даем права на выполнение gradlew (используем путь к файлу в родительской директории)
RUN chmod +x ../gradlew

# Собираем приложение используя gradlew из родительской директории
RUN ../gradlew build -x test

# Команда для запуска приложения
CMD ["java", "-jar", "build/libs/api-service-0.0.1-SNAPSHOT.jar"]