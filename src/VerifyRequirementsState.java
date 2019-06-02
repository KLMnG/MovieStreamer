public class VerifyRequirementsState extends DownloadingRegion{

    protected MovieStreamer context;
    private MovieStreamerState superContext;

    public VerifyRequirementsState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public void entry() {
        System.out.println("enter VerifyRequirements state");
        File f = context.getFileReuqestQueue().poll();
        context.setCurrentDownloadFile(f);
        if (context.getSystemManager().getAvailableSpace() >= context.getCurrentDownloadFile().getRequiredSize())
            context.getCurrentDownloadFile().setDownloaded(0);
        exit();
    }

    @Override
    public void Do() {

    }

    @Override
    public void exit() {
        System.out.println("exit VerifyRequirements state");
        if (context.getSystemManager().getAvailableSpace() >= context.getCurrentDownloadFile().getRequiredSize()){
            superContext.setState(context.getDownloadState());
        }
        else{
            superContext.setState(context.getSecondAttemptState());
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
    public void fileRequest() {

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
