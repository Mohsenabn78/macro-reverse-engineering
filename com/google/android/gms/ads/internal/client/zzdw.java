package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdw {

    /* renamed from: g  reason: collision with root package name */
    private Date f19124g;

    /* renamed from: h  reason: collision with root package name */
    private String f19125h;

    /* renamed from: k  reason: collision with root package name */
    private String f19128k;

    /* renamed from: l  reason: collision with root package name */
    private String f19129l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19131n;

    /* renamed from: o  reason: collision with root package name */
    private String f19132o;

    /* renamed from: a  reason: collision with root package name */
    private final HashSet f19118a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f19119b = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f19120c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet f19121d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f19122e = new Bundle();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet f19123f = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private final List f19126i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private int f19127j = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f19130m = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f19133p = 60000;

    @Deprecated
    public final void zzA(int i4) {
        this.f19127j = i4;
    }

    public final void zzB(int i4) {
        this.f19133p = i4;
    }

    @Deprecated
    public final void zzC(boolean z3) {
        this.f19131n = z3;
    }

    public final void zzD(List list) {
        this.f19126i.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                zzbzr.zzj("neighboring content URL should not be null or empty");
            } else {
                this.f19126i.add(str);
            }
        }
    }

    public final void zzE(String str) {
        this.f19128k = str;
    }

    public final void zzF(String str) {
        this.f19129l = str;
    }

    @Deprecated
    public final void zzG(boolean z3) {
        this.f19130m = z3 ? 1 : 0;
    }

    public final void zzp(String str) {
        this.f19123f.add(str);
    }

    public final void zzq(Class cls, Bundle bundle) {
        if (this.f19119b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.f19119b.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        Bundle bundle2 = this.f19119b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        Preconditions.checkNotNull(bundle2);
        bundle2.putBundle(cls.getName(), bundle);
    }

    public final void zzr(String str, String str2) {
        this.f19122e.putString(str, str2);
    }

    public final void zzs(String str) {
        this.f19118a.add(str);
    }

    public final void zzt(Class cls, @Nullable Bundle bundle) {
        this.f19119b.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zzu(NetworkExtras networkExtras) {
        this.f19120c.put(networkExtras.getClass(), networkExtras);
    }

    public final void zzv(String str) {
        this.f19121d.add(str);
    }

    public final void zzw(String str) {
        this.f19121d.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final void zzx(String str) {
        this.f19132o = str;
    }

    @Deprecated
    public final void zzy(Date date) {
        this.f19124g = date;
    }

    public final void zzz(String str) {
        this.f19125h = str;
    }
}
