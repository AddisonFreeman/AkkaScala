package MUDGame

//import scala.xml._

class attkOpts(val attkOpts: Int, val attkName: String, val damage: Int) extends Serializable {
//  def toXML: xml.Node = <attacks attkOpts={ attkOpts.toString } attkName={ attkName } damage={ damage.toString }/>
}

class MUDCharacter(val name: String, val evolvesInto: String, val evolutionaryLevel: Int, val charClass: String, val attackOptions: Array[attkOpts], var health: Int, val description: String) extends Serializable {

  def heal(healAmt: Int) {
    if ((health <= 100) && (health + healAmt <= 100)) {
      health += healAmt; println("you have been partially healed.\n Your health is now " + health)
    } else {
      if ((health <= 100) && (health + healAmt <= 100)) { health = 100; println("you have been fully healed!") }
    }
  }

 // def toXML: xml.Node = <character name={ name } evolvesInto={ evolvesInto } evolutionaryLevel={ evolutionaryLevel.toString } charClass={ charClass } health={ health.toString } description={ description }> { attackOptions.map(_.toXML) } </character>
}

class NPCCharacter (val name: String, var health: Int, val description: String, val attackOptions: Array[attkOpts])
