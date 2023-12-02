package com.melnykov.fab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ScrollView;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.melnykov.fab.ObservableScrollView;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public class FloatingActionButton extends ImageButton {
    public static final int TYPE_MINI = 1;
    public static final int TYPE_NORMAL = 0;

    /* renamed from: a  reason: collision with root package name */
    private boolean f36129a;

    /* renamed from: b  reason: collision with root package name */
    private int f36130b;

    /* renamed from: c  reason: collision with root package name */
    private int f36131c;

    /* renamed from: d  reason: collision with root package name */
    private int f36132d;

    /* renamed from: e  reason: collision with root package name */
    private int f36133e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f36134f;

    /* renamed from: g  reason: collision with root package name */
    private int f36135g;

    /* renamed from: h  reason: collision with root package name */
    private int f36136h;

    /* renamed from: i  reason: collision with root package name */
    private int f36137i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f36138j;

    /* renamed from: k  reason: collision with root package name */
    private final Interpolator f36139k;

    @IntDef({0, 1})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface TYPE {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int i4;
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            if (floatingActionButton.f36135g == 0) {
                i4 = R.dimen.fab_size_normal;
            } else {
                i4 = R.dimen.fab_size_mini;
            }
            int g4 = floatingActionButton.g(i4);
            outline.setOval(0, 0, g4, g4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f36141a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f36142b;

        b(boolean z3, boolean z4) {
            this.f36141a = z3;
            this.f36142b = z4;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = FloatingActionButton.this.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            FloatingActionButton.this.p(this.f36141a, this.f36142b, true);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c extends com.melnykov.fab.a {

        /* renamed from: e  reason: collision with root package name */
        private ScrollDirectionListener f36144e;

        /* renamed from: f  reason: collision with root package name */
        private AbsListView.OnScrollListener f36145f;

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ScrollDirectionListener scrollDirectionListener) {
            this.f36144e = scrollDirectionListener;
        }

        @Override // com.melnykov.fab.a
        public void c() {
            FloatingActionButton.this.show();
            ScrollDirectionListener scrollDirectionListener = this.f36144e;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollDown();
            }
        }

        @Override // com.melnykov.fab.a
        public void d() {
            FloatingActionButton.this.hide();
            ScrollDirectionListener scrollDirectionListener = this.f36144e;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollUp();
            }
        }

        public void h(AbsListView.OnScrollListener onScrollListener) {
            this.f36145f = onScrollListener;
        }

        @Override // com.melnykov.fab.a, android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
            AbsListView.OnScrollListener onScrollListener = this.f36145f;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i4, i5, i6);
            }
            super.onScroll(absListView, i4, i5, i6);
        }

        @Override // com.melnykov.fab.a, android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i4) {
            AbsListView.OnScrollListener onScrollListener = this.f36145f;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i4);
            }
            super.onScrollStateChanged(absListView, i4);
        }

        /* synthetic */ c(FloatingActionButton floatingActionButton, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class d extends com.melnykov.fab.b {

        /* renamed from: b  reason: collision with root package name */
        private ScrollDirectionListener f36147b;

        /* renamed from: c  reason: collision with root package name */
        private RecyclerView.OnScrollListener f36148c;

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ScrollDirectionListener scrollDirectionListener) {
            this.f36147b = scrollDirectionListener;
        }

        @Override // com.melnykov.fab.b
        public void a() {
            FloatingActionButton.this.show();
            ScrollDirectionListener scrollDirectionListener = this.f36147b;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollDown();
            }
        }

        @Override // com.melnykov.fab.b
        public void b() {
            FloatingActionButton.this.hide();
            ScrollDirectionListener scrollDirectionListener = this.f36147b;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollUp();
            }
        }

        public void e(RecyclerView.OnScrollListener onScrollListener) {
            this.f36148c = onScrollListener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
            RecyclerView.OnScrollListener onScrollListener = this.f36148c;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(recyclerView, i4);
            }
            super.onScrollStateChanged(recyclerView, i4);
        }

        @Override // com.melnykov.fab.b, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            RecyclerView.OnScrollListener onScrollListener = this.f36148c;
            if (onScrollListener != null) {
                onScrollListener.onScrolled(recyclerView, i4, i5);
            }
            super.onScrolled(recyclerView, i4, i5);
        }

        /* synthetic */ d(FloatingActionButton floatingActionButton, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class e extends com.melnykov.fab.c {

        /* renamed from: c  reason: collision with root package name */
        private ScrollDirectionListener f36150c;

        /* renamed from: d  reason: collision with root package name */
        private ObservableScrollView.OnScrollChangedListener f36151d;

        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ScrollDirectionListener scrollDirectionListener) {
            this.f36150c = scrollDirectionListener;
        }

        @Override // com.melnykov.fab.c
        public void a() {
            FloatingActionButton.this.show();
            ScrollDirectionListener scrollDirectionListener = this.f36150c;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollDown();
            }
        }

        @Override // com.melnykov.fab.c
        public void b() {
            FloatingActionButton.this.hide();
            ScrollDirectionListener scrollDirectionListener = this.f36150c;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollUp();
            }
        }

        public void e(ObservableScrollView.OnScrollChangedListener onScrollChangedListener) {
            this.f36151d = onScrollChangedListener;
        }

        @Override // com.melnykov.fab.c, com.melnykov.fab.ObservableScrollView.OnScrollChangedListener
        public void onScrollChanged(ScrollView scrollView, int i4, int i5, int i6, int i7) {
            ObservableScrollView.OnScrollChangedListener onScrollChangedListener = this.f36151d;
            if (onScrollChangedListener != null) {
                onScrollChangedListener.onScrollChanged(scrollView, i4, i5, i6, i7);
            }
            super.onScrollChanged(scrollView, i4, i5, i6, i7);
        }

        /* synthetic */ e(FloatingActionButton floatingActionButton, a aVar) {
            this();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private Drawable d(int i4) {
        int i5;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i4);
        if (this.f36134f && !k()) {
            Resources resources = getResources();
            if (this.f36135g == 0) {
                i5 = R.drawable.fab_shadow;
            } else {
                i5 = R.drawable.fab_shadow_mini;
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{resources.getDrawable(i5), shapeDrawable});
            int i6 = this.f36136h;
            layerDrawable.setLayerInset(1, i6, i6, i6, i6);
            return layerDrawable;
        }
        return shapeDrawable;
    }

    private static int e(int i4) {
        Color.colorToHSV(i4, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * 0.9f};
        return Color.HSVToColor(fArr);
    }

    private int f(int i4) {
        return getResources().getColor(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(int i4) {
        return getResources().getDimensionPixelSize(i4);
    }

    private int getMarginBottom() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return 0;
    }

    private TypedArray h(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private boolean i() {
        return true;
    }

    private boolean j() {
        return true;
    }

    private boolean k() {
        return true;
    }

    private void l(Context context, AttributeSet attributeSet) {
        this.f36129a = true;
        int f4 = f(R.color.material_blue_500);
        this.f36130b = f4;
        this.f36131c = e(f4);
        this.f36132d = n(this.f36130b);
        this.f36133e = f(17170432);
        this.f36135g = 0;
        this.f36134f = true;
        this.f36137i = getResources().getDimensionPixelOffset(R.dimen.fab_scroll_threshold);
        this.f36136h = g(R.dimen.fab_shadow_size);
        if (attributeSet != null) {
            m(context, attributeSet);
        }
        q();
    }

    private void m(Context context, AttributeSet attributeSet) {
        TypedArray h4 = h(context, attributeSet, R.styleable.FloatingActionButton);
        if (h4 != null) {
            try {
                int color = h4.getColor(R.styleable.FloatingActionButton_fab_colorNormal, f(R.color.material_blue_500));
                this.f36130b = color;
                this.f36131c = h4.getColor(R.styleable.FloatingActionButton_fab_colorPressed, e(color));
                this.f36132d = h4.getColor(R.styleable.FloatingActionButton_fab_colorRipple, n(this.f36130b));
                this.f36133e = h4.getColor(R.styleable.FloatingActionButton_fab_colorDisabled, this.f36133e);
                this.f36134f = h4.getBoolean(R.styleable.FloatingActionButton_fab_shadow, true);
                this.f36135g = h4.getInt(R.styleable.FloatingActionButton_fab_type, 0);
            } finally {
                h4.recycle();
            }
        }
    }

    private static int n(int i4) {
        Color.colorToHSV(i4, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * 1.1f};
        return Color.HSVToColor(fArr);
    }

    private void o() {
        if (!this.f36138j && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int i4 = marginLayoutParams.leftMargin;
            int i5 = this.f36136h;
            marginLayoutParams.setMargins(i4 - i5, marginLayoutParams.topMargin - i5, marginLayoutParams.rightMargin - i5, marginLayoutParams.bottomMargin - i5);
            requestLayout();
            this.f36138j = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z3, boolean z4, boolean z5) {
        int marginBottom;
        if (this.f36129a != z3 || z5) {
            this.f36129a = z3;
            int height = getHeight();
            if (height == 0 && !z5) {
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(new b(z3, z4));
                    return;
                }
            }
            if (z3) {
                marginBottom = 0;
            } else {
                marginBottom = getMarginBottom() + height;
            }
            if (z4) {
                ViewPropertyAnimator.animate(this).setInterpolator(this.f36139k).setDuration(200L).translationY(marginBottom);
            } else {
                ViewHelper.setTranslationY(this, marginBottom);
            }
            if (!i()) {
                setClickable(z3);
            }
        }
    }

    private void q() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, d(this.f36131c));
        stateListDrawable.addState(new int[]{-16842910}, d(this.f36133e));
        stateListDrawable.addState(new int[0], d(this.f36130b));
        setBackgroundCompat(stateListDrawable);
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        float g4;
        if (k()) {
            float f4 = 0.0f;
            if (this.f36134f) {
                if (getElevation() > 0.0f) {
                    g4 = getElevation();
                } else {
                    g4 = g(R.dimen.fab_elevation_lollipop);
                }
                f4 = g4;
            }
            setElevation(f4);
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.f36132d}), drawable, null);
            setOutlineProvider(new a());
            setClipToOutline(true);
            setBackground(rippleDrawable);
        } else if (j()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    public void attachToListView(@NonNull AbsListView absListView) {
        attachToListView(absListView, null, null);
    }

    public void attachToRecyclerView(@NonNull RecyclerView recyclerView) {
        attachToRecyclerView(recyclerView, null, null);
    }

    public void attachToScrollView(@NonNull ObservableScrollView observableScrollView) {
        attachToScrollView(observableScrollView, null, null);
    }

    public int getColorNormal() {
        return this.f36130b;
    }

    public int getColorPressed() {
        return this.f36131c;
    }

    public int getColorRipple() {
        return this.f36132d;
    }

    public int getType() {
        return this.f36135g;
    }

    public boolean hasShadow() {
        return this.f36134f;
    }

    public void hide() {
        hide(true);
    }

    public boolean isVisible() {
        return this.f36129a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        super.onMeasure(i4, i5);
        if (this.f36135g == 0) {
            i6 = R.dimen.fab_size_normal;
        } else {
            i6 = R.dimen.fab_size_mini;
        }
        int g4 = g(i6);
        if (this.f36134f && !k()) {
            g4 += this.f36136h * 2;
            o();
        }
        setMeasuredDimension(g4, g4);
    }

    public void setColorNormal(int i4) {
        if (i4 != this.f36130b) {
            this.f36130b = i4;
            q();
        }
    }

    public void setColorNormalResId(int i4) {
        setColorNormal(f(i4));
    }

    public void setColorPressed(int i4) {
        if (i4 != this.f36131c) {
            this.f36131c = i4;
            q();
        }
    }

    public void setColorPressedResId(int i4) {
        setColorPressed(f(i4));
    }

    public void setColorRipple(int i4) {
        if (i4 != this.f36132d) {
            this.f36132d = i4;
            q();
        }
    }

    public void setColorRippleResId(int i4) {
        setColorRipple(f(i4));
    }

    public void setShadow(boolean z3) {
        if (z3 != this.f36134f) {
            this.f36134f = z3;
            q();
        }
    }

    public void setType(int i4) {
        if (i4 != this.f36135g) {
            this.f36135g = i4;
            q();
        }
    }

    public void show() {
        show(true);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36139k = new AccelerateDecelerateInterpolator();
        l(context, attributeSet);
    }

    public void attachToListView(@NonNull AbsListView absListView, ScrollDirectionListener scrollDirectionListener) {
        attachToListView(absListView, scrollDirectionListener, null);
    }

    public void attachToRecyclerView(@NonNull RecyclerView recyclerView, ScrollDirectionListener scrollDirectionListener) {
        attachToRecyclerView(recyclerView, scrollDirectionListener, null);
    }

    public void attachToScrollView(@NonNull ObservableScrollView observableScrollView, ScrollDirectionListener scrollDirectionListener) {
        attachToScrollView(observableScrollView, scrollDirectionListener, null);
    }

    public void hide(boolean z3) {
        p(false, z3, false);
    }

    public void show(boolean z3) {
        p(true, z3, false);
    }

    public void attachToListView(@NonNull AbsListView absListView, ScrollDirectionListener scrollDirectionListener, AbsListView.OnScrollListener onScrollListener) {
        c cVar = new c(this, null);
        cVar.i(scrollDirectionListener);
        cVar.h(onScrollListener);
        cVar.e(absListView);
        cVar.f(this.f36137i);
        absListView.setOnScrollListener(cVar);
    }

    public void attachToRecyclerView(@NonNull RecyclerView recyclerView, ScrollDirectionListener scrollDirectionListener, RecyclerView.OnScrollListener onScrollListener) {
        d dVar = new d(this, null);
        dVar.f(scrollDirectionListener);
        dVar.e(onScrollListener);
        dVar.c(this.f36137i);
        recyclerView.setOnScrollListener(dVar);
    }

    public void attachToScrollView(@NonNull ObservableScrollView observableScrollView, ScrollDirectionListener scrollDirectionListener, ObservableScrollView.OnScrollChangedListener onScrollChangedListener) {
        e eVar = new e(this, null);
        eVar.f(scrollDirectionListener);
        eVar.e(onScrollChangedListener);
        eVar.c(this.f36137i);
        observableScrollView.setOnScrollChangedListener(eVar);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f36139k = new AccelerateDecelerateInterpolator();
        l(context, attributeSet);
    }
}
