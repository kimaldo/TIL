class C extends Thread{
	int data = 10;
	public void run() {
		try {
		Thread.sleep(2000);
		}catch(InterruptedException e) {}
		data = data * 2;
		System.out.println("run 메소드=" + data);
	}
}

public class JoinTest {

	public static void main(String[] args) {
		System.out.println("main 시작");
		C c1 = new C();//멀티 스레드 생성. c1.data -> 10
		c1.start();//run 실행 준비 (실행 전) c1.data -> 10, (실행 후) c1.data -> 20
		//run 수행 결과 출력 원하는 경우, 
		try {//예외 처리
		c1.join();//cpu c1 스레드 실행 변경, c1 run 수행
		}catch(InterruptedException e) {}
		System.out.println(c1.data);
		System.out.println("main 종료");
		//cpu 실행 스레드 c1 변경
	}

}

