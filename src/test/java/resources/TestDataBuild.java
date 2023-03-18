package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceLocationPojoClass;
import pojo.AddPlaceRequestPojoClass;
import pojo.DeletePlacePayloadPojoClass;

public class TestDataBuild {
	
	public AddPlaceRequestPojoClass addPlacePayload(String name, String language, String address) {
		
		AddPlaceRequestPojoClass p = new AddPlaceRequestPojoClass();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setName(name);
		p.setPhone_number("9988776655");
		p.setWebsite("http://google.com");

		List<String> myList = new ArrayList<String>();
		myList.add("Show park");
		myList.add("shop");
		p.setTypes(myList);

		AddPlaceLocationPojoClass l = new AddPlaceLocationPojoClass();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l);
		
		return p;

	}
	
	public DeletePlacePayloadPojoClass deletePlacePayload(String place_id) {
		DeletePlacePayloadPojoClass d = new DeletePlacePayloadPojoClass();
		d.setPlace_id(place_id);
		return d;
	}

}
