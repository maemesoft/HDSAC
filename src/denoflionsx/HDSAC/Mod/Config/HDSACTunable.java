package denoflionsx.HDSAC.Mod.Config;

import denoflionsx.HDSAC.Mod.HDSACMod;
import denoflionsx.denLib.Config.Annotations.Config;
import denoflionsx.denLib.Config.Annotations.Tunable;
import net.minecraftforge.common.Configuration;

public class HDSACTunable {

    @Config
    public static Configuration config = new Configuration(HDSACMod.configLocation);

    @Tunable(category = "server")
    public static class Server {

        public static String useInternalServer = String.valueOf(true);
        public static String serverUrl = "127.0.0.1";
        public static String serverPort = String.valueOf(80);
    }
}
