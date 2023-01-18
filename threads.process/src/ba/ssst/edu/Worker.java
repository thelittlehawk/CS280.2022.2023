package ba.ssst.edu;

public class Worker implements Runnable {
    private int number;

    private boolean completed;

    public Worker(int number) {
        this.number = number;
        this.completed = false;
    }

    @Override
    public void run() {
        System.out.println("Worker class! (" + this.number + ")");
        this.completed = true;
    }

    public boolean isCompleted() {
        return this.completed;
    }
}
