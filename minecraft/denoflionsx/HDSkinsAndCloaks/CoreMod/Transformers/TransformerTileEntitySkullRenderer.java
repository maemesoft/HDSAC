package denoflionsx.HDSkinsAndCloaks.CoreMod.Transformers;

import codechicken.core.asm.ClassOverrider;
import codechicken.core.asm.ObfuscationManager;
import cpw.mods.fml.relauncher.IClassTransformer;
import denoflionsx.HDSkinsAndCloaks.CoreMod.HDSACCoreMod;
import denoflionsx.HDSkinsAndCloaks.Interfaces.IHDSACTransformer;

public class TransformerTileEntitySkullRenderer implements IClassTransformer, IHDSACTransformer {

    @Override
    public byte[] transform(String name, byte[] bytes) {
        bytes = ClassOverrider.overrideBytes(name, bytes, new ObfuscationManager.ClassMapping(this.getObfClassName()), HDSACCoreMod.location);
        return bytes;
    }

    @Override
    public String getObfClassName() {
        return "bbw";
    }
}
