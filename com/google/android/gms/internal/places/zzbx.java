package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbx implements zzcz {
    private static final zzch zzkf = new zzca();
    private final zzch zzke;

    public zzbx() {
        this(new zzbz(zzba.zzbb(), zzcc()));
    }

    private static boolean zzb(zzci zzciVar) {
        if (zzciVar.zzcj() == zzbc.zze.zzit) {
            return true;
        }
        return false;
    }

    private static zzch zzcc() {
        try {
            return (zzch) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzkf;
        }
    }

    @Override // com.google.android.gms.internal.places.zzcz
    public final <T> zzda<T> zze(Class<T> cls) {
        zzdc.zzg((Class<?>) cls);
        zzci zzc = this.zzke.zzc(cls);
        if (zzc.zzck()) {
            if (zzbc.class.isAssignableFrom(cls)) {
                return zzcq.zzb(zzdc.zzdb(), zzas.zzas(), zzc.zzcl());
            }
            return zzcq.zzb(zzdc.zzcz(), zzas.zzat(), zzc.zzcl());
        } else if (zzbc.class.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzco.zzb(cls, zzc, zzcu.zzco(), zzbu.zzcb(), zzdc.zzdb(), zzas.zzas(), zzcf.zzch());
            }
            return zzco.zzb(cls, zzc, zzcu.zzco(), zzbu.zzcb(), zzdc.zzdb(), (zzar<?>) null, zzcf.zzch());
        } else if (zzb(zzc)) {
            return zzco.zzb(cls, zzc, zzcu.zzcn(), zzbu.zzca(), zzdc.zzcz(), zzas.zzat(), zzcf.zzcg());
        } else {
            return zzco.zzb(cls, zzc, zzcu.zzcn(), zzbu.zzca(), zzdc.zzda(), (zzar<?>) null, zzcf.zzcg());
        }
    }

    private zzbx(zzch zzchVar) {
        this.zzke = (zzch) zzbd.zzb(zzchVar, "messageInfoFactory");
    }
}
