package com.chen.minio;

import io.minio.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@Service
public class MinioFileService {



    private final MinioClient minioClient;

    @Value("${minio.bucket}")
    private String bucket;

    public MinioFileService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    // 上传文件
    public String uploadFile(MultipartFile file, String userId) throws Exception {
        String objectName = userId + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try (InputStream in = file.getInputStream()) {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucket)
                            .object(objectName)
                            .stream(in, file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
        }
        return objectName;
    }

    // 下载文件
    public InputStream downloadFile(String objectName) throws Exception {
        return minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucket)
                        .object(objectName)
                        .build()
        );
    }

    // 生成预览 URL（限时有效）
    public String getPreviewUrl(String objectName, int expireMinutes) throws Exception {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucket)
                        .object(objectName)
                        .method(Method.GET)
                        .expiry(expireMinutes, TimeUnit.MINUTES)
                        .build()
        );
    }
    // 删除文件 ✅
    public void deleteFile(String objectName) throws Exception {
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(bucket)
                        .object(objectName)
                        .build()
        );
    }
}
