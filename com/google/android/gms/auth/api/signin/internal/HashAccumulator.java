package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class HashAccumulator {

    /* renamed from: a  reason: collision with root package name */
    private int f19848a = 1;

    @NonNull
    @CanIgnoreReturnValue
    @KeepForSdk
    public HashAccumulator addObject(@Nullable Object obj) {
        int hashCode;
        int i4 = this.f19848a * 31;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        this.f19848a = i4 + hashCode;
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.f19848a;
    }

    @NonNull
    @CanIgnoreReturnValue
    public final HashAccumulator zaa(boolean z3) {
        this.f19848a = (this.f19848a * 31) + (z3 ? 1 : 0);
        return this;
    }
}
