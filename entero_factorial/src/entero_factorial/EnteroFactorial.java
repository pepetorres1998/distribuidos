package entero_factorial;

import java.math.BigInteger;
//import java.util.Arrays;

public class EnteroFactorial {
	private int integer;
	private int threads;
	private BigInteger result;
	private long time;
	
	public EnteroFactorial(){}
	
	public EnteroFactorial(int i, int j)
	{
		this.integer = i;
		this.threads = j;
		this.result = this.Concurrent();
	}
	
	public EnteroFactorial(int i)
	{
		this.integer = i;
		this.threads = 2;
		this.result = this.Concurrent();
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
		
		int f1 = integer/threads;
		//System.out.println(f1);
		
		Parallel functions[] = new Parallel[threads];
		for(int i = 0; i<threads; i++)
		{
			if(i == 0)
			{
				functions[i] = new Parallel(integer, (f1*(threads-(i+1))));
			}
			else
			{
				functions[i] = new Parallel(f1*(threads-i), (f1*(threads-(i+1))));				
			}
		}
		long a = System.currentTimeMillis();
		for(Parallel function : functions)
		{
			function.start();
		}
		for(Parallel function : functions)
		{
			try {
				function.join();				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		//System.out.println(Arrays.toString(functions));
		BigInteger sum = new BigInteger("1");
		for(Parallel function : functions)
		{
			sum = sum.multiply(function.getBigInt());
		}
		long b = System.currentTimeMillis();
		time = b-a;
		return sum;
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
	
	public BigInteger getResult()
	{
		return result;
	}
	
	public String toString()
	{
		return "\nThreads: "+this.threads+
				"\nFactorial: "+this.integer+
				"\nTime: "+this.time;
	}
}
