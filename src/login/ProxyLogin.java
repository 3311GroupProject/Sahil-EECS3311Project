package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;





public class ProxyLogin implements ILogin{
	private static ILogin login;
	String incomingUsername, incomingPassword ;
	static boolean loginStatus=false ;
	static String loginMessage;
	
	ProxyLogin(String username , String password){
		username=this.incomingUsername ;
		password=this.incomingPassword ;
		
		
		loginStatus= doValidate(incomingUsername, incomingPassword,loginMessage);
		
			
		
		// Read user.xml file  and validate username and password // and launch main GUI
		
	}
	
	public boolean doValidate(String username, String password ,String loginMessage) {
		boolean flag=false ;
		
		
		
		Map<String, String> userMap = new HashMap<String, String>(); 
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("userDatabase.xml");
			//doc.getDocumentElement().normalize();
			NodeList userList =doc.getElementsByTagName("crendential");
			System.out.println("this is printing the node elements from the xml");
			for(int i = 0; i < userList.getLength(); i++)
			{
				Node u = userList.item(i);
				if(u.getNodeType()== Node.ELEMENT_NODE) {
					Element credential = (Element) u;
					String id = credential.getAttribute("id");
					NodeList credentialList = credential.getChildNodes();
					
					for(int j=0; j< credentialList.getLength(); j++ )
					{
						Node n =credentialList.item(j);
						if(n.getNodeType()==Node.ELEMENT_NODE) {
							Element uname = (Element) n;
							System.out.println("user " + id + ":" + uname.getTagName() + "=" + uname.getTextContent());
							
							//currently stuck on getting the node elements to a hashmap or map
							//Element k = (Element) n.getFirstChild().getNextSibling();
							//userMap.put(n.getFirstChild().getTextContent(), n.getFirstChild().getNextSibling().getTextContent());
						}
					}
				}
			}
		}
		catch(ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch(SAXException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(userMap.keySet());
		return flag;
		}
		
		
		//-----------Parsing XML file ----------
//	try {	
//		File file =new File("/Users/gurparteetsinghpurbe/Desktop/Document/Studies/YORK STUDIES/3rd Year/Fall 2022/EECS 3311 - Software Design/Project/src/login/userDatabase.xml");
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
//		
//		DocumentBuilder db = dbf.newDocumentBuilder();    
//		Document parseDoc = db.parse(file) ;
//		parseDoc.getDocumentElement().normalize();
//		
//		System.out.println("Root Element" + parseDoc.getDocumentElement().getNodeName());
//		NodeList nodeList= parseDoc.getElementsByTagName("credentials");
//		
//		for(int temp= 0; temp < nodeList.getLength(); temp++ ) {
//			Node node= nodeList.item(temp);
//			
//		}
//		
//		
//		
//		
//		NodeList nodeList= parseDoc.getElementByTagName("credentials") ;
//		
//		
//		
//		
//
//		
//	}
//	catch(Exception e){
//		
//	}


	
		
		
		
		
		
		
		
		//---------------------
		
		
		

	public static void main(String[] args) {
		String un = "hi";
		String pa = "no";
		ILogin test = new ProxyLogin(un, pa);
		test.doValidate(un, pa, pa);
		
	}	
	}
	


	
	
	

