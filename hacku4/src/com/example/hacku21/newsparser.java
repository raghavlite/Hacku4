package com.example.hacku21;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class newsparser extends DefaultHandler {

	StringBuffer sb;
	public String news;
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		
		
		
		
		
		
	}
	
	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);

		
		
		
		Log.i("local", localName);
		
		
		sb=new StringBuffer();
		
	}

	
	
	
	
	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
	        for (int i=start; i<start+length; i++) {
	        	switch (ch[i]) {
	        	 case '\\':
	        		 sb.append(ch[i]);
	        			break;
	        		    case '"':
	        		    	sb.append(ch[i]);
	        			break;
	        		    case '\n':
	        		    	sb.append(ch[i]);
	        			break;
	        		    case '\r':
	        		    	sb.append(ch[i]);
	        			break;
	        		    case '\t':
	        		    	sb.append(ch[i]);
	        			break;
	        		    default:
	        		    	sb.append(ch[i]);
	        			break;
				} 
	        }
	}

	
	
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		
		if (localName.equalsIgnoreCase("title")) {
      
			news=news+sb.toString()+"\n";
			
		}
	
	}
	
	
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	
	@Override
	public void error(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub
		super.error(e);
	}






	
	
	
}
