package com.braxisltd.thinweb

import unfiltered.jetty.{ContextBuilder, Http}
import java.net.URL
import unfiltered.filter.Plan
import unfiltered.request._
import net.liftweb.json.Printer._
import net.liftweb.json.JsonAST._
import net.liftweb.json.JsonDSL._
import unfiltered.response.Ok
import net.liftweb.json.JsonParser._
import unfiltered.response.ResponseString
import java.util

class PersonService extends Plan {
  implicit val formats = net.liftweb.json.DefaultFormats

  val persons = scala.collection.mutable.Map[String, Person]()

  def intent = {
    case GET(Path("/persons")) =>
      val withIds = for ((id, person) <- persons) yield {
        ("id" -> id) ~ ("firstname" -> person.firstname) ~ ("lastname" -> person.lastname)
      }
      val json = pretty(render(withIds))
      ResponseString(json)
    case req@POST(Path("/persons")) =>
      persons(util.UUID.randomUUID().toString) = parse(Body.string(req)).extract[Person]
      Ok
  }
}

case class Person(firstname: String, lastname: String)

object PersonService {

  var http: Http = null

  def main(args: Array[String]) {
    start()
  }

  def start() {
    http = Http.local(8081)
    http.context("/public") {
      ctx: ContextBuilder =>
        ctx.resources(new URL("file:///C:/Users/Darren/IdeaProjects/thin-web/public"))
    }.filter(new PersonService).start()
  }

  def stop() {
    http.stop()
  }

}