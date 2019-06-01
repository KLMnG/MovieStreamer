import java.util.PriorityQueue;
import java.util.Queue;

public class MovieStreamer {



    private Queue<File> fileReuqestQueue;
    private MovieStreamerState onState;
    private MovieStreamerState offState;

    private MovieStreamerState currentState;


    public MovieStreamer(){
        onState = new OnState(this);
        offState = new OffState(this);
        fileReuqestQueue = new PriorityQueue<>();
    }

    public MovieStreamerState getOnState() {
        return onState;
    }

    public MovieStreamerState getOffState() {
        return offState;
    }

    public void setState(MovieStreamerState state){
        this.currentState = state;
    }

    public Queue<File> getFileReuqestQueue() {
        return fileReuqestQueue;
    }
}
