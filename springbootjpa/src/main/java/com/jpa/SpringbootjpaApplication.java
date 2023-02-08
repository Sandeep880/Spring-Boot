package com.jpa;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.dao.UserRepository;
import com.jpa.entities.User;

@SpringBootApplication(scanBasePackages = "com.jpa")
public class SpringbootjpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=
		SpringApplication.run(SpringbootjpaApplication.class, args);
		
		UserRepository userRepository= context.getBean(UserRepository.class);   
		
		/*
		 * // Saving data/user to the data base User user= new User();
		 * user.setName("Dwarika Prasad Sah"); user.setCity("Khiderpore");
		 * user.setStatus("Business"); User user1 = userRepository.save(user);
		 * System.out.println(user1);
		 */
		
		// Create object of User
//		User user1=new User();
//		user1.setName("Lila Devi");
//		user1.setCity("Garkha");
//		user1.setStatus("HouseWife");
//		
//		User user2=new User();
//		user2.setName("Munna");
//		user2.setCity("Pahlejaghat");
//		user2.setStatus("Student");
		
		// Saving Single User
		/*
		 * User result = userRepository.save(user1); System.out.println(result);
		 */
		
		/*
		 * // Saving Multiple User List<User> users= List.of(user1,user2);
		 * Iterable<User> result = userRepository.saveAll(users);
		 */
		
		/*
		 * For Printing the element of user result.forEach(user->{
		 * System.out.println(user); });
		 */
		 
		// update  the user of id 252
		
		/*
		 * Optional<User> optional = userRepository.findById(252); User
		 * user=optional.get(); user.setName("Ankit Tiwari"); user.setCity("Allahabad");
		 * user.setStatus("Singer"); User result=userRepository.save(user);
		 * System.out.println(result);
		 */
		
		// how to get the data 
		// findById(id) - return Optional Containing your data
		  
		//Iterable<User> itr = userRepository.findAll();
		
		// Ye Purana tarika hai
		/*
		 * Iterable<User> itr = userRepository.findAll(); Iterator<User>
		 * iterator=itr.iterator();
		 * 
		 * while(iterator.hasNext()) { User person= iterator.next();
		 * System.out.println(person); }
		 */
		
		// Lambda function
		
	//	itr.forEach(user->System.out.println(user));
		
		
		// Deleting the element in the table
		
		//userRepository.deleteById(52);
		  // delete the all element in table 
		/*
		 * Iterable<User> allUser = userRepository.findAll();
		 * 
		 * allUser.forEach(user->System.out.println(user));
		 * 
		 * userRepository.deleteAll(allUser);
		 */
		
//**************************************************CUSTOM FINDER METHODS ***********************************************************************
		List<User> person = userRepository.findByName("Dwarika Prasad Sah");
		
		person.forEach(p->System.out.println(p));
		
		List<User> twoPerson = userRepository.findByNameOrCity("Munna", "Khiderpore");
		twoPerson.forEach(e->System.out.println(e));
		
		
	}

}

