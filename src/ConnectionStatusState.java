public class ConnectionStatusState extends OnState{

    protected MovieStreamer context;
    private MovieStreamerState superContext;


    public ConnectionStatusState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public MovieStreamerState getCurrentState() {
        return this;
    }

    @Override
    public void entry() {
        System.out.println("enter ConnectionStatus state");
        //context.CheckConnection();
    }

    @Override
    public void exit() {
        System.out.println("exit ConnectionStatus state");
    }

    @Override
    public void Do() {

    }

    @Override
    public void turnOff() {

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
}
