package in.techcamp.colorchartconnect.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl { //implements ProductImageService {

//  @Value("${image.folder}")
//  private String imgFolder;
//
//  @Value("${image.extract}")
//
//  private String imgExtract;

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

//  public void store(MultipartFile file) throws IOException {
//    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//    // 画像データの取得
//    byte[] imageData = file.getBytes();
//    // 保存するProductEntityの作成
//    ProductForm form = new ProductForm();
//    form.setImage_filename(fileName);
//    form.setImage_data(imageData);
//  }
}
