package com.pollfish.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pollfish.internal.c3;
import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import com.pollfish.internal.u1;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public abstract class c3 extends RelativeLayout implements z5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u3 f36715a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final x0 f36716b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public c2 f36717c;

    /* renamed from: d  reason: collision with root package name */
    public int f36718d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final i3 f36719e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final e3 f36720f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final g3 f36721g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public b4 f36722h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f36723i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f36724j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public TextView f36725k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public RelativeLayout f36726l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public TextView f36727m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public ImageView f36728n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public View f36729o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public ProgressBar f36730p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    public TextView f36731q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public ImageView f36732r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public v2 f36733s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f36734t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    public j3 f36735u;

    /* renamed from: v  reason: collision with root package name */
    public int f36736v;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f36737a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c3 f36738b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RelativeLayout relativeLayout, c3 c3Var) {
            super(0);
            this.f36737a = relativeLayout;
            this.f36738b = c3Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.f36737a.addView(this.f36738b.getWebView());
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f36740b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z3) {
            super(0);
            this.f36740b = z3;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            try {
                c3.this.setVisibility(4);
                c3 c3Var = c3.this;
                c3Var.setLayerType(c3Var.f36718d, null);
                c3.this.removeAllViews();
                b4 webView = c3.this.getWebView();
                if (webView != null) {
                    webView.k();
                }
                b4 webView2 = c3.this.getWebView();
                if (webView2 != null) {
                    webView2.destroy();
                }
                ViewParent parent = c3.this.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(c3.this);
                }
                c3.this.j();
                boolean z3 = this.f36740b;
                if (!z3 || (z3 && Intrinsics.areEqual(c3.this.getViewModel().q().a(), Boolean.TRUE))) {
                    c3.this.getViewModel().u();
                }
            } catch (Exception e4) {
                c3.this.getViewModel().a(new l4.a.d0(e4));
            }
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j3 f36742b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j3 j3Var) {
            super(0);
            this.f36742b = j3Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            c3 c3Var = c3.this;
            String str = this.f36742b.f36933c;
            b4 webView = c3Var.getWebView();
            if (webView != null) {
                webView.b(str);
            }
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements u1.a<Integer> {
        public d() {
        }

        @Override // com.pollfish.internal.u1.a
        public final void a(Integer num) {
            Integer num2 = num;
            if (num2 != null) {
                c3.a(c3.this, num2.intValue());
            }
        }
    }

    public c3(@NotNull Context context, @NotNull u3 u3Var, @NotNull x0 x0Var, @NotNull d2 d2Var) {
        super(context);
        this.f36715a = u3Var;
        this.f36716b = x0Var;
        this.f36717c = d2Var;
        this.f36719e = new i3(this);
        this.f36720f = new e3(this);
        this.f36721g = new g3(this);
        this.f36736v = getCurrentOrientation();
        setVisibility(4);
        setId(View.generateViewId());
        setFocusableInTouchMode(true);
        requestFocus();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout getBottomMediationContainer() {
        Unit unit;
        RelativeLayout relativeLayout = this.f36724j;
        RelativeLayout relativeLayout2 = relativeLayout;
        if (relativeLayout == null) {
            RelativeLayout relativeLayout3 = new RelativeLayout(getContext());
            if (relativeLayout3.getParent() != null) {
                ((ViewGroup) relativeLayout3.getParent()).removeView(relativeLayout3);
            }
            relativeLayout3.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, s5.a(relativeLayout3, 40));
            layoutParams.addRule(12);
            relativeLayout3.setLayoutParams(layoutParams);
            g2 d4 = this.f36715a.d();
            if (d4 != null) {
                relativeLayout3.setBackgroundColor(Color.parseColor(d4.h()));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                u3 u3Var = this.f36715a;
                u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
            }
            relativeLayout3.addView(getBottomMediationSeparatorView());
            LinearLayout linearLayout = new LinearLayout(relativeLayout3.getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setGravity(17);
            linearLayout.addView(getBottomMediationSurveyByTextView());
            linearLayout.addView(getBottomMediationLogoImageView());
            relativeLayout3.addView(linearLayout);
            this.f36724j = relativeLayout3;
            relativeLayout2 = relativeLayout3;
        }
        return relativeLayout2;
    }

    private final ImageView getBottomMediationLogoImageView() {
        String a4;
        Object obj;
        String removePrefix;
        ImageView imageView = this.f36728n;
        if (imageView == null) {
            imageView = new ImageView(getContext());
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            imageView.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, s5.a(imageView, 24));
            layoutParams.setMargins(s5.a(imageView, 8), 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            j3 j3Var = this.f36735u;
            Unit unit = null;
            if (j3Var != null && (a4 = j3Var.a()) != null) {
                g2 d4 = this.f36715a.d();
                if (d4 != null) {
                    Iterator<T> it = d4.a().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            String a5 = ((k) obj).a();
                            removePrefix = StringsKt__StringsKt.removePrefix(a4, (CharSequence) ".");
                            if (Intrinsics.areEqual(a5, removePrefix)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    k kVar = (k) obj;
                    if (kVar != null) {
                        s5.a(imageView, kVar, new b3(this));
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        this.f36734t = true;
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    u3 u3Var = this.f36715a;
                    u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.f36734t = true;
            }
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            this.f36728n = imageView;
        }
        return imageView;
    }

    private final View getBottomMediationSeparatorView() {
        Unit unit;
        View view = this.f36729o;
        if (view == null) {
            view = new View(getContext());
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            view.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, s5.a(view, 1));
            layoutParams.addRule(10);
            view.setLayoutParams(layoutParams);
            g2 d4 = this.f36715a.d();
            if (d4 != null) {
                view.setBackgroundColor(Color.parseColor(d4.i()));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                u3 u3Var = this.f36715a;
                u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
            }
            this.f36729o = view;
        }
        return view;
    }

    private final TextView getBottomMediationSurveyByTextView() {
        Unit unit;
        TextView textView = this.f36727m;
        if (textView == null) {
            textView = new TextView(getContext());
            if (textView.getParent() != null) {
                ((ViewGroup) textView.getParent()).removeView(textView);
            }
            textView.setId(View.generateViewId());
            textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            textView.setTextAlignment(4);
            g2 d4 = this.f36715a.d();
            String str = null;
            if (d4 != null) {
                textView.setTextColor(Color.parseColor(d4.j()));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                u3 u3Var = this.f36715a;
                u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
            }
            j3 j3Var = this.f36735u;
            if (j3Var != null) {
                str = j3Var.b();
            }
            textView.setText(str);
            this.f36727m = textView;
        }
        return textView;
    }

    private final TextView getCloseTextView() {
        TextView textView = this.f36725k;
        if (textView == null) {
            TextView d4 = d();
            this.f36725k = d4;
            return d4;
        }
        return textView;
    }

    private final int getCurrentOrientation() {
        Configuration configuration;
        Resources resources = getContext().getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            return configuration.orientation;
        }
        return 0;
    }

    private final u2 getLoadingView() {
        v2 v2Var = this.f36733s;
        if (v2Var == null) {
            Context context = getContext();
            if (context != null) {
                v2Var = new v2(context, this.f36715a);
            } else {
                v2Var = null;
            }
            this.f36733s = v2Var;
        }
        return v2Var;
    }

    private final TextView getRefreshTextView() {
        TextView textView = this.f36731q;
        if (textView == null) {
            TextView e4 = e();
            this.f36731q = e4;
            return e4;
        }
        return textView;
    }

    private final ImageView getTopLogoImageView() {
        Unit unit;
        ImageView imageView = this.f36732r;
        if (imageView == null) {
            imageView = new ImageView(getContext());
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            imageView.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, s5.a(imageView, 35));
            layoutParams.addRule(13);
            imageView.setLayoutParams(layoutParams);
            g2 d4 = this.f36715a.d();
            if (d4 != null) {
                s5.a(imageView, d4.k(), new d3(imageView));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                u3 u3Var = this.f36715a;
                u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setAdjustViewBounds(true);
            this.f36732r = imageView;
        }
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout getTopMediationContainer() {
        Unit unit;
        RelativeLayout relativeLayout = this.f36726l;
        if (relativeLayout == null) {
            relativeLayout = new RelativeLayout(getContext());
            if (relativeLayout.getParent() != null) {
                ((ViewGroup) relativeLayout.getParent()).removeView(relativeLayout);
            }
            relativeLayout.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            relativeLayout.setLayoutParams(layoutParams);
            g2 d4 = this.f36715a.d();
            if (d4 != null) {
                relativeLayout.setBackgroundColor(Color.parseColor(d4.l()));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                u3 u3Var = this.f36715a;
                u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
            }
            relativeLayout.removeAllViews();
            relativeLayout.addView(getTopSeparatorProgressBar());
            relativeLayout.addView(getCloseTextView());
            relativeLayout.addView(getTopLogoImageView());
            relativeLayout.addView(getRefreshTextView());
            this.f36726l = relativeLayout;
        }
        return relativeLayout;
    }

    private final ProgressBar getTopSeparatorProgressBar() {
        ProgressBar progressBar = this.f36730p;
        if (progressBar == null) {
            Unit unit = null;
            progressBar = new ProgressBar(getContext(), null, 16842872);
            if (progressBar.getParent() != null) {
                ((ViewGroup) progressBar.getParent()).removeView(progressBar);
            }
            progressBar.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, s5.a(progressBar, 2));
            layoutParams.addRule(3, getRefreshTextView().getId());
            progressBar.setLayoutParams(layoutParams);
            g2 d4 = this.f36715a.d();
            if (d4 != null) {
                progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor(d4.n())));
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.parseColor(d4.m())));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                u3 u3Var = this.f36715a;
                u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
            }
            this.f36730p = progressBar;
        }
        return progressBar;
    }

    private final void setBottomMediationContainer(RelativeLayout relativeLayout) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36724j);
        }
        this.f36724j = relativeLayout;
    }

    private final void setBottomMediationLogoImageView(ImageView imageView) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36728n);
        }
        this.f36728n = imageView;
    }

    private final void setBottomMediationSeparatorView(View view) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36729o);
        }
        this.f36729o = view;
    }

    private final void setBottomMediationSurveyByTextView(TextView textView) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36727m);
        }
        this.f36727m = textView;
    }

    private final void setCloseTextView(TextView textView) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36725k);
        }
        this.f36725k = textView;
    }

    private final void setRefreshTextView(TextView textView) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36731q);
        }
        this.f36731q = textView;
    }

    private final void setTopLogoImageView(ImageView imageView) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36732r);
        }
        this.f36732r = imageView;
    }

    private final void setTopMediationContainer(RelativeLayout relativeLayout) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36726l);
        }
        this.f36726l = relativeLayout;
    }

    private final void setTopSeparatorProgressBar(ProgressBar progressBar) {
        RelativeLayout surveyPanelContainer = getSurveyPanelContainer();
        if (surveyPanelContainer != null) {
            surveyPanelContainer.removeView(this.f36730p);
        }
        this.f36730p = progressBar;
    }

    public final TextView d() {
        Unit unit;
        TextView textView = new TextView(getContext());
        if (textView.getParent() != null) {
            ((ViewGroup) textView.getParent()).removeView(textView);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(20);
        layoutParams.addRule(15);
        textView.setLayoutParams(layoutParams);
        textView.setText("x");
        g2 d4 = this.f36715a.d();
        if (d4 != null) {
            textView.setTextColor(Color.parseColor(d4.o()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            u3 u3Var = this.f36715a;
            u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
        }
        textView.setPadding(s5.a(textView, 14), s5.a(textView, 8), s5.a(textView, 12), s5.a(textView, 12));
        textView.setTextSize(1, 20.0f);
        textView.setOnClickListener(new View.OnClickListener() { // from class: k1.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c3.a(c3.this, view);
            }
        });
        return textView;
    }

    @SuppressLint({"SetTextI18n"})
    public final TextView e() {
        TextView textView = new TextView(getContext());
        if (textView.getParent() != null) {
            ((ViewGroup) textView.getParent()).removeView(textView);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(15);
        textView.setLayoutParams(layoutParams);
        Unit unit = null;
        textView.setTypeface(null, 1);
        textView.setText(e5.a());
        g2 d4 = this.f36715a.d();
        if (d4 != null) {
            textView.setTextColor(Color.parseColor(d4.o()));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            u3 u3Var = this.f36715a;
            u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
        }
        textView.setPadding(s5.a(textView, 14), s5.a(textView, 8), s5.a(textView, 12), s5.a(textView, 12));
        textView.setTextSize(1, 20.0f);
        textView.setOnClickListener(new View.OnClickListener() { // from class: k1.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c3.b(c3.this, view);
            }
        });
        return textView;
    }

    public final RelativeLayout f() {
        Context context = getContext();
        if (context != null) {
            final RelativeLayout relativeLayout = new RelativeLayout(context);
            if (relativeLayout.getParent() != null) {
                ((ViewGroup) relativeLayout.getParent()).removeView(relativeLayout);
            }
            relativeLayout.setId(View.generateViewId());
            relativeLayout.setClipToPadding(true);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.setFocusable(true);
            relativeLayout.setClickable(true);
            s5.a(relativeLayout, new a(relativeLayout, this));
            Boolean.valueOf(relativeLayout.post(new Runnable() { // from class: k1.g
                @Override // java.lang.Runnable
                public final void run() {
                    c3.a(relativeLayout, this);
                }
            })).booleanValue();
            if (getHeightPercentage() == 100) {
                getWidthPercentage();
                return relativeLayout;
            }
            return relativeLayout;
        }
        return null;
    }

    public final void g() {
        boolean z3;
        this.f36715a.y();
        j3 j3Var = this.f36735u;
        int i4 = 0;
        if (j3Var != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (j3Var != null) {
                i4 = j3Var.f36931a;
            }
            if (i4 == 2) {
                if (j3Var != null) {
                    this.f36717c.a(j3Var.f36934d, j3Var.f36935e, j3Var.f36936f, j3Var.f36937g, new c(j3Var), null);
                    return;
                }
                return;
            }
        }
        this.f36715a.l();
    }

    public abstract int getHeightPercentage();

    @Override // com.pollfish.internal.z5
    @NotNull
    public u2 getPollfishLoadingView() {
        return getLoadingView();
    }

    @Nullable
    public final RelativeLayout getSurveyPanelContainer() {
        RelativeLayout relativeLayout = this.f36723i;
        if (relativeLayout == null) {
            RelativeLayout f4 = f();
            this.f36723i = f4;
            return f4;
        }
        return relativeLayout;
    }

    @NotNull
    public final u3 getViewModel() {
        return this.f36715a;
    }

    @NotNull
    public final u1.a<Boolean> getVisibilityObserver() {
        return this.f36719e;
    }

    @Nullable
    public final b4 getWebView() {
        b4 b4Var = this.f36722h;
        if (b4Var == null) {
            Context context = getContext();
            if (context != null) {
                b4Var = t5.d(context);
                if (b4Var.getParent() != null) {
                    ((ViewGroup) b4Var.getParent()).removeView(b4Var);
                }
                b4Var.setId(View.generateViewId());
                b4Var.setFocusable(true);
                b4Var.setFocusableInTouchMode(true);
                a(b4Var);
                b4Var.setPollfishWebChromeClient(new y3(this.f36715a, this));
            } else {
                b4Var = null;
            }
            this.f36722h = b4Var;
        }
        return b4Var;
    }

    public abstract int getWidthPercentage();

    public void h() {
        this.f36715a.k().b(this.f36721g);
        this.f36716b.a(this.f36720f);
    }

    public void i() {
        this.f36718d = getLayerType();
        setLayerType(2, null);
    }

    public void j() {
        t1 mediationWebChromeClient;
        u1<Integer> u1Var;
        b4 webView = getWebView();
        if (webView != null && (mediationWebChromeClient = webView.getMediationWebChromeClient()) != null && (u1Var = mediationWebChromeClient.f37224a) != null) {
            u1Var.b();
        }
        this.f36715a.k().c(this.f36721g);
        this.f36716b.b(this.f36720f);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (getVisibility() == 0 && getCurrentOrientation() != this.f36736v) {
            this.f36715a.t();
        }
    }

    public final void setSurveyPanelContainer(@Nullable RelativeLayout relativeLayout) {
        this.f36723i = relativeLayout;
    }

    public final void setWebView(@Nullable b4 b4Var) {
        this.f36722h = b4Var;
    }

    public static final void b(c3 c3Var, View view) {
        b4 webView = c3Var.getWebView();
        if (webView != null) {
            webView.a("javascript:window.location.reload(true)");
        }
    }

    public final void a(b4 b4Var) {
        u1<Integer> a4;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
        j3 j3Var = this.f36735u;
        if ((j3Var != null) && this.f36734t) {
            layoutParams.addRule(3, getTopMediationContainer().getId());
            layoutParams.addRule(12);
        } else {
            if ((j3Var != null) && !this.f36734t) {
                layoutParams.addRule(3, getTopMediationContainer().getId());
                layoutParams.addRule(2, getBottomMediationContainer().getId());
            } else {
                layoutParams.addRule(10);
                layoutParams.addRule(12);
            }
        }
        b4Var.setLayoutParams(layoutParams);
        if (this.f36735u != null) {
            t1 t1Var = new t1();
            t1Var.a().b(new d());
            b4Var.setPollfishWebChromeClient(t1Var);
            return;
        }
        t1 mediationWebChromeClient = b4Var.getMediationWebChromeClient();
        if (mediationWebChromeClient == null || (a4 = mediationWebChromeClient.a()) == null) {
            return;
        }
        a4.b();
    }

    @Override // com.pollfish.internal.z5
    public final void c() {
        requestFocus();
    }

    @Override // com.pollfish.internal.z5
    public final void b() {
        u2 loadingView = getLoadingView();
        if (loadingView != null) {
            loadingView.a();
        }
        b4 webView = getWebView();
        if (webView != null) {
            webView.a("javascript:Pollfish.mobile.interface.playVideo();");
        }
    }

    public static final void a(c3 c3Var, int i4) {
        Unit unit;
        String m4;
        ProgressBar topSeparatorProgressBar = c3Var.getTopSeparatorProgressBar();
        if (topSeparatorProgressBar != null) {
            topSeparatorProgressBar.setProgress(i4);
        }
        g2 d4 = c3Var.f36715a.d();
        if (d4 != null) {
            ProgressBar topSeparatorProgressBar2 = c3Var.getTopSeparatorProgressBar();
            if (topSeparatorProgressBar2 != null) {
                if (i4 == 100) {
                    m4 = d4.n();
                } else {
                    m4 = d4.m();
                }
                topSeparatorProgressBar2.setProgressTintList(ColorStateList.valueOf(Color.parseColor(m4)));
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            u3 u3Var = c3Var.f36715a;
            u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
        }
    }

    public static final void d(c3 c3Var) {
        c3Var.f36735u = null;
        s5.a(c3Var, new f3(c3Var));
    }

    public static final void a(c3 c3Var, RelativeLayout relativeLayout) {
        c3Var.setTopMediationContainer(null);
        c3Var.setBottomMediationContainer(null);
        c3Var.setTopSeparatorProgressBar(null);
        c3Var.setCloseTextView(null);
        c3Var.setTopLogoImageView(null);
        c3Var.setRefreshTextView(null);
        c3Var.setBottomMediationSeparatorView(null);
        c3Var.setBottomMediationLogoImageView(null);
        c3Var.setBottomMediationSurveyByTextView(null);
        relativeLayout.addView(c3Var.getTopMediationContainer());
        c3Var.f36734t = false;
        relativeLayout.addView(c3Var.getBottomMediationContainer());
        if (c3Var.f36734t) {
            relativeLayout.removeView(c3Var.getBottomMediationContainer());
        }
    }

    public static final void a(c3 c3Var, View view) {
        c3Var.g();
    }

    public static final void a(RelativeLayout relativeLayout, c3 c3Var) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((c3Var.getWidthPercentage() * relativeLayout.getWidth()) / 100, (c3Var.getHeightPercentage() * relativeLayout.getHeight()) / 100);
        layoutParams.addRule(15);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.requestLayout();
    }

    public static final void a(c3 c3Var, j3 j3Var) {
        c3Var.f36735u = j3Var;
        s5.a(c3Var, new h3(c3Var));
    }

    @Override // com.pollfish.internal.z5
    public final void a(@NotNull View view) {
        Context context = getContext();
        if (context != null) {
            new t3(context, view, this.f36715a, this.f36716b);
            return;
        }
        this.f36715a.n();
        Unit unit = Unit.INSTANCE;
    }

    @Override // com.pollfish.internal.z5
    public final void a() {
        u2 loadingView = getLoadingView();
        if (loadingView != null) {
            loadingView.b();
        }
    }

    public void a(boolean z3, boolean z4) {
        s5.a(this, new b(z4));
    }
}
