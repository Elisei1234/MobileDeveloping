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

    //println(getStringLength("clown"))
    //println(getStringLength(null))
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

//Задание 2. Элвис-оператор.
fun getFullName(firstName: String?, LastName: String?): String?
{
    val fname = firstName ?: "Unknown"
    val lname = LastName ?: "Unknown"
    val Name = fname + " " + lname
    return Name
}

//Задание 3. Оператор !!
fun calculateSquareRoot(numb: Double?): Double
{
    val l = numb ?: throw IllegalArgumentException("Предсказуемая ошибка, новичковая")
    var sqrt = sqrt(l!!)
    return sqrt
}


//Задание 4. Безопасное приведение типов
fun getStringLength(clown :Any?): Int
{
    val mini_clown = clown as? String
    val max_clown : Int
    if(mini_clown == null)max_clown = -1 else max_clown = mini_clown.length
    return max_clown
}

