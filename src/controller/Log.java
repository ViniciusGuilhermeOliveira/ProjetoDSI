package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Log {
    
    private static final Log singleton = new Log();
    
    private final String fileName = "log.xml";
    private Document doc;
    private Node root;
    
    private Log() {
        
        try {
        
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            File file = new File(fileName);
                    
            if( file.exists() ) {
                
                doc = docBuilder.parse( file );
                doc.getDocumentElement().normalize();
                root = doc.getDocumentElement();

            } else {

                doc = docBuilder.newDocument();
                root = doc.createElement( "log" );
                doc.appendChild(root);
                save();

            }        
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static Log getInstance() {
        return singleton;
    }
    
    private void save() {
        
        try {
                
                FileOutputStream output = new FileOutputStream(fileName);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource( doc );
                StreamResult result = new StreamResult( output );

                transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "yes" );
                transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
                transformer.setOutputProperty( OutputKeys.ENCODING,"UTF-8" );
                transformer.transform( source, result );
        
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
        
    }
    
    public void addException( Exception exception, boolean showDialog, JFrame frame ) {
        
        exception.printStackTrace();
        
        Calendar date = Calendar.getInstance();
        String time = date.getTime().toString();
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        
        Element element = doc.createElement("exception");
        
        element.setAttribute( "time", time );
        element.setTextContent( sw.toString() );
        
        root.appendChild(element);
        
        save();
        
        if( showDialog ) {
            JOptionPane.showMessageDialog( frame, exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );
        }
        
    }
    
}