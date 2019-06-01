public class OnState implements MovieStreamerState{

    private OnState userManagerRegion;
    private OnState internetConnectionRegion;
    private OnState connectionStatusRegion;

    protected MovieStreamer context;
    private MovieStreamerState downloadHistory;

    public OnState(MovieStreamer streamer){
        this.context = streamer;
        this.userManagerRegion = new UserManagerRegion(streamer);
        this.internetConnectionRegion = new InternetConnectedState(streamer);
        this.connectionStatusRegion = new ConnectionStatusRegion(streamer);
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
    public void fileRequest() {

    }

    @Override
    public void removed() {

    }

    @Override
    public void turnOn() {
        System.out.println("Already On");
    }

    @Override
    public void turnOff() {
        context.setState(context.getOffState());
    }


    public void setState(OnState state){

    }
}
