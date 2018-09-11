package analise;


public interface IClient {
	void add(String item) throws Exception;
	void remove(String item) throws Exception;;
	void list() throws Exception;
}
