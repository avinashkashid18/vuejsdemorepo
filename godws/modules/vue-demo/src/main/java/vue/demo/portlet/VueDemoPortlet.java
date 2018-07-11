package vue.demo.portlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import vue.demo.constants.VueDemoPortletKeys;

/**
 * @author AK51103
 */
@Component(
		configurationPid =
				VueDemoPortletKeys.CONFIGURATION_ID,
		immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=vue-demo Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + VueDemoPortletKeys.VueDemo, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class VueDemoPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute(ExampleConfiguration.class.getName(), _exampleConfiguration);
		PortletPreferences portletPreferences=renderRequest.getPreferences();
		String color = portletPreferences.getValue("favoriteColor", _exampleConfiguration.favoriteColor());
		System.out.println("<<<<<<<  Color  "+color);
		super.doView(renderRequest, renderResponse);
	}

	public String getFavoriteColor(Map labels) {
		return (String) labels.get(_exampleConfiguration.favoriteColor());
	}


	protected void activate(Map<Object, Object> properties) {
		_exampleConfiguration = ConfigurableUtil.createConfigurable(ExampleConfiguration.class, properties);
	}

	private volatile ExampleConfiguration _exampleConfiguration;
}