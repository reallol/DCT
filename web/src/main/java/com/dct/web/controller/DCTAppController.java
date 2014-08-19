package com.dct.web.controller;

import com.dct.client.DCTClient;
import com.dct.client.impl.DCTClientImpl;
import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DCTAppController {
    DCTClient client = new DCTClientImpl();

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView getHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(value="/service/version", method = RequestMethod.GET)
    public @ResponseBody
    VersionInfo getVersion() {
        VersionInfo version = client.getVersionInfo();
        return version;
    }

    @RequestMapping(value="/service/checkTriangle", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public @ResponseBody
    TriangleResult triangleCheck(@ModelAttribute TriangleData request) {
        TriangleResult result = client.checkTriangle(request);
        return result;
    }
}