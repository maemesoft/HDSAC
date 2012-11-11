package denoflionsx.HDSkinsAndCloaks.Core;

import denoflionsx.HDSkinsAndCloaks.Config.Config;
import denoflionsx.HDSkinsAndCloaks.Config.HDSACConfig;
import denoflionsx.HDSkinsAndCloaks.HDSAC;
import java.io.File;

public class HDSACCore {

    public Config config;
    public File file;
    public File cache;
    public String url;
    public boolean useInternalServer = true;
    public int port = 80;

    public void setupConfig() {
        file = new File(HDSAC.proxy.getConfigurationDirectory() + "HDSAC.cfg");
        config = new Config(new HDSACConfig(file));
        if (file.exists()) {
            config.configuration.load();
        }
        url = config.getUrl("SkinServerURL", "http://localhost:80/");
        useInternalServer = config.configuration.get("general", "UseInternalServer", "true").getBoolean(true);
        port = config.configuration.get("general", "InternalServer_Port", port).getInt();
        config.configuration.save();
    }

    public void print(String msg) {
        System.out.println("[HDSAC]: " + msg);
    }
}
