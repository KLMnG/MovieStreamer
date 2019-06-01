public class IdleState extends DownloadingRegion{

    protected MovieStreamer context;
    private MovieStreamerState superContext;

    public IdleState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public void entry() {

    }

    @Override
    public void Do() {
        if (context.getFileReuqestQueue().size() >= 0){
            exit();
        }
    }

    @Override
    public void exit() {
        superContext.setState(context.getVerifyRequirementState());
    }

    @Override
    public void moviePending() {
        exit();
    }

    public void timeEvent(){
        exit();
    }

}
