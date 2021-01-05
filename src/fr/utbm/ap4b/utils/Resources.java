package fr.utbm.ap4b.utils;

import java.util.ResourceBundle;

public class Resources {
    public static final String BUNDLEPATH = "res.lang.strings_EN";
	static final ResourceBundle RESSOURCEBUNDLE = ResourceBundle.getBundle(BUNDLEPATH);
	
	public static String getStringRessources(String key) {
		try {
			return RESSOURCEBUNDLE.getString(key);
		} catch (Exception e) {
			System.err.println("Error :" + e);
			return "!" + key + "!";
		}
	}
}
