package com.bce.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.bce.dto.Address;
import com.bce.dto.Employee;

import reactor.core.publisher.Flux;

@Component
public class AddressDao {
	
	public static void sleepExecution(int i)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<Address> getAllAddress() {
		return IntStream.range(1, 12)
				.peek(AddressDao::sleepExecution)
				.peek(i -> System.out.println("Address Processing count " + i))			
				.mapToObj(i -> new Address("ID" + i, "ADDRESS ID"+i, "Address " + i))
				.collect(Collectors.toList());
	}

	public Flux<Address> getAllAddressReactive()
	{
		return Flux.range(1, 12)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("Address Processing reactive "+i))
				.doOnCancel(()->System.out.println("Task cancel by user"))
				.doOnComplete(()->System.out.println("Task Completed..."))
				.map(i -> new Address("ID" + i, "ADDRESS ID"+i, "Address " + i));
		
	}
	
	
}
