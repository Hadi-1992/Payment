package com.example.payment_01.dto.convertors;

import com.example.payment_01.dto.CustomerBillDto;
import com.example.payment_01.entities.CustomerBill;
import com.example.payment_01.entities.CustomerBill;
import com.example.payment_01.dto.CustomerBillDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerBillConverter extends BaseConvertor<CustomerBillDto,CustomerBill> {
}
