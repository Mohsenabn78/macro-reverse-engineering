package com.arlosoft.macrodroid.bubbleshowcase;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleMessageView;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCase;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BubbleShowCase.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nBubbleShowCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BubbleShowCase.kt\ncom/arlosoft/macrodroid/bubbleshowcase/BubbleShowCase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,431:1\n1#2:432\n*E\n"})
/* loaded from: classes3.dex */
public final class BubbleShowCase {
    public static final int $stable = 8;
    @Nullable
    private BubbleMessageView.Builder A;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f9503a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9504b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9505c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9506d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9507e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9508f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final WeakReference<Activity> f9509g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f9510h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final String f9511i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final String f9512j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final Drawable f9513k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final Integer f9514l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final Integer f9515m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private final Integer f9516n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private final Integer f9517o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private final String f9518p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f9519q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f9520r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private final HighlightMode f9521s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final List<ArrowPosition> f9522t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private final WeakReference<View> f9523u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    private final BubbleShowCaseListener f9524v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    private final SequenceShowCaseListener f9525w;

    /* renamed from: x  reason: collision with root package name */
    private final boolean f9526x;

    /* renamed from: y  reason: collision with root package name */
    private final boolean f9527y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    private RelativeLayout f9528z;

    /* compiled from: BubbleShowCase.kt */
    /* loaded from: classes3.dex */
    public enum ArrowPosition {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    /* compiled from: BubbleShowCase.kt */
    /* loaded from: classes3.dex */
    public enum HighlightMode {
        VIEW_LAYOUT,
        VIEW_SURFACE
    }

    /* compiled from: BubbleShowCase.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArrowPosition.values().length];
            try {
                iArr[ArrowPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArrowPosition.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArrowPosition.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArrowPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BubbleShowCase(@NotNull BubbleShowCaseBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f9503a = "BubbleShowCasePrefs";
        this.f9504b = 731;
        this.f9505c = 200;
        this.f9507e = 700;
        this.f9508f = 420;
        WeakReference<Activity> mActivity$app_standardRelease = builder.getMActivity$app_standardRelease();
        Intrinsics.checkNotNull(mActivity$app_standardRelease);
        this.f9509g = mActivity$app_standardRelease;
        this.f9510h = builder.getMImage$app_standardRelease();
        this.f9511i = builder.getMTitle$app_standardRelease();
        this.f9512j = builder.getMSubtitle$app_standardRelease();
        this.f9513k = builder.getMCloseAction$app_standardRelease();
        this.f9514l = builder.getMBackgroundColor$app_standardRelease();
        this.f9515m = builder.getMTextColor$app_standardRelease();
        this.f9516n = builder.getMTitleTextSize$app_standardRelease();
        this.f9517o = builder.getMSubtitleTextSize$app_standardRelease();
        this.f9518p = builder.getMShowOnce$app_standardRelease();
        this.f9519q = builder.getMDisableTargetClick$app_standardRelease();
        this.f9520r = builder.getMDisableCloseAction$app_standardRelease();
        this.f9521s = builder.getMHighlightMode$app_standardRelease();
        this.f9522t = builder.getMArrowPositionList$app_standardRelease();
        this.f9523u = builder.getMTargetView$app_standardRelease();
        this.f9524v = builder.getMBubbleShowCaseListener$app_standardRelease();
        this.f9525w = builder.getMSequenceShowCaseListener$app_standardRelease();
        Boolean mIsFirstOfSequence$app_standardRelease = builder.getMIsFirstOfSequence$app_standardRelease();
        Intrinsics.checkNotNull(mIsFirstOfSequence$app_standardRelease);
        this.f9526x = mIsFirstOfSequence$app_standardRelease.booleanValue();
        Boolean mIsLastOfSequence$app_standardRelease = builder.getMIsLastOfSequence$app_standardRelease();
        Intrinsics.checkNotNull(mIsLastOfSequence$app_standardRelease);
        this.f9527y = mIsLastOfSequence$app_standardRelease.booleanValue();
    }

    private final void A(SharedPreferences sharedPreferences, String str, String str2) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(BubbleShowCase this$0) {
        List<ArrowPosition> list;
        ArrowPosition arrowPosition;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.f9523u.get();
        Intrinsics.checkNotNull(view);
        View view2 = view;
        if (this$0.f9522t.isEmpty()) {
            ScreenUtils screenUtils = ScreenUtils.INSTANCE;
            Activity activity = this$0.f9509g.get();
            Intrinsics.checkNotNull(activity);
            if (screenUtils.isViewLocatedAtHalfTopOfTheScreen(activity, view2)) {
                list = this$0.f9522t;
                arrowPosition = ArrowPosition.TOP;
            } else {
                list = this$0.f9522t;
                arrowPosition = ArrowPosition.BOTTOM;
            }
            list.add(arrowPosition);
            this$0.A = this$0.j();
        }
        if (this$0.v(view2)) {
            this$0.f(view2, this$0.f9528z);
            BubbleMessageView.Builder builder = this$0.A;
            Intrinsics.checkNotNull(builder);
            this$0.d(view2, builder, this$0.f9528z);
            return;
        }
        this$0.dismiss();
    }

    private final Bitmap C(View view, HighlightMode highlightMode) {
        if (highlightMode != null && highlightMode != HighlightMode.VIEW_LAYOUT) {
            return E(view);
        }
        return D(view);
    }

    private final Bitmap D(View view) {
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            Activity activity = this.f9509g.get();
            Intrinsics.checkNotNull(activity);
            View childAt = q(activity).getChildAt(0);
            childAt.buildDrawingCache();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(childAt.getDrawingCache(), r(view), s(view), view.getWidth(), view.getHeight());
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(currentScre…width, targetView.height)");
                childAt.setDrawingCacheEnabled(false);
                childAt.destroyDrawingCache();
                return createBitmap;
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    private final Bitmap E(View view) {
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            view.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(targetView.drawingCache)");
            view.setDrawingCacheEnabled(false);
            return createBitmap;
        }
        return null;
    }

    private final void d(View view, BubbleMessageView.Builder builder, RelativeLayout relativeLayout) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int i16 = WhenMappings.$EnumSwitchMapping$0[builder.getMArrowPosition().get(0).ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        layoutParams.addRule(12);
                        ScreenUtils screenUtils = ScreenUtils.INSTANCE;
                        Activity activity = this.f9509g.get();
                        Intrinsics.checkNotNull(activity);
                        if (screenUtils.isViewLocatedAtHalfLeftOfTheScreen(activity, view)) {
                            if (u()) {
                                i14 = r(view);
                            } else {
                                i14 = 0;
                            }
                            if (u()) {
                                Activity activity2 = this.f9509g.get();
                                Intrinsics.checkNotNull(activity2);
                                int o4 = o(activity2) - r(view);
                                Activity activity3 = this.f9509g.get();
                                Intrinsics.checkNotNull(activity3);
                                i15 = o4 - k(o(activity3) - r(view));
                            } else {
                                i15 = 0;
                            }
                            Activity activity4 = this.f9509g.get();
                            Intrinsics.checkNotNull(activity4);
                            layoutParams.setMargins(i14, 0, i15, l(activity4) - s(view));
                        } else {
                            if (u()) {
                                i12 = (r(view) + view.getWidth()) - k(r(view));
                            } else {
                                i12 = 0;
                            }
                            if (u()) {
                                Activity activity5 = this.f9509g.get();
                                Intrinsics.checkNotNull(activity5);
                                i13 = (o(activity5) - r(view)) - view.getWidth();
                            } else {
                                i13 = 0;
                            }
                            Activity activity6 = this.f9509g.get();
                            Intrinsics.checkNotNull(activity6);
                            layoutParams.setMargins(i12, 0, i13, l(activity6) - s(view));
                        }
                    }
                } else {
                    layoutParams.addRule(10);
                    ScreenUtils screenUtils2 = ScreenUtils.INSTANCE;
                    Activity activity7 = this.f9509g.get();
                    Intrinsics.checkNotNull(activity7);
                    if (screenUtils2.isViewLocatedAtHalfLeftOfTheScreen(activity7, view)) {
                        if (u()) {
                            i10 = r(view);
                        } else {
                            i10 = 0;
                        }
                        int s3 = s(view) + view.getHeight();
                        if (u()) {
                            Activity activity8 = this.f9509g.get();
                            Intrinsics.checkNotNull(activity8);
                            int o5 = o(activity8) - r(view);
                            Activity activity9 = this.f9509g.get();
                            Intrinsics.checkNotNull(activity9);
                            i11 = o5 - k(o(activity9) - r(view));
                        } else {
                            i11 = 0;
                        }
                        layoutParams.setMargins(i10, s3, i11, 0);
                    } else {
                        if (u()) {
                            i8 = (r(view) + view.getWidth()) - k(r(view));
                        } else {
                            i8 = 0;
                        }
                        int s4 = s(view) + view.getHeight();
                        if (u()) {
                            Activity activity10 = this.f9509g.get();
                            Intrinsics.checkNotNull(activity10);
                            i9 = (o(activity10) - r(view)) - view.getWidth();
                        } else {
                            i9 = 0;
                        }
                        layoutParams.setMargins(i8, s4, i9, 0);
                    }
                }
            } else {
                layoutParams.addRule(11);
                ScreenUtils screenUtils3 = ScreenUtils.INSTANCE;
                Activity activity11 = this.f9509g.get();
                Intrinsics.checkNotNull(activity11);
                if (screenUtils3.isViewLocatedAtHalfTopOfTheScreen(activity11, view)) {
                    if (u()) {
                        i7 = r(view) - k(r(view));
                    } else {
                        i7 = 0;
                    }
                    int s5 = s(view);
                    Activity activity12 = this.f9509g.get();
                    Intrinsics.checkNotNull(activity12);
                    layoutParams.setMargins(i7, s5, o(activity12) - r(view), 0);
                    layoutParams.addRule(10);
                } else {
                    if (u()) {
                        i6 = r(view) - k(r(view));
                    } else {
                        i6 = 0;
                    }
                    Activity activity13 = this.f9509g.get();
                    Intrinsics.checkNotNull(activity13);
                    int o6 = o(activity13) - r(view);
                    Activity activity14 = this.f9509g.get();
                    Intrinsics.checkNotNull(activity14);
                    layoutParams.setMargins(i6, 0, o6, (l(activity14) - s(view)) - view.getHeight());
                    layoutParams.addRule(12);
                }
            }
        } else {
            layoutParams.addRule(9);
            ScreenUtils screenUtils4 = ScreenUtils.INSTANCE;
            Activity activity15 = this.f9509g.get();
            Intrinsics.checkNotNull(activity15);
            if (screenUtils4.isViewLocatedAtHalfTopOfTheScreen(activity15, view)) {
                int r4 = r(view) + view.getWidth();
                int s6 = s(view);
                if (u()) {
                    Activity activity16 = this.f9509g.get();
                    Intrinsics.checkNotNull(activity16);
                    int o7 = o(activity16) - (r(view) + view.getWidth());
                    Activity activity17 = this.f9509g.get();
                    Intrinsics.checkNotNull(activity17);
                    i5 = o7 - k(o(activity17) - (r(view) + view.getWidth()));
                } else {
                    i5 = 0;
                }
                layoutParams.setMargins(r4, s6, i5, 0);
                layoutParams.addRule(10);
            } else {
                int r5 = r(view) + view.getWidth();
                if (u()) {
                    Activity activity18 = this.f9509g.get();
                    Intrinsics.checkNotNull(activity18);
                    int o8 = o(activity18) - (r(view) + view.getWidth());
                    Activity activity19 = this.f9509g.get();
                    Intrinsics.checkNotNull(activity19);
                    i4 = o8 - k(o(activity19) - (r(view) + view.getWidth()));
                } else {
                    i4 = 0;
                }
                Activity activity20 = this.f9509g.get();
                Intrinsics.checkNotNull(activity20);
                layoutParams.setMargins(r5, 0, i4, (l(activity20) - s(view)) - view.getHeight());
                layoutParams.addRule(12);
            }
        }
        BubbleMessageView build = builder.targetViewScreenLocation(new RectF(r(view), s(view), r(view) + view.getWidth(), s(view) + view.getHeight())).build();
        build.setId(h());
        AnimationUtils animationUtils = AnimationUtils.INSTANCE;
        Animation scaleAnimation = animationUtils.getScaleAnimation(0, this.f9505c);
        if (relativeLayout != null) {
            relativeLayout.addView(animationUtils.setAnimationToView(build, scaleAnimation), layoutParams);
        }
    }

    private final void e(BubbleMessageView.Builder builder, RelativeLayout relativeLayout) {
        int i4;
        int i5;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        BubbleMessageView build = builder.build();
        build.setId(h());
        if (u()) {
            if (u()) {
                Activity activity = this.f9509g.get();
                Intrinsics.checkNotNull(activity);
                i4 = (o(activity) / 2) - (ScreenUtils.INSTANCE.dpToPx(this.f9508f) / 2);
            } else {
                i4 = 0;
            }
            if (u()) {
                Activity activity2 = this.f9509g.get();
                Intrinsics.checkNotNull(activity2);
                i5 = (o(activity2) / 2) - (ScreenUtils.INSTANCE.dpToPx(this.f9508f) / 2);
            } else {
                i5 = 0;
            }
            layoutParams.setMargins(i4, 0, i5, 0);
        }
        AnimationUtils animationUtils = AnimationUtils.INSTANCE;
        Animation scaleAnimation = animationUtils.getScaleAnimation(0, this.f9505c);
        if (relativeLayout != null) {
            relativeLayout.addView(animationUtils.setAnimationToView(build, scaleAnimation), layoutParams);
        }
    }

    private final void f(View view, RelativeLayout relativeLayout) {
        if (view == null) {
            return;
        }
        Bitmap C = C(view, this.f9521s);
        Activity activity = this.f9509g.get();
        Intrinsics.checkNotNull(activity);
        ImageView imageView = new ImageView(activity);
        imageView.setImageBitmap(C);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: w.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BubbleShowCase.g(BubbleShowCase.this, view2);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int r4 = r(view);
        int s3 = s(view);
        Activity activity2 = this.f9509g.get();
        Intrinsics.checkNotNull(activity2);
        layoutParams.setMargins(r4, s3, o(activity2) - (r(view) + view.getWidth()), 0);
        if (relativeLayout != null) {
            relativeLayout.addView(imageView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BubbleShowCase this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.f9519q) {
            this$0.dismiss();
        }
        BubbleShowCaseListener bubbleShowCaseListener = this$0.f9524v;
        if (bubbleShowCaseListener != null) {
            bubbleShowCaseListener.onTargetClick(this$0);
        }
    }

    private final int h() {
        return View.generateViewId();
    }

    private final RelativeLayout i() {
        Activity activity = this.f9509g.get();
        Intrinsics.checkNotNull(activity);
        if (activity.findViewById(this.f9504b) != null) {
            Activity activity2 = this.f9509g.get();
            Intrinsics.checkNotNull(activity2);
            View findViewById = activity2.findViewById(this.f9504b);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mActivity.get()!!.findVi…yId(FOREGROUND_LAYOUT_ID)");
            return (RelativeLayout) findViewById;
        }
        Activity activity3 = this.f9509g.get();
        Intrinsics.checkNotNull(activity3);
        RelativeLayout relativeLayout = new RelativeLayout(activity3);
        relativeLayout.setId(this.f9504b);
        relativeLayout.setFitsSystemWindows(false);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        Activity activity4 = this.f9509g.get();
        Intrinsics.checkNotNull(activity4);
        relativeLayout.setBackgroundColor(ContextCompat.getColor(activity4, R.color.black_slight_transparent));
        relativeLayout.setClickable(true);
        return relativeLayout;
    }

    private final BubbleMessageView.Builder j() {
        BubbleMessageView.Builder builder = new BubbleMessageView.Builder();
        Activity activity = this.f9509g.get();
        Intrinsics.checkNotNull(activity);
        return builder.from(activity).arrowPosition(this.f9522t).backgroundColor(this.f9514l).textColor(this.f9515m).titleTextSize(this.f9516n).subtitleTextSize(this.f9517o).title(this.f9511i).subtitle(this.f9512j).image(this.f9510h).closeActionImage(this.f9513k).disableCloseAction(this.f9520r).listener(new OnBubbleMessageViewListener() { // from class: com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCase$getBubbleMessageViewBuilder$1
            @Override // com.arlosoft.macrodroid.bubbleshowcase.OnBubbleMessageViewListener
            public void onBubbleClick() {
                BubbleShowCaseListener bubbleShowCaseListener;
                bubbleShowCaseListener = BubbleShowCase.this.f9524v;
                if (bubbleShowCaseListener != null) {
                    bubbleShowCaseListener.onBubbleClick(BubbleShowCase.this);
                }
            }

            @Override // com.arlosoft.macrodroid.bubbleshowcase.OnBubbleMessageViewListener
            public void onCloseActionImageClick() {
                BubbleShowCaseListener bubbleShowCaseListener;
                BubbleShowCase.this.dismiss();
                bubbleShowCaseListener = BubbleShowCase.this.f9524v;
                if (bubbleShowCaseListener != null) {
                    bubbleShowCaseListener.onCloseActionImageClick(BubbleShowCase.this);
                }
            }
        });
    }

    private final int k(int i4) {
        ScreenUtils screenUtils = ScreenUtils.INSTANCE;
        if (i4 > screenUtils.dpToPx(this.f9508f)) {
            return screenUtils.dpToPx(this.f9508f);
        }
        return i4;
    }

    private final int l(Context context) {
        return ScreenUtils.INSTANCE.getScreenHeight(context) - n();
    }

    private final int m() {
        RelativeLayout relativeLayout = this.f9528z;
        if (relativeLayout != null) {
            ScreenUtils screenUtils = ScreenUtils.INSTANCE;
            Intrinsics.checkNotNull(relativeLayout);
            return screenUtils.getAxisXpositionOfViewOnScreen(relativeLayout);
        }
        return 0;
    }

    private final int n() {
        RelativeLayout relativeLayout = this.f9528z;
        if (relativeLayout != null) {
            ScreenUtils screenUtils = ScreenUtils.INSTANCE;
            Intrinsics.checkNotNull(relativeLayout);
            return screenUtils.getAxisYpositionOfViewOnScreen(relativeLayout);
        }
        return 0;
    }

    private final int o(Context context) {
        return ScreenUtils.INSTANCE.getScreenWidth(context) - m();
    }

    private final String p(SharedPreferences sharedPreferences, String str) {
        return sharedPreferences.getString(str, null);
    }

    private final ViewGroup q(Activity activity) {
        ViewParent parent = ((ViewGroup) activity.findViewById(16908290)).getParent().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) parent;
    }

    private final int r(View view) {
        return ScreenUtils.INSTANCE.getAxisXpositionOfViewOnScreen(view) - m();
    }

    private final int s(View view) {
        return ScreenUtils.INSTANCE.getAxisYpositionOfViewOnScreen(view) - n();
    }

    private final boolean t(String str) {
        Activity activity = this.f9509g.get();
        Intrinsics.checkNotNull(activity);
        SharedPreferences mPrefs = activity.getSharedPreferences(this.f9503a, 0);
        Intrinsics.checkNotNullExpressionValue(mPrefs, "mPrefs");
        if (p(mPrefs, str) == null) {
            return false;
        }
        return true;
    }

    private final boolean u() {
        Activity activity = this.f9509g.get();
        Intrinsics.checkNotNull(activity);
        return activity.getResources().getBoolean(R.bool.is_tablet);
    }

    private final boolean v(View view) {
        if (view == null || r(view) < 0 || s(view) < 0) {
            return false;
        }
        if (r(view) == 0 && s(view) == 0) {
            return false;
        }
        return true;
    }

    private final void w() {
        SequenceShowCaseListener sequenceShowCaseListener = this.f9525w;
        if (sequenceShowCaseListener != null) {
            sequenceShowCaseListener.onDismiss();
        }
    }

    private final void x(String str) {
        Activity activity = this.f9509g.get();
        Intrinsics.checkNotNull(activity);
        SharedPreferences mPrefs = activity.getSharedPreferences(this.f9503a, 0);
        Intrinsics.checkNotNullExpressionValue(mPrefs, "mPrefs");
        A(mPrefs, str, str);
    }

    private final void y(RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: w.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BubbleShowCase.z(BubbleShowCase.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(BubbleShowCase this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BubbleShowCaseListener bubbleShowCaseListener = this$0.f9524v;
        if (bubbleShowCaseListener != null) {
            bubbleShowCaseListener.onBackgroundDimClick(this$0);
        }
    }

    public final void dismiss() {
        RelativeLayout relativeLayout = this.f9528z;
        if (relativeLayout != null && this.f9527y) {
            finishSequence();
        } else if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        w();
    }

    public final void finishSequence() {
        Activity activity = this.f9509g.get();
        Intrinsics.checkNotNull(activity);
        q(activity).removeView(this.f9528z);
        this.f9528z = null;
    }

    public final void show() {
        try {
            String str = this.f9518p;
            if (str != null) {
                if (t(str)) {
                    w();
                    return;
                }
                x(this.f9518p);
            }
            Activity activity = this.f9509g.get();
            Intrinsics.checkNotNull(activity);
            ViewGroup q4 = q(activity);
            RelativeLayout i4 = i();
            this.f9528z = i4;
            y(i4);
            this.A = j();
            if (this.f9523u != null && this.f9522t.size() <= 1) {
                new Handler().postDelayed(new Runnable() { // from class: w.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        BubbleShowCase.B(BubbleShowCase.this);
                    }
                }, this.f9506d);
            } else {
                BubbleMessageView.Builder builder = this.A;
                Intrinsics.checkNotNull(builder);
                e(builder, this.f9528z);
            }
            if (this.f9526x) {
                AnimationUtils animationUtils = AnimationUtils.INSTANCE;
                Animation fadeInAnimation = animationUtils.getFadeInAnimation(0, this.f9506d);
                RelativeLayout relativeLayout = this.f9528z;
                if (relativeLayout != null) {
                    Intrinsics.checkNotNull(relativeLayout);
                    q4.addView(animationUtils.setAnimationToView(relativeLayout, fadeInAnimation));
                }
            }
        } catch (Exception unused) {
        }
    }
}
