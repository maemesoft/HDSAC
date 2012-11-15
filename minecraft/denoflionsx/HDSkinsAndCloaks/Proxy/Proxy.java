package denoflionsx.HDSkinsAndCloaks.Proxy;

import java.io.File;

public class Proxy {
    
    public String getConfigurationDirectory(){
        return "./" + File.separator + "config" + File.separator + "denoflionsx" + File.separator + "HDSAC" + File.separator;
    }
    
    public boolean isClient(){
        return false;
    }
    
    public void printMappings(){
        
    }
    
}
