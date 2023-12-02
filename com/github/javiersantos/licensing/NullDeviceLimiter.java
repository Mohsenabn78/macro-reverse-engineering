package com.github.javiersantos.licensing;

/* loaded from: classes3.dex */
public class NullDeviceLimiter implements DeviceLimiter {
    @Override // com.github.javiersantos.licensing.DeviceLimiter
    public int isDeviceAllowed(String str) {
        return Policy.LICENSED;
    }
}
