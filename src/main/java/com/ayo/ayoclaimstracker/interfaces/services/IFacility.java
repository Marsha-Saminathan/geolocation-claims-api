package com.ayo.ayoclaimstracker.interfaces.services;

import com.ayo.ayoclaimstracker.models.Facility;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFacility {

	List<Facility> find(String searchString);

	void insertFacility(CloudBlobContainer container, Facility facility, MultipartFile[] files);

	void updateFacility(Facility emp);

	void executeUpdateFacility(Facility emp);

	void deleteFacility(Facility emp);

}
