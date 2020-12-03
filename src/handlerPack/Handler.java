package handlerPack;

import java.io.*;
import java.util.*;

public class Handler {

	public static void main(String[] args) {
		
		boolean done = false;
		int choice  = -1;
		Scanner s = new Scanner(System.in);
		
		while(done == false) {
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1) Read a file.");
			System.out.println("2) Write to a file.");
			System.out.println("3) Append a file.");
			System.out.println("4) Exit the program.");
			
			choice = s.nextInt();
			s.nextLine();
			
			switch(choice) {
			
			case 1:
				try {
					readFile(s);
				} catch (IOException e) {
					System.out.println("There was a " + e + "with the operation you just performed");
				}
				break;
			case 2:
				try {
					writeFile(s);
				} catch (IOException e) {
					System.out.println("There was a " + e + "with the operation you just performed");
				}
				break;
			case 3:
				try {
					appendFile(s);
				} catch (IOException e) {
					System.out.println("There was a " + e + "with the operation you just performed");
				}
				break;
			case 4:
				done = true;
				break;
			default:
				System.out.println("The value you input was not a selection in the menu");
				break;
			}
			
		}
		
		s.close();

	}
	
	public static void readFile(Scanner s) throws IOException {
		System.out.println("What is the name of the file you would like to read?");
		
		String filename = s.nextLine();
		
		File file = new File(filename);
		
		BufferedReader br;
		
		try {  
			br = new BufferedReader(new FileReader(file));
			
			String fileLine;
			
			System.out.println();
			
			while ((fileLine = br.readLine()) != null) {
				System.out.println(fileLine); 
			}
		}
		catch(FileNotFoundException f) {
			System.out.println("The file you input could not be found");
		}
	
	}
	
	public static void writeFile(Scanner s) throws IOException {
		System.out.println("What is the name of the file you would like to write to?");
		
		String filename = s.nextLine();
		
		File file = new File(filename);
		
		BufferedWriter bw;
		
		try {  
			bw = new BufferedWriter(new FileWriter(file));
			
			boolean done = false;
			while(done == false) {
				System.out.println("What would you like to do?");
				System.out.println("1) Write something to this file");
				System.out.println("2) Stop writing to this file");
				
				int choice = s.nextInt();
				s.nextLine();
				
				switch(choice) {
				case 1:
					System.out.println("What would you like to write?");
					String writeString = s.nextLine();
					bw.write(writeString);
					break;
				case 2:
					done = true;
					break;
				default:
					System.out.println("The value you input was not a selection in the menu");
					break;
				}
			}
			
			bw.close();
			
		}
		catch(FileNotFoundException f) {
			System.out.println("The file you input could not be found");
		}
	}
	
	public static void appendFile(Scanner s) throws IOException {
		System.out.println("What is the name of the file you would like to append?");
		
		String filename = s.nextLine();
		
		File file = new File(filename);
		
		PrintWriter pw;
		
		try {  
			pw = new PrintWriter(new FileWriter(file, true));
			
			boolean done = false;
			while(done == false) {
				System.out.println("What would you like to do?");
				System.out.println("1) Append something to this file");
				System.out.println("2) Stop appending to this file");
				
				int choice = s.nextInt();
				s.nextLine();
				
				switch(choice) {
				case 1:
					System.out.println("What would you like to append to this file?");
					String writeString = s.nextLine();
				    pw.println(writeString);
					break;
				case 2:
					done = true;
					break;
				default:
					System.out.println("The value you input was not a selection in the menu");
					break;
				}
			}
			
			pw.close();
			
		}
		catch(FileNotFoundException f) {
			System.out.println("The file you input could not be found");
		}
	}
}
