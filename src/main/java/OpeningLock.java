import java.util.Scanner;
import static java.lang.System.exit;

public class OpeningLock {

    public static void main(String[] args) {

        ComboLock lock = new ComboLock();
        int guess;
        System.out.println("Welcome to the Lock Opening minigame!");
        System.out.println("blabla rules");

        while(!lock.open()){
            guess = OpeningLock.input();
            if(lock.turnRight(guess)){
                guess = OpeningLock.input();
                if(lock.turnLeft(guess)){
                    guess = OpeningLock.input();
                    if(lock.turnRight(guess)){
                        System.out.println("You opened the lock! Congratulations");
                        System.exit(0);
                    }
                }
            }
            lock.resetLock();
            System.out.println("Wrong number! BZZZT");
        }

    }

    public static int input(){
        boolean check = true;
        int guess = 0;
        System.out.println("Type in your guess:");

        while(check){
            Scanner keyboard = new Scanner(System.in);

            if(keyboard.hasNextInt()){
                guess = keyboard.nextInt();
                check = false;
            }
            else{
                System.out.println("Please input an integer:");
            }
        }
        return guess;
    }

}
