public class User {
    private int level;

    public User() {
        this.level = 1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level>=1) {
            this.level = level;
        }
    }
}
