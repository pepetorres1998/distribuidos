package knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneticAlgorithm extends Thread{
	private Generator g;
	public ArrayList<String> poblations;
	public ArrayList<Double> weights;
	public Double maxWeight;
	public int iterations;
	
	public GeneticAlgorithm(Generator g, int nPoblations, int iterations)
	{
		this.iterations = iterations;
		this.maxWeight = (double) 0;
		this.g = g;
		this.poblations = generatePoblation(nPoblations);
		this.weights = weightItems();
	}
	
	public void run()
	{
		for (int i = 0; i < iterations; i++) {
			poblations = giveNewGen();
			weights = weightItems();
		}
	}
	
	private ArrayList<String> generatePoblation(int nPoblations)
	{
		ArrayList<String> poblations = new ArrayList<String>();
		for (int i = 0; i < nPoblations; i++) {
			Random rg = new Random();
		    int n = rg.nextInt((int) Math.pow(2, 31)); //generate random integer
		    String[] formated = String.format("%"+g.Items+"s", Integer.toBinaryString(n))
		    		.replace(' ', '0').split("");
		    List<String> formated2 = Arrays.asList(formated);
		    
		    Collections.shuffle(formated2);
		    StringBuilder sb = new StringBuilder(formated.length);
		    for (String c : formated2) {
				sb.append(c);
			}
		    
		    poblations.add(sb.toString());
		}
		return poblations; 
	}
	
	private char[] parseBinary(String poblation)
	{
		return poblation.toCharArray();
		
	}
	
	private ArrayList<Double> weightItems()
	{
		ArrayList<Double> weights = new ArrayList<Double>();
		for (int i = 0; i < poblations.size(); i++) {
			int total = 0, totalWeights = 0;
			char[] binaryParsed = parseBinary(poblations.get(i));
			for (int j = 0; j < binaryParsed.length; j++) {
				if(binaryParsed[j] == '1')
				{
					total += g.Values.get(j);
					totalWeights += g.Weights.get(j);
				}
			}
			if(totalWeights > g.W) {
				weights.add((double) 0);
			}
			else {
				weights.add((double) total);								
			}
		}
		if(Collections.max(weights) > maxWeight) {
			maxWeight = Collections.max(weights);
		}
		return weights;
	}
	
	public ArrayList<String> giveNewGen()
	{
		double sum = 0;
		ArrayList<Double> probabilities = new ArrayList<Double>();
		for (double weight : weights) {
			if(weight != 0) {
				sum += weight;
			}
		}
		//System.out.println(sum);
		for (double weight : weights) {
			if (weight != 0) {
				probabilities.add(weight/sum);
			} else {
				probabilities.add((double) 1);
			}
		}
		//System.out.println(probabilities);
		//System.out.println(Math.random());
		ArrayList<String> auxNewGen = new ArrayList<String>();
		while(auxNewGen.size() < poblations.size()) {
			double random = Math.random();
			double auxSumProba = 0;
			for (int i = 0; i < probabilities.size(); i++) {
				if (probabilities.get(i) < 1.0) {
					if (random < auxSumProba) {
						auxNewGen.add(poblations.get(i));
						break;
					} else {
						auxSumProba += probabilities.get(i);				
					}
				}
			}
		}
		//System.out.println(auxNewGen.size());
		ArrayList<String> aux2NewGen = new ArrayList<String>();
		for (int i = 0; i < auxNewGen.size(); i+=2) {
			aux2NewGen.add(cutGen1(auxNewGen.get(i), auxNewGen.get(i+1)));
			aux2NewGen.add(cutGen2(auxNewGen.get(i), auxNewGen.get(i+1)));
		}
		
		ArrayList<String> newGen = new ArrayList<String>();
		for (String aux2 : aux2NewGen) {
			if(Math.random() > 0.1) {
				int replace = new Random().nextInt(aux2.length());
				StringBuilder string = new StringBuilder(aux2);
				if (string.charAt(replace) == '1') {
					string.setCharAt(replace, '0');
					newGen.add(string.toString());
				} else {
					string.setCharAt(replace, '1');
					newGen.add(string.toString());
				}
			} else {
				newGen.add(aux2);
			}
		}
		//System.out.println(newGen.size());
		//System.out.println(newGen == poblations);
		return newGen;
	} //giveNewGen end
	
	public String cutGen1(String p1, String p2)
	{
		int position = ThreadLocalRandom.current().nextInt(1, p1.length());
		String aux1P1 = p1.substring(0, position);
		String aux2P1 = p1.substring(position);
		String aux1P2 = p2.substring(0, position);
		String aux2P2 = p2.substring(position);
		p1 = aux1P1+aux2P2;
		p2 = aux1P2+aux2P1;
		return p1;
	}
	
	public String cutGen2(String p1, String p2)
	{
		int position = ThreadLocalRandom.current().nextInt(1, p1.length());
		String aux1P1 = p1.substring(0, position);
		String aux2P1 = p1.substring(position);
		String aux1P2 = p2.substring(0, position);
		String aux2P2 = p2.substring(position);
		p1 = aux1P1+aux2P2;
		p2 = aux1P2+aux2P1;
		return p2;
	}
}
