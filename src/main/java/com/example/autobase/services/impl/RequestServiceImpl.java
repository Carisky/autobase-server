package com.example.autobase.services.impl;

import com.example.autobase.models.Request;
import com.example.autobase.repositories.RequestRepository;
import com.example.autobase.services.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Optional<Request> findById(long id) {
        return requestRepository.findById(id);
    }

    @Override
    public Request create(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Optional<Request> delete(long id) {
        Optional<Request> deleted = requestRepository.findById(id);
        deleted.ifPresent(request -> requestRepository.delete(request));
        return deleted;
    }
}
