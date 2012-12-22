package denoflionsx.HDSkinsAndCloaks.CoreMod;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HDSACCoreMod implements IFMLLoadingPlugin {

    //--------------------------------------------------------------------------------------------
    public static final String clazzpath = "denoflionsx.HDSkinsAndCloaks.CoreMod.Transformers.";
    public static final String Libclazzpath = "denoflionsx.HDSkinsAndCloaks.CoreMod.Libs.";
    public static final String Lib = Libclazzpath + "HDSACLib";
    public static final String Player = clazzpath + "TransformerEntityPlayerSP";
    public static final String Skull = clazzpath + "TransformerTileEntitySkullRenderer";
    public static final String OtherPlayer = clazzpath + "TransformerEntityOtherPlayerMP";
    public static final String Download = clazzpath + "TransformerImageBufferDownload";
    public static boolean hasRegistered = false;
    public static boolean hasRegisteredLibs = false;
    //--------------------------------------------------------------------------------------------
    public static String[] ASM = new String[]{Player, OtherPlayer, Skull, Download};
    public static String[] Libs = new String[]{Lib};
    public static File location;

    @Override
    public String[] getASMTransformerClass() {
         //This is mostly for debug. I was having some random ClassNotFound problems, but now it seems to have stopped.
        if (!hasRegistered) {
            List<String> asm = Arrays.asList(ASM);
            for (String s : asm) {
                try {
                    Class c = Class.forName(s);
                    if (c != null) {
                        String a = clazzpath + "Transformer";
                        int l = a.length();
                        System.out.println("[HDSAC]: " + "Registered Transformer " + s.substring(l));
                    }
                } catch (Exception ex) {
                    System.out.println("[HDSAC]: " + "Error while running transformer " + s);
                    return null;
                }
            }
            hasRegistered = true;
        }
        return ASM;
    }

    @Override
    public String[] getLibraryRequestClass() {
        if (!hasRegisteredLibs) {
            List<String> libs = Arrays.asList(Libs);
            for (String s : libs) {
                try {
                    Class c = Class.forName(s);
                    if (c != null) {
                        int i = Libclazzpath.length();
                        System.out.println("[HDSAC]: " + "Registered Library Set " + s.substring(i));
                    }
                } catch (Exception ex) {
                    System.out.println("[HDSAC]: " + "Error while running library set " + s);
                    return null;
                }
            }
            hasRegisteredLibs = true;
        }
        return Libs;
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
        System.out.println("[HDSAC]: " + "Patching client...");
    }
}
