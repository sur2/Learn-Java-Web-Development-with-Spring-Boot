package info.thecodinglive.conditional;

public interface MsgBean {
	// java 1.8부터 추가된 키워드 - 몸체가 있는 메서드 작성 가능(override 하지 않아도 구현됨)
	default void printMsg() {
		System.out.println("My Bean default is running");
	}
}
