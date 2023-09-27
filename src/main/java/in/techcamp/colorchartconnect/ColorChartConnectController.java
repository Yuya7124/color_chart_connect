package in.techcamp.colorchartconnect;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@RequiredArgsConstructor
public class ColorChartConnectController {
//  private final ColorChartConnectRepository colorcharRepository;
  @GetMapping
  public String showColorchart() {
//    var colorchartList = colorcharRepository.findAll();
//    model.addAttribute("colorchartList", colorchartList);
    return "index";
  }
}
