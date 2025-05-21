package jstl_project;

import org.apache.tomcat.util.buf.StringCache;

public class CarVO {
	private String num;
	private String name;
	private int price;
	
	public CarVO() {}

	public CarVO(String num, String name, int price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CarVO [num=" + num + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
