/*  package nl.framework.applicatie.api;

import nl.framework.applicatie.persist.LoginPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginPageEndpoint {

    private final LoginPageService loginPageService;

    @Autowired
    public LoginPageEndpoint(LoginPageService loginPageService) {
        this.loginPageService = loginPageService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Returns the name of the Thymeleaf template (login.html)
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {
        boolean authenticated = loginPageService.authenticate(username, password);
        if (authenticated) {
            // Perform login logic, e.g., store user information in session
            session.setAttribute("username", username);
            return "redirect:/index"; // Redirect to the index page
        } else {
            model.addAttribute("errorMessage", "Login failed. Invalid credentials.");
            return "login"; // Return to the login page with an error message
        }
    }
}
*/