public class PauseState extends MovieStreamerRegion{
    MovieStreamerState superContext;
    MovieStreamer streamer;
    String name;

    public PauseState(MovieStreamer streamer, MovieStreamerState superContext) {
        super(streamer);
        this.streamer = streamer;
        this.superContext = superContext;
        this.name = "PauseState";
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
      if(streamer.getDownloadRegionState().getCurrentState()!=streamer.getdErrorState()){
          exit();
          this.superContext.setState(streamer.getStreamingState());
      }
    }

    @Override
    public void errorFixed() {
        exit();
        this.superContext.setState(streamer.getStreamingState());
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
    public MovieStreamerState getCurrentState() {
        return null;
    }
}
