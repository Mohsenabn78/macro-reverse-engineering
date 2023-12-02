package com.google.firebase.storage.network.connection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes5.dex */
public interface HttpURLConnectionFactory {
    @Nullable
    HttpURLConnection createInstance(@NonNull URL url) throws IOException;
}
