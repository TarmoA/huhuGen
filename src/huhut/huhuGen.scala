package huhut
import scala.io.Source
import scala.util.Random

object huhuGen extends App {
  
  var verbs = List[Word]()
  var objects = List[Word]() 
  var subjects = List[Word]()
  
  
  def getVerbs = {
    val f = Source.fromFile("verb.huhu")
    
    val line = f.getLines
    verbs = line.toList.map(Word(_,"v"))
  }
  
  def getSubjects = {
    val f = Source.fromFile("subj.huhu")
    
    val line = f.getLines
    subjects = line.toList.map(Word(_,"s"))
  }
  
  def getObjects = {
    val f = Source.fromFile("obj.huhu")
    
    val line = f.getLines
    objects = line.toList.map(Word(_,"o"))
  }
  
  def getRandom(list: List[Word]) = {
    val rndm = Random.nextInt(list.size)
    list(rndm)
  }
  
  def generateHuhu(i: Int) = {
    var res = "Huhutaan että...\n"
    for (a <- 0 until i) {
      res = res ++ "..." + getRandom(subjects).value + " " + getRandom(verbs).value + " " + getRandom(objects).value + "\n"
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