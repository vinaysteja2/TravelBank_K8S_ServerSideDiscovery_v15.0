package com.travelbank.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelbank.accounts.dto.LoansDto;

@FeignClient(name="loans" , url = "http://loans:8090" ,fallback = LoansFallback.class)
public interface LoansFeignClient {

    @GetMapping(value = "/api/fetch",consumes = "application/json")
    public ResponseEntity<LoansDto> fetchLoanDetails(
    		@RequestHeader("travelbank-correlation-id")
    		  String CorrelationId,@RequestParam String mobileNumber);

}
