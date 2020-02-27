package info.thecodinglive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import info.thecodinglive.model.User;

@RestController
public class UserController {
	private static List<User> userList = new ArrayList<User>();
}
