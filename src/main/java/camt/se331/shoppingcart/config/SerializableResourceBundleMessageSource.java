package camt.se331.shoppingcart.config;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Properties;

/**
 * Created by nettanwat on 3/17/15 AD.
 */
public class SerializableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {
    public Properties getAllProperties(Locale locale){
        clearCacheIncludingAncestors();
        PropertiesHolder propertiesHolder = getMergedProperties(locale);
        Properties properties = propertiesHolder.getProperties();
        return properties;
    }
}
