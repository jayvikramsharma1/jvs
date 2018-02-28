package uk.co.news.methode.automation;

import uk.co.news.methode.automation.container.Parameter;

public class ParameterFactory {

	public static Parameter getParameter(Object[] dvalue) {
		Class<?> params[] = new Class[dvalue.length];
		for (int i = 0; i < dvalue.length; i++) {
			if (dvalue[i] instanceof Integer) {
				params[i] = Integer.TYPE;
			} else if (dvalue[i] instanceof String) {
				params[i] = String.class;
			} else if (dvalue[i] instanceof Boolean) {
				params[i] = Boolean.class;
			}
		}

		Parameter container = new Parameter();
		container.setClassObject(params);
		container.setParamObject(dvalue);
		return container;
	}
}
