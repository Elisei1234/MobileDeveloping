fun main()
{
    //task1()

    /*task2
    println(getFullName("Елисей", "Синяев"))
    println(getFullName("Елисей", null))
    println(getFullName(null, "Синяев"))
    println(getFullName(null, null))
    *///task2


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
    //Вывелось то, чему равна переменная
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


fun calculateSquareRoot(numb: Double?)
{

}

