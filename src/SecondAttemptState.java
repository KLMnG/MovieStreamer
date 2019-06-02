public class SecondAttemptState extends DownloadingRegion {
    protected MovieStreamer context;
    private MovieStreamerState superContext;

    public SecondAttemptState(MovieStreamer streamer, MovieStreamerState superContext) {
        super(streamer, superContext);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public void entry() {
        System.out.println("enter SecondAttempt state");
        if (context.getSystemManager().getAvailableSpace() >= context.getCurrentDownloadFile().getRequiredSize()) {
            context.getCurrentDownloadFile().setDownloaded(0);
            exit();
            superContext.setState(context.getDownloadState());
        }
    }

    @Override
    public void Do() {
        timeEvent();
    }

    public void timeEvent() {
        exit();
        superContext.setState(context.getIdleState());
    }

    @Override
    public void exit() {
        System.out.println("exit SecondAttempt state");
        if (context.getSystemManager().getAvailableSpace() >= context.getCurrentDownloadFile().getRequiredSize()) {
            context.getCurrentDownloadFile().setDownloaded(0);
            superContext.setState(context.getDownloadState());
        } else {
            superContext.setState(context.getIdleState());
        }
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
        if (this.context.getCurrentDownloadFile().getId() != 5) {
            context.setCurrentDownloadFile(null);
            exit();
            superContext.setState(context.getIdleState());
        }
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
    public void internetOff() {

    }

    @Override
    public void turnOff() {

    }
}
