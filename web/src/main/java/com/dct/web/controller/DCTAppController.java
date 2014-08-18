package com.dct.web.controller;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import com.dct.service.TriangleService;
import com.dct.service.impl.TriangleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DCTAppController {
    TriangleService service = new TriangleServiceImpl();

    /*@Autowired
    public DCTAppController(TriangleService service) {
        this.service = service;
    }*/

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView getHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(value="/service/version", method = RequestMethod.GET)
    public @ResponseBody
    VersionInfo getVersion() {
        VersionInfo version = service.getVersion();
        return version;
    }

    @RequestMapping(value="/service/checkTriangle", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public @ResponseBody
    TriangleResult triangleCheck(@ModelAttribute TriangleData request) {

        boolean checkResult = false;
        try {
            checkResult = service.checkTriangle(request);
        } catch (IllegalArgumentException e) {

        }
        TriangleResult result = new TriangleResult(checkResult);
        return result;
    }
}