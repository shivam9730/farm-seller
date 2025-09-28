package com.choice.reigster.farm_item.service;

import com.choice.reigster.shared.utility.RequestDto.RegisterItemRequest;
import com.choice.reigster.shared.utility.entity.RegisterItem;
import org.springframework.stereotype.Service;

@Service
public interface RegisterItemService  {
    public RegisterItem createProduct(RegisterItemRequest dto);
}
