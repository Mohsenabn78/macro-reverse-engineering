package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public class BooleanResult implements Result {

    /* renamed from: a  reason: collision with root package name */
    private final Status f20003a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20004b;

    @ShowFirstParty
    @KeepForSdk
    public BooleanResult(@NonNull Status status, boolean z3) {
        this.f20003a = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.f20004b = z3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        if (!this.f20003a.equals(booleanResult.f20003a) || this.f20004b != booleanResult.f20004b) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f20003a;
    }

    public boolean getValue() {
        return this.f20004b;
    }

    public final int hashCode() {
        return ((this.f20003a.hashCode() + 527) * 31) + (this.f20004b ? 1 : 0);
    }
}
