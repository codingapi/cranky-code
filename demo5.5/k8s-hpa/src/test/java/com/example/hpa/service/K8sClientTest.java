package com.example.hpa.service;

import io.kubernetes.client.openapi.ApiException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class K8sClientTest {

    @Autowired
    private K8sClient k8sClient;

    @Test
    void listServices() throws ApiException {
        k8sClient.listServices().forEach(System.out::println);
    }
}