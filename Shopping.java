package com.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Shopping {
	
	public void create_data()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		//Product
		Product p1 = new Product();
		p1.setId(101); p1.setName("Kurta"); p1.setPrice(999);
		
		Product p2 = new Product();
		p2.setId(102); p2.setName("Jeans"); p2.setPrice(1500);
		
		Product p3 = new Product();
		p3.setId(103); p3.setName("Shirt"); p3.setPrice(1100);
		//User
		User u1 = new User();
		u1.setId(111); u1.setUsername("kar123"); u1.setEmail("kar123@gmail.com"); u1.setPhone("915698009");
		
		User u2 = new User();
		u2.setId(112); u2.setUsername("Priya141"); u2.setEmail("priya@gmail.com"); u2.setPhone("789568773");
		
		User u3 = new User();
		u3.setId(113); u3.setUsername("Ritu"); u3.setEmail("ritu111@gmail.com"); u3.setPhone("9846787988");
		
		//cartItem
		CartItem cartitem = new CartItem();
		cartitem.setId(567); cartitem.setProduct(p1); cartitem.setQuantity(5); 
		
		//Orderitem details
		OrderItem orderitem = new OrderItem();
		orderitem.setId(4567); orderitem.setPrice(1000.23); orderitem.setProduct(p1); orderitem.setQuantity(2);
		
		s.save(p1); s.save(p2); s.save(p3); s.save(u1); s.save(u2); s.save(u3); 
		s.save(cartitem);
		s.save(orderitem); 
		
		s.save(p1);
		s.save(u1);
		
		t.commit();
		s.close();
		
	}
	public void update_data()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		String hql = "update Product set name = :a where id = :k";
		Query q = s.createQuery(hql);
		q.setParameter("a", "Tshirt");
		q.setParameter("k", 3);
		
		int row = q.executeUpdate();
		System.out.println(row+ " Object is updated");
		
		t.commit();
		s.close();
	}
	public void Read_data()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		

		   String hql = "from Product";
			Query q = s.createQuery(hql);
			
			List<Product> pro = q.getResultList();
			
			System.out.println("Product Details");
			for(Product p1:pro)
			{
				System.out.println(p1.getId());
				System.out.println(p1.getName());
				System.out.println(p1.getPrice());
			}
		
		t.commit();
		s.close();
	}
	public void delete_data()
	{
		
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			
				
				String hql = "delete from Product where id= :i";
				Query q = s.createQuery(hql);
				q.setParameter("i", 3);
				
				
				int del = q.executeUpdate();
				System.out.println(del+ " Object is Deleted"); 
			
			t.commit();
			s.close();
	}

	public static void main(String[] args) {
		
		Shopping s1 = new Shopping();
		  s1.create_data();
		//s1.update_data();
		//s1.Read_data();
		//s1.delete_data();
        
	}

}
