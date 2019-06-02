public class DErrorState extends  DownloadingRegion{

    protected MovieStreamer context;
    private MovieStreamerState superContext;

    public DErrorState(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer,superContext);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public void entry() {
        System.out.println("enter DError state");
    }

    @Override
    public void Do() {

    }

    @Override
    public void exit() {
        System.out.println("exit DError state");

    }

    @Override
    public void errorFixed() {
        exit();
        superContext.setState(context.getDownloadState());
    }

    public void timeEvent(){
        exit();
        superContext.setState(context.getIdleState());
    }

}
