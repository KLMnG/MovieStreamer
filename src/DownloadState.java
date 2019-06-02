public class DownloadState extends DownloadingRegion {

    protected MovieStreamer context;
    private MovieStreamerState superContext;

    public DownloadState(MovieStreamer streamer, MovieStreamerState superContext) {
        super(streamer, superContext);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public void entry() {
        System.out.println("enter Download state");
    }

    @Override
    public void Do() {
        while (context.getCurrentDownloadFile().getDownloaded() < context.getCurrentDownloadFile().getRequiredSize()){
            context.getCurrentDownloadFile().setDownloaded(context.getCurrentDownloadFile().getDownloaded() + 1);
        }
        context.getSystemManager().setAvailableSpace(context.getSystemManager().getAvailableSpace() - context.getCurrentDownloadFile().getRequiredSize());
        exit();
        superContext.setState(context.getIdleState());
    }

    @Override
    public void exit() {
        System.out.println("exit Download state");
    }


    @Override
    public void downloadError() {
        exit();
        superContext.setState(context.getdErrorState());
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
    public void restart() {

    }

    @Override
    public void downloadAborted() {
        if (this.context.getCurrentDownloadFile().getId() != 5){
            //File need to be equal null
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
