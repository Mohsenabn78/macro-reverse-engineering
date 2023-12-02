package com.google.api.client.extensions.android.http;

import com.google.api.client.extensions.android.AndroidUtils;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes5.dex */
public class AndroidHttp {
    private AndroidHttp() {
    }

    public static HttpTransport newCompatibleTransport() {
        if (AndroidUtils.isMinimumSdkLevel(9)) {
            return new NetHttpTransport();
        }
        return new ApacheHttpTransport();
    }
}
