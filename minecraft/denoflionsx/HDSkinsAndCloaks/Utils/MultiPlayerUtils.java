package denoflionsx.HDSkinsAndCloaks.Utils;

import denoflionsx.HDSkinsAndCloaks.Config.HDSACConfig;
import denoflionsx.HDSkinsAndCloaks.HDSAC;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.Configuration;

public class MultiPlayerUtils {

    public static boolean doesServerHaveHDSAC() {
        return SkinUtils.exists("http://" + Minecraft.getMinecraft().getServerData().serverIP + "/HDSAC.cfg");
    }

    public static void downloadServerConfig() {
        if (doesServerHaveHDSAC()) {
            String ip = Minecraft.getMinecraft().getServerData().serverIP;
            File s = new File(HDSAC.proxy.getConfigurationDirectory() + "Cache" + File.separator + ip);
            if (!s.exists()) {
                s.mkdirs();
            }
            try {
                DownloadUtils.saveUrl(s.getAbsolutePath() + File.separator + "HDSAC.cfg", "http://" + ip + "/HDSAC.cfg");
                Configuration c = new Configuration(new File(s.getAbsolutePath() + File.separator + "HDSAC.cfg"));
                c.load();
                HDSAC.Core.config.configuration = (HDSACConfig) c;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            HDSAC.Core.print("Server does not seem to have HDSAC installed!");
        }
    }
}
