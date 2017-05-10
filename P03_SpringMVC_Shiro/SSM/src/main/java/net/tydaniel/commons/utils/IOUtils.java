package net.tydaniel.commons.utils;

import java.io.Closeable;
import java.io.IOException;

import org.springframework.util.StreamUtils;

/**
 * 流工具类，继承自Spring
 * @author 
 */

public class IOUtils extends StreamUtils {
    /**
     * closeQuietly
     * @param closeable 自动关闭
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }
}
