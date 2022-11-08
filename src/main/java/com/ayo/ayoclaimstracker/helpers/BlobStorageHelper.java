package com.ayo.ayoclaimstracker.helpers;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

public class BlobStorageHelper {

    String connectStr = System.getenv("AZURE_STORAGE_CONNECTION_STRING");

    public CloudBlobContainer GetContainer(String containerName) {

        // Parse the connection string and create a blob client to interact with Blob storage
        CloudStorageAccount storageAccount = null;
        CloudBlobContainer container = null;
        try {
            storageAccount = CloudStorageAccount.parse(connectStr);
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
            container = blobClient.getContainerReference(containerName);
            container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (StorageException e) {
            e.printStackTrace();
        }
        return container;
    }

}
