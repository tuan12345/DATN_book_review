package app.dto;
import java.util.Date;

public class ResponseReviewInfo {
	private String name;
	private Date creatDate;
	private int numberStar;
	private String content;
	
	private int totalPage;
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public ResponseReviewInfo(String name, Date creatDate, int numberStar, String content) {
		super();
		this.name = name;
		this.creatDate = creatDate;
		this.numberStar = numberStar;
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public int getNumberStar() {
		return numberStar;
	}
	public void setNumberStar(int numberStar) {
		this.numberStar = numberStar;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
