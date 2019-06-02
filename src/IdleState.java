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
        System.out.println("enter Idle state");
        if (context.getFileReuqestQueue().size() >= 0){
            exit();
        }
    }

    @Override
    public void Do() {

    }

    @Override
    public void exit() {
        System.out.println("exit Idle state");
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
