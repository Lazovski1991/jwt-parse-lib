# **Библиотека для парсинга jwt токенов**

**Подлючение к проекту**

//todo

**Как пользоваться?**

1. Обязательный параметр при подключении который нужно задать в yaml или properties jwt.parse.service.secret-key = "key". Это секретный ключ который используется при шифровании токена. 
2. Дальше просто в нужном месте внедряем бин ParseTokenUtilService и вызываем метод getValueFieldFromToken(token: String, field: String). Данный метод принимает два параметра, первый это сам токен, второй название поля из которого мы хотим достать значение.



