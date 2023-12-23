package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.form.ProductForm;
import in.techcamp.colorchartconnect.repository.ProductRepository;
import in.techcamp.colorchartconnect.service.ProductImageService;
import in.techcamp.colorchartconnect.service.ProductImageServiceImpl;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductController {
  private final ProductRepository productRepository;

  private final ProductImageServiceImpl imageService;

  private static final String UPLOAD_DIR = "uploads";

  // 画像ファイル圧縮
  private byte[] compressImage(byte[] originalImageData, int targetWidth, int targetHeight) throws IOException {
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(originalImageData);
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      Thumbnails.of(inputStream)
              .size(targetWidth, targetHeight)
              .outputFormat("png") // 出力フォーマットを選択
              .toOutputStream(outputStream);
      return outputStream.toByteArray();
    }
  }

  @Value("${image.folder}")
  private String imgFolder;

  @Value("${image.extract}")
  private String imgExtract;

  @GetMapping
  public String showProducts(Model model){
    var productList = productRepository.findAll();
    // Base64エンコードされた画像データをセット
    try {
      productList.forEach(product -> {
        Long id = product.getProduct_id();
        if(id != null) {
          byte[] imageData = product.getImage_data();
          String image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageData);
          product.setEncodedImageData(image);
          model.addAttribute("image", image);
        }
      });
    } catch (Exception e) {

    }
    model.addAttribute("productList", productList);
    return "index";
  }

  @GetMapping("/product")
  public String showProductForm(@ModelAttribute("product") ProductForm form){
    return "product";
  }
  //データ保存

  @PostMapping("/product")
  public String saveProduct(@ModelAttribute ProductForm form, @RequestParam("file") MultipartFile file, Model model) throws IOException {
    String message = "";
    try {
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      // 画像データの取得
      byte[] imageData = file.getBytes();
      int targetWidth = 250; // 適切な幅を指定
      int targetHeight = 187; // 適切な高さを指定
      byte[] compressedImageData = compressImage(imageData, targetWidth, targetHeight);
      String image = Base64.getEncoder().encodeToString(compressedImageData);

      // 保存するProductEntityの作成
      form.setImage_filename(fileName);
      form.setImage_data(compressedImageData);

    } catch (Exception e) {

    }
    model.addAttribute("productForm", form);
    productRepository.insert(form.getProduct_name(), form.getColor_chart(), form.getImage_data(), form.getImage_filename(),form.getComment());
    return "redirect:/";
  }

  @GetMapping("/product/{product_id}")
  public String productDetail(@PathVariable long product_id, Model model){
    var product = productRepository.findById(product_id);
    try {
      // Base64エンコードされた画像データをセット
      byte[] imageData = product.getImage_data();
      String image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageData);
      product.setEncodedImageData(image);
      model.addAttribute("image", image);
    } catch (Exception e) {

    }
    model.addAttribute("product", product);
    return "detail";
  }

  @GetMapping("/product/{product_id}/edit")
  public String productEdit(@PathVariable long product_id, Model model){
    var product = productRepository.findById(product_id);
    model.addAttribute("product", product);
    return "edit";
  }

  @PostMapping("/product/{product_id}/edit")
  public String productUpdate(@PathVariable long product_id, ProductForm form){
    productRepository.update(product_id, form.getProduct_name(), form.getColor_chart() ,form.getImage_data(), form.getImage_filename(), form.getComment());
    return "redirect:/product/{product_id}";
  }

  @PostMapping("/product/{product_id}/delete")
  public String productDelete(@PathVariable Long product_id){
    productRepository.deleteById(product_id);
    
    return "redirect:/";
  }
}
