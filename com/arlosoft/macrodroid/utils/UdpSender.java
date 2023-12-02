package com.arlosoft.macrodroid.utils;

import android.content.Context;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* loaded from: classes3.dex */
public class UdpSender {
    private void b(Context context, String str) {
        SystemLog.logInfo("UDP Send failed: " + str);
        if (Settings.getNotifyOnUDPFailure(context)) {
            Util.displayNotification(context, context.getString(R.string.udp_failed), str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, byte[] bArr, int i4, Context context) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            DatagramSocket datagramSocket = new DatagramSocket();
            if (!datagramSocket.getBroadcast()) {
                datagramSocket.setBroadcast(true);
            }
            datagramSocket.send(new DatagramPacket(bArr, bArr.length, byName, i4));
            datagramSocket.close();
        } catch (Exception e4) {
            b(context, e4.toString());
        }
    }

    public void SendTo(final Context context, final String str, final int i4, String str2) {
        if (str2 == null) {
            b(context, "empty message");
        }
        byte[] bytes = str2.getBytes();
        if (str2.startsWith("\\0x")) {
            bytes = str2.replace("\\0x", "0x").getBytes();
        } else if (str2.startsWith("0x")) {
            String replace = str2.replace("0x", "");
            if (!replace.matches("[a-fA-F0-9]+")) {
                b(context, "Invalid Message Format");
                return;
            }
            bytes = m.a(replace);
        }
        final byte[] bArr = bytes;
        SystemLog.logInfo("Sending UDP to " + str + ":" + i4);
        new Thread(new Runnable() { // from class: com.arlosoft.macrodroid.utils.v
            @Override // java.lang.Runnable
            public final void run() {
                UdpSender.this.c(str, bArr, i4, context);
            }
        }).start();
    }
}
