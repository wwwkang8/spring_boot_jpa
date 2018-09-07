package net.slipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller /*컨트롤러 클래스로 역할 부여*/
public class WelcomeController {
	
	@GetMapping("/helloworld")
	public String welcome(String name,int age, Model model){//url로부터 받는 파라미터
		System.out.println("name : "+name+","+"age : "+age);
		model.addAttribute("name",name);//모델에 네임이라는 이름으로 저장됨
		model.addAttribute("age",age);
		/*welcome.html은 view에 해당한다*/
		return "welcome"; //메서드 리턴값 중요 : welcome 뒤에 html이 자동으로 붙는다. 파일명만 반환하기
	}
	
}
