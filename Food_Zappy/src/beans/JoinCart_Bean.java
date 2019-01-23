package beans;

public class JoinCart_Bean {
String pname,price,emailid,image;
int quantity;
int total;
int cid;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}
