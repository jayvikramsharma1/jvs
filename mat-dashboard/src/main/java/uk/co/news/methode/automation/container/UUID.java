package uk.co.news.methode.automation.container;

public class UUID {
	
	private static String editionUUID = "";
	private static String bookUUID = "";
	private static String sectionUUID = "";
	private static String slotUUID = "";
	private static String articleUUID = "";
	private static String imageUUID = "";
	private static String articleMetadataUUID = "";
	private static String slotMetadataUUID = "";
	private static String imageMetadataUUID = "";
	private static String imagePositionalUUID = "";

	public static String getEditionUUID() {
		return editionUUID;
	}

	public static void setEditionUUID(String editionUUID) {
		UUID.editionUUID = editionUUID;
	}

	public static String getBookUUID() {
		return bookUUID;
	}

	public static void setBookUUID(String bookUUID) {
		UUID.bookUUID = bookUUID;
	}

	public static String getSectionUUID() {
		return sectionUUID;
	}

	public static void setSectionUUID(String sectionUUID) {
		UUID.sectionUUID = sectionUUID;
	}

	public static String getSlotUUID() {
		return slotUUID;
	}

	public static void setSlotUUID(String slotUUID) {
		UUID.slotUUID = slotUUID;
	}

	public static String getArticleUUID() {
		return articleUUID;
	}

	public static void setArticleUUID(String articleUUID) {
		UUID.articleUUID = articleUUID;
	}

	public static String getImageUUID() {
		return imageUUID;
	}

	public static void setImageUUID(String imageUUID) {
		UUID.imageUUID = imageUUID;
	}
	
	public static String getArticleMetadataUUID() {
		return articleMetadataUUID;
	}

	public static void setArtilceMetadataUUID(String articleMetadataUUID) {
		UUID.articleMetadataUUID = articleMetadataUUID;
	}
	
	public static String getSlotMetadataUUID() {
		return slotMetadataUUID;
	}
	
	public static void setSlotMetadataUUID(String slotMetadataUUID) {
		UUID.slotMetadataUUID = slotMetadataUUID;
	}
	public static String getImageMetadataUUID() {
		return imageMetadataUUID;
	}
	
	public static void setImageMetadataUUID(String imageMetadataUUID) {
		UUID.imageMetadataUUID = imageMetadataUUID;
	}
	
	public static String getImagePositionalUUID() {
		return imagePositionalUUID;
	}
	
	public static void setImagePositionalUUID(String imagePositionalUUID) {
		UUID.imagePositionalUUID = imagePositionalUUID;
	}

}
