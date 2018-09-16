package springData;


import b_proxy.Waiter;
import b_proxy.Waitress;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Proxy;

/**
 * @author YaphetS
 * @date 2018/9/14 下午9:17
 */
public class ServiceImpl {
	@Test
	public void demo(){
		JpaRepository jpaRepository=new JpaRepositoryImpl();
		/**
		 * ClassLoader :类加载器.
		 * Class[]     :被增强的对象实现的所有接口
		 * InvocationHandler	:处理类.
		 */
		// 第一个参数:
		ClassLoader classLoader = jpaRepository.getClass().getClassLoader();
		// 第二个参数:
		Class[] interfaces = jpaRepository.getClass().getInterfaces();

		JpaRepository proxyInstance = (JpaRepository) Proxy.newProxyInstance(classLoader, interfaces, new SpringInvocationHandler(jpaRepository));






		proxyInstance.save();
	}
}
