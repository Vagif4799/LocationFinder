package app.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LocationController {

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

}

