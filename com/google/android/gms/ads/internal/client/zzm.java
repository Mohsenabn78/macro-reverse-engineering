package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzm {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f19203a = new Bundle();

    /* renamed from: b  reason: collision with root package name */
    private List f19204b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f19205c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f19206d = -1;

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f19207e = new Bundle();

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f19208f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    private final List f19209g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private int f19210h = -1;

    /* renamed from: i  reason: collision with root package name */
    private String f19211i = null;

    /* renamed from: j  reason: collision with root package name */
    private final List f19212j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private int f19213k = 60000;

    public final zzl zza() {
        return new zzl(8, -1L, this.f19203a, -1, this.f19204b, this.f19205c, this.f19206d, false, null, null, null, null, this.f19207e, this.f19208f, this.f19209g, null, null, false, null, this.f19210h, this.f19211i, this.f19212j, this.f19213k, null);
    }

    public final zzm zzb(Bundle bundle) {
        this.f19203a = bundle;
        return this;
    }

    public final zzm zzc(int i4) {
        this.f19213k = i4;
        return this;
    }

    public final zzm zzd(boolean z3) {
        this.f19205c = z3;
        return this;
    }

    public final zzm zze(List list) {
        this.f19204b = list;
        return this;
    }

    public final zzm zzf(String str) {
        this.f19211i = str;
        return this;
    }

    public final zzm zzg(int i4) {
        this.f19206d = i4;
        return this;
    }

    public final zzm zzh(int i4) {
        this.f19210h = i4;
        return this;
    }
}
