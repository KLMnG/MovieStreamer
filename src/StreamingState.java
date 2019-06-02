public class StreamingState extends MovieStreamerRegion {

    MovieStreamerState superContext;
    MovieStreamer streamer;
    String name;

    public StreamingState(MovieStreamer streamer, MovieStreamerState superContext) {
        super(streamer,superContext);
        this.streamer = streamer;
        this.superContext = superContext;
        this.name = "StreamingState";
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
        while (streamer.getCurrentDownloadFile().getStreamedTime() <= streamer.getCurrentDownloadFile().getDownloaded()) {
            streamer.getCurrentDownloadFile().setStreamedTime(streamer.getCurrentDownloadFile().getStreamedTime() + 1);
        }
    }

    @Override
    public void movieOn() {

    }

    @Override
    public void doneDownload() {
        exit();
        this.superContext.setState(streamer.getIdleStreamingState());
    }

    @Override
    public void holdMovie() {
        exit();
        superContext.setState(streamer.getPauseState());
    }

    @Override
    public void downloadError() {
        exit();
        superContext.setState(streamer.getPauseState());
    }

    @Override
    public void restart() {
        exit();
        streamer.getCurrentDownloadFile().setStreamedTime(0);
        superContext.setState(streamer.getStreamingState());
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
    public void fileRequest(File f) {
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
    public MovieStreamerState getCurrentState() {
        return this;
    }
}
