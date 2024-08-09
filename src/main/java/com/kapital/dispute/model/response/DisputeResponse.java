package com.kapital.dispute.model.response;

import java.util.List;

public record DisputeResponse(
        Long id,
        String status,
        String number,
        String title,
        String createdAt,
        String updatedAt,
        String description,
        Integer rating,
        String review,
        List<DisputeAttachmentResponse> attachments) {

}

