package denoflionsx.HDSAC.CoreMod.ASM;

import cpw.mods.fml.relauncher.IClassTransformer;
import denoflionsx.HDSAC.CoreMod.HDSACCore;
import denoflionsx.denLib.CoreMod.ASM.ClassOverride;

public class ImageBufferDownloadASM implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("bfv")) {
            bytes = ClassOverride.Override(name, bytes, "bfv", HDSACCore.location);
        }
        return bytes;
    }
}
