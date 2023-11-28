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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
  private final ProductMapper productMapper;
  @GetMapping
  public String showProduct(Model model){
    var productList = productMapper.findAll();
    model.addAttribute("productList", productList);
    return "index";
  }
  @GetMapping("/product")
  public String showProduct(@ModelAttribute("product") ProductEntity entity){
    return "product";
  }
  //データ保存
  @PostMapping("/product")
  public String saveProduct(ProductEntity entity){
    productMapper.insert(entity);

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
  public String productUpdate(@PathVariable long product_id, ProductEntity entity){
    productMapper.update(product_id, entity.getProduct_name(), entity.getComment(), entity.getType(), entity.getData());
    return "redirect:/";
  }
}
