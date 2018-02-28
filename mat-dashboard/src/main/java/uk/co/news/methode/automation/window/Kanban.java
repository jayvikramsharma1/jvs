package uk.co.news.methode.automation.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import uk.co.news.methode.automation.container.UUID;

public class Kanban extends BaseWindow{

	By SEARCH_QUERY = By.xpath("input[@validate-query='searchSource']");
	
	public WebDriver driver;
	
	public void init_Browser() throws Exception{
		driver = new ChromeDriver();
		Thread.sleep(INTERVAL);
		driver.get("http://nu-omnis-plus-si-elasticsearch.cps-dev.ntch.co.uk/_plugin/kibana/#/discover?_g=(refreshInterval:(display:Off,section:0,value:0),time:(from:now-1d%2Fd,mode:quick,to:now-1d%2Fd))&_a=(columns:!(_source),index:%5Bnotification-%5DYYYY-MM-DD,interval:auto,query:(query_string:(analyze_wildcard:!t,query:'*')),sort:!(timestamp,desc))");
		Thread.sleep(INTERVAL);
		driver.manage().window().maximize();
	}
	
	public boolean kanbanSearchBoxIsDispalyed() throws Exception{
		try{
			driver.findElement(SEARCH_QUERY).isDisplayed();
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	
	public void enterUUID() throws Exception{
		driver.findElement(SEARCH_QUERY).click();
		Thread.sleep(INTERVAL);
		driver.findElement(SEARCH_QUERY).clear();
		Thread.sleep(INTERVAL);
		driver.findElement(SEARCH_QUERY).sendKeys(UUID.getEditionUUID());
		Thread.sleep(INTERVAL);
		driver.findElement(SEARCH_QUERY).submit();
	}
	
}
