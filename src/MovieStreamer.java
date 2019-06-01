public class MovieStreamer {


private MovieStreamerState onState;
private MovieStreamerState offState;

private MovieStreamerState currentState;


    public MovieStreamer(){
        onState = new OnState(this);
        offState = new OffState(this);
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
}
