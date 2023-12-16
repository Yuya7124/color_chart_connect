package in.techcamp.colorchartconnect.service;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.form.ProductForm;
import in.techcamp.colorchartconnect.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


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
    if(form != null && form.getData() != null && !form.getData().isEmpty()){
      //保存する画像のパス設定
      var saveFileName = form.getProduct_id() + imgExtract;
      Path imageFilePath = Path.of(imgFolder, saveFileName);

      //画像ファイル保存
      Files.copy(form.getData().getInputStream(), imageFilePath);
    }
    //DB更新
    var productInfo = mapper.map(form, ProductEntity.class);
    productRepository.save(productInfo);
  }
}
