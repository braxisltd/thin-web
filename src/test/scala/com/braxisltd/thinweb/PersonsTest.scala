package com.braxisltd.thinweb

import org.scalatest.{FlatSpec, BeforeAndAfterAll}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.WebDriver

class PersonsTest extends FlatSpec with BeforeAndAfterAll {

  var driver = new ChromeDriver()

  override protected def beforeAll() {
    PersonService.start()
  }

  override protected def afterAll() {
    PersonService.stop()
    driver.close()
  }

  "The persons page" should "update when a new person is saved" in {
    driver.get("http://localhost:8081/public/persons.html")
    new PersonsPage(driver)
      .submitPerson("Darren", "Ballinger")
      .submitPerson("Gemma", "Ballinger")
      .assertPersonPresent("Darren", "Ballinger")
      .assertPersonPresent("Gemma", "Ballinger")
  }
}
