import scala.annotation.tailrec
object Main extends App {
// Ćwiczenia 1
  println(
    "####################################\nPierwszy zestaw ćwiczeń\n####################################"
  )
// Zadanie 1
  var weekdays: List[String] = List(
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
  )
  def concat_list(str_list: List[String]): String = {
    var ret: String = "";
    var element = "";
    for (element <- str_list) {
      ret += element + ",";
    }
    ret.substring(0, ret.length() - 1)
  }
  println("For Loop concatanation : " + concat_list(weekdays))
  def concat_list_starts_with(
      str_list: List[String],
      start_char: Char
  ): String = {
    var ret: String = "";
    var element = "";
    for (element <- str_list if element.head == start_char) {
      ret += element + ",";
    }
    ret.substring(0, ret.length() - 1)
  }
  println("Filter concatation: " + concat_list_starts_with(weekdays, 'S'))
  def concat_list_while(str_list: List[String]): String = {
    var ret: String = "";
    var element = "";
    var i = 0;
    while (i < str_list.length) {
      ret += str_list(i) + ",";
      i += 1
    }
    ret.substring(0, ret.length() - 1)
  }
  println("While loop concatanation : " + concat_list_while(weekdays))
// Zadanie 2
  def concat_list_recurent(
      str_list: List[String],
      str_so_far: String = ""
  ): String = str_list match {
    case Nil => str_so_far
    case x :: Nil =>
      (str_so_far + ',' + x).substring(1, (str_so_far + ',' + x).length())
    case x :: y :: xs => concat_list_recurent(y :: xs, str_so_far + ',' + x)
  }
  println("Recurent concatanation : " + concat_list_recurent(weekdays))
  def concat_list_recurent_reverse(
      str_list: List[String],
      str_so_far: String = ""
  ): String = str_list match {
    case Nil => str_so_far
    case x :: Nil =>
      (x + ',' + str_so_far).substring(0, (str_so_far + ',' + x).length() - 1)
    case x :: y :: xs =>
      concat_list_recurent_reverse(y :: xs, x + ',' + str_so_far)
  }
  println(
    "Recurent reverse concatanation : " + concat_list_recurent_reverse(weekdays)
  )
// Zadanie 3
  @tailrec
  def concat_list_recurent_tail(
      str_list: List[String],
      result: String = ""
  ): String = {
    if (str_list.length == 0)
      result
    else
      concat_list_recurent_tail(
        str_list.tail,
        if (result != "") result + ',' + str_list.head else str_list.head
      )
  }

  println(
    "Tail recurent concatanation : " + concat_list_recurent_tail(weekdays)
  )
// Zadanie 4

  println("Foldl concatanation : " + weekdays.foldLeft("") {
    (concat_string, element) =>
      if (concat_string != "") concat_string + ',' + element else element
  })

  println("Foldr concatanation : " + weekdays.foldRight("") {
    (concat_string, element) =>
      if (element != "") element + ',' + concat_string else concat_string
  })

  println(
    "Foldl concatanation with filter : " + weekdays
      .filter(_.head == 'S')
      .foldLeft("") { (concat_string, element) =>
        if (concat_string != "") concat_string + ',' + element else element

      }
  )

// Zadanie 5
  val products: Map[String, Double] =
    Map("Apple" -> 10, "Banana" -> 5, "Plutonium" -> 250000)
  val discounted =
    products.view.mapValues(price => price * 0.9).toMap
  println(s"Discounted products : from $products to  $discounted")
// Zadanie 6
  val diff_types = ("Apple", 42, 4.231512)
  def print_variety(list_to_print: (Any, Any, Any)) = {
    println(s"Different types printed : $list_to_print")
  }
  print_variety(diff_types)
// Zadanie 7
  val library = Map(
    "Foundation" -> "Asimov",
    "Stelaris" -> "Lem",
    "Diuna" -> "Herbert",
    "Lód" -> "Dukaj"
  )
  def option_demo(key: Option[String]) = key match {
    case Some(s) => s
    case None    => "?"
  }
  println("The author of Lód is " + option_demo(library.get("Lód")))
  println(
    "The author of Frankenstein is " + option_demo(library.get("Frankenstein"))
  )
// Zadanie 8
  var numbers = List[Int](0, 2, 4, 6, 2321, 21, 0, 23, 0, 6, 43, 2, 34, 0, 32,
    -3, -7, -1, -20, 0, -14)
  def remove_zeroes(
      int_list: List[Int],
      filtered: List[Int] = List[Int]()
  ): List[Int] =
    int_list match {
      case Nil      => filtered
      case x :: Nil => if (x != 0) x :: filtered else filtered
      case x :: y :: xs =>
        if (x != 0) remove_zeroes(y :: xs, x :: filtered)
        else remove_zeroes(y :: xs, filtered)
    }
  println("Numbers sans zeros " + remove_zeroes(numbers))
// Zadanie 9
  def make_my_monsters_grow(nums: List[Int]) = {
    def increment(num: Int): Int = {
      num + 1
    }
    nums.map(increment)
  }
  println("Big numbers " + make_my_monsters_grow(numbers))
// Zadanie 10

  def filter_out(nums: List[Double]) = {
    nums.filter(x => x < 12 && x > -5)
  }
  println(
    "Some numbers " + filter_out(numbers.map(num => num.toDouble))
  )
// Ćwiczenia 2
  println(
    "####################################\nDrugi zestaw ćwiczeń\n####################################"
  )
// Zadanie 1
  def is_it_over(day: String): String = day match {
    case "Saturday" | "Sunday"                                      => "Work"
    case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "Weekend"
    case _                                                          => "No such day"
  }
  println(
    "Monday is " + is_it_over("Monday")
  )
  println(
    "Saturday is " + is_it_over("Saturday")
  )
  println(
    "Blabla is " + is_it_over("Blabla")
  )
// Zadanie 2
  class BankAccount(private var balance: Int = 0) {
    def deposit(change: Int): Unit = {
      balance += change
    }
    def withdraw(change: Int): Unit = {
      balance -= change
    }
    def check(): Int = {
      balance
    }
  }
  val myAccount = new BankAccount
  myAccount.deposit(200)
  myAccount.withdraw(100)
  val wifesAccount = new BankAccount(1000)
  wifesAccount.deposit(1000)
  wifesAccount.withdraw(500)
  println(
    "My wife has " + wifesAccount.check() + "PLN and I have " + myAccount
      .check() + "PLN"
  )

// Zadanie 3
  case class Person(var name: String, var surname: String)
  val me = new Person("Kajetan", "Kaczmarek")
  val some_nerd = new Person("Konrad", "Dymowski")
  val random_cutie = new Person("Amelia", "Kaczmarek")
  val stranger = new Person("???", "???")
  def greet(someone: Person): String = someone match {
    case Person(name, "Dymowski") =>
      s"Well well well, if it aint $name"
    case Person("Kajetan", "Kaczmarek") => s"Bonjour Kajetan"
    case Person("Amelia", "Kaczmarek")  => s"Ohaio Amelia"
    case _                              => "He...Hello?"
  }
  println(greet(me))
  println(greet(some_nerd))
  println(greet(random_cutie))
  println(greet(stranger))
// Zadanie 4
  def triple_down(value: Int, action: (Int) => Int): Int = {
    action(action(action(value)))
  }
  println(triple_down(1, a => a + 1))
  println(triple_down(2, a => a * 2))
// Zadanie 5
  trait Student extends Person_2 { override def tax = 0 }
  trait Worker extends Person_2 {
    var _salary: Integer = 0
    def salary() {
      _salary
    }
    def salary_=(new_salary: Integer): Unit = {
      _salary = new_salary
    }
    override def tax: Double =
      0.2 * _salary.toDouble
  }
  trait Teacher extends Worker {
    override def tax = 0.1 * _salary
  }

  abstract class Person_2(
      val name: String,
      val surname: String
  ) {
    def tax(): Double
  }
  var person_1 = new Person_2("A", "B") with Student
  var person_2 = new Person_2("C", "D") with Worker
  person_2.salary = 1500
  var person_3 = new Person_2("E", "F") with Teacher
  var person_4 = new Person_2("G", "H") with Student with Worker
  var person_5 = new Person_2("I", "J") with Worker with Student
  person_4.salary = 1200
  person_5.salary = 1500

  def print_person(person: Person_2): Unit = {
    println(s"${person.name} tax : ${person.tax}")
  }
  print_person(person_4) //This has tax cause it's a worker second
  print_person(person_5) //This doesn't have tax cause it's a student second
}
