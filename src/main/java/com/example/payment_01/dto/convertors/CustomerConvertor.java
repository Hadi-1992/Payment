package com.example.payment_01.dto.convertors;

import com.example.payment_01.dto.CustomerDto;
import com.example.payment_01.entities.CustomerEntity;
import com.example.payment_01.exceptions.ServiceException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "Spring")
public interface CustomerConvertor extends BaseConvertor<CustomerDto, CustomerEntity> {
    @Override
    @Mapping(target ="firstName",source ="name")
    CustomerEntity convertDto(CustomerDto customerDto) throws ServiceException;


}
