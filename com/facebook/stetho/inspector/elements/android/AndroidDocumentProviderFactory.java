package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.HandlerUtil;
import com.facebook.stetho.inspector.elements.DescriptorProvider;
import com.facebook.stetho.inspector.elements.DocumentProvider;
import com.facebook.stetho.inspector.elements.DocumentProviderFactory;
import java.util.List;

/* loaded from: classes3.dex */
public final class AndroidDocumentProviderFactory implements DocumentProviderFactory, ThreadBound {
    private final Application mApplication;
    private final List<DescriptorProvider> mDescriptorProviders;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public AndroidDocumentProviderFactory(Application application, List<DescriptorProvider> list) {
        this.mApplication = (Application) Util.throwIfNull(application);
        this.mDescriptorProviders = (List) Util.throwIfNull(list);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public boolean checkThreadAccess() {
        return HandlerUtil.checkThreadAccess(this.mHandler);
    }

    @Override // com.facebook.stetho.inspector.elements.DocumentProviderFactory
    public DocumentProvider create() {
        return new AndroidDocumentProvider(this.mApplication, this.mDescriptorProviders, this);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public <V> V postAndWait(UncheckedCallable<V> uncheckedCallable) {
        return (V) HandlerUtil.postAndWait(this.mHandler, uncheckedCallable);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public void postDelayed(Runnable runnable, long j4) {
        if (this.mHandler.postDelayed(runnable, j4)) {
            return;
        }
        throw new RuntimeException("Handler.postDelayed() returned false");
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public void removeCallbacks(Runnable runnable) {
        this.mHandler.removeCallbacks(runnable);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public void verifyThreadAccess() {
        HandlerUtil.verifyThreadAccess(this.mHandler);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public void postAndWait(Runnable runnable) {
        HandlerUtil.postAndWait(this.mHandler, runnable);
    }
}
