/** Напишите отдельные функции, решающие поставленную задачу.
  * 
  * Синтаксис:
  *   // метод
  *   def myFunction(param0: Int, param1: String): Double = // тело
  * 
  *   // значение
  *   val myFunction: (Int, String) => Double (param0, param1) => // тело
  */
object Functions {

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def Circle(r: Double): Double = Math.pow(r,2)* Math.PI
  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double =Circle(r)


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def RectangleCurried(a: Double)(b: Double): Double = a * b
  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = RectangleCurried(a)(b)


  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def RectangleUc(a: Double, b: Double): Double = a * b
  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = RectangleUc(a, b)

  def main(args: Array[String]): Unit ={
    println("testCircle = "+testCircle(5))
    println("testRectangleCurried = " + testRectangleCurried(3,1.5))
    println("testRectangleUc = " + testRectangleUc(2.5,5))
    val a = RectangleCurried(5)(_)
    val b = a(6)
    println(b)

  }
}
