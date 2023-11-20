package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.entity.ColorChartEntity;
import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.mapper.ColorChartMapper;
import in.techcamp.colorchartconnect.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
  private final ProductMapper productMapper;
  @GetMapping("/products")
  public String showProduct(Model model){
    var productList = productMapper.findAll();
    model.addAttribute("productList", productList);
    return "index";
  }
  @GetMapping("/product")
  public String showProduct(@ModelAttribute("product") ProductEntity entity){
    return "product";
  }
  @PostMapping("/product")
  public String saveProduct(ProductEntity entity){
    productMapper.insert(entity.getProduct_name());
    return "redirect:/";
  }
}
