/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.io.File;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 *
 * @author Marco
 */
public class AWSUploader {
    private BasicAWSCredentials awsCreds;
    private AmazonS3 s3Client;
    private String bucketName;
    private String folderName;
    
    public AWSUploader() {
        awsCreds = new BasicAWSCredentials("AKIA3XEKIVK5LQEBKTVU", "ShNF1hH7SVMfgZ/kcE1cw+VlvszYcECtVBOjqCL5");
        s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-2").withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	bucketName = "elasticbeanstalk-us-east-2-805596342970";
	folderName = "immagini_strutture";
    }
    
    public String caricaFoto(File FotoDaCaricare) {
        try {
            String fileNameInS3 = FotoDaCaricare.getName();
            
            PutObjectRequest request = new PutObjectRequest(bucketName, folderName + "/" + fileNameInS3, FotoDaCaricare);
            s3Client.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));
            System.out.println("--Uploading file done");
            
            String URL = s3Client.getUrl(bucketName, folderName+"/"+fileNameInS3).toExternalForm();   
            return URL;
            
	} catch (AmazonS3Exception e) {
            e.printStackTrace();
	}
        return null;
    }
    
}
