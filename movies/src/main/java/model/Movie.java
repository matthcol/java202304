package model;


import java.util.Objects;

public class Movie {
    private String title;
    private int year;
    private short duration;

    /**
     * default constructor
     */
    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    /**
     * Full constructor, All arg constructor
     * @param title
     * @param year
     * @param duration
     */
    public Movie(String title, int year, short duration) {
    	super();
		this.title = title;
		this.year = year;
		this.duration = duration;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    @Override // from Object::toString
    public String toString() {
//        final StringBuilder sb = new StringBuilder("Movie{");
//        sb.append("title='").append(title).append('\'');
//        sb.append(", year=").append(year);
//        sb.append('}');
//        return sb.toString();
        return title + " (" + year + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year  && Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }
}
