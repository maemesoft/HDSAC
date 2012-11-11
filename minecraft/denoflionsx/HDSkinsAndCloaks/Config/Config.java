package denoflionsx.HDSkinsAndCloaks.Config;

public class Config {
    
    public HDSACConfig configuration;
    
    public static final String cat_url = "URLs";

    public Config(HDSACConfig configuration) {
        this.configuration = configuration;
    }

    public String getUrl(String key, String url){
        return this.configuration.get(cat_url, key, url).value;
    }
    
}
