package com.chen.controller;

import com.chen.minio.MinioFileService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
@RestController
@RequestMapping("/files")
public class FileController {

    private final MinioFileService fileService;

    public FileController(MinioFileService fileService) {
        this.fileService = fileService;
    }

    // 上传文件
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file,
                         @RequestParam String userId) throws Exception {
        return fileService.uploadFile(file, userId);
    }

    // 下载文件
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam String objectName,
                                           @RequestParam String userId) throws Exception {
        // 权限检查
        /*if (!permissionService.hasAccess(userId, objectName)) {
            return ResponseEntity.status(403).build();
        }*/

        try (InputStream in = fileService.downloadFile(objectName)) {
            byte[] data = IOUtils.toByteArray(in);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + objectName + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(data);
        }
    }

    // 生成预览链接
    @GetMapping("/preview")
    public String preview(@RequestParam String objectName,
                          @RequestParam String userId) throws Exception {
        /*if (!permissionService.hasAccess(userId, objectName)) {
            throw new RuntimeException("无权限预览");
        }*/
        return fileService.getPreviewUrl(objectName, 10); // 有效期 10 分钟
    }
}
