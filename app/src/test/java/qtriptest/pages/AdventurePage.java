package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindAll;

public class AdventurePage {

    RemoteWebDriver driver;

    @FindBy(id="duration-select")
    WebElement select_hours;

    @FindBy(xpath = "(//div[contains(text(),'Clear')])[1]")
    WebElement hours_clear;


    @FindBy(xpath = "//*[@id='category-select']")
    WebElement select_category;

    @FindBy(xpath = "(//div[contains(text(),'Clear')])[2]")
    WebElement select_category_clear;

    @FindAll({
        @FindBy(xpath ="//*[@id='data']/div"),
        @FindBy(xpath ="//*[@id='data']")
     })
    List<WebElement> adventureContents;

    @FindBy(id = "search-adventures")
    WebElement search_adventure;

    @FindBy(xpath = "//div[@class='col-6 col-lg-3 mb-4']")
    WebElement select_adventure;

    public AdventurePage(RemoteWebDriver driver){
        this.driver=driver;
        AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver,  10);
        PageFactory.initElements(ajax, this);
    }

   public void setDurationFilter(String DurationFilter ){
    try{
        Select sel= new Select(select_hours);
        sel.selectByVisibleText(DurationFilter);
        Thread.sleep(2000);
        select_hours.click();

    }catch(Exception e){
        System.out.println(e);
    }
}

public void clearHours(){
    hours_clear.clear();
}

public void searchAdventure(String AdventureName ) throws InterruptedException
{
    Thread.sleep(3000);
    search_adventure.sendKeys(AdventureName);
   
}
 public void clickAdventure() throws InterruptedException{
    Thread.sleep(3000);
    select_adventure.click();
    
 }


    public void setCatrgoryFilter(String Category_Filter){
        try{
        Select sel2= new Select(select_category);
        sel2.selectByVisibleText(Category_Filter);
        Thread.sleep(2000);
        select_category.click();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void clearCategory(){
        select_category_clear.clear();
    }
   
public Boolean verifyAdventureContents(String filteredResult) {
    try {
        Integer actualResult = adventureContents.size();
        String result = actualResult.toString();
        if(result.equals(filteredResult)){
            return true;
        }
        return false;
    } catch (Exception e) {
        System.out.println("Exception while verifying adventure contents: " + e.getMessage());
        return true;
    }
}

}