import java.util.Random;

public class ComboLock {
    Random rand = new Random();
    private int secret1 = 10; //rand.nextInt(0,40);
    private int secret2 = 20 //rand.nextInt(0, 40);
    private int secret3 = 30; //rand.nextInt(0, 40);
    private boolean state1 = false;
    private boolean state2 = false;
    private boolean state3 = false;


    public boolean turnRight(int num){
        if(this.state2 == true){
            if(num == this.secret3){
                this.state3 = true;
                return true;
            }
        }
        else if (num == this.secret1) {
            this.state1 = true;
            return true;
        }
        return false;
    }
    public boolean turnLeft(int num){
        if(num == this.secret2){
            this.state2 = true;
            return true;
        }
        return false;
    }

    public void resetLock(){
        this.state1 = false;
        this.state2 = false;
        this.state3 = false;
    }

    public boolean open(){
        if(this.state1 == true && this.state2 == true && this.state3 == true){
            return true;
        }
        return false;
    }


}
