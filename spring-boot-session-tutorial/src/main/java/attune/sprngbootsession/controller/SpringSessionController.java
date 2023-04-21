package attune.sprngbootsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SpringSessionController {

    @GetMapping("/")
    public String home(Model model ,HttpSession session){
       @SuppressWarnings("unchecked")
       List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGE");

       if (messages == null) {
           messages = new ArrayList<>();
       }
       model.addAttribute("sessionMessage",messages);

       return "index";
    }

    @PostMapping("/persistMessage")
    public String persistMessage(@RequestParam("param") String msg , HttpServletRequest request) {

        @SuppressWarnings("unchecked")
        List<String> msgs = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGE");
        if (msgs == null){
            msgs = new ArrayList<>();
            request.getSession().setAttribute("MY_SESSION_MESSAGE" ,msg);
        }

        msgs.add(msg);
        request.getSession().setAttribute("MY_SESSION_MESSAGE",msg);
        return "redirect:/";
    }

    @GetMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }
}
