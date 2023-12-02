package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhz implements zzlo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzik f21815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhz(zzik zzikVar) {
        this.f21815a = zzikVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlo
    public final void a(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f21815a.zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle, str);
        } else {
            this.f21815a.zzD(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle);
        }
    }
}
