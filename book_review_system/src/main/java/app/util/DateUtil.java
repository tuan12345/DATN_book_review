package app.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date parseDate(String date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
