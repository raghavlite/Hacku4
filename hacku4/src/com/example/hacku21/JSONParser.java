package com.example.hacku21;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {

	static InputStream is =null;
	static JSONObject jObj = null;
	static String json = "";
	
	public JSONParser() {
		// TODO Auto-generated constructor stub
	}
	public String getJSONFromUrl(String url) throws ParseException, IOException,IllegalArgumentException {
		try{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			
			
			HttpPost httpPost = new HttpPost(url);
			
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			json=EntityUtils.toString(httpEntity);
			//is = httpEntity.getContent();
			
		}catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		return json;
	}
	
}
