package huhut
import scala.io.Source
import scala.util.Random

object huhuGen extends App {
  
  var verbs = List[Word]()
  var verbsPlural = List[Word]()
  var objects = List[Word]() 
  var objectsPlural = List[Word]()
  var subjects = List[Word]()
  
  
  def getVerbs = {
    val f = Source.fromFile("verb.huhu")
    
    val line = f.getLines
    val list = line.toList.map(_.split("_")).map((a: Array[String]) => Array[Word](Word(a(0), "v", false), Word(a(1), "v", true)))
    verbs = list.map((a: Array[Word]) =>  a(0))
    verbsPlural = list.map((a: Array[Word]) =>  a(1))
  }
  
  def getSubjects = {
    val f = Source.fromFile("subj.huhu")
    
    val line = f.getLines
    subjects = line.toList.map(_.split("_")).map((a: Array[String]) => Word( a(0),"s", a(1) match {
      case "1" => true
      case "0" => false
    }))
  }
  
   def getObjects = {
    val f = Source.fromFile("obj.huhu")
    
    val line = f.getLines
    val list = line.toList.map(_.split("_")).map((a: Array[String]) => Array[Word](Word(a(0), "o", false), try {
      Word(a(1), "o", true)
    } catch {
      case e: java.lang.ArrayIndexOutOfBoundsException =>  Word(a(0), "o", true)
    }))
     //catch Word(a(0), "o", false)))
   
    objects = list.map((a: Array[Word]) =>  a(0))
    objectsPlural = list.map((a: Array[Word]) =>  a(1))
  }
  
  def getRandom(list: List[Word]) = {
    val rndm = Random.nextInt(list.size)
    list(rndm)
  }
  
  def generateHuhu(i: Int) = {
    var res = "Huhutaan että...\n"
    for (a <- 0 until i) {
      val subj = getRandom(subjects)
      res = res ++ "..." + subj.value + " " + {
        subj.plural match {
          case true => getRandom(verbsPlural).value + " " + getRandom(objectsPlural).value + "\n"
          case false => getRandom(verbs).value + " " + getRandom(objects).value + "\n"
        }
      }
    }
    res
  }
  getVerbs
  getSubjects
  getObjects
  
  while (true) {
    println("Montako huhua haluat?")
    val n = readInt()
    print(generateHuhu(n))
  }
  
  
  
  
}