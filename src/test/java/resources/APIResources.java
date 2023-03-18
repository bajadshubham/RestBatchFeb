package resources;

// enum is a special class in java which has collection of constants and method
// we have to mention different method comma seperated

public enum APIResources {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resources; // resources = addPlaceAPI
	
	APIResources(String resources){ // resources = addPlaceAPI
		this.resources = resources; // 
	}
	
	public String getResources() {
		return resources;
	}
	

}
