FROM eclipse-temurin:17-jdk

WORKDIR /app

# Копируем только необходимые файлы из api-service
COPY api-service .

# Даем права на выполнение gradlew
RUN chmod +x ./gradlew

# Собираем приложение
RUN ./gradlew build -x test

# Команда для запуска приложения
CMD ["java", "-jar", "build/libs/api-service-0.0.1-SNAPSHOT.jar"]