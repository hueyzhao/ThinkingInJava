package JUC.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fibonacci implements Runnable{
	  private int num = 0;
	  public Fibonacci(int n){
		  this.num = n;
	  }
	  private int count = 0;
	  public Integer next() { return fib(count++); }
	  private int fib(int n) {
	    if(n < 2) return 1;
	    return fib(n-2) + fib(n-1);
	  }
	 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Fibonacci gen = new Fibonacci(this.num);
	    for(int i = 0; i < num; i++)
	      System.out.print(gen.next() + " ");
			
	}
	
	public static void main(String [] args){
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i = 0;i <10;i++){
			exec.execute(new Fibonacci(10));
		}
		exec.shutdown();
	}
	}
