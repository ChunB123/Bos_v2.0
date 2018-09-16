package springData;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author YaphetS
 * @date 2018/9/14 下午9:10
 */
public class SpringInvocationHandler implements InvocationHandler {
	private JpaRepository repository;

	public SpringInvocationHandler(JpaRepository repository){
		this.repository =repository ;
	}

	@Override
	/**
	 * 方法的参数:
	 * * proxy	:产生的代理对象.
	 * * method	:当前正在调用的目标类的方法.
	 * * params	:正在执行的方法中的参数.
	 */
	public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
			JpaRepository simpleJpaRepository=new SimpleJpaRepository();
			simpleJpaRepository.save();
			return null;
	}
}
