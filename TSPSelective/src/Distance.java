
public class Distance {
	public static double Euclidean(Node a, Node b)
	{
		double x = a.x - b.x;
		double y = a.y - b.y;
		double euDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return euDistance;
	}
}
