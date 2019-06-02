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
}
