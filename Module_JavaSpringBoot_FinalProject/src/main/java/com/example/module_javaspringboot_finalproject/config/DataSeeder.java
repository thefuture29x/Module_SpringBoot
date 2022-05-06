//package com.example.module_javaspringboot_finalproject.config;
//
//import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
//import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
//import com.example.module_javaspringboot_finalproject.entities.RoleEntity;
//import com.example.module_javaspringboot_finalproject.entities.UserEntity;
//import com.example.module_javaspringboot_finalproject.repository.CategoryRepository;
//import com.example.module_javaspringboot_finalproject.repository.ProductRepository;
//import com.example.module_javaspringboot_finalproject.repository.RoleRepository;
//import com.example.module_javaspringboot_finalproject.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {
//    @Autowired
//    RoleRepository roleRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        if(roleRepository.findByRole("ROLE_ADMIN") == null){
//            roleRepository.save(new RoleEntity(1L,"ROLE_ADMIN",null));
//        }
//        if(roleRepository.findByRole("ROLE_MENTOR") == null){
//            roleRepository.save(new RoleEntity(2L,"ROLE_MENTOR",null));
//        }
//        if(roleRepository.findByRole("ROLE_USER") == null){
//            roleRepository.save(new RoleEntity(3L,"ROLE_USER",null));
//        }
//        RoleEntity roleAdmin = roleRepository.findByRole("ROLE_ADMIN");
//        RoleEntity roleMentor = roleRepository.findByRole("ROLE_MENTOR");
//        RoleEntity roleUser = roleRepository.findByRole("ROLE_USER");
//
//
//        if (userRepository.findByEmail("admin@gmail.com") == null){
//            List<RoleEntity> list = new ArrayList<>();
//            list.add(roleAdmin);
//
//            UserEntity userEntity = new UserEntity();
//            userEntity.setId(1L);
//            userEntity.setUsername("ADMIN");
//            userEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
//            userEntity.setEmail("admin@gmail.com");
//            userEntity.setEnabled(true);
//            userEntity.setAvatar("avatar-1.jpg");
//            userEntity.setAuthProvider(AuthProvider.LOCAL);
//            userEntity.setRoleEntityList(list);
//
//            userRepository.save(userEntity);
//        }
//        if (userRepository.findByEmail("mentor@gmail.com") == null){
//            List<RoleEntity> list = new ArrayList<>();
//            list.add(roleMentor);
//
//            UserEntity userEntity = new UserEntity();
//            userEntity.setId(2L);
//            userEntity.setUsername("MENTOR");
//            userEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
//            userEntity.setAvatar("avatar-2.jpg");
//            userEntity.setEmail("mentor@gmail.com");
//            userEntity.setEnabled(true);
//            userEntity.setAuthProvider(AuthProvider.LOCAL);
//            userEntity.setRoleEntityList(list);
//
//            userRepository.save(userEntity);
//        }
//        if (userRepository.findByEmail("user@gmail.com") == null){
//            List<RoleEntity> list = new ArrayList<>();
//            list.add(roleUser);
//
//            UserEntity userEntity = new UserEntity();
//            userEntity.setId(3L);
//            userEntity.setUsername("USER");
//            userEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
//            userEntity.setAvatar("avatar-3.jpg");
//            userEntity.setEmail("user@gmail.com");
//            userEntity.setEnabled(true);
//            userEntity.setAuthProvider(AuthProvider.LOCAL);
//            userEntity.setRoleEntityList(list);
//
//            userRepository.save(userEntity);
//        }
//
//
//        if (categoryRepository.findByName("Category 01") == null){
//            categoryRepository.save(new CategoryEntity(1L,"Category 01",null));
//        }
//        if (categoryRepository.findByName("Category 02") == null){
//            categoryRepository.save(new CategoryEntity(2L,"Category 02",null));
//        }
//        if (categoryRepository.findByName("Category 03") == null){
//            categoryRepository.save(new CategoryEntity(3L,"Category 03",null));
//        }
//        if (categoryRepository.findByName("Category 04") == null){
//            categoryRepository.save(new CategoryEntity(4L,"Category 04",null));
//        }
//
//        CategoryEntity category01 = categoryRepository.findByName("Category 01");
//        CategoryEntity category02 = categoryRepository.findByName("Category 02");
//        CategoryEntity category03 = categoryRepository.findByName("Category 03");
//        CategoryEntity category04 = categoryRepository.findByName("Category 04");
//
//
//        if (productRepository.findByName("Product 01") == null){
//            productRepository.save(new ProductEntity(1L,"Product 01","Description 01",1000,800,700,100,"68478586_537058193701522_5255942305512161280_o.jpg",category01,null,null));
//        }
//        if (productRepository.findByName("Product 02") == null){
//            productRepository.save(new ProductEntity(2L,"Product 02","Description 02",1000,800,700,100,"68572433_537059613701380_8975149963965104128_o.jpg",category01,null,null));
//        }
//        if (productRepository.findByName("Product 03") == null){
//            productRepository.save(new ProductEntity(3L,"Product 03","Description 03",1000,800,700,100,"68587275_537059467034728_8400964169939025920_o.jpg",category02,null,null));
//        }
//        if (productRepository.findByName("Product 04") == null){
//            productRepository.save(new ProductEntity(4L,"Product 04","Description 04",1000,800,700,100,"68609958_537059000368108_2475904163444162560_o.jpg",category02,null,null));
//        }
//        if (productRepository.findByName("Product 05") == null){
//            productRepository.save(new ProductEntity(5L,"Product 05","Description 05",1000,800,700,100,"68636746_541616136579061_3601551019403640832_o.jpg",category03,null,null));
//        }
//        if (productRepository.findByName("Product 06") == null){
//            productRepository.save(new ProductEntity(6L,"Product 06","Description 06",1000,800,700,100,"68690759_537765740297434_3055620445123379200_o.jpg",category03,null,null));
//        }
//        if (productRepository.findByName("Product 07") == null){
//            productRepository.save(new ProductEntity(7L,"Product 07","Description 07",1000,800,700,100,"69028894_540991013308240_7731124944515366912_o.jpg",category04,null,null));
//        }
//        if (productRepository.findByName("Product 08") == null){
//            productRepository.save(new ProductEntity(8L,"Product 08","Description 08",1000,800,700,100,"2019_06_10kehoachcuocdoi.u5567.d20170918.t121211.659577.jpg",category04,null,null));
//        }
//
//    }
//}
