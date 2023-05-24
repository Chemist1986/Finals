package Final_work.Core.Infrastructure;

public class Counter implements AutoCloseable {

    private int count;
    private boolean flag;
    
    public Counter() {
        this.count = 0;
        this.flag = true;
    }

    public void add() throws OutResourseException {
        if (flag) {
            this.count++;
        } else {
            throw new OutResourseException(); 
        }
    }

    public void remove() throws OutResourseException {
        if (flag) {
            if(this.count > 0) {
                this.count--;
            }
        } else {
            throw new OutResourseException(); 
        }
    } 

    public int getCount() {
        return this.count;
    }

    public void setCount(int value) {
        this.count = value;
    } 

    @Override
    public void close() throws Exception {
        this.flag = false;
    }
    
}
