package com.example

import akka.actor.Actor

/**
 * Created by Addison on 9/14/2015.
 */
class ChatClient(val name: String) {
  val chat = Actor.remote.actorFor("chat:service", "localhost", 2552)

  def login                 = chat ! Login(name)
  def logout                = chat ! Logout(name)
  def post(message: String) = chat ! ChatMessage(name, name + ": " + message)
  def chatLog               = (chat ? GetChatLog(name)).as[ChatLog]
                              .getOrElse(throw new Exception("Couldn't get the chat log from Server"))
}
