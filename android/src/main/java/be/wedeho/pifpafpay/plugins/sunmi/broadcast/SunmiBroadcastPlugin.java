package be.wedeho.pifpafpay.plugins.sunmi.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Base64;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SunmiBroadcast")
public class SunmiBroadcastPlugin extends Plugin {
    private BroadcastReceiver receiver;

    @Override
    public void load() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED");

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ctx, Intent intent) {
                if (intent == null) return;
                if (!"com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED".equals(intent.getAction())) return;

                JSObject payload = new JSObject();
                payload.put("action", intent.getAction());
                payload.put("data", intent.getStringExtra("data"));

                byte[] bytes = intent.getByteArrayExtra("source_byte");
                if (bytes != null) {
                    String b64 = Base64.encodeToString(bytes, Base64.NO_WRAP);
                    payload.put("source_byte_base64", b64);
                }

                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String key : extras.keySet()) {
                        if (!payload.has(key)) {
                            Object value = extras.get(key);
                            payload.put(key, value);
                        }
                    }
                }

                notifyListeners("sunmiScan", payload, true);
            }
        };

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            getContext().registerReceiver(receiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            getContext().registerReceiver(receiver, filter);
        }
    }

    @Override
    protected void handleOnDestroy() {
        if (receiver != null) {
            try {
                getContext().unregisterReceiver(receiver);
            } catch (IllegalArgumentException ignore) {}
            receiver = null;
        }
        super.handleOnDestroy();
    }
}
