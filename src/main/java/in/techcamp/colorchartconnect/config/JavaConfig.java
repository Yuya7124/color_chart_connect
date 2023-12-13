package in.techcamp.colorchartconnect.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

  @Bean
  public ModelMapper modelMapper(){
    return new ModelMapper();
  }

  @Bean
  public Mapper mapper() {
    return new DozerBeanMapper();
  }
}
