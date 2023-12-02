package com.google.firebase.appcheck.interop;

import androidx.annotation.NonNull;
import com.google.firebase.appcheck.AppCheckTokenResult;

/* loaded from: classes5.dex */
public interface AppCheckTokenListener {
    void onAppCheckTokenChanged(@NonNull AppCheckTokenResult appCheckTokenResult);
}
