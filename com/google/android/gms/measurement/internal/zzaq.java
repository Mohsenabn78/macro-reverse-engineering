package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzaq {

    /* renamed from: a  reason: collision with root package name */
    final String f21471a;

    /* renamed from: b  reason: collision with root package name */
    final String f21472b;

    /* renamed from: c  reason: collision with root package name */
    final long f21473c;

    /* renamed from: d  reason: collision with root package name */
    final long f21474d;

    /* renamed from: e  reason: collision with root package name */
    final long f21475e;

    /* renamed from: f  reason: collision with root package name */
    final long f21476f;

    /* renamed from: g  reason: collision with root package name */
    final long f21477g;

    /* renamed from: h  reason: collision with root package name */
    final Long f21478h;

    /* renamed from: i  reason: collision with root package name */
    final Long f21479i;

    /* renamed from: j  reason: collision with root package name */
    final Long f21480j;

    /* renamed from: k  reason: collision with root package name */
    final Boolean f21481k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(String str, String str2, long j4, long j5, long j6, long j7, long j8, Long l4, Long l5, Long l6, Boolean bool) {
        boolean z3;
        boolean z4;
        boolean z5;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (j5 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        if (j6 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        Preconditions.checkArgument(j8 >= 0);
        this.f21471a = str;
        this.f21472b = str2;
        this.f21473c = j4;
        this.f21474d = j5;
        this.f21475e = j6;
        this.f21476f = j7;
        this.f21477g = j8;
        this.f21478h = l4;
        this.f21479i = l5;
        this.f21480j = l6;
        this.f21481k = bool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaq a(Long l4, Long l5, Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
        }
        return new zzaq(this.f21471a, this.f21472b, this.f21473c, this.f21474d, this.f21475e, this.f21476f, this.f21477g, this.f21478h, l4, l5, bool);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaq b(long j4, long j5) {
        return new zzaq(this.f21471a, this.f21472b, this.f21473c, this.f21474d, this.f21475e, this.f21476f, j4, Long.valueOf(j5), this.f21479i, this.f21480j, this.f21481k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaq c(long j4) {
        return new zzaq(this.f21471a, this.f21472b, this.f21473c, this.f21474d, this.f21475e, j4, this.f21477g, this.f21478h, this.f21479i, this.f21480j, this.f21481k);
    }
}
