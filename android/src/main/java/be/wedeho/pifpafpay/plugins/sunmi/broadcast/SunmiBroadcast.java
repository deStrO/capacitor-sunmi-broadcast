package be.wedeho.pifpafpay.plugins.sunmi.broadcast;

import com.getcapacitor.Logger;

public class SunmiBroadcast {

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }
}
