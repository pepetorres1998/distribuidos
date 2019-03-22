package knapsack;

import java.util.ArrayList;

public class Distribution {
	public int threads;
	public int iterations;
	public Generator g;
	public int perCapita;
	public double bestResult;
	public final int totalPoblations;
	public double maxWeight;
	
	public Distribution(int iterations, int threads, Generator g, int poblations)
	{
		this.totalPoblations = poblations;
		this.iterations = iterations;
		this.threads = threads;
		this.g = g;
		this.perCapita = setIterationPerCapita();
		this.maxWeight = runAlgorithms();
	}
	
	public double runAlgorithms()
	{
		ArrayList<GeneticAlgorithm> ga = new ArrayList<GeneticAlgorithm>();
		for (int i = 0; i < threads; i++) {
			//GeneticAlgorithm gen = new GeneticAlgorithm(g, 200, 20);
			ga.add(new GeneticAlgorithm(g, totalPoblations, perCapita));
		}
		for (GeneticAlgorithm gal : ga) {
			gal.run();
		}
		for (GeneticAlgorithm gal : ga) {
			try {
				gal.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		double maxWeight = 0;
		for (GeneticAlgorithm gal : ga) {
			if (gal.maxWeight > maxWeight) {
				maxWeight = gal.maxWeight;
			}
		}
		return maxWeight;
	}
	
	public int setIterationPerCapita()
	{
		System.out.println((iterations/threads) + " iteraciones por hilo en " +
				threads + " hilos.");
		return (int) iterations/threads;
	}
}
