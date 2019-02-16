package entero_factorial;

public class Main {
	public static void main(String[] args) {
		EnteroFactorial f = new EnteroFactorial(25000, 10,
				"/home/jose/documents/result.txt");
		//Uncomment to print result BigInteger, pretty big number WARNING.
		//System.out.println(f.getResult());
		System.out.println(f);
		f.toText();
		EnteroFactorial f1 = new EnteroFactorial(25000, 5);
		System.out.println(f1);
		EnteroFactorial f2 = new EnteroFactorial(25000, 3);
		System.out.println(f2);
		EnteroFactorial f3 = new EnteroFactorial(25000, 1);
		System.out.println(f3);
	}
}
