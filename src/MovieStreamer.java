import java.util.PriorityQueue;
import java.util.Queue;

public class MovieStreamer {
    private double downLoadSpeed;


    private Queue<File> fileReuqestQueue;
    private MovieStreamerState onState;
    private MovieStreamerState offState;



    //OnState
    private MovieStreamerState internetConnectionRegion;
    private MovieStreamerState connectionStatusRegion;

    //InternetConnection
    private MovieStreamerState internetConnectedState;
    private MovieStreamerState internetDisconnectedState;
    private MovieStreamerState downloadRegionState;

    //DownloadingRegion
    private MovieStreamerState downloadState;
    private MovieStreamerState secondAttemptState;
    private MovieStreamerState idleState;
    private MovieStreamerState dErrorState;
    private MovieStreamerState verifyRequirementState;

    //DeviceManagerRegion
    private MovieStreamerState deviceManagerState;

    //MovieStreamerRegion
    private MovieStreamerState idleStreamingState;
    private MovieStreamerState pauseState;
    private MovieStreamerState streamingState;

    private System system;

    private MovieStreamerState currentState;
    private File currentDownloadFile;
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
        fileReuqestQueue = new PriorityQueue<>();
        system = new System(false,100);
    }



    public MovieStreamerState getOnState() {
        return onState;
    }

    public MovieStreamerState getOffState() {
        return offState;
    }

    public void setState(MovieStreamerState state) {
    public MovieStreamerState getInternetConnectionRegion() {
        return internetConnectionRegion;
    }

    public MovieStreamerState getConnectionStatusRegion() {
        return connectionStatusRegion;
    }

    public MovieStreamerState getInternetConnectedState() {
        return internetConnectedState;
    }

    public MovieStreamerState getInternetDisconnectedState() {
        return internetDisconnectedState;
    }

    public MovieStreamerState getDownloadRegionState() {
        return downloadRegionState;
    }

    public MovieStreamerState getDownloadState() {
        return downloadState;
    }

    public MovieStreamerState getSecondAttemptState() {
        return secondAttemptState;
    }

    public MovieStreamerState getIdleState() {
        return idleState;
    }

    public MovieStreamerState getdErrorState() {
        return dErrorState;
    }

    public MovieStreamerState getVerifyRequirementState() {
        return verifyRequirementState;
    }

    public MovieStreamerState getDeviceManagerState() {
        return deviceManagerState;
    }

    public MovieStreamerState getIdleStreamingState() {
        return idleStreamingState;
    }

    public MovieStreamerState getPauseState() {
        return pauseState;
    }

    public MovieStreamerState getStreamingState() {
        return streamingState;
    }

    public MovieStreamerState getCurrentState() {
        return currentState;
    }

    public void setState(MovieStreamerState state){
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

    public Queue<File> getFileReuqestQueue() {
        return fileReuqestQueue;
    }

    public void setCurrentDownloadFile(File f) {
        currentDownloadFile = f;
    }

    public File getCurrentDownloadFile() {
        return currentDownloadFile;
    }

    public System getSystem() {
        return system;
    }
}
