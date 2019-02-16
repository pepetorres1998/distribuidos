package entero_factorial;

import java.math.BigInteger;

public class Parallel extends Thread {
	private int begin, end;
	private BigInteger bigint;
	public Parallel(int begin, int end)
	{
		this.bigint = new BigInteger("1");
		this.begin = begin;
		this.end = end;
	}
	
	public void run()
	{
		try 
		{
			for(int i = begin; i>end; i--)
			{
				bigint = bigint.multiply(new BigInteger(Integer.toString(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public BigInteger getBigInt()
	{
		return bigint;
	}
}
