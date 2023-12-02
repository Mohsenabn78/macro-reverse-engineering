package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public class Response<T extends Result> {

    /* renamed from: a  reason: collision with root package name */
    private Result f20029a;

    public Response() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public T b() {
        return (T) this.f20029a;
    }

    public void setResult(@NonNull T t3) {
        this.f20029a = t3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Response(@NonNull T t3) {
        this.f20029a = t3;
    }
}
