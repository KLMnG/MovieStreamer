public class UserManagerRegion extends OnState {


    private MovieStreamerState currentState;
    private MovieStreamerState superContext;


    public UserManagerRegion(MovieStreamer streamer,MovieStreamerState superContext) {
        super(streamer);
    }
}
