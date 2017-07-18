/**
  * Created by Administrator on 18/07/2017.
  */
class NumberToTextTest extends BaseTest {
  val nTT = new NumberToText(BigInt("25123456789"))
  "A number above 20 billion" should "be able to be converted its short representation" in {
    val representation = nTT.getRepresentation(NumberToText.shortStringList)

    representation(0) should be ("25 billion")
    representation(1) should be ("123 million")
    representation(2) should be ("456 thousand")
    representation(3) should be ("789 ")
  }

  "A number above 20 billion" should "be able to be converted its long representation" in {
    val representation = nTT.getRepresentation(NumberToText.longStringList)

    representation(0) should be ("25 milliard")
    representation(1) should be ("123 million")
    representation(2) should be ("456 thousand")
    representation(3) should be ("789 ")
  }
}
