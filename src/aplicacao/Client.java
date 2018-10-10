package aplicacao;

import java.util.ArrayList;

import distribuicao.Invocation;
import distribuicao.Requestor;

public class Client {
	public static void main(String[] args) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add("item");
		
		Invocation inv = new Invocation(1234, "localhost", 2000, "add", parameters);
		Requestor req = new Requestor();
		
		try {
			req.invoke(inv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
