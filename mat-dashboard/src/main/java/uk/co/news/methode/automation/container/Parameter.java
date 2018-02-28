package uk.co.news.methode.automation.container;

public class Parameter {
	
	private Object[] data;
	private Class<?> params[];
	
	public void setParamObject(Object[] paramObject) {
		data = paramObject;
	}
	
	public void setClassObject(Class<?>[] classObject) {
		params = classObject;
	}
	
	public Class<?>[] getParamObject() {
		return params;
	}
	
	public Object[] getObject() {
		return data;
	}
}
