
package com.tijori.main;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class EPS {


	String DY = "";
public boolean maxsalesvalue(WebDriver driver)
{	boolean maxvalue=false; 
    List<Double> list3 = new ArrayList<Double>();// to store sales values
    List<WebElement> cc= driver.findElements(By.xpath("//td[@macro__name='Net Sales']/following-sibling::td"));
	  int count=cc.size();
	  int j=0;
		//Thread.sleep(10000);
	 
	  double lastele = 0; 
		
		int activeel=0;
		  for(WebElement selectLi: cc)
		  {
			 		  if (selectLi.isDisplayed())
			  {
				  //System.out.println(selectLi.getAttribute("innerText"));
			  System.out.println(selectLi.getAttribute("innerText"));
			  String str1 = selectLi.getAttribute("innerText").replaceAll(",", ""); 
			  activeel++;
			  
			  try {
				  
		
			  double val=Double.parseDouble(str1);
			  list3.add(val);
			
			  
			  System.out.println("method call"+list3.get(0));
				
				 // System.out.println("sum is "+sum);
			  }
			  
			  catch (Exception e)
			  {
			//list.add()	
				  
				  double d = Double.parseDouble(str1);
				 
				  list3.add(d);
			  }
			  finally {
				
			}
			
			  }
			  
			//  j++;      

		  }
		  int size=list3.size();
		  lastele=list3.get(size-1);
		  System.out.println("Last element is"+lastele);
		  for (int k=0; k<list3.size()-1;k++)
			 {
				 if (list3.get(k) >= lastele) {
			          maxvalue=false;
			          
			          break;
			    
			        }
				 else
				 {
					 maxvalue=true;					
				 }
				
			 }
		  System.out.println("MAX_______"+maxvalue);
		 // return maxvalue; 
		//return maxvalue;
		return maxvalue;
	
}
	public String getdivy(String stock, WebDriver driver) throws InterruptedException
	{
		
	        // declaration and instantiation of objects/variables

		
		  
			//	driver.manage().deleteAllCookies();

			//comment the above 2 lines and uncomment below 2 lines to use Chrome
			//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
	        String baseUrl = "https://www.tijorifinance.com/timeline/all";
	        
			// * String expectedTitle = "Welcome: Mercury Tours"; String actualTitle = "";
	        // launch Fire fox and direct it to the Base URL
	       
	        driver.get(baseUrl);
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //   Thread.sleep(5000);
	       // driver.findElement(By.xpath("//div[@class='searchiconhead']/i")).click();
	        
	      //  driver.findElement(By.xpath("//div[@class='searchiconhead']")).click();
	        
	        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(stock); 
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.BACK_SPACE);

	       Thread.sleep(1000);
	        try
	        {		  
	        	driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
	      //  driver.findElement(By.xpath("//strong[.='companies']/ancestor::div[@id]/div/div[2]/strong")).click();
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        	System.out.println("Test");
              return DY;
	        	
		}
	        // get the actual value of the title
	        /*
	         * compare the actual title of the page with the expected one and print
	         * the result as "Passed" or "Failed"
	         */
	    System.out.println("Entered");
	        int rating=0;
	        List<Double> list = new ArrayList<Double>();// to store eps values
	        //////////////////
	      //  as.numeric(sub(",", ".", list, fixed = TRUE))
	      //td[.='Net Sales']/parent::tr/td[2]/following-sibling::td
	      //td[.='Sales']/parent::tr/td[2]/following-sibling::td
	        
	        String url=driver.getCurrentUrl();
	 
	       // driver.get(url+"/financials/");
	        String ss=driver.getCurrentUrl();
	       
	        driver.navigate().refresh();
	        List<Double> list2 = new ArrayList<Double>();
	        //list 2 for storing book value
	       // Thread.sleep(7000);
	        String marketc;
	        marketc="";
	        try
	        {
	        	List<WebElement>mcap=driver.findElements(By.xpath("//div[@class='company_details_title']/following-sibling::div[@class='company_details_value']"));
	    		marketc=mcap.get(0).getText();
	        	System.out.println(marketc);
	            List<WebElement> fr=driver.findElements(By.xpath("//a[.='Financials']"));
		        fr.get(0).click();
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//a[@href='#cash_flow_analysis']")).click();
		        Thread.sleep(1000);
			       List<WebElement> ratio=driver.findElements(By.xpath("//a[.='Consolidated']/parent::li"));
                 ratio.get(5).click();
                 
                 
                 Thread.sleep(1000);
           	  List<WebElement> bb= driver.findElements(By.xpath("//tr[@myid='PricetoBook']/td"));
        	  int countbb=bb.size();
        	int   activepricetobook=0;
	        }
        	/*
        	int z=0;
        	  for(WebElement selectLi: bb)
        	  {
        		 		  if (selectLi.isDisplayed())
        		  {
        			  //System.out.println(selectLi.getAttribute("innerText"));
        		  System.out.println(selectLi.getAttribute("innerText"));
        		  String str1 = selectLi.getAttribute("innerText").replaceAll(",", ""); 
        		  activepricetobook++;
        		  
        		  try {
        			  
        		
        		  double val=Double.parseDouble(str1);
        		  list2.add(val);
        		  }
        		  
        		  catch (Exception e)
        		  {
        		//list.add()	
        			  
        			  double d = Double.parseDouble(str1);
        			 
        			  list2.add(d);
        		  }
        		  finally {
        			
        		}
        		
        		  }
        		  
        		  z++;  
				
					 * JavascriptExecutor js = (JavascriptExecutor) driver;
					 * js.executeScript("window.scrollBy(0,5000)", "");
					 
		 
	         
	        }
	        }*/
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        
	        
	        // driver.navigate().refresh();
	       // Thread.sleep(5000);
	      //td[@name='EPS_97N']/following-sibling::td[position()>1]
	        try
	        {
	        	
	            Thread.sleep(1000);
		        driver.findElement(By.xpath("//a[@href='#ratios']")).click();
		        Thread.sleep(1000);
		       List<WebElement> con=driver.findElements(By.xpath("//a[.='Consolidated']/parent::li"));
 
		    
		        con.get(6).click();		        
		      //  actions.release().perform(); 

 		      
	      //  driver.findElement(By.xpath("//a[@href='#quarterly_results']")).click();
	        Thread.sleep(2000);
	  List<WebElement> aa= driver.findElements(By.xpath("//td[@macro__name='EPS']/following-sibling::td"));
	  int count=aa.size();
	  System.out.println("count of elements "+count);
	  int j=0;
	//Thread.sleep(10000);
	  
	  
	  
	
	int activeel=0;
	  for(WebElement selectLi: aa)
	  {
		 		  if (selectLi.isDisplayed())
		  {
			  //System.out.println(selectLi.getAttribute("innerText"));
		  System.out.println(selectLi.getAttribute("innerText"));
		  String str1 = selectLi.getAttribute("innerText").replaceAll(",", ""); 
		  activeel++;
		  
		  try {
			  
		
		  double val=Double.parseDouble(str1);
		  list.add(val);
		  }
		  
		  catch (Exception e)
		  {
		//list.add()	
			  
			  double d = Double.parseDouble(str1);
			 
			  list.add(d);
		  }
		  finally {
			
		}
		
		  }
		  
		  j++;      

	  }
	  
	 //as.numeric(sub(",", ".", Input, fixed = TRUE));

	 System.out.println("PRINT SIZE "+list.size());
	 
	 double sum = 0;
	 double diff;
	 double values;
	 double diff1;
	 double diff2;

EPS obj=new EPS();
Boolean saleshighest=obj.maxsalesvalue(driver);
	
	
	 System.out.println("SALES HIGHEST"+saleshighest);
	 int size=list.size();
	 diff=Math.abs((list.get(list.size()-4))-(list.get(list.size()-3)));
	double diffp1=diff;
	
	 diff1=Math.abs((list.get(list.size()-3))-(list.get(list.size()-2)));
		double diffp2=diff1;
	 diff2=Math.abs((list.get(list.size()-2))-(list.get(list.size()-1)));
		double diffp3=Math.abs(diff2);

	 
	 
	 System.out.println("difference 1"+diff);
	 System.out.println("difference 2"+diff1);
	 System.out.println("difference 3"+diff2);
	 for (int k=list.size()-4; k<list.size()-1;k++)
	 {
		 System.out.println(list.get(k));
		 sum +=list.get(k);
		 
		 
	 }
	  System.out.println("sum is "+sum);
	 
	double average= sum / 3;
	
	
	System.out.println("-----------------------AVG--------------------------"+average);
	double lq=list.get(size-1);
	double tq=list.get(size-2);
	
	double pyq=list.get(size-5);
	System.out.println("last quarter is" +lq);
	System.out.println("avg is -----"+average);
	
	//double ptob=
	//		list2.get(size-1).g;
	// last quarter of price to book
	//pt
//	System.out.println("last quarter of price to book is"+ptob);
	
	double avgdiff= ((diffp1+diffp2)/2);
	
	
	if ( (((average>0) && (lq/average)>1.2 ) && (saleshighest)) || (( (saleshighest) && (list.get(list.size()-2))>0) && ((list.get(list.size()-1))>0) && ((diff2/diff1)>2) &&((list.get(list.size()-1))>(list.get(list.size()-2))) ))
	{
		double vals=(diffp3/diffp2);
		double ravg=lq/average;
		
	//	double realavg=
		System.out.println("******");
	
		   String mcapnumberOnly= marketc.replaceAll("[^0-9]", "");
		   System.out.println("numbers only is "+mcapnumberOnly);

		DY=stock+"?"+ravg+"?"+mcapnumberOnly;
	}
	
	else if(saleshighest)
	{
		System.out.println("highhhhhh"+saleshighest);
	}
	
	else if ((saleshighest) && ((lq>0) && (pyq>0) && (lq/tq)>=1.1 && (lq/pyq)>=1.25))
	{
		double yoy;
		yoy =lq/pyq;

		   String mcapnumberOnly= marketc.replaceAll("[^0-9]", "");
		   System.out.println("numbers only is --"+mcapnumberOnly);
		DY=stock+"?"+yoy+"?"+mcapnumberOnly;;
		
	}
/*	
if ((average>0) && (lq/average)>2)
{
 double vals=(lq/average);
	DY=stock+vals;
}*/
//driver.quit();

	return DY;
		
	        }
	        catch(Exception e)
	        {
	    		return DY;
	        }
	
	}

	public static void main(String[] args) throws InterruptedException {
//		Test obj=new Test();
//		obj.getdivy(null);

	}
}
