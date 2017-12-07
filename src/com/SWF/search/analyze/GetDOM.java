package com.SWF.search.analyze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

public class GetDOM {
	
	public String dom2String(String url) throws Exception{
	
		HttpPost http = new HttpPost(url);
		
		HttpClient httpClient = HttpClientBuilder.create().build();
	
		HttpResponse response = httpClient.execute(http);
	
		HttpEntity entity = response.getEntity();
	
		ContentType contentType = ContentType.getOrDefault(entity);
	
		Charset charset = contentType.getCharset();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
	
		StringBuffer sb = new StringBuffer();
	
		String line = "";
	
		while((line=br.readLine()) != null){
	
			sb.append(line+"\n");
	
		}
		
		return sb.toString();
	}
}
