package lexer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FReader {
    
    public String read(String filePath) throws IOException {

        String file = Files.readString(Path.of(filePath));
        return file;
    }
    
    public void parse() throws IOException {
        String text = read("src/test/scala/dd.jasm");
        for (int i = 0; i < text.length(); i++) {
            int CurrentPointer = text.charAt(i);
            char CCP = text.charAt(i);
            if (CCP < text.length() && !Character.isWhitespace(CCP)) {
                
            }
            
        }
        
    }
    
}
