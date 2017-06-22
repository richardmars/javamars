package io.github.richardmars.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {
	private static HttpClient httpClient = HttpClientBuilder.create().build();
	private static String url = "http://localhost:8080/httpclientdemo";
	
	public static void main(String[] args) throws IOException {
		
		HttpGet get = new HttpGet(url);

		// execute request
		HttpResponse response = httpClient.execute(get);

		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		System.out.println("Response Content: " + EntityUtils.toString(response.getEntity()));
		
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		BasicNameValuePair nv = new BasicNameValuePair("name", "value");
		postParams.add(nv);
		post.setEntity(new UrlEncodedFormEntity(postParams));
		// execute request
		response = httpClient.execute(post);

		responseCode = response.getStatusLine().getStatusCode();

		System.out.println("Sending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + postParams);
		System.out.println("Response Code : " + responseCode);
		System.out.println("Response Content: " + EntityUtils.toString(response.getEntity()));
	}
}
