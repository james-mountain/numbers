import scala.annotation.tailrec

class NumberToText(number : BigInt) {
  def spliceLongNum(): List[String] = {
    @tailrec def spliceRec(remainSegments : List[Char], splicedNums : List[String]) : List[String] = remainSegments.length match {
      case x if x > 3 => spliceRec(remainSegments.dropRight(3), splicedNums :+ remainSegments.takeRight(3).mkString )
      case _ => splicedNums :+ remainSegments.takeRight(3).mkString;
    }

    spliceRec(number.toString().toList, Nil)
  }

  def getRepresentation(representationList : List[String]): List[String] = {
    spliceLongNum().zip(representationList).reverse.map {
      case (num, shortrep) => num + " " + shortrep
    }
  }
}

object NumberToText {
  val shortStringList = List("", "thousand", "million", "billion", "trillion", "quadrillion")
  val longStringList = List("", "thousand", "million", "milliard", "billion", "billiard")
}