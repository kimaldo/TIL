package java;

class B implements Runnable{
	//변수 생성자 메소드 추가 선택적
	String name;
	B(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 1; i<=10; i++) {
			System.out.println(name + " 스레드=" + i);
	}
	
}
}

public class RunnableTest {

	public static void main(String[] args) {
		B a1 = new B("one");
		B a2 = new B("two");
		Thread ta1 = new Thread(a1);
		Thread ta2 = new Thread(a2);
		ta1.start();//run() 호출하는 시점에서 cpu 실행 중인 메소드 main 실행 대기 / one 스레드=
		ta2.start();//two 스레드=
		System.out.println("main 종료"); 
	}

}
