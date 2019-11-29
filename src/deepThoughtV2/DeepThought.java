package deepThoughtV2;	

import java.util.Scanner;

import deepThoughtV2.DisplyWindow;

public class DeepThought {

	public static void main(String[] args) {

		int choice;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter 42 to start the program");
			choice=scanner.nextInt();
			while(choice!=42) {
				System.out.println("Please enter 42 to start the program");
				choice=scanner.nextInt();
				scanner.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("LAunching Deepthought in....");
		for(int i=3; i>0; i--) {
			System.out.println(i+"..............");
			for(long  j=1111111111; j>0; j--) {
				//just waiting 
			}
		}

		try { 
			@SuppressWarnings("unused")
			DisplyWindow mainWin = new DisplyWindow();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}