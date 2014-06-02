package com.example.hacku21;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import android.util.Log;

public class XMLParser {

	public XMLParser() {
		// TODO Auto-generated constructor stub
	}
	public String getXmlFromUrl(String url) {
		String xml = null;
		try{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse httpResponse = httpClient.execute(httpget);
			HttpEntity httpEntity = httpResponse.getEntity();
			xml = EntityUtils.toString(httpEntity);
			
		}
		catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (ClientProtocolException  e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return xml;
		
	}
	public Document getDomElement(String xml) {
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is);
		} catch (ParserConfigurationException e) {
			// TODO: handle exception
			Log.e("Error: ", e.getMessage());
			return null;
			
		}
		catch (SAXException e) {
			// TODO: handle exception
			Log.e("Error: ", e.getMessage());
			return null;
			
		}
		catch (IOException e) {
			// TODO: handle exception
			Log.e("Error: ", e.getMessage());
			return null;
		}
		return doc;
	}
	public final String getElementValue(Node elem)
	{
		Node child;
		if ( elem != null) {
			if (elem.hasChildNodes()) {
				for (child = elem.getFirstChild(); child != null; child = child.getNextSibling()) {
					if (child.getNodeType() == Node.TEXT_NODE) {
						return child.getLocalName();
					}
				}
			}
			
		}
		return "";
		
	}
	
	public String getValue(Element e, String str) {
		NodeList nlList = e.getElementsByTagName(str).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
		
	}
}
