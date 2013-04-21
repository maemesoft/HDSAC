package denoflionsx.HDSAC.Mod.Proxy;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.MinecraftForge;

public class HDSACProxy implements IHDSACProxy {

    @Override
    public void print(String msg) {
        FMLLog.info("[HDSAC]: " + msg);
    }

    @Override
    public String processPlayer(String skinurl) {
        return skinurl;
    }

    @Override
    public void registerForgeSubscribe(Object o) {
        MinecraftForge.EVENT_BUS.register(o);
    }

    @Override
    public String getConfigDir() {
        return null;
    }
}
