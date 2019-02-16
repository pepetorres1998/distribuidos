package entero_factorial;

public class Main {
	public static void main(String[] args) {
		EnteroFactorial f = new EnteroFactorial(10000);
		System.out.println(f.Lineal());
		System.out.println(f.Concurrent());
	}
}
