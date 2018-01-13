package com.yunsle.bookshop.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunsle.bookshop.entity.Book;
import com.yunsle.bookshop.entity.StatusMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Doublestar on 2018/1/13 11:51).
 */
@Component
public class JsonUtil {

    /**
     * 对BookList进行Jsonu化
     * @param data
     * @return
     */
    public StatusMessage toJson(List<?> data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(data);
            return new StatusMessage(200, "success", json);
        } catch(Exception e) {
            return new StatusMessage(200, "error", "错误:"+e);
        }
    }

}
