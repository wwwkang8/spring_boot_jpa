package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	/*이 데이터는 RAM에 올라간다. 그렇게 되면 전기가 꺼지면 데이터가 소멸된다*/
	private List<User> users=new ArrayList<User>();
	
	@PostMapping("/create")
	public String create(User user){
		/*서버에 변경사항이 저장될 때는 post 방식을 사용한다*/
		System.out.println("user : "+user);
		users.add(user);
		/*회원가입을 끝내고 바로 GetMapping("/list")가 호출 될 수 있게 한다*/
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model){
		model.addAttribute("users", users);
		return "list";
		/*서버를 재시작하면 리스트가 사라지는 이유
		 * 
		 * 서버가 재시작하는 순간 모두 소멸된다.
		 * 데이터베이스에 모두 저장해야한다
		 * */
	}
	
}
