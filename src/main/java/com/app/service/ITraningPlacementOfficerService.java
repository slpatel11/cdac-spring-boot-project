package com.app.service;

import com.app.pojos.TraningPlacementOfficer;

public interface ITraningPlacementOfficerService  {
	public TraningPlacementOfficer getTraningPlacementOfficerDetails(String EmailId);
	public TraningPlacementOfficer addTraningPlacementOfficer(TraningPlacementOfficer p);
}
