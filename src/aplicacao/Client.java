package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

import distribuicao.ClientProxy;
import distribuicao.EstoqueProxy;
import distribuicao.Invocation;
import distribuicao.Requestor;
import distribuicao.Termination;
import distribuicao.message.Message;

public class Client {
	public static void main(String[] args) {
		
		try {
			Scanner scanner = new Scanner(System.in);
			while(true){
				EstoqueProxy proxy = new EstoqueProxy("localhost", 2000, 1234);
				String msg = scanner.nextLine();
				String[] msgArray = msg.split(" ");
				switch (msgArray[0]) {
				case "add":
					proxy.add(msgArray[1]);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
