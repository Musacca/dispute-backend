package com.kapital.dispute.model.response;

import java.util.List;

public record DisputeItemResponse(String status, List<Dispute> disputeItems) {

}

