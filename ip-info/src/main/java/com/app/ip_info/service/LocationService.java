package com.app.ip_info.service;


import com.app.ip_info.entity.Location;

import java.util.List;

public interface LocationService {

    public List<Location> getAllLocations();

    public Location getLocationById(Long id);

    public Location saveLocation(Location location);

    public void deleteLocation(Long id);
}
