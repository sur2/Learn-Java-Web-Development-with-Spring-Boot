package info.thecodinglive.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.thecodinglive.model.Todo;
import info.thecodinglive.model.TodoResource;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/todo")
	public Todo basic() {
		return new Todo(counter.incrementAndGet(), "라면사오기");
	}

	@RequestMapping(value = "/todop", method = RequestMethod.POST)
	public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle) {
		return new Todo(counter.incrementAndGet(), todoTitle);
	}

	/**
	 * 응답 헤더에 대한 구현체 ResponseEntity 
	 * Http 응답에 대한 상태값을 표현 헤더는 HttpHeaders로 생성
	 */
	@RequestMapping(value = "/todor", method = RequestMethod.POST)
	public ResponseEntity<Todo> postBasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("Test-Header", "Header-Test-do");

		return new ResponseEntity<Todo>(new Todo(counter.incrementAndGet(), todoTitle), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
	public Todo getPath(@PathVariable int todoId) {
		Todo todo1 = new Todo(1L, "문서쓰기");
		Todo todo2 = new Todo(2L, "기획회의");
		Todo todo3 = new Todo(3L, "운동");
		
		Map<Integer, Todo> todoMap = new HashMap<Integer, Todo>();
		todoMap.put(1, todo1);
		todoMap.put(2, todo2);
		todoMap.put(3, todo3);
		
		return todoMap.get(todoId);
	}
	
	@RequestMapping(value = "/todoh", method = RequestMethod.GET)
	public ResponseEntity<TodoResource> geth(@RequestParam(value = "todoTitle") String todoTitle) {
		TodoResource todoResource = new TodoResource(todoTitle);
		Link link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BasicController.class).geth(todoTitle)).withSelfRel();
		todoResource.add(link);
		return new ResponseEntity<TodoResource>(todoResource, HttpStatus.OK);
	}

}
