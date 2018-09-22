package distribuicao;

public interface IRequestHandler {

	public void send(byte[] data) throws Exception;
	public byte[] receive() throws Exception;
	
}
