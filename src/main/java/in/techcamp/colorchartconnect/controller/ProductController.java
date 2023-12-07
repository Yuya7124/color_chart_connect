package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.form.ProductForm;
import in.techcamp.colorchartconnect.repository.ProductRepository;
import in.techcamp.colorchartconnect.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
public class ProductController {
  private final ProductRepository productMapper;

  @Autowired
  private ProductImageService imageService;

  @GetMapping
  public String showProduct(Model model){
    var productList = productMapper.findAll();
    model.addAttribute("productList", productList);
    return "index";
  }
  @GetMapping("/product")
  public String showProduct(@ModelAttribute("product") ProductForm entity){
    return "product";
  }
  //データ保存
  @PostMapping("/product")
  public String saveProduct(@ModelAttribute ProductForm form, @RequestParam("file") MultipartFile file, Model model) {
    // 画像ファイルを処理する
    if (!file.isEmpty()) {
      // 画像を保存する処理
      try {
        ProductForm saveFile = imageService.store(file);
        byte[] imageData = saveFile.getData();
        String image = Base64.getEncoder().encodeToString(imageData);
        model.addAttribute("image", image);
      } catch (IOException e) {
        e.printStackTrace();
        // エラーハンドリング
      }
    }

    // その他のデータ保存処理
    productMapper.insert(form);
    return "redirect:/";
  }


  @GetMapping("/product/{product_id}")
  public String productDetail(@PathVariable long product_id, Model model){
    var product = productMapper.findById(product_id);
    model.addAttribute("product", product);
    return "detail";
  }

  @GetMapping("/product/{product_id}/edit")
  public String productEdit(@PathVariable long product_id, Model model){
    var product = productMapper.findById(product_id);
    model.addAttribute("product", product);
    return "edit";
  }

  @PostMapping("/product/{product_id}/edit")
  public String productUpdate(@PathVariable long product_id, ProductForm entity){
    productMapper.update(product_id, entity.getProduct_name(), entity.getComment(), entity.getType(), entity.getData());
    return "redirect:/product/{product_id}";
  }

  @PostMapping("/product/{product_id}/delete")
  public String productDelete(@PathVariable Long product_id){
    productMapper.deleteById(product_id);
    return "redirect:/";
  }
}
