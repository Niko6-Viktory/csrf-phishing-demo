# CSRF & Phishing Security Demo

**Описание**
Учебный проект на Spring Boot, демонстрирующий веб-уязвимости:
- CSRF (Cross-Site Request Forgery)
- Phishing (поддельная форма входа)

---

**Технологии**
- Java
- Spring Boot
- Spring MVC
- Gradle
- HTML / Forms

---

**Демонстрация атак:**

**CSRF**
Показано, как злоумышленник может выполнить запрос от имени пользователя без его согласия.

**Phishing**
Имитация поддельной страницы логина для получения пользовательских данных.

---

**Возможные улучшения защиты**
- CSRF Token (Spring Security)
- SameSite cookies
- HTTPS
- Input validation

---

**Запуск проекта**
```bash
./gradlew bootRun
