package JUC.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	
	public static void main(String [] args){
		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		for(int i = 0;i < 10; i++){
			exec.execute(new YieldTest());
		}
		exec.shutdown();
	}

}
