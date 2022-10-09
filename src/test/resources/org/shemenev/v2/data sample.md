# Timing

| №   | time  | tasks      | desc                                                                        |
|:----|:------|:-----------|:----------------------------------------------------------------------------|
| 1   | 10:05 | inbox      |                                                                             |
| 2   | 10:48 | break      |                                                                             |
| 3   | 11:00 | persreview |                                                                             |
| 4   | 12:00 | daily      |                                                                             |
| 5   | 12:26 | break      |                                                                             |
| 6   | 14:06 | inbox      |                                                                             |
| 7   | 14:17 | review     | [M] ID-1839 Рефакторинг парсинга на SAX                                     |
| 8   | 14:46 | review     | [S] ID-1957 Безопасное получение даты рождения при нормализации даты выдачи |
| 9   | 14:48 | review     | [S] ID-1837 [API] Ручка деактивации торговых точек                          |
| 10  | 14:50 | review     | [M] ID-1411 Кубер                                                           | 
| 11  | 15:00 | ответ Leo  | Где взять date для поиска через beeline                                     | 
| 12  | 15:11 | ответ Leo  | AEADBadTagException: Tag mismatch!                                          | 
| 13  | 15:35 | break      |                                                                             |
| 14  | 15:50 | ID-1872    |                                                                             |
| 15  | 18:17 | break      |                                                                             |
| 16  | 19:11 | ID-1872    |                                                                             |
| 17  | 19:20 | ID-1872    |                                                                             |
| 18  | 20:01 | end        |                                                                             |

# Цель
* прочитать про Stream Api distinct
* прочитать про архитектуру https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749

# ID-1872
* как узнать что за ручки дергались за сентябрь
  * find /logs/
  * grep
  * cat dublicates | sort -u
```
  [POST/component/cation/annual/data]
  [POST/component/cation/annual/set]
  [POST/component/cation/approve]
  [POST/component/cation/cancel]
  [POST/component/cation/check]
  [POST/component/cation/complete]
  [POST/component/cation/confirmation/get]
  [POST/component/cation/error]
  [POST/component/cation/get]
  [POST/component/cation/inherite]
  [POST/component/cation/inherit/init]
  [POST/component/cation/personal/execute]
  [POST/component/cation/]
  [POST/component/cation/callback]
  [POST/component/cation/reject]
  [POST/component/cation/start]
```

# Таски
* Создать таску на добавление кода
* изучить wiremock - не понимаю как происходит перехват
* изучить com.fasterxml.jackson.annotation - долго не понимал, что у обьекта есть unmarshal, но нет marshal
* изучить xml xsd wsdl soap xjb xjc что бы хотябы понимать что это такое
* доработать доку про зипкин
* изучить PeriodicQueue
* изучить Lock
* Составить декомпозицию проекта
* поездка в офис в среду ?
  * не работает обнвление винды
  * подписать документы
  * заблокировать учетку

# Вопросы
* Как посмотреть тестовую базу при запуке компонентных тестов
* Как все таки накатить компонент в докере?
* Что лучше строковое представление перечисления (GetInnStatus) или цифровое(IdentOrderState)
* Что такое ДТО, пример DataWhiteListDto, узнать у Димы

