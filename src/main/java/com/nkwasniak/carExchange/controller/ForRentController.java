package com.nkwasniak.carExchange.controller;

import com.nkwasniak.carExchange.dto.ForRentDTO;
import com.nkwasniak.carExchange.dto.mapper.DataMapper;
import com.nkwasniak.carExchange.money.Currency;
import com.nkwasniak.carExchange.service.ForRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.nkwasniak.carExchange.service.implementation.UserDetailsServiceImpl.activeUserId;

@Controller
@RequestMapping("/")
public class ForRentController {
    @Autowired
    private ForRentService forRentService;

    @Autowired
    private DataMapper dataMapper;

    @GetMapping(path = "all-forrent")
    public ModelAndView getAllForRentUserAds() {
        ModelAndView modelAndView = new ModelAndView("allforrent");
        modelAndView.addObject("forrentAds", getAllForRentDTOList());
        return modelAndView;
    }

    @GetMapping(path = "user-forrent")
    public ModelAndView getForRentAds() {
        ModelAndView modelAndView = new ModelAndView("userforrent");
        modelAndView.addObject("forrentAds", getForRentDTOList());
        return modelAndView;
    }

    @GetMapping("add-forrent")
    public ModelAndView forRentForm() {
        ModelAndView model = new ModelAndView("addforrent");
        model.addObject("enumValues", Currency.values());
        return model;
    }

    @PostMapping("add-forrent")
    public ModelAndView forRentAdd(@Valid @ModelAttribute("forRent") ForRentDTO forRentDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }
        try {
            forRentService.saveForRent(dataMapper.convertToEntity(forRentDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView model = new ModelAndView("allforrent");
        model.addObject("forrentAds", getAllForRentDTOList());
        return model;
    }


    @GetMapping(path = "/edit-{adsId}")
    public ModelAndView editForRent(@PathVariable Long adsId) {
        ForRentDTO forRentDTO = dataMapper.convertToDto(forRentService.findByAdsId(adsId));

        ModelAndView model = new ModelAndView("editforrent");
        model.addObject("enumValues", Currency.values());
        model.addObject("forRent", forRentDTO);
        model.addObject("adsId", adsId);

        return model;
    }

    @PostMapping(path = "/edit-{adsId}")
    public ModelAndView updateUser(@Valid @ModelAttribute("forRent") ForRentDTO editForRentDto, @PathVariable Long adsId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        try {
            forRentService.updateForRentAd(
                    dataMapper.convertToEntity(editForRentDto),
                    adsId
            );
        } catch (Exception e) {
            return new ModelAndView("error");
        }

        ModelAndView model = new ModelAndView("userforrent");
        model.addObject("forrentAds", getForRentDTOList());
        return model;
    }


    @GetMapping("/delete-{adsId}")
    public ModelAndView deleteForRent(@PathVariable Long adsId) {
        forRentService.deleteByAdsId(adsId);

        ModelAndView model = new ModelAndView("userforrent");
        model.addObject("forrentAds", getForRentDTOList());
        return model;
    }

    private List<ForRentDTO> getForRentDTOList() {
        return forRentService.findAllByUserId(activeUserId).stream()
                .map(forRent -> dataMapper.convertToDto(forRent))
                .collect(Collectors.toList());
    }

    private List<ForRentDTO> getAllForRentDTOList() {
        return forRentService.findAll().stream()
                .map(forRent -> dataMapper.convertToDto(forRent))
                .collect(Collectors.toList());
    }
}
