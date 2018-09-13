package net.slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
@RequestMapping("/users") //대표 URL. 이것 이후에 다른 url을 붙일 수 있다. url 중복 제거
public class UserController {
	
	@Autowired   //스프링부트에서 알아서 생성해준다
	private UserRepository userRepository;
	
	@GetMapping("/form")
	public String form(){
		return "/user/form";
	}
	
	@PostMapping("")
	public String create(User user){
		System.out.println("user : "+user);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable Long id, User newUser){
		User user=userRepository.findById(id).get();
		user.update(newUser); //User 객체 내부에 있는 정보를 업데이트 한다.
		userRepository.save(user); //
		return "redirect:/users";
	}
	
	@GetMapping("")
	public String list(Model model){
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	@GetMapping("{id}/form")
	public String updateForm(@PathVariable Long id, Model model){
		User user = userRepository.findById(id).get();  
		model.addAttribute("user", user);
		return "/user/updateForm";
	}
	
}
