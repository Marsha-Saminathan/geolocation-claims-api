package com.ayo.ayoclaimstracker.services;

import com.ayo.ayoclaimstracker.interfaces.services.IFacility;
import com.ayo.ayoclaimstracker.repositories.FacilityRepository;
import com.google.common.base.Objects;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

@Service
public class Facility implements IFacility {

	private final Path root = Paths.get("uploads");
	String connectStr = System.getenv("AZURE_STORAGE_CONNECTION_STRING");
	@Autowired
	private FacilityRepository repository;

	@Override
	public List<com.ayo.ayoclaimstracker.models.Facility> find(String searchString) {
		return (List<com.ayo.ayoclaimstracker.models.Facility>) repository
				.findByCountryLikeIgnoreCaseOrRegionLikeIgnoreCaseOrDistrictLikeIgnoreCaseOrMunicipalityLikeIgnoreCaseOrNameLikeIgnoreCaseOrTypeLikeIgnoreCaseOrOwnershipLikeIgnoreCaseOrderByNameAsc(
						searchString, searchString, searchString, searchString, searchString, searchString,
						searchString);
	}

	@Override
	public void insertFacility(CloudBlobContainer container, com.ayo.ayoclaimstracker.models.Facility facility,
			MultipartFile[] files) {
		try {
			if (facility.getFacilityFee() == null) {
				facility.setFacilityFee((long) 0);
			}
			if (facility.getBurialFee() == null) {
				facility.setBurialFee((long) 0);
			}
			if (facility.getStorageFee() == null) {
				facility.setStorageFee((long) 0);
			}
			if (facility.getEmbalmingFee() == null) {
				facility.setEmbalmingFee((long) 0);
			}
			if (facility.getDeathRegistrationFee() == null) {
				facility.setDeathRegistrationFee((long) 0);
			}
			// Save Facility
			repository.insertFacility(UUID.fromString(facility.getId()), facility.getCountry(), facility.getRegion(),
					facility.getDistrict(), facility.getMunicipality(), facility.getName(), facility.getType(),
					facility.getOwnership(), Double.parseDouble(facility.getLatitude()),
					Double.parseDouble(facility.getLongitude()), facility.getPhoneNumber(), facility.getClaimType(),
					facility.getServices(), facility.getNumberOfBeds(), facility.getConsultationFee(),
					facility.getAdmissionFee(), facility.getAttendant(), facility.getContactNumber(),
					BigInteger.valueOf(facility.getFacilityFee()), BigInteger.valueOf(facility.getBurialFee()),
					BigInteger.valueOf(facility.getStorageFee()), BigInteger.valueOf(facility.getEmbalmingFee()),
					BigInteger.valueOf(facility.getDeathRegistrationFee()), facility.getBurialType(),
					facility.getGovernmentApproved(), facility.getValidated(), facility.getValidationStart(),
					facility.getValidationEnd(), facility.getBlackListed());

			Arrays.asList(files).stream().forEach(file -> {
				// Get a reference to a blob
				CloudBlockBlob blobClient = null;
				InputStream inputStream = null;
				try {
					blobClient = container.getBlockBlobReference(file.getOriginalFilename());
					inputStream = file.getInputStream();
					blobClient.upload(inputStream, file.getSize());
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (StorageException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	@Override
	public void updateFacility(com.ayo.ayoclaimstracker.models.Facility emp) {

	}

	@Override
	public void executeUpdateFacility(com.ayo.ayoclaimstracker.models.Facility emp) {

	}

	@Override
	public void deleteFacility(com.ayo.ayoclaimstracker.models.Facility emp) {

	}

}
