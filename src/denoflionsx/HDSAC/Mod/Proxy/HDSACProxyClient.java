package denoflionsx.HDSAC.Mod.Proxy;

import denoflionsx.HDSAC.Mod.Utils.SkinUrlParser;
import java.io.File;
import net.minecraft.client.Minecraft;

public class HDSACProxyClient extends HDSACProxy {

    @Override
    public String processPlayer(String skinurl) {
        return SkinUrlParser.parseURL(skinurl);
    }

    @Override
    public String getConfigDir() {
        return Minecraft.getMinecraftDir() + File.separator + "config" + File.separator + "denoflionsx" + File.separator + "HDSAC" + File.separator;
    }
}
