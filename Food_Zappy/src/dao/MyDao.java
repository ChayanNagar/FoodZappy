package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CartBean;
import beans.CustomerBean;
import beans.JoinCart_Bean;
import beans.OrderBean;
import beans.ProductBean;

public class MyDao {
	//my sql connection code
	public Connection start()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zapfood","root","root");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	
	//admin login check by passing parameter uid and pwd
	public int loginCheck(String uid,String pwd)
	{
		int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
				x=1;
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
		
		return x;
	}
	//product insert query by the help of bean class
	public int insertProduct(ProductBean e)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into product (category,pname,price,description,images)values(?,?,?,?,?)");
		    
		    ps1.setString(1,e.getCategory());
		    ps1.setString(2, e.getProductname());
		    ps1.setString(3,e.getProductprice());
		    ps1.setString(4,e.getDescription());
		    ps1.setString(5,e.getFilename());
		   
		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
		
	return x;
		
	}
	//view product method using array list and bean class
	public ArrayList<ProductBean>   viewProduct()
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try(Connection con=start()) {
			
			PreparedStatement ps=con.prepareStatement("select * from product");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				ProductBean e=new ProductBean();
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				e.setDescription(rs.getString("description"));
				e.setFilename(rs.getString("images"));
				

				list.add(e);
		     }
			//con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	//method for display images in grid using the help of category column used in database
	public ArrayList<ProductBean>   viewProductreadytodrink()
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try {
			
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select pid,category,pname,price,images from product WHERE category = 'ready to drink'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				
			{ 
				ProductBean e=new ProductBean();
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
			    e.setFilename(rs.getString("images"));
				

				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	//method for display images in grid using the help of category column used in database
	public ArrayList<ProductBean>   viewProductreadytocook()
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try {
			
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select pid,category,pname,price,images from product WHERE category = 'ready to cook'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				
			{ 
				ProductBean e=new ProductBean();
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				
				e.setFilename(rs.getString("images"));
				

				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	//method for display images in grid using the help of category column used in database
	public ArrayList<ProductBean>   viewProductreadytoeat()
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try {
			
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select pid,category,pname,price,images from product WHERE category = 'ready to eat'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				
			{ 
				ProductBean e=new ProductBean();
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				
				e.setFilename(rs.getString("images"));
				

				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	//delete method to delete record from the insert product
	public int deleteEmp(int pid)
	{
		int x=0;
		
		try {
			
			Connection con=start();			
			PreparedStatement ps=con.prepareStatement("delete from product where pid=?");
			ps.setInt(1,pid);
			x= ps.executeUpdate();
	       con.close();
		}catch(SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
    //method to update record with the help of pid
	public  ProductBean getProductDetailsByPid(int pid)
	{
		ProductBean e=new ProductBean();
		try {
				Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
			ps.setInt(1,pid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{ 
				
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				e.setDescription(rs.getString("description"));
				e.setFilename(rs.getString("images"));
		 }
			con.close();
		}catch(  SQLException w)
			{
			  System.out.println(w);
			}
		System.out.println(e);
	return e;
		
	}
     //method to update product which are seen by admin in admin panel
	public int updateProduct(ProductBean e)
	{
		int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("update product set category=?,pname=?,price=?,description=?  where pid=?");
			ps.setInt(5,e.getPid());
			ps.setString(1,e.getCategory());
			ps.setString(2,e.getProductname());
			ps.setString(3, e.getProductprice());
			ps.setString(4, e.getDescription());
			
			x= ps.executeUpdate();
	       con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
	//update image method in admin panel
	public int updateImage(ProductBean e) 
	{
      int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("update product set images=? where pid=?");
			ps.setInt(2,e.getPid());
			ps.setString(1,e.getFilename());
			
			x= ps.executeUpdate();
	       con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
	//method for insert customer with the help of bean class
	public int insertCustomer(CustomerBean e)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into customer values(?,?,?,?,?)");
		    
		    ps1.setString(1,e.getCname());
		    ps1.setString(2, e.getEmailid());
		    ps1.setString(3,e.getPassword());
		    ps1.setString(4,e.getMobileno());
		    ps1.setString(5,e.getCaddress());
		    		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
		
	return x;
	}
	//method for customer login by passing email and pwd as a parameter
	public int customerLogin(String email,String pwd)
	{
		int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from customer where emailid=? and password=?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next())
				x=1;
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
		
		return x;
	}
	//method to insert values in a cart table
	public int insertCart(CartBean e)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into cart(pid,quantity,emailid)values(?,?,?)");
		    
			ps1.setInt(1, e.getPid());
			ps1.setInt(2,e.getQuantity());
		    ps1.setString(3,e.getUser());
		    
		   
		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
	
	return x;
		
	}
	//cart check for dynamically update quantity with same pid
	public int quantityCheck(String pid , String user)	 
	{
		int x=0;
	
		try {
			
			Connection con =start(); 
			// prepared Statement
			PreparedStatement ps = con.prepareStatement("Select * from cart where pid=? and emailid=?");
			ps.setInt(1, Integer.parseInt(pid));
			ps.setString(2, user);
			//System.out.println(ps);
			ResultSet rs=ps.executeQuery();
             x=0;
			if(rs.next())
           x=1;
	}catch(Exception e)
		{
		System.out.println(e);
		}
		return x;
	}
		
	//cart quantity update method after checking quantity with same user and pid
	public int updateQuantityViaCart(CartBean e,String Quantity) {
		int x = 0;
  	try {
  		
  		//int q=Integer.parseInt(quantity);
			Connection con = start();
			PreparedStatement ps = con.prepareStatement("update cart set quantity=quantity+? where emailid=? and pid=?");
			ps.setInt(1, Integer.parseInt(Quantity));
			ps.setString(2, e.getUser());
			ps.setInt(3, e.getPid());
				
			x = ps.executeUpdate();
			//System.out.println(ps);
			con.close();
		} catch (SQLException w) {
			System.out.println(w);
		}
		System.out.println("update method call");
		return x;
	}


//method to view cart using array list and bean class
	public ArrayList<JoinCart_Bean>   viewCart(String user)
	{
		ArrayList<JoinCart_Bean> list=new ArrayList<>();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select c.cid,p.images,p.pname,p.price,c.quantity from product p,cart c WHERE p.pid=c.pid And c.emailid=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			
		    
			while(rs.next())
			{ 
				JoinCart_Bean e=new JoinCart_Bean();
				e.setCid(rs.getInt(1));
				e.setImage(rs.getString(2));
				e.setPname(rs.getString(3));
				e.setPrice(rs.getString(4));
				e.setQuantity(rs.getInt(5));
				
		    list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	//method for total cart by multiplying price and quantity which gives total
	public ArrayList<JoinCart_Bean>   cartTotal(String user)
	{
		ArrayList<JoinCart_Bean> list=new ArrayList<>();
		JoinCart_Bean e=new JoinCart_Bean();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select sum(p.price*c.quantity)from product p,cart c WHERE p.pid=c.pid And c.emailid=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next())
			{ 
				
				e.setTotal(rs.getInt("sum(p.price*c.quantity)"));
				list.add(e);
				}
			con.close();
		}catch( SQLException ex)
			{
			  System.out.println(ex);
			}
	return list;
	 }
	//method for counting cart when user add to cart
	  public int  cartCount(String user)
	  {  
		  int count=0;
		  try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select count(*) from cart  where emailid=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next())
			{ 
			  count= rs.getInt("count(*)");
				
				}
			con.close();
		}catch( SQLException ex)
			{
			  System.out.println(ex);
			}

		return count;
	  }
	  //cart update method 
    public int cartUpdate(String user,String IP)
    {
    	int x=0;
    	try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("update cart set emailid=? where emailid=?");
			ps.setString(1, user);
			ps.setString(2, IP);
			x=ps.executeUpdate();
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
	
    	return x;
    }
    //product desc method when clicking on a product
    public ArrayList<ProductBean>   productDesc(int pid)
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try {
			
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from product WHERE pid=?");
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				
			{ 
				ProductBean e=new ProductBean();
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				e.setDescription(rs.getString("description"));
                e.setFilename(rs.getString("images"));
				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
    //ajax method for checking mail is available or exist in sign up page
    public String checkEmail(String email)
    {
    	String msg=null;
    	
    	try
    	{	
    		int x=0;
    		Connection con=start();
    		String sql = "select * from customer where emailid=?";
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, email);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			x=1;
    		}
    		if(x==1)
    			msg="<font color=red>Already Exist</font>";
    		else
    			msg="<font color=green>Avaliable</font>";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
         return msg;
    }
  //ajax method for checking product name is available or not
    public String checkPname(String pname)
    {
    	String msg=null;
    	
    	try
    	{	
    		int x=0;
    		Connection con=start();
    		String sql = "select * from product where pname=?";
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, pname);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			x=1;
    		}
    		if(x==1)
    			msg="<font color=red>Already Exist</font>";
    		else
    			msg="<font color=green>Avaliable</font>";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
         return msg;
    }
    //method for deleting records from cart by passing cid as a parameter
    public int deleteCart(int cid)
	{
		int x=0;
		
		try {
			
			Connection con=start();			
			PreparedStatement ps=con.prepareStatement("delete from cart where cid=?");
			ps.setInt(1,cid);
			x= ps.executeUpdate();
	       con.close();
		}catch(SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
    //method for updating total cart values
   public int totalUpdateCart(String q,String cid)

{
	   int x=0;
	   try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("update cart set quantity=? where cid=?");
			ps.setInt(1, Integer.parseInt(q));
			ps.setInt(2, Integer.parseInt(cid));
			x=ps.executeUpdate();
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
	
	  return x;
}
   //grand total from cart in view cart jsp page
   public int   gTotal(String user)
	{int gtot=0;
				
	   try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select sum(p.price*c.quantity)from product p,cart c WHERE p.pid=c.pid And c.emailid=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			//System.out.println(ps);
			
			if(rs.next())
			{ 
				
				gtot=rs.getInt(1);
				}
			con.close();
		}catch( SQLException ex)
			{
			  System.out.println(ex);
			}
	return gtot;
	 }
   //check out method 
   public ArrayList<CartBean>  checkOut(String user,String Add)
	{
		ArrayList<CartBean> list=new ArrayList<>();
		CartBean e=new CartBean();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select c.pid,c.quantity,c.emailid,p.price from cart c,product p WHERE c.pid=p.pid AND c.emailid=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			
		//	System.out.println(ps);
			while(rs.next())
			{ 
				insertOrder1(rs.getInt(1),rs.getInt(2),rs.getString(3),Add,rs.getInt(4));
								
			}
			deleteCartTable(user);

			con.close();
		}catch( SQLException ex)
			{
			  System.out.println(ex);
			}
	return list;
	 }
   public int insertOrder1(int pid,int quan,String user,String add,int price)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into order1(pid,quantity,price,emailid,address,status)values(?,?,?,?,?,?)");
		    
			ps1.setInt(1,pid);
			ps1.setInt(2,quan);
		   ps1.setInt(3, price);
			ps1.setString(4,user);
		    ps1.setString(5, add);
		   ps1.setInt(6, 0);
		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    //System.out.println(ps1);
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
	
	return x;
		
	}
   public int deleteCartTable(String user)
  	{
  		int x=0;
  		
  		try {
  			
  			CartBean c=new CartBean();
  			Connection con=start();			
  			PreparedStatement ps=con.prepareStatement("delete from cart where emailid=?");
  			ps.setString(1,user);
  			x= ps.executeUpdate();
  	       con.close();
  		}catch(SQLException w)
  			{
  			  System.out.println(w);
  			}
  		
  		return x;
  	}
   public ArrayList<OrderBean>   viewPendingOrder()
	{
		ArrayList<OrderBean> list=new ArrayList<>();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from order1  where status=0 order by oid desc");
			//System.out.println(ps);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				OrderBean e=new OrderBean();
				e.setOid(rs.getInt("oid"));
				e.setPid(rs.getInt("pid"));
				e.setQuantity(rs.getInt("quantity"));
				e.setPrice(rs.getInt("price"));
				e.setUser(rs.getString("emailid"));
				e.setAddress(rs.getString("address"));
				e.setStatus(rs.getInt("status"));
                e.setDate(rs.getString("datetime"));
				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
   public ArrayList<OrderBean>   viewOrderHistory()
  	{
  		ArrayList<OrderBean> list=new ArrayList<>();
  		try {
  			Connection con=start();
  			PreparedStatement ps=con.prepareStatement("select * from order1  where status!=0 order by oid desc");
  			ResultSet rs=ps.executeQuery();
  			while(rs.next())
  			{ 
  				OrderBean e=new OrderBean();
  				e.setOid(rs.getInt("oid"));
  				e.setPid(rs.getInt("pid"));
  				e.setQuantity(rs.getInt("quantity"));
  				e.setPrice(rs.getInt("price"));
  				e.setUser(rs.getString("emailid"));
  				e.setAddress(rs.getString("address"));
  				e.setStatus(rs.getInt("status"));
  				e.setDate(rs.getString("datetime"));
  				list.add(e);
  		     }
  			con.close();
  		}catch( SQLException w)
  			{
  			  System.out.println(w);
  			}
  	return list;
  		
  	}

   public int productDispatch(int oid)
	{
		int x=0;
		
		try {
			
			Connection con=start();			
			PreparedStatement ps=con.prepareStatement("update order1 set status=1 where oid=?");
			//ps.setInt(1,1);
			ps.setInt(1,oid);
			x= ps.executeUpdate();
	       con.close();
		}catch(SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
   public int productNotAvailable(int oid)
	{
		int x=0;
		
		try {
			
			Connection con=start();			
			PreparedStatement ps=con.prepareStatement("update order1 set status=2 where oid=?");
			//ps.setInt(1,2);
			ps.setInt(1,oid);
			x= ps.executeUpdate();
	       con.close();
		}catch(SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
   public ArrayList<OrderBean>   viewCustomerOrder(String user)
	{
		ArrayList<OrderBean> list=new ArrayList<>();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from order1 where emailid=? order by oid desc ");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				OrderBean e=new OrderBean();
				e.setOid(rs.getInt("oid"));
				e.setPid(rs.getInt("pid"));
				e.setQuantity(rs.getInt("quantity"));
				e.setPrice(rs.getInt("price"));
				e.setUser(rs.getString("emailid"));
				e.setAddress(rs.getString("address"));
				e.setStatus(rs.getInt("status"));
               e.setDate(rs.getString("datetime"));
				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
   public String sendPassword(String userpss)
  	{
  		
  		
  		try {
  			
  			Connection con=start();			
  			PreparedStatement ps=con.prepareStatement("select password from customer where emailid=?");
  			//ps.setInt(1,2);
  			ps.setString(1,userpss);
  			//System.out.println(ps);
  			ResultSet rs=ps.executeQuery();
  			if(rs.next())
  			{
  				userpss=rs.getString(1);
  			}
  	       con.close();
  		}catch(SQLException w)
  			{
  			  System.out.println(w);
  			}
  		
  		return userpss;
  	}
   public int checkEmailForForgotPassword(String email)
   {
	   int x=0;
   try
   	{	
   		   		Connection con=start();
   		String sql = "select * from customer where emailid=?";
   		PreparedStatement ps = con.prepareStatement(sql);
   		ps.setString(1, email);
   		ResultSet rs = ps.executeQuery();
   		if(rs.next())
   		{
   			x=1;
   		}
   		  	}
   	catch(Exception e)
   	{
   		System.out.println(e);
   	}
   	
        return x;
   }
   public int insertOtp(String emailid,String otp)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("update customer set otp=? where emailid=?");
		    
		    ps1.setString(2,emailid);
		    ps1.setString(1, otp);
		    
		    		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
		
	return x;
	}
   public int checkOtp(String otp)
   {
	   int x=0;
   try
   	{	
   		   		Connection con=start();
   		String sql = "select * from customer where otp=?";
   		PreparedStatement ps = con.prepareStatement(sql);
   		ps.setString(1, otp);
   		ResultSet rs = ps.executeQuery();
   		if(rs.next())
   		{
   			x=1;
   		}
   		  	}
   	catch(Exception e)
   	{
   		System.out.println(e);
   	}
   	
        return x;
   }
   public int passwordUpdate(String password,String emailid)
  	{ 
  		int x=0;
  		
  		try {
  			
  			Connection con=start();
  			PreparedStatement ps1=con.prepareStatement("update customer set password=? where emailid=?");
  		    
  		    ps1.setString(2,emailid);
  		    ps1.setString(1, password);
  		    
  		    		    
  		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
  		    con.close();
  		    }catch(Exception w)
  		{
  		    	System.out.println(w);
  		}
  		
  	return x;
  	}

}
