package in.techcamp.colorchartconnect.service;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.repository.FileStorageRepository;
import in.techcamp.colorchartconnect.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageService {

//  @Autowired
//  private FileStorageRepository fileStorageRepository;
//  public ProductEntity store(MultipartFile file) throws IOException {
//    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//    ProductEntity entity = new ProductEntity(fileName, file.getContentType(), file.getBytes());
//
//    return fileStorageRepository.save(entity);
//  }
}
