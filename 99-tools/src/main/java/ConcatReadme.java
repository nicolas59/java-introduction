import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ConcatReadme {

    public static void main(String[] args) throws Exception {
        var chapters = List.of("1-base", "2-Tableau", "3-String", "4-Classes", "5-Collection", "7-Streams");
        var javaFormation = Path.of("./", "java-formation.md");
        if( Files.exists(javaFormation)){
            Files.delete(javaFormation);
        }
        try (var output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Path.of("./", "java-formation.md").toFile())))) {
            chapters.stream().forEach(chapter -> {
                try {
                    output.write(Files.readString(Path.of("./", chapter, "readme.md")).replaceAll("/assets", "/"+chapter+"/assets"));
                    output.write("\n\n<div style=\"page-break-before: always\"> </div>\n\n");
                } catch (IOException e) {

                }
            });
        }
    }
}

