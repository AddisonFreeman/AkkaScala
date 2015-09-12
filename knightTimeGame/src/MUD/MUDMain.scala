package MUDGame

    import scala.collection.mutable
    import scala.collection.mutable._
    import java.io._
    import java.net._
    import scala.actors.Actor._
    //better formatting for user chat
    //Write and read users to xml
    //regex password matching
    //get all of menu to work
    //start item collections
    //Console map editor
    //connections other than telnet
    object MUDMain {
      def main(args: Array[String]): Unit = {
        ServerClass.startServer(3030)
  }
}