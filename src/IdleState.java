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

    @Override
    public void downloadAborted() {
        if (this.context.getCurrentDownloadFile().getId() != 5){
            //File need to be equal null
            superContext.setState(context.getIdleState());
        }
    }

    public void timeEvent(){
        exit();
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
    public void resume() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void internetOn() {

    }

    @Override
    public void fileRequest(File f) {
        this.moviePending();
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
