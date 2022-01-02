package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name,String language,String address)
	{// these parameters comes from feature file--> stepdefiniton
		
		AddPlace p= new AddPlace();
		p.setAccuracy(50);
		p.setName(name);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 999 898 3937");
		p.setWebsite("http://google.com");
		
		List<String> myList= new ArrayList();
		myList.add("shoe park");
		myList.add("shop");
		myList.add("cnhge in mygitx master");
		p.setTypes(myList);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		return p;
		
	}
	public String deletePlacePayload(String placid)
	{
		return "{\r\n    \r\n    \"place_id\": \""+placid+"\"\r\n}";
	}

}
