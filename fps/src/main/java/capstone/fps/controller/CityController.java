package capstone.fps.controller;

import capstone.fps.common.Fix;
import capstone.fps.model.district.MdlCity;
import capstone.fps.model.Response;
import capstone.fps.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CityController extends AbstractController {

    private static final String API = Fix.MAP_API + "city";

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping(Fix.MAP_ANY + API)
    public String getCityList() {
        Response<List<MdlCity>> response = new Response<>(Response.STATUS_FAIL, Response.MESSAGE_FAIL);
        try {
            List<MdlCity> mdlCityList = cityService.getCityList();
            response.setResponse(Response.STATUS_SUCCESS, Response.MESSAGE_SUCCESS, mdlCityList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponse(Response.STATUS_SERVER_ERROR, Response.MESSAGE_SERVER_ERROR);
        }
        return gson.toJson(response);
    }
}
