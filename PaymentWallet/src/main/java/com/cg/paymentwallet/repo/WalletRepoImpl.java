package com.cg.paymentwallet.repo;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.paymentwallet.beans.Customer;
import com.cg.paymentwallet.util.PaymentWalletUtil;


public class WalletRepoImpl implements WalletRepo {
	//private static Map<String, Customer> data=null;
	private static List<String> myList=null;
	Connection con =null;
	
 public WalletRepoImpl() {

	 try {
		 con=PaymentWalletUtil.getConnect();
	 }catch (Exception e) {
	
	}
}
	static {
		//data=new HashMap<String ,Customer>();
		myList=new ArrayList<String>();
	}

	
public void save(Customer customer) {
		
		//return data.put(customer.getMobileNo(), customer);
	try
	{
					
			String sql = "INSERT INTO cust_details VALUES(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,customer.getName());
			pstmt.setString(2, customer.getMobileNo());
			pstmt.setBigDecimal(3, customer.getWallet());
			pstmt.executeUpdate();
	}catch (Exception e) {
		
	}
	
}


	public Customer findOne(String moblieNo) {
		
		Customer customer=new Customer();
		try {
			String sql="SELECT * FROM cust_details WHERE mobile =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,moblieNo);
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				customer.setName(res.getString(1));
				customer.setMobileNo(res.getString(2));
				customer.setWallet(res.getBigDecimal(3));
				
				
			}
		}
		catch (Exception e) {
			
		}
		return customer;
		
	}


	/*public Map<String, Customer> getDetails() {
		
		return data;
	}
*/


	


	/*public List<String> viewTransaction() {
		
		return myList;
	}*/
	public void updateWallet(String mobileNo,BigDecimal balance) {
		try {
			String sql="UPDATE cust_details SET balance= ? WHERE mobile=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setBigDecimal(1,balance);
			pstmt.setString(2,mobileNo);
			pstmt.executeUpdate();		
					
		}catch (Exception e) {
			
		}
	
	}


	public void addTransaction(String mobileNo,String transactions) {
		try {
			String sql="INSERT INTO transactions values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			
			pstmt.setString(1,mobileNo);
			pstmt.setString(2, transactions);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			
		}
		myList.add(transactions);
			
		}
		
	public List<String> printTransactions(String mobileNo){
		List<String> transaction = new ArrayList<String>();
		try {
			String sql="SELECT * FROM transactions WHERE mobile =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,mobileNo);
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				transaction.add(res.getString(2));
			}
			
		}catch (Exception e) {
		
		}
		return transaction;
	}
	}

	


