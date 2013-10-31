package io_dbrown;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {

		Contacts con = new Contacts();
		con.LoadingFile();
		while(con.shouldGo())
		{
			con.Selection();
		}

	}
}