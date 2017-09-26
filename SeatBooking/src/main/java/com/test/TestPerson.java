package com.seat.service;

import java.math.BigInteger;

import org.hibernate.Session;

import com.seat.dao.ContactDetailsDAO;
import com.seat.dao.PersonDAO;
import com.seat.dao.impl.ContactDeatilsDAOImpl;
import com.seat.dao.impl.PersonDAOImpl;
import com.seat.model.ContactDetail;
import com.seat.model.Person;
import com.seat.util.MyUtil;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*ContactDetail cd1=new ContactDetail();
	ContactDetail cd2=new ContactDetail();
		Person p=new Person();
		cd1.setCity("Pune");
		cd1.setContactType("O");
		cd1.setCountry("India");
		cd1.setState("Maharashtra");
		
		p.getContactDetails().add(cd1);
		cd2.setCity("Mumbai");
		cd2.setContactType("H");
		cd2.setCountry("India");
		cd2.setState("Maharashtra");
	p.getContactDetails().add(cd2);
		p.setEmployeeId("A12");
		p.setEmployeeName("shraddha");
		p.setPassword("abcd");
		p.setDesignation("Coder");
		p.setUserName("sdevarkar");
	p.setUserType("A");
			cd1.setPerson(p);
			cd2.setPerson(p);
			 */
		
		PersonDAO pd=new PersonDAOImpl();
		ContactDetailsDAO cdp1=new ContactDeatilsDAOImpl();
		ContactDetailsDAO cdp2=new ContactDeatilsDAOImpl();
		Session session=MyUtil.getSession();
		session.beginTransaction();
	//	pd.register(p,session);
		//pd.retrieve(p, session);
	//	cdp1.addContact(cd1,session);
		//cdp2.addContact(cd2,session);
	 /*   pd.checkPerson("rshivkumar", "abcd");
	    Person p1= pd.getPerson("rshivkumar");
	    System.out.println(p1.getDesignation()+ " " +p1.getEmployeeId()+" "+p1.getUserName());
	    boolean flag= false;
	    flag=pd.deletePerson("rshivkumar");
	    System.out.println(flag);*/
	    
/*	boolean flag= false;
	    flag=pd.updateUserFullname("sdevarkar", "charlie rawool");
	    System.out.println(flag);*/
	    
//		p.setEmployeeName("chetan");
//		System.out.println(p.getEmployeeId());
//		System.out.println(p.getEmployeeName());
		
		session.getTransaction().commit();
		
		
		

	}

}
