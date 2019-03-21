package knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {
	private Generator g;
	public ArrayList<String> poblations;
	public ArrayList<Integer> weights;
	
	public GeneticAlgorithm(Generator g, int nPoblations)
	{
		this.g = g;
		this.poblations = generatePoblation(nPoblations);
		this.weights = weightItems();
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
	
	private ArrayList<Integer> weightItems()
	{
		ArrayList<Integer> weights = new ArrayList<Integer>();
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
				weights.add(0);
			}
			else {
				weights.add(total);								
			}
		}
		return weights;
	}
	
	//private 
}
