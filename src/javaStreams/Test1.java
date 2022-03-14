package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	//Here we gonna learn Java Stream concept with examples
	//Count the number of names which is start from letter "A"
	//this test is done by regular java methods
	@Test
	public void regular()
	{
		//here we assign String array list
		ArrayList<String> names = new ArrayList<String>();
		names.add("Lisa");
		names.add("Abhi");
		names.add("Raju");
		names.add("Anand");
		names.add("Arron");
		names.add("Vrund");
		names.add("Nikunj");
		
		int count = 0;
		for(int i=0;i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count); //it will print count of names with letter "A"
	}
	//this is enhanced version of above example
	@Test
	public void streamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Lisa");
		names.add("Abhi");
		names.add("Raju");
		names.add("Anand");
		names.add("Arron");
		names.add("Vrund");
		names.add("Nikunj");
		
		//there is no life of intermediate operation if there is no terminal operation
		//now we convert our arrayList in streams and using lambda expression
		//terminal operation execute only if intermediate  operation (filter) returns true
		//how to use filter in stream
		//how we can create stream
		Long count = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);
		
		//we can assign as below as well
		Stream.of("Lisa","Abhi","Raju","Anand","Arron","Vrund","Nikunj").filter(s->s.startsWith("A"));
		
		//another way to execute stream
		Long names1 = Stream.of("Lisa","Abhi","Raju","Anand","Arron","Vrund","Nikunj").filter(s->
		{
			//we can write code here
			return s.startsWith("A");
		}
		).count();
		System.out.println(names1);
		
		//print all names which is more than 4 letter in it from arrayList
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//if we want to see only 1 result from that names which is more than 4 letters
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
			
		
	}
	
	@Test
	public void streamMap()
	{
		//Print names ends with letter "d" and with UpperCase
		 Stream.of("Lisa","Abhi","Raju","Anand","Arron","Vrund","Nikunj").filter(s->s.endsWith("d")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		 
		//print names which is start with "a" and sorted
		//How to convert array in arrayList : Arrays.asList(arg0)
		 List<String> names = Arrays.asList("Lisa","Abhi","Raju","Anand","Arron","Vrund","Nikunj");
		 names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		 
	}
	
	@Test
	public void streamMerge()
	{
		//Merge two lists and sort it
		ArrayList<String> names = new ArrayList<String>();
		names.add("Baburao");
		names.add("Adam");
		names.add("Ronnie");
		names.add("Swap");
		names.add("Pri");
		names.add("Jim");
		names.add("Meet");
		
		List<String> names1 = Arrays.asList("Lisa","Abhi","Raju","Anand","Arron","Vrund","Nikunj");
		
		Stream<String> newName = Stream.concat(names.stream(), names1.stream());//merge two lists into stream
		newName.sorted().forEach(s->System.out.println(s));
		
		//checking name is present or not
		boolean checkName =	names.stream().anyMatch(s->s.equalsIgnoreCase("swap"));
		Assert.assertTrue(checkName);
	}
	
	@Test
	public void streamCollect()
	{
		//making a list as collection without print
		List<String> list = Stream.of("Lisa","Abhi","Raju","Anand","Arron","Vrund","Nikunj").filter(s->s.endsWith("d")).map(s->s.toUpperCase()).collect(Collectors.toList());
		//print 1st name from list
		System.out.println(list.get(0)); //print 1st name from list
		
		//Print unique numbers and sort it from integer array
		List<Integer> values = Arrays.asList(3,6,2,8,7,3,6,2,11,2,8,7);
		values.stream().distinct().forEach(s->System.out.println(s)); //print unique number from list
		List<Integer> li = values.stream().distinct().collect(Collectors.toList()); //making unique number list
		System.out.println(li.get(2)); //print 2 index from unique list
	 
	
	}
}
