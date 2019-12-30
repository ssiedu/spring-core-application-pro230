package com.ssi;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product Code : ");
		int code=sc.nextInt();
		System.out.println("Enter Product Name : ");
		String name=sc.next();
		System.out.println("Enter Price : ");
		int price=sc.nextInt();
		
		Product product=new Product();
		product.setPcode(code);
		product.setPname(name);
		product.setPrice(price);
		
		//we are demanding spring-container to provide us the DAO instance
		ProductDAO dao=context.getBean("productDAO",ProductDAO.class);
		dao.saveProduct(product);
		
		System.out.println("DATA ADDED SUCCESSFULLY");
		
		

	}

}
