/**
 * @author Marcus
 * Date created: 1/21/26
 * Last modified: 1/24/26
 * Purpose: Tower of Hanoi
 */
 
import java.util.ArrayList;
import java.util.List;

/**
 * Tower of Hanoi Lab
 * 
 * The Tower of Hanoi is a classic problem that demonstrates recursion.
 * 
 * Rules:
 * - You have 3 pegs (A, B, C) and n disks of different sizes
 * - All disks start on peg A, sorted by size (largest at bottom)
 * - Goal: Move all disks from peg A to peg C
 * - Only one disk can be moved at a time
 * - A larger disk can never be placed on top of a smaller disk
 * 
 * Recursive solution:
 * To move n disks from source to destination using auxiliary peg:
 *   1. Move n-1 disks from source to auxiliary (using destination as helper)
 *   2. Move the largest disk from source to destination
 *   3. Move n-1 disks from auxiliary to destination (using source as helper)
 * 
 * @author Marcus Prado
 */
 
public class tower_hanoi_starter {
    
    // Part 3: Move counter (you'll add this)
    private static int moveCount = 0;
    
    // Create each peg as an array
    static ArrayList<Integer> pegA = new ArrayList<>();
    static ArrayList<Integer> pegB = new ArrayList<>();
    static ArrayList<Integer> pegC = new ArrayList<>();

    /**
     * PART 1: Implement the classic Tower of Hanoi solver
     * 
     * TODO: Implement this recursive method
     * 
     * Base case: if n == 1, move disk from source to destination
     * Recursive case:
     *   1. Move n-1 disks from source to auxiliary (using destination)
     *   2. Move disk n from source to destination
     *   3. Move n-1 disks from auxiliary to destination (using source)
     * 
     * @param n number of disks to move
     * @param source the source peg (e.g., 'A')
     * @param destination the destination peg (e.g., 'C')
     * @param auxiliary the auxiliary peg (e.g., 'B')
     */
     
    public static void moveDisks(int n, char source, char destination, char auxiliary) {
            // TODO: Implement base case
        if (n == 1) {
            System.out.println("\nMove disk " + n + " from " + source + " to " + destination);
            //Call displayTower to display move
            displayTowers(source, destination);
            //Increase moveCount
            moveCount++;
        } else {
            // TODO: Implement recursive case (3 steps)
            moveDisks(n-1, source, auxiliary, destination);
            System.out.println("\nMove disk " + n + " from " + source + " to " + destination);
            //Call displayTower to display move
            displayTowers(source, destination);
            //Increase moveCount
            moveCount++;
            moveDisks(n-1, auxiliary, destination, source);
        }
        
    }
    
    /**
     * PART 2: Add visualization
     * 
     * Modify this method to display the state of the towers after each move.
     * 
     * You can represent the towers however you like. Example:
     * A: [3, 2, 1]
     * B: []
     * C: []
     * 
     * Or get creative with ASCII art!
     * 
     * Hint: You'll need to track which disks are on which peg.
     * Consider using ArrayList<Integer> for each peg.
     */
    
    public static void displayTowers(char source, char destination) {
        //Create copies of the source and destination peg. Initialized with a placement holder
        ArrayList<Integer> src = pegA;
        ArrayList<Integer> des = pegC;
        
        //Based on the char of the source and destination, replace value with correct peg.
        switch (source) {
            case 'A':
                src = pegA;
                break;
            case 'B':
                src = pegB;
                break;
            case 'C':
                src = pegC;
                break;
            default:
                System.out.println("HELP ME");
        }
        switch (destination) {
            case 'A':
                des = pegA;
                break;
            case 'B':
                des = pegB;
                break;
            case 'C':
                des = pegC;
                break;
            default:
                System.out.println("HELP ME");
        }
        
        //Add the highest disk on the source peg(Last value of list) and add it to the destination peg
        des.add(src.get(src.size()-1));
        //Remove the highest disk on the source peg
        src.remove(src.size()-1);
        
        // TODO: Implement tower visualization
        System.out.println("--- Tower State ---");
        // Display pegs A, B, C and their disks
        System.out.println("A: " + pegA);
        System.out.println("B: " + pegB);
        System.out.println("C: " + pegC);
        
    }
    
    /**
     * Part 2a: Populate towers
     * Add the amount of discs needed starting at peg A
     * 
     */
    public static void populateTowers(int n, ArrayList<Integer> tower){
        //Based on the amount of disks, add the disks by largest to smallest
        for (int i = n; i > 0; i--){
            tower.add(i);
        }
    }
    
    /**
     * PART 3: Add move counting and validation
     * 
     * Enhance your solution to:
     * 1. Count total moves
     * 2. Verify the solution uses the minimum number of moves (2^n - 1)
     * 3. Optional: Add validation to ensure no illegal moves
     */
    public static void printStatistics(int n) {
        // TODO: Print statistics
        System.out.println("\n=== Statistics ===");
        System.out.println("Number of disks: " + n);
        System.out.println("Total moves: " + moveCount);
        System.out.println("Minimum possible moves: " + ((int)Math.pow(2, n) - 1));
        
        // Verify correctness
        if (moveCount == (int)Math.pow(2, n) - 1) {
            System.out.println("SUCCESS! Optimal solution.");
        } else {
            System.out.println("WARNING: Not optimal.");
        }
    }
    
    public static void main(String[] args) {
        int n = 3; // Start with 3 disks
        
        System.out.println("Tower of Hanoi - " + n + " disks");
        System.out.println("Moving disks from A to C using B\n");
        
        // Tower of Hanoi with 3 disks
        // Populate the pegs    
        populateTowers(n, pegA);
        // Reset move counter
        moveCount = 0;
        // Solve the puzzle
        moveDisks(n, 'A', 'C', 'B');
        // Reset pegs
        pegC.clear();
        // Display statistics
        printStatistics(n);
        
        // Tower of Hanoi with 4 disks
        System.out.println("\n\n=== Try with 4 disks ===");
        populateTowers(4, pegA);
        moveCount = 0;
        moveDisks(4, 'A', 'C', 'B');
        pegC.clear();
        printStatistics(4);
        
        //Tower of Hanoi with 5 disks
        System.out.println("\n\n=== Try with 5 disks ===");
        populateTowers(5, pegA);
        moveCount = 0;
        moveDisks(5, 'A', 'C', 'B');
        pegC.clear();
        printStatistics(5);
        
        //Tower of Hanoi with 7 disks
        System.out.println("\n\n=== Try with 7 disks ===");
        populateTowers(7, pegA);
        moveCount = 0;
        moveDisks(7, 'A', 'C', 'B');
        pegC.clear();
        printStatistics(7);
    }
}
