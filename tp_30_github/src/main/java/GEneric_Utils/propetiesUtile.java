package GEneric_Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propetiesUtile {
         /**
          * 
          * @param key
          * @return
          * @throws IOException
          */
	public String readDataproprty(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.filepath);
		
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
