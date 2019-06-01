public interface MovieStreamerState extends State{

    public void movieOn();
    public void doneDownload();
    public void holdMovie();
    public void downloadError();
    public void restart();
    public void downloadAborted();
    public void resume();
    public void errorFixed();
    public void moviePending();
    public void internetOff();
    public void internetOn();
    public void fileRequest();
    public void removed();
    public void turnOn();
    public void turnOff();
    public void setState(MovieStreamerState state);

}
