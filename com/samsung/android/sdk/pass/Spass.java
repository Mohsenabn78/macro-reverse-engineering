package com.samsung.android.sdk.pass;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;

/* loaded from: classes6.dex */
public class Spass implements SsdkInterface {
    public static final int DEVICE_FINGERPRINT = 0;
    public static final int DEVICE_FINGERPRINT_AVAILABLE_PASSWORD = 4;
    public static final int DEVICE_FINGERPRINT_CUSTOMIZED_DIALOG = 2;
    public static final int DEVICE_FINGERPRINT_FINGER_INDEX = 1;
    public static final int DEVICE_FINGERPRINT_UNIQUE_ID = 3;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f37371a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f37372b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f37373c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f37374d = false;

    /* renamed from: e  reason: collision with root package name */
    private Context f37375e;

    @Override // com.samsung.android.sdk.SsdkInterface
    public int getVersionCode() {
        return 12;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public String getVersionName() {
        return "1.2.6";
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public void initialize(Context context) throws SsdkUnsupportedException {
        if (this.f37375e != null) {
            return;
        }
        if (context != null) {
            if (SsdkVendorCheck.isSamsungDevice()) {
                try {
                    boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.sec.feature.fingerprint_manager_service");
                    f37371a = hasSystemFeature;
                    if (hasSystemFeature) {
                        SpassFingerprint spassFingerprint = new SpassFingerprint(context);
                        f37373c = SpassFingerprint.a();
                        f37372b = spassFingerprint.b();
                        f37374d = spassFingerprint.c();
                        this.f37375e = context;
                        Log.i(SpassFingerprint.TAG, "initialize : BP=" + f37374d + ",CD=" + f37373c + ",ID=" + f37372b + ",GT=false");
                        SpassFingerprint.a(context, null);
                        return;
                    }
                    throw new SsdkUnsupportedException("This device does not provide FingerprintService.", 1);
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("context is not valid.");
                }
            }
            throw new SsdkUnsupportedException("This is not Samsung device.", 0);
        }
        throw new IllegalArgumentException("context passed is null.");
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public boolean isFeatureEnabled(int i4) {
        if (this.f37375e != null) {
            if (i4 != 0) {
                if (i4 != 1 && i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            return f37374d;
                        }
                        throw new IllegalArgumentException("type passed is not valid");
                    }
                    return f37372b;
                }
                return f37373c;
            }
            return f37371a;
        }
        throw new IllegalStateException("initialize() is not Called first.");
    }
}
