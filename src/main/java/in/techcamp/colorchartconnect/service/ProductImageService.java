package in.techcamp.colorchartconnect.service;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.form.ProductForm;
import in.techcamp.colorchartconnect.repository.ProductRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class ProductImageService {

  @Autowired
  private ProductRepository productRepository;

  private Mapper mapper;

  @Value("${image.folder}")
  private String imgFolder;

  @Value("${image.extract}")
  private String imgExtract;

  @Override
  public void saveProduct(ProductForm form) throws IOException {
    if(!form.getProduct_image().isEmpty()){
      //保存する画像のパス設定
      var saveFileName = form.getProduct_id() + imgExtract;
      Path imageFilePath = Path.of(imgFolder, saveFileName);

      //画像ファイル保存
      Files.copy(form.getProduct_image().getInputStream(), imageFilePath);
    }
    //DB更新
    var productInfo = mapper.map(form, ProductEntity.class);
    productRepository.insert(productInfo);

  }
}
