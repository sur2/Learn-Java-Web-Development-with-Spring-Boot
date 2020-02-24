package info.thecodinglive.model;

import org.springframework.hateoas.RepresentationModel;
/***
 * HATEOAS를 이용한 URI 정보 표현
 */
public class TodoResource extends RepresentationModel<TodoResource> {

	private String title;

	public TodoResource() {
	}

	public TodoResource(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
