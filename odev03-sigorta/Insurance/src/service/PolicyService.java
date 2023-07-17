package service;

import model.InsuranceCompany;
import model.Policy;
import model.Vehicle;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

public class PolicyService {



    /*
    private InsuranceCompany insuranceCompany;
    private Vehicle vehicle;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;
     */
    public Policy createPolicy(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal price, Date startDate,
                               Date endDate){
        Policy policy = new Policy();
        policy.setInsuranceCompany(insuranceCompany);
        policy.setVehicle(vehicle);
        policy.setPrice(price);
        policy.setStartDate(startDate);
        policy.setEndDate(endDate);
        return policy;

    }
}
