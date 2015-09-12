/*package MUDGame

import scala.util.parsing._
import scala.Console._
import scala.collection.parallel.mutable._

//commPrefic = help, talk to, & go
//commSuffix = playerName, Room, direction

//command ::= simpleCommand | oneArgCommand | complexCommand
//simpleCommand ::= { [verb] + direction }
//oneArgCommand ::= { verb + item }
//complexCommand ::= { verb + item + description + item }

object commandParser extends JavaTokenParsers {
  def apply(com: String): (Client, buildRooms) => Unit = {
    this.parseAll(command, com).get
  }
  
  def command: Parser[(Client, buildRooms) => Unit] = {
    dir ^^ { case s: String => buildGo(s.capitalize.head.toString) } |
      moveComm ~> dir ^^ { case s: String => buildGo(s.capitalize.head.toString) } |
//      takeComm ~> obj ^^ { case s: String => buildTake(s) } |
//      swapComm ~> obj ^^ { case s: String => buildSwap(s) } |
      //": inventory".r ^^ { case _ => (c: Client, map: buildRooms) => c.ps.print(c.inventory(c.curRoom).itemName.toString+"\n") }  |
      //":" ~> tool ^^ { case => 
      """.*""".r ^^ { case r => (c: Client, map: buildRooms) => ServerClass.clients.foreach(e => e.ps.println(scala.Console.GREEN + c.name.toString + ": " + scala.Console.RESET + r.toString)) }

  }

  def dir: Parser[String] = "north" | "south" | "east" | "west" | "up" | "down" //doesn't work for NW,SW, etc...

  def moveComm: Parser[String] = "go ".r | "walk ".r | "move ".r | "travel ".r

  def takeComm: Parser[String] = "take ".r | "get ".r | "grab ".r
  
  def swapComm: Parser[String] = "give ".r | "drop ".r | "trade ".r | "swap ".r | "trade for ".r
  
  def tool: Parser[String] = " map"//watch this plus sign

  def obj: Parser[String] = "Sword".r | "Gun".r | "Chess Piece".r | "Flower Pot".r | "Kitchen Knife".r | "Skewer".r | "Atlas".r | "First-Aid Kit".r
  
  def buildGo(dir: String): (Client, buildRooms) => Unit = (c, map) => {
    val dirIndex = map.rooms(c.curRoom).exits.indexWhere(_.exitDir == dir)
    if (dirIndex < 0) {
      c.ps.println("I'm sorry dave, I can't let you do that")
    } else {
      c.curRoom = map.rooms(c.curRoom).exits(dirIndex).destination
    }
//  }
//
//  def buildTake(objName: String): (Client, buildRooms) => Unit = (c, map) => {
//    if(ServerClass.mapRooms.items(c.curRoom).itemName==objName) {
//      c.item = (ServerClass.mapRooms.items(c.curRoom))
//      c.ps.println(c.item.itemName)
//      ServerClass.mapRooms.items(c.curRoom)=new Item("Nothing", "Nothing", 0)
//    }
//  }
//  
//    def buildSwap(objName: String): (Client, buildRooms) => Unit = (c, map) => {//swap or drop
//      if(c.item==null) c.ps.println("you can't trade an item you don't have!")
//     else {
//      var playerItem = c.item
//        if(ServerClass.mapRooms.items(c.curRoom).itemName!="Nothing") {
//            var roomItem = ServerClass.mapRooms.items(c.curRoom)
//            c.item=roomItem
//            ServerClass.mapRooms.items(c.curRoom)=playerItem     
//        } else {
//          ServerClass.mapRooms.items(c.curRoom)=playerItem
//          c.item=null
//        }
//  }
//    }
//}
  }
}
/*
  def programUnit(l:List[String]): List[Any] = l match {
    case Nil => Nil
    case "go" :: e => programUnit(expression(e))
    case "talk" :: e => programUnit(expression(e))
    case "help" :: e => programUnit(expression(e))
    case x => throw new Exception("Expected 'print' or end of input but found "+x)
  }

  def expression(l:List[Any]): List[String] = l match {
    case Nil => throw new Exception("Expected number but found end of input");
    case "east" :: e => "east"
    case "south" :: e => "south"
    case "west" :: e => "west"
    case "north" :: e => "north"
    case x => x
*/
*/