/*
package com.yundong.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.List;


*/
/**
 * @Author gfc
 * @Date Created in 2018/7/27 11:45
 * 基于阿里云的oss      对象存储
 *//*


public class OSSUtil {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    public OSSUtil(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
    }


*/
/**
     * 创建客户端
     *
     * @return
     *//*


    private OSS createClient() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }


*/
/**
     * 获取文件列表
     *
     * @return
     *//*


    public List<OSSObjectSummary> fileList() {
        OSS client = createClient();
        // 设置最大个数。
        final int maxKeys = 200;
        // 列举文件。
        ObjectListing objectListing = client.listObjects(new ListObjectsRequest(bucketName).withMaxKeys(maxKeys));
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        return sums;
    }


*/
/**
     * 上传文件
     *//*


    public String fileUp(String filename, byte[] data) {
        OSS client = createClient();
        client.putObject(bucketName, filename, new ByteArrayInputStream(data));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return client.generatePresignedUrl(bucketName, filename, calendar.getTime()).toString();
    }


*/
/**
     * 删除文件
     *//*


    public void delFile(String key) {
        OSS client = createClient();
        client.deleteObject(bucketName, key);
        client.shutdown();
    }


*/
/**
     * 删除文件 多个文件
     *//*


    public void delFiles(List<String> keys) {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 删除文件。
        DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(keys));
        List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
        // 关闭OSSClient。
        ossClient.shutdown();
    }


*/
/**
     * 验证是否存在
     *//*


    public boolean isHave(String objName) {
        OSS client = createClient();
        return client.doesObjectExist(bucketName, objName);
    }


*/
/**
     * 创建文件夹
     *//*


    public void createDir(String dirName) {
        if (!isHave(dirName)) {
            OSS client = createClient();
            client.putObject(bucketName, dirName, new ByteArrayInputStream(new byte[0]));
            client.shutdown();
        }
    }
}
*/
