package com.afollestad.materialdialogs.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.StackingBehavior;
import com.afollestad.materialdialogs.util.DialogUtils;

/* loaded from: classes2.dex */
public class MDRootLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final MDButton[] f1128a;

    /* renamed from: b  reason: collision with root package name */
    private int f1129b;

    /* renamed from: c  reason: collision with root package name */
    private View f1130c;

    /* renamed from: d  reason: collision with root package name */
    private View f1131d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1132e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1133f;

    /* renamed from: g  reason: collision with root package name */
    private StackingBehavior f1134g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1135h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1136i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1137j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1138k;

    /* renamed from: l  reason: collision with root package name */
    private int f1139l;

    /* renamed from: m  reason: collision with root package name */
    private int f1140m;

    /* renamed from: n  reason: collision with root package name */
    private int f1141n;

    /* renamed from: o  reason: collision with root package name */
    private GravityEnum f1142o;

    /* renamed from: p  reason: collision with root package name */
    private int f1143p;

    /* renamed from: q  reason: collision with root package name */
    private Paint f1144q;

    /* renamed from: r  reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f1145r;

    /* renamed from: s  reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f1146s;

    /* renamed from: t  reason: collision with root package name */
    private int f1147t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1148a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1149b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f1150c;

        a(View view, boolean z3, boolean z4) {
            this.f1148a = view;
            this.f1149b = z3;
            this.f1150c = z4;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.f1148a.getMeasuredHeight() != 0) {
                if (MDRootLayout.k((WebView) this.f1148a)) {
                    MDRootLayout.this.h((ViewGroup) this.f1148a, this.f1149b, this.f1150c);
                } else {
                    if (this.f1149b) {
                        MDRootLayout.this.f1132e = false;
                    }
                    if (this.f1150c) {
                        MDRootLayout.this.f1133f = false;
                    }
                }
                this.f1148a.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1152a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1153b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f1154c;

        b(ViewGroup viewGroup, boolean z3, boolean z4) {
            this.f1152a = viewGroup;
            this.f1153b = z3;
            this.f1154c = z4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            super.onScrolled(recyclerView, i4, i5);
            MDButton[] mDButtonArr = MDRootLayout.this.f1128a;
            int length = mDButtonArr.length;
            boolean z3 = false;
            int i6 = 0;
            while (true) {
                if (i6 < length) {
                    MDButton mDButton = mDButtonArr[i6];
                    if (mDButton != null && mDButton.getVisibility() != 8) {
                        z3 = true;
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
            MDRootLayout.this.o(this.f1152a, this.f1153b, this.f1154c, z3);
            MDRootLayout.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1156a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1157b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f1158c;

        c(ViewGroup viewGroup, boolean z3, boolean z4) {
            this.f1156a = viewGroup;
            this.f1157b = z3;
            this.f1158c = z4;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            MDButton[] mDButtonArr = MDRootLayout.this.f1128a;
            int length = mDButtonArr.length;
            boolean z3 = false;
            int i4 = 0;
            while (true) {
                if (i4 < length) {
                    MDButton mDButton = mDButtonArr[i4];
                    if (mDButton != null && mDButton.getVisibility() != 8) {
                        z3 = true;
                        break;
                    }
                    i4++;
                } else {
                    break;
                }
            }
            ViewGroup viewGroup = this.f1156a;
            if (viewGroup instanceof WebView) {
                MDRootLayout.this.p((WebView) viewGroup, this.f1157b, this.f1158c, z3);
            } else {
                MDRootLayout.this.o(viewGroup, this.f1157b, this.f1158c, z3);
            }
            MDRootLayout.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1160a;

        static {
            int[] iArr = new int[GravityEnum.values().length];
            f1160a = iArr;
            try {
                iArr[GravityEnum.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1160a[GravityEnum.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MDRootLayout(Context context) {
        super(context);
        this.f1128a = new MDButton[3];
        this.f1132e = false;
        this.f1133f = false;
        this.f1134g = StackingBehavior.ADAPTIVE;
        this.f1135h = false;
        this.f1136i = true;
        this.f1142o = GravityEnum.START;
        n(context, null, 0);
    }

    public static boolean canRecyclerViewScroll(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getLayoutManager() != null && recyclerView.getLayoutManager().canScrollVertically()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ViewGroup viewGroup, boolean z3, boolean z4) {
        if ((!z4 && this.f1145r == null) || (z4 && this.f1146s == null)) {
            if (viewGroup instanceof RecyclerView) {
                b bVar = new b(viewGroup, z3, z4);
                RecyclerView recyclerView = (RecyclerView) viewGroup;
                recyclerView.addOnScrollListener(bVar);
                bVar.onScrolled(recyclerView, 0, 0);
                return;
            }
            c cVar = new c(viewGroup, z3, z4);
            if (!z4) {
                this.f1145r = cVar;
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.f1145r);
            } else {
                this.f1146s = cVar;
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.f1146s);
            }
            cVar.onScrollChanged();
        }
    }

    private static boolean i(AdapterView adapterView) {
        boolean z3;
        boolean z4;
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        if (adapterView.getFirstVisiblePosition() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (adapterView.getLastVisiblePosition() == adapterView.getCount() - 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 && z4 && adapterView.getChildCount() > 0 && adapterView.getChildAt(0).getTop() >= adapterView.getPaddingTop() && adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() <= adapterView.getHeight() - adapterView.getPaddingBottom()) {
            return false;
        }
        return true;
    }

    private static boolean j(ScrollView scrollView) {
        if (scrollView.getChildCount() == 0) {
            return false;
        }
        if ((scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() >= scrollView.getChildAt(0).getMeasuredHeight()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(WebView webView) {
        if (webView.getMeasuredHeight() < webView.getContentHeight() * webView.getScale()) {
            return true;
        }
        return false;
    }

    @Nullable
    private static View l(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                return childAt;
            }
        }
        return null;
    }

    @Nullable
    private static View m(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                return childAt;
            }
        }
        return null;
    }

    private void n(Context context, AttributeSet attributeSet, int i4) {
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MDRootLayout, i4, 0);
        this.f1137j = obtainStyledAttributes.getBoolean(R.styleable.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        obtainStyledAttributes.recycle();
        this.f1139l = resources.getDimensionPixelSize(R.dimen.md_notitle_vertical_padding);
        this.f1140m = resources.getDimensionPixelSize(R.dimen.md_button_frame_vertical_padding);
        this.f1143p = resources.getDimensionPixelSize(R.dimen.md_button_padding_frame_side);
        this.f1141n = resources.getDimensionPixelSize(R.dimen.md_button_height);
        this.f1144q = new Paint();
        this.f1147t = resources.getDimensionPixelSize(R.dimen.md_divider_height);
        this.f1144q.setColor(DialogUtils.resolveColor(context, R.attr.md_divider_color));
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(ViewGroup viewGroup, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        boolean z7 = true;
        if (z3 && viewGroup.getChildCount() > 0) {
            View view = this.f1130c;
            if (view != null && view.getVisibility() != 8 && viewGroup.getScrollY() + viewGroup.getPaddingTop() > viewGroup.getChildAt(0).getTop()) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f1132e = z6;
        }
        if (z4 && viewGroup.getChildCount() > 0) {
            this.f1133f = (!z5 || (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() >= viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom()) ? false : false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(WebView webView, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        boolean z7 = true;
        if (z3) {
            View view = this.f1130c;
            if (view != null && view.getVisibility() != 8 && webView.getScrollY() + webView.getPaddingTop() > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f1132e = z6;
        }
        if (z4) {
            this.f1133f = (!z5 || ((float) ((webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom())) >= ((float) webView.getContentHeight()) * webView.getScale()) ? false : false;
        }
    }

    private void q() {
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            int i4 = d.f1160a[this.f1142o.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    this.f1142o = GravityEnum.START;
                    return;
                }
                return;
            }
            this.f1142o = GravityEnum.END;
        }
    }

    private static boolean r(View view) {
        boolean z3;
        boolean z4 = true;
        if (view != null && view.getVisibility() != 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && (view instanceof MDButton)) {
            if (((MDButton) view).getText().toString().trim().length() <= 0) {
                z4 = false;
            }
            return z4;
        }
        return z3;
    }

    private void s(View view, boolean z3, boolean z4) {
        if (view == null) {
            return;
        }
        if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            if (j(scrollView)) {
                h(scrollView, z3, z4);
                return;
            }
            if (z3) {
                this.f1132e = false;
            }
            if (z4) {
                this.f1133f = false;
            }
        } else if (view instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) view;
            if (i(adapterView)) {
                h(adapterView, z3, z4);
                return;
            }
            if (z3) {
                this.f1132e = false;
            }
            if (z4) {
                this.f1133f = false;
            }
        } else if (view instanceof WebView) {
            view.getViewTreeObserver().addOnPreDrawListener(new a(view, z3, z4));
        } else if (view instanceof RecyclerView) {
            boolean canRecyclerViewScroll = canRecyclerViewScroll((RecyclerView) view);
            if (z3) {
                this.f1132e = canRecyclerViewScroll;
            }
            if (z4) {
                this.f1133f = canRecyclerViewScroll;
            }
            if (canRecyclerViewScroll) {
                h((ViewGroup) view, z3, z4);
            }
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            View m4 = m(viewGroup);
            s(m4, z3, z4);
            View l4 = l(viewGroup);
            if (l4 != m4) {
                s(l4, false, true);
            }
        }
    }

    public void noTitleNoPadding() {
        this.f1138k = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.f1131d;
        if (view != null) {
            if (this.f1132e) {
                int top = view.getTop();
                canvas.drawRect(0.0f, top - this.f1147t, getMeasuredWidth(), top, this.f1144q);
            }
            if (this.f1133f) {
                int bottom = this.f1131d.getBottom();
                canvas.drawRect(0.0f, bottom, getMeasuredWidth(), bottom + this.f1147t, this.f1144q);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getId() == R.id.md_titleFrame) {
                this.f1130c = childAt;
            } else if (childAt.getId() == R.id.md_buttonDefaultNeutral) {
                this.f1128a[0] = (MDButton) childAt;
            } else if (childAt.getId() == R.id.md_buttonDefaultNegative) {
                this.f1128a[1] = (MDButton) childAt;
            } else if (childAt.getId() == R.id.md_buttonDefaultPositive) {
                this.f1128a[2] = (MDButton) childAt;
            } else {
                this.f1131d = childAt;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int measuredWidth;
        int i10;
        int i11;
        int i12;
        int measuredWidth2;
        int measuredWidth3;
        int i13;
        MDButton[] mDButtonArr;
        if (r(this.f1130c)) {
            int measuredHeight = this.f1130c.getMeasuredHeight() + i5;
            this.f1130c.layout(i4, i5, i6, measuredHeight);
            i5 = measuredHeight;
        } else if (!this.f1138k && this.f1136i) {
            i5 += this.f1139l;
        }
        if (r(this.f1131d)) {
            View view = this.f1131d;
            view.layout(i4, i5, i6, view.getMeasuredHeight() + i5);
        }
        if (this.f1135h) {
            int i14 = i7 - this.f1140m;
            for (MDButton mDButton : this.f1128a) {
                if (r(mDButton)) {
                    mDButton.layout(i4, i14 - mDButton.getMeasuredHeight(), i6, i14);
                    i14 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            if (this.f1136i) {
                i7 -= this.f1140m;
            }
            int i15 = i7 - this.f1141n;
            int i16 = this.f1143p;
            if (r(this.f1128a[2])) {
                if (this.f1142o == GravityEnum.END) {
                    measuredWidth3 = i4 + i16;
                    i13 = this.f1128a[2].getMeasuredWidth() + measuredWidth3;
                    i8 = -1;
                } else {
                    int i17 = i6 - i16;
                    measuredWidth3 = i17 - this.f1128a[2].getMeasuredWidth();
                    i13 = i17;
                    i8 = measuredWidth3;
                }
                this.f1128a[2].layout(measuredWidth3, i15, i13, i7);
                i16 += this.f1128a[2].getMeasuredWidth();
            } else {
                i8 = -1;
            }
            if (r(this.f1128a[1])) {
                GravityEnum gravityEnum = this.f1142o;
                if (gravityEnum == GravityEnum.END) {
                    i12 = i16 + i4;
                    measuredWidth2 = this.f1128a[1].getMeasuredWidth() + i12;
                } else if (gravityEnum == GravityEnum.START) {
                    measuredWidth2 = i6 - i16;
                    i12 = measuredWidth2 - this.f1128a[1].getMeasuredWidth();
                } else {
                    i12 = this.f1143p + i4;
                    measuredWidth2 = this.f1128a[1].getMeasuredWidth() + i12;
                    i9 = measuredWidth2;
                    this.f1128a[1].layout(i12, i15, measuredWidth2, i7);
                }
                i9 = -1;
                this.f1128a[1].layout(i12, i15, measuredWidth2, i7);
            } else {
                i9 = -1;
            }
            if (r(this.f1128a[0])) {
                GravityEnum gravityEnum2 = this.f1142o;
                if (gravityEnum2 == GravityEnum.END) {
                    i10 = i6 - this.f1143p;
                    i11 = i10 - this.f1128a[0].getMeasuredWidth();
                } else if (gravityEnum2 == GravityEnum.START) {
                    i11 = i4 + this.f1143p;
                    i10 = this.f1128a[0].getMeasuredWidth() + i11;
                } else {
                    if (i9 == -1 && i8 != -1) {
                        i9 = i8 - this.f1128a[0].getMeasuredWidth();
                    } else {
                        if (i8 == -1 && i9 != -1) {
                            measuredWidth = this.f1128a[0].getMeasuredWidth();
                        } else if (i8 == -1) {
                            i9 = ((i6 - i4) / 2) - (this.f1128a[0].getMeasuredWidth() / 2);
                            measuredWidth = this.f1128a[0].getMeasuredWidth();
                        }
                        i8 = i9 + measuredWidth;
                    }
                    i10 = i8;
                    i11 = i9;
                }
                this.f1128a[0].layout(i11, i15, i10, i7);
            }
        }
        s(this.f1131d, true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0110  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.onMeasure(int, int):void");
    }

    public void setButtonGravity(GravityEnum gravityEnum) {
        this.f1142o = gravityEnum;
        q();
    }

    public void setButtonStackedGravity(GravityEnum gravityEnum) {
        MDButton[] mDButtonArr;
        for (MDButton mDButton : this.f1128a) {
            if (mDButton != null) {
                mDButton.setStackedGravity(gravityEnum);
            }
        }
    }

    public void setDividerColor(int i4) {
        this.f1144q.setColor(i4);
        invalidate();
    }

    public void setMaxHeight(int i4) {
        this.f1129b = i4;
    }

    public void setStackingBehavior(StackingBehavior stackingBehavior) {
        this.f1134g = stackingBehavior;
        invalidate();
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1128a = new MDButton[3];
        this.f1132e = false;
        this.f1133f = false;
        this.f1134g = StackingBehavior.ADAPTIVE;
        this.f1135h = false;
        this.f1136i = true;
        this.f1142o = GravityEnum.START;
        n(context, attributeSet, 0);
    }

    @TargetApi(11)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1128a = new MDButton[3];
        this.f1132e = false;
        this.f1133f = false;
        this.f1134g = StackingBehavior.ADAPTIVE;
        this.f1135h = false;
        this.f1136i = true;
        this.f1142o = GravityEnum.START;
        n(context, attributeSet, i4);
    }

    @TargetApi(21)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f1128a = new MDButton[3];
        this.f1132e = false;
        this.f1133f = false;
        this.f1134g = StackingBehavior.ADAPTIVE;
        this.f1135h = false;
        this.f1136i = true;
        this.f1142o = GravityEnum.START;
        n(context, attributeSet, i4);
    }
}
