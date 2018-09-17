package net.slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

import javax.servlet.http.HttpSession;

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

	@GetMapping("/loginForm")
	public String loginForm(){
		System.out.println("loginForm 통과");
		return "/user/login";
	}

	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session){
		User user=userRepository.findByUserId(userId);
		if(user == null){
			System.out.println("Login fail");
			return "redirect:/users/loginForm";
		}

		if(!password.equals(user.getPassword())){
			System.out.println("Login fail");
			return "redirect:/users/loginForm";
		}
		System.out.println("Login Success");
		session.setAttribute("user", user);

		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session){
		//session.invalidate();
		/*session에 해당하는 이름을 매개변수로 넣어줘야 한다*/
		session.removeAttribute("user");
		return "redirect:/";
	}
























	
}
