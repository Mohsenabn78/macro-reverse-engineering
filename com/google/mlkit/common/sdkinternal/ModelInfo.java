package com.google.mlkit.common.sdkinternal;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class ModelInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f32968a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f32969b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32970c;

    /* renamed from: d  reason: collision with root package name */
    private final ModelType f32971d;

    @KeepForSdk
    public ModelInfo(@NonNull String str, @NonNull Uri uri, @NonNull String str2, @NonNull ModelType modelType) {
        this.f32968a = str;
        this.f32969b = uri;
        this.f32970c = str2;
        this.f32971d = modelType;
    }

    @NonNull
    @KeepForSdk
    public String getModelHash() {
        return this.f32970c;
    }

    @NonNull
    @KeepForSdk
    public String getModelNameForPersist() {
        return this.f32968a;
    }

    @NonNull
    @KeepForSdk
    public ModelType getModelType() {
        return this.f32971d;
    }

    @NonNull
    @KeepForSdk
    public Uri getModelUri() {
        return this.f32969b;
    }
}
