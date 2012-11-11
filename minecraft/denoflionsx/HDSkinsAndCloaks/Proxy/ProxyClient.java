package denoflionsx.HDSkinsAndCloaks.Proxy;

import java.io.File;
import net.minecraft.client.Minecraft;

public class ProxyClient extends Proxy{

    @Override
    public String getConfigurationDirectory() {
        return Minecraft.getMinecraftDir() + File.separator + "config" + File.separator + "denoflionsx" + File.separator + "HDSAC" + File.separator;
    }

    @Override
    public boolean isClient() {
        return true;
    }
}
