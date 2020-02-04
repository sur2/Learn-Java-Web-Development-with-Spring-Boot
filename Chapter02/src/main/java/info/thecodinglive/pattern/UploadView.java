package main.java.info.thecodinglive.pattern;

public class UploadView extends Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		forward("/upload.html");
	}
	
}
