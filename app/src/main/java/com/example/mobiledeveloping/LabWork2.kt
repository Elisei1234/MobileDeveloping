package com.example.mobiledeveloping

fun main()
{
    println("Введите любое целочисленное значение")
    var number = readln().toInt()
    println(task1(number))
    //task2()
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