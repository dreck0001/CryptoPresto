package denis.ansah.POJO;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String dateCreated;
	public User() {
	}
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

}
