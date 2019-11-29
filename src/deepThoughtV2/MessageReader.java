package deepThoughtV2;
import java.util.*;
import java.io.*;

public class MessageReader extends Message{

	public MessageReader() {
		
	read();
	}
	
	
	//Overriding read() to read from the file instead of the ArrayList
	String read(){
		String message=null;

		
			Scanner scanner = null;
			try {
				scanner = new Scanner(new FileReader(FILE_NAME));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (scanner.hasNextLine()) { // to avoid reading past the end of the file
				message = message + "\n"+ (scanner.nextLine());	//appending the string with the next string and a new line
				
			}
			scanner.close();
	
		return message +"\n\n  from the child read function "; 
	}


 
}

