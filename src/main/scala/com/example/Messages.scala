package com.example

/**
 * Created by Addison on 9/14/2015.
 */
sealed trait Event
case class Login(user: String) extends Event
case class Logout(user: String) extends Event
case class ChatMessage(name: String, message: String) extends Event
case class GetChatLog(from: String) extends Event
case class ChatLog(log: List[String]) extends Event