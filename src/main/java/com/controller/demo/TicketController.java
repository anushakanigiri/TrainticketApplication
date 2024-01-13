package com.controller.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.demo.PurchaseRequest;
import com.entity.demo.UserSeat;
import com.service.demo.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

 @Autowired
 private TicketService ticketService;

 @PostMapping("/purchase")
 public ResponseEntity<String> purchaseTicket(@RequestBody PurchaseRequest request) {
     String result = ticketService.purchaseTicket(request);
     //return ResponseEntity.ok(receipt);
     return ResponseEntity.ok(result);
 }

 @GetMapping("/receipt/{email}")
 public ResponseEntity<String> getReceipt(@PathVariable String email) {
     String receipt = ticketService.getReceipt(email);
     return ResponseEntity.ok(receipt);
 }

 @GetMapping("/users/{section}")
 public ResponseEntity<List<UserSeat>> getUsersBySection(@PathVariable String section) {
     List<UserSeat> usersBySection = ticketService.getUsersBySection(section);
     return ResponseEntity.ok(usersBySection);
 }

 @PostMapping("/remove")
 public ResponseEntity<String> removeUser(@RequestParam String email) {
     String message = ticketService.removeUser(email);
     return ResponseEntity.ok(message);
 }

 @PostMapping("/modify")
 public ResponseEntity<String> modifyUserSeat(@RequestParam String email, @RequestParam String newSeat) {
     String message = ticketService.modifyUserSeat(email, newSeat);
     return ResponseEntity.ok(message);
 }

}




