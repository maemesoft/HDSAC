package denoflionsx.HDSAC.CoreMod;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.io.File;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(value = "1.5.1")
public class HDSACCore implements IFMLLoadingPlugin {

    public static File location;

    @Override
    public String[] getASMTransformerClass() {
        String path = "denoflionsx.HDSAC.CoreMod.ASM.";
        return new String[]{path + "ThreadDownloadImageASM", path + "ImageBufferDownloadASM"};
    }

    @Override
    public String[] getLibraryRequestClass() {
        return new String[]{"denoflionsx.HDSAC.CoreMod.Lib.WebServerLib"};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        location = (File) data.get("coremodLocation");
    }
}
