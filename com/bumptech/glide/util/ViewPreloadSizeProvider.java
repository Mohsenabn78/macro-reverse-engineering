package com.bumptech.glide.util;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    private int[] f17588a;

    /* renamed from: b  reason: collision with root package name */
    private a f17589b;

    public ViewPreloadSizeProvider() {
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    @Nullable
    public int[] getPreloadSize(@NonNull T t3, int i4, int i5) {
        int[] iArr = this.f17588a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i4, int i5) {
        this.f17588a = new int[]{i4, i5};
        this.f17589b = null;
    }

    public void setView(@NonNull View view) {
        if (this.f17588a == null && this.f17589b == null) {
            this.f17589b = new a(view, this);
        }
    }

    public ViewPreloadSizeProvider(@NonNull View view) {
        this.f17589b = new a(view, this);
    }

    /* loaded from: classes3.dex */
    private static final class a extends ViewTarget<View, Object> {
        a(@NonNull View view, @NonNull SizeReadyCallback sizeReadyCallback) {
            super(view);
            getSize(sizeReadyCallback);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }
}
