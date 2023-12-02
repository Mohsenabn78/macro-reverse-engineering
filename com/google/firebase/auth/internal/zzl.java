package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeEmailInfo;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzl extends ActionCodeEmailInfo {

    /* renamed from: b  reason: collision with root package name */
    private final String f29074b;

    public zzl(String str, String str2) {
        this.f28840a = Preconditions.checkNotEmpty(str);
        this.f29074b = Preconditions.checkNotEmpty(str2);
    }

    @Override // com.google.firebase.auth.ActionCodeEmailInfo
    public final String getPreviousEmail() {
        return this.f29074b;
    }
}
