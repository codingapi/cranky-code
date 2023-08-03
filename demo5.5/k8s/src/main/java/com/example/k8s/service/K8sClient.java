package com.example.k8s.service;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class K8sClient {

    private final CoreV1Api api;

    public K8sClient() {
        try {
            Resource resource = new ClassPathResource("k8s/admin.conf");
            Reader reader = new InputStreamReader(resource.getInputStream());
            ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(reader)).build();
            Configuration.setDefaultApiClient(client);
            api = new CoreV1Api(client);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listServices() throws ApiException {
        List<String> services = new ArrayList<>();
        api.listServiceForAllNamespaces(null, null, null, null,
                        null, null, null, null, null, null)
                .getItems()
                .forEach(service -> {
                    services.add(Objects.requireNonNull(service.getMetadata()).getName());
                });
        return services;
    }

}
