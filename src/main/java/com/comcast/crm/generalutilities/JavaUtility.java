package com.comcast.crm.generalutilities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.swing.text.SimpleAttributeSet;

public class JavaUtility 
{
                                // To get Random Number
	public int getRandomNumber()
	{
		Random ran=new Random();
		int ranInt=ran.nextInt(1000);
		return ranInt;
	}
	
	// To get currentDate
	
	public String getCurrentDate()
	{
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sif=new SimpleDateFormat("dd-MM-yyy");
		String currDate=sif.format(date);
		return currDate;
		
	}
	
	//Generate 10 digit num
	
	 public long togetTenDigitRandomNumber(){
		
	  Random r = new Random();
	  long num = 1000000000L + (long) (r.nextDouble()*9000000000L);
	  return num;
	 }

	
	// To get Required date
	
	public String toGetRequiredDate(int days)
	{
	java.util.Date date=new java.util.Date();
	SimpleDateFormat sif=new SimpleDateFormat("dd-MM-yyy");
	String currDate=sif.format(date);
	Calendar cal=sif.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String dateRequired=sif.format(cal.getTime());
	return dateRequired;
	
	
}
}
