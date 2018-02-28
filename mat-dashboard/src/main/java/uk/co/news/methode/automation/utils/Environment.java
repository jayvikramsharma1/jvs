package uk.co.news.methode.automation.utils;

import java.io.File;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Environment {

	private final static String directorySeparator = File.separator;
	private final static String configRoot = "config";
	private final static String envConfig = "env.xml";
	private final static String screenshotLocation = "screenshot";

	private static String title = "";
	private static String environment = "";
	private static String userName = "";
	private static String password = "";
	private static String channel = "";
	private static String path = "";
	private static String s3URL = "";
	private static String s3Bucket = "";
	private static String s3ApiKey = "";
	private static String s3ApiSecret = "";
	private static String s3MediaPath = "";
	private static String s3ReportPath = "";
	private static String articleFeed = "";
	private static String slotFeed = "";
	private static String bookFeed = "";
	private static String sectionFeed = "";
	private static String editionFeed = "";
	private static String imageFeed = "";
	private static String articleMetadataFeed = "";
	private static String slotMetadataFeed = "";
	private static String imageMetadataFeed = "";
	private static String imagePositionalFeed = "";
	private static String screenshotPath = "";

	public static String getS3Bucket() {
		return s3Bucket;
	}

	public static String getS3URL() {
		return s3URL;
	}

	public static void setS3URL(String s3url) {
		s3URL = s3url;
	}

	public static void setS3Bucket(String s3Bucket) {
		Environment.s3Bucket = s3Bucket;
	}

	public static String getS3ApiKey() {
		return s3ApiKey;
	}

	public static void setS3ApiKey(String s3ApiKey) {
		Environment.s3ApiKey = s3ApiKey;
	}

	public static String getS3ApiSecret() {
		return s3ApiSecret;
	}

	public static void setS3ApiSecret(String s3ApiSecret) {
		Environment.s3ApiSecret = s3ApiSecret;
	}

	public static String getS3MediaPath() {
		return s3MediaPath;
	}

	public static void setS3MediaPath(String s3MediaPath) {
		Environment.s3MediaPath = s3MediaPath;
	}

	public static String getS3ReportPath() {
		return s3ReportPath;
	}

	public static void setS3ReportPath(String s3ReportPath) {
		Environment.s3ReportPath = s3ReportPath;
	}

	public static String getArticleFeed() {
		return articleFeed;
	}

	public static void setArticleFeed(String articleFeed) {
		Environment.articleFeed = articleFeed;
	}

	public static String getSlotFeed() {
		return slotFeed;
	}

	public static void setSlotFeed(String slotFeed) {
		Environment.slotFeed = slotFeed;
	}

	public static String getBookFeed() {
		return bookFeed;
	}

	public static void setBookFeed(String bookFeed) {
		Environment.bookFeed = bookFeed;
	}

	public static String getSectionFeed() {
		return sectionFeed;
	}

	public static void setSectionFeed(String sectionFeed) {
		Environment.sectionFeed = sectionFeed;
	}

	public static String getEditionFeed() {
		return editionFeed;
	}

	public static void setEditionFeed(String editionFeed) {
		Environment.editionFeed = editionFeed;
	}

	public static String getImageFeed() {
		return imageFeed;
	}

	public static void setImageFeed(String imageFeed) {
		Environment.imageFeed = imageFeed;
	}

	public static String getArticleMetadataFeed() {
		return articleMetadataFeed;
	}

	public static void setArticleMetadataFeed(String articleMetadataFeed) {
		Environment.articleMetadataFeed = articleMetadataFeed;
	}

	public static String getSlotMetadataFeed() {
		return slotMetadataFeed;
	}

	public static void setSlotMetadataFeed(String slotMetadataFeed) {
		Environment.slotMetadataFeed = slotMetadataFeed;
	}

	public static String getImageMetadataFeed() {
		return imageMetadataFeed;
	}

	public static void setImageMetadataFeed(String imageMetadataFeed) {
		Environment.imageMetadataFeed = imageMetadataFeed;
	}

	public static String getImagePositionalFeed() {
		return imagePositionalFeed;
	}

	public static void setImagePositionalFeed(String imagePositionalFeed) {
		Environment.imagePositionalFeed = imagePositionalFeed;
	}

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Environment.title = title;
	}

	public static String getEnvironment() {
		return environment;
	}

	public static void setEnvironment(String environment) {
		Environment.environment = environment;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		Environment.userName = userName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Environment.password = password;
	}

	public static String getMethodePath() {
		return path;
	}

	public static void setMethodePath(String path) {
		Environment.path = path;
	}

	public static String getChannel() {
		return channel;
	}

	public static void setChannel(String channel) {
		Environment.channel = channel;
	}

	public static String getScreenshotLocationPath() {
		return screenshotPath;
	}

	public static void setScreenshotLocationPath() {
		Environment.screenshotPath = screenshotLocation + directorySeparator + channel + directorySeparator;
	}

	public static void loadConfiguration() {

		String envConfigurationFile = configRoot + directorySeparator + envConfig;
		Document doc = XMLFileReader.getXMLFile(envConfigurationFile);
		getDefaultSettings(doc);
		loadMethodePath(doc);
		loadS3Path(doc);
		setScreenshotLocationPath();

	}

	public static void getDefaultSettings(Document doc) {

		NodeList defaultSetting = doc.getElementsByTagName("default");

		for (int i = 0; i < defaultSetting.getLength(); i++) {

			Node settings = defaultSetting.item(i);

			if (settings.hasAttributes()) {

				Attr env = (Attr) settings.getAttributes().getNamedItem("env");
				Attr title = (Attr) settings.getAttributes().getNamedItem("title");
				Attr channel = (Attr) settings.getAttributes().getNamedItem("channel");

				setEnvironment(env.getValue());
				setTitle(title.getValue());
				setChannel(channel.getValue());

				if (env != null) {

					NodeList environment = doc.getElementsByTagName(env.getValue());

					for (int e = 0; e < environment.getLength(); e++) {

						Node envSettings = environment.item(i);

						if (envSettings.hasAttributes()) {

							Attr username = (Attr) envSettings.getAttributes().getNamedItem("username");
							Attr password = (Attr) envSettings.getAttributes().getNamedItem("password");

							setUserName(username.getValue());
							setPassword(password.getValue());

						}
					}

				}
			}
		}
	}

	public static void loadMethodePath(Document doc) {

		NodeList methodePath = doc.getElementsByTagName("methode");

		for (int i = 0; i < methodePath.getLength(); i++) {

			Node settings = methodePath.item(i);

			if (settings.hasAttributes()) {

				Attr path = (Attr) settings.getAttributes().getNamedItem("path");

				setMethodePath(path.getValue());

			}
		}
	}

	public static void loadScreenshotLocationPath() {
		setScreenshotLocationPath();
	}

	public static void loadS3Path(Document doc) {

		String paths[] = { "s3URL", "s3Bucket", "s3ApiKey", "s3ApiSecret", "s3MediaPath", "s3ReportPath", "articleFeed",
				"slotFeed", "bookFeed", "sectionFeed", "editionFeed", "imageFeed", "articleMetadataFeed",
				"slotMetadataFeed", "imageMetadataFeed", "imagePositionalFeed" };

		for (int x = 0; x < paths.length; x++) {

			NodeList methodePath = doc.getElementsByTagName(paths[x]);

			for (int i = 0; i < methodePath.getLength(); i++) {

				Node settings = methodePath.item(i);

				if (settings.hasAttributes()) {

					Attr path = (Attr) settings.getAttributes().getNamedItem("path");

					if (paths[x] == "s3URL") {
						setS3URL(path.getValue());
					} else if (paths[x] == "articleFeed") {
						setArticleFeed(path.getValue());
					} else if (paths[x] == "slotFeed") {
						setSlotFeed(path.getValue());
					} else if (paths[x] == "bookFeed") {
						setBookFeed(path.getValue());
					} else if (paths[x] == "sectionFeed") {
						setSectionFeed(path.getValue());
					} else if (paths[x] == "editionFeed") {
						setEditionFeed(path.getValue());
					} else if (paths[x] == "imageFeed") {
						setImageFeed(path.getValue());
					} else if (paths[x] == "articleMetadataFeed") {
						setArticleMetadataFeed(path.getValue());
					} else if (paths[x] == "slotMetadataFeed") {
						setSlotMetadataFeed(path.getValue());
					} else if (paths[x] == "imageMetadataFeed") {
						setImageMetadataFeed(path.getValue());
					} else if (paths[x] == "imagePositionalFeed") {
						setImagePositionalFeed(path.getValue());
					}
				} else {
					if (paths[x] == "s3Bucket") {
						setS3Bucket(settings.getTextContent());
					} else if (paths[x] == "s3ApiKey") {
						setS3ApiKey(settings.getTextContent());
					} else if (paths[x] == "s3ApiSecret") {
						setS3ApiSecret(settings.getTextContent());
					} else if (paths[x] == "s3MediaPath") {
						setS3MediaPath(settings.getTextContent());
					}else if (paths[x] == "s3ReportPath") {
						setS3ReportPath(settings.getTextContent());
					}

				}
			}

		}

	}

}
