package com.example.restaurant;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.restaurant.admin.admin;
import com.example.restaurant.admin.adminRepo;
import com.example.restaurant.menu.java.food;
import com.example.restaurant.menu.java.foodRepo;
import com.example.restaurant.menu.java.drink.drink;
import com.example.restaurant.menu.java.drink.drinkRepo;
import com.example.restaurant.restaurant.rest;
import com.example.restaurant.restaurant.restRepo;
import com.example.restaurant.user.login;
import com.example.restaurant.user.loginRepo;


@Controller
public class restController {
    @Autowired
    restRepo rr;

    @Autowired
    loginRepo lr;

    @Autowired
    adminRepo ar;

    @Autowired
    foodRepo mr;

    @Autowired
    drinkRepo dr;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/menu")
    public String drink(Model m) {
        List<food> users = mr.findAll();
        for (food food : users) {
            if (food.getImage() != null) {
                String byte64Image = Base64.getEncoder().encodeToString(food.getImage());
                food.setByte64Image(byte64Image);
            }
        }
        m.addAttribute("order", new rest());
        m.addAttribute("menus", mr.findAll());
        List<drink> user = dr.findAll();
        for (drink drink : user) {
            if (drink.getDrinkimage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(drink.getDrinkimage());
                drink.setBase64Image(base64Image);
            }
        }
        m.addAttribute("drinks", new drink());
        m.addAttribute("drinks", dr.findAll());
        return "menu";
    }

        @GetMapping("/usermenu")
    public String userdrink(Model m) {
        List<food> users = mr.findAll();
        for (food food : users) {
            if (food.getImage() != null) {
                String byte64Image = Base64.getEncoder().encodeToString(food.getImage());
                food.setByte64Image(byte64Image);
            }
        }
        m.addAttribute("order", new rest());
        m.addAttribute("menus", mr.findAll());
        List<drink> user = dr.findAll();
        for (drink drink : user) {
            if (drink.getDrinkimage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(drink.getDrinkimage());
                drink.setBase64Image(base64Image);
            }
        }
        m.addAttribute("drinks", new drink());
        m.addAttribute("drinks", dr.findAll());
        return "usermenu";
    }
    @PostMapping("/order")
    public String order(@ModelAttribute("order") rest r, Model m) {
        rr.save(r);
        List<food> users = mr.findAll();
        for (food food : users) {
            if (food.getImage() != null) {
                String byte64Image = Base64.getEncoder().encodeToString(food.getImage());
                food.setByte64Image(byte64Image);
            }
        }
        m.addAttribute("order", new rest());
        m.addAttribute("menus", mr.findAll());
        List<drink> user = dr.findAll();
        for (drink drink : user) {
            if (drink.getDrinkimage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(drink.getDrinkimage());
                drink.setBase64Image(base64Image);
            }
        }
        m.addAttribute("drinks", new drink());
        m.addAttribute("drinks", dr.findAll());
        return "success";
    }

    @GetMapping("/updatefood/{id}")
    public String update(@PathVariable("id") int id, Model m) {
        Optional<food> op = mr.findById(id);
        food f = null;
        if (op.isPresent()) {
            f = op.get();
        } else {
            throw new RuntimeException("data not found = " + id);
        }
        m.addAttribute("foods", f);
        return "update";

    }
     @GetMapping("/updatedrink/{id}")
    public String updatedrinks(@PathVariable("id") int id, Model m) {
        Optional<drink> op = dr.findById(id);
        drink d = null;
        if (op.isPresent()) {
            d = op.get();
        } else {
            throw new RuntimeException("data not found = " + id);
        }
        m.addAttribute("drinks", d);
        return "updatedrink";

    }

    @GetMapping("/view")
    public String view(Model m) {
        m.addAttribute("orders", rr.findAll());
        return "order";
    }

    @GetMapping("/cencel/{id}")
    public String delete(@PathVariable("id") int i) {
        rr.deleteById(i);
        return "redirect:/view";
    }

    // login mapping
    @GetMapping("/login")
    public String login(Model m) {
        m.addAttribute("user", new login());
        return "login";
    }

    @PostMapping("/home")
    public String userhome( @ModelAttribute("users") login l , Model model) {
        l.setDate(LocalDateTime.now());
        lr.save(l);

        return "userhome"; // Return a view to show user details
 
    }
    @GetMapping("/userhome")
    public String userhome(){
        return "userhome";
    }
    @GetMapping("/viewuser")
    public String viewuser(Model m){
        m.addAttribute("users", lr.findAll());
        return "userdata";
    }
      @GetMapping("/delete/{id}")
    public String deleteuser(@PathVariable("id") int i) {
        lr.deleteById(i);
        return "redirect:/viewuser";
    }

    @GetMapping("/logout/{id}")
    public String logout(@PathVariable("id") int i) {
        lr.deleteById(i);
        return "redirect:/";
    }

    // ADMIN
    @GetMapping("/admin")
    public String admin(Model m) {
        m.addAttribute("admin", new admin());
        return "adminlogin";
    }

    @PostMapping("/adminlogin")
    public String adminlogin(@ModelAttribute admin a) {
        ar.save(a);
        return "adminhome";
    }

    // MUNU ADD ON
    @GetMapping("/addmenu")
    public String adddrink(Model m) {
        m.addAttribute("dishes", new food());
        List<food> users = mr.findAll();
        for (food food : users) {
            if (food.getImage() != null) {
                String byte64Image = Base64.getEncoder().encodeToString(food.getImage());
                food.setByte64Image(byte64Image);
            }
        }
        m.addAttribute("menus", mr.findAll());

        m.addAttribute("drinks", new drink());
        List<drink> user = dr.findAll();
        for (drink drink : user) {
            if (drink.getDrinkimage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(drink.getDrinkimage());
                drink.setBase64Image(base64Image);
            }
        }
        m.addAttribute("drinks", dr.findAll());

        return "menuadd";
    }

    @PostMapping("/additems")
    public String addeditems(@ModelAttribute food m, @RequestParam("imageFile") MultipartFile imageFile, Model model)
            throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            m.setImage(imageFile.getBytes());
        }
        mr.save(m);

        model.addAttribute("menus", mr.findAll());
        return "redirect:/addmenu";
    }

    @PostMapping("/adddrink")
    public String adddrink(@ModelAttribute drink d, @RequestParam("dimageFile") MultipartFile dimageFile, Model m)
            throws IOException {
        if (dimageFile != null && !dimageFile.isEmpty()) {
            d.setDrinkimage(dimageFile.getBytes());
        }
        dr.save(d);

        m.addAttribute("drinks", dr.findAll());
        return "redirect:/addmenu";
    }

  

    @GetMapping("/deletefood/{id}")
    public String deletefood(@PathVariable("id") int i) {
        mr.deleteById(i);
        return "redirect:/addmenu";
    }

    @GetMapping("/deletedrink/{id}")
    public String deletedrink(@PathVariable("id") int i) {
        dr.deleteById(i);
        return "redirect:/addmenu";
    }
   

    @GetMapping("/adminhome")
    public String ahome() {
        return "adminhome";
    }

}
