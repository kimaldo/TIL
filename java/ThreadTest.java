package java;

class A extends Thread{
	//변수 생성자 메소드 추가 선택적
	A(String name){
		super(name);
	}
	@Override
	public void run() {
		//setName("변경"); //스레드 이름 수정하고 싶을 경우
		for(int i = 1; i<=10; i++) {
			System.out.println(getName() + " 스레드=" + i);//시스템에서 정해 주는 이름 할당, Thread-0~ 형식
	}
	
}
}
// 멀티스레드 - 1번에 cpu 여러개 스레드 실행 구조
// main 메소드 cpu 실행 - run 명령어 시작 = main 스레드
// 사용자 스레드 - a1, a2

public class ThreadTest {

	public static void main(String[] args) {
		A a1 = new A("one");
		A a2 = new A("two");
		a1.start();//run() 호출하는 시점에서 cpu 실행 중인 메소드 main 실행 대기 / one 스레드=
		a2.start();//two 스레드=
		System.out.println("main 종료"); 
	}

}
