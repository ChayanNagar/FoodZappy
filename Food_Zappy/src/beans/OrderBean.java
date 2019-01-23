package beans;

public class OrderBean {
int oid,pid,quantity,price,status;
String user,address;
String Date;
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
	}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
