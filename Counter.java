public class Counter{
    private int count;

    public Counter(){
        count = 0;
    }

    public int getValue(){
        return count;
    }

    public void count(){
        count++;
    }

    public void reset(){
        count = 0;
    }
}