package com.dct.web.controller;

import com.dct.client.DCTClient;
import com.dct.client.impl.DCTClientImpl;
import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import com.dct.model.exceptions.DCTClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DCTAppController {
    private final static Logger logger = LoggerFactory.getLogger(DCTAppController.class);

    DCTClient client = new DCTClientImpl();

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView getHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(value="/service/version", method = RequestMethod.GET)
    public @ResponseBody VersionInfo getVersion() {
        VersionInfo version = client.getVersionInfo();
        return version;
    }

    @RequestMapping(value="/service/checkTriangle", method = RequestMethod.POST)
    public @ResponseBody TriangleResult triangleCheck(@ModelAttribute TriangleData request) {
        TriangleResult result = null;
        try {
            result = client.checkTriangle(request);
        } catch (DCTClientException e) {
            logger.error("Error while proceeding POST request for triangle existance");
            e.printStackTrace();
        }
        return result;
    }
}