package Model;

public class ToDoTask {
    private int ident;
    private String description;
    private boolean isDone;



    public ToDoTask(String description, boolean isDone, int ident) {
        this.description = description;
        this.isDone = isDone;
        this.ident = ident;
    }


}
