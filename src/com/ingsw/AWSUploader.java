/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void getFotoDaURI(String URIFoto) {
        try {
            URI fileToBeDownloaded = new URI(URIFoto);
            AmazonS3URI s3URI = new AmazonS3URI(fileToBeDownloaded);
            S3Object s3Object = s3Client.getObject(s3URI.getBucket(), s3URI.getKey());
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(AWSUploader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}