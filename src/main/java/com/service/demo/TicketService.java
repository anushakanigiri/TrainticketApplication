package com.service.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.demo.PurchaseRequest;
import com.entity.demo.UserSeat;
import com.entity.demo.User;
import com.entity.demo.Receipt;
import com.repository.demo.ReceiptRepository;
import com.repository.demo.UserRepository;
import com.repository.demo.UserSeatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

 @Autowired
 private UserRepository userRepository;

 @Autowired
 private UserSeatRepository userSeatRepository;

 @Autowired
 private ReceiptRepository receiptRepository;

 public String purchaseTicket(PurchaseRequest request) {
     Optional<User> optionalUser = userRepository.findByEmailAddress(request.getUser().getEmailAddress());

     if (optionalUser.isPresent()) {
         User user = optionalUser.get();
         String seat = assignSeat(request.getSection());

         UserSeat userSeat = new UserSeat(user, seat, request.getPricePaid());
         userSeatRepository.save(userSeat);

         Receipt receipt = new Receipt("London", "France", user, request.getPricePaid());
         receiptRepository.save(receipt);

         return "Purchase Successful\n" + receipt.toString();
     } else {
         return "User not found";
     }
 }

 public String getReceipt(String emailAddress) {
     Optional<User> optionalUser = userRepository.findByEmailAddress(emailAddress);

     if (optionalUser.isPresent()) {
         User user = optionalUser.get();
         Optional<UserSeat> optionalUserSeat = userSeatRepository.findByUser(user);

         if (optionalUserSeat.isPresent()) {
             UserSeat userSeat = optionalUserSeat.get();
             return "Receipt Details:\n" +
                     "From: London\n" +
                     "To: France\n" +
                     "User: " + user.getFirstName() + " " + user.getLastName() + "\n" +
                     "Seat: " + userSeat.getSeat() + "\n" +
                     "Price Paid: " + userSeat.getPricePaid();
         } else {
             return "User has not purchased a ticket";
         }
     } else {
         return "User not found";
     }
 }

 public List<UserSeat> getUsersBySection(String section) {
     return userSeatRepository.findBySection(section);
 }

 public String removeUser(String emailAddress) {
     Optional<User> optionalUser = userRepository.findByEmailAddress(emailAddress);

     if (optionalUser.isPresent()) {
         User user = optionalUser.get();
         userSeatRepository.remove(user);
         return "User removed successfully";
     } else {
         return "User not found";
     }
 }

 public String modifyUserSeat(String emailAddress, String newSeat) {
     Optional<User> optionalUser = userRepository.findByEmailAddress(emailAddress);

     if (optionalUser.isPresent()) {
         User user = optionalUser.get();
         Optional<UserSeat> optionalUserSeat = userSeatRepository.findByUser(user);

         if (optionalUserSeat.isPresent()) {
             UserSeat userSeat = optionalUserSeat.get();
             userSeat.setSeat(newSeat);
             userSeatRepository.save(userSeat);
             return "Seat modified for user: " + emailAddress;
         } else {
             return "User has not purchased a ticket";
         }
     } else {
         return "User not found";
     }
 }

 private String assignSeat(String section) {
     // Logic to assign a seat in the specified section
     // For simplicity, let's assume seats are assigned sequentially
     List<UserSeat> userSeatsInSection = userSeatRepository.findBySection(section);
     int seatNumber = userSeatsInSection.size() + 1;
     return section + seatNumber;
 }
}



