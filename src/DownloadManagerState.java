public class DownloadManagerState extends InternetConnectedState{


    protected MovieStreamer context;
    private MovieStreamerState superContext;


    public DownloadManagerState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        this.context = streamer;
        this.superContext = superContext;
    }


    @Override
    public void entry() {
        System.out.println("enter DownloadManager state");
    }

    @Override
    public void exit() {
        System.out.println("exit DownloadManager state");
    }

    @Override
    public void moviePending() {

    }

    @Override
    public void fileRequest(File f) {
        context.getFileReuqestQueue().add(f);
    }

    @Override
    public void downloadAborted() {
        if (context.getFileReuqestQueue().contains(null))
            context.getFileReuqestQueue().remove(null);
    }

    @Override
    public void internetOff() {
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
    public void resume() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void internetOn() {

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
