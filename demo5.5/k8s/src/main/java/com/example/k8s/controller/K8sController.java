package com.example.k8s.controller;

import com.example.k8s.service.K8sClient;
import io.kubernetes.client.openapi.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/k8s")
@AllArgsConstructor
public class K8sController {

    private final K8sClient k8sClient;

    @RequestMapping("/listServices")
    public List<String> listServices() throws ApiException {
        return k8sClient.listServices();
    }


}
