package io.github.vinifillos;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class RemovedorDadosXML {

    public static void main(String[] args) {
        try {
            // Caminho do arquivo XML
            File xmlFile = new File("src/main/resources/data/input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Normaliza o documento
            doc.getDocumentElement().normalize();

            // Obtém o nó <books>
            NodeList booksList = doc.getElementsByTagName("books");
            if (booksList.getLength() > 0) {
                Node booksNode = booksList.item(0);

                // Remove todos os filhos do nó <books>
                while (booksNode.hasChildNodes()) {
                    booksNode.removeChild(booksNode.getFirstChild());
                }
            }

            // Salva no mesmo arquivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            System.out.println("XML resetado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
