public class InternetConnectedState extends InternetConnectionRegion{



    protected MovieStreamer context;
    private MovieStreamerState superContext;

    private MovieStreamerState currentDownloadManagerStateState;
    private MovieStreamerState currentDownloadRegionState;
    private MovieStreamerState currentMovieStreamerRegion;

    public InternetConnectedState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        this.context = streamer;
        this.superContext = superContext;
    }


    @Override
    public void entry() {
        System.out.println("enter InternetConnected state");
    }

    @Override
    public void exit() {
        System.out.println("exit InternetConnected state");
    }

    @Override
    public void internetOff() {
        exit();
        superContext.setState(context.getInternetConnectedState());
    }

    @Override
    public void Do() {

    }

    @Override
    public void movieOn() {
        currentDownloadManagerStateState.movieOn();
        currentDownloadRegionState.movieOn();
        currentMovieStreamerRegion.movieOn();
    }

    @Override
    public void doneDownload() {
        currentDownloadManagerStateState.doneDownload();
        currentDownloadRegionState.doneDownload();
        currentMovieStreamerRegion.doneDownload();
    }

    @Override
    public void holdMovie() {
        currentDownloadManagerStateState.holdMovie();
        currentDownloadRegionState.holdMovie();
        currentMovieStreamerRegion.holdMovie();
    }

    @Override
    public void downloadError() {
        currentDownloadManagerStateState.downloadError();
        currentDownloadRegionState.downloadError();
        currentMovieStreamerRegion.downloadError();
    }

    @Override
    public void restart() {
        currentDownloadManagerStateState.restart();
        currentDownloadRegionState.restart();
        currentMovieStreamerRegion.restart();
    }

    @Override
    public void downloadAborted() {
        currentDownloadManagerStateState.downloadAborted();
        currentDownloadRegionState.downloadAborted();
        currentMovieStreamerRegion.downloadAborted();
    }

    @Override
    public void resume() {
        currentDownloadManagerStateState.resume();
        currentDownloadRegionState.resume();
        currentMovieStreamerRegion.resume();
    }

    @Override
    public void errorFixed() {
        currentDownloadManagerStateState.errorFixed();
        currentDownloadRegionState.errorFixed();
        currentMovieStreamerRegion.errorFixed();
    }

    @Override
    public void moviePending() {
        currentDownloadManagerStateState.moviePending();
        currentDownloadRegionState.moviePending();
        currentMovieStreamerRegion.moviePending();
    }

    @Override
    public void internetOn() {
        currentDownloadManagerStateState.internetOn();
        currentDownloadRegionState.internetOn();
        currentMovieStreamerRegion.internetOn();
    }

    @Override
    public void fileRequest() {
        currentDownloadManagerStateState.fileRequest();
        currentDownloadRegionState.fileRequest();
        currentMovieStreamerRegion.fileRequest();
    }

    @Override
    public void removed() {
        currentDownloadManagerStateState.removed();
        currentDownloadRegionState.removed();
        currentMovieStreamerRegion.removed();
    }

    @Override
    public void turnOn() {
        currentDownloadManagerStateState.turnOn();
        currentDownloadRegionState.turnOn();
        currentMovieStreamerRegion.turnOn();
    }

    @Override
    public void turnOff() {
        currentDownloadManagerStateState.turnOff();
        currentDownloadRegionState.turnOff();
        currentMovieStreamerRegion.turnOff();
    }
}
