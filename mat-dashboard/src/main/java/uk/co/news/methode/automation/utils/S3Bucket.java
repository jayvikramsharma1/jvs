package uk.co.news.methode.automation.utils;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import uk.co.news.methode.automation.container.UUID;

public class S3Bucket {

	public static Document doc;

	public static Map<String, String> namespaceUris = new HashMap<String, String>();

	public static String getBookURL(String edition) {

		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}

		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getBookFeed();
		String uuid = UUID.getSlotUUID();;
		return url + uuid;
	}

	public static String getArticleURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getArticleFeed();
		String uuid = UUID.getArticleUUID();
		return url + uuid;
	}

	public static String getArticleMetadataURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getArticleMetadataFeed();
		String uuid = UUID.getArticleUUID();
		return url + uuid;
	}

	public static String getSlotURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getSlotFeed();
		String uuid = UUID.getSlotUUID();
		return url + uuid;
	}

	public static String getSlotMetadataURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getSlotMetadataFeed();
		String uuid = UUID.getSlotUUID();
		return url + uuid;
	}

	public static String getSectionURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getSectionFeed();
		String uuid = UUID.getSlotUUID();
		return url+ uuid;
	}

	public static String getEditionURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getEditionFeed();
		String uuid = UUID.getEditionUUID();
		return url + uuid;
	}

	public static String getImageURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getImageFeed();
		String uuid = UUID.getImageUUID();
		return url + uuid;
	}

	public static String getImageMetadataURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getImageMetadataFeed();
		String uuid = UUID.getImageUUID();
		// System.out.println(url + uuid + "_fl");
		//String imageMetadata = url + uuid + "_fl";
		String imageMetadata = url + uuid;
		// String imagePosition = imageMetadata.replace(" ", "");
		// System.out.println(imagePosition);
		return imageMetadata;

	}

	public static String getImagePositionalURL(String edition) {
		String title = Environment.getTitle();

		if (edition.equals("ireland")) {
			title = Environment.getTitle() + edition;
		}
		String url = Environment.getS3URL() + title + "/" + Environment.getEnvironment() + "/"
				+ Environment.getChannel() + Environment.getImagePositionalFeed();
		String uuid = UUID.getImageUUID();
		// System.out.println(url + uuid + "_fl");
		String imagePositional = url + uuid + "_pos";
		// String imagePosition = imageMetadata.replace(" ", "");
	System.out.println(imagePositional);
		return imagePositional;

	}

	public static String getXMLFeed(String url) throws Exception {

		try {

			// DocumentBuilderFactory dbFactory =
			// DocumentBuilderFactory.newInstance();
			// DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// doc = dBuilder.parse(new URL(url).openStream());
			//
			// doc.getDocumentElement().normalize();

			return getFeed(url);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String getElementByName(String element) throws DocumentException {
		
		boolean xpathStatus = element.contains("link");
		//boolean xpathStatus = element.contains("span");
		//boolean xpathStatus = element.contains("a");

		if (xpathStatus == true) {
			// System.out.println("It is true");
			return parseWithCustomXpath(element);

		} else {
			// System.out.println("It is false");
			return parseWithCustomElement(element);

			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());
			//
			// Node nList = doc.getElementsByTagName(element);
			//
			// System.out.println(doc);
			//
			// System.out.println(nList.item(0).getTextContent());
			//
			// return nList.item(0).getTextContent();
		}

	}

	public static String getFeed(String url) throws DocumentException, IOException {

		SAXReader reader = new SAXReader();
		String s3Content = null;

		try {
			//String s3KeyName = "methode/" + url.replace(Environment.getS3URL(), "");
			//System.out.println(s3KeyName);
			//s3Content = S3Uploader.getS3Object(s3KeyName.trim(), false);
			//System.out.println(s3Content);
			//doc = reader.read(new StringReader(s3Content));
			doc = reader.read(new URL(url));
			s3Content = doc.asXML().toString();
			System.out.println(s3Content);
			return s3Content;
			

		} catch (MalformedURLException e) {
			// logger.error("Invalid Feed URL", e);
		}
		return s3Content;

	}
	
	private static void initNamespace() {
		namespaceUris.put("atom", "http://www.w3.org/2005/Atom");
		namespaceUris.put("cpi", "http://xmlns.new.co.uk/types");
		namespaceUris.put("dcterms", "http://purl.org/dc/terms/");
		namespaceUris.put("age", "http://purl.org/atompub/age/1.0");
		namespaceUris.put("xhtml", "http://www.w3.org/1999/xhtml");
	}

	public static String parseWithCustomXpath(String path) throws DocumentException {
		initNamespace();
		XPath xp = DocumentHelper.createXPath(path);
		xp.setNamespaceURIs(namespaceUris);
		Element root = doc.getRootElement();
		Node content = xp.selectSingleNode(root);
		System.out.println(content.getName());
		return content.getName();

	}

	public static String parseWithCustomElement(String path) throws DocumentException {

		initNamespace();
		XPath xp = DocumentHelper.createXPath(path);
		xp.setNamespaceURIs(namespaceUris);
		Element root = doc.getRootElement();
		Node content = xp.selectSingleNode(root);
		System.out.println(content.getText());
		return content.getText();

	}

}
