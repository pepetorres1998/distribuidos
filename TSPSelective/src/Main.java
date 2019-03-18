import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// TxtReader txt = new
		// TxtReader("/home/jose/Downloads/semestre_7/tso/tsiligirides_1/tsiligirides_problem_1_budget_05.txt");
		TxtReader txt = new TxtReader(
				"/home/jose/Downloads/semestre_7/tso/tsiligirides_1/tsiligirides_problem_1_budget_05.txt");
		try {
			ArrayList<Node> nodes = txt.assignReader();
			txt.printReader();
			for(int i = 0; i < nodes.size(); i++) {
				System.out.println(nodes.get(i));
			}
			double distanceOriginFinal = Distance.Euclidean(nodes.get(0), nodes.get(1));
			System.out.println(distanceOriginFinal);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Node n = new Node(10, 12, 5, 1);
		System.out.println(n);
	}
}
