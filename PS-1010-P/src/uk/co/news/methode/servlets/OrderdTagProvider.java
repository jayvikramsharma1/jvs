package uk.co.news.methode.servlets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import uk.co.news.methode.json.dto.ResponsePojo;
import uk.co.news.methode.json.dto.Tags;
import uk.co.news.methode.json.dto.TagsData;

/**
 * Servlet implementation class OrderdTagProvider
 */
@WebServlet("/OrderdTagProvider")
public class OrderdTagProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(OrderdTagProvider.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderdTagProvider() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		//System.out.println(request.getParameterMap());
		String data = getBody(request);//request.getParameterNames().nextElement(); //getPostData(request);//request.getParameter("data");
		logger.debug(data);
		ObjectMapper mapper = new ObjectMapper();
		//System.out.println(getBody(request));
		response.getWriter().append(mapper.writeValueAsString(getTagsWithSortedScore(data, request)));
	}
	
	public static String getBody(HttpServletRequest request) throws IOException {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static ResponsePojo getTagsWithScore(String apiUrl, String data) throws IOException {
		HttpURLConnection connection = null;
		ResponsePojo resPojo  = new ResponsePojo();
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
			resPojo.setResponseCode(connection.getResponseCode());
			resPojo.setResponseMessage(connection.getResponseMessage());
			resPojo.setData(response.toString());
			return resPojo;

		} catch (Exception e) {
			//e.printStackTrace();
			logger.debug(connection.getResponseCode());
			logger.debug(connection.getResponseMessage());
			resPojo.setResponseCode(connection.getResponseCode());
			resPojo.setResponseMessage(connection.getResponseMessage());
			return resPojo; //"[]";
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	public static ResponsePojo getTagsWithScore(String data, HttpServletRequest request) throws FileNotFoundException, IOException {
		//Properties configProperties = new Properties();
		ServletContext context = request.getServletContext();
		String taggingEndPointUrl = context.getInitParameter("tag-endpoint");
		//configProperties.load(request.getServletContext().getResourceAsStream("/WEB-INF/config/config.properties"));
		logger.debug(taggingEndPointUrl);
		return getTagsWithScore(taggingEndPointUrl, data);
	}
	
	public static TagsData getTagsWithSortedScore(String data, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		TagsData tData = null;
		ResponsePojo res = getTagsWithScore(data, request);
		try {
			logger.debug(res.getResponseCode());
			logger.debug(res.getResponseMessage());
			if (res.getResponseCode() == 200) {
				ObjectMapper mapper = new ObjectMapper();
				tData = mapper.readValue(res.getData(), TagsData.class);
				tData.setResponseCode(res.getResponseCode());
				tData.setResponseMessage(res.getResponseMessage());
				logger.debug(tData);
				Collections.sort(tData.getTags(), new Comparator<Tags>() {

					@Override
					public int compare(Tags t1, Tags t2) {
						if (t1.getScore() > t2.getScore())
							return -1;
						else if (t1.getScore() < t2.getScore())
							return 1;
						else
							return 0;
					}

				});
				return tData;
			} else {
				tData = new TagsData();
				tData.setResponseCode(res.getResponseCode());
				tData.setResponseMessage(res.getResponseMessage());
				return tData;
			}

		} catch (Exception e) {
			logger.error(e);
			return tData;
		}
	}

}
