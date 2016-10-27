/* NOTES
 * 1: If the program is running in the background, never minimize the browser. Just click another application to run on top of it.
 * 2: For "collect mode" set the if statement after the prompts to if(d<200) and un-comment Thread.Sleep(1000000).
 * 3: When going to chip links make sure you're logged out of facebook everywhere on you're comp.
 * 4: When not at home and on a slow network, the app and game will probably both require an additional 10-15s to load
 * 5: Took about 3.5 hours to get 1000 LP , but that was with pretty low bets
 */
/*TO DO:
 * 1: Zoom out window to allow all buildings to be clicked
 * 2: Create exception for if internet stops or if facebook has error.
 */
package myVegas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class Run {
 
	public static void main(String[] args) throws InterruptedException {
		
		
	for(int d=0; d<300; d++)//run program d<___ times
	{
		//One "Play" session = 5m 15s
		//One "Collect" session = ???
		
		System.out.println("Session " +d+ " of 300 starting...");
		
		System.setProperty("webdriver.chrome.driver", "C://Users/Thomas/Desktop/Java/chromedriver.exe");
		
	    WebDriver driver = new ChromeDriver();
		
		
        //Launch the Online Store Website
		driver.get("https://apps.facebook.com/playmyvegas/?fb_source=bookmark&ref=bookmarks&count=0&fb_bmpos=_0");
 
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website");

        
        String fName="the_tominator123@hotmail.com";
        String lName="********";
    
 
        WebElement element_enter = driver.findElement(By.xpath("//*[@id='email']"));
        element_enter.findElement(By.xpath("//*[@id='email']")).sendKeys(fName);
        
        
        WebElement element_enter2 = driver.findElement(By.xpath("//*[@id='pass']"));
        element_enter.findElement(By.xpath("//*[@id='pass']")).sendKeys(lName);
        
        element_enter2.sendKeys(Keys.RETURN); // this will result in the return key 
        									 //being pressed upon the text field
        
        //This breaks program:
        //Thread.sleep(5000);
        //Facebook security check fail:
        //element_enter.findElement(By.xpath("//*[@id='pass']")).sendKeys(lName); 
        //element_enter2.sendKeys(Keys.RETURN);
        //System.out.println("Failed Security Check handle");
        
        Thread.sleep(45000);
        System.out.println("Waited 45 seconds for myVegas to load");
       
        WebElement imageSpan = driver.findElement(By.className("_2md"));
        Actions actions = new Actions(driver);
        
        
        		//Prompt 1
        		clickHere(imageSpan, driver, 647, 224);//Perfect coords
        		System.out.println("Clicked prompt 1");		
        		Thread.sleep(3000);
        		
        		//Prompt 2
        		clickHere(imageSpan, driver, 628, 217);//had to adjust y value for some reason
        		System.out.println("Clicked prompt 2");
        		Thread.sleep(3000);
        		
        		//Prompt 3
        		clickHere(imageSpan, driver, 666, 176);//had to adjust y value for some reason
        		System.out.println("Clicked prompt 3");
        		Thread.sleep(5000);
        		
        		//Prompt 4
        		clickHere(imageSpan, driver, 381, 517);//Perfect coords
        		System.out.println("Clicked prompt 4");
        		Thread.sleep(3000);
        		
        		
        		if(d<0){//PLAY MODE: d%5==0 run collect() every 5 play sessions and comment out Thread.sleep(1000000)
        				   //COLLECTION MODE: Change to d<200 AND un-comment Thread.sleep(1000000) go to line ___ to turn on "Collect mode"
        			System.out.println("Collect mode on; callin collect()");
        			collect(imageSpan, driver);
        			continue;
        		}
        	      		
        		
        		//Play Excalibur
        		clickHere(imageSpan, driver, 129, 678);//Perfect coords
        		System.out.println("Clicked play X Caliber");
        		        		
        		Thread.sleep(40000);
        		System.out.println("Waited 40 seconds for Excalibur to load");
        		

        		
	        		//lower bet to min (play 60)
        		int count = 0; 
        		while(count<20){
        			clickHere(imageSpan, driver, 315, 628);
	        		System.out.println("Lower bet");
	        		count++; 
	        		Thread.sleep(200);
        		}
        		
        			//increase to ...
        		clickHere(imageSpan, driver, 399, 629);
        		clickHere(imageSpan, driver, 399, 629);
        		clickHere(imageSpan, driver, 399, 629);
        		System.out.println("Increased bet thrice");
        		
        		
        			//click auto spin
        			clickHere(imageSpan, driver, 524, 628);
	        		System.out.println("Clicked auto spin start");
	        		
	        		Thread.sleep(2000);
	        		
	        		//select 50 auto spins
	        		clickHere(imageSpan, driver, 526, 570);
	        		System.out.println("Selected 50 auto spins *");
	        		
	        		Thread.sleep(10000);
	        		
	        		//Click Not Now
	        		clickHere(imageSpan, driver, 637, 522);//Perfect coords
	        		System.out.println("Clicked not now");

	        		//every 15s do prompt sweep
	        		for(int z=0; z<26; z++)
	        		{
	        			System.out.println("waiting 15s");
		        		Thread.sleep(15000);
		        		System.out.println("Prompt sweep "+(z+1)+" of 26");
		        		exitCommonPrompts(imageSpan, driver);
	        		}

        
        /* MY TESTER (NEEDS PAGE RULER)
        for(int a = 0; a<25; a++)
        {  	
        	for(int i = 0; i<25; i++)
        	{
        		actions.moveToElement(imageSpan, (619), (196));
        		actions.click();
        		actions.perform();
        		System.out.println("click");
        	}
        }
        */
        
        System.out.println("Done");
        
        driver.close();
        Thread.sleep(3000);
        System.out.println("Session finished. Restarting...");
    
}//close for

System.out.println("Program finished...");
}//close main
	
	public static void clickHere (WebElement imageSpanTemp, WebDriver temp, int X, int Y){
		
		WebElement imageSpan = temp.findElement(By.className("_2md"));
		Actions actionsTemp = new Actions(temp);
		
		X-=16;	
		Y-=9;
	
		
		actionsTemp.moveToElement(imageSpan, (X), (Y));
		actionsTemp.click();
		actionsTemp.perform();
	}
	
	
public static void exitCommonPrompts (WebElement imageSpanTemp, WebDriver temp) throws InterruptedException{
		
		WebElement imageSpan = temp.findElement(By.className("_2md"));
		Actions actionsTemp = new Actions(temp);
		
		//Date Knight WINNER: Don't share Aug. 18, 2016 still not working! Changed (-10, -5)=NOW FIXED!
		actionsTemp.moveToElement(imageSpan, (497), (272));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\t***Date Knight WINNER! Don't share***");
		Thread.sleep(1000);
		
		//Need more chips
		actionsTemp.moveToElement(imageSpan, (670), (250));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tNeed more chips");
		
		//Jackpot!: Don't share
		actionsTemp.moveToElement(imageSpan, (339), (523));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tJackpot! Don't share");
		
		
		//Congrats! Free Spin Win: Don't share...THOUGHT DEFAULT WAS SHARE, BUT IT'S ACTUALLY NOT SHARE... 
		//clickHere(imageSpan, temp, 312, 488);
		clickHere(imageSpan, temp, 364, 509);
		System.out.println("\tCongrats: Free Spin Win OK");
		
		
		//Close Date Knight Winner
		actionsTemp.moveToElement(imageSpan, (521), (240));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tClose Date Knight Winner");
		
		//Click Not Now
		actionsTemp.moveToElement(imageSpan, (653), (531));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tClicked not now");
	
		//Send Gifts
		actionsTemp.moveToElement(imageSpan, (633), (140));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tSend Gifts Prompt");
		
		//Choose Winner
		actionsTemp.moveToElement(imageSpan, (637), (522));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tChoose Winner Prompt");
		
		//Another Choose Winner
		actionsTemp.moveToElement(imageSpan, (306), (500));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\t2nd Choose Winner Prompt");
		
		//Fight Night WINNER: OK
		actionsTemp.moveToElement(imageSpan, (370), (552));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tFight/Date Night WINNER: OK");
		
		//Congratulations! Free spin win 
		actionsTemp.moveToElement(imageSpan, (349), (526));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tCongratulations: Free Spin Win Total... *CHANGED*");
		
		//Free Rewards
		actionsTemp.moveToElement(imageSpan, (642), (194));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tFree Rewards");
		
		//Level Up
		actionsTemp.moveToElement(imageSpan, (456), (477));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("\tLevel up A(?)");
		
		//Lets Build It
		clickHere(imageSpan, temp, 478, 593); 
		System.out.println("\tLets Build it **used clickHere");
		
		//New Level Up
		actionsTemp.moveToElement(imageSpan, (425), (545));
		actionsTemp.click();
		actionsTemp.perform(); 
		System.out.println("\tLevel up (B?)");
		
		//Jackpot!: OKAY
		actionsTemp.moveToElement(imageSpan, (423), (563));
		actionsTemp.click();
		actionsTemp.perform(); 
		System.out.println("\tJackpot!: OKAY");
		
		//Level Up C
		actionsTemp.moveToElement(imageSpan, (621), (241));
		actionsTemp.click();
		actionsTemp.perform(); 
		System.out.println("\tLevel up C(?)");
			
	}//close exitCommonPrompts


public static void collect (WebElement imageSpanTemp, WebDriver temp)throws InterruptedException{
	
	WebElement imageSpan = temp.findElement(By.className("_2md"));
	Actions actionsTemp = new Actions(temp);
	
	
	//Close Games
	actionsTemp.moveToElement(imageSpan, (702), (94));
	actionsTemp.click();
	actionsTemp.perform();
	System.out.println("Clicked Close Games");
	Thread.sleep(7000);

	//Monte Carlo
	actionsTemp.moveToElement(imageSpan, (387), (547));
	actionsTemp.click();
	actionsTemp.perform();
	System.out.println("Clicked Monte Carlo");
	Thread.sleep(500);
	
	//Monte Carlo 2
		actionsTemp.moveToElement(imageSpan, (387), (547));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("Clicked Monte Carlo");
		Thread.sleep(500);
		
			//Monte Carlo 3
			actionsTemp.moveToElement(imageSpan, (387), (547));
			actionsTemp.click();
			actionsTemp.perform();
			System.out.println("Clicked Monte Carlo");
			Thread.sleep(500);
	

	
	
	temp.manage().window().maximize();
	Thread.sleep(2000);
	
	//New York New York
	actionsTemp.moveToElement(imageSpan, (1123), (324));
	actionsTemp.click();
	actionsTemp.perform();
	System.out.println("Clicked NY NY");
	Thread.sleep(500);
	
		//New York New York 2
		actionsTemp.moveToElement(imageSpan, (1123), (324));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("Clicked NY NY");
		Thread.sleep(500);
	
			//New York New York 3
			actionsTemp.moveToElement(imageSpan, (1123), (324));
			actionsTemp.click();
			actionsTemp.perform();
			System.out.println("Clicked NY NY");
			Thread.sleep(500);
			
			
	//Gas Station
	actionsTemp.moveToElement(imageSpan, (1025), (87));
	actionsTemp.click();
	actionsTemp.perform();
	System.out.println("Gas Station");
	Thread.sleep(500);
	
		//Gas Station
		actionsTemp.moveToElement(imageSpan, (1025), (87));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("Gas Station");
		Thread.sleep(500);
	
			//Gas Station
			actionsTemp.moveToElement(imageSpan, (1025), (87));
			actionsTemp.click();
			actionsTemp.perform();
			System.out.println("Gas Station");
			Thread.sleep(500);
			
	
	//Restaurant
	actionsTemp.moveToElement(imageSpan, (1272), (196));
	actionsTemp.click();
	actionsTemp.perform();
	System.out.println("Restaurant");
	Thread.sleep(500);
	
		//Restaurant
		actionsTemp.moveToElement(imageSpan, (1272), (196));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("Restaurant");
		Thread.sleep(500);
			
			//Restaurant
			actionsTemp.moveToElement(imageSpan, (1272), (196));
			actionsTemp.click();
			actionsTemp.perform();
			System.out.println("Restaurant");
			Thread.sleep(500);
			
	
	//Mirage
	actionsTemp.moveToElement(imageSpan, (609), (78));
	actionsTemp.click();
	actionsTemp.perform();
	System.out.println("Mirage");
	Thread.sleep(500);
	
		//Mirage
		actionsTemp.moveToElement(imageSpan, (609), (78));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("Mirage");
		Thread.sleep(500);
	
			//Mirage
			actionsTemp.moveToElement(imageSpan, (609), (78));
			actionsTemp.click();
			actionsTemp.perform();
			System.out.println("Mirage");
			Thread.sleep(500);
			
			
	//Circus Circus
	actionsTemp.moveToElement(imageSpan, (160), (309));
	actionsTemp.click();
	actionsTemp.perform();
	System.out.println("Circus Circus");
	Thread.sleep(500);
	
		//Circus Circus
		actionsTemp.moveToElement(imageSpan, (160), (309));
		actionsTemp.click();
		actionsTemp.perform();
		System.out.println("Circus Circus");
		Thread.sleep(500);
	
			//Circus Circus
			actionsTemp.moveToElement(imageSpan, (160), (309));
			actionsTemp.click();
			actionsTemp.perform();
			System.out.println("Circus Circus");
			Thread.sleep(500);
			
	Thread.sleep(15000);
	for(int i=0; i<8; i++){ System.out.println(16 - 2*i + " minutes until restart"); Thread.sleep(120000); }
	
			

			
	//Close and restart
	System.out.println("Done collecting chips. Restarting...");
	temp.close();
	return;
	
}//close collect


	
}//close class
