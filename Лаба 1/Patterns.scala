/** Напишите решение в виде функции.
  * 
  * Синтаксис:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object PatternMatching {

  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat       extends Food
  case object Vegetables extends Food
  case object Plants     extends Food

  trait Animal {

    val name: String
    var food: Food
  }
  case class Mammal(name: String, var food: Food, weight: Int) extends Animal
  case class Fish(name: String, var food: Food)                extends Animal
  case class Bird(name: String, var food: Food)                extends Animal



  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */
  def IntToString (n:Int): String = n match {
    case 1 => "it is one"
    case 2 => "it is two"
    case 3 => "it is three"
    case _ => "what's that"
  }

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = IntToString(value)

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */
def IsMaxAndMoritz (s: String):Boolean = s match {
  case "max"|"Max"|"moritz"|"Moritz"=>true
  case _=> false
}


  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = IsMaxAndMoritz(value)

  // c) Напишите функцию проверки является ли `value` четным 
def IsEven (n:Int):Boolean = n match {
  case n => n%2==0
  case _=> false
}


  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = IsEven(value)


  
  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага 
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   *///Scissor, Paper, Rock
def WinsA (a: Hand, b: Hand): Result = (a,b) match {
  case (Rock,Scissor)|(Scissor,Paper)|(Paper,Rock)=>Win
  case (Rock,Rock)|(Scissor,Scissor)|(Paper,Paper)=>Draw
  case _=>Lose
}

  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = WinsA(a,b)



  // Примечание: используйте определение Animals

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
def ExtractMammalWeight (animal: Animal):Int = animal match {
  case animal: Mammal => animal.weight
  case _=> -1
}


  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = ExtractMammalWeight(animal)


  // f) Измените поле еда объектов классов Fish и Birds на Plants, класс Mammal оставьте неизмененным.
def UpdateFood ( animal: Animal):Animal = animal match {
  case animal: Mammal=>animal
  case _=> animal.food = Plants
    animal
}


  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = UpdateFood(animal)

  def main(args: Array[String]): Unit = {

    println("testIntToString(1) = " + testIntToString(1))
    println("testIntToString(5) = " + testIntToString(5))

    println("IsMaxAndMoritz(max) = " + IsMaxAndMoritz("max"))
    println("IsMaxAndMoritz(mas) = " + IsMaxAndMoritz("mas"))

    println("testIsEven(2) = " + testIsEven(2))
    println("testIsEven(3) = " + testIsEven(3))


    println("testWinsA(Scissor,Rock) = " + testWinsA(Scissor,Rock))

    val mammal = new Mammal("mammal", Meat, 100)
    val fish = new Fish("fish", Vegetables)
    println("ExtractMammalWeight(mammal) = " + ExtractMammalWeight(mammal))
    println("ExtractMammalWeight(fish) = " + ExtractMammalWeight(fish))


    println("UpdateFood(mammal) = " + UpdateFood(mammal).food)
    println("UpdateFood(fish) = " + UpdateFood(fish).food)

  }
}
