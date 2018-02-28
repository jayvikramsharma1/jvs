package uk.co.news.methode;

public class ParameterContainer {
	
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
