package info.thecodinglive.model;

public class Todo {

	private long id;
	private String title;

	public Todo(long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
