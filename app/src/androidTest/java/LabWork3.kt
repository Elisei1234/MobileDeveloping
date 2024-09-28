import kotlin.math.sqrt

fun main()
{
    //task1()

    /*task2
    println(getFullName("Елисей", "Синяев"))
    println(getFullName("Елисей", null))
    println(getFullName(null, "Синяев"))
    println(getFullName(null, null))
    *///task2


    /*task3
    println(calculateSquareRoot(5.0))
    println(calculateSquareRoot(null))
    */
}


//Задание 1 – Создание nullable переменной
fun task1()
{
    var a: String?
    a = null
    println(a)
    //Вывелось "null"
    a = "abc"
    var text: String = a
    println(text)
    //Вывелось то, чему равна переменная "a"
}

//Задание 2. Элвис-оператор. Функция должна возвращать полное имя в формате "Имя Фамилия".
//Если какое-либо значение равно null, то вместо него должно использоваться слово "Unknown".
fun getFullName(firstName: String?, LastName: String?): String?
{
    val fname = firstName ?: "Unknown"
    val lname = LastName ?: "Unknown"
    val Name = fname + " " + lname
    return Name
}

//Задание 3. Оператор !!
//Напишите функцию calculateSquareRoot, которая принимает число типа Double?.
// Если переданное значение равно null, функция должна выбросить исключение.
// В противном случае — вернуть квадратный корень числа.
fun calculateSquareRoot(numb: Double?): Double
{
    val l = numb ?: throw IllegalArgumentException("Предсказуемая ошибка, новичковая")
    var sqrt = sqrt(l!!)
    return sqrt
}


//Задание 4. Безопасное приведение типов
fun getStringLength()
{

}

