package com.example.mobiledeveloping

fun main()
{
    println("Введите любое целочисленное значение")
    var number = readln().toInt()
    //println(task1(number))
    println(task2(number))
    //task3()
}


//3.	Написать функцию. Входящий параметр (number) – целочисленная переменная.
// Действие функции – если number нечетное, вернуть нуль, иначе вернуть квадрат числа number.
fun task1(number: Int) : Int?
{
    if(number % 2 !=0)
    {
        return null
    }
    else
    {
        return number * number
    }
}


//3.	Написать лямбда-выражение. Входящий параметр Int. Выходящий Boolean.
// Действие лямбды – если входящий параметр является трехзначным числом (от 100 до 999), вернуть true, иначе вернуть false.

val task2 = {num: Int ->
    if(num > 99 && num < 1000) true
    else false
}
