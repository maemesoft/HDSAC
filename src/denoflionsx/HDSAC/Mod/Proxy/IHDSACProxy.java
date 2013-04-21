package denoflionsx.HDSAC.Mod.Proxy;

public interface IHDSACProxy {

    public void print(String msg);

    public String processPlayer(String skinurl);
    
    public void registerForgeSubscribe(Object o);
    
    public String getConfigDir();
}
