package denoflionsx.HDSkinsAndCloaks.CoreMod.Libs;

import cpw.mods.fml.relauncher.ILibrarySet;

public class HDSACLib implements ILibrarySet{
    
    public static final String[] Hashes = new String[]{"CE0A344DA463FD18C4A9586408AD36D804F59FA2".toLowerCase()};
    public static final String[] Libs = new String[]{"WebServerLite.jar"};

    @Override
    public String[] getHashes() {
        return Hashes;
    }

    @Override
    public String[] getLibraries() {
        return Libs;
    }

    @Override
    public String getRootURL() {
        return "http://www.jibble.org/files/%s";
    }
}
