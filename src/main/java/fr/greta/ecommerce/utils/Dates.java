package fr.greta.ecommerce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Dates {

	public static final Date convertStringToDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static final String convertDateToString(Date date) {
		String dateStr = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateStr = dateFormat.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return dateStr;
	}

	public static final java.sql.Date convertDateUtilToDateSql(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}
	
	public static final java.util.Date convertDateSqlToDateUtil(java.sql.Date sqlDate) {
		return new java.util.Date(sqlDate.getTime());
	}
    
}

