package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaqr extends zzaqq {
    protected zzaqr(Context context, String str, boolean z3) {
        super(context, str, z3);
    }

    public static zzaqr zzt(String str, Context context, boolean z3) {
        zzaqq.zzr(context, false);
        return new zzaqr(context, str, false);
    }

    @Deprecated
    public static zzaqr zzu(String str, Context context, boolean z3, int i4) {
        zzaqq.zzr(context, z3);
        return new zzaqr(context, str, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzaqq
    protected final List zzp(zzart zzartVar, Context context, zzanq zzanqVar, zzanj zzanjVar) {
        if (zzartVar.zzk() != null && ((zzaqq) this).zzu) {
            int zza = zzartVar.zza();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(super.zzp(zzartVar, context, zzanqVar, null));
            arrayList.add(new zzasl(zzartVar, "sjJJMjdJ4ejENjGN3VSKrjMe8gO2ipNVGbEWPt320LzidWuv9Vye4oanMfYCO4eP", "M+JigCCNgE9WH1drVXVCETLYEk7iaWPFwZXUH8JlEbE=", zzanqVar, zza, 24));
            return arrayList;
        }
        return super.zzp(zzartVar, context, zzanqVar, null);
    }
}
