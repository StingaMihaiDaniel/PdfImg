package mihai.ImagePDF;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;

public class ImageTypes{
	/**The resulting PDF*/
	public static final String PDF = "/tmp/ImagePDF.pdf";
	/**Path to the image*/
	public static final String ImagePath = "/home/alex/Downloads/1465235_609911679044043_457971138_n.jpg";
	/**Base64 Image*/
	public static final String Img = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAACT0lEQVR42o2TXUiTURiAP+smoYuysFIsvepGiSiIhAIl3YVl5qSULqImJYJaEcoMLXUXVlZEqRlqJZhBJf4wEZvCNKQJ4kyb5Uwt/4ap/czUptvT932abrWwAw/ve17OeXgP5xxBcDPKOr9gGF/AsJBK/8wCOnsUbfMahNWGptFC7XADNdZwNyioyQ6nfvqoe1FZ32nKR4KX2I9v4Han+Qr62zHUXolwlag1RZR0ZVFoCvpver+xItnsvYWISCXlw3ZyW3egafGTo0R+zjliI/ewddMG9u4KXK5nNPosCi5r15Kks3CrZ450rddfhB7aTXrdRpfa0CxYfoJJ6iLpyTqcSS73pNKs58+6M6ceeMqSgR+iQFW0ht/kme3L+dNRqLYg5y8/dnM8z0POs6ojeS9u7J8RkQQnbwg4I0kKBh08HEKWSLWGz9A8CV3TdjrEtrutyJLeaVEQlNWMMkNYJvaqDzf7XCVSJ5IkJtODtq/IkjffHbRP2RECLtRz+LwgE5EikGacJadn/p8S/YSN11MOtO+MVH1YusqwMwKK+EUSmqdI7Zgh22STj5M/4KD0E1SMQNWYg7oxO+qCaBKvR6+8g20J1YTGCRy42y5HlW6ciwYrmZ2z5PbYuGOe536fjWLzHMVvrdxrGydEXOfyGiXJTrWOfXkGFKUmTlQOEt9gIVk/QdqrSdJbJlA3jXJJO8DBY4L7/+CtqsQ/RUtgRhPBoiis0MiR0m6iH5tQijGqqIOQa62r/8r1yhK84h7hq6rAP+EZAYnP8Tv7wu3GX7uZOz31J6xkAAAAAElFTkSuQmCC";
	 /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException
     */
	public void createPDF(String filename) throws IOException, DocumentException{
		//Step 1
		Document document = new Document();
		//Step 3
		document.open();
		//Step 4 Add a java.awt.image
		
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodedBytes = decoder.decodeBuffer(Img);
		InputStream in = new ByteArrayInputStream(decodedBytes);
		BufferedImage image = ImageIO.read(in);
		Image img = Image.getInstance(image, null);
		//document.add(new Paragraph(String.format("is an image of type java.awt.Image", img.getClass().getName())));
		document.add(img);
		//Step 5
		document.close();
	}
		/**
	     * Main method.
	     *
	     * @param    args    no arguments needed
	     * @throws DocumentException 
	     * @throws IOException 
	     * @throws DocumentException 
	     * @throws IOException
	     */
	public static void main(String[] args) throws IOException, DocumentException {
        new ImageTypes().createPDF(PDF);
	}
}