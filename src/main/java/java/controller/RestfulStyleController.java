package java.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import java.util.HashMap;
import java.util.Map;

import static com.taobao.api.internal.toplink.endpoint.MessageType.HeaderType.Token;

@RestController
@RequestMapping(value = "/xxx/xxx", produces = "application/json;charset=utf-8")
@Api(value = "xxx", description = "xxxx")
public class RestfulStyleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestfulStyleController.class);

//    @Autowired
//    private java.service.MyService service;
//
//    @RequestMapping(value = "/XXXX/XXXX", method = RequestMethod.POST)
//    @ApiOperation(value = "XXXXXXX")
//    public Map<String, Object> xxxxx(
//            @ApiParam(name = "XXXXXX", required = true) @RequestBody java.bean.ParamsBean paramsBean) {
//        Map<String, Object> result = new HashMap<>(2, 1);
//        try {
//            result.put("content", "");
//            result.put("status", "1");
//        } catch (Exception e) {
//            result.put("message", e.getMessage());
//            result.put("status", "0");
//            LOGGER.error(e.getMessage(), e);
//        }
//        return result;
//    }

    @RequestMapping(value = "/xxx/xxx/{xxx}", method = RequestMethod.GET)
    @ApiOperation("xxxxxxx")
    public Map<String, Object> xxxxxx(
            @ApiParam(required = true, name = "brand") @PathVariable String[] xxx) {
        Map<String, Object> result = new HashMap<>(2, 1);
        try {
            //result.put("content", service.getConfigThemeHead(brand));
            result.put("status", "1");
        } catch (Exception e) {
            result.put("message", e.getMessage());
            result.put("status", "0");
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

   // @RequestMapping(value = "/xxxxx")
   // @Token(save=true)
//    public ModelAndView toGenInventory(HttpServletRequest request, @Valid ParamsBean paramsBean) {
//        //Map<String, String> brandMap = service.getxxxxxx();
//        return new ModelAndView("/inventory/genInventory")
//                .addObject("brandMap", brandMap).addObject("productCategoryMap", mobileGeneralizeService.getProductCategoryMap());
//    }

}
