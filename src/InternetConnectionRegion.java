public class InternetConnectionRegion extends OnState{

    protected MovieStreamer context;
    private MovieStreamerState superContext;

    private MovieStreamerState currentState;

    public InternetConnectionRegion(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public void setState(MovieStreamerState state) {
        currentState = state;
        currentState.entry();
        currentState.Do();
    }


    @Override
    public void entry() {
        this.setState(context.getInternetDisconnectedState());
    }

    @Override
    public void exit() {

    }

    @Override
    public void Do() {

    }

    @Override
    public void movieOn() {
        currentState.movieOn();
    }

    @Override
    public void doneDownload() {
        currentState.doneDownload();
    }

    @Override
    public void holdMovie() {
        currentState.holdMovie();
    }

    @Override
    public void downloadError() {
        currentState.downloadError();
    }

    @Override
    public void restart() {
        currentState.restart();
    }

    @Override
    public void downloadAborted() {
        currentState.downloadAborted();
    }

    @Override
    public void resume() {
        currentState.resume();
    }

    @Override
    public void errorFixed() {
        currentState.errorFixed();
    }

    @Override
    public void moviePending() {
        currentState.moviePending();
    }

    @Override
    public void internetOff() {
        this.setState(context.getInternetDisconnectedState());
        currentState.internetOff();
    }

    @Override
    public void internetOn() {
        this.setState(context.getInternetConnectedState());
        currentState.internetOn();
    }

    @Override
    public void fileRequest(File f) {
        currentState.fileRequest(f);
    }

    @Override
    public void removed() {
        currentState.removed();
    }

    @Override
    public void turnOn() {
        currentState.turnOn();
    }

    @Override
    public void turnOff() {
        currentState.turnOff();
    }
}
