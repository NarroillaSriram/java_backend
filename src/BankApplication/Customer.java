package BankApplication;

public class Customer {
	private int customerID;
	private String name;
	private String address;
	private String contact;

	
	public Customer(int customerID,String name,String address,String contact) {
		this.customerID=customerID;
		this.name=name;
		this.address=address;
		this.contact=contact;
	}
	public void setCustomerId(int customerId) {
		this.customerID=customerID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	public void setContact(String contact) {
		this.contact=contact;
	}
	public String getContact() {
		return contact;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ "]";
	}

}
