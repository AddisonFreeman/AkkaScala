package MUDGame

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable._
import java.io._
import java.io.Console._
import java.net._
//import scala.xml.NodeBuffer
/*
object createPlayer {
  val xmlFile = xml.XML.loadFile("players.xml")

  def attackOptsFromXML(elem: xml.Node): attkOpts =
    new attkOpts((elem \ "@opts").text.toInt,
      (elem \ "@name").text,
      (elem \ "@damage").text.toInt)

  def attackOptsArrayFromXML(elem: xml.Node): Array[attkOpts] =
    (for (i <- (elem \ "attack")) yield {
      attackOptsFromXML(i)
    }).toArray

  def MUDCharacterFromXML(elem: xml.Node): MUDCharacter =
    new MUDCharacter((elem \ "@name").text,
      (elem \ "@evolvesInto").text,
      (elem \ "@evolutionaryLevel").text.toInt,
      (elem \ "@charClass").text,
      attackOptsArrayFromXML(elem),
      (elem \ "@health").text.toInt,
      (elem \ "@description").text)

  def clientFromXML(elem: xml.Node): Client =
    new Client(null,
      null,
      null,
      0,
      (elem \ "@curRoom").text.toInt,
      //(elem \ "@usrLvl").text.toInt,
      (elem \ "@name").text,
      //(elem \ "@pass").text,
      //null,
      MUDCharacterFromXML((elem \ "character").head))

  def clientListFunct(): Buffer[Client] = {
    for (r <- xmlFile \\ "client") yield {
      clientFromXML(r)
    }.toBuffer
  }

  var clientList = clientListFunct()
  val charXml = (xml.XML.loadFile("CharacterTypesAndAttacks.xml") \ "character")

  def charAttkOptsFromXML(elem: xml.Node): attkOpts = new attkOpts((elem \ "@opts").text.toInt, (elem \ "@name").text, (elem \ "@damage").text.toInt)

  def charArrAttkOptsFromXML(elem: xml.Node): Array[attkOpts] = Array[attkOpts]((for (i <- (elem \ "attack")) yield {
    charAttkOptsFromXML(i)
  }): _*)

  def characterFromXML(elem: xml.Node): MUDCharacter = new MUDCharacter((elem \ "@name").text, (elem \ "@evolvesInto").text, (elem \ "@evolutionaryLevel").text.toInt, (elem \ "@charClass").text, charArrAttkOptsFromXML(elem), 100, (elem \ "description").text)

  def readCharacters(): Array[MUDCharacter] = {
    (for (r <- charXml) yield {
      characterFromXML(r)
    }).toArray
  }

  val characterArray = readCharacters

  val distinctCharList = readCharacters.distinct

  def mapCharacters(): Map[String, MUDCharacter] = {
    val chTmp = Map[String, MUDCharacter]
    for (i <- 0 to characterArray.size) {
      chTmp += (characterArray(i).name -> characterArray(i))
    }
    chTmp
  }

  val characterMap = chTmp

  def apply(key: String): MUDCharacter = {
    characterArray.find(s => s.charClass == key).get
  }

  def characterSelect(nc: Client): Client = {
    var flag = true
    var flag1 = true
    var flag2 = true
    var p1 = true
    var p2 = true
    while (flag) {
      val userInput = new BufferedReader(new InputStreamReader(nc.is))
      nc.ps.println("enter username: ")
      nc.name = userInput.readLine()
      if (clientList.exists(_.name == nc.name)) {

        while (flag1) {
          nc.ps.println("User exists, overwrite character profile?")
          userInput.readLine().capitalize.head.toString match {
            case "Y" => nc.ps.println("enter password: "); nc.pass = userInput.readLine(); if (clientList.exists(e => e.name == nc.name && e.pass == nc.pass)) deletePlayer(nc.name, nc.pass); flag1 = false
            case "N" => nc.ps.println("Resume playing with this user?")
              userInput.readLine().capitalize.head.toString match {
                case "Y" => nc.ps.println("enter password: ");
                  nc.pass = userInput.readLine();
                  if (clientList.exists(e => e.name == nc.name && e.pass == nc.pass)) {
                    var client: Client = clientList.find(e => e.name == nc.name && e.pass == nc.pass).get
                    nc.curRoom = client.curRoom
                    nc.usrLvl = client.usrLvl
                    nc.character = client.character
                    flag = false;
                    flag1 = false
                  } else nc.ps.println("wrong password")
                case "N" => nc.ps.println("enter username: "); nc.name = userInput.readLine(); flag1 = false
                case _ => null
              }
            case _ => null
          }
        }
      }
      if (flag1 == true) nc.ps.println("enter password: ")
      if (flag1 == true) nc.pass = userInput.readLine()
      if (flag == true) {
        nc.ps.println("What character type would you like to be?")
        nc.ps.println("[1] KNIGHT\n[2] WIZARD\n[3] JEDI\ntype help racename for a character description (e.g. help knight)")

        while (flag2) {
          userInput.readLine() match {
            case "1" => nc.character = createPlayer.apply("KNIGHT"); flag2 = false
            case "2" => nc.character = createPlayer.apply("WIZARD"); flag2 = false
            case "3" => nc.character = createPlayer.apply("JEDI"); flag2 = false
            case "help knight" => nc.ps.println(characterArray(0).charClass.toString())
            case "help Knight" => nc.ps.println(characterArray(0).charClass.toString())
            case "help KNIGHT" => nc.ps.println(characterArray(0).charClass.toString())
            case "help wizard" => nc.ps.println(characterArray(3).charClass.toString())
            case "help Wizard" => nc.ps.println(characterArray(3).charClass.toString())
            case "help WIZARD" => nc.ps.println(characterArray(3).charClass.toString())
            case "help jedi" => nc.ps.println(characterArray(7).charClass.toString())
            case "help Jedi" => nc.ps.println(characterArray(7).charClass.toString())
            case "help JEDI" => nc.ps.println(characterArray(7).charClass.toString())
            case _ => null
          }
        }

        nc.ps.println("Welcome, " + nc.name + ". So you're decided to become a " + nc.character.charClass.toString.toLowerCase.capitalize + "? Well, you should know that every good " + nc.character.charClass.toString.toLowerCase.capitalize + " begins as a " + nc.character.name + "! A long and strenous journey awaits you, you better rest before you begin.")
        nc.ps.println("Would you like some instructions on how to play the game?")
        userInput.readLine().capitalize.head.toString match {
          case "Y" => instructions.run(nc)
          case _ => null
        }
        flag = false
      }

    }
    nc
  }

  //  def storePlayers(clients: ArrayBuffer[Client]) {
  //
  //  	for (c <- clients) clientList.append(c)
  //
  //  	xml.XML.save("players.xml", <element>{clientList.map(_.toXML)}</element>)
  //    }
  //
  //  def deletePlayer(userName:String,password:String) {
  //
  //   var del = clientList.find(e => e.name==userName && e.pass==password).get
  //   clientList -= del
  //
  //    }
  //
  //  // Way to create players and store them in collection
  //  // Way to delete Players
  //  // collections that log interactions between players
}

*/