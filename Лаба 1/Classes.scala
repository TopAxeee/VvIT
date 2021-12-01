      /*
       a) Создать класс Animal, который имеет следующие поля:
       *      - name: String (название)
       *      - species: String (вид)
       *      - food: String
       *
       *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
       *              // остальные поля и методы
       *            }*/

      /**class Animal (val name: String,val species: String,val food: String) {**/
      /* c) Добавьте следующие метод в Animals:
      *      def eats(food: String): Boolean
      *
      *     который проверяет ест ли животное определенную пищу
       */
        /**!def Eats(food:String):Boolean = food==this.food
      }
      */

/* d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishes.
*    Вам все еще нужно поле `species`? - нет
*/
trait Animal{
val name : String
val food : Food
def eats(food: Food): Boolean = food == this.food
}
case class Mammal (name: String, food: Food, weight: Int)extends Animal
case class Bird (name: String, food: Food)extends Animal
case class Fish (name: String, food:Food)extends Animal
/* b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
*      - cat, mammal, meat
*      - parrot, bird, vegetablesing, food: Food
*      - goldfish, fish, plants
*
*    Синтаксис: object MyClass {
*              // статические поля и методы
*            }
*/
object Animal {
 /**
 val c = Animal("cat", "mammal", "meat")
 val p = Animal("parrot", "bird", "vegetables")
 val d = Animal("goldfish", "fish", "plants")*/
  /* e) Добавьте следующие функции в объект-компаньон Animal:
  *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
  *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
  */
  def knownAnimal(name: String): Boolean = name=="cat"|name=="parrot"|name=="goldfish"
  def apply(name: String): Option[Animal] = name match {
    case "cat"=>Some(Mammal("cat",Meat,5))
    case "parrot"=>Some(Bird("parrot",Vegetables))
    case "goldfish"=>Some(Fish("goldfish",Plants))
    case _ => None
  }
}



/* f) Создайте трейт Food со следующими классами-образцами:
*      - Meat
*      - Vegetables
*      - Plants
*   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
*      def apply(food: String): Option[Food]
*/
trait Food
case object Meat       extends Food
case object Vegetables extends Food
case object Plants     extends Food
object Food {
  def apply(food: String): Option[Food] = food match {
    case "Meat" => Some(Meat)
    case "Vegetables" => Some(Vegetables)
    case "Plants" => Some(Plants)
    case _ => None
  }
}
object Classes{
  def main(args: Array[String]): Unit ={
    println("knownAnimal(\"fish\") = " + Animal.knownAnimal("fish"))
    println("knownAnimal(\"goldfish\") = " + Animal.knownAnimal("goldfish"))

    println("apply(\"parrot\") = " + Animal.apply("parrot"))
    println("apply(\"bird\") = " + Animal.apply("bird"))

    println("apply(\"Seed\") = " + Food.apply("Seed"))
    println("apply(\"Vegetables\") = " + Food.apply("Vegetables"))

  }
}
