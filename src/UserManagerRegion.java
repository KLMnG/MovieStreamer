public class UserManagerRegion extends OnState {


    private MovieStreamerState currentState;
    private MovieStreamerState superContext;
    private MovieStreamer streamer;

    public UserManagerRegion(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer);
        this.superContext=superContext;
        this.streamer=streamer;
    }

    @Override
    public void setState(MovieStreamerState state) {
       this.currentState=state;
       this.currentState.entry();
       this.currentState.Do();
    }

    @Override
    public void entry() {
        setState(streamer.getBeginnerState());

    }

    @Override
    public void exit() {
        this.currentState.exit();

    }

    @Override
    public void Do() {
    }

    @Override
    public void movieOn() {
        this.currentState.movieOn();
    }

    @Override
    public void doneDownload() {
        this.currentState.doneDownload();
    }

    @Override
    public void holdMovie() {
        this.currentState.holdMovie();
    }

    @Override
    public void downloadError() {
        this.currentState.downloadError();
    }

    @Override
    public void restart() {
        this.currentState.restart();
    }

    @Override
    public void downloadAborted() {
        this.currentState.downloadAborted();
    }

    @Override
    public void resume() {
        this.currentState.resume();
    }

    @Override
    public void errorFixed() {
        this.currentState.errorFixed();
    }

    @Override
    public void moviePending() {
        this.currentState.moviePending();
    }

    @Override
    public void internetOff() {
        this.currentState.internetOff();
    }

    @Override
    public void internetOn() {
        this.currentState.internetOn();
    }

    @Override
    public void fileRequest(File f) {
        this.currentState.fileRequest(f);
    }

    @Override
    public void removed() {
        this.currentState.removed();
    }

    @Override
    public void turnOn() {
        this.currentState.turnOn();
    }

    @Override
    public void turnOff() {
        this.currentState.turnOff();
    }

}
