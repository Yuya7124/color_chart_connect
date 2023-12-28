package in.techcamp.colorchartconnect.service;

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


@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl { //implements ProductImageService {

  @Autowired
  private final ProductRepository productRepository;

  private final Mapper mapper;

  @Value("${image.folder}")
  private String imgFolder;

  @Value("${image.extract}")

  private String imgExtract;

//  @Override
//  public void saveProduct(ProductForm form) throws IOException {
//    if(form != null && form.getProduct_image() != null && !form.getProduct_image().isEmpty()){
//      //保存する画像のパス設定
////      File file = new File("0");
//      String fileName = fileName(form.getProduct_image());
//      var saveFileName = fileName + imgExtract;
//
//      Path imageFilePath = Paths.get(imgFolder, saveFileName);
//
//      //画像ファイル保存
//      Files.copy(form.getProduct_image().getInputStream(), imageFilePath);
//    }
//    //DB更新
//    var productInfo = mapper.map(form, ProductForm.class);
//    productRepository.insert(productInfo);
//  }

//  public String fileName(MultipartFile file) throws IOException {
//    String name = StringUtils.cleanPath(file.getOriginalFilename());
//    return name;
//  }

  public void store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    // 画像データの取得
    byte[] imageData = file.getBytes();
    // 保存するProductEntityの作成
    ProductForm form = new ProductForm();
    form.setImage_filename(fileName);
    form.setImage_data(imageData);
  }
}
