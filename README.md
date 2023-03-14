## Задача: Необходимо написать программу – розыгрыша игрушек в магазине детских товаров.
### Желательный функционал программы:
1. В программе должен быть минимум один класс со следующими свойствами:
* id игрушки
* текстовое название
* количество
* частота выпадения игрушки (вес в % от 100)
2. Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки)
3. Возможность организовать розыгрыш игрушек.
    Например, следующим образом:
С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
Это список призовых игрушек, которые ожидают выдачи.
Еще у нас должен быть метод – получения призовой игрушки.
После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.
Не забываем уменьшить количество игрушек

### Описание

1. Main.java:
* Задаются данные первоначального массива с игрушками.
* Розыгрыш игрушек. Разбивается диапазон от 1 до 100 на интервалы, в зависимости от веса игрушки. Далее в зависимости от выпавшей рандомной цифры выбирается диапазон, в которой находится определенная игрушка. Все выигранные игрушки с помощью цикла записываются в новый массив выигранных игрушек. Также вычитаем 1 выигранную игрушку из количества соответсвующей игрушки из первоначального массива.
* Запись выданной первой игрушки из массива выигранных игрушек в файл.
* Обнуление первой игрушки из массива выигранных игрушек (выдача) и перемещение ее в конец.
* Запрос у пользователя для дальнейшего действия: Добавление игрушки в первоначальный массив или изменение веса игрушки в первоначальном массиве.

2. Toy.java:
* Создание класса Toy с заданными аргументами.
* Вспомогательные методы.