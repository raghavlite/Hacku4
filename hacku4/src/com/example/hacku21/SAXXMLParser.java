package com.example.hacku21;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;



public class SAXXMLParser extends DefaultHandler{


	//public ArrayList<Menus> menuArr;
	StringBuffer sb;
//	Menus mVO = null;
	public String result;
	public String forecasts;
	
	
	public SAXXMLParser() {
		// TODO Auto-generated constructor stub
		//menuArr=new ArrayList<Menus>();
	}

	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		
		result="";
		
		forecasts="";
		
		
		
		
	}
	
	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		sb=new StringBuffer();
		
		
		
		Log.i("local", localName);
		
		
		
		if(localName.equals("location")) {
        	//mVO= new Menus();
 
			result=result+attributes.getValue("city")+"\n";
			
			result=result+attributes.getValue("region")+"  ";
			result=result+attributes.getValue("country");
			
		}
		else if(localName.equals("units"))
		{//result=result+"TEMPERATURE"+attributes.getValue("temperature")+" "+attributes.getValue("");
			
			
			
		}
		else if(localName.equals("wind"))
		{
			
			result=result+"\n"+"Temperature "+attributes.getValue("chill")+",Wind speed "+attributes.getValue("speed")+"km/h";
			
			
		}
		else if(localName.equals("atmosphere"))
		{
			result=result+",Humidity "+attributes.getValue("humidity")+",Visibility "+attributes.getValue("visibility")+",Pressure "+attributes.getValue("pressure")+"mb";
			
			
		}
		
        
		else if(localName.equals("forecast"))
		{
			
			forecasts=forecasts+"DAY "+attributes.getValue("day")+
					",Date "+attributes.getValue("date")+
					",Min Temp "+attributes.getValue("low")+
					",Max Temp "+attributes.getValue("high")+
					",Weather "+attributes.getValue("text")+"\n";
			
			
		}
		else if(localName.equals(""))
		{
			
		}
		else if(localName.equals(""))
		{
			
		}
		else if(localName.equals(""))
		{
			
		}
		
		
	}

	
	
	
	
	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
//	        for (int i=start; i<start+length; i++) {
//	        	switch (ch[i]) {
//	        	 case '\\':
//	     //   		 sb.append(ch[i]);
//	        			break;
//	        		    case '"':
//	       // 		    	sb.append(ch[i]);
//	        			break;
//	        		    case '\n':
//	        //		    	sb.append(ch[i]);
//	        			break;
//	        		    case '\r':
//	        	//	    	sb.append(ch[i]);
//	        			break;
//	        		    case '\t':
//	        		//    	sb.append(ch[i]);
//	        			break;
//	        		    default:
//	        		  //  	sb.append(ch[i]);
//	        			break;
//				} 
//	        }
	}

	
	
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
//		
//		if (localName.equalsIgnoreCase("id")) {
//        	mVO.KEY_ID=sb.toString().trim();
//		}
//		if (localName.equalsIgnoreCase("name")) {
//        	mVO.KEY_NAME=sb.toString().trim();
//		}
//		if (localName.equalsIgnoreCase("cost")) {
//        	mVO.KEY_COST=sb.toString().trim();
//		}
//		if (localName.equalsIgnoreCase("description")) {
//			mVO.KEY_DESC=sb.toString().trim();
//		}
//		if (localName.equalsIgnoreCase("item")) {
//        	menuArr.add(mVO);
//		}
	
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

