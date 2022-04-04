package com.example.module_javaspringboot_day5_02.controller;

import com.example.module_javaspringboot_day5_02.dto.ProductDTO;
import com.example.module_javaspringboot_day5_02.dto.StatisticalDTO;
import com.example.module_javaspringboot_day5_02.service.ICategoryService;
import com.example.module_javaspringboot_day5_02.service.IProductService;
import com.example.module_javaspringboot_day5_02.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    IUserService iUserService;

    @GetMapping("/list")
    public String getHomePage(Model model,HttpSession session,@RequestParam("page") int page, @RequestParam("limit") int limit){
        if (session.getAttribute("UserLogin") == null){
            model.addAttribute("userName","Anonymous");

        }else {
            int id_user = (int) session.getAttribute("UserLogin");
            model.addAttribute("userName",iUserService.findById(id_user).get().getUsername());
        }

        if (page == 0){
            page = 1;
        }
        if (limit == 0){
            limit = 5;
        }
        List<ProductDTO> dtoList = (List<ProductDTO>) iProductService.findAll();
        int totalItems  = dtoList.size();
        int totalPage = (int) Math.ceil((double) totalItems / limit);
        int offset = (page - 1)*limit;

        model.addAttribute("page",page);
        model.addAttribute("limit",limit);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("listProduct",iProductService.findAllProduct(offset,limit));
        model.addAttribute("listCategory",iCategoryService.findAll());
        return "list_product";
    }
    @GetMapping("/insert")
    public String getInsertPage(Model model){
        model.addAttribute("product",new ProductDTO());
        return "edit_product";
    }

    @PostMapping("/edit")
    public String getEditPage(@RequestParam(value = "id_pr_edit") int id, Model model,HttpSession session){
        if (session.getAttribute("UserLogin") == null){
            model.addAttribute("userName","Anonymous");

        }else {
            int id_user = (int) session.getAttribute("UserLogin");
            model.addAttribute("userName",iUserService.findById(id_user).get().getUsername());
        }
        if (id == 0){
            model.addAttribute("product",new ProductDTO());
        }else{
            model.addAttribute("product",iProductService.findById(id).get());
        }
        return "edit_product";
    }

    @PostMapping("/insert")
    public String insertProduct(Model model, ProductDTO productDTO, @RequestParam(value = "image-pr") MultipartFile file, HttpSession session){
        productDTO.setImage(file.getOriginalFilename());
        int id_user = (int) session.getAttribute("UserLogin");
        productDTO.setCreateBy(iUserService.findById(id_user).get().getUsername());

        productDTO.setCreateTime(LocalDate.now());
        productDTO.setStatus(1);
        model.addAttribute("listProduct",iProductService.save(productDTO));
        uploadFile(file);
        return "redirect:list";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam(value = "id_pr_delete") int id){
        iProductService.delete(id);
        return "redirect:list";
    }
    @GetMapping("/ctg-product")
    public String getCategory(@RequestParam(value = "id-ctg") int id, Model model){
        model.addAttribute("listProduct",iCategoryService.findListProductById(id));
        model.addAttribute("listCategory",iCategoryService.findAll());
        return "home";
    }
    @GetMapping("/statistical")
    public String statistical(Model model,HttpSession session){
        if (session.getAttribute("cartProduct") == null){
            model.addAttribute("listPrOnCart",new ArrayList<ProductDTO>());
        }else {
            ArrayList<ProductDTO> listPrInCart = (ArrayList<ProductDTO>) session.getAttribute("cartProduct");
            ArrayList<StatisticalDTO> listStatistic = new ArrayList<>();
            int total = 0;
            for (int i = 0; i < listPrInCart.size(); i++) {
                StatisticalDTO statis = new StatisticalDTO();
                statis.setName_product(listPrInCart.get(i).getName());
                statis.setAmount(listPrInCart.get(i).getCart_amount());
                statis.setPrice(Integer.parseInt(listPrInCart.get(i).getPrice()));
                int price = Integer.parseInt(listPrInCart.get(i).getPrice());
                int pr_total = price*listPrInCart.get(i).getCart_amount();
                statis.setTotal(pr_total);
                total += pr_total;

                listStatistic.add(statis);
            }
            model.addAttribute("Statistical",listStatistic);
            model.addAttribute("Total",total);
        }

        int id_user = (int) session.getAttribute("UserLogin");
        model.addAttribute("userName",iUserService.findById(id_user).get().getUsername());
        return "statistical";
    }




    public void uploadFile(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String replaceFileName = fileName.replaceAll("\\s+", "");
        String uploadDir = "./src/main/resources/static/image-product/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(replaceFileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
