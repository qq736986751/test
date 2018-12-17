package servlet.homework;

public class Sales {
	private int p_id;
	private String p_name;
	private int p_sale_num;
	
	public Sales() {}
	
	public Sales(int p_id, String p_name, int p_sale_num) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_sale_num = p_sale_num;
	}

	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_sale_num() {
		return p_sale_num;
	}
	public void setP_sale_num(int p_sale_num) {
		this.p_sale_num = p_sale_num;
	}

	@Override
	public String toString() {
		return "Sales [p_id=" + p_id + ", p_name=" + p_name + ", p_sale_num="
				+ p_sale_num + "]";
	}
	
	
}
