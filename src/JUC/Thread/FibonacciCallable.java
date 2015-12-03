package JUC.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciCallable implements Callable{
	 private int num = 0;
	  public FibonacciCallable(int n){
		  this.num = n;
	  }
	  private int count = 0;
	  public Integer next() { return fib(count++); }
	  private int fib(int n) {
	    if(n < 2) return 1;
	    return fib(n-2) + fib(n-1);
	  }

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<ArrayList<Integer>>> results = new ArrayList<Future<ArrayList<Integer>>>();
		for(int i = 1; i < 10;i++)
			results.add(exec.submit(new FibonacciCallable(i)));
		for(Future<ArrayList<Integer>> oneResult:results){
			System.out.println(oneResult.get());
		}
		exec.shutdown();
	}

	@Override
	public List<Integer> call() throws Exception {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		Fibonacci gen = new Fibonacci(this.num);
	    for(int i = 0; i < num; i++)
	      result.add(gen.next());
		return result;
	}

}
