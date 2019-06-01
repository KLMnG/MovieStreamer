public class MovieStreamer {
    private double downLoadSpeed;

    private MovieStreamerState onState;
    private MovieStreamerState offState;
    private MovieStreamerState advancedState;
    private MovieStreamerState userManagerRegion;
    private MovieStreamerState currentState;
    private MovieStreamerState beginnerState;
    private MovieStreamerState advencedState;
    private MovieStreamerState professionalState;
    private User user;

    public MovieStreamer() {
        onState = new OnState(this);
        offState = new OffState(this);
        userManagerRegion = new UserManagerRegion(this);
        beginnerState=new BeginnerState(this);
        advencedState=new AdvancedState(this,userManagerRegion);
        professionalState=new ProfessionalState(this);
        user = new User();
    }

    public MovieStreamerState getOnState() {
        return onState;
    }

    public MovieStreamerState getOffState() {
        return offState;
    }

    public void setState(MovieStreamerState state) {
        this.currentState = state;
    }

    public void increaseUserLevel(int i) {
        this.user.setLevel(this.user.getLevel() + i);
    }

    public MovieStreamerState getAdvancedState() {
        return advancedState;
    }

    public int getUserLevel() {
        return user.getLevel();
    }

    public void setDownLoadSpeed(double i) {
        if (i >= 0) {
            downLoadSpeed = i;
        }
    }

    public MovieStreamerState getBeginnerState() {
        return beginnerState;
    }

    public MovieStreamerState getAdvencedState() {
        return advencedState;
    }
}
