class NumberToText(number : BigInt) {
  def spliceLongNum(): List[String] = {
    def spliceRec(remainSegments : List[Char]) : List[String] = remainSegments.length match {
      case x if x > 3 => remainSegments.takeRight(3).mkString :: spliceRec(remainSegments.dropRight(3))
      case _ => remainSegments.takeRight(3).mkString :: Nil;
    }

    spliceRec(number.toString().toList)
  }

  def getRepresentation(orderedNumList : List[String], representationList : List[String]): List[String] = {
    orderedNumList.zip(representationList).reverse.map {
      case (num, shortrep) => num + " " + shortrep
    }
  }
}

object NumberToText {
  val shortStringList = List("", "thousand", "million", "billion", "trillion", "quadrillion")
  val longStringList = List("", "thousand", "million", "milliard", "billion", "billiard")
}