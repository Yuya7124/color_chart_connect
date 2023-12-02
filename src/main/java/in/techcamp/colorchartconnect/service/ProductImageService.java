package in.techcamp.colorchartconnect.service;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.ImagingOpException;
import java.io.IOException;

@Service
public class ProductImageService {

  @Autowired
  private ProductMapper productMapper;

  public ProductEntity store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    ProductEntity ProductEntity = new ProductEntity(fileName, file.getContentType(), file.getBytes());

    return productMapper.insert(ProductEntity);
  }
}
