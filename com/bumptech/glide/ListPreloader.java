package com.bumptech.glide;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

/* loaded from: classes3.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f16601a;

    /* renamed from: b  reason: collision with root package name */
    private final b f16602b;

    /* renamed from: c  reason: collision with root package name */
    private final RequestManager f16603c;

    /* renamed from: d  reason: collision with root package name */
    private final PreloadModelProvider<T> f16604d;

    /* renamed from: e  reason: collision with root package name */
    private final PreloadSizeProvider<T> f16605e;

    /* renamed from: f  reason: collision with root package name */
    private int f16606f;

    /* renamed from: g  reason: collision with root package name */
    private int f16607g;

    /* renamed from: i  reason: collision with root package name */
    private int f16609i;

    /* renamed from: h  reason: collision with root package name */
    private int f16608h = -1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16610j = true;

    /* loaded from: classes3.dex */
    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i4);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u3);
    }

    /* loaded from: classes3.dex */
    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t3, int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f16613a;

        b(int i4) {
            this.f16613a = Util.createQueue(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                this.f16613a.offer(new a());
            }
        }

        public a a(int i4, int i5) {
            a poll = this.f16613a.poll();
            this.f16613a.offer(poll);
            poll.f16612c = i4;
            poll.f16611b = i5;
            return poll;
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager, @NonNull PreloadModelProvider<T> preloadModelProvider, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i4) {
        this.f16603c = requestManager;
        this.f16604d = preloadModelProvider;
        this.f16605e = preloadSizeProvider;
        this.f16601a = i4;
        this.f16602b = new b(i4 + 1);
    }

    private void a() {
        for (int i4 = 0; i4 < this.f16601a; i4++) {
            this.f16603c.clear(this.f16602b.a(0, 0));
        }
    }

    private void b(int i4, int i5) {
        int min;
        int i6;
        if (i4 < i5) {
            i6 = Math.max(this.f16606f, i4);
            min = i5;
        } else {
            min = Math.min(this.f16607g, i4);
            i6 = i5;
        }
        int min2 = Math.min(this.f16609i, min);
        int min3 = Math.min(this.f16609i, Math.max(0, i6));
        if (i4 < i5) {
            for (int i7 = min3; i7 < min2; i7++) {
                d(this.f16604d.getPreloadItems(i7), i7, true);
            }
        } else {
            for (int i8 = min2 - 1; i8 >= min3; i8--) {
                d(this.f16604d.getPreloadItems(i8), i8, false);
            }
        }
        this.f16607g = min3;
        this.f16606f = min2;
    }

    private void c(int i4, boolean z3) {
        int i5;
        if (this.f16610j != z3) {
            this.f16610j = z3;
            a();
        }
        if (z3) {
            i5 = this.f16601a;
        } else {
            i5 = -this.f16601a;
        }
        b(i4, i5 + i4);
    }

    private void d(List<T> list, int i4, boolean z3) {
        int size = list.size();
        if (z3) {
            for (int i5 = 0; i5 < size; i5++) {
                e(list.get(i5), i4, i5);
            }
            return;
        }
        for (int i6 = size - 1; i6 >= 0; i6--) {
            e(list.get(i6), i4, i6);
        }
    }

    private void e(@Nullable T t3, int i4, int i5) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t3 == null || (preloadSize = this.f16605e.getPreloadSize(t3, i4, i5)) == null || (preloadRequestBuilder = this.f16604d.getPreloadRequestBuilder(t3)) == null) {
            return;
        }
        preloadRequestBuilder.into((RequestBuilder<?>) this.f16602b.a(preloadSize[0], preloadSize[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
        this.f16609i = i6;
        int i7 = this.f16608h;
        if (i4 > i7) {
            c(i5 + i4, true);
        } else if (i4 < i7) {
            c(i4, false);
        }
        this.f16608h = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a extends BaseTarget<Object> {

        /* renamed from: b  reason: collision with root package name */
        int f16611b;

        /* renamed from: c  reason: collision with root package name */
        int f16612c;

        a() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.f16612c, this.f16611b);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i4) {
    }
}
