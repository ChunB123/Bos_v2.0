package b_proxy;
/**
 * 服务器的实现类
 * @author admin
 *
 */
public class Waitress implements Waiter {

	@Override
	public void server() {
		System.out.println("服务中...");
	}

	@Override
	public String sayHello(String name) {
		return "Hello "+name;
	}

}
