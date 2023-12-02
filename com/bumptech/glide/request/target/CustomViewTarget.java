package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    @IdRes

    /* renamed from: g  reason: collision with root package name */
    private static final int f17486g = R.id.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    private final b f17487a;

    /* renamed from: b  reason: collision with root package name */
    protected final T f17488b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private View.OnAttachStateChangeListener f17489c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17490d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17491e;
    @IdRes

    /* renamed from: f  reason: collision with root package name */
    private int f17492f;

    /* loaded from: classes3.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            CustomViewTarget.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            CustomViewTarget.this.f();
        }
    }

    @VisibleForTesting
    /* loaded from: classes3.dex */
    static final class b {
        @Nullable
        @VisibleForTesting

        /* renamed from: e  reason: collision with root package name */
        static Integer f17494e;

        /* renamed from: a  reason: collision with root package name */
        private final View f17495a;

        /* renamed from: b  reason: collision with root package name */
        private final List<SizeReadyCallback> f17496b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f17497c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private a f17498d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<b> f17499a;

            a(@NonNull b bVar) {
                this.f17499a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                }
                b bVar = this.f17499a.get();
                if (bVar != null) {
                    bVar.a();
                    return true;
                }
                return true;
            }
        }

        b(@NonNull View view) {
            this.f17495a = view;
        }

        private static int c(@NonNull Context context) {
            if (f17494e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f17494e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f17494e.intValue();
        }

        private int e(int i4, int i5, int i6) {
            int i7 = i5 - i6;
            if (i7 > 0) {
                return i7;
            }
            if (this.f17497c && this.f17495a.isLayoutRequested()) {
                return 0;
            }
            int i8 = i4 - i6;
            if (i8 > 0) {
                return i8;
            }
            if (this.f17495a.isLayoutRequested() || i5 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f17495a.getContext());
        }

        private int f() {
            int i4;
            int paddingTop = this.f17495a.getPaddingTop() + this.f17495a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f17495a.getLayoutParams();
            if (layoutParams != null) {
                i4 = layoutParams.height;
            } else {
                i4 = 0;
            }
            return e(this.f17495a.getHeight(), i4, paddingTop);
        }

        private int g() {
            int i4;
            int paddingLeft = this.f17495a.getPaddingLeft() + this.f17495a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f17495a.getLayoutParams();
            if (layoutParams != null) {
                i4 = layoutParams.width;
            } else {
                i4 = 0;
            }
            return e(this.f17495a.getWidth(), i4, paddingLeft);
        }

        private boolean h(int i4) {
            if (i4 <= 0 && i4 != Integer.MIN_VALUE) {
                return false;
            }
            return true;
        }

        private boolean i(int i4, int i5) {
            if (h(i4) && h(i5)) {
                return true;
            }
            return false;
        }

        private void j(int i4, int i5) {
            Iterator it = new ArrayList(this.f17496b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).onSizeReady(i4, i5);
            }
        }

        void a() {
            if (this.f17496b.isEmpty()) {
                return;
            }
            int g4 = g();
            int f4 = f();
            if (!i(g4, f4)) {
                return;
            }
            j(g4, f4);
            b();
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f17495a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f17498d);
            }
            this.f17498d = null;
            this.f17496b.clear();
        }

        void d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int g4 = g();
            int f4 = f();
            if (i(g4, f4)) {
                sizeReadyCallback.onSizeReady(g4, f4);
                return;
            }
            if (!this.f17496b.contains(sizeReadyCallback)) {
                this.f17496b.add(sizeReadyCallback);
            }
            if (this.f17498d == null) {
                ViewTreeObserver viewTreeObserver = this.f17495a.getViewTreeObserver();
                a aVar = new a(this);
                this.f17498d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f17496b.remove(sizeReadyCallback);
        }
    }

    public CustomViewTarget(@NonNull T t3) {
        this.f17488b = (T) Preconditions.checkNotNull(t3);
        this.f17487a = new b(t3);
    }

    @Nullable
    private Object a() {
        T t3 = this.f17488b;
        int i4 = this.f17492f;
        if (i4 == 0) {
            i4 = f17486g;
        }
        return t3.getTag(i4);
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f17489c;
        if (onAttachStateChangeListener != null && !this.f17491e) {
            this.f17488b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f17491e = true;
        }
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f17489c;
        if (onAttachStateChangeListener != null && this.f17491e) {
            this.f17488b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f17491e = false;
        }
    }

    private void h(@Nullable Object obj) {
        T t3 = this.f17488b;
        int i4 = this.f17492f;
        if (i4 == 0) {
            i4 = f17486g;
        }
        t3.setTag(i4, obj);
    }

    @NonNull
    public final CustomViewTarget<T, Z> clearOnDetach() {
        if (this.f17489c != null) {
            return this;
        }
        this.f17489c = new a();
        b();
        return this;
    }

    protected abstract void d(@Nullable Drawable drawable);

    final void f() {
        Request request = getRequest();
        if (request != null) {
            this.f17490d = true;
            request.clear();
            this.f17490d = false;
        }
    }

    final void g() {
        Request request = getRequest();
        if (request != null && request.isCleared()) {
            request.begin();
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public final Request getRequest() {
        Object a4 = a();
        if (a4 != null) {
            if (a4 instanceof Request) {
                return (Request) a4;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f17487a.d(sizeReadyCallback);
    }

    @NonNull
    public final T getView() {
        return this.f17488b;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(@Nullable Drawable drawable) {
        this.f17487a.b();
        d(drawable);
        if (!this.f17490d) {
            c();
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(@Nullable Drawable drawable) {
        b();
        e(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f17487a.k(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(@Nullable Request request) {
        h(request);
    }

    public String toString() {
        return "Target for: " + this.f17488b;
    }

    public final CustomViewTarget<T, Z> useTagId(@IdRes int i4) {
        if (this.f17492f == 0) {
            this.f17492f = i4;
            return this;
        }
        throw new IllegalArgumentException("You cannot change the tag id once it has been set.");
    }

    @NonNull
    public final CustomViewTarget<T, Z> waitForLayout() {
        this.f17487a.f17497c = true;
        return this;
    }

    protected void e(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }
}
