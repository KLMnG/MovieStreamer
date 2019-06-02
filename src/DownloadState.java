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
}
