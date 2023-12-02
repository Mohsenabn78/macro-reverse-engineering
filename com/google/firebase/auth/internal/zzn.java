package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzn extends ActionCodeMultiFactorInfo {

    /* renamed from: b  reason: collision with root package name */
    private final MultiFactorInfo f29075b;

    public zzn(String str, MultiFactorInfo multiFactorInfo) {
        this.f28840a = Preconditions.checkNotEmpty(str);
        this.f29075b = (MultiFactorInfo) Preconditions.checkNotNull(multiFactorInfo);
    }

    @Override // com.google.firebase.auth.ActionCodeMultiFactorInfo
    public final MultiFactorInfo getMultiFactorInfo() {
        return this.f29075b;
    }
}
