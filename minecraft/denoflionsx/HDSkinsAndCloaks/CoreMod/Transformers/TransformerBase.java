package denoflionsx.HDSkinsAndCloaks.CoreMod.Transformers;

import denoflionsx.HDSkinsAndCloaks.CoreMod.HDSACCoreMod;
import denoflionsx.denLib.CoreMod.ASM.denLibTransformer;
import java.io.File;

public class TransformerBase extends denLibTransformer{

    @Override
    public File getLocation() {
        return HDSACCoreMod.location;
    } 
}
