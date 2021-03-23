object Main extends App {
// Ćwiczenia 1
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
    for (element <- str_list if element.charAt(0) == start_char) {
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
  def concat_list_recurent_tail(str_list: List[String]): String = {
    if (str_list.length == 1)
      str_list(0)
    else
      str_list(0) + ',' + concat_list_recurent_tail(str_list.tail)
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
      if (concat_string != "") element + ',' + concat_string else element
  }) // TODO Remove tailing ,

  println("Foldl concatanation with filter : " + weekdays.foldLeft("") {
    (concat_string, element) =>
      if (element.charAt(0) == 'S') concat_string + ',' + element
      else concat_string
  }) // TODO Remove tailing ,

// Zadanie 5
  val products: Map[String, Double] =
    Map("Apple" -> 10, "Banana" -> 5, "Plutonium" -> 250000)
  val discounted =
    products.map(product =>
      (product._1, product._2 * 0.9)
    ) // JAK TO ROZWINĄĆ W DWIE ZMIENNE
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
  ) //Czemu tu nie potrzeba nawiasów
// Ćwiczenia 2
// Zadanie 1
// Zadanie 2
// Zadanie 3
// Zadanie 4
// Zadanie 5
// Zadanie 6
// Zadanie 7
// Zadanie 8
// Zadanie 9
// Zadanie 10

}
