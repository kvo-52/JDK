## 1. Графические интерфейсы

Собрать графический интерфейс проекта месседжера (скриншоты можно посмотреть в материалах к уроку)
Отправлять сообщения из текстового поля сообщения в лог по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
Продублировать импровизированный лог (историю) чата в файле;
При запуске клиента чата заполнять поле истории из файла, если он существует. Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение истории чата лучше делать при соединении с сервером, а не при открытии окна клиента.

## 2. Программные интерфейсы

Задача: исправить серверную часть проекта, выделив интерфейсы.

## 3. Обобщенное программирование
* Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа (но необязательно разного между собой), над которыми должна быть произведена операция.
* Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
* Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары, а также переопределение метода toString(), возвращающее строковое представление пары.

## 4. Коллекции
Создать справочник сотрудников - AppPhoneBook\
Необходимо:\
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
* Табельный номер
* Номер телефона
* Имя
* Стаж\
 Добавить метод, который ищет сотрудника по стажу (может быть список)\
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)\
Добавить метод, который ищет сотрудника по табельному номеру\
Добавить метод добавление нового сотрудника в справочник

## 5. Многопоточность
Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.\
Вилки лежат на столе между каждой парой ближайших философов.\
Каждый философ может либо есть, либо размышлять.
Философ может есть только тогда, когда держит две вилки — взятую справа и слева.\
Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)\
Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны\
Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
### Решение:
Введем понятия раунда.\
Раунд - промежуток времени в течении которого могут обедать философы. Раундов может быть 5 (по количеству философов).\
Каждый раунд выбираются 2 философа, которые будут обедать, остальные 3 размышляют. \
Выборка производится по следующему
алгоритму. Берется номер раунда. И начиная с этого номера через одного выбираются философы, принимающие пищу. Новый философ
не приступает к еде до начала следующего раунда.