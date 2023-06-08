package com.codingapi.crankycode.repository.impl;

import com.codingapi.crankycode.domain.Merchant;
import com.codingapi.crankycode.domain.Product;
import com.codingapi.crankycode.repository.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Product getProductByName(String name) {
        Merchant merchant = new Merchant("李老板");
        return new Product(name,merchant);
    }

}
