package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(){
		AddPlace p=new AddPlace();
		p.setAccuracy("50");
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline House");
	    List<String> mylist=new ArrayList<String>();
	    mylist.add("Shoe park");
	    mylist.add("shop");
	    p.setTypes(mylist);
	    Location l=new Location();
	    l.setLat(-38.383);
	    l.setLng(33.427);
	    p.setLocation(l);
	    
	    return p;
	}
}
