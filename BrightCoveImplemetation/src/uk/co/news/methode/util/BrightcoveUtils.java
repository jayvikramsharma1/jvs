package uk.co.news.methode.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.eidosmedia.wa.util.Base64;

import EMEC.log;
import uk.co.news.methode.dto.AccessTokenData;
import uk.co.news.methode.dto.BrightcoveVideoDatum;
import uk.co.news.methode.dto.BrightcoveVideoSource;
import uk.co.news.methode.dto.BrightcoveVideoSourceData;

public class BrightcoveUtils {
	static Logger logger = Logger.getLogger(BrightcoveUtils.class);

	@SuppressWarnings("unchecked")
	public static List<BrightcoveVideoDatum> getVideos(String token, String cmsUrl, String query, String limitPerPage, String sort, String exclusive)
			throws JsonParseException, JsonMappingException, IOException {
		if (limitPerPage == null || limitPerPage.equalsIgnoreCase(""))
			limitPerPage = "20";
		String qry = null;
		if (query != null && query.equalsIgnoreCase("") != true)
			qry = URLEncoder.encode(query, "UTF-8");
		/*String apiUrl =  ((qry == null) ? ((exclusive!= null ? "q="+exclusive +"&" : "") + "sort="+sort+"&limit=" + limitPerPage + "&offset=0")
				: ("q=\"" + qry + "\"\\s+"+exclusive+"&sort="+sort+"&limit=" + limitPerPage + "&offset=0"));*/
		
		String apiUrl = "?limit="+limitPerPage+"&offset=0&sort="+sort+"&q=";
		if(qry != null)
			apiUrl = apiUrl + URLEncoder.encode("+\""+ URLDecoder.decode(qry, StandardCharsets.UTF_8.toString()) +"\"+-exclusive:\""+exclusive+"\"", StandardCharsets.UTF_8.toString()).replaceAll("%22%2B", "%22+");
		else
			apiUrl = apiUrl + URLEncoder.encode("-exclusive:\""+exclusive+"\"", StandardCharsets.UTF_8.toString());
		
		apiUrl = cmsUrl + apiUrl;
		//apiUrl = cmsUrl + "?" +  URLEncoder.encode(apiUrl, StandardCharsets.UTF_8.toString());
		logger.debug(apiUrl);
		return (List<BrightcoveVideoDatum>) getVideosDataListFromJson(getBrightcoveResponse(token, apiUrl),
				"uk.co.news.methode.dto.BrightcoveVideoDatum");
	}

	public static List<?> getVideosDataListFromJson(String jsonString, String className) {
		// logger.debug(jsonString);
		ObjectMapper mapper = new ObjectMapper();
		List<?> returnList = null;
		try {
			returnList = mapper.readValue(jsonString,
					mapper.getTypeFactory().constructCollectionType(List.class, Class.forName(className)));
		} catch (ClassNotFoundException | IOException e) {
			logger.debug(e.getMessage());
		}
		return returnList;
	}

	public static String getJsonFromList(List<?> list) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(list);
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
		return jsonString;
	}

	@SuppressWarnings("unchecked")
	public static List<BrightcoveVideoSourceData> getVideoSource(List<BrightcoveVideoDatum> brightcoveVideosData,
			String token, String cmsUrl, String flightTimeFlag, String oldIEBrowserFlag) {
		logger.debug("Old IE Browser Flag = " + oldIEBrowserFlag);
		List<BrightcoveVideoSourceData> brightcoveVideoSourceDataList = new ArrayList<BrightcoveVideoSourceData>();
		for (BrightcoveVideoDatum brightcoveVideoDatum : brightcoveVideosData) {
			List<BrightcoveVideoSource> brightcoveVideoSourceList = null;
			BrightcoveVideoSourceData brightcoveVideoSourceData = null;
			Instant now = Instant.now();
			//logger.debug("-----------------------------------------------------------------------------" + flightTimeFlag);
			if (flightTimeFlag.equalsIgnoreCase("ON")) {
				if (brightcoveVideoDatum.getState().equalsIgnoreCase("ACTIVE") && (brightcoveVideoDatum
						.getSchedule() == null
						|| ((brightcoveVideoDatum.getSchedule().getStarts_at() == null
								|| Instant.parse(brightcoveVideoDatum.getSchedule().getStarts_at()).compareTo(now) <= 0)
								&& (brightcoveVideoDatum.getSchedule().getEnds_at() == null
										|| Instant.parse(brightcoveVideoDatum.getSchedule().getEnds_at())
												.compareTo(now) >= 0)))) {
					getVideoSourceImpl(brightcoveVideoDatum, cmsUrl, brightcoveVideoSourceList,
							brightcoveVideoSourceData, token, brightcoveVideoSourceDataList, oldIEBrowserFlag, false);
				} else {
					logger.debug("Searching with filght time flage : ON, Video Id : " + brightcoveVideoDatum.getId() + " is either not active or not in flight time, Status : " + brightcoveVideoDatum.getState());
				}
			} else {
				if (brightcoveVideoDatum.getState().equalsIgnoreCase("ACTIVE")) {
					
					if ((brightcoveVideoDatum
							.getSchedule() == null
							|| ((brightcoveVideoDatum.getSchedule().getStarts_at() == null
									|| Instant.parse(brightcoveVideoDatum.getSchedule().getStarts_at()).compareTo(now) <= 0)
									&& (brightcoveVideoDatum.getSchedule().getEnds_at() == null
											|| Instant.parse(brightcoveVideoDatum.getSchedule().getEnds_at())
													.compareTo(now) >= 0)))) {
						getVideoSourceImpl(brightcoveVideoDatum, cmsUrl, brightcoveVideoSourceList, brightcoveVideoSourceData,
								token, brightcoveVideoSourceDataList, oldIEBrowserFlag, false);
					} else {
						getVideoSourceImpl(brightcoveVideoDatum, cmsUrl, brightcoveVideoSourceList, brightcoveVideoSourceData,
								token, brightcoveVideoSourceDataList, oldIEBrowserFlag, true);
					}
				} else {
					logger.debug("Searching with filght time flage : OFF, Video Id : " + brightcoveVideoDatum.getId() + " is not active");
				}
			}
		}

		return brightcoveVideoSourceDataList;
	}

	public static void getVideoSourceImpl(BrightcoveVideoDatum brightcoveVideoDatum,
			String cmsUrl, List<BrightcoveVideoSource> brightcoveVideoSourceList,
			BrightcoveVideoSourceData brightcoveVideoSourceData, String token,
			List<BrightcoveVideoSourceData> brightcoveVideoSourceDataList, String oldIEBrowserFlag, Boolean embargoedFlag) {
		try {
			//if(oldIEBrowserFlag.equalsIgnoreCase("false")) {
				String apiUrl = cmsUrl + "/" + brightcoveVideoDatum.getId() + "/sources";
				brightcoveVideoSourceList = (List<BrightcoveVideoSource>) getVideosDataListFromJson(getBrightcoveResponse(token, apiUrl), "uk.co.news.methode.dto.BrightcoveVideoSource");
			//}
			brightcoveVideoSourceData = new BrightcoveVideoSourceData();
			brightcoveVideoSourceData.setEmbargoedFlag(embargoedFlag);
			brightcoveVideoSourceData.setId(brightcoveVideoDatum.getId());
			brightcoveVideoSourceData.setAccountId(brightcoveVideoDatum.getAccountId());
			if (brightcoveVideoDatum.getDuration() != null)
				brightcoveVideoSourceData.setDuration(brightcoveVideoDatum.getDuration().longValue());
			else
				brightcoveVideoSourceData.setDuration(0l);
			brightcoveVideoSourceData.setDescription(brightcoveVideoDatum.getDescription());
			brightcoveVideoSourceData.setName(brightcoveVideoDatum.getName());
			if (brightcoveVideoSourceList != null && brightcoveVideoSourceList.size() > 0) {
				brightcoveVideoSourceData.setVideoSrc(brightcoveVideoSourceList.get(1).getSrc());
				brightcoveVideoSourceData.setCodec(brightcoveVideoSourceList.get(1).getCodec());
				brightcoveVideoSourceData.setContainer(brightcoveVideoSourceList.get(1).getContainer());
			} else {
				brightcoveVideoSourceData.setVideoSrc("null");
				brightcoveVideoSourceData.setCodec("null");
				brightcoveVideoSourceData.setContainer("null");
			}
			if (brightcoveVideoDatum.getImages().getPoster().getSources() != null
					&& brightcoveVideoDatum.getImages().getPoster().getSources().size() > 0) {
				brightcoveVideoSourceData
						.setImageSrc(brightcoveVideoDatum.getImages().getPoster().getSources().get(0).getSrc());
				brightcoveVideoSourceData.setWidth(
						brightcoveVideoDatum.getImages().getPoster().getSources().get(0).getWidth().toString());
				brightcoveVideoSourceData.setHeight(
						brightcoveVideoDatum.getImages().getPoster().getSources().get(0).getHeight().toString());
			} else {
				brightcoveVideoSourceData.setImageSrc(brightcoveVideoDatum.getImages().getPoster().getSrc());
			}
			brightcoveVideoSourceData.setEmoFileName(UUID.randomUUID().toString());
			brightcoveVideoSourceData.setPaidOnly(
					brightcoveVideoDatum.getCustomFields().getAdditionalProperties().get("paidonly") == null ? null
							: brightcoveVideoDatum.getCustomFields().getAdditionalProperties().get("paidonly")
									.toString());
			if(brightcoveVideoDatum.getSchedule() != null)
				brightcoveVideoSourceData.setSchedules(brightcoveVideoDatum.getSchedule());
			brightcoveVideoSourceDataList.add(brightcoveVideoSourceData);
			/*if((brightcoveVideoDatum != null && brightcoveVideoDatum.getCustomFields() != null) && datam.get(0) != null && datam.get(0).getCustomFields() != null && datam.get(0).getCustomFields().getAdditionalProperties() != null) {
				isPaidChannel = datam.get(0).getCustomFields().getAdditionalProperties().get("paidonly") == null ? "false" : datam.get(0).getCustomFields().getAdditionalProperties().get("paidonly").toString();
			}*/
			if(brightcoveVideoDatum != null && brightcoveVideoDatum.getCustomFields()!= null && brightcoveVideoDatum.getCustomFields().getAdditionalProperties() != null) {
				String competitionId = brightcoveVideoDatum.getCustomFields().getAdditionalProperties().get("competition_id").toString();
				System.out.println("#################################################" + competitionId);
				 brightcoveVideoSourceData.setCompetitionId((competitionId == null ? "" : competitionId));
			}
		} catch (Exception e) {
			brightcoveVideoSourceData.setVideoSrc("");
			logger.debug("## Brightcove Response Error");
			logger.debug(brightcoveVideoDatum);
			logger.debug(brightcoveVideoSourceList);
			logger.debug(e.getMessage());
		}
	}

	public static String getBrightcoveResponse(String token, String apiUrl) {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(apiUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", "Bearer " + token.trim());
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
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static AccessTokenData getApiToken(String apiUrl, String clientId, String clientSecret) {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(apiUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Authorization",
					"Basic " + new String(Base64.encode((clientId + ":" + clientSecret).getBytes())));
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(response.toString(), AccessTokenData.class);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
