package main.java.info.thecodinglive.pattern;

public class LoginView extends Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		forward("/login.html");
	}
	
}
