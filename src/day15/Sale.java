package day15;

//menu, price
public class Sale<K,V> {
	
	private K menu;
	private V price;
	
	public Sale() {}

	public Sale(K menu, V price) {
		this.menu = menu;
		this.price = price;
	}

	public K getMenu() {
		return menu;
	}

	public void setMenu(K menu) {
		this.menu = menu;
	}

	public V getPrice() {
		return price;
	}

	public void setPrice(V price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[" + menu + ":" + price + "]";
	}
	
}
