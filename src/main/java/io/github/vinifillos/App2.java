package io.github.vinifillos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class App2 {
    public static void main(String[] args) {
        try {

            // Arquivo para modificar
            File xmlFile = new File("src/main/resources/data/input.xml");

            // Carrega o XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            Element root = document.getDocumentElement();
            document.getDocumentElement().normalize();

            // Obtém a lista de nós <book>
            NodeList bookList = document.getElementsByTagName("book");

            // Lista de novos livros para adicionar
            String[][] newBooks = {
                    {"Effective Java", "Joshua Bloch", "2018"},
                    {"Clean Code", "Robert C. Martin", "2008"},
                    {"Design Patterns", "Erich Gamma", "1994"},
                    {"The Pragmatic Programmer", "Andrew Hunt", "1999"},
                    {"Refactoring", "Martin Fowler", "2018"}
            };

            for (String[] bookData : newBooks) {
                // Cria o elemento <book>
                Element book = document.createElement("book");

                // Adiciona o título
                Element title = document.createElement("title");
                title.appendChild(document.createTextNode(bookData[0]));
                book.appendChild(title);

                // Adiciona o autor
                Element author = document.createElement("author");
                author.appendChild(document.createTextNode(bookData[1]));
                book.appendChild(author);

                // Adiciona o ano
                Element year = document.createElement("year");
                year.appendChild(document.createTextNode(bookData[2]));
                book.appendChild(year);

                // Adiciona o <book> ao <books>
                    root.appendChild(book);
            }


            // Modifica os valores dos nós
            for (int i = 0; i < bookList.getLength(); i++) {
                Node book = bookList.item(i);
                if (book.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) book;

                    // Altera o título do primeiro livro
                    if (i == 0) {
                        element.getElementsByTagName("title").item(0).setTextContent("Modifing text 1");
                    }
                    if (i == 0) {
                        element.getElementsByTagName("author").item(0).setTextContent("Modifing author 1");
                    }
                }
            }

            // Salva as alterações no arquivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            System.out.println("XML modificado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}