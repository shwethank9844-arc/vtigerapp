package GEneric_Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class javaUtiles {
     /**
      * @author Supriya
      * @return
      */
	public int getRandomNo() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	
	 /**
     * this is used to get systemdates
     * @author Supriya
     * @return
     */
	public String systemdates() 
	{
		LocalDate date = LocalDate.now();
		//local date  future month 
		
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String systemdate = d.format(date);
		return systemdate;
	}
	/**
	 * 
	 * @author Supriya
	 * @return
	 */
	public String sysdate()
	{
		Date date = new Date();
		SimpleDateFormat sim= new SimpleDateFormat("dd-MM-yyy_HH-mm-ss");
		String systemDateInFormate=sim.format(date);
		
		return systemDateInFormate;
	}
	
	/**
	 * @author Supriya
	 * @param futureMon
	 * @return
	 */
	public String futureDateIntermsOfMonth(long futureMon)
	{
		LocalDate date = LocalDate.now();
		 LocalDate future = date.plusMonths(futureMon);
		 DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String futureMonth = d.format(future);
		return futureMonth;
	}
	
	
	
}
