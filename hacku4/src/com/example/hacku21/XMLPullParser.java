package com.example.hacku21;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;



public class XMLPullParser {
	
	//public  ArrayList<Menus> menuArr;
	protected XmlPullParser xmlpullparser;
	String TAG="XmlPullParsing";
	//Menus mVO = null;
	StringBuffer sb;
	public String result;
	String currentelement;
	boolean wanted=false;
	
	public XMLPullParser(InputStream is) {

		XmlPullParserFactory factory = null;
		try {
			factory = XmlPullParserFactory.newInstance();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory.setNamespaceAware(true);
		try {
			xmlpullparser = factory.newPullParser();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			xmlpullparser.setInput(is, "UTF-8");
			processDocument(xmlpullparser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}


	
	
    public void processDocument(XmlPullParser xpp)
            throws XmlPullParserException, IOException
        {
            int eventType = xpp.getEventType();
            do {
                if(eventType == XmlPullParser.START_DOCUMENT) {
                    System.out.println("Start document");
                } else if(eventType == XmlPullParser.END_DOCUMENT) {
                    System.out.println("End document");
                } else if(eventType == XmlPullParser.START_TAG) {
                    processStartElement(xpp);
                } else if(eventType == XmlPullParser.END_TAG) {
                    processEndElement(xpp);
                } else if(eventType == XmlPullParser.TEXT) {
                    processText(xpp);
                }
                eventType = xpp.next();
            } while (eventType != XmlPullParser.END_DOCUMENT);
        }


        public void processStartElement (XmlPullParser xpp)
        {
            String name = xpp.getName();
            
            
        	sb= new StringBuffer();

//            if ("".equals (uri)) {
                System.out.println("Start element: " + name);
                if(name.equals("description"))
                {
                	wanted=true;
                }
                else if(name.equals("yweather:location"))
                {
                	wanted=true;	
                
                }
                else if(name.equals("yweather:units"))
                {
                	wanted=true;
                    xpp.getAttributeValue(0);
                    
                    sb.append(xpp.getAttributeValue(0));
                   result=result+"temperature="+sb; 
                }
                else if(name.equals("yweather:atmosphere"))
                {
                	wanted=true;
                }
                
                else if(name.equals("yweather:astronomy"))
                {
                	wanted=true;
                	
                }
                
                
               // xpp.getAttributeValue(null, "id");
//            } else {
//                System.out.println("Start element: {" + uri + "}" + name);
//            }
        }


        
        
        
        
        
        
        
        
        
        int holderForStartAndLength[] = new int[4];

        public void processText (XmlPullParser xpp) throws XmlPullParserException
        {
            char ch[] = xpp.getTextCharacters(holderForStartAndLength);
            int start = holderForStartAndLength[0];
            int length = holderForStartAndLength[1];
            System.out.print("Characters:    \"");
	        for (int i=start; (i<start+length)&&(wanted==true); i++) {
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
            System.out.print("\"\n");
        }
        
        
        
        
        
        
        
        
        public void processEndElement (XmlPullParser xpp)
        {
            String name = xpp.getName();
          //  String uri = xpp.getNamespace();
//            if ("".equals (uri)){
            	System.out.println("End element: " + name);
//           
            	
            	
            	
            	
            	
            	
            	
            	
//              if ("".equals (uri)) {
//                System.out.println("Start element: " + name);
//                if(name.equals("description"))
//                {
//                	wanted=false;
//                
//                   result=result+"\n"+sb.toString().trim();
//                   
//                }
//                else if(name.equals("yweather:location"))
//                {
//                	
//                	wanted=false;
//                    
//                    result=result+"\n"+sb.toString().trim();
//                }
//                else if(name.equals("yweather:units"))
//                {
//                	wanted=false;
//                    
//                    result=result+"\n"+sb.toString().trim();
//                }
//                else if(name.equals("yweather:atmosphere"))
//                {
//                	wanted=false;
//                    
//                    result=result+"\n"+sb.toString().trim();
//                }
//                
//                else if(name.equals("yweather:astronomy"))
//                {
//                	wanted=false;
//                    
//                    result=result+"\n"+sb.toString().trim();
//                	
//                }
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	//if(name.equals("id")){
//                	mVO.KEY_ID=sb.toString().trim();
//                }
//                if(name.equals("name")){
//                	mVO.KEY_NAME=sb.toString().trim();
//                }
//                if(name.equals("cost")){
//                	mVO.KEY_COST=sb.toString().trim();
//                }
//                if(name.equals("description")){
//                	mVO.KEY_DESC=sb.toString().trim();
//                }
//                if(name.equals("item")){
//                	menuArr.add(mVO);
//                }
// //           }
//                
//            else
//                System.out.println("End element:   {" + uri + "}" + name);
        }

       


}
