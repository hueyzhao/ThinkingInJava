package JUC.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0;i < 10; i++)
			exec.execute(new YieldTest());
		exec.shutdown();
	}

}
