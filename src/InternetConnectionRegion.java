public class InternetConnectionRegion extends OnState{

    protected MovieStreamer context;
    private MovieStreamerState superContext;

    public InternetConnectionRegion(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer);
        this.context = streamer;
        this.superContext = superContext;
    }

    @Override
    public void setState(MovieStreamerState state) {
        super.setState(state);
    }
}
