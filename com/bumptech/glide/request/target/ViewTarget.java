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
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f17520g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static Integer f17521h;

    /* renamed from: b  reason: collision with root package name */
    protected final T f17522b;

    /* renamed from: c  reason: collision with root package name */
    private final b f17523c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View.OnAttachStateChangeListener f17524d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17525e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17526f;

    /* loaded from: classes3.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewTarget.this.e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTarget.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class b {
        @Nullable
        @VisibleForTesting

        /* renamed from: e  reason: collision with root package name */
        static Integer f17528e;

        /* renamed from: a  reason: collision with root package name */
        private final View f17529a;

        /* renamed from: b  reason: collision with root package name */
        private final List<SizeReadyCallback> f17530b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f17531c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private a f17532d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<b> f17533a;

            a(@NonNull b bVar) {
                this.f17533a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                }
                b bVar = this.f17533a.get();
                if (bVar != null) {
                    bVar.a();
                    return true;
                }
                return true;
            }
        }

        b(@NonNull View view) {
            this.f17529a = view;
        }

        private static int c(@NonNull Context context) {
            if (f17528e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f17528e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f17528e.intValue();
        }

        private int e(int i4, int i5, int i6) {
            int i7 = i5 - i6;
            if (i7 > 0) {
                return i7;
            }
            if (this.f17531c && this.f17529a.isLayoutRequested()) {
                return 0;
            }
            int i8 = i4 - i6;
            if (i8 > 0) {
                return i8;
            }
            if (this.f17529a.isLayoutRequested() || i5 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f17529a.getContext());
        }

        private int f() {
            int i4;
            int paddingTop = this.f17529a.getPaddingTop() + this.f17529a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f17529a.getLayoutParams();
            if (layoutParams != null) {
                i4 = layoutParams.height;
            } else {
                i4 = 0;
            }
            return e(this.f17529a.getHeight(), i4, paddingTop);
        }

        private int g() {
            int i4;
            int paddingLeft = this.f17529a.getPaddingLeft() + this.f17529a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f17529a.getLayoutParams();
            if (layoutParams != null) {
                i4 = layoutParams.width;
            } else {
                i4 = 0;
            }
            return e(this.f17529a.getWidth(), i4, paddingLeft);
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
            Iterator it = new ArrayList(this.f17530b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).onSizeReady(i4, i5);
            }
        }

        void a() {
            if (this.f17530b.isEmpty()) {
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
            ViewTreeObserver viewTreeObserver = this.f17529a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f17532d);
            }
            this.f17532d = null;
            this.f17530b.clear();
        }

        void d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int g4 = g();
            int f4 = f();
            if (i(g4, f4)) {
                sizeReadyCallback.onSizeReady(g4, f4);
                return;
            }
            if (!this.f17530b.contains(sizeReadyCallback)) {
                this.f17530b.add(sizeReadyCallback);
            }
            if (this.f17532d == null) {
                ViewTreeObserver viewTreeObserver = this.f17529a.getViewTreeObserver();
                a aVar = new a(this);
                this.f17532d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f17530b.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(@NonNull T t3) {
        this.f17522b = (T) Preconditions.checkNotNull(t3);
        this.f17523c = new b(t3);
    }

    @Nullable
    private Object a() {
        Integer num = f17521h;
        if (num == null) {
            return this.f17522b.getTag();
        }
        return this.f17522b.getTag(num.intValue());
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f17524d;
        if (onAttachStateChangeListener != null && !this.f17526f) {
            this.f17522b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f17526f = true;
        }
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f17524d;
        if (onAttachStateChangeListener != null && this.f17526f) {
            this.f17522b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f17526f = false;
        }
    }

    private void f(@Nullable Object obj) {
        Integer num = f17521h;
        if (num == null) {
            f17520g = true;
            this.f17522b.setTag(obj);
            return;
        }
        this.f17522b.setTag(num.intValue(), obj);
    }

    public static void setTagId(int i4) {
        if (f17521h == null && !f17520g) {
            f17521h = Integer.valueOf(i4);
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @NonNull
    public final ViewTarget<T, Z> clearOnDetach() {
        if (this.f17524d != null) {
            return this;
        }
        this.f17524d = new a();
        b();
        return this;
    }

    void d() {
        Request request = getRequest();
        if (request != null) {
            this.f17525e = true;
            request.clear();
            this.f17525e = false;
        }
    }

    void e() {
        Request request = getRequest();
        if (request != null && request.isCleared()) {
            request.begin();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @Nullable
    public Request getRequest() {
        Object a4 = a();
        if (a4 != null) {
            if (a4 instanceof Request) {
                return (Request) a4;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f17523c.d(sizeReadyCallback);
    }

    @NonNull
    public T getView() {
        return this.f17522b;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f17523c.b();
        if (!this.f17525e) {
            c();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        b();
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f17523c.k(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(@Nullable Request request) {
        f(request);
    }

    public String toString() {
        return "Target for: " + this.f17522b;
    }

    @NonNull
    public final ViewTarget<T, Z> waitForLayout() {
        this.f17523c.f17531c = true;
        return this;
    }

    @Deprecated
    public ViewTarget(@NonNull T t3, boolean z3) {
        this(t3);
        if (z3) {
            waitForLayout();
        }
    }
}
