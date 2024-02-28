package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.entity.UserEntity;
import in.techcamp.colorchartconnect.form.ProductForm;
import in.techcamp.colorchartconnect.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {
  private final ProductRepository productRepository;

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

  // 一覧画面
  @GetMapping
  public String showProducts(Model model, Principal principal){

    if (principal != null) {
       String nickname = principal.getName(); // ログインユーザのユーザ名を取得
       model.addAttribute("nickname", nickname);
    }

    //投稿情報
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


  // 新規投稿画面へ遷移
  @GetMapping("/product")
  public String showProductForm(@ModelAttribute("productForm") ProductForm form){
    return "product";
  }

  //データ保存
  @PostMapping("/product")
  public String saveProduct(@Valid @ModelAttribute("productForm") ProductForm form, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file, Principal principal, @AuthenticationPrincipal UserEntity user) throws IOException {
    
    String nickname = principal.getName(); // ログインユーザのユーザ名を取得

    // 入力チェック
    if (bindingResult.hasErrors()){
      // エラー発生時
      return showProductForm(form);
    }

    try {
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      // 画像データの取得
      byte[] imageData = file.getBytes();

      if (imageData.length > 1000000) {
        int targetWidth = 250; // 適切な幅を指定
        int targetHeight = 187; // 適切な高さを指定
        byte[] compressedImageData = compressImage(imageData, targetWidth, targetHeight);
        // 保存するProductEntityの作成
        form.setImage_filename(fileName);
        form.setImage_data(compressedImageData);
        form.setNickname(nickname);
      }
      else {
        // 保存するProductEntityの作成
        form.setImage_filename(fileName);
        form.setImage_data(imageData);
      }
    }
    catch (Exception e) {
      return showProductForm(form);
    }

    model.addAttribute("productForm", form);
    productRepository.insert(form.getProduct_name(), form.getNickname(), form.getColor_chart(), form.getImage_data(), form.getImage_filename(),form.getComment());
    return "redirect:/";
  }

  // 詳細画面
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

  // 編集画面へ遷移
  @GetMapping("/product/{product_id}/edit")
  public String productEdit(@PathVariable long product_id, @ModelAttribute("product") ProductForm form, Model model){
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
    return "edit";
  }

  // データ更新
  @PostMapping("/product/{product_id}/edit")
  public String productUpdate(@PathVariable long product_id, @Valid @ModelAttribute("productForm") ProductForm form, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) throws IOException {
    var product = productRepository.findById(product_id);
    form.setFile(file);
    form.convertFileToBytes();
    form.setImage_data(product.getImage_data());
    form.setImage_filename(product.getImage_filename());

    if (bindingResult.hasErrors()){
      // エラー発生時
      return productEdit(product_id, form, model);
    }

    try {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // 画像データの取得
        byte[] imageData = file.getBytes();
        // 保存するProductEntityの作成
        form.setImage_filename(fileName);
        form.setImage_data(imageData);
    } catch (Exception e) {
      return productEdit(product_id, form, model);
    }

    model.addAttribute("productForm", form);
    productRepository.update(product_id, form.getProduct_name(), form.getColor_chart(), form.getImage_data(), form.getImage_filename(), form.getComment());
    return "redirect:/product/" + product_id;
  }

  // データ削除
  @PostMapping("/product/{product_id}/delete")
  public String productDelete(@PathVariable long product_id){
    productRepository.deleteById(product_id);
    return "redirect:/";
  }
}
