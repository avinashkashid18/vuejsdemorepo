<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page import="vue.demo.portlet.ExampleConfiguration"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	ExampleConfiguration exampleConfiguration = (ExampleConfiguration) renderRequest.getAttribute(ExampleConfiguration.class.getName());

	String favoriteColor = StringPool.BLANK;
	String textColor = StringPool.BLANK;
	if (Validator.isNotNull(exampleConfiguration)) {
		favoriteColor = portletPreferences.getValue("favoriteColor", exampleConfiguration.favoriteColor());
		textColor = portletPreferences.getValue("textColor", exampleConfiguration.getTest());
	}
%>