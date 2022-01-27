package demo.tykendpoing;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestBody {
    public static String getValid() throws IOException {
        return FileUtils.readFileToString(new File( TestBody.class.getResource("/test-request-body.json").getFile()), StandardCharsets.UTF_8);
    }
}
