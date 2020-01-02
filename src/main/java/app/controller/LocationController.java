package app.controller;

        import app.model.Location;
        import app.service.LocationService;
        import app.util.EmailUtil;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.List;
        import java.util.Optional;


@Controller
public class LocationController {

    @Autowired
    LocationService service;

    @Autowired
    EmailUtil emailUtil;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location")Location location, ModelMap modelMap) {
        Location locationSaved = service.saveLocation(location);
        String msg = "Location saved with id: " + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        emailUtil.sendEmail("vagif.dev@gmail.com", "Location Saved", "Location Saved Successfully and about return a response.");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> allLocations = service.getAllLocations();
        modelMap.addAttribute("locations", allLocations);
        return "displayLocations";
    }

    @RequestMapping("deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Location> location = service.getLocationById(id);
        Location location1 = location.get();
        service.deleteLocation(location1);
        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Location> location = service.getLocationById(id);
        Location location1 = location.get();
        modelMap.addAttribute("location", location1);
        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location")Location location, ModelMap modelMap) {
        service.updateLocation(location);
        List<Location> allLocations = service.getAllLocations();
        modelMap.addAttribute("locations", allLocations);
        return "displayLocations";
    }

}

