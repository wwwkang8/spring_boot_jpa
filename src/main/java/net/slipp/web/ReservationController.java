package net.slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.domain.Reservation;
import net.slipp.domain.ReservationRepository;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@PostMapping("")
	public String createOrder(Reservation reservation){
		System.out.println(reservation);
		reservationRepository.save(reservation);
		return "redirect:/reservations";
	}
	
	@GetMapping("")
	public String listOrder(Model model){
		model.addAttribute("reservation",reservationRepository.findAll());
		System.out.println("asdfasdf");
		return "/reservation/list";
	}
	
}
