package com.google.android.gms.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {
    @NonNull
    public static final SignInOptions zaa = new SignInOptions(false, false, null, false, null, null, false, null, null, null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22570a = false;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22571b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f22572c = null;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22573d = false;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f22576g = false;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f22574e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f22575f = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Long f22577h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final Long f22578i = null;

    /* synthetic */ SignInOptions(boolean z3, boolean z4, String str, boolean z5, String str2, String str3, boolean z6, Long l4, Long l5, zaf zafVar) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        boolean z3 = ((SignInOptions) obj).f22570a;
        if (Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.hashCode(bool, bool, null, bool, bool, null, null, null, null);
    }
}
