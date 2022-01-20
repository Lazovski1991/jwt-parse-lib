# **Библиотека для парсинга jwt токенов**

**Подлючение к проекту**

Для подключения к проекту необходимо сделать две вещи.
1. Добавить репозиторий в проект. Пример для maven:
```
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
Для gradle:
```
allprojects {
	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
```
2. Добавить зависомость. Пример для Maven:
```
<dependency>
	    <groupId>com.github.Lazovski1991</groupId>
	    <artifactId>jwt-parse-lib</artifactId>
	    <version>1.0.0-T</version>
	</dependency>
```
Для gradle:
```
dependencies {
	implementation 'com.github.Lazovski1991:jwt-parse-lib:1.0.0-T'
}
```

**Как пользоваться?**

1. Обязательный параметр при подключении который нужно задать в yaml или properties jwt.parse.service.secret-key = "key". Это секретный ключ который используется при шифровании токена. 
2. Дальше просто в нужном месте внедряем бин ParseTokenUtilService и вызываем метод getValueFieldFromToken(token: String, field: String). Данный метод принимает два параметра, первый это сам токен, второй название поля из которого мы хотим достать значение.



