package com.example.mobiledeveloping

fun main()
{
    //println("Введите любое целочисленное значение")
    //var number = readln().toInt()
    //println(task1(number))
    //println(task2(number))
    println("Введите размерность массива: ")
    val n = readln().toInt()
    val array = IntArray(size = n)
    for(i in 0 until array.size)
    {
        array[i] = (-100 until 501).random()
    }

    println("Исходный массив: ")
    _Array(array)

}


//Написать функцию. Входящий параметр (number) – целочисленная переменная.
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


//Написать лямбда-выражение. Входящий параметр Int. Выходящий Boolean.
// Действие лямбды – если входящий параметр является трехзначным числом (от 100 до 999), вернуть true, иначе вернуть false.

val task2 = {num: Int ->
    if(num > 99 && num < 1000) true
    else false
}

//Task3
fun _Array(numbers: IntArray)
{
    for(i in 0..numbers.size - 1)
    {
        print("${numbers[i]}  ")
        // print("  ")
    }
}


//Task 5.
//1. (Int, Int, String) -> Unit.
//2. () -> String.
//3. (()->Unit) -> Unit.
