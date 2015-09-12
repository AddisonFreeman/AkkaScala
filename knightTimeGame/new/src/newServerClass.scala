/**
 * Created by addison.freeman on 7/17/2014.
 */

import java.net._
import java.io._

object newServerClass {
 var playerCount = 0
 def startServer(port:Int) {
     val server = new ServerSocket(port)
     while(true) {
         val socket = server.accept()
         playerCount += 1
         println("player number "+playerCount+" accepted to game")
     }
 }
}
