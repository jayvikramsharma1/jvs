package uk.co.news.methode.gapi.connector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import uk.co.news.methode.json.mapper.Tags;
import uk.co.news.methode.json.mapper.TagsData;

public class ApiConnection {
	public static String getTagsWithScore(String apiUrl, String data) throws IOException {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(apiUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.getOutputStream().write(data.getBytes());
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {
			//e.printStackTrace();
			return String.valueOf(connection.getResponseCode());
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	public static String getTagsWithScore(String data) throws FileNotFoundException, IOException {
		Properties configProperties = new Properties();
		configProperties.load(new FileReader("config.properties"));
		return getTagsWithScore(configProperties.getProperty("api.url"), data);
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String data = "{\"text\":\"This is a bunch of text for the article. It could be written in Methode or wherever. I'm not too bothered. The piece of text that is written should have a decent number of words in the text (I'm not exactly sure what that should be) but I'll sort that out later\", \"title\":\"This is a title for my article\"}";
		System.out.println(getTagsWithSortedScore(data));
	}
	public static TagsData getTagsWithSortedScore(String data) throws JsonParseException, JsonMappingException, IOException {
		String jsonData = getTagsWithScore(data);
		ObjectMapper mapper = new ObjectMapper();
		TagsData tData = mapper.readValue(jsonData, TagsData.class);
		System.out.println(tData);
		Collections.sort(tData.getTags(), new Comparator<Tags>() {

			@Override
			public int compare(Tags t1, Tags t2) {
				if(t1.getScore() > t2.getScore())
					return -1;
				else if(t1.getScore() < t2.getScore())
					return 1;
				else
					return 0;
			}
			
		});
		return tData;
	}
}
