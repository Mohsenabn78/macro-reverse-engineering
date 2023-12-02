package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzeq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f21526a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21527b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f21528c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Object f21529d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Object f21530e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzet f21531f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeq(zzet zzetVar, int i4, String str, Object obj, Object obj2, Object obj3) {
        this.f21531f = zzetVar;
        this.f21526a = i4;
        this.f21527b = str;
        this.f21528c = obj;
        this.f21529d = obj2;
        this.f21530e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c4;
        long j4;
        char c5;
        long j5;
        zzfi zzm = this.f21531f.f21734a.zzm();
        if (zzm.zzy()) {
            zzet zzetVar = this.f21531f;
            c4 = zzetVar.f21537c;
            if (c4 == 0) {
                if (zzetVar.f21734a.zzf().zzy()) {
                    zzet zzetVar2 = this.f21531f;
                    zzetVar2.f21734a.zzay();
                    zzetVar2.f21537c = 'C';
                } else {
                    zzet zzetVar3 = this.f21531f;
                    zzetVar3.f21734a.zzay();
                    zzetVar3.f21537c = 'c';
                }
            }
            zzet zzetVar4 = this.f21531f;
            j4 = zzetVar4.f21538d;
            if (j4 < 0) {
                zzetVar4.f21734a.zzf().zzh();
                zzetVar4.f21538d = 79000L;
            }
            char charAt = "01VDIWEA?".charAt(this.f21526a);
            zzet zzetVar5 = this.f21531f;
            c5 = zzetVar5.f21537c;
            j5 = zzetVar5.f21538d;
            String str = ExifInterface.GPS_MEASUREMENT_2D + charAt + c5 + j5 + ":" + zzet.g(true, this.f21527b, this.f21528c, this.f21529d, this.f21530e);
            if (str.length() > 1024) {
                str = this.f21527b.substring(0, 1024);
            }
            zzfg zzfgVar = zzm.f21592d;
            if (zzfgVar != null) {
                zzfgVar.zzb(str, 1L);
                return;
            }
            return;
        }
        Log.println(6, this.f21531f.zzr(), "Persisted config not initialized. Not logging error/warn");
    }
}
