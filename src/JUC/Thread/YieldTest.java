package JUC.Thread;

public class YieldTest implements Runnable{
	public YieldTest(){
		System.out.println("Constructing YieldTest");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("In Run Method");
		for(int i = 0;i < 3; i++)
			Thread.yield();//给其他相同级别的线程让出时间片
		System.out.println("Exiting Run");
		
	}
	
	public static void main(String [] args){
		for(int i = 0; i<100; i++)
			new Thread(new YieldTest()).start();
	}
		

}
