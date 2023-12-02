package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzap {

    /* renamed from: a  reason: collision with root package name */
    final String f21465a;

    /* renamed from: b  reason: collision with root package name */
    final String f21466b;

    /* renamed from: c  reason: collision with root package name */
    final String f21467c;

    /* renamed from: d  reason: collision with root package name */
    final long f21468d;

    /* renamed from: e  reason: collision with root package name */
    final long f21469e;

    /* renamed from: f  reason: collision with root package name */
    final zzas f21470f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzap(zzgd zzgdVar, String str, String str2, String str3, long j4, long j5, Bundle bundle) {
        zzas zzasVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.f21465a = str2;
        this.f21466b = str3;
        this.f21467c = true == TextUtils.isEmpty(str) ? null : str;
        this.f21468d = j4;
        this.f21469e = j5;
        if (j5 != 0 && j5 > j4) {
            zzgdVar.zzaA().zzk().zzb("Event created with reverse previous/current timestamps. appId", zzet.f(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzgdVar.zzaA().zzd().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object d4 = zzgdVar.zzv().d(next, bundle2.get(next));
                    if (d4 == null) {
                        zzgdVar.zzaA().zzk().zzb("Param value can't be null", zzgdVar.zzj().e(next));
                        it.remove();
                    } else {
                        zzgdVar.zzv().o(bundle2, next, d4);
                    }
                }
            }
            zzasVar = new zzas(bundle2);
        } else {
            zzasVar = new zzas(new Bundle());
        }
        this.f21470f = zzasVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzap a(zzgd zzgdVar, long j4) {
        return new zzap(zzgdVar, this.f21467c, this.f21465a, this.f21466b, this.f21468d, j4, this.f21470f);
    }

    public final String toString() {
        String str = this.f21465a;
        String str2 = this.f21466b;
        String obj = this.f21470f.toString();
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + obj + "}";
    }

    private zzap(zzgd zzgdVar, String str, String str2, String str3, long j4, long j5, zzas zzasVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzasVar);
        this.f21465a = str2;
        this.f21466b = str3;
        this.f21467c = true == TextUtils.isEmpty(str) ? null : str;
        this.f21468d = j4;
        this.f21469e = j5;
        if (j5 != 0 && j5 > j4) {
            zzgdVar.zzaA().zzk().zzc("Event created with reverse previous/current timestamps. appId, name", zzet.f(str2), zzet.f(str3));
        }
        this.f21470f = zzasVar;
    }
}
