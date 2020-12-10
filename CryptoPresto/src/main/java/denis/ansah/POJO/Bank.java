package denis.ansah.POJO;

public class Bank {
	private int id;
	private int userId;
	private String name;
	private String type;
	private int routingNumber;
	private int accountNumber;
	public Bank() {
		super();
	}
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getRoutingNumber() {
		return routingNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
