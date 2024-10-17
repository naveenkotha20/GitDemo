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
public class Earnings {


	String DY = "";
	String sname="";
public boolean maxsalesvalue(WebDriver driver)
{	boolean maxvalue=false; 
    List<Double> list3 = new ArrayList<Double>();// to store sales values
    
    List<WebElement> cc= driver.findElements(By.xpath("//section[@id='quarters']/descendant::button[1]/parent::td/following-sibling::td"));
	  int count;
	  count=cc.size();
	  if(count==0)
	  {
		cc=  driver.findElements(By.xpath("//section[@id='quarters']/descendant::button[2]/parent::td/following-sibling::td"));
		count=cc.size();
	  }
	  
	  if(count==0)
	  {
		cc=  driver.findElements(By.xpath("//section[@id='quarters']/descendant::button[3]/parent::td/following-sibling::td"));
		count=cc.size();

	  }
	  
	  
	  int j=0;
		//Thread.sleep(10000);
	 
	  double lastele = 0; 
		
		int activeel=0;
		  for(WebElement selectLi: cc)
		  {
			 		  if (selectLi.isDisplayed())
			  {
				  System.out.println("ENTERED MAX SALES EVAL");
			 			  
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
public int getdebttoeqvaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double dtoe = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='Debt to equity']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	dtoe= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	if (dtoe>=0 && dtoe<=0.01 )
	{
		i=10;
	}
	
	else if (dtoe>0.01 && dtoe<=0.05 )
	{
		i=9;
	}
	
	else if (dtoe>0.05 && dtoe<=0.1 )
	{
		i=8;
	}
	
	else if (dtoe>0.1 && dtoe<=0.2 )
	{
		i=7;
	}
	
	else if (dtoe>0.2 && dtoe<=0.3 )
	{
		i=6;
	}
	else if (dtoe>0.3 && dtoe<=0.4 )
	{
		i=5;
	}
	else if (dtoe>0.4 && dtoe<=0.5 )
	{
		i=4;
	}
	else if (dtoe>0.5 && dtoe<=0.6 )
	{
		i=3;
	}
	else if (dtoe>0.6 && dtoe<=0.7 )
	{
		i=2;
	}	
	else if (dtoe>0.7 && dtoe<=0.9 )
	{
		i=1;
	}
	else if (dtoe>1.0)
	{
		i=0;
	}
	else
	{
		i=0;
	}

	return i;
	
}
public int getpromopldegevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double promopldge = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='Pledged percentage']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	promopldge= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	if (promopldge>=0 && promopldge<=2 )
	{
		i=2;
	}
	
	else if (promopldge>2 && promopldge<=5 )
	{
		i=-1;
	}
	
	else if (promopldge>5 && promopldge<=10 )
	{
		i=-2;
	}
	
	else if (promopldge>11 && promopldge<=20 )
	{
		i=-3;
	}
	
	else if (promopldge>20 && promopldge<=30 )
	{
		i=-4;
	}
	else if (promopldge>30 && promopldge<=40 )
	{
		i=-5;
	}
	else if (promopldge>40 && promopldge<=60 )
	{
		i=-6;
	}
	else if (promopldge>60 && promopldge<=70 )
	{
		i=-7;
	}
	else if (promopldge>70 && promopldge<=80 )
	{
		i=-8;
	}	
	else if (promopldge>80 && promopldge<=90 )
	{
		i=-9;
	}
	else if (promopldge>90)
	{
		i=-10;
	}

	return i;
	
}
public int getpricetobookevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double pricetobook = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='Price to book value']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	pricetobook= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	if (pricetobook>0 && pricetobook<=0.3 )
	{
		i=20;
	}
	
	else if (pricetobook>0.3 && pricetobook<=0.5 )
	{
		i=16;
	}
	
	else if (pricetobook>0.5 && pricetobook<=1 )
	{
		i=14;
	}
	
	else if (pricetobook>1 && pricetobook<=1.5 )
	{
		i=10;
	}
	
	else if (pricetobook>1.5 && pricetobook<=3 )
	{
		i=8;
	}
	else if (pricetobook>3 && pricetobook<=10 )
	{
		i=7;
	}
	else if (pricetobook>10 && pricetobook<=15 )
	{
		i=6;
	}
	else if (pricetobook>15 && pricetobook<=20 )
	{
		i=5;
	}
	else if (pricetobook>20 && pricetobook<=30 )
	{
		i=3;
	}	
	else if (pricetobook>30 && pricetobook<=50 )
	{
		i=1;
	}
	else if (pricetobook>50)
	{
		i=0;
	}

	return i;
	
}

public int getroevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double roe = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='ROE']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	roe= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	 if (roe > 35) {
            i = 10;
        } else if (roe >= 30 && roe <= 35) {
            i = 9;
        } else if (roe >= 25 && roe < 30) {
            i = 8;
        } else if (roe >= 20 && roe < 25) {
            i = 7;
        } else if (roe >= 15 && roe < 20) {
            i = 6;
        } else if (roe >= 13 && roe < 15) {
            i = 5;
        } else if (roe >= 10 && roe < 13) {
            i = 4;
        } else if (roe >= 8 && roe < 10) {
            i = 3;
        } else if (roe >= 5 && roe < 8) {
            i = 2;
        } else if (roe > 0 && roe < 5) {
            i = 1;
        } else {
            i = 0;
        }

	return i;
	
}
public int getcratiovaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double cratio = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='Current ratio']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	cratio= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	 if (cratio > 5) {
            i = 5;
           
        } else if (cratio >= 3 && cratio <= 3.5) {
            i = 9;
        }else if (cratio >= 3.5 && cratio <= 5) {
            i = 8;
        } 
        else if (cratio >= 2.5 && cratio < 3.0) {
            i = 8;
        } else if (cratio >= 2.0 && cratio < 2.5) {
            i = 10;
        } else if (cratio >= 1.5 && cratio < 2.0) {
            i = 7;
        } else if (cratio >= 1.3 && cratio < 1.5) {
            i = 6;
        } else if (cratio >= 1.0 && cratio < 1.3) {
            i = 5;
        } else if (cratio >= 0.5 && cratio < 1.0) {
            i = 4;
        } else if (cratio >= 0.2 && cratio < 0.5) {
            i = 2;
        } else if (cratio > 0 && cratio < 0.2) {
            i = 1;
        } else {
            i = 0;
        }

	return i;
	
}
public int getrocevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double roce = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='ROCE']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	roce= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	 if (roce > 35) {
            i = 10;
        } else if (roce >= 30 && roce <= 35) {
            i = 9;
        } else if (roce >= 25 && roce < 30) {
            i = 8;
        } else if (roce >= 20 && roce < 25) {
            i = 7;
        } else if (roce >= 15 && roce < 20) {
            i = 6;
        } else if (roce >= 13 && roce < 15) {
            i = 5;
        } else if (roce >= 10 && roce < 13) {
            i = 4;
        } else if (roce >= 8 && roce < 10) {
            i = 3;
        } else if (roce >= 5 && roce < 8) {
            i = 2;
        } else if (roce > 0 && roce < 5) {
            i = 1;
        } else {
            i = 0;
        }

	return i;
	
}

public int getdivyvaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double divy = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='Dividend Yield']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	divy= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	 if (divy > 5) {
            i = 10;
        } else if (divy >= 4 && divy <5) {
            i = 9;
        } else if (divy >= 3.5 && divy < 4) {
            i = 8;
        } else if (divy >=3  && divy < 3.5) {
            i = 7;
        } else if (divy >= 2.5 && divy < 3) {
            i = 6;
        } else if (divy >= 2 && divy < 2.5) {
            i = 5;
        } else if (divy >= 1.5 && divy < 2)
		{
            i = 4;
        } else if (divy >=1 && divy < 1.5) {
            i = 3;
        } else if (divy >= 0.5 && divy < 1) {
            i = 2;
        } else if (divy > 0 && divy < 0.5) {
            i = 1;
        } else {
            i = 0;
        }

	return i;
	
}

public int getpegevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double peg = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='PEG Ratio']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	peg= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	if (peg>0 && peg<=0.3 )
	{
		i=20;
	}
	
	else if (peg>0.3 && peg<=0.5 )
	{
		i=16;
	}
	
	else if (peg>0.5 && peg<=1 )
	{
		i=14;
	}
	
	else if (peg>1 && peg<=1.5 )
	{
		i=10;
	}
	
	else if (peg>1.5 && peg<=3 )
	{
		i=9;
	}
	else if (peg>3 && peg<=5 )
	{
		i=8;
	}
	else if (peg>5 && peg<=15 )
	{
		i=6;
	}
	else if (peg>15 && peg<=20 )
	{
		i=5;
	}
	else if (peg>20 && peg<=30 )
	{
		i=3;
	}	
	else if (peg>30 && peg<=50 )
	{
		i=1;
	}
	else if (peg>50)
	{
		i=0;
	}

	return i;
	
}


public int getfcashevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
	Double fcash = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='CMP / FCF']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	fcash= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	if (fcash>0 && fcash<=2 )
	{
		i=20;
	}
	
	else if (fcash>2 && fcash<=5 )
	{
		i=16;
	}
	
	else if (fcash>5 && fcash<=10 )
	{
		i=14;
	}
	
	else if (fcash>10 && fcash<=15 )
	{
		i=10;
	}
	
	else if (fcash>15 && fcash<=20 )
	{
		i=9;
	}
	else if (fcash>20 && fcash<=25 )
	{
		i=8;
	}
	else if (fcash>25 && fcash<=30 )
	{
		i=6;
	}
	else if (fcash>30 && fcash<=35 )
	{
		i=5;
	}
	else if (fcash>35 && fcash<=40 )
	{
		i=3;
	}	
	else if (fcash>40 && fcash<=45 )
	{
		i=1;
	}
	else if (fcash>50)
	{
		i=0;
	}

	return i;
	
}
public String getcfoevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    int finalav=0;
	int pbts = 0;
	 StringBuilder sb = new StringBuilder("");

	try
	{
		List<WebElement> header=driver.findElements(By.xpath("//h1"));
		sname=header.get(1).getText();
	 
	 
		List<WebElement> nett=	driver.findElements(By.xpath("//section[@id='profit-loss']//tr/td[normalize-space(text())='EPS in Rs']/parent::tr/preceding-sibling::tr[1]/td"));
		int size=nett.size();
		
		List<WebElement> da=driver.findElements(By.xpath("//section[@id='profit-loss']//tr/td[normalize-space(text())='Depreciation']/following-sibling::td"));
	// int sizedt=dtax.size();
		List<WebElement> wcc=driver.findElements(By.xpath("//td[normalize-space(text())='Working capital changes']/following-sibling::td"));
        int wccsize=wcc.size();
		int sizeda=da.size();
		int counter=0;
		
		Double dtavg=0.0;
		String CFOALL="";
		
		int totalgreater=0;
		for(int i=0;i<sizeda-2;i++)
	{
		String datext= da.get(sizeda-i-1).getText().replaceAll(",", "");
		System.out.println("DA"+datext);
		double dac=Double.parseDouble(datext);

		String nettext= nett.get(sizeda-i-0).getText().replaceAll(",", "");
		System.out.println("NET PROFIT"+nettext);
		double netc=Double.parseDouble(nettext);

		//int netcalc=Integer.parseInt(nettext);
		String wc= wcc.get(wccsize-i-1).getText().replaceAll(",", "");
		System.out.println("WCC CHANGES"+wc);
		double wccc=Double.parseDouble(wc);

	//	double wccc=double.parseDouble(wc);

		double cfo=(dac+netc+wccc)/netc;
		if(cfo>1)
		{
			totalgreater++;
		}
		System.out.println("PRINT CFO"+cfo);
	   
		
	    sb.append("?"+cfo);
	//    System.out.println(sb);
	//	double dt=pbts+Double.parseDouble(directtax);
	//	double dtc=Math.abs(dt);
	/*	
		if (tax>0)
		{
			counter++;
			System.out.println("converted dtc"+dtc);
			
			double valuationdt=(dtc/tax)*100;
			dtavg=dtavg+valuationdt;
			System.out.println("valuationdt"+valuationdt);	
			System.out.println("ADDING AVG TAX"+dtavg);
			
		
		}
		
			*/
	
	}
	    System.out.println(sb);
System.out.println("Total greater value"+totalgreater);
	Double finalavg=dtavg/counter;
	 finalav=(int) Math.round(finalavg);
	System.out.println("FINAL DT "+finalav);
	//section[@id='profit-loss']/descendant::button[4]/parent::td/following-sibling::td
	//above xpath for net profit
	
	}
	catch(Exception e)
	{
	
		System.out.println(e);	
	}
	finally
	{
		
	}
	return sb.toString();

//	return i;
	
}
public int getgreatercfoevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    int finalav=0;
	int pbts = 0;
	int totalgreater=0;
	 StringBuilder sb = new StringBuilder("");

	try
	{
		List<WebElement> header=driver.findElements(By.xpath("//h1"));
		sname=header.get(1).getText();
	 
	 
		List<WebElement> nett=	driver.findElements(By.xpath("//section[@id='profit-loss']//tr/td[normalize-space(text())='EPS in Rs']/parent::tr/preceding-sibling::tr[1]/td"));
		int size=nett.size();
		
		List<WebElement> da=driver.findElements(By.xpath("//section[@id='profit-loss']//tr/td[normalize-space(text())='Depreciation']/following-sibling::td"));
	// int sizedt=dtax.size();
		List<WebElement> wcc=driver.findElements(By.xpath("//td[normalize-space(text())='Working capital changes']/following-sibling::td"));
        int wccsize=wcc.size();
		int sizeda=da.size();
		int counter=0;
		
		Double dtavg=0.0;
		String CFOALL="";
		
		
		for(int i=0;i<sizeda-2;i++)
	{
		String datext= da.get(sizeda-i-1).getText().replaceAll(",", "");
		System.out.println("DA"+datext);
		double dac=Double.parseDouble(datext);

		String nettext= nett.get(sizeda-i-0).getText().replaceAll(",", "");
		System.out.println("NET PROFIT"+nettext);
		double netc=Double.parseDouble(nettext);

		//int netcalc=Integer.parseInt(nettext);
		String wc= wcc.get(wccsize-i-1).getText().replaceAll(",", "");
		System.out.println("WCC CHANGES"+wc);
		double wccc=Double.parseDouble(wc);

	//	double wccc=double.parseDouble(wc);

		double cfo=(dac+netc+wccc)/netc;
		if(cfo>1)
		{
			totalgreater++;
		}
		System.out.println("PRINT CFO"+cfo);
	   
		
	    sb.append("?"+cfo);
	//    System.out.println(sb);
	//	double dt=pbts+Double.parseDouble(directtax);
	//	double dtc=Math.abs(dt);
	/*	
		if (tax>0)
		{
			counter++;
			System.out.println("converted dtc"+dtc);
			
			double valuationdt=(dtc/tax)*100;
			dtavg=dtavg+valuationdt;
			System.out.println("valuationdt"+valuationdt);	
			System.out.println("ADDING AVG TAX"+dtavg);
			
		
		}
		
			*/
	
	}
	    System.out.println(sb);
System.out.println("Total greater value"+totalgreater);
	Double finalavg=dtavg/counter;
	 finalav=(int) Math.round(finalavg);
	System.out.println("FINAL DT "+finalav);
	//section[@id='profit-loss']/descendant::button[4]/parent::td/following-sibling::td
	//above xpath for net profit
	
	}
	catch(Exception e)
	{
	
		System.out.println(e);	
	}
	finally
	{
		
	}
	return totalgreater;

//	return i;
	
}

public int gettaxevaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    int finalav=0;
	int pbts = 0;
	try
	{
		List<WebElement> header=driver.findElements(By.xpath("//h1"));
		sname=header.get(1).getText();
		List<WebElement> pbt=
	driver.findElements(By.xpath("//section[@id='profit-loss']/descendant::td[normalize-space(text())='Profit before tax']/following-sibling::td"));
	//fcash= Double.parseDouble(marketcpval);
		int size=pbt.size();
		List<WebElement> nett=	driver.findElements(By.xpath("//section[@id='profit-loss']//tr/td[normalize-space(text())='EPS in Rs']/parent::tr/preceding-sibling::tr[1]/td"));
		driver.findElement(By.xpath("//section[@id='cash-flow']/descendant::td[1]/button/span")).click();
		Thread.sleep(2000);
		List<WebElement> dtax=driver.findElements(By.xpath("//td[normalize-space(text())='Direct taxes']/following-sibling::td"));
	int sizedt=dtax.size();
		int counter=0;
		Double dtavg=0.0;
		for(int i=0;i<size-2;i++)
	{
		String pbtext= pbt.get(size-i-1).getText().replaceAll(",", "");
		System.out.println(pbtext);
		String nettext= nett.get(size-i-0).getText().replaceAll(",", "");
		System.out.println(nettext);

		String directtax= dtax.get(sizedt-i-1).getText().replaceAll(",", "");
		System.out.println(directtax);

	System.out.println("PBT"+pbtext);
		int profitbt=pbts+Integer.parseInt(pbtext);
		
		int netcalc=Integer.parseInt(nettext);
		
		double tax=profitbt-netcalc;
		
		
		System.out.println("TAX CALC"+tax);
		
		System.out.println("direct"+directtax);
		double dt=pbts+Double.parseDouble(directtax);
		double dtc=Math.abs(dt);
		
		if (tax>0)
		{
			counter++;
			System.out.println("converted dtc"+dtc);
			
			double valuationdt=(dtc/tax)*100;
			dtavg=dtavg+valuationdt;
			System.out.println("valuationdt"+valuationdt);	
			System.out.println("ADDING AVG TAX"+dtavg);
			
			
		}
		
		
	
	}
	Double finalavg=dtavg/counter;
	 finalav=(int) Math.round(finalavg);
	System.out.println("FINAL DT "+finalav);
	//section[@id='profit-loss']/descendant::button[4]/parent::td/following-sibling::td
	//above xpath for net profit
	
	}
	catch(Exception e)
	{
	
		System.out.println(e);	
	}
	finally
	{
		
	}
	return finalav;

//	return i;
	
}
public int getmcapvaluation(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	Double marketcc = 0.0;
	try
	{
	String marketcpval=driver.findElement(By.xpath("//span[normalize-space(text())='Market Cap']/parent::li/span[2]/span")).getText().replaceAll(",", "");
	marketcc= Double.parseDouble(marketcpval);
	}
	catch(Exception e)
	{
	System.out.println(e);	
	}
	finally
	{
		
	}
	
int i = 0;
	
	
	if (marketcc>=0 && marketcc<=100 )
	{
		i=0;
	}
	
	else if (marketcc>100 && marketcc<=200 )
	{
		i=1;
	}
	
	else if (marketcc>200 && marketcc<=400 )
	{
		i=2;
	}
	
	else if (marketcc>400 && marketcc<=800 )
	{
		i=3;
	}
	
	else if (marketcc>800 && marketcc<=1200 )
	{
		i=4;
	}
	else if (marketcc>1200 && marketcc<=1400 )
	{
		i=5;
	}
	else if (marketcc>1400 && marketcc<=1800 )
	{
		i=6;
	}
	else if (marketcc>1801 && marketcc<=2800 )
	{
		i=7;
	}
	else if (marketcc>2800 && marketcc<=5000 )
	{
		i=8;
	}	
	else if (marketcc>=5000 && marketcc<=10000 )
	{
		i=9;
	}
	else if (marketcc>10000 && marketcc<=20000 )
	{
		i=10;
	}
	else if (marketcc>20000 )
	{
		i=11;
	}
	return i;
	}


	public String getdivy(String stock, WebDriver driver) throws InterruptedException
	{
		
	        // declaration and instantiation of objects/variables

		
		  
			//	driver.manage().deleteAllCookies();

			//comment the above 2 lines and uncomment below 2 lines to use Chrome
			//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
	        String baseUrl = "https://www.screener.in";
	        
			// * String expectedTitle = "Welcome: Mercury Tours"; String actualTitle = "";
	        // launch Fire fox and direct it to the Base URL
	       
	        driver.get(baseUrl);
	        
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    //   Thread.sleep(5000);
	       // driver.findElement(By.xpath("//div[@class='searchiconhead']/i")).click();
	        
	      //  driver.findElement(By.xpath("//div[@class='searchiconhead']")).click();
	        
	        

	        try
	        {	
		        driver.findElement(By.xpath("//div[@class='search']/descendant::input[@placeholder='Search for a company']")).sendKeys(stock); 
		        Thread.sleep(1000);
		   //     driver.findElement(By.xpath("//div[@class='search']/descendant::input[@placeholder='Search for a company']")).sendKeys(Keys.BACK_SPACE);

		       Thread.sleep(1000);
	        	driver.findElement(By.xpath("//div[@class='search']/descendant::input[@placeholder='Search for a company']")).sendKeys(Keys.ENTER);
	      //  driver.findElement(By.xpath("//strong[.='companies']/ancestor::div[@id]/div/div[2]/strong")).click();
	       WebElement h1= driver.findElement(By.xpath("//h1"));
	        //String =h1.getText();
	        
	        
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
	        String return3="";
	        String pe="";
	        String YLow="";
	      //  String cmp="";
	        String cp="";
	        String fcf="";
	        int VF=0;
	        // Total Value factor for stock
int mcapfactor=getmcapvaluation(driver);
System.out.println("MCAP FACTOR"+mcapfactor);

int dtoefactor=getdebttoeqvaluation(driver);
System.out.println("Debt to EQUI Factor"+dtoefactor);

int pledgefactor=getpromopldegevaluation(driver);
System.out.println("Pledge Factor"+pledgefactor);

int roefactor=getroevaluation(driver);
System.out.println("ROE Factor"+roefactor);


int rocefactor=getrocevaluation(driver);
System.out.println("ROCE Factor"+rocefactor);

int divyfactor=getdivyvaluation(driver);
System.out.println("DIVIDEND Factor"+divyfactor);

int currratio=getcratiovaluation(driver);

System.out.println("Current ratio Factor"+currratio);

int ptob=getpricetobookevaluation(driver);

System.out.println("Price to Book Factor"+ptob);

int fcash=getfcashevaluation(driver);

System.out.println("free cash flow Factor"+fcash);

int peg=getpegevaluation(driver);

System.out.println("PEG Factor"+peg);

int tax=gettaxevaluation(driver);


System.out.println(sname+"TAX Factor"+tax);


String cfo=getcfoevaluation(driver);

System.out.println(sname+"CFO"+cfo);

int great=getgreatercfoevaluation(driver);
System.out.println(great);


	       // VF=mcapfactor+dtoefactor+pledgefactor+roefactor+rocefactor+divyfactor+currratio+peg+ptob;
VF=dtoefactor+pledgefactor+roefactor+rocefactor+divyfactor+currratio+peg+fcash;
	        System.out.println("VALUATION FACTOR "+VF);
	        try
			{
	        	
	      fcf= 	driver.findElement(By.xpath("//span[normalize-space(text())='CMP / FCF']/parent::li/span[2]/span")).getText();
				String mcp=driver.findElement(By.xpath("//span[normalize-space(text())='Market Cap']/parent::li/span[2]/span")).getText();
      		  marketc = mcp.replaceAll(",", ""); 
      		  
      	 return3=driver.findElement(By.xpath("//span[normalize-space(text())='Return over 3months']/parent::li/span[2]/span")).getText();
      		
      		  System.out.println("3months"+return3);
      		  
      		  pe=driver.findElement(By.xpath("//span[normalize-space(text())='Stock P/E']/parent::li/span[2]/span")).getText().replaceAll(",", "");
      		 
      		  cp=driver.findElement(By.xpath("//span[normalize-space(text())='Current Price']/parent::li/span[2]/span")).getText().replaceAll(",", "");
      		  List<WebElement> yearL=driver.findElements(By.xpath("//span[normalize-space(text())='High / Low']/parent::li/span[2]/span"));
      		  YLow=yearL.get(1).getText().replaceAll(",", "");
      		  
      		  
      		  
	        	
      		  /*
				 * List<WebElement>mcap=driver.findElements(By.xpath(
				 * "//div[@class='company_details_title']/following-sibling::div[@class='company_details_value']"
				 * )); marketc=mcap.get(0).getText(); System.out.println(marketc);
				 * List<WebElement> fr=driver.findElements(By.xpath("//a[.='Financials']"));
				 * fr.get(0).click(); Thread.sleep(1000);
				 * driver.findElement(By.xpath("//a[@href='#cash_flow_analysis']")).click();
				 * Thread.sleep(1000); List<WebElement>
				 * ratio=driver.findElements(By.xpath("//a[.='Consolidated']/parent::li"));
				 * ratio.get(5).click();
				 * 
				 * 
				 * Thread.sleep(1000); List<WebElement> bb=
				 * driver.findElements(By.xpath("//tr[@myid='PricetoBook']/td")); int
				 * countbb=bb.size(); int activepricetobook=0;
				 */}
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
	        	        
		      //  actions.release().perform(); 

 		      
	      //  driver.findElement(By.xpath("//a[@href='#quarterly_results']")).click();
	        Thread.sleep(2000);
	        
	      //section[@id='quarters']/descendant::td[contains(., ' Profit')]/following-sibling::td
	      //section[@id='quarters']/descendant::td[normalize-space(text())='Operating Profit']/following-sibling::td

	        List<WebElement> aa= driver.findElements(By.xpath("//section[@id='quarters']/descendant::td[contains(., ' Profit')]/following-sibling::td"));
	  
	        
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

Earnings obj=new Earnings();
Boolean saleshighest=true;

//obj.maxsalesvalue(driver);
	
	
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
	
	double r3=Double.parseDouble(return3);
	
	Double pec=Double.parseDouble(pe);
	//year low converted
	Double ylc=Double.parseDouble(YLow);
	Double cmpc=Double.parseDouble(cp);
	Double fcfc=Double.parseDouble(fcf);
	
	
	Double raisefromlow=(((cmpc-ylc)/ylc))*100;
	int raisefromlowc=raisefromlow.intValue();
	
	System.out.println("Raise from low int Value"+raisefromlowc);
	

	   String mcapnumberOnly= marketc.replaceAll("[^0-9]", "");
	   System.out.println("numbers only is "+mcapnumberOnly);
	   double mcpdouble = Double.parseDouble(mcapnumberOnly); // returns double primitive

	  // if ( (((average>0) && (lq/average)> 1.3 ) )  || (( (saleshighest) && (list.get(list.size()-2))>0)  &&  ((list.get(list.size()-1))>0) && ((diff2/diff1)>2) &&((list.get(list.size()-1))>(list.get(list.size()-2))) ))   

	//if ( (((average>0) && (lq/average)>0.5 )  )  || (( (saleshighest) && (list.get(list.size()-2))>0)  &&  ((list.get(list.size()-1))>0) && ((diff2/diff1)>2) &&((list.get(list.size()-1))>(list.get(list.size()-2))) ))
	if(2>1)
	   {
		double vals=(diffp3/diffp2);
		double ravg=lq/average;
		
	//	double realavg=
		System.out.println("******");
	
		DY=stock+"?"+ravg+"?"+mcapnumberOnly+"?"+r3+"?"+pec+"?"+raisefromlow+"?"+fcfc+"?"+VF+"?"+tax+cfo+"?"+great;
	}
	
	else if(saleshighest)
	{
		System.out.println("highhhhhh"+saleshighest);
	}
	
	else if ((saleshighest) && ((lq>0)  && (pyq>0) && (lq/tq)>=1.3 && (lq/pyq)>=1.25))
	{
		double yoy;
		yoy =lq/pyq;

		   
		   System.out.println("numbers only is --"+mcapnumberOnly);
		DY=stock+"?"+yoy+"?"+mcapnumberOnly+"?"+r3+"?"+pec+"?"+raisefromlow+"?"+fcfc+"?"+VF+"?"+tax+cfo;
		
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
