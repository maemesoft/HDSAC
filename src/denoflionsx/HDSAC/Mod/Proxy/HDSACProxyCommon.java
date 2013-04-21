package denoflionsx.HDSAC.Mod.Proxy;

import java.io.File;

public class HDSACProxyCommon extends HDSACProxy {

    @Override
    public String getConfigDir() {
        return "./" + File.separator + "config" + File.separator + "denoflionsx" + File.separator + "HDSAC" + File.separator;
    }
}
