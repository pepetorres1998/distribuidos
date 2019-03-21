package knapsack;

public class Main {
	public static void main(String[] args)
	{
		Generator g = new Generator(10, 10000, 500, 15, 1, 0.3);
		System.out.println("Values: " + g.Values);
		System.out.println("Weigths: " + g.Weights);
		System.out.println("Categories: " + g.Categories);
		System.out.println("Max weight: " + g.W);
		GeneticAlgorithm gen = new GeneticAlgorithm(g, 20);
		System.out.println(gen.poblations);
		//for (int i = 0; i < gen.poblations.size(); i++) {
		//	System.out.println(gen.poblations.get(i));
		//}
		System.out.println(gen.weights);
	}
}
