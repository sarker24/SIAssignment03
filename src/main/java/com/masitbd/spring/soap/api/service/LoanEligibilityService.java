package com.masitbd.spring.soap.api.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.masitbd.spring.soap.api.loaneligibility.Acknowledgement;
import com.masitbd.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchcriteriaList = acknowledgement.getCriteriaMismatch();
		
		if(!(request.getAge()>30 && request.getAge()<=60)){
			mismatchcriteriaList.add("This person should between 30 to 60");
		}
		if(!(request.getYearlyIncome()>200000 )){
			mismatchcriteriaList.add("Minimum income shiuld be more than 200000");
		}
		
		if(!(request.getCibilScore()>500 )){
			mismatchcriteriaList.add("Try after six month");
		}else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchcriteriaList.clear();
		}
		return acknowledgement;
		
	}

}
