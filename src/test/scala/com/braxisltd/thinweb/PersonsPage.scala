package com.braxisltd.thinweb

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.{PageFactory, FindBy}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.scalatest.matchers.ShouldMatchers


class PersonsPage(driver:WebDriver) extends ShouldMatchers{
  import scala.collection.JavaConverters._

  @FindBy(id = "firstName")
  var firstName:WebElement = null
  @FindBy(id = "lastName")
  var lastName:WebElement = null
  @FindBy(id = "submit")
  var submit:WebElement = null
  @FindBy(id = "persons")
  var personTable:WebElement = null

  PageFactory.initElements(driver, this)

  def submitPerson(first:String, last:String):PersonsPage = {
    val originalPersonCount = persons.size
    firstName.clear()
    firstName.sendKeys(first)
    lastName.clear()
    lastName.sendKeys(last)
    submit.click()
    new WebDriverWait(driver, 5).until(new ExpectedCondition[Boolean] {
      override def apply(d: WebDriver) = persons.size > originalPersonCount
    })
    this
  }

  def assertPersonPresent(first:String, last:String):PersonsPage = {
    val numberOfMatchedRows = driver.findElements(By.xpath("//table[@id='persons']/tbody/tr[td[@class='firstName']='%s' and td[@class='lastName']='%s']" format(first, last))).size()
    numberOfMatchedRows should (be >= 1)
    this
  }

  def persons:List[WebElement] = personTable.findElements(By.tagName("tr")).asScala.toList

}
