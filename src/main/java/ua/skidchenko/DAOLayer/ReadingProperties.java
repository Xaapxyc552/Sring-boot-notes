package ua.skidchenko.DAOLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadingProperties {

    public static ReadingProperties readingProperties;
    private InputStream inputStream;

    public static ReadingProperties getInstance() {
        if (readingProperties!=null)
            return readingProperties;
        return new ReadingProperties();
    }
    public Properties getPropValues() throws IOException {
        String property1 = null;
        Properties prop = null;
        try {
            prop = new Properties();
            String propFileName = "resources/database.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        return prop;
    }
}