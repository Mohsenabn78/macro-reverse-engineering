package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzhi {

    /* renamed from: a  reason: collision with root package name */
    final Context f21766a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    String f21767b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    String f21768c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    String f21769d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    Boolean f21770e;

    /* renamed from: f  reason: collision with root package name */
    long f21771f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    com.google.android.gms.internal.measurement.zzcl f21772g;

    /* renamed from: h  reason: collision with root package name */
    boolean f21773h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    final Long f21774i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    String f21775j;

    @VisibleForTesting
    public zzhi(Context context, @Nullable com.google.android.gms.internal.measurement.zzcl zzclVar, @Nullable Long l4) {
        this.f21773h = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f21766a = applicationContext;
        this.f21774i = l4;
        if (zzclVar != null) {
            this.f21772g = zzclVar;
            this.f21767b = zzclVar.zzf;
            this.f21768c = zzclVar.zze;
            this.f21769d = zzclVar.zzd;
            this.f21773h = zzclVar.zzc;
            this.f21771f = zzclVar.zzb;
            this.f21775j = zzclVar.zzh;
            Bundle bundle = zzclVar.zzg;
            if (bundle != null) {
                this.f21770e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
