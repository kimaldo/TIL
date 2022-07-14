class Data{
	int value;//동기화 메소드 정의할 때 사용, 2개 이상의 스레드는 동시에 동기화 메소드 수행 x. 1개 수행하는 동안 다른 1개의 스레드는 대기
			  //속도가 느려짐
	public synchronized void saveValue(int value) {
		this.value = value;
		try {
		Thread.sleep(2000);
		}catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " : " + this.value);
	}
}
class DataThread1 extends Thread{
	Data d;
	DataThread1(String name, Data d){
		super(name);
		this.d = d;
	}
	public void run() {
		d.saveValue(10);
	}
}
class DataThread2 extends Thread{
	Data d;
	DataThread2(String name, Data d){
		super(name);
		this.d = d;
	}
	public void run() {
		d.saveValue(20);
	}
}
public class SynchroniazedTest {

	public static void main(String[] args) {
		Data d = new Data();
		DataThread1 t1 = new DataThread1("스레드1", d);
		DataThread2 t2 = new DataThread2("스레드2", d);
		t1.start();
		t2.start();
		
		}
	}