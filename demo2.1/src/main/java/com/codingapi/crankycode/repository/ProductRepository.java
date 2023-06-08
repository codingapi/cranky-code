package com.codingapi.crankycode.repository;

import com.codingapi.crankycode.domain.Product;

public interface ProductRepository {

    Product getProductByName(String name);
}
