import java.util.PriorityQueue;
import java.util.Queue;

public class MovieStreamer {
    private double downLoadSpeed;


    private Queue<File> fileReuqestQueue;
    private MovieStreamerState onState;
    private MovieStreamerState offState;



    //OnState
    private MovieStreamerState internetConnectionRegion;
    private MovieStreamerState connectionStatusState;
    private MovieStreamerState userManagerRegion;

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





    private MovieStreamerState movieStreamerRegion;
    private MovieStreamerState downloadManagerState;
    //MovieStreamerRegion
    private MovieStreamerState idleStreamingState;
    private MovieStreamerState pauseState;
    private MovieStreamerState streamingState;

    private SystemManager systemManager;

    private MovieStreamerState currentState;
    private File currentDownloadFile;

    private MovieStreamerState advancedState;

    private MovieStreamerState beginnerState;

    private MovieStreamerState professionalState;
    private User user;

    public MovieStreamer() {
        onState = new OnState(this);
        offState = new OffState(this);

        internetConnectionRegion = new InternetConnectionRegion(this,onState);
        connectionStatusState = new ConnectionStatusState(this,onState);
        userManagerRegion = new UserManagerRegion(this,onState);

        internetDisconnectedState = new InternetDisconnectedState(this,internetConnectionRegion);
        internetConnectedState = new InternetConnectedState(this,internetConnectionRegion);

        movieStreamerRegion = new MovieStreamerRegion(this,internetConnectedState);
        downloadRegionState = new DownloadingRegion(this,internetConnectedState);
        downloadManagerState = new DownloadManagerState(this,internetConnectedState);

        idleStreamingState = new IdleStreamingState(this,movieStreamerRegion);
        streamingState = new StreamingState(this,movieStreamerRegion);
        pauseState = new PauseState(this,movieStreamerRegion);


        idleState = new IdleState(this,internetConnectedState);
        verifyRequirementState = new VerifyRequirementsState(this,internetConnectedState);
        secondAttemptState = new SecondAttemptState(this,internetConnectedState);
        downloadState = new DownloadState(this,internetConnectedState);
        dErrorState = new DErrorState(this,internetConnectedState);



        beginnerState=new BeginnerState(this,userManagerRegion);
        advancedState=new AdvancedState(this,userManagerRegion);
        professionalState=new ProfessionalState(this,userManagerRegion);


        user = new User();
        fileReuqestQueue = new PriorityQueue<>();
        systemManager = new SystemManager(false,100);

        setState(offState);
    }



    public MovieStreamerState getOnState() {
        return onState;
    }

    public MovieStreamerState getOffState() {
        return offState;
    }


    public MovieStreamerState getInternetConnectionRegion() {
        return internetConnectionRegion;
    }

    public MovieStreamerState getConnectionStatusState() {
        return connectionStatusState;
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

    public MovieStreamerState getDownloadManagerState() {
        return downloadManagerState;
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
        currentState.entry();
        currentState.Do();
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

    public Queue<File> getFileReuqestQueue() {
        return fileReuqestQueue;
    }

    public void setCurrentDownloadFile(File f) {
        currentDownloadFile = f;
    }

    public File getCurrentDownloadFile() {
        return currentDownloadFile;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }

    public MovieStreamerState getProfessionalState() {
        return professionalState;
    }

    public double getDownLoadSpeed() {
        return downLoadSpeed;
    }

    public MovieStreamerState getUserManagerRegion() {
        return userManagerRegion;
    }

    public MovieStreamerState getMovieStreamerRegion() {
        return movieStreamerRegion;
    }

    public User getUser() {
        return user;
    }

    public void decreaseUserLevel(int i) {
        this.user.setLevel(this.user.getLevel() - i);
    }

    public void addDownloadQueue(File f) {
        currentState.fileRequest(f);
    }

    public void turnSystemOff() {
        currentState.turnOff();
    }

    public void turnSystemOn() {
        currentState.turnOn();
    }

    public void turnInternetOff() {
        systemManager.setConnectionStatus(false);
        currentState.internetOff();
    }

    public void turnInternetOn() {
        systemManager.setConnectionStatus(true);
        currentState.internetOn();
    }

    public void setAvailableSpace(int diskSize) {
        systemManager.setAvailableSpace(diskSize);
    }

    public void doneDownloadFile() {
        currentState.doneDownload();
    }
}
