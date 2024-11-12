import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class ConcatReadme {

    static Map<String, List<String>> documents = Map.of(
            "java-formation.md", List.of("1-base", "2-Tableau", "3-String", "4-Classes", "9-Interface", "5-Collection", "7-Streams", "8-Enum", "10-Exception"),
            "Spring-boot-formation.md", List.of("20-Spring/21-Introduction",
                    "20-Spring/22-Base",
                    "20-Spring/23-SpringMVC")
    );

    public static void main(String[] args) throws Exception {
        documents.entrySet().forEach(entry -> {
            var chapters = entry.getValue();
            var document = Path.of("./", entry.getKey());
            try {
                Files.deleteIfExists(document);
                try (var output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Path.of("./", entry.getKey()).toFile())))) {
                    chapters.stream().forEach(chapter -> {
                        try {
                            output.write(Files.readString(Path.of("./", chapter, "readme.md")).replaceAll("/assets", "/" + chapter + "/assets"));
                            output.write("\n\n<div style=\"page-break-before: always\"> </div>\n\n");
                        } catch (IOException e) {
                           e.printStackTrace();
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

