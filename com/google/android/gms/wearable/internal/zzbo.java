package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbo implements Channel.GetInputStreamResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22705a;

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f22706b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbo(Status status, @Nullable InputStream inputStream) {
        this.f22705a = (Status) Preconditions.checkNotNull(status);
        this.f22706b = inputStream;
    }

    @Override // com.google.android.gms.wearable.Channel.GetInputStreamResult
    @Nullable
    public final InputStream getInputStream() {
        return this.f22706b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22705a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        InputStream inputStream = this.f22706b;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
