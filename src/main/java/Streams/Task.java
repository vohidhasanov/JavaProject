package Streams;

public class Task {
private String summary;
private int duration;

public Task(String summary, int duration) {
    this.summary = summary;
    this.duration = duration;
}

    public String getSummary() {
        return summary;
    }

    public int getDuration() {
        return duration;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
