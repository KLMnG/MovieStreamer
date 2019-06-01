public class AdvancedState extends UserManagerRegion{

    MovieStreamerState superContext;
    MovieStreamer streamer;
    String name;

    public AdvancedState(MovieStreamer streamer, MovieStreamerState superContext) {
        super(streamer);
        this.streamer = streamer;
        this.superContext = superContext;
        this.name = "AdvancedState";
    }

    @Override
    public void movieOn() {
        this.superContext.movieOn();

    }

    @Override
    public void setState(MovieStreamerState state) {

    }

    @Override
    public void doneDownload() {
        exit();
        this.streamer.increaseUserLevel(1);
        superContext.setState(streamer.getAdvancedState());

    }

    @Override
    public void holdMovie() {
        superContext.holdMovie();
    }

    @Override
    public void downloadError() {
        superContext.holdMovie();
    }

    @Override
    public void restart() {
        superContext.holdMovie();
    }

    @Override
    public void downloadAborted() {
        superContext.holdMovie();
    }

    @Override
    public void resume() {
        superContext.holdMovie();
    }

    @Override
    public void errorFixed() {
        superContext.holdMovie();
    }

    @Override
    public void moviePending() {
        superContext.holdMovie();
    }

    @Override
    public void internetOff() {
        superContext.holdMovie();
    }

    @Override
    public void internetOn() {
        superContext.holdMovie();
    }

    @Override
    public void fileRequest() {
        superContext.holdMovie();
    }

    @Override
    public void removed() {
        exit();
        this.streamer.decreaseUserLevel(1);
        superContext.setState(streamer.getAdvancedState());
    }

    @Override
    public void turnOn() {
        superContext.holdMovie();
    }

    @Override
    public void turnOff() {
        superContext.holdMovie();
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
        if (streamer.getUserLevel() < 4) {
            exit();
            streamer.setDownLoadSpeed(1);
            superContext.setState(streamer.getBeginnerState());
        }
        if (streamer.getUserLevel()>=7) {
            exit();
            streamer.setDownLoadSpeed(1.5);
            superContext.setState(streamer.getProfessionalState());
        }
    }

}
