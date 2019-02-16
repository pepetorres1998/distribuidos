package entero_factorial;

import java.math.BigInteger;

public class EnteroFactorial {
	private int integer;
	private int threads;
	
	public EnteroFactorial(){}
	
	public EnteroFactorial(int i, int j)
	{
		this.integer = i;
		this.threads = j;
	}
	
	public EnteroFactorial(int i)
	{
		this.integer = i;
		this.threads = 2;
	}
	
	public BigInteger Lineal()
	{
		BigInteger factorial = new BigInteger("1");
		long a = System.currentTimeMillis();
		for(int i = integer; i>1; i--)
		{
			factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
			//System.out.println(new BigInteger(Integer.toString(i)));
		}
		long b = System.currentTimeMillis();
		System.out.println("Time transcurred => "+(b-a));
		//System.out.println("Resultado de factorial => "+factorial);
		return factorial;
	}
	
	public BigInteger Concurrent()
	{
		
		int f1 = integer/2;
		System.out.println(f1);
		Parallel func1 = new Parallel(integer, f1);
		Parallel func2 = new Parallel(f1, 1);
		
		long a = System.currentTimeMillis();
		try {
			func1.start();
			func2.start();
			func1.join();
			func2.join();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		long b = System.currentTimeMillis();
		System.out.println("Time transcurred => "+(b-a));
		return func1.getBigInt().multiply(func2.getBigInt());
	}
	
	//Setters and getters
	public void setInteger(int i)
	{
		this.integer = i;
	}
	
	public int getInteger()
	{
		return integer;
	}
	
	public void setThreads(int i)
	{
		this.threads = i;
	}
	
	public int getThreads()
	{
		return threads;
	}
}
