package cn.stevekung.utils;

import cn.stevekung.dto.ResultDTO;

/**
 * ResultUtil工具类可以快速的获得一个ResultDTO
 */
public class ResultUtil {
    public static <T>ResultDTO<T> successResult(T t, String msg){
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setResult(true);
        resultDTO.setMessage(msg);
        resultDTO.setData(t);
        return resultDTO;
    }
    public static <T>ResultDTO<T> errorResult(T t, String msg){
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setResult(false);
        resultDTO.setMessage(msg);
        resultDTO.setData(t);
        return resultDTO;
    }

    public static <T>ResultDTO<T> successResult(T t){
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setResult(true);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        return resultDTO;
    }
    public static <T>ResultDTO<T> errorResult(T t){
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setResult(false);
        resultDTO.setMessage("请求失败");
        resultDTO.setData(t);
        return resultDTO;
    }

    public static ResultDTO successResult(String msg){
        ResultDTO resultDTO = new ResultDTO<>();
        resultDTO.setResult(true);
        resultDTO.setMessage(msg);
        return resultDTO;
    }
    public static ResultDTO errorResult(String msg){
        ResultDTO resultDTO = new ResultDTO<>();
        resultDTO.setResult(false);
        resultDTO.setMessage(msg);
        return resultDTO;
    }
}
