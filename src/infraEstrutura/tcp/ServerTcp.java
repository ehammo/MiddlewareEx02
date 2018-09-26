package infraEstrutura.tcp;

import distribuicao.IServer;
import infraEstrutura.Estoque;


public class ServerTcp extends IServer {
		
	static TcpServerRequestHandler tcpServerRequestHandler;
	boolean running;
	
	public ServerTcp(int port) throws Exception{
		tcpServerRequestHandler = new TcpServerRequestHandler(port);
		estoque = new Estoque();
	}
	
	private void run() throws Exception{
		String out;
		running = true;
		while (running){
        	String[] command = tcpServerRequestHandler.receiveAsStringArray();
        	if (command[0].equals("add")) {
        		out = this.add(command[1]);
        	} else if(command[0].equals("remove")){
        		out = this.remove(command[1]);
        	} else if(command[0].equals("list")){
        		out = this.getAll();
        	} else {
        		out = "Invalid command. Use 'add', 'remove' or 'list' \n";
        	}
        	tcpServerRequestHandler.send(out.getBytes());
    	}
	}

    public static void main(String[] args) throws Exception {
    	String out;
    	int port = 2005;
    	ServerTcp server = new ServerTcp(port);
    	
    }

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		running = false;
	}

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		run();
	}
}
   
