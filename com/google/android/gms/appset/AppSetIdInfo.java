package com.google.android.gms.appset;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
/* loaded from: classes4.dex */
public class AppSetIdInfo {
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f19594a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19595b;

    /* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface Scope {
    }

    public AppSetIdInfo(@NonNull String str, int i4) {
        this.f19594a = str;
        this.f19595b = i4;
    }

    @NonNull
    public String getId() {
        return this.f19594a;
    }

    public int getScope() {
        return this.f19595b;
    }
}
