/**
  * Created by Administrator on 18/07/2017.
  */
class NumberToText(number : BigInt) {
  def spliceLongNum(): List[String] = {
    def spliceRec(remainSegments : List[Char]) : List[String] = remainSegments.length match {
      case x if x > 3 => remainSegments.takeRight(3).mkString :: spliceRec(remainSegments.dropRight(3))
      case _ => remainSegments.takeRight(3).mkString :: Nil;
    }

    spliceRec(number.toString().toList)
  }

  def getRepresentation(orderedNumList : List[String], representationList : List[String]): Unit = {
    orderedNumList.zip(representationList).reverse.foreach {
      case (num, shortrep) => println(num + " " + shortrep)
    }
  }
}

object NumberToText {
  val shortStringList = List("", "thousand", "million", "billion", "trillion", "quadrillion")
  val longStringList = List("", "thousand", "million", "milliard", "billion", "billiard")

  def main(args: Array[String]): Unit = {
    val nTT = new NumberToText(BigInt("1234567891111"))
    nTT.getRepresentation(nTT.spliceLongNum(), shortStringList)
    nTT.getRepresentation(nTT.spliceLongNum(), longStringList)
  }
}