package com.google.firebase.remoteconfig.internal;

import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;

/* loaded from: classes5.dex */
public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {

    /* renamed from: a  reason: collision with root package name */
    private final String f32021a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32022b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfigValueImpl(String str, int i4) {
        this.f32021a = str;
        this.f32022b = i4;
    }

    private String a() {
        return asString().trim();
    }

    private void b() {
        if (this.f32021a != null) {
            return;
        }
        throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public boolean asBoolean() throws IllegalArgumentException {
        if (this.f32022b == 0) {
            return false;
        }
        String a4 = a();
        if (ConfigGetParameterHandler.f31964e.matcher(a4).matches()) {
            return true;
        }
        if (ConfigGetParameterHandler.f31965f.matcher(a4).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", a4, "boolean"));
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public byte[] asByteArray() {
        if (this.f32022b == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        return this.f32021a.getBytes(ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public double asDouble() {
        if (this.f32022b == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        String a4 = a();
        try {
            return Double.valueOf(a4).doubleValue();
        } catch (NumberFormatException e4) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", a4, "double"), e4);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public long asLong() {
        if (this.f32022b == 0) {
            return 0L;
        }
        String a4 = a();
        try {
            return Long.valueOf(a4).longValue();
        } catch (NumberFormatException e4) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", a4, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_LONG), e4);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public String asString() {
        if (this.f32022b == 0) {
            return "";
        }
        b();
        return this.f32021a;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public int getSource() {
        return this.f32022b;
    }
}
