package entity;

public class Cart {
	private int id;
	private String p_name;
	private double price;
	private int num;
	
	public Cart() {}

	public Cart(int id, String p_name, double price) {
		this.id = id;
		this.p_name = p_name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
