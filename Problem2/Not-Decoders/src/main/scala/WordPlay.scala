import scala.io.Source
import java.io.File
import java.io.PrintWriter

object WordPlay extends App {

  def getState(a: Int, c: Int): Boolean = {
    var d = a
    var b = c
    var count: Int = 0
    if (b != 0) {
      d -= 1
      while (d >= 0) {
        if (d == 0) count +=1
        else count += Math.pow(2, d).toInt
        d -= 1
      }
      var e = 0
      var f = 0
      f = b / (count + 1)
      e = b % (count + 1)
      if (e == 0) {
        f -= 1;
        f + 1
      }
      b = b - f
      e = b % count
      if (e == 0) true
      else false
    }
    else {
      false
    }
  }

  val input = Source.fromResource("input.txt").getLines()
  val output = new PrintWriter(new File("output.txt"))
  var count = 0
  input.drop(1).foreach(x =>
    x.split(" ") match {
      case Array(x, y) =>
        count = count + 1
        val a = (x.toInt, y.toInt)
        output.write(s"Experiment-$count: ${
          getState(a._1, a._2) match {
            case true => "ON"
            case false => "OFF"
          }
        }\n")
    }
  )
}