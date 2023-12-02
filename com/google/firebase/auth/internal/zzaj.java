package com.google.firebase.auth.internal;

import com.google.firebase.auth.SignInMethodQueryResult;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzaj implements SignInMethodQueryResult {

    /* renamed from: a  reason: collision with root package name */
    private final List f28980a;

    public zzaj(List list) {
        this.f28980a = list;
    }

    @Override // com.google.firebase.auth.SignInMethodQueryResult
    public final List<String> getSignInMethods() {
        return this.f28980a;
    }
}
