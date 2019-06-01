public class File {
    private int Id;
    private int requiredSize;
    private int downloaded;

    public File(int id, int requiredSize, int downloaded) {
        Id = id;
        this.requiredSize = requiredSize;
        this.downloaded = downloaded;
    }

    public int getId() {
        return Id;
    }

    public int getRequiredSize() {
        return requiredSize;
    }

    public int getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(int downloaded) {
        this.downloaded = downloaded;
    }
}
