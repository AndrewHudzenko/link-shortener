FROM eclipse-temurin:17-jdk

WORKDIR /app

# Копируем файлы для сборки
COPY . .

# Даем права на выполнение gradlew
RUN chmod +x ./gradlew

# Собираем приложение
RUN ./gradlew build -x test

# Команда для запуска приложения
CMD ["java", "-jar", "build/libs/link-shortener-0.0.1-SNAPSHOT.jar"]