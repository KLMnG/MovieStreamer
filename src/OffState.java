public class OffState implements MovieStreamerState {

    private MovieStreamer streamer;
    private String name;

    public OffState(MovieStreamer streamer) {

        this.streamer = streamer;
        this.name = "OffState";
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
        exit();
        streamer.setState(streamer.getOnState());
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void setState(MovieStreamerState state) {

    }

    @Override
    public MovieStreamerState getCurrentState() {
        return null;
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

    }
}
