package com.kapital.dispute.controller;


import com.kapital.dispute.model.response.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    // get list of disputes API


    @GetMapping("/disputes")
    public BaseResponse<List<DisputeItemResponse>> getDisputes() throws InterruptedException {
        List<DisputeItemResponse> disputeItemResponses = new ArrayList<>();
        disputeItemResponses.add(new DisputeItemResponse("open", List.of(new Dispute(1L, "123", "Dispute 1"), new Dispute(2L, "1234", "Dispute 2"))));
        disputeItemResponses.add(new DisputeItemResponse("resolved", List.of(new Dispute(1L, "123", "Dispute 1"), new Dispute(2L, "1234", "Dispute 2"))));
        disputeItemResponses.add(new DisputeItemResponse("rejected", List.of(new Dispute(1L, "123", "Dispute 1"), new Dispute(2L, "1234", "Dispute 2"))));
        disputeItemResponses.add(new DisputeItemResponse("waiting_for_reply", List.of(new Dispute(1L, "123", "Dispute 1"), new Dispute(2L, "1234", "Dispute 2"))));
        return new BaseResponse<>(disputeItemResponses);
    }

    @GetMapping("/disputes/{disputeId}")
    public BaseResponse<DisputeResponse> getDisputes(@PathVariable Long disputeId) {
        return new BaseResponse<>(new DisputeResponse(5L, "open", "musabir", "Dispute 5", "2024-06-24T17:06:18", "2024-06-24T17:06:18", "Dispute 5 description", null, null, getDisputeAttachmentResponses()));
    }


    @PostMapping("/file")
    public BaseResponse<String> uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println("File uploaded successfully " + file.getSize());
        return new BaseResponse<>("File uploaded successfully");
    }

    @GetMapping("/image/{ss}")
    public ResponseEntity<Resource> getImage(@PathVariable Long ss) throws IOException {
        System.out.println("Image requested");
        MediaType contentType = MediaType.IMAGE_JPEG;
        Resource resource = new UrlResource("https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg");
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
//        InputStream input = new URL("https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg").openStream();
//        return ResponseEntity.ok()
//                .contentType(contentType)
//                .body(new InputStreamResource(input));
//        BufferedImage originalImage = ImageIO.read(imageURL);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ImageIO.write(originalImage, "jpg", baos);
//        byte[] imageInByte = baos.toByteArray();
    }

    private List<DisputeAttachmentResponse> getDisputeAttachmentResponses() {

        List<DisputeAttachmentResponse> attachments1 = new ArrayList<>();
//        attachments1.add(new DisputeAttachmentResponse("https://upperedu.az/image/news/url-nedir-76.jpg", "2024-06-24T17:06:18"));
//        attachments1.add(new DisputeAttachmentResponse("https://www.lifewire.com/thmb/fxbUeZKA7CCXMuHZ2VY-ro_kFLw=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/ScreenShot2020-04-20at10.06.28AM-69855f4797cb4be4bbed72f51dff1ab5.jpg", "2024-06-24T17:06:18"));
//        attachments1.add(new DisputeAttachmentResponse("https://media.kasperskycontenthub.com/wp-content/uploads/sites/103/2019/09/26105755/fish-1.jpg", "2024-06-24T17:06:18"));
//        attachments1.add(new DisputeAttachmentResponse("https://upperedu.az/image/news/url-nedir-76.jpg", "2024-06-24T17:06:18"));
//        attachments1.add(new DisputeAttachmentResponse("https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg", "2024-06-24T17:06:18"));
//        attachments1.add(new DisputeAttachmentResponse("https://h5p.org/sites/default/files/h5p/content/1209180/images/file-6113d5f8845dc.jpeg", "2024-06-24T17:06:18"));
//        attachments1.add(new DisputeAttachmentResponse("https://h5p.org/sites/default/files/h5p/content/1209180/images/file-6113d7c152b3f.jpeg", "2024-06-24T17:06:18"));
//        attachments1.add(new DisputeAttachmentResponse("https://h5p.org/sites/default/files/h5p/content/1209180/images/file-6113d7ca05303.jpeg", "2024-06-24T17:06:18"));
//        attachments1.add(new DisputeAttachmentResponse("https://h5p.org/sites/default/files/h5p/content/1209180/images/file-6113d62c09fab.jpeg", "2024-06-24T17:06:18"));
        return attachments1;
    }


}
