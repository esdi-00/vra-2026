package com.rocs.video.rental.app.model.item;

public class Item {

    private Long id;
    private String title;
    private String genre;
    private String description;
    private int copy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + "\nTITLE: " + this.getTitle() + "\n-----------";
    }
}
