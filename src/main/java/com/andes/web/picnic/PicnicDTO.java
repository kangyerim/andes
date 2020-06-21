package com.andes.web.picnic;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PicnicDTO {
    private String stationName, stationType, roadAddress, branchAddress, latitude, hardness, operStart, operEnd, closeDay,
            chargeType, serviceCharge, holdingNum, holderNum, airInjectAble, airInjectType, repairAble, manageTel, manageAgency, dbDate ;
}

//    private String seq, name, cate, address, addressNum, latitude, hardness, area, exerciseFacility, amusementFacility,
//            convenientFacility, culturalFacility, extraFacility, noticedDate, manageAgency, tel, dbDate;
