package denoflionsx.HDSkinsAndCloaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import denoflionsx.HDSkinsAndCloaks.Core.HDSACCore;
import denoflionsx.HDSkinsAndCloaks.Proxy.Proxy;
import denoflionsx.HDSkinsAndCloaks.SkinServer.ServerThread;
import net.minecraft.src.EntityPlayerSP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

@Mod(modid = "HDSAC", name = "HD Skins and Cloaks", version = "0.2A", dependencies = "required-after:denLib")
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class HDSAC {

    @Mod.Instance
    public static Object instance;
    @SidedProxy(clientSide = "denoflionsx.HDSkinsAndCloaks.Proxy.ProxyClient", serverSide = "denoflionsx.HDSkinsAndCloaks.Proxy.ProxyServer")
    public static Proxy proxy;
    public static HDSACCore Core;
    public static ServerThread server;
    public static boolean setup = false;

    public HDSAC() {
    }

    @Mod.PreInit
    public void preload(FMLPreInitializationEvent evt) {
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        Core = new HDSACCore();
    }

    @Mod.Init
    public void load(FMLInitializationEvent event) {
        Core.setupConfig();
    }

    @Mod.PostInit
    public void modsLoaded(FMLPostInitializationEvent evt) {
        if (Core.useInternalServer) {
            server = new ServerThread();
            server.start();
            HDSAC.Core.print("Skin server started!");
        }
        HDSAC.proxy.printMappings();
    }

    @ForgeSubscribe
    public void onWorldLoaded(WorldEvent.Load event) {
    }

    @ForgeSubscribe
    public void onWorldEnded(WorldEvent.Unload event) {
    }
}
