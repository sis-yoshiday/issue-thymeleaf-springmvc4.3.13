package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Controller
	public static class MyController {

    @GetMapping("/")
    public String index(MyForm form, Model model) {
      model.addAttribute("enums", MyEnum.values());
      return "index";
    }
	}

	public enum MyEnum {
	  A, B, C
  }

  public static class MyForm {

		private MyEnum v = MyEnum.A;// throw exception
		//private MyEnum v = MyEnum.B;// throw exception
		//private MyEnum v;// error not occur

		public MyEnum getV() {
			return v;
		}

		public void setV(MyEnum v) {
			this.v = v;
		}
	}
}
