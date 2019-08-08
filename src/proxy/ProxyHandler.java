package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler{
	private Object object;
	public ProxyHandler(Object object) {
		this.object = object;
	}
	
	public Object proxyInstance() {
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("proxy begin");
		Object result = method.invoke(this.object, args);
		System.out.println("proxy end");
		
		return result;
		
	}

}
