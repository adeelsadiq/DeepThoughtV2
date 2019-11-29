
package deepThoughtV2;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//this is the main writer class, writes to the files and I want to also add arrays somehow, Maybe add users in here, they get stored in an array and get their own file 
//and we can access that by sidebar menu, but first the core project and then we can mess about with this.

public class MessageWriter extends Message{
	
	public MessageWriter() {
		
	}
	//invoking super = modularity and constructor overloading 
	public MessageWriter(String text) {
		super(text);	//invoking super = reuse	
		
		if (text != null) {
			try{
				String time = new SimpleDateFormat("dd:MM:yyyy-HH:mm:ss").format(Calendar.getInstance().getTime());// getting time and date for each question

				PrintWriter writer = new PrintWriter((new FileWriter(FILE_NAME, true)));
				
				writer.println(time+": \n"+text); //adding date and time with each question
				writer.close();
			}
			catch (IOException e){
				System.out.println("Error: " + e.getMessage());
			}}else {
				System.out.println("Ask a question will you, or do you want me to guess the question too?");
			}
		
	} 

	void erase() {//function to erase the file at button push. 

		try{

			PrintWriter writer = new PrintWriter((new FileWriter(FILE_NAME)));

			writer.println("");
			writer.close();
		}
		catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}

	}


}
