package resources;

public class ConstantClass {
	
	final String addPlaceAPI = "/maps/api/place/add/json";
	final String getPlaceAPI = "/maps/api/place/get/json";
	final String deletePlaceAPI = "/maps/api/place/delete/json";
	
	public String getAddPlaceAPI() {
		return addPlaceAPI;
	}
	
	public String getGetPlaceAPI() {
		return getPlaceAPI;
	}
	
	public String getDeletePlaceAPI() {
		return deletePlaceAPI;
	}
	

}
