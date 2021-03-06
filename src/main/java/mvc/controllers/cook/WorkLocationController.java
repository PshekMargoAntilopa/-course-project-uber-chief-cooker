package mvc.controllers.cook;


import mvc.entity.location.Town;
import mvc.model.DistrictDto;
import mvc.service.user.CookService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//todo
@Controller
public class WorkLocationController {

    private final CookService cookService;

    public WorkLocationController(CookService cookService) {
        this.cookService = cookService;
    }

    @GetMapping(value = "/location")
    public String getCookWorkLocationPage() {
        return "cook/location";
    }

    @PostMapping(value = "/getCookDistrictsByTown")
    @ResponseBody
    public List<DistrictDto> getSortedDistrictDtoListByTown(@RequestBody Town town, @AuthenticationPrincipal UserDetails currentUser) {
        return cookService.getSortedDistrictCookDtoListByTown(town, cookService.getAuthenticationCook(currentUser).getId());
    }


    @PostMapping(value = "/getCookDistricts")
    @ResponseBody
    public List<DistrictDto> getCookWorkLocation(@AuthenticationPrincipal UserDetails currentUser) {
        return cookService.readCookLocation(cookService.getAuthenticationCook(currentUser).getId());
    }


    @PostMapping(value = "/saveCookDistricts")
    public String saveCookDistricts(@RequestBody List<DistrictDto> dtoList, @AuthenticationPrincipal UserDetails currentUser) {
        cookService.updateDistricts(cookService.getAuthenticationCook(currentUser).getId(), dtoList);
        return "cook/startCook";
    }

}
