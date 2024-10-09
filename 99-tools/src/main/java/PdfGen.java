import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfWriter;
import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.pdf.converter.PdfConverterExtension;
import com.vladsch.flexmark.profile.pegdown.Extensions;
import com.vladsch.flexmark.profile.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class PdfGen {
    static final DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(
            Extensions.ALL
    ).toImmutable();

    public static void main(String[] args) throws Exception {
        String markdownContent = Files.readString(Path.of("./readme.md"));
        var converted = convertMarkdownToHtml(markdownContent);
        //convertHtmlToPdf(converted, Path.of("./99-tools/target/file1.pdf"));
        PdfConverterExtension.exportToPdf(new FileOutputStream(Path.of("./99-tools/target/file1.pdf").toFile()), converted, "", OPTIONS);
    }

    private static String convertMarkdownToHtml(String markdownContent) throws Exception {
        MutableDataSet options = new MutableDataSet();
        options.set(HtmlRenderer.INDENT_SIZE, 1);
        options.setFrom(ParserEmulationProfile.KRAMDOWN);
        options.set(Parser.EXTENSIONS, Parser.EXTENSIONS.get(OPTIONS))
                .set(Formatter.DEFAULT_LINK_RESOLVER, true);

        //options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));
        //options.set(HtmlRenderer.SOFT_BREAK, "<br /><br />\n");

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(markdownContent);
        return renderer.render(document);  // Convertir en HTML
    }

    private static void convertHtmlToPdf(String htmlContent, Path outputPdfPath) throws DocumentException, IOException {


        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(outputPdfPath.toFile()));
        document.open();

        // Utiliser HTMLWorker pour ajouter du contenu HTML au document PDF
        HTMLWorker htmlWorker = new HTMLWorker(document);
        htmlWorker.parse(new StringReader(htmlContent));

        document.close();
    }
}
