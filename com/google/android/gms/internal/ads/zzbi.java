package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbi {
    public final Uri zzb;
    public final List zzf;
    public final zzfsc zzh;
    @Deprecated
    public final List zzi;
    @Nullable
    public final Object zzj;
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    private static final String zzq = Integer.toString(6, 36);
    public static final zzn zza = new zzn() { // from class: com.google.android.gms.internal.ads.zzbg
    };
    @Nullable
    public final String zzc = null;
    @Nullable
    public final zzbb zzd = null;
    @Nullable
    public final zzaq zze = null;
    @Nullable
    public final String zzg = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbi(Uri uri, String str, zzbb zzbbVar, zzaq zzaqVar, List list, String str2, zzfsc zzfscVar, Object obj, zzbh zzbhVar) {
        this.zzb = uri;
        this.zzf = list;
        this.zzh = zzfscVar;
        zzfrz zzfrzVar = new zzfrz();
        if (zzfscVar.size() <= 0) {
            this.zzi = zzfrzVar.zzi();
            this.zzj = null;
            return;
        }
        zzbn zzbnVar = (zzbn) zzfscVar.get(0);
        throw null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbi)) {
            return false;
        }
        zzbi zzbiVar = (zzbi) obj;
        if (this.zzb.equals(zzbiVar.zzb) && zzfj.zzC(null, null) && zzfj.zzC(null, null) && zzfj.zzC(null, null) && this.zzf.equals(zzbiVar.zzf) && zzfj.zzC(null, null) && this.zzh.equals(zzbiVar.zzh) && zzfj.zzC(null, null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzb.hashCode() * 923521) + this.zzf.hashCode()) * 961) + this.zzh.hashCode()) * 31;
    }
}
