package denoflionsx.HDSkinsAndCloaks.Utils;

import denoflionsx.HDSkinsAndCloaks.HDSAC;
import java.net.HttpURLConnection;
import java.net.URL;

public class SkinUtils {

    public static final String Skins = "MinecraftSkins/";
    public static final String Cloaks = "MinecraftCloaks/";
    public static final String ext = ".png";
    public static final String Mojang_Skins = "http://skins.minecraft.net/" + Skins;
    public static final String Mojang_Cloaks = "http://skins.minecraft.net/" + Cloaks;

    public static boolean exists(String URLName) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con =
                    (HttpURLConnection) new URL(URLName).openConnection();
            con.setRequestMethod("GET");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getSkin(String name) {
        if (HDSAC.Core == null) {
            return Mojang_Skins;
        } else {
            if (exists(HDSAC.Core.url + Skins + name + ext)) {
                return HDSAC.Core.url + Skins + name + ext;
            } else {
                return Mojang_Skins + name + ext;
            }
        }
    }

    public static String getCloak(String name) {
        if (HDSAC.Core == null) {
            return Mojang_Cloaks;
        } else {
            if (exists(HDSAC.Core.url + Cloaks + name + ext)) {
                return HDSAC.Core.url + Cloaks + name + ext;
            } else {
                return Mojang_Cloaks + name + ext;
            }
        }
    }
}
