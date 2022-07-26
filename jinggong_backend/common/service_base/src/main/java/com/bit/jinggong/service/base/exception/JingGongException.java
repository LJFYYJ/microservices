package com.bit.jinggong.service.base.exception;

import com.bit.jinggong.common.base.result.ResultCodeEnum;
import lombok.Data;

@Data
public class JingGongException extends RuntimeException {

    //状态码
    private Integer code;

        /**
         * 接受状态码和消息
         * @param code
         * @param message
         */
    public JingGongException(Integer code, String message) {
        super(message);
        this.code=code;
    }

        /**
         * 接收枚举类型
         * @param resultCodeEnum
         */
    public JingGongException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "JingGongException{" +
        "code=" + code +
        ", message=" + this.getMessage() +
        '}';
    }
}
