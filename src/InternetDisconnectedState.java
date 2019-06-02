public class InternetDisconnectedState extends InternetConnectionRegion{

    protected MovieStreamer context;
    private MovieStreamerState superContext;

    private MovieStreamerState currentState;

    public InternetDisconnectedState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        this.context = streamer;
        this.superContext = superContext;
    }


    @Override
    public void entry() {
        System.out.println("enter InternetDisconnected state");
    }

    @Override
    public void exit() {
        System.out.println("exit InternetDisconnected state");
    }

    @Override
    public void internetOn() {
        exit();
        superContext.setState(context.getInternetConnectedState());
    }

    @Override
    public void Do() {

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
    public void internetOff() {

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
    public void turnOff() {

    }
}
