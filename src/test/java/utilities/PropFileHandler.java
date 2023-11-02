package utilities;

import org.apache.commons.configuration2.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropFileHandler {
    public static Properties config = new Properties();
    public static PropertiesConfiguration write;
    static
    {
        try{
            FileInputStream configReader = new FileInputStream("src/test/resources/testData/config.properties");
            try{
                config.load(configReader);
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static String readProperty(String property)
    {
        return config.getProperty(property);
    }
}
