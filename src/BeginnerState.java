public class BeginnerState extends UserManagerRegion{
    MovieStreamerState superContext;
    MovieStreamer streamer;
    String name;

    public BeginnerState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,null);
        this.streamer = streamer;
        this.superContext = superContext;
        this.name = "BeginnerState";
    }

    @Override
    public void movieOn() {


    }

    @Override
    public void setState(MovieStreamerState state) {

    }

    @Override
    public void doneDownload() {
        exit();
        this.streamer.increaseUserLevel(1);
        superContext.setState(streamer.getBeginnerState());

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
        exit();
        this.streamer.decreaseUserLevel(1);
        superContext.setState(streamer.getBeginnerState());
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }


    @Override
    public void entry() {
        System.out.println("enter " + name + " state");
    }

    @Override
    public void exit() {
        System.out.println("exit " + name + " state");
    }

    @Override
    public void Do() {

        if (streamer.getUserLevel()>=4) {
            exit();
            streamer.setDownLoadSpeed(1.2);
            superContext.setState(streamer.getAdvancedState());
        }
    }

}
