package model;

public class Board {
    String title;

    public Board withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }
}
