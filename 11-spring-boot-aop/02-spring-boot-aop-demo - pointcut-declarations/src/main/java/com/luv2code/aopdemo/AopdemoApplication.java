package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean // auto inject because of @bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService){
		return runner -> {
			//demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
			//demotheAfterReturnAdvice(theAccountDAO)
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAroundAdvice(theTrafficFortuneService);
			//demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};	
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling the getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("My fortune is: " + data);

		System.out.println("Finished");

	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling the getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("My fortune is: " + data);

		System.out.println("Finished");

	}


	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling the getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("My fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;

		try {

			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program: ...caught exception: " + exc);
		}

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demotheAfterReturnAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("\n\nMain Program: demotheAfterReturnAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {

		Account myAccount = new Account();
		myAccount.setName("Mohammad");
		myAccount.setLevel("level of monster");

        theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		System.out.println();

		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();


		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

    }
}
