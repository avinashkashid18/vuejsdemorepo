package vue.demo.portlet;

import aQute.bnd.annotation.metatype.Meta;
import vue.demo.constants.VueDemoPortletKeys;

@Meta.OCD(id =VueDemoPortletKeys.CONFIGURATION_ID)
public interface ExampleConfiguration {

    @Meta.AD(required = false)
    public String favoriteColor();

    @Meta.AD(deflt="This is testing",  required=false )
    public String getTest();
    
}