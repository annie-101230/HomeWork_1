package com.bibiboom.arithmetic;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Annie
 * @date 2021年05月27日 16:23
 */
@Data
@Component
public class EnterWeChatView {

    public String corpid;
    public String corpsecret;
    public String url;
    public String enterJsapiTicket;
    public String appJsapiTicket;

}
