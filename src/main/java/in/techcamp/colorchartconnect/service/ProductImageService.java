package in.techcamp.colorchartconnect.service;

import in.techcamp.colorchartconnect.form.ProductForm;

import java.io.IOException;

public interface ProductImageService {

  public void saveProduct(ProductForm form) throws IOException;
}
