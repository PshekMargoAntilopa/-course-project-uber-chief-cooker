package mvc.controllers;


import mvc.entity.user.Cook;
import mvc.model.PersonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserSingInController {



    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginError", false);
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping("/signIn")
    public String singIn(@ModelAttribute Cook user, Model model) {
        return "login";
    }

    @ModelAttribute
    public void getAllDishTypes(Model model){
        model.addAttribute("user", new PersonDto());
    }


}
