package infraEstrutura.udp;

import distribuicao.IServer;
import infraEstrutura.Estoque;

public class ServerUdp extends IServer {
	
	static UdpServerRequestHandler udpServerRequestHandler;
	boolean running;	
	
	public ServerUdp(int port) throws Exception{
		estoque = new Estoque();
        udpServerRequestHandler = new UdpServerRequestHandler(port);
	}
	
	private void run() throws Exception{
		String out;
		running = true;
		while (running){
    		byte[] data = udpServerRequestHandler.receive();
    		String[] command = new String(data).split(" ");
    		command[1] = command[1].replace(System.getProperty("line.separator"), "");
        	if (command[0].equals("add")) {
        		out = this.add(command[1]);
        	} else if(command[0].equals("remove")){
        		out = this.remove(command[1]);
        	} else if(command[0].equals("list")){
        		out = this.getAll();
        	} else {
        		out = "Invalid command. Use 'add', 'remove' or 'list' \n";
        	}
        	udpServerRequestHandler.send(out.getBytes());
        }
	}
	
    public static void main(String[] args) throws Exception {
		ServerUdp server = new ServerUdp(2004);
		server.run();
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
   
