package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
    Properties prop;

    public ConfigReader()
    {
        prop = new Properties();

        try
        {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");

            prop.load(fis);   // IMPORTANT
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getBrowser()
    {
        return prop.getProperty("browser");
    }

    public String geturl()
    {
        return prop.getProperty("url");
    }

    public String getusername()
    {
        return prop.getProperty("username");
    }

    public String getuserpass()
    {
        return prop.getProperty("userpass");
    }
}