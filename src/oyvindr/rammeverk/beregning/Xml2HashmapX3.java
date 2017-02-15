package oyvindr.rammeverk.beregning;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


// leser inn en XML-fil og oversetter denne til en HashMap. Key=xpath , value = xml-element-verdi
public class Xml2HashmapX3 {

    public static void main(final String[] args) throws SAXException, IOException, ParserConfigurationException {
        Map<String, String> xmlHM = new HashMap<String, String>();
        new Xml2HashmapX3("test.xml", xmlHM);
    }

    public Xml2HashmapX3(final String file, Map<String, String> xmlHM) throws SAXException, IOException, ParserConfigurationException {

        File fXmlFile = new File("test.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        doc = dBuilder.parse(fXmlFile);

        parse(doc, xmlHM, doc.getDocumentElement(), "melding");

        // skriv ut sortert
        xmlHM.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.println("K: " + e.getKey() + " V: "  + e.getValue()) );

    }

    // parse gjennom subtre
    private void parse(final Document doc, Map<String, String> list, final Element e, String startTag) {
        final NodeList children = e.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            final Node n = children.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                list.put( startTag + "/" + n.getNodeName(), n.getTextContent() );
                parse(doc, list, (Element) n, startTag + "/" + n.getNodeName());
            }
        }
    }

}

