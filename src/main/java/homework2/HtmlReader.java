package homework2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class HtmlReader {

    private static Queue<HtmlTag> getTagsFromFile(File file) throws IOException {
        InputStream stream = new FileInputStream(file);
        StringBuffer buffer = new StringBuffer();
        int ch;
        while ((ch = stream.read()) > 0) {
            buffer.append((char) ch);
        }
        stream.close();
        String htmlFileString = buffer.toString();
        return HtmlTag.tokenize(htmlFileString);
    }


    public Queue<HtmlTag> getTagsFromHtmlFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return getTagsFromFile(file);
    }


}
