package in.techcamp.colorchartconnect.service;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ProductImageService {

  @Autowired
  private ProductMapper productMapper;

  public ProductEntity entity(MultipartFile file)
  public void uploadImage(MultipartFile file) {

  }
}
