package entities;

public abstract class Lesson {

	private String title;

	public Lesson(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract Integer duration();

}
