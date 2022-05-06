package com.example.module_javaspringboot_finalproject.controller;

import com.example.module_javaspringboot_finalproject.dto.CountRatingDTO;
import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;
import com.example.module_javaspringboot_finalproject.repository.UserRepository;
import com.example.module_javaspringboot_finalproject.service.ICommentsService;
import com.example.module_javaspringboot_finalproject.service.IDefaultSendMailService;
import com.example.module_javaspringboot_finalproject.service.IProductService;
import com.example.module_javaspringboot_finalproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IProductService iProductService;
    @Autowired
    ICommentsService iCommentsService;
    @Autowired
    IUserService iUserService;
    @Autowired
    IDefaultSendMailService iDefaultSendMailService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    public String getHomePage(Model model,HttpSession session) {
        if (session.getAttribute("userLogin") != null){
            model.addAttribute("userLogin",session.getAttribute("userLogin"));
        }
        model.addAttribute("listProduct", iProductService.findAllProduct(PageRequest.of(0,4)));
        int totalPage = (int) Math.ceil((double) iProductService.findAllProduct().size() / 4);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageable", PageRequest.of(1, 4));
        return "user_home";
    }

    @GetMapping("/view-detail")
    public String viewDetail(@RequestParam(name = "id-product") int id_pro, Model model, HttpSession session) {
        if (session.getAttribute("userLogin") != null){
            model.addAttribute("userLogin",session.getAttribute("userLogin"));
        }
        model.addAttribute("productObj", iProductService.findById((long) id_pro));

        model.addAttribute("listProduct", iProductService.findAllProduct(PageRequest.of(0,4)));
        int totalPage = (int) Math.ceil((double) iProductService.findAllProduct().size() / 4);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageable", PageRequest.of(1, 4));
        return "user_detail_product";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/data-pagination")
    public ResponseEntity<List<ProductDTO>> getHomePagePagination(Pageable pageable) {
        return ResponseEntity.ok().body(iProductService.findAllProduct(PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize())));
    }
    @GetMapping("/get-count-comments")
    public ResponseEntity<?> getCountComment(@RequestParam(name = "id-product") int id_pro){
        int point1 = iCommentsService.countCommentsByPoint((long) id_pro,1);
        int point2 = iCommentsService.countCommentsByPoint((long) id_pro,2);
        int point3 = iCommentsService.countCommentsByPoint((long) id_pro,3);
        int point4 = iCommentsService.countCommentsByPoint((long) id_pro,4);
        int point5 = iCommentsService.countCommentsByPoint((long) id_pro,5);
        int avgPoint = 0;
        if (point1 == 0 && point2 == 0 && point3 == 0 && point4 == 0 && point5 == 0){

        }else{
            avgPoint = iCommentsService.avgPoint((long) id_pro);
        }
        CountRatingDTO countRatingDTO = new CountRatingDTO(point1,point2,point3,point4,point5,avgPoint);
        return ResponseEntity.ok().body(countRatingDTO);
    }
    @GetMapping("/get-comments")
    public ResponseEntity<?> getComments(@RequestParam(name = "id-product") int id_pro){
        return ResponseEntity.ok().body(iCommentsService.getListCommentsByIdProduct((long) id_pro));
    }
    @GetMapping("/forgot-password")
    public String getFogotPasswordForm() {
        return "forgot_password_form";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam(name = "email") String email, Model model) {
        UserEntity userEntity = iUserService.findByEmail(email);
        if (userEntity != null) {
            iDefaultSendMailService.sendMailResetPassword(email);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
        } else {
            model.addAttribute("message", "User Invalid");
        }
        return "forgot_password_form";
    }

    @GetMapping("/reset_password")
    public String getResetPasswordForm(Model model, @RequestParam("token") String token) {
        model.addAttribute("token", token);
        return "reset_password_form";
    }

    @PostMapping("/reset-password")
    public String resetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String confirm_pass = request.getParameter("confirm-password");
        UserEntity userEntity = iUserService.findUserByToken(token);
        if (userEntity != null) {
            if (password.equals(confirm_pass)) {
                userEntity.setResetPassWordToken(null);
                userEntity.setPassword(bCryptPasswordEncoder.encode(password));
                userRepository.save(userEntity);
                model.addAttribute("message", "Reset password successfull !");
            } else {
                model.addAttribute("message", "Reset password failed ! ");
            }

        }

        return "reset_password_form";
    }

}
