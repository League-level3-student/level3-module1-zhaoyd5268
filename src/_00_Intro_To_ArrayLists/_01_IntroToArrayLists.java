package _00_Intro_To_ArrayLists;
import java.util.ArrayList;
public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    	ArrayList <String> nice = new ArrayList <String>();
        // 2. Add five Strings to your list
    	nice.add("happy");
    	nice.add("sad");
    	nice.add("joyful");
    	nice.add("disgusted");
    	nice.add("joyous");
        // 3. Print all the Strings using a standard for-loop
    	for(int i = 0; i < nice.size(); i++) {
    		System.out.println(nice.get(i));
    	}
        // 4. Print all the Strings using a for-each loop
    	for (String words : nice) {
    		System.out.println(words);
    	}
        // 5. Print only the even numbered elements in the list.
      	for(int i = 0; i < nice.size(); i++) {
      		if (i % 2 == 0) {
      			System.out.println(nice.get(i));
      		}
      	}
          // 6. Print all the Strings in reverse order.
      	for(int i = nice.size()-1; i > -1; i--) {
      			System.out.println(nice.get(i));
      	}
          // 7. Print only the Strings that have the letter 'e' in them.
      	for(int i = 0; i < nice.size(); i++) {
      		if (nice.get(i).contains("e")) {
      			System.out.println(nice.get(i));
      		}
      	}
    }
}
