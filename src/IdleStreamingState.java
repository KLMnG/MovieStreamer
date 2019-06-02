public class IdleStreamingState extends InternetConnectionRegion {

    MovieStreamerState superContext;
    MovieStreamer streamer;
    String name;

    public IdleStreamingState(MovieStreamer streamer, MovieStreamerState superContext) {
        super(streamer, null);
        this.streamer = streamer;
        this.superContext = superContext;
        this.name = "IdleStreamingState";
    }


    @Override
    public void setState(MovieStreamerState state) {

    }

    @Override
    public void entry() {
        System.out.println("enter " + name + " state");
    }

    @Override
    public void exit() {
        System.out.println("exit " + name + " state");
    }

    @Override
    public void Do() {

    }

    @Override
    public void movieOn() {
        if (streamer.getCurrentDownloadFile().getDownloaded() >= 0.2 * streamer.getCurrentDownloadFile().getRequiredSize() &&
                streamer.getDownloadRegionState().getCurrentState() == streamer.getDownloadState()) {
            exit();
            superContext.setState(streamer.getStreamingState());
        }
    }

    @Override
    public void doneDownload() {
        exit();
       this.superContext.setState(streamer.getIdleStreamingState());
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
        exit();
        this.superContext.setState(streamer.getIdleStreamingState());
    }

    @Override
    public void resume() {
    }

    @Override
    public void errorFixed() {
    }

    @Override
    public void moviePending() {
    }

    @Override
    public void internetOff() {
    }

    @Override
    public void internetOn() {
    }

    @Override
    public void fileRequest() {
    }

    @Override
    public void removed() {
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void setState(OnState state) {
    }
}
