package chap12;

//중첩 인터페이스
// 특정 class 내부에 포함되어 사용하는 인터페이스
// 인터페이스를 상속 받은 무명 클래스를 정의 + 객체 생성하여 사용


public class RunnableTest2 {

	public static void main(String[] args) {
		Runnable r1 = new Runnable(){
			//변수 생성자 메소드 추가 선택적
			public void run() {
				for(int i = 1; i<=10; i++) {
					System.out.println(" 스레드=" + i);
				}
			}
		};
		
		//B a1 = new B("one");
		Thread ta1 = new Thread(r1);
		ta1.start();//run() 호출하는 시점에서 cpu 실행 중인 메소드 main 실행 대기 / one 스레드=
		System.out.println("main 종료"); 
	}
}
