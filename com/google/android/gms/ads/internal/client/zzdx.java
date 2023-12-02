package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzbzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdx {

    /* renamed from: a  reason: collision with root package name */
    private final Date f19134a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19135b;

    /* renamed from: c  reason: collision with root package name */
    private final List f19136c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19137d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f19138e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f19139f;

    /* renamed from: g  reason: collision with root package name */
    private final Map f19140g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19141h;

    /* renamed from: i  reason: collision with root package name */
    private final String f19142i;
    @Nullable
    @NotOnlyInitialized

    /* renamed from: j  reason: collision with root package name */
    private final SearchAdRequest f19143j;

    /* renamed from: k  reason: collision with root package name */
    private final int f19144k;

    /* renamed from: l  reason: collision with root package name */
    private final Set f19145l;

    /* renamed from: m  reason: collision with root package name */
    private final Bundle f19146m;

    /* renamed from: n  reason: collision with root package name */
    private final Set f19147n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f19148o;

    /* renamed from: p  reason: collision with root package name */
    private final String f19149p;

    /* renamed from: q  reason: collision with root package name */
    private final int f19150q;

    public zzdx(zzdw zzdwVar, @Nullable SearchAdRequest searchAdRequest) {
        Date date;
        String str;
        List list;
        int i4;
        HashSet hashSet;
        Bundle bundle;
        HashMap hashMap;
        String str2;
        String str3;
        int i5;
        HashSet hashSet2;
        Bundle bundle2;
        HashSet hashSet3;
        boolean z3;
        String str4;
        int i6;
        date = zzdwVar.f19124g;
        this.f19134a = date;
        str = zzdwVar.f19125h;
        this.f19135b = str;
        list = zzdwVar.f19126i;
        this.f19136c = list;
        i4 = zzdwVar.f19127j;
        this.f19137d = i4;
        hashSet = zzdwVar.f19118a;
        this.f19138e = Collections.unmodifiableSet(hashSet);
        bundle = zzdwVar.f19119b;
        this.f19139f = bundle;
        hashMap = zzdwVar.f19120c;
        this.f19140g = Collections.unmodifiableMap(hashMap);
        str2 = zzdwVar.f19128k;
        this.f19141h = str2;
        str3 = zzdwVar.f19129l;
        this.f19142i = str3;
        this.f19143j = searchAdRequest;
        i5 = zzdwVar.f19130m;
        this.f19144k = i5;
        hashSet2 = zzdwVar.f19121d;
        this.f19145l = Collections.unmodifiableSet(hashSet2);
        bundle2 = zzdwVar.f19122e;
        this.f19146m = bundle2;
        hashSet3 = zzdwVar.f19123f;
        this.f19147n = Collections.unmodifiableSet(hashSet3);
        z3 = zzdwVar.f19131n;
        this.f19148o = z3;
        str4 = zzdwVar.f19132o;
        this.f19149p = str4;
        i6 = zzdwVar.f19133p;
        this.f19150q = i6;
    }

    @Deprecated
    public final int zza() {
        return this.f19137d;
    }

    public final int zzb() {
        return this.f19150q;
    }

    public final int zzc() {
        return this.f19144k;
    }

    @Nullable
    public final Bundle zzd(Class cls) {
        Bundle bundle = this.f19139f.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zze() {
        return this.f19146m;
    }

    @Nullable
    public final Bundle zzf(Class cls) {
        return this.f19139f.getBundle(cls.getName());
    }

    public final Bundle zzg() {
        return this.f19139f;
    }

    @Nullable
    @Deprecated
    public final NetworkExtras zzh(Class cls) {
        return (NetworkExtras) this.f19140g.get(cls);
    }

    @Nullable
    public final SearchAdRequest zzi() {
        return this.f19143j;
    }

    @Nullable
    public final String zzj() {
        return this.f19149p;
    }

    public final String zzk() {
        return this.f19135b;
    }

    public final String zzl() {
        return this.f19141h;
    }

    public final String zzm() {
        return this.f19142i;
    }

    @Deprecated
    public final Date zzn() {
        return this.f19134a;
    }

    public final List zzo() {
        return new ArrayList(this.f19136c);
    }

    public final Set zzp() {
        return this.f19147n;
    }

    public final Set zzq() {
        return this.f19138e;
    }

    @Deprecated
    public final boolean zzr() {
        return this.f19148o;
    }

    public final boolean zzs(Context context) {
        RequestConfiguration zzc = zzej.zzf().zzc();
        zzay.zzb();
        String zzy = zzbzk.zzy(context);
        if (!this.f19145l.contains(zzy) && !zzc.getTestDeviceIds().contains(zzy)) {
            return false;
        }
        return true;
    }
}
