public class OnState implements MovieStreamerState{

    private OnState userManagerRegion;
    private OnState internetConnectionRegion;
    private OnState connectionStatusRegion;

    protected MovieStreamer context;

    private MovieStreamerState downloadHistory;

    @Override
    public void setState(MovieStreamerState state) {

    }

    @Override
    public void entry() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void Do() {

    }

    public OnState(MovieStreamer streamer){
        this.context = streamer;
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

    }

    @Override
    public void turnOff() {
        context.setState(context.getOffState());
    }


    public void setState(OnState state){

    }
}
