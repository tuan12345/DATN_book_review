package app.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import app.dto.BookInfo;

public class SortBooks {
	public static List<BookInfo> sortBooksByTitle(List<BookInfo> listBookInfos) {
		List<BookInfo> tempBooks = listBookInfos;
		Collections.sort(tempBooks, new Comparator<BookInfo>() {
			@Override
			public int compare(BookInfo o1, BookInfo o2) {
				return o1.getTittle().compareToIgnoreCase(o2.getTittle());
			}
		});
		return tempBooks;
	}

	public static List<BookInfo> sortBooksByPublishDate(List<BookInfo> listBookInfos){
		List<BookInfo> tempBooks=listBookInfos;
		Collections.sort(tempBooks,new Comparator<BookInfo>() {
			@Override
			public int compare(BookInfo o1, BookInfo o2) {	
				return o1.getPublishDate().compareTo(o2.getPublishDate());
			}
		});
		return tempBooks;
	}
	

}
