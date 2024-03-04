package converter;

import java.io.File;

public interface ConversionService {
    String scanAndConvert(String directoryPath);
    String convert(String jsonStr);
    String save(File jsonFile, String content, File resultLogFile);
}
