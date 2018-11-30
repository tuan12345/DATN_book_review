package app.dto;

import java.util.ArrayList;
import java.util.List;

public class BookChart {
	private String name;
	private List<Integer> data = new ArrayList<>();

	public BookChart() {

	}

	public BookChart(String name, List<Integer> data) {
		this.name = name;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public void setFirstdata(int FirstData) {
		this.data.add(FirstData);
	}
}
