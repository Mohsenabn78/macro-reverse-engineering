package com.google.android.gms.ads.internal.client;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzx;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzay {

    /* renamed from: f  reason: collision with root package name */
    private static final zzay f19101f = new zzay();

    /* renamed from: a  reason: collision with root package name */
    private final zzbzk f19102a;

    /* renamed from: b  reason: collision with root package name */
    private final zzaw f19103b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19104c;

    /* renamed from: d  reason: collision with root package name */
    private final zzbzx f19105d;

    /* renamed from: e  reason: collision with root package name */
    private final Random f19106e;

    protected zzay() {
        zzbzk zzbzkVar = new zzbzk();
        zzaw zzawVar = new zzaw(new zzk(), new zzi(), new zzeq(), new zzbgq(), new zzbvz(), new zzbrq(), new zzbgr());
        String zzd = zzbzk.zzd();
        zzbzx zzbzxVar = new zzbzx(0, (int) ModuleDescriptor.MODULE_VERSION, true, false, false);
        Random random = new Random();
        this.f19102a = zzbzkVar;
        this.f19103b = zzawVar;
        this.f19104c = zzd;
        this.f19105d = zzbzxVar;
        this.f19106e = random;
    }

    public static zzaw zza() {
        return f19101f.f19103b;
    }

    public static zzbzk zzb() {
        return f19101f.f19102a;
    }

    public static zzbzx zzc() {
        return f19101f.f19105d;
    }

    public static String zzd() {
        return f19101f.f19104c;
    }

    public static Random zze() {
        return f19101f.f19106e;
    }
}
