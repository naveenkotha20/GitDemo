
package com.tijori.main;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class Test {
	String DY="";
	public String getdivy(String stock) throws InterruptedException
	{
		
	        // declaration and instantiation of objects/variables
	    	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");

			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("default");
			 
		    FirefoxOptions options=new FirefoxOptions().setProfile(myprofile);
		    WebDriver driver = new FirefoxDriver(options);
		    driver = new FirefoxDriver(options);
	    	//options.setProfile(profile);
	       	//comment the above 2 lines and uncomment below 2 lines to use Chrome
			//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
	        String baseUrl = "https://tijorifinance.com";
			// * String expectedTitle = "Welcome: Mercury Tours"; String actualTitle = "";
	        // launch Fire fox and direct it to the Base URL
	        driver.get(baseUrl);
	        
	        driver.findElement(By.xpath("//input[@id='companySearch']")).sendKeys(stock);
	        Thread.sleep(5000);
	        try
	        {

	        driver.findElement(By.xpath("//div[@class='textboxy']/div[@id='resultsscompanySearch']/descendant::div[@class='autocomplete-suggestion autocomplete-selected']")).click();
	        }
	        catch(Exception e)
	        {
	        	
	        }
	        // get the actual value of the title
	        /*
	         * compare the actual title of the page with the expected one and print
	         * the result as "Passed" or "Failed"
	         */
	    
	        int rating=0;
	        List<Integer> list = new ArrayList<Integer>();
	      //  as.numeric(sub(",", ".", list, fixed = TRUE))
	      //td[.='Net Sales']/parent::tr/td[2]/following-sibling::td
	      //td[.='Sales']/parent::tr/td[2]/following-sibling::td
	        
	        String url=driver.getCurrentUrl();
	        driver.get(url+"#bs");
	        driver.navigate().refresh();

	        Thread.sleep(5000);
	  List<WebElement> aa=    driver.findElements(By.xpath("//td[.='Dividend Yield (%)']/parent::tr/td[2]/following-sibling::td"));
	  int count=aa.size();
	  System.out.println("count of elements "+count);
	  int j=0;
	Thread.sleep(5000);
	  for(WebElement selectLi: aa)
	  {
		 		  if (selectLi.isDisplayed())
		  {
			  //System.out.println(selectLi.getAttribute("innerText"));
		  System.out.println(selectLi.getAttribute("innerText"));
		  String str1 = selectLi.getAttribute("innerText").replaceAll(",", ""); 
		  
		  try {
			  
		
		  int val=Integer.parseInt(str1);
		  list.add(val);
		  }
		  
		  catch (Exception e)
		  {
		//list.add()	
			  
			  double d = Double.parseDouble(str1);
			  int val=(int) d;
			  list.add(val);
		  }
		  finally {
			
		}
		
		  }
		  
		 
	 
	  
		  j++;      

	  }
	  
	 //as.numeric(sub(",", ".", Input, fixed = TRUE));

	 System.out.println("PRINT SIZE "+list.size());
	 for (int k=0;k<list.size()-1;k++)
	 {
			
		
		 System.out.println("entered1");
		 /*
			 * if (k==list.size()-1) { System.out.println("test"); }
			 */
		 System.out.println("k value"+k);
		 System.out.println("K+1 value"+k+1);
		 
		 int ele1=list.get(k);
		 int ele2=list.get(k+1);
		 System.out.println("ele1"+ele1);
		   if (ele1==0 && ele1<ele2 && k==list.size()-2 )
	       {
	    	  
			   System.out.println("printing K"+k+"printing k+1"+k+1);
			   System.out.println("entered"+stock);
	DY=stock;
	    	   
			   rating++;
	    	   
	    	//   System.out.println("points " +rating);
	    	   if(k>1)
	    	   {
	    		//   Toolkit.getDefaultToolkit().beep();
	    	   }
	    	   
	    	   
	       }
	          
		 
		 if (list.get(k+1)>list.get(k))
	       {
	    	   rating++;
	    	   
	    	//   System.out.println("points " +rating);
	       }
	       
	    
	       
	       else
	       {
	    	 //  System.out.println("----ve rate");
	       }
	       
	    }
	 driver.close();
	return DY;
		}	
	public static void main(String[] args) throws InterruptedException {
//		Test obj=new Test();
//		obj.getdivy(null);
	
	}
	}
    
