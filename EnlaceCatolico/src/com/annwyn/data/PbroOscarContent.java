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
	
	public static void GetContent (){
      
	if (ITEMS.size()==0 )
	{
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
						content = setCleanString(property.getFirstChild().getNodeValue().toString());
					}
				}
				//damos tratamiento al titulo
				title = setRemoveWord(title," ",7);
				addItem(new PbroOscarItem(Integer.toString(id),title,content));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	}
	/**
	 * An array of sample (dummy) items.
	 */
	public static List<PbroOscarItem> ITEMS = new ArrayList<PbroOscarItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, PbroOscarItem> ITEM_MAP = new HashMap<String, PbroOscarItem>();

	static {
		
		 
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
		String strContent = "";
		
		// Pasamos el valor a la variable interna 
		strContent = Cadena; 
		
		// Eliminamos las imagenes  
		strContent = strContent.replaceAll("<img.+/(img)*>", "");
		
		// Eliminamos la linea de parrafo donde se establecia la imagen
		strContent = strContent.replaceAll("<p style=\"text-align: justify;\"><span style=\"line-height: 1.3em;\"></span></p>", "");
		strContent = strContent.replaceAll("<p style=\"text-align: justify;\"> </p>", "");
		
		// Formateamos como HTML 
		strContent = Html.fromHtml(strContent).toString();
		
		// Retornamos la variable 
		return strContent;
	}
	

	private static String setRemoveWord(String Cadena, String Delim, int Cant)
	{
		 String[] items = Cadena.split(Delim);
		 String NewCadena = "";
		 int i = 0;
		 for (String item : items)
		 {
			 NewCadena = NewCadena + " " + item;
			 //System.out.println("item = " + item);
		     if (i == Cant-1)
		     {
		    	 return NewCadena + " ...";
		      }
		     i++;
		  }
		  return NewCadena;
	}
	
}

