package main.java.info.thecodinglive.pattern;

public class HomeView extends Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		forward("/index.html");
	}
	
}
