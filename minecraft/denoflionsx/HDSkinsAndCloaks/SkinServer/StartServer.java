package denoflionsx.HDSkinsAndCloaks.SkinServer;

import denoflionsx.HDSkinsAndCloaks.HDSAC;
import java.io.File;
import java.lang.reflect.Method;

public class StartServer {

    public static final File dir1 = new File(HDSAC.proxy.getConfigurationDirectory() + File.separator + "MinecraftSkins");
    public static final File dir2 = new File(HDSAC.proxy.getConfigurationDirectory() + File.separator + "MinecraftCloaks");

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
            a = new String[]{HDSAC.proxy.getConfigurationDirectory(), String.valueOf(HDSAC.Core.port)};
            m.invoke(null, new Object[]{a});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
