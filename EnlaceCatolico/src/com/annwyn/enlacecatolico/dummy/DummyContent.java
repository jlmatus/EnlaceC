package com.annwyn.enlacecatolico.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	static {
		// Add 3 sample items.
		addItem(new DummyItem("1", "¡Vamos... Subamos a la montaña!","La montaña ha simbolizado siempre la unión del cielo con la tierra; un espacio sagrado. Ha sido en la montaña donde el hombre a tenido que subir para encontrarse con Dios y en la paz de la montaña encontrarse consigo mismo. " +
               " En el Antiguo Testamento la montaña tiene un profundo significado religioso: El monte Horeb o Sinaí es “el monte de Dios” (Ex.3,1) y, por tanto, “tierra sagrada” (Ex.3,5). Es en la montaña donde Moisés hace la alianza con Dios (Ex.19,3-8) y donde Dios le da las tablas de los mandamientos (Ex.24, 12). " +  
         " Así mismo la montaña tiene una gran importancia en el Nuevo Testamento:" + 
         " Es en la montaña donde Jesús vence al enemigo que pretende hacerse adorar como Dios (Mt.4,8). " +
     " Es en la montaña desde donde Jesús nos brinda la esencia de todo su mensaje: El sermón de las bienaventuranzas (Mt. 5,1). " +
    " Es en la montaña donde Jesús elige a los doce apóstoles (Mc.3,13). " + 
   " Es en la montaña donde Jesús se refugia a orar (Mt. 14,23). " +
  " Es a la montaña donde Jesús sube para tomar fuerzas y enfrentarse a su pasión (Mt.26,30). " ));


		addItem(new DummyItem("2", "Lo que pienso y lo que hablo es lo que vivo","Observando que un gran número de amistades, personas que me escriben, que me hablan o buscan y que tienen pensamientos y actitudes negativas en su vida, con su familia y su relación con los demás, a muchos de ellos al preguntarles sobre lo que hacen, piensan, realizan y sueñan, me responden y comunican todo negativo"));
		addItem(new DummyItem("3", "Que se te note","Contenido Dummy"));
		addItem(new DummyItem("4", "Sabes, soy Fariseo hipócrita y Publicano pecador","Donde están los que hablan de mi, Donde están por el techo van a Salir"));
	}

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public String id;
		public String title;
		public String content;

		public DummyItem(String id, String title, String content) {
			this.id = id;
			this.title = title;
			this.content = content;
		}

		@Override
		public String toString() {
			return title;
		}
	}
}
