package com.ayo.ayoclaimstracker.repositories;

import com.ayo.ayoclaimstracker.models.TowerLocation;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

public interface TowerLocationRepository  extends CrudRepository<TowerLocation, UUID> {

    Iterable<TowerLocation> findByBaseStationLikeIgnoreCaseOrTowerNumberLikeIgnoreCaseOrSiteNameLikeIgnoreCaseOrDistrictLikeIgnoreCaseOrRegionLikeIgnoreCaseOrMunicipalityLikeIgnoreCase(String base_station, String tower_number, String site_name, String district, String region, String municipality);


    @Query(value="SELECT * FROM claimtracker.tower_locations as tl " +
            "WHERE " +
            "ST_Distance(" +
            " ST_Transform(ST_SetSRID( ST_Point(tl.latitude, tl.longitude), 4326), 4326)\\:\\:geography ," +
            " ST_Transform(ST_SetSRID( ST_Point(?1, ?2), 4326), 4326)\\:\\:geography)/1000 < ?3", nativeQuery = true)
    public List<TowerLocation> findAllTowerLocationsInRange(double latitude, double longitude, double distance);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO claimtracker.tower_locations("
			+ "id, base_station, tower_number, site_name, district, region, municipality, latitude, longitude)"
			+ " VALUES (:id, :base_station, :tower_number, :site_name, :district, :region, :municipality, :latitude, :longitude)", nativeQuery = true)
	public void insertTowerLocation(UUID id, String base_station, String tower_number, String site_name, String district,
			String region, String municipality, double latitude, double longitude);
}

