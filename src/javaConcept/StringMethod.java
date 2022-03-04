package javaConcept;

public class StringMethod {

	public static void main(String[] args) {
		//String is an object 
		
				String s = "Swapnil Patel Automation";
				String[] splittedString = s.split(" ");
				System.out.println(splittedString[0]);
				System.out.println(splittedString[1].trim());
				
				for(int i=0;i<s.length();i++)
				{
					System.out.println(s.charAt(i));
				}
				
				System.out.println("***************");
				//print in reverse order
				for(int i=s.length()-1;i>=0;i--)
				{
					System.out.println(s.charAt(i));
				}
				


	}

}
