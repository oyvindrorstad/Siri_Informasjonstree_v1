package oyvindr.rammeverk.beregning;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathExpression;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Xml2Hashmap {

    public static void test() throws ParserConfigurationException, IOException, SAXException {

        File fXmlFile = new File("test.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = dBuilder.parse(fXmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map<String, String>> nodes = null;
        try {
            nodes = fromNodeList( eval(doc, "//skatteforholdFastEiendom"));
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        System.out.println(nodes);
    }

    public static NodeList eval(final Document doc, final String pathStr)
            throws XPathExpressionException {
        final XPath xpath = XPathFactory.newInstance().newXPath();
        final XPathExpression expr = xpath.compile(pathStr);
        return (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
    }

    public static List<Map<String, String>> fromNodeList(final NodeList nodes) {
        final List<Map<String, String>> out = new ArrayList<Map<String, String>>();
        int len = (nodes != null) ? nodes.getLength() : 0;
        for (int i = 0; i < len; i++) {
            NodeList children = nodes.item(i).getChildNodes();
            Map<String, String> childMap = new HashMap<String, String>();
            for (int j = 0; j < children.getLength(); j++) {
                Node child = children.item(j);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                    childMap.put( nodes.item(i).getNodeName()  + "/" + child.getNodeName(), child.getTextContent());
            }
            out.add(childMap);
        }
        return out;
    }




}

