package framework;

import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigurationManager {
	private static ConfigurationManager singleton;
	private static final Object lock = new Object();
	private static HashMap<String, String> settings;
    
    public static ConfigurationManager getInstance () {
        if (singleton == null) {
        	
            synchronized (lock) {
            	singleton = new ConfigurationManager();
            }
        }
        return singleton;
    }
    
	public void overrideConfiguration(String name, String value) {	
			String overriddenValue = settings.get(name);
						
			settings.put(name, overriddenValue);			
	}
	
    public ConfigurationManager getConfiguration() {   	
    	String settingsFilePath = ClassLoader.getSystemResource("settings.xml").getFile();
    	DocumentBuilderFactory factory;
        DocumentBuilder docBuilder;
        Document document;
        settings = new HashMap<String, String>();
        
        // guard here for missing file

        try {
        	factory = DocumentBuilderFactory.newInstance();
        	docBuilder = factory.newDocumentBuilder();
			document = docBuilder.parse(settingsFilePath);
	        NodeList nodes = document.getElementsByTagName("parameter");
	        
	        if(nodes.getLength() == 0) {
	        	throw new RuntimeException("No parameter nodes were found in the settings file.");
	        }
	        
	        for(int node = 0;node < nodes.getLength(); node++) {
	        	NamedNodeMap attributes = nodes.item(node).getAttributes();
	        	String name = attributes.getNamedItem("name").getNodeValue();
	        	String value = attributes.getNamedItem("value").getNodeValue();        	
	        	settings.put(name, value);
	        }  
        } catch (ParserConfigurationException e) {
        	throw new RuntimeException(e.getMessage());
		} catch (SAXException e) {
        	throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
        	throw new RuntimeException(e.getMessage());
		}
        finally {
        	document = null;
        	docBuilder = null;
        	factory = null;
        }  
        return getInstance();
    }

	public ConfigurationManager SetIfValueNotNull(String name, String value) {
		if(value != null) {		
			settings.put(name, value);	
		}			
		return getInstance();
	}

	public Object getValue(String name) {
		if(!settings.containsKey(name)) {		
			throw new RuntimeException(name + " is not a valid setting.");	
		}	
		return settings.get(name);
	}
	
	public String getValueAsString(String name) {
		Object value = getValue(name);
		return String.valueOf(value);
	}
	
	public long getValueAsLong(String name) {
		String value = getValueAsString(name);
		return Long.parseLong(value);
	}
}
