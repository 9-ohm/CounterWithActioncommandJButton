public class Counter{
    private int count;

    public Counter(){
        count = 0;
    }

    public int getValue(){
        return count;
    }

    public void count(int i){
        count+=i;
    }

    public void reset(){
        count = 0;
    }
}