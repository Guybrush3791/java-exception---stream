package org.booleancareer.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("START");
		
		System.out.print("\nQuante persone: ");
		String countStr = sc.nextLine();
		int count = Integer.parseInt(countStr);
		
		int index = 0;
		Person[] persons = new Person[count];
		while(index < count) {
			
			System.out.print("Nome: ");
			String name = sc.nextLine();
			
			System.out.print("Age: ");
			String ageStr = sc.nextLine();
			int age = Integer.parseInt(ageStr);
			
			try {
				
				Person p = new Person(name, age);
				persons[index++] = p;
			} catch(Exception e) {
				
				System.err.println(e.getMessage());
			}
		}
		
		// ----------------------------------------------
		
		FileWriter myWriter = null;
		try {
			
			myWriter = new FileWriter("./testfile.txt");
			
			for (int x=0;x<persons.length;x++) {
				
				Person p = persons[x];
				
				myWriter.write(p.toString() + "\n");
			}
			
		} catch (Exception e) { 

			System.err.println(e.getMessage());
		}
		finally {
			
			try {
				myWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// ----------------------------------------------
		
		File f = new File("./testfile.txt");
		Scanner fileSc = null;
		try {
			
			fileSc = new Scanner(f);
			
			while(fileSc.hasNextLine()) {
				
				String line = fileSc.nextLine();
				
				if (line.startsWith("p")) {
					System.out.println(line);
				}
			}
			
		} catch (FileNotFoundException e) {
			
			System.err.println(e.getMessage());
		} finally {
			
			fileSc.close();
		}
		
		
		// ----------------------------------------------		
		
		System.out.println(Arrays.toString(persons));
		
		System.out.println("THE END");
	}
}








