public class System {

    private boolean connectionStatus;
    private int availableSpace;

    public System(boolean connectionStatus, int availableSpace) {
        this.connectionStatus = connectionStatus;
        this.availableSpace = availableSpace;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }
}
