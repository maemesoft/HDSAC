package denoflionsx.HDSAC.Mod.SkinServer;

import denoflionsx.HDSAC.Mod.Config.HDSACTunable;
import denoflionsx.HDSAC.Mod.HDSACMod;
import java.io.File;
import java.lang.reflect.Method;

public class StartServer {

    public static final File dir1 = new File(HDSACMod.Proxy.getConfigDir() + "MinecraftSkins");
    public static final File dir2 = new File(HDSACMod.Proxy.getConfigDir() + "MinecraftCloaks");

    public static void Start() {
        try {
            Class c = Class.forName("WebServerMain");
            Method m = c.getDeclaredMethod("main", new Class[]{String[].class});
            String[] a = null;
            File[] f = new File[]{dir1, dir2};
            for (File z : f) {
                if (!z.exists()) {
                    z.mkdirs();
                }
            }
            a = new String[]{HDSACMod.Proxy.getConfigDir(), String.valueOf(HDSACTunable.Server.serverPort)};
            m.invoke(null, new Object[]{a});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
