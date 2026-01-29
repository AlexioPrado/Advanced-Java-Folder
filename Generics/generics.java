/**
 * Name: Marcus Prado
 * Date: 1/28/26
 * Purpose: User enter 5 strings and output user's input in reverse
 * 
 */

import java.util.*;

public class generics {
    public static void main(String[] args){
        //Create Scanner and stack of user inputs
        Scanner input = new Scanner(System.in);
        GenericStack<String> stack = new GenericStack<>();

        //Ask for input 5 times and push it into stack
        System.out.println("Enter five strings: ");
        for (int i = 1; i<=5; i++){
            stack.push(input.nextLine());
        }

        //Output stack in reverse
        System.out.println("Outputting String in Reverse Order: ");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }


        input.close();
    }
}