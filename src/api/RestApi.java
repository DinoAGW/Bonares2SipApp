package api;

import java.util.Iterator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestApi {

	public static void main(String[] args) throws Exception {
		JsonNode uploads = getUploads();
		System.out.println(uploads.toPrettyString());
		JsonNode obj = uploads.get(0);
		for (Iterator<String> iterator = obj.fieldNames(); iterator.hasNext();) {
			String fieldName = iterator.next();
			System.out.println(fieldName + " -> " + obj.get(fieldName));
		}
		System.out.println("RestApi Ende");
	}

	private static JsonNode getUploads() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uploadsUrl = "https://longtermarchiving-e.dataservice.zalf.de/api/lza/uploads/";
		ResponseEntity<String> response = restTemplate.getForEntity(uploadsUrl, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(response.getBody());
		return json;
	}
}
