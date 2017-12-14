package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BmiController {
	@RequestMapping("/toBmi.do")
	public String toBmi(){
		return "bmi_form";
	}
	@RequestMapping("/bmi.do")
	public String bmi(Bmi bmi,HttpServletRequest request){
		int weight = Integer.parseInt(bmi.getWeight());
		double height = Double.parseDouble(bmi.getHeight());
		double bmi1 = weight / height / height;
		String message;
		if(bmi1<19){
			message = "瘦了";
		}else if(bmi1>25){
			message = "胖了";
		}else{
			message = "正常";
		}
		request.setAttribute("message", message);
		request.setAttribute("bmi1", bmi1);
		return "view";
	}
}
