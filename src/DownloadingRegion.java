public class DownloadingRegion extends InternetConnectedState {

    protected MovieStreamer context;

    private MovieStreamerState superContext;
    private MovieStreamerState currentState;
    private MovieStreamerState downloadHistory;

    public DownloadingRegion(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        this.context = streamer;
        this.superContext = superContext;

        downloadHistory = null;
        currentState = null;

    }

    public void setState(MovieStreamerState state){
        this.currentState = state;
        downloadHistory = state;
        this.currentState.entry();
        this.currentState.Do();
    }

    public void entry() {
        currentState = context.getIdleState();
        if (downloadHistory != null)
            currentState = downloadHistory;
        setState(currentState);
    }

    @Override
    public void exit() {
        currentState.exit();
    }

    @Override
    public void internetOff() {
        currentState.internetOff();
    }

    @Override
    public void Do() {
        currentState.Do();
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
    public void internetOn() {
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
