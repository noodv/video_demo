package com.example.springbootresttemplate.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.codehaus.jackson.map.ObjectMapper;
import java.net.URI;
import java.util.Map;

@Log4j2
@Service
public class RestTemplateService
{

    @Autowired
    private RestTemplate restTemplate;

    /**
     * * HTTP 请求工具类
     * *
     * * @author Simon
     * * @date 2018年7月23日
     */
    private RestTemplateService()
    {
    }

    /**
     * post 请求封装
     *
     * @param value
     * @param URL
     * @return
     */
    public JSONObject post(final Object value, final String URL)
    {
        if (!StringUtils.isNotBlank(URL))
        {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Inclusion.NON_EMPTY);
        String requestJson = null;
        try
        {
            requestJson = objectMapper.writeValueAsString(value);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        log.info("requestJson:{}", requestJson);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        log.info("URL:{}", URL);
        ResponseEntity<String> response = null;
        try
        {
            response = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);
            Integer code = response.getStatusCode().value();
            if (200 != code)
            {
                System.out.println("异常");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        JSONObject body = new JSONObject().parseObject(response.getBody());
        log.info("body:{}", body);
        return body;
    }

    /**
     * get请求封装
     *
     * @param uriComponents
     * @return
     */
    public JSONObject get(final UriComponents uriComponents)
    {
        if (null == uriComponents)
        {
            return null;
        }
        URI uri = uriComponents.toUri();
        log.info(uri.toString());
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        Integer code = response.getStatusCode().value();
        if (200 != code)
        {
            System.out.println("异常");
        }
        JSONObject body = new JSONObject().parseObject(response.getBody());
        log.info("body:{}", body);
        return body;
    }

    /**
     * delete请求封装
     * @param URL
     * @param map
     * @return
     */
    public JSONObject delete(final String URL, final Map<String, Object> map)
    {
        if (!StringUtils.isNotBlank(URL))
        {
            return null;
        }
        log.info("URL:{}", URL);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.DELETE, entity, String.class, map);
        Integer code = response.getStatusCode().value();
        if (200 != code)
        {
            System.out.println("异常");
        }
        JSONObject body = new JSONObject().parseObject(response.getBody());
        log.info("body:{}", body);
        return body;
    }

    public JSONObject postFile(MultiValueMap param, String URL)
    {
        if (!StringUtils.isNotBlank(URL))
        {
            return null;
        }
        String recv = restTemplate.postForObject(URL, param, String.class);
        JSONObject body = new JSONObject().parseObject(recv);
        return body;
    }

}
