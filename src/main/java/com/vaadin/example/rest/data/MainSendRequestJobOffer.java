package com.vaadin.example.rest.data;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class MainSendRequestJobOffer {
	
	@SuppressWarnings("deprecation")
	public String send_job_offer(){
		HttpClient httpClient = new DefaultHttpClient();

		try {
		    HttpPost request = new HttpPost("http://localhost:3000");
		    StringEntity params =new StringEntity("details={\"name\":\"myname\",\"description\":\"descripcion prueba\",\"available_vacans\":\"14\"}");
		    request.addHeader("content-type", "application/json");
		    request.addHeader("Accept","application/json");
		    request.setEntity(params);
		    HttpResponse response = httpClient.execute(request);

		   return("se enviaron los datos con éxito " + response);
		}catch (Exception ex) {
			return("se enviaron los datos sin éxito");
		} finally {
		    httpClient.getConnectionManager().shutdown();
		}
		
	}
}
