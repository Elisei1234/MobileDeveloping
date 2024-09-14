package com.example.mobiledeveloping


fun main()
{
    main_4()

}


//Задание 1 – Вычисление.
//8.	Пользователь вводит время в минутах и расстояние в километрах. Найдите скорость в м/c.
fun main_1 () {

    print("Введите время в минутах: ")
    var min = readln().toInt()
    print("Введите расстояние в км: ")
    var km = readln().toInt()

    var speed = (km * 1000) / (min * 60)

    println("Скорость в м/c равна = $speed")

}


//Задание 2 – Условные конструкции. Решить двумя способами – с помощью
// обычного if, с помощью конструкции when
//5.	Пользователь вводит два числа. Если они не равны 10 и первое число четное, то вывести их сумму, иначе вывести их произведение.
fun main_2() {

    print("Введите число: ")
    var num1 = readln().toInt()
    print("Введите 2 число: ")
    var num2 = readln().toInt()
    if(num1 != 10 && num2 != 10 && num1 % 2 == 0)
    {
        print(num1 + num2)
    }
    else
    {
        print(num1 * num2)
    }
}


fun main_2_2()
{
    print("Введите число: ")
    var num1 = readln().toInt()
    print("Введите 2 число: ")
    var num2 = readln().toInt()
    when
    {
        (num1 != 10 && num2 !=10 && num1 % 2 == 0) -> print(num1 + num2)
        else -> println(num1 * num2)
    }

}


//Задание 3 – Циклы.
//
fun main_3() {
    for (i in 1..5) {
        for (j in 1..i) {
            print("*")
        }
        println()
    }
}


//Задание 4. Массивы и коллекции

//10.	В двухмерном массиве переставьте попарно соседние строки,
// т.е. 1-ю со 2-ой, 3-ю с 4-й и т.д. Результат выведите на экран.
fun main_4()
{

    fun swapAdjacentRows(array: Array<IntArray>) {
        for (i in 0 until array.size - 1 step 2) {
            val temp = array[i]
            array[i] = array[i + 1]
            array[i + 1] = temp
        }

    }

    val array = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
        intArrayOf(10, 11, 12)
    )
    swapAdjacentRows(array)

    for (row in array) {
        for (element in row) {
            print("$element ")
        }
        println()
    }
}






