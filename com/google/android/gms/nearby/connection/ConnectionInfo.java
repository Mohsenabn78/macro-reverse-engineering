package com.google.android.gms.nearby.connection;

import androidx.annotation.NonNull;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class ConnectionInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f22145a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22146b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f22147c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22148d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f22149e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f22150f;

    /* renamed from: g  reason: collision with root package name */
    private final int f22151g;

    private ConnectionInfo(String str, String str2, byte[] bArr, boolean z3, boolean z4, byte[] bArr2, int i4) {
        this.f22145a = str;
        this.f22146b = str2;
        this.f22147c = bArr;
        this.f22148d = z3;
        this.f22149e = z4;
        this.f22150f = bArr2;
        this.f22151g = i4;
    }

    @NonNull
    public String getAuthenticationDigits() {
        int i4 = 0;
        int i5 = 1;
        for (byte b4 : this.f22147c) {
            i5 = (i5 * 31) % 9973;
            i4 = (i4 + (b4 * i5)) % 9973;
        }
        return String.format(Locale.US, "%04d", Integer.valueOf(Math.abs(i4)));
    }

    public int getAuthenticationStatus() {
        return this.f22151g;
    }

    @NonNull
    @Deprecated
    public String getAuthenticationToken() {
        return this.f22146b;
    }

    @NonNull
    public byte[] getEndpointInfo() {
        return this.f22150f;
    }

    @NonNull
    public String getEndpointName() {
        return this.f22145a;
    }

    @NonNull
    public byte[] getRawAuthenticationToken() {
        return this.f22147c;
    }

    @Deprecated
    public boolean isConnectionVerified() {
        return this.f22149e;
    }

    public boolean isIncomingConnection() {
        return this.f22148d;
    }

    @Deprecated
    public ConnectionInfo(@NonNull String str, @NonNull String str2, boolean z3) {
        this(str, str2, str2.getBytes(), z3, false, str.getBytes(), 0);
    }
}
