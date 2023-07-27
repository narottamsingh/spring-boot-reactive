package com.bce.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.bce.dto.Employee;

import reactor.core.publisher.Flux;

@Component
public class EmployeeDao {
	
	public static void sleepExecution(int i)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getAllEmp() {

		return IntStream.range(1, 10)
				.peek(EmployeeDao::sleepExecution)
				.peek(i -> System.out.println("Employee Processing count " + i))			
				.mapToObj(i -> new Employee("ID" + i, "Employee " + i))
				.collect(Collectors.toList());
	}
	
	public List<Employee> getAllEmp10() {

		return IntStream.range(1, 10)
				.peek(EmployeeDao::sleepExecution)
				.peek(i -> System.out.println("Employee Processing count " + i))			
				.mapToObj(i -> new Employee("ID" + i, "Employee " + i))
				.collect(Collectors.toList());
	}

	public Flux<Employee> getAllEmpReactive()
	{
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("Employee Processing reactive "+i))
				.doOnCancel(()->System.out.println("Task cancel by user"))
				.doOnComplete(new ThreadR())
				.map(i->new Employee("ID"+i, "Employee "+i));
		
	}
	
	public Flux<Employee> getAllEmpReactive10()
	{
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("Employee Processing reactive "+i))
				.doOnCancel(()->System.out.println("Task cancel by user"))
				.doOnComplete(new ThreadR())
				.map(i->new Employee("ID"+i, "Employee "+i));
		
	}
	
	
}


class ThreadR implements Runnable
{
	@Override
	public void run() {
		System.out.println("Task completed");
	}
}