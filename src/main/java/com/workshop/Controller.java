package com.workshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private CabService ser;
    
  @GetMapping("/")
  public String home() {
	  return "form";
  }
  
  @PostMapping("/process")
  public String process(Model model,@RequestParam("tripType") String tripType
		  ,@RequestParam("distance") String distance,@RequestParam("pickupLocation") String pickupLocation,
		  @RequestParam("dropLocation") String dropLocation,
		  @RequestParam("name") String name,
          @RequestParam("email") String email,
          @RequestParam("date") String date,
          @RequestParam("time") String time
		  ) {
	 
	  StringBuilder s = new StringBuilder();
		 for(int i=0;i<distance.length();i++) {
			 
			 if(Character.isDigit(distance.charAt(i))) {
				 s.append(distance.charAt(i));
			 }else {
				 break;
			 }
		 }
		 
		 int distance1 = Integer.parseInt(s.toString());
	  
	  
	  if (tripType.equals("roundTrip")) {
	        int doubleDistance = distance1 * 2;
	        model.addAttribute("distance", Integer.toString(doubleDistance));
	        System.out.println(doubleDistance);
	        distance1 = doubleDistance;
	    } else {
	        model.addAttribute("distance", distance);
	    }
	  
	  model.addAttribute("cab1",distance1*15);
	  model.addAttribute("cab2",distance1*35);
	  model.addAttribute("cab3",distance1*55);


	  model.addAttribute("dropLocation",dropLocation);
	  model.addAttribute("pickupLocation",pickupLocation);
	  model.addAttribute("name", name);
	    model.addAttribute("email", email);
	    model.addAttribute("date", date);
	    model.addAttribute("time", time);
	    model.addAttribute("triptype", tripType);

	 // model.addAttribute("distance",distance);
	  System.out.println(dropLocation+" "+pickupLocation+" "+distance);

	 return "cab-page"; 
  }
  
 @PostMapping("/book")
 public String book(Model model , @RequestParam("cabType") String cabtype,
		 @RequestParam("distance") String distance,
		 @RequestParam("pickupLocation") String pickupLocation,
		 @RequestParam("dropLocation") String dropLocation,
		  @RequestParam("name") String name,
          @RequestParam("email") String email,
          @RequestParam("date") String date,
          @RequestParam("time") String time,
          @RequestParam("triptype") String triptype) {
	 
	 int price = 0;
	 System.out.println(distance);
	 
	 StringBuilder s = new StringBuilder();
	 for(int i=0;i<distance.length();i++) {
		 
		 if(Character.isDigit(distance.charAt(i))) {
			 s.append(distance.charAt(i));
		 }else {
			 break;
		 }
	 }
	 
	 int distance1 = Integer.parseInt(s.toString());
	 
	 
	 System.out.println(distance1+1);
	
		  if(cabtype.equals("Cab 1")) {
			  price = distance1*15;
			  
		  }else if(cabtype.equals("Cab 2")) {
			  price = distance1*35;
			  
		  }else if(cabtype.equals("Cab 3")) {
			  price = distance1*55;
		  }
		  System.out.println(cabtype);
		  System.out.println("result");
		  System.out.println(price);
		  
		  
		  model.addAttribute("dropLocation",dropLocation);
		  model.addAttribute("pickupLocation",pickupLocation);
		  model.addAttribute("price",price);
		  model.addAttribute("distance",distance);
		  model.addAttribute("cabtype",cabtype);
		  model.addAttribute("name", name);
		    model.addAttribute("email", email);
		    model.addAttribute("date", date);
		    model.addAttribute("time", time);
		    model.addAttribute("triptype", triptype);



		
	 return "payment";
 }
 
 
 @PostMapping("/book-cab")
 public String showreciept(Model model,@ModelAttribute Booking booking) {
	 System.out.println(booking.getName());
	 ser.save(booking);
	 return "redirect:/bookings";
	 
 }
 
 @GetMapping("/bookings")
 public String bookings(Model model) {
	 List<Booking> booking = ser.showAll();
	 model.addAttribute("booking",booking);
	 return "bookings";
 }
 
 
 
 

}
