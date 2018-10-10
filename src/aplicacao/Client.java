package aplicacao;

import java.util.ArrayList;

import distribuicao.Invocation;
import distribuicao.Requestor;
import distribuicao.Termination;
import distribuicao.message.Message;

public class Client {
	public static void main(String[] args) {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add("item");
		
		Invocation inv = new Invocation(1234, "localhost", 2000, "add", parameters);
		Requestor req = new Requestor();
		
		try {
			Termination termination = req.invoke(inv);
			Message mesg = (Message)termination.getResult();
			
			System.out.println(mesg.getOperationResult().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
