package com.learn.aopdemo;

import com.learn.aopdemo.dao.AccountDAO;
import com.learn.aopdemo.entity.Account;
import com.learn.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,  TrafficFortuneService trafficFortuneService){
		return runner->{
			//System.out.println("Hello World");
			demoTheBeforeAdvice(accountDAO);
			//demoAfterReturningAdvice(accountDAO);
			//demoAfterThrowingAdvice(accountDAO);
			//demoAfterAdvice(accountDAO);
			//demoAroundAdvice(trafficFortuneService);
			//demoAroundAdviceHandleException(trafficFortuneService);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		Account myAccount = new Account();
		myAccount.setName("Hari Object");
		myAccount.setLevel("Platinum");

		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();

		accountDAO.setName("Hari");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		accountDAO.addSillyMember();
	}

	private void demoAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("-----demoAroundAdviceHandleException -----");
		System.out.println("Calling getFortune()");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("My Fortune is "+ data);
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("----- Demo Around Advice -----");
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();
		System.out.println("My Fortune is "+ data);

	}

	private void demoAfterAdvice(AccountDAO accountDAO) {
		List<Account> theAccount = null;

		try{
			boolean tripWire = true;
			theAccount = accountDAO.findAccounts(tripWire);
		}catch(Exception exception){
			System.out.println("----- Exception Caught -----"+exception);
		}
		accountDAO.findAccounts();
		System.out.println("Main Program: demo After throwing Advice");
		System.out.println("Accounts-->"+theAccount);
	}

	private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> theAccount = null;

		try{
			boolean tripWire = true;
			theAccount = accountDAO.findAccounts(tripWire);
		}catch(Exception exception){
			System.out.println("----- Exception Caught -----"+exception);
		}
		accountDAO.findAccounts();
		System.out.println("Main Program: demo After throwing Advice");
		System.out.println("Accounts-->"+theAccount);
	}

	private void demoAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> theAccount = accountDAO.findAccounts();
		System.out.println("Main Program: demo After Returning Advice");
		System.out.println("Accounts-->"+theAccount);
	}


}
