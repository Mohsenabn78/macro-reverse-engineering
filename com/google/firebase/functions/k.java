package com.google.firebase.functions;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.functions.dagger.Provides;
import javax.inject.Named;

/* compiled from: FunctionsComponent.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class k {
    @Provides
    @Named("projectId")
    public static String a(FirebaseOptions firebaseOptions) {
        return firebaseOptions.getProjectId();
    }
}
