
public abstract class Account {

	public String type;
	public abstract Account log_in(String username , String password);
	public abstract String Log_out();
}
