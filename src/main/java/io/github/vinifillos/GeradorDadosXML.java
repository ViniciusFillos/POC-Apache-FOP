package io.github.vinifillos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class GeradorDadosXML {
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

            // Lista de novos livros para adicionar
            String[][] newBooks = {
                    {"Effective Java", "Joshua Bloch", "2018"},
                    {"Clean Code", "Robert C. Martin", "2008"},
                    {"The Pragmatic Programmer", "Andrew Hunt, David Thomas", "1999"},
                    {"Design Patterns", "Erich Gamma et al.", "1994"},
                    {"Refactoring", "Martin Fowler", "1999"},
                    {"Java: The Complete Reference", "Herbert Schildt", "2021"},
                    {"Head First Java", "Kathy Sierra, Bert Bates", "2005"},
                    {"Java Concurrency in Practice", "Brian Goetz", "2006"},
                    {"Spring in Action", "Craig Walls", "2018"},
                    {"Microservices Patterns", "Chris Richardson", "2018"},
                    {"Kubernetes Up & Running", "Kelsey Hightower et al.", "2017"},
                    {"Docker Deep Dive", "Nigel Poulton", "2021"},
                    {"Building Microservices", "Sam Newman", "2015"},
                    {"Continuous Delivery", "Jez Humble, David Farley", "2010"},
                    {"Site Reliability Engineering", "Betsy Beyer et al.", "2016"},
                    {"The Phoenix Project", "Gene Kim et al.", "2013"},
                    {"The DevOps Handbook", "Gene Kim et al.", "2016"},
                    {"Code Complete", "Steve McConnell", "2004"},
                    {"You Don't Know JS", "Kyle Simpson", "2014"},
                    {"Eloquent JavaScript", "Marijn Haverbeke", "2018"},
                    {"JavaScript: The Good Parts", "Douglas Crockford", "2008"},
                    {"HTML and CSS: Design and Build Websites", "Jon Duckett", "2011"},
                    {"CSS Secrets", "Lea Verou", "2015"},
                    {"JavaScript and JQuery", "Jon Duckett", "2014"},
                    {"Python Crash Course", "Eric Matthes", "2015"},
                    {"Fluent Python", "Luciano Ramalho", "2015"},
                    {"Automate the Boring Stuff with Python", "Al Sweigart", "2015"},
                    {"Introduction to the Theory of Computation", "Michael Sipser", "1996"},
                    {"Structure and Interpretation of Computer Programs", "Harold Abelson, Gerald Jay Sussman", "1996"},
                    {"Computer Networking: A Top-Down Approach", "James F. Kurose, Keith W. Ross", "2017"},
                    {"Operating System Concepts", "Abraham Silberschatz et al.", "2018"},
                    {"Modern Operating Systems", "Andrew S. Tanenbaum", "2014"},
                    {"Computer Organization and Design", "David A. Patterson, John L. Hennessy", "2021"},
                    {"The Art of Computer Programming", "Donald E. Knuth", "1968"},
                    {"Introduction to Algorithms", "Thomas H. Cormen et al.", "2009"},
                    {"Grokking Algorithms", "Aditya Y. Bhargava", "2016"},
                    {"Algorithm Design Manual", "Steven S. Skiena", "2020"},
                    {"Cracking the Coding Interview", "Gayle Laakmann McDowell", "2015"},
                    {"Programming Pearls", "Jon Bentley", "1986"},
                    {"The Mythical Man-Month", "Frederick P. Brooks Jr.", "1975"},
                    {"Software Engineering", "Ian Sommerville", "2015"},
                    {"Peopleware", "Tom DeMarco, Timothy Lister", "1987"},
                    {"Extreme Programming Explained", "Kent Beck", "1999"},
                    {"Domain-Driven Design", "Eric Evans", "2003"},
                    {"The Clean Coder", "Robert C. Martin", "2011"},
                    {"Soft Skills: The Software Developer's Life Manual", "John Sonmez", "2014"},
                    {"The Manager’s Path", "Camille Fournier", "2017"},
                    {"Deep Work", "Cal Newport", "2016"},
                    {"A Mind for Numbers", "Barbara Oakley", "2014"},
                    {"How to Win Friends and Influence People", "Dale Carnegie", "1936"}
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

                // Adiciona o <book> ao <books> (elemento root precisa já estar definido no arquivo!)
                    root.appendChild(book);
            }

            // Salva as alterações no arquivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            System.out.println("XML gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}