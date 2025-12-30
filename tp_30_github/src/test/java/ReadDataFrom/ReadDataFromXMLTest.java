package ReadDataFrom;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXMLTest {
     
    @Test    //annotation itis act like main method
   public void readData_xml(XmlTest test) {
    	
    	System.out.println(test.getParameter("browser"));
    	System.out.println(test.getParameter("url"));
    	System.out.println(test.getParameter("username"));
    	System.out.println(test.getParameter("password"));
     
}
}
