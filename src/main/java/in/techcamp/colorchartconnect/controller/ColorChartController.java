package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.entity.ColorChartEntity;
import in.techcamp.colorchartconnect.mapper.ColorChartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class ColorChartController {
  private final ColorChartMapper colorchartRepository;
  @GetMapping
  public String showList(Model model){
    var colorchartList = colorchartRepository.findAll();
    model.addAttribute("colorchartList", colorchartList);
    return "index";
  }
  @GetMapping("/colorChart")
  public String showColorChart(@ModelAttribute("colorChart") ColorChartEntity entity){
    return "colorChart";
  }
}
