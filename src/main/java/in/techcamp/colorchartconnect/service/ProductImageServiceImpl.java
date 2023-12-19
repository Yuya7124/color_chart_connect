package in.techcamp.colorchartconnect.service;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.form.ProductForm;
import in.techcamp.colorchartconnect.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

  @Autowired
  private final ProductRepository productRepository;

  private final Mapper mapper;

  @Value("${image.folder}")
  private String imgFolder;

  @Value("${image.extract}")
  private String imgExtract;

  @Override
  public void saveProduct(ProductForm form) throws IOException {
    if(form != null && form.getProduct_image() != null && !form.getProduct_image().isEmpty()){
      //保存する画像のパス設定
      var saveFileName = form.getProduct_id() + imgExtract;
      File file = new File(imgFolder);
      Path imageFilePath = Path.of(imgFolder, saveFileName);

      //画像ファイル保存
      Files.copy(form.getProduct_image().getInputStream(), imageFilePath);
    }
    //DB更新
    var productInfo = mapper.map(form, ProductForm.class);
    productRepository.insert(productInfo);
  }
}
