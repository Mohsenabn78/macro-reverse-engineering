package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneratedAppGlideModule.java */
/* loaded from: classes3.dex */
public abstract class a extends AppGlideModule {
    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract Set<Class<?>> a();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public RequestManagerRetriever.RequestManagerFactory b() {
        return null;
    }
}
