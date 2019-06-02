public class SecondAttemptState extends DownloadingRegion{
    protected MovieStreamer context;
    private MovieStreamerState superContext;

    public SecondAttemptState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public void entry() {
        System.out.println("enter SecondAttempt state");
        if (context.getSystemManager().getAvailableSpace() >= context.getCurrentDownloadFile().getRequiredSize()){
            context.getCurrentDownloadFile().setDownloaded(0);
            superContext.setState(context.getDownloadState());
        }
        else{
            superContext.setState(context.getIdleState());
        }
    }

    @Override
    public void Do() {

    }

    public void timeEvent(){
        exit();
    }

    @Override
    public void exit() {
        System.out.println("exit SecondAttempt state");
        if (context.getSystemManager().getAvailableSpace() >= context.getCurrentDownloadFile().getRequiredSize()){
            context.getCurrentDownloadFile().setDownloaded(0);
            superContext.setState(context.getDownloadState());
        }
        else{
            superContext.setState(context.getIdleState());
        }
    }
}
