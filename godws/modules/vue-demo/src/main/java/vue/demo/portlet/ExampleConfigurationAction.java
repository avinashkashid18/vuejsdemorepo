package vue.demo.portlet;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import vue.demo.constants.VueDemoPortletKeys;

@Component(configurationPid = VueDemoPortletKeys.CONFIGURATION_ID, configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true, property = {
		"javax.portlet.name=" + VueDemoPortletKeys.VueDemo }, service = ConfigurationAction.class)
public class ExampleConfigurationAction extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String favoriteColor = ParamUtil.getString(actionRequest, "favoriteColor");
		String textColor = ParamUtil.getString(actionRequest, "textColor");
System.out.println("<<<< textColor "+textColor);
		setPreference(actionRequest, "favoriteColor", favoriteColor);
		setPreference(actionRequest, "textColor", textColor);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ExampleConfiguration.class.getName(), _exampleConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	
	protected void activate(Map<Object, Object> properties) {
		_exampleConfiguration = ConfigurableUtil.createConfigurable(ExampleConfiguration.class, properties);
	}

	private volatile ExampleConfiguration _exampleConfiguration;

}