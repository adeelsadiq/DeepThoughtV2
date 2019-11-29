package deepThoughtV2;	
import java.util.ArrayList;
import java.util.Random;

	//the parent class for the  MessageReader and MessageWriter. 
public class Message {
		int numberAnswer; 
		public static String FILE_NAME = "log.txt"; //the filename is static as its the only one being used across the program
		
		protected String mainMessage; 
		protected String answer;
		//Array of predefined answers
		String answers[]= {"The answer is 42!","The Answer is *DRAMATIC PAUSE* ..... 42!!!",
				"42","Its 42","Its 42 ok, now stop bugging me",
				"Like seriously its 42","interesting question, let me think about it... nope its still 42",
				"do some work yourself its 20+20+2",
				"Its 101010","your answer in hex is 0x2A","You again? I told you already, its 42!",
				"All this brain and I am answering questions like this, *sigh the answer is 42",
				"The answer is 24 written backwards","Ok Stop! its never going to be anything othe than 42!",};
		
		static ArrayList <String> messages = new ArrayList<String>(); //initiating String type array list to add the Q&A to it in overloaded constructor 
		//we made the array list static so it is not created each time locally and overwritten 
		
		public Message() {
			//constructor
			numberAnswer = new Random().nextInt(14); //this will give us a new random number on each access that we can use to access the answers array element at random
		}
		//constructor overloading 
		public Message(String input) {
			if (input != null) { //check if the incoming string is not empty
				
				messages.add(input);  //adding the incoming string to the ArrayList
				
				System.out.println(input); //printing the input to console
				
//				System.out.println("size of messages is "+messages.size()); //to check how big the arraylist is 
			}else {
				System.out.println("The input was not found"); //print if the input was empty
			}
			
		}
		//encapsulation
		public void setMainMessage(String text) { //mainMessage setter
			this.mainMessage=text;
			
		}
		
		public String getMainMessage() { //mainMessage getter
			return this.mainMessage;
		}

		String getAnswer() { //returns a random answer from the array of predefined strings
			this.answer=answers[numberAnswer];
			return answer;	
		}
		String read() { //reads from the ArrayList, so it will only include the current session and no history from the file
			String readOut = null;
			for (int i = 0; i < messages.size(); i++) {
				readOut = readOut + messages.get(i);
			}

			
			return readOut+ "\n  from the parent reader"; //added string is just to show which reader method is being used.
		}
}
