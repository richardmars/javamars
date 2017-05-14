package test;

public class TestFinally {
	public static void main(String[] args) throws InterruptedException {
		Runnable s = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println("线程开始");
					Thread.sleep(1000);
					System.out.println("线程执行完毕");
				} catch (Exception e) {
					System.out.println("睡眠中断");
				} finally {
					System.out.println("finally调用");
				}
			}
		};
		Thread thread = new Thread(s);
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(500);
	}
}
