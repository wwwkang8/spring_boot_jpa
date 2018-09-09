package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired   //스프링부트에서 알아서 생성해준다
	private UserRepository userRepository;
	
	@PostMapping("/create")
	public String create(User user){
		System.out.println("user : "+user);
		userRepository.save(user);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model){
		model.addAttribute("users", userRepository.findAll());
		return "list";
	}
	
}
