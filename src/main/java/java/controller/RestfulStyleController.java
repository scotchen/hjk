package java.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    @Autowired
    private RestTemplate restTemplate;

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


    /**
     * 调用其他接口，返回来的json数据，以往还需要额外转化成bean对象 使用rest的方式  就自动转换成bean对象进行了返回。
     * @param request
     * @return
     */
    @RequestMapping(value = "xxx/xxxxx")
    //@ApiOperation(value = "xxx", notes = SwaggerDocument.GET_ACCOUNT_OPERATE, position = 1)
    public Map<String,Object> xxxx(
            HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>(2, 1);
        try{
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            MultiValueMap<String, Object> reqParam = new LinkedMultiValueMap<>();
            String url ="xxxxxxxx"+1+"/"+20;
            Object  storeVO = restTemplate.getForObject(url, Object.class);//可直接写bean对象
            //restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Object>() {}).getBody();
            result.put("status", 1);
        }catch (Exception e){
            result.put("message", e.getMessage());
            result.put("status", 0);
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
