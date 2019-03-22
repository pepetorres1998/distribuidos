package knapsack;

public class Main {
	public static void main(String[] args)
	{
		Generator g = new Generator(2000, 10000, 500, 15, 1, 0.005);

		for (int i = 1; i <= 25; i++) {
			long initialTime = System.currentTimeMillis();
			Distribution dis = new Distribution(2000, i, g, 200);
			System.out.println("Tiempo transcurrido: " +
					(System.currentTimeMillis() - initialTime) +
					" milisegundos");
			System.out.println("Mejor resultado: " + dis.maxWeight + "\n");
		}
	}
}
