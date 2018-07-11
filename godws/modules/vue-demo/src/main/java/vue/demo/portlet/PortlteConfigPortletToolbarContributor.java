package vue.demo.portlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.toolbar.contributor.PortletToolbarContributor;
import com.liferay.portal.kernel.servlet.taglib.ui.Menu;
import com.liferay.portal.kernel.servlet.taglib.ui.MenuItem;
import com.liferay.portal.kernel.servlet.taglib.ui.URLMenuItem;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import vue.demo.constants.VueDemoPortletKeys;

/**
 * @author AK51103
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + VueDemoPortletKeys.VueDemo,
		"mvc.path=-"
	},
	service = PortletToolbarContributor.class
)
public class PortlteConfigPortletToolbarContributor
	implements PortletToolbarContributor {

	@Override
	public List<Menu> getPortletTitleMenus(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		List<Menu> menus = new ArrayList<>();

		Menu menu = new Menu();

		List<MenuItem> menuItems = new ArrayList<>();

		URLMenuItem urlMenuItem = new URLMenuItem();

		urlMenuItem.setLabel("Liferay");
		urlMenuItem.setURL("http://www.liferay.com");
		menuItems.add(urlMenuItem);
		urlMenuItem = new URLMenuItem();
		urlMenuItem.setLabel("Testing");
		urlMenuItem.setURL("http://www.liferay.com");
		menuItems.add(urlMenuItem);

		menu.setDirection("right");
		menu.setExtended(false);
		menu.setIcon("sites");
		menu.setMarkupView("lexicon");
		menu.setMenuItems(menuItems);

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", getLocale(portletRequest), getClass());

		menu.setMessage(LanguageUtil.get(resourceBundle, "list-of-links"));

		menu.setScroll(false);
		menu.setShowArrow(false);
		menu.setShowWhenSingleIcon(true);

		menus.add(menu);

		return menus;
	}

	protected Locale getLocale(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		return themeDisplay.getLocale();
	}

}