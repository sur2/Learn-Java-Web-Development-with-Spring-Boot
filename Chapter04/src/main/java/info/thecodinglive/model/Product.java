package info.thecodinglive.model;

public class Product {
	private String color;
	private String name;
	private int price;

	public Product() {
		super();
	
	}

	public Product(String color, String name, int price) {
		super();
		this.color = color;
		this.name = name;
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
	
}
