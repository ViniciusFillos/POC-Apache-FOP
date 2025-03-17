package io.github.vinifillos;

import org.apache.fop.apps.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class App1 {
    public static void main(String[] args) {



        // input
        File xmlFile = new File("src/main/resources/data/input.xml");
        File xsltFile = new File("src/main/resources/style/style.xsl");

        // output
        File pdfFile = new File("src/main/resources/pdf/output.pdf");
        pdfFile.getParentFile().mkdirs();

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        try (OutputStream out = new FileOutputStream(pdfFile)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            Source src = new StreamSource(xmlFile);
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}