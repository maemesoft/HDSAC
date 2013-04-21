package denoflionsx.HDSAC.Mod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import denoflionsx.HDSAC.Mod.Config.HDSACTunable;
import denoflionsx.HDSAC.Mod.Proxy.HDSACProxy;
import denoflionsx.HDSAC.Mod.SkinServer.SkinServerThread;
import denoflionsx.denLib.Mod.denLibMod;
import java.io.File;

@Mod(modid = "HDSAC", name = "HDSAC", version = "@VERSION@")
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class HDSACMod {

    @Mod.Instance("HDSAC")
    public static Object instance;
    private static final String proxyPath = "denoflionsx.HDSAC.Mod.Proxy.";
    @SidedProxy(clientSide = proxyPath + "HDSACProxyClient", serverSide = proxyPath + "HDSACProxyCommon")
    public static HDSACProxy Proxy;
    public static File configLocation;
    public static SkinServerThread Server;

    @Mod.PreInit
    public void preLoad(FMLPreInitializationEvent event) {
        configLocation = new File(Proxy.getConfigDir() + "HDSAC.cfg");
        Proxy.print(configLocation.getAbsolutePath());
    }

    @Mod.Init
    public void load(FMLInitializationEvent event) {
        Proxy.print("loading...");
        denLibMod.tuning.registerTunableClass(HDSACTunable.class);
    }

    @Mod.PostInit
    public void modsLoaded(FMLPostInitializationEvent evt) {
        Proxy.print("loaded!");
        if (Boolean.valueOf(HDSACTunable.Server.useInternalServer)) {
            Server = new SkinServerThread();
            Server.start();
            Proxy.print("Internal skin server started at " + HDSACTunable.Server.serverUrl + " on port " + HDSACTunable.Server.serverPort);
        }
    }
}
