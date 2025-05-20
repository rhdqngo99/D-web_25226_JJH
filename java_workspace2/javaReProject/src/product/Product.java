package product;

public class Product {
	
	private int pno; // db에서 자동생성
	private String pname;
	private int price;
	private String regdate; // db자동생성
	private String madeby;
	
	//생성자
	public Product() {}

	// 등록
	public Product( String pname, int price, 
			String madeby) {
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
	}

	// 상세 => 전부
	public Product(int pno, String pname, int price, String regdate, String madeby) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.regdate = regdate;
		this.madeby = madeby;
	}
	
	// 수정 => pon, pname, price, madeby
	// 생성자 호출
	public Product(String pname, int price, String madeby ,int pno) {
		this(pname, price, madeby);
		this.pno = pno;
	}
	
	public void print() {
		System.out.println("제품번호(등록일) : "+pno+" ("+regdate+") ");
		System.out.println("제품명 : "+pname);
		System.out.println("가격 : "+price);
		System.out.println("제품상세");
		System.out.println(madeby);
	}
	

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getMadeby() {
		return madeby;
	}

	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}

	@Override
	public String toString() {
		// list 용도
		return "Product [pno=" + pno + ", pname=" + pname + ", price=" + price + ", regdate=" + regdate + "]";
	}

}
