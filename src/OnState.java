public class OnState implements MovieStreamerState{

    private MovieStreamerState userManagerRegion;
    private MovieStreamerState internetConnectionRegion;
    private MovieStreamerState connectionStatusState;

    protected MovieStreamer context;


    @Override
    public void setState(MovieStreamerState state) {

    }

    @Override
    public MovieStreamerState getCurrentState() {
        return this;
    }

    @Override
    public void entry() {
        userManagerRegion = context.getUserManagerRegion();
        internetConnectionRegion = context.getInternetConnectionRegion();
        connectionStatusState = context.getConnectionStatusState();
        System.out.println("enter On state");
        userManagerRegion.entry();
        internetConnectionRegion.entry();
        connectionStatusState.entry();
        userManagerRegion.Do();
        internetConnectionRegion.Do();
        connectionStatusState.Do();

    }

    @Override
    public void exit() {
        userManagerRegion.exit();
        internetConnectionRegion.exit();
        connectionStatusState.exit();
        System.out.println("exit On state");
    }

    @Override
    public void Do() {

    }

    @Override
    public void turnOff() {
        exit();
        context.setState(context.getOffState());
    }

    public OnState(MovieStreamer streamer){

        this.context = streamer;
    }

    @Override
    public void movieOn() {
        userManagerRegion.movieOn();
        internetConnectionRegion.movieOn();
        connectionStatusState.movieOn();
    }

    @Override
    public void doneDownload() {
        userManagerRegion.doneDownload();
        internetConnectionRegion.doneDownload();
        connectionStatusState.doneDownload();
    }

    @Override
    public void holdMovie() {
        userManagerRegion.holdMovie();
        internetConnectionRegion.holdMovie();
        connectionStatusState.holdMovie();
    }

    @Override
    public void downloadError() {
        userManagerRegion.downloadError();
        internetConnectionRegion.downloadError();
        connectionStatusState.downloadError();
    }

    @Override
    public void restart() {
        userManagerRegion.restart();
        internetConnectionRegion.restart();
        connectionStatusState.restart();
    }

    @Override
    public void downloadAborted() {
        userManagerRegion.downloadAborted();
        internetConnectionRegion.downloadAborted();
        connectionStatusState.downloadAborted();
    }

    @Override
    public void resume() {
        userManagerRegion.resume();
        internetConnectionRegion.resume();
        connectionStatusState.resume();
    }

    @Override
    public void errorFixed() {
        userManagerRegion.errorFixed();
        internetConnectionRegion.errorFixed();
        connectionStatusState.errorFixed();
    }

    @Override
    public void moviePending() {
        userManagerRegion.moviePending();
        internetConnectionRegion.moviePending();
        connectionStatusState.moviePending();
    }

    @Override
    public void internetOff() {
        userManagerRegion.internetOff();
        internetConnectionRegion.internetOff();
        connectionStatusState.internetOff();
    }

    @Override
    public void internetOn() {
        userManagerRegion.internetOn();
        internetConnectionRegion.internetOn();
        connectionStatusState.internetOn();
    }

    @Override
    public void fileRequest(File f) {
        userManagerRegion.fileRequest(f);
        internetConnectionRegion.fileRequest(f);
        connectionStatusState.fileRequest(f);
    }

    @Override
    public void removed() {
        userManagerRegion.removed();
        internetConnectionRegion.removed();
        connectionStatusState.removed();
    }

    @Override
    public void turnOn() {
        userManagerRegion.turnOn();
        internetConnectionRegion.turnOn();
        connectionStatusState.turnOn();
    }

}
