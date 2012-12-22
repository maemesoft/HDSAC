package denoflionsx.HDSkinsAndCloaks.Proxy;

import denoflionsx.HDSkinsAndCloaks.HDSAC;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;

public class ProxyClient extends Proxy{

    @Override
    public String getConfigurationDirectory() {
        return Minecraft.getMinecraftDir() + File.separator + "config" + File.separator + "denoflionsx" + File.separator + "HDSAC" + File.separator;
    }

    @Override
    public boolean isClient() {
        return true;
    }

    @Override
    public void printMappings() {
        HDSAC.Core.print("EntityPlayerSP Mapping: " + EntityPlayerSP.class.getName());
        HDSAC.Core.print("EntityOtherPlayerMP Mapping: " + EntityOtherPlayerMP.class.getName());
        HDSAC.Core.print("TileEntitySkullRenderer Mapping: " + TileEntitySkullRenderer.class.getName());
        HDSAC.Core.print("ImageBufferDownload Mapping: " + ImageBufferDownload.class.getName());
    }

}
