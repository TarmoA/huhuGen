package huhut

class Word(word: String) {
 
  val value = word
  
}

class Verb(word: String) extends Word(word) {
  
}

class Subject(word: String) extends Word(word) {
  
}

class Obj(word: String) extends Word(word) {
  
}

object Word {
  
  def apply(word: String, t: String) = {
    t match {
      case "s" => new Subject(word)
      case "o" => new Obj(word)
      case "v" => new Verb(word)
      
    }
  }
}