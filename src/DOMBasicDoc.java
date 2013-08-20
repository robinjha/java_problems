import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMBasicDoc {
    public static void main(String args[]) {
        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);
            Element memberList = doc.createElement("BARCODES");
            root.appendChild(memberList);
            for (int i = 0; i <= 2000; i++) {
            	if(i < 10){
                Element member = doc.createElement("BARCODE");
                member.appendChild(doc.createTextNode(String.format("BZAKQQXXX%s",Integer.toString(i))));
                memberList.appendChild(member);
            	}
            	else if(i >= 10 && i < 100){
            		Element member = doc.createElement("BARCODE");
                member.appendChild(doc.createTextNode(String.format("BZAKQQXX%s",Integer.toString(i))));
                memberList.appendChild(member);
            	}
            	else if(i >=100 && i < 1000){
            		Element member = doc.createElement("BARCODE");
                member.appendChild(doc.createTextNode(String.format("BZAKQQX%s",Integer.toString(i))));
                memberList.appendChild(member);
            	}
            	else{
            		Element member = doc.createElement("BARCODE");
                member.appendChild(doc.createTextNode(String.format("BZAKQQ%s",Integer.toString(i))));
                memberList.appendChild(member);
            	}
            }
            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer trans = tFact.newTransformer();

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            System.out.println(writer.toString());

        } catch (TransformerException ex) {
            System.out.println("Error outputting document");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error building document");
        }
    }
}
