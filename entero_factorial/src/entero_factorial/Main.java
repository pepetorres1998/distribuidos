package entero_factorial;

public class Main {
	public static void main(String[] args) {
		EnteroFactorial f = new EnteroFactorial(100000, 10);
		System.out.println(f.getResult());
		System.out.println(f);
		EnteroFactorial f1 = new EnteroFactorial(100000, 5);
		System.out.println(f1);
		EnteroFactorial f2 = new EnteroFactorial(100000, 3);
		System.out.println(f2);
		EnteroFactorial f3 = new EnteroFactorial(100000, 1);
		System.out.println(f3);
	}
}
