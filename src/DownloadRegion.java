public class DownloadRegion extends InternetConnectedState {


    protected MovieStreamer context;
    private MovieStreamerState superContext;
    private MovieStreamerState currentState;
    private MovieStreamerState downloadHistory;


    public DownloadRegion(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        context = streamer;
        this.superContext = superContext;

        downloadHistory = streamer.getIdleState();
        currentState = streamer.getIdleState();
    }

    @Override
    public void entry() {
        this.setState(downloadHistory);
    }

    @Override
    public void exit() {

    }

    @Override
    public void Do() {

    }

    @Override
    public void movieOn() {

    }

    @Override
    public void doneDownload() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void restart() {

    }

    @Override
    public void downloadAborted() {
        currentState.downloadAborted();
    }

    @Override
    public void resume() {

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
        currentState.internetOff();
    }

    @Override
    public void internetOn() {
        this.setState(downloadHistory);
        currentState.internetOn();
    }

    @Override
    public void fileRequest() {
        this.moviePending();
    }

    @Override
    public void removed() {

    }

    @Override
    public void turnOn() {
        this.setState(downloadHistory);
        currentState.turnOn();
    }

    @Override
    public void turnOff() {
        currentState.turnOff();
    }

    @Override
    public void setState(MovieStreamerState state) {
        currentState = state;
        downloadHistory = state;
        currentState.entry();
        currentState.Do();
    }
}
