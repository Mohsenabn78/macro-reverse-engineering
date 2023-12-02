package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class VersionInfo {

    /* renamed from: a  reason: collision with root package name */
    protected final int f18989a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f18990b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f18991c;

    public VersionInfo(int i4, int i5, int i6) {
        this.f18989a = i4;
        this.f18990b = i5;
        this.f18991c = i6;
    }

    public int getMajorVersion() {
        return this.f18989a;
    }

    public int getMicroVersion() {
        return this.f18991c;
    }

    public int getMinorVersion() {
        return this.f18990b;
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "%d.%d.%d", Integer.valueOf(this.f18989a), Integer.valueOf(this.f18990b), Integer.valueOf(this.f18991c));
    }
}
