package javaConcept;

import java.util.ArrayList;

public class Arrays {

	public static void main(String[] args) {
		// Arrays
		int[] array = new int[5];
		array[0] = 1;
	    array[1] = 2;
	    array[2]=3;
	    array[3]=4;
	    array[4]=5;
	    
	    int[] arr = {1,2,3,4,5};
	    for(int i=0;i<arr.length;i++)
	    {
	    	System.out.println(arr[i]);
	    }
		
		String[] name = {"Swapnil","Patel","Automation"};
		for(int i=0;i<name.length;i++)
		{
			System.out.println(name[i]);
			
		}
		
		//Simplified version for loop
		for(String s: name)
		{
			System.out.println(s);
		}
		
		//ArrayList dynamic array
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Swapnil");
		alist.add("Patel");

		alist.get(1);  //get values


	}

}
