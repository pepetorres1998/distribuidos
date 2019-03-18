import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TxtReader {
	private String fileName;
	
	public TxtReader(String fileName)
	{
		this.fileName = fileName;
	}
	
	private BufferedReader readData()
	{
		File file = new File(fileName);
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			return br;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void printReader() throws IOException
	{
		BufferedReader br = readData();
		String line;
		//int i = 0;
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
		}
		br.close();
	}
	
	public ArrayList<Node> assignReader() throws IOException
	{
		BufferedReader br = readData();
		String line;
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		int i = 0;
		while((line = br.readLine()) != null)
		{
			if(i == 0)
			{
				System.out.println("Primera linea");
			}
			else
			{
				nodes.add(new Node(line, i));
			}
			i++;
		}
		return nodes;
	}
}
