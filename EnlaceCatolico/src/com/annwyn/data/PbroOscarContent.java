package com.annwyn.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.text.Html;

/**
 ** Clase con contenido DUMMY para cargar en la aplicacion 
 */
public class PbroOscarContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<PbroOscarItem> ITEMS = new ArrayList<PbroOscarItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, PbroOscarItem> ITEM_MAP = new HashMap<String, PbroOscarItem>();

	static {
		
		URL url = null;
		
		int id = 0;
		String title = "", content = "";
		
		try {
			url = new URL("http://avemariatv.org/padre-oscar?format=feed&type=rss");
			}catch (MalformedURLException e) {
				e.printStackTrace();
			}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			URLConnection connection = url.openConnection();
			InputStream in= connection.getInputStream();
			Document dom = builder.parse(in);
			Element root = dom.getDocumentElement();
			NodeList items = root.getElementsByTagName("item");
			for (int i=0;i<items.getLength();i++){			
				Node item = items.item(i);
				NodeList properties = item.getChildNodes();
				for (int j=0;j<properties.getLength();j++){
					Node property = properties.item(j);
					String name = property.getNodeName();
					if (name.equalsIgnoreCase("title")){
						id++;
						title = (property.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("description")){
						content = Html.fromHtml(property.getFirstChild().getNodeValue()).toString();				
					}
				}
				addItem(new PbroOscarItem(Integer.toString(id),title,content));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

	private static void addItem(PbroOscarItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item that contains a unique ID that represents the position of
	 * the element, the title and the content.
	 */
	public static class PbroOscarItem {
		public String id;
		public String title;
		public String content;

		public PbroOscarItem(String id, String title, String content) {
			this.id = id;
			this.title = title;
			this.content = content;
		}

		/**
		 * This method returns only the title because that's the way it is
		 * used in the fragments 
		 */
		@Override
		public String toString() {
			return title;
		}
	}
	
	private static String setCleanString(String Cadena)
	{
		// Variable a retornar 
		String stringClean = "";
		
		// Eliminamos de caracteres HTML 
		Cadena = Cadena.replace("<br/>", ""); 
		Cadena = Cadena.replace("<p>", "");
		Cadena = Cadena.replace("&quot;", "\"");
		Cadena = Cadena.replace("&amp;", "&");
		Cadena = Cadena.replace("&lt;", "<");
		Cadena = Cadena.replace("&gt;", ">");
		Cadena = Cadena.replace("&iexcl;", "¡");
		Cadena = Cadena.replace("&copy;", "©");
		Cadena = Cadena.replace("&reg;", "®");
		Cadena = Cadena.replace("&iquest;", "¿");
		Cadena = Cadena.replace("&aacute;", "á");
		Cadena = Cadena.replace("&eacute;", "é");
		Cadena = Cadena.replace("&iacute;", "í");
		Cadena = Cadena.replace("&oacute;", "ó");
		Cadena = Cadena.replace("&uacute;", "ú");
		Cadena = Cadena.replace("&uuml;", "ü");
		Cadena = Cadena.replace("&ntilde;", "ñ");
		Cadena = Cadena.replace("&Ntilde;", "Ñ");
		
		// Retornamos la variable 
		return stringClean;
	}
}

