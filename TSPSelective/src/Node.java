import java.util.StringTokenizer;

public class Node {
	public int id;
	public double value;
	public double x;
	public double y;
	
	public Node(double x, double y, double value, int id)
	{
		this.x = x;
		this.y = y;
		this.value = value;
		this.id = id;
	}
	
	public Node(String coordinates, int id)
	{
		StringTokenizer st = new StringTokenizer(coordinates, "\t");
		this.x = Double.parseDouble(st.nextToken());
		this.y = Double.parseDouble(st.nextToken());
		this.value = Double.parseDouble(st.nextToken());
		this.id = id;
	}
	
	public String toString()
	{
		StringBuffer tostring = new StringBuffer()
				.append("\n")
				.append("X = ").append(x).append("\n")
				.append("Y = ").append(y).append("\n")
				.append("Value = ").append(value).append("\n")
				.append("ID = ").append(id)
				.append("\n");
		return tostring.toString();
	}
}
