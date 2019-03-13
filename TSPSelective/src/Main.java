import java.io.IOException;

public class Main {
	public static void main(String[] args)
	{
		TxtReader txt = new TxtReader("/home/jose/Downloads/semestre_7/tso/tsiligirides_1/tsiligirides_problem_1_budget_05.txt");
		try {
			txt.printReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
