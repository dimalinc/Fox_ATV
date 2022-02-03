package browser;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public  class Wait {

   public WebDriverWait getWait() {
      WebDriverWait wait  = null;
      try {
          wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(8));
      } catch (Exception e) {e.printStackTrace();}

      return wait;
   }

/*   private void waitUntilSelectOptionsPopulated(final Select select) {
      new FluentWait<WebDriver>(driver)
              .withTimeout(60, TimeUnit.SECONDS)
              .pollingEvery(10, TimeUnit.MILLISECONDS)
              .until(new Predicate<WebDriver>() {
                 public boolean apply(WebDriver d) {
                    return (select.getOptions().size() > 1);
                 }
              });
   }*/
}
