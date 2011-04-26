package pages

import org.jbehave.web.selenium.WebDriverProvider
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.jbehave.web.selenium.LazyWebDriver

class AdvancedSearch extends BasePage{

  def AdvancedSearch(LazyWebDriver lazyWebDriver) {
    super(lazyWebDriver)
  }

  def go() {
    get("http://www.etsy.com/search_advanced.php")
  }

  def go(String section) {
    go()
    findElement(By.xpath("//a[@title = '$section']")).click()
  }

  def search(String thing) {
    findElement(By.id("search-query")).sendKeys(thing)
    findElement(By.id("search_submit")).click()
  }

  def subCategory(String subCategory) {
    def select = findElement(By.className("handmade"))
    def List options = select.findElements(By.tagName("option"))
    for (int i = 0; i < options.size(); i++) {
      def WebElement o =  options.get(i);
      if (o.isSelected()) {
        o.setSelected()
      }
      if (o.getValue().equals(subCategory)) {
        o.setSelected()
        return
      }
    }
  }

  def searchFor(String thing) {
    def field = findElement(By.id("search_query"))
    field.sendKeys thing
    field.submit()
  }
}
