package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class URLWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final URL f33041a;

    @KeepForSdk
    public URLWrapper(@NonNull String str) throws MalformedURLException {
        this.f33041a = new URL(str);
    }

    @NonNull
    @KeepForSdk
    public URLConnection openConnection() throws IOException {
        return this.f33041a.openConnection();
    }
}
