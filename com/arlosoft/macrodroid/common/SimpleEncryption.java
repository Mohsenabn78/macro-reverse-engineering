package com.arlosoft.macrodroid.common;

import android.util.Base64;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* loaded from: classes3.dex */
public class SimpleEncryption {

    /* renamed from: a  reason: collision with root package name */
    private SecretKey f10015a;

    public SimpleEncryption() {
        try {
            this.f10015a = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec("B1U2M4P5O6O8P9O1L2O3O5P".getBytes("UTF-8")));
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SimpleEncryption: Failed to generate encryption key: " + e4.getMessage()));
        }
    }

    public String decrypt(String str) throws Exception {
        byte[] decode = Base64.decode(str, 0);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, this.f10015a);
        return new String(cipher.doFinal(decode));
    }

    public String encrypt(String str) throws Exception {
        byte[] bytes = str.getBytes("UTF-8");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, this.f10015a);
        return Base64.encodeToString(cipher.doFinal(bytes), 0);
    }
}
