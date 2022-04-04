package com.example.onlineshoppingsystem.services.impl;

import com.example.onlineshoppingsystem.dto.FileDTO;
import com.example.onlineshoppingsystem.entities.file.File;
import com.example.onlineshoppingsystem.repositories.FileRepository;
import com.example.onlineshoppingsystem.services.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class FileServiceImpl implements FileService {
    private final ModelMapper modelMapper;
    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository, ModelMapper modelMapper) {
        this.fileRepository = fileRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FileDTO getFileById(String id) {
        File byId = fileRepository.getById(id);
        FileDTO dto = modelMapper.map(byId, FileDTO.class);
        return dto;
    }
}
