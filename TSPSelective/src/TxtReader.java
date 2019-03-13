import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
}
