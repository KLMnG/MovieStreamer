public class DownloadingRegion extends InternetConnectedState {

    protected MovieStreamer context;

    private MovieStreamerState superContext;
    private MovieStreamerState currentState;

    public DownloadingRegion(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer);
        this.context = streamer;
        this.superContext = superContext;
    }

    public void setState(MovieStreamerState state){
        this.currentState = state;
        this.currentState.entry();
        this.currentState.Do();
    }




}
