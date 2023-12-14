package in.techcamp.colorchartconnect.service;

import in.techcamp.colorchartconnect.form.ProductForm;

import java.io.IOException;

public interface ProductImageService {

  public ProductImageServiceImpl saveProduct(ProductForm form) throws IOException;
}
