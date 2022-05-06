package com.example.module_javaspringboot_finalproject.controller;

import com.example.module_javaspringboot_finalproject.dto.*;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;
import com.example.module_javaspringboot_finalproject.repository.UserRepository;
import com.example.module_javaspringboot_finalproject.service.ICommentsService;
import com.example.module_javaspringboot_finalproject.service.IDefaultSendMailService;
import com.example.module_javaspringboot_finalproject.service.IProductService;
import com.example.module_javaspringboot_finalproject.service.ISoldService;
import com.example.module_javaspringboot_finalproject.service.impl.SoldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/user")
@RolesAllowed(value = {"ROLE_ADMIN", "ROLE_USER"})
public class UserController {
    @Autowired
    IProductService iProductService;
    @Autowired
    ICommentsService iCommentsService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IDefaultSendMailService iDefaultSendMailService;
    @Autowired
    ISoldService iSoldService;

    List<CartProductDTO> listPrOnCart = new ArrayList<>();

    @GetMapping("/home")
    public String getHomePage(Model model, HttpSession session) {
        if (session.getAttribute("userLogin") == null) {
            return "login";
        } else {
            model.addAttribute("userLogin", session.getAttribute("userLogin"));
        }
        model.addAttribute("listProduct", iProductService.findAllProduct(PageRequest.of(0, 4)));
        int totalPage = (int) Math.ceil((double) iProductService.findAllProduct().size() / 4);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageable", PageRequest.of(1, 4));
        return "user_home";
    }

    @GetMapping("/add-to-cart")
    public String addProductToCart(@RequestParam(name = "id-product") int id_pro,
                                   HttpSession session, Model model, HttpServletRequest request) {
        if (session.getAttribute("userLogin") == null) {
            return "login";
        } else {
            model.addAttribute("userLogin", session.getAttribute("userLogin"));
        }

        int amount = 1;
        if (request.getParameter("amount-cart") != null) {
            amount = Integer.parseInt(request.getParameter("amount-cart"));
        }

        ProductDTO productDTO = iProductService.findById((long) id_pro);
        CartProductDTO cartPr = CartProductDTO.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .newPrice(productDTO.getNewPrice())
                .oldPrice(productDTO.getOldPrice())
                .amountCart(amount)
                .image(productDTO.getImage())
                .build();

        List<CartProductDTO> listPrCart = new ArrayList<>();

        if (session.getAttribute("cartProduct") != null) {
            listPrOnCart = (List<CartProductDTO>) session.getAttribute("cartProduct");
            boolean check = false;
            for (CartProductDTO proDTO : listPrOnCart) {
                if (proDTO.getId() == id_pro) {
                    proDTO.setAmountCart(proDTO.getAmountCart() + amount);
                    if (proDTO.getAmountCart() > productDTO.getAmount()) {
                        proDTO.setAmountCart(productDTO.getAmount());
                    }
                    listPrCart.add(proDTO);
                    check = true;
                } else {
                    listPrCart.add(proDTO);
                }
            }
            if (check == false) {
                listPrCart.add(cartPr);
            }
        } else {
            listPrCart.add(cartPr);
        }


        session.setAttribute("cartProduct", listPrCart);
        model.addAttribute("cartItems", listPrCart.size());

        model.addAttribute("listProduct", iProductService.findAllProduct(PageRequest.of(0, 4)));
        int totalPage = (int) Math.ceil((double) iProductService.findAllProduct().size() / 4);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageable", PageRequest.of(1, 4));

        return "user_home";
    }

    @GetMapping("/go-to-cart")
    public String cartProduct(Model model, HttpSession session) {
        UserEntity user = new UserEntity();
        if (session.getAttribute("userLogin") == null) {
            return "login";
        } else {
            user = (UserEntity) session.getAttribute("userLogin");
            model.addAttribute("userLogin", session.getAttribute("userLogin"));

        }
        AtomicInteger total = new AtomicInteger();
        if (session.getAttribute("cartProduct") != null) {
            listPrOnCart = (List<CartProductDTO>) session.getAttribute("cartProduct");

            listPrOnCart.stream().forEach(pro -> {
                total.addAndGet(pro.getAmountCart() * pro.getNewPrice());
            });
            model.addAttribute("totalPr", total);

        } else {
            model.addAttribute("listProduct", new ArrayList<>());
            model.addAttribute("totalPr", 0);
        }
        session.setAttribute("billProduct", new BillCheckoutDTO(user.getEmail(), total, null, null));
        model.addAttribute("listProduct", listPrOnCart);
        return "user_cart";
    }

    @GetMapping("/delete")
    public String deleteProductOnCart(@RequestParam(name = "id-product") int id_pro, HttpSession session) {
        UserEntity userEntity = (UserEntity) session.getAttribute("userLogin");


        listPrOnCart = (List<CartProductDTO>) session.getAttribute("cartProduct");
        List<CartProductDTO> listPrCart = new ArrayList<>();
        for (CartProductDTO proDTO : listPrOnCart) {
            if (proDTO.getId() != id_pro) {
                listPrCart.add(proDTO);
            }
        }
        session.setAttribute("cartProduct", listPrCart);
        return "redirect:go-to-cart";
    }

    @PostMapping("/comment")
    public String commentAndRating(@RequestParam(name = "id-product") int id_pro, HttpServletRequest request, HttpSession session) {

        UserEntity userEntity = (UserEntity) session.getAttribute("userLogin");

        String comment = request.getParameter("comment");
        int rating = Integer.parseInt(request.getParameter("rating"));
        iCommentsService.save(new CommentsDTO(null, comment, rating, null, iProductService.findById((long) id_pro), UserEntity.toDTO(userEntity)));
        return "redirect:/view-detail?id-product=" + id_pro;
    }

    @GetMapping("/pay")
    public String payment(HttpSession session, @RequestParam(name = "id") int id_user) {
        BillCheckoutDTO billCheckoutDTO = (BillCheckoutDTO) session.getAttribute("billProduct");
        listPrOnCart = (List<CartProductDTO>) session.getAttribute("cartProduct");


        billCheckoutDTO.setStatus("Thanh toán thành công");
        billCheckoutDTO.setDate(LocalDate.now().toString());
        UserEntity userEntity = userRepository.getById((long) id_user);
        iDefaultSendMailService.sendMailToPayCart(userEntity.getEmail(),billCheckoutDTO,listPrOnCart);

        listPrOnCart.stream().forEach(pro -> {
            SoldDTO soldDTO = new SoldDTO(null, pro.getAmountCart(), (pro.getAmountCart() * pro.getNewPrice()), new Date(), iProductService.findById(pro.getId()));
            iSoldService.setDataStatistic(pro);
            iSoldService.save(soldDTO);

        });

        iDefaultSendMailService.setAmountProductAfterCheckout(listPrOnCart);

        session.removeAttribute("billProduct");
        session.removeAttribute("cartProduct");
        return "redirect:home";
    }

}
