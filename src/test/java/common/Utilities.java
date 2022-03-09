package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utilities {
	final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);
	
	public String replaceText(String Xpath, String replacement){
		return Xpath.replace("#text#", replacement);
	}
	
	public void printFirst5PricesElements(List<WebElement> prices){
		Iterator<WebElement> itr = prices.iterator();
		int count=0;
		while(count<5) {
			LOGGER.info(itr.next().getText());
		    count++;  	    
		}
	}
	
	public void printFirst5ProductNames(List<WebElement> productNames){
		Iterator<WebElement> itr = productNames.iterator();
		int count=0;
		List<String> stringList = new ArrayList<>();
		while(count<5) {		 
			 stringList.add(itr.next().getText());        
		     count++;  		   
		}
		 // before sorting
		LOGGER.info(" before sorting ");
	    System.out.println(stringList);
	    
	    // sort the list
	    Collections.sort(stringList);
	 
	    // after sorting
	    LOGGER.info(" after sorting ");
	    System.out.println(stringList);
	}
}
