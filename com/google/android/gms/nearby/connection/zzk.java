package com.google.android.gms.nearby.connection;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzk {

    /* renamed from: a  reason: collision with root package name */
    private String f22241a;

    /* renamed from: b  reason: collision with root package name */
    private String f22242b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f22243c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f22244d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22245e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f22246f;

    /* renamed from: g  reason: collision with root package name */
    private int f22247g = 0;

    public final zzk zza(int i4) {
        this.f22247g = i4;
        return this;
    }

    @Deprecated
    public final zzk zzb(String str) {
        this.f22242b = str;
        return this;
    }

    public final zzk zzc(byte[] bArr) {
        this.f22246f = bArr;
        return this;
    }

    public final zzk zzd(String str) {
        this.f22241a = str;
        return this;
    }

    @Deprecated
    public final zzk zze(boolean z3) {
        this.f22245e = z3;
        return this;
    }

    public final zzk zzf(boolean z3) {
        this.f22244d = z3;
        return this;
    }

    public final zzk zzg(byte[] bArr) {
        this.f22243c = bArr;
        return this;
    }

    public final ConnectionInfo zzh() {
        return new ConnectionInfo(this.f22241a, this.f22242b, this.f22243c, this.f22244d, this.f22245e, this.f22246f, this.f22247g);
    }
}
