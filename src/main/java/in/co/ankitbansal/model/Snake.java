package in.co.ankitbansal.model;

public class Snake {
    private int start;
    private int end;

    public Snake(int start, int end) {
        if (start<end) throw new IllegalArgumentException("For snake start should be greater than end");
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}