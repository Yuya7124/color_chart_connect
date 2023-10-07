package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.repository.ColorChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ColorChartController {
  private final ColorChartRepository colorchartRepository;
  @GetMapping
  public String showList(Model model){
    var colorchartList = colorchartRepository.findAll();
    model.addAttribute("colorchartList", colorchartList);
    return "index";
  }
}
