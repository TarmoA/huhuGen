package huhut

class Word(word: String, val plural: Boolean) {
 
  val value = word
  
}

class Verb(word: String, plural: Boolean) extends Word(word, plural) {
  
}

class Subject(word: String, plural: Boolean) extends Word(word, plural) {
  
}

class Obj(word: String, plural: Boolean) extends Word(word, plural) {
  
}

object Word {
  
  def apply(word: String, t: String, plural: Boolean) = {
    t match {
      case "s" => new Subject(word, plural)
      case "o" => new Obj(word, plural)
      case "v" => new Verb(word, plural)
      
    }
  }
}