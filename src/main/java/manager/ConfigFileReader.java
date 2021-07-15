package manager;

import enums.BrowserType;

public class ConfigFileReader {

    public String getApplicationUrl() {
        String url = System.getProperty("app.url");
        if(url != null) return url;
        else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public BrowserType getBrowser() {
        String browserName = System.getProperty("local.browser");
        if(browserName == null || browserName.equals("CHROME")) return BrowserType.CHROME;
        else if(browserName.equals("FIREFOX")) return BrowserType.FIREFOX;
        else if(browserName.equals("EDGE")) return BrowserType.EDGE;
        else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

}


