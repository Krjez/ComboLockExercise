import java.util.Scanner;
import static java.lang.System.exit;

/**Jakub Polacek
 * 29.9.2023
 * Small exercise made during class
 * No sample code used
 */
public class OpeningLock {

    public static void main(String[] args) {

        ComboLock lock = new ComboLock(); //Creating of the lock object
        int guess; //number used for changing player input

        System.out.println("Welcome to the Lock Opening minigame!");
        System.out.println("You are going to guess 3 numbers on a standard combo lock.");
        System.out.println("The numbers are going to be random ones in a range of 0 to 39");
        System.out.println("Each time you fail, the lock is going to reset.");
        System.out.println("Good luck finding the right combination");
        System.out.println();

        while(!lock.open()){ //The main game logic
            guess = OpeningLock.input();

            if(lock.turnRight(guess)){
                System.out.println("*CLICK* First number correct");
                guess = OpeningLock.input();

                if(lock.turnLeft(guess)){
                    System.out.println("*CLICK* Second number correct");
                    guess = OpeningLock.input();

                    if(lock.turnRight(guess)){
                        System.out.println("You opened the lock! Congratulations");
                        System.exit(0);
                    }
                }
            }
            //On any mistake, resets lock and displays the message
            lock.resetLock();
            System.out.printf("Wrong number! BZZZT\n*The lock resets*\n\n");
        }

    }

    public static int input(){
        boolean check = true;
        int guess = 0;

        //Player input with error handling
        while(check){
            System.out.println("Type in your guess:");
            Scanner keyboard = new Scanner(System.in);

            if(keyboard.hasNextInt()){
                guess = keyboard.nextInt();
                if(0 <= guess && guess<= 39){
                    check = false;
                }
                else{
                    System.out.println("Integer is not in range.");
                }
            }
            else{
                System.out.println("Please input an integer:");
            }
        }
        return guess;
    }

}
