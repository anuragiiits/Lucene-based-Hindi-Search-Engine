package file;

import java.io.IOException;

public class Test {
	public static void main(String args[] ) throws IOException{
		LuceneReadIndexFromFile ob1 = new LuceneReadIndexFromFile();
//		System.out.println("Args = "+args[0]);
//		System.out.println("Args = "+args[1]);
		ob1.search("तालाब बनाने"); 
	}
}
