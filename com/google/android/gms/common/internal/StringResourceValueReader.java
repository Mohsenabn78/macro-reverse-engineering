package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class StringResourceValueReader {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f20493a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20494b;

    public StringResourceValueReader(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.f20493a = resources;
        this.f20494b = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @Nullable
    @KeepForSdk
    public String getString(@NonNull String str) {
        int identifier = this.f20493a.getIdentifier(str, "string", this.f20494b);
        if (identifier == 0) {
            return null;
        }
        return this.f20493a.getString(identifier);
    }
}
