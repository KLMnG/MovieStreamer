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
        File f = context.getFileReuqestQueue().poll();
        context.setCurrentDownloadFile(f);
    }

    @Override
    public void Do() {

    }

    @Override
    public void exit() {
        if (context.getSystemManager().getAvailableSpace() >= context.getCurrentDownloadFile().getRequiredSize()){
            context.getCurrentDownloadFile().setDownloaded(0);
            superContext.setState(context.getDownloadState());
        }
        else{
            superContext.setState(context.getSecondAttemptState());
        }
    }
}
