package com.arlosoft.macrodroid.bubbleshowcase;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCase;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BubbleShowCaseBuilder.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BubbleShowCaseBuilder {
    public static final int $stable = 8;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f9532a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Drawable f9533b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f9534c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f9535d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Drawable f9536e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Integer f9537f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Integer f9538g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Integer f9539h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Integer f9540i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private BubbleShowCase.HighlightMode f9541j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9542k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9543l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private String f9544m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private Boolean f9545n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Boolean f9546o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList<BubbleShowCase.ArrowPosition> f9547p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private WeakReference<View> f9548q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private BubbleShowCaseListener f9549r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private SequenceShowCaseListener f9550s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f9551t;

    public BubbleShowCaseBuilder(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f9547p = new ArrayList<>();
        this.f9532a = new WeakReference<>(activity);
    }

    private final BubbleShowCase b() {
        if (this.f9545n == null) {
            this.f9545n = Boolean.TRUE;
        }
        if (this.f9546o == null) {
            this.f9546o = Boolean.TRUE;
        }
        return new BubbleShowCase(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(BubbleShowCase bubbleShowCase, View view, BubbleShowCaseBuilder this$0) {
        Intrinsics.checkNotNullParameter(bubbleShowCase, "$bubbleShowCase");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bubbleShowCase.show();
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this$0.f9551t);
    }

    @NotNull
    public final BubbleShowCaseBuilder arrowPosition(@NotNull BubbleShowCase.ArrowPosition arrowPosition) {
        Intrinsics.checkNotNullParameter(arrowPosition, "arrowPosition");
        this.f9547p.clear();
        this.f9547p.add(arrowPosition);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder backgroundColor(int i4) {
        this.f9537f = Integer.valueOf(i4);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder backgroundColorResourceId(int i4) {
        WeakReference<Activity> weakReference = this.f9532a;
        Intrinsics.checkNotNull(weakReference);
        Activity activity = weakReference.get();
        Intrinsics.checkNotNull(activity);
        this.f9537f = Integer.valueOf(ContextCompat.getColor(activity, i4));
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder closeActionImage(@Nullable Drawable drawable) {
        this.f9536e = drawable;
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder closeActionImageResourceId(int i4) {
        WeakReference<Activity> weakReference = this.f9532a;
        Intrinsics.checkNotNull(weakReference);
        Activity activity = weakReference.get();
        Intrinsics.checkNotNull(activity);
        this.f9536e = ContextCompat.getDrawable(activity, i4);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder description(@NotNull String subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        this.f9535d = subtitle;
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder descriptionTextSize(int i4) {
        this.f9540i = Integer.valueOf(i4);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder disableCloseAction(boolean z3) {
        this.f9543l = z3;
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder disableTargetClick(boolean z3) {
        this.f9542k = z3;
        return this;
    }

    @Nullable
    public final WeakReference<Activity> getMActivity$app_standardRelease() {
        return this.f9532a;
    }

    @NotNull
    public final ArrayList<BubbleShowCase.ArrowPosition> getMArrowPositionList$app_standardRelease() {
        return this.f9547p;
    }

    @Nullable
    public final Integer getMBackgroundColor$app_standardRelease() {
        return this.f9537f;
    }

    @Nullable
    public final BubbleShowCaseListener getMBubbleShowCaseListener$app_standardRelease() {
        return this.f9549r;
    }

    @Nullable
    public final Drawable getMCloseAction$app_standardRelease() {
        return this.f9536e;
    }

    public final boolean getMDisableCloseAction$app_standardRelease() {
        return this.f9543l;
    }

    public final boolean getMDisableTargetClick$app_standardRelease() {
        return this.f9542k;
    }

    @Nullable
    public final BubbleShowCase.HighlightMode getMHighlightMode$app_standardRelease() {
        return this.f9541j;
    }

    @Nullable
    public final Drawable getMImage$app_standardRelease() {
        return this.f9533b;
    }

    @Nullable
    public final Boolean getMIsFirstOfSequence$app_standardRelease() {
        return this.f9545n;
    }

    @Nullable
    public final Boolean getMIsLastOfSequence$app_standardRelease() {
        return this.f9546o;
    }

    @Nullable
    public final SequenceShowCaseListener getMSequenceShowCaseListener$app_standardRelease() {
        return this.f9550s;
    }

    @Nullable
    public final String getMShowOnce$app_standardRelease() {
        return this.f9544m;
    }

    @Nullable
    public final String getMSubtitle$app_standardRelease() {
        return this.f9535d;
    }

    @Nullable
    public final Integer getMSubtitleTextSize$app_standardRelease() {
        return this.f9540i;
    }

    @Nullable
    public final WeakReference<View> getMTargetView$app_standardRelease() {
        return this.f9548q;
    }

    @Nullable
    public final Integer getMTextColor$app_standardRelease() {
        return this.f9538g;
    }

    @Nullable
    public final String getMTitle$app_standardRelease() {
        return this.f9534c;
    }

    @Nullable
    public final Integer getMTitleTextSize$app_standardRelease() {
        return this.f9539h;
    }

    @NotNull
    public final BubbleShowCaseBuilder highlightMode(@NotNull BubbleShowCase.HighlightMode highlightMode) {
        Intrinsics.checkNotNullParameter(highlightMode, "highlightMode");
        this.f9541j = highlightMode;
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder image(@NotNull Drawable image) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.f9533b = image;
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder imageResourceId(int i4) {
        WeakReference<Activity> weakReference = this.f9532a;
        Intrinsics.checkNotNull(weakReference);
        Activity activity = weakReference.get();
        Intrinsics.checkNotNull(activity);
        this.f9533b = ContextCompat.getDrawable(activity, i4);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder isFirstOfSequence$app_standardRelease(boolean z3) {
        this.f9545n = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder isLastOfSequence$app_standardRelease(boolean z3) {
        this.f9546o = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder listener(@NotNull BubbleShowCaseListener bubbleShowCaseListener) {
        Intrinsics.checkNotNullParameter(bubbleShowCaseListener, "bubbleShowCaseListener");
        this.f9549r = bubbleShowCaseListener;
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder sequenceListener$app_standardRelease(@NotNull SequenceShowCaseListener sequenceShowCaseListener) {
        Intrinsics.checkNotNullParameter(sequenceShowCaseListener, "sequenceShowCaseListener");
        this.f9550s = sequenceShowCaseListener;
        return this;
    }

    public final void setMActivity$app_standardRelease(@Nullable WeakReference<Activity> weakReference) {
        this.f9532a = weakReference;
    }

    public final void setMBackgroundColor$app_standardRelease(@Nullable Integer num) {
        this.f9537f = num;
    }

    public final void setMBubbleShowCaseListener$app_standardRelease(@Nullable BubbleShowCaseListener bubbleShowCaseListener) {
        this.f9549r = bubbleShowCaseListener;
    }

    public final void setMCloseAction$app_standardRelease(@Nullable Drawable drawable) {
        this.f9536e = drawable;
    }

    public final void setMDisableCloseAction$app_standardRelease(boolean z3) {
        this.f9543l = z3;
    }

    public final void setMDisableTargetClick$app_standardRelease(boolean z3) {
        this.f9542k = z3;
    }

    public final void setMHighlightMode$app_standardRelease(@Nullable BubbleShowCase.HighlightMode highlightMode) {
        this.f9541j = highlightMode;
    }

    public final void setMImage$app_standardRelease(@Nullable Drawable drawable) {
        this.f9533b = drawable;
    }

    public final void setMIsFirstOfSequence$app_standardRelease(@Nullable Boolean bool) {
        this.f9545n = bool;
    }

    public final void setMIsLastOfSequence$app_standardRelease(@Nullable Boolean bool) {
        this.f9546o = bool;
    }

    public final void setMSequenceShowCaseListener$app_standardRelease(@Nullable SequenceShowCaseListener sequenceShowCaseListener) {
        this.f9550s = sequenceShowCaseListener;
    }

    public final void setMShowOnce$app_standardRelease(@Nullable String str) {
        this.f9544m = str;
    }

    public final void setMSubtitle$app_standardRelease(@Nullable String str) {
        this.f9535d = str;
    }

    public final void setMSubtitleTextSize$app_standardRelease(@Nullable Integer num) {
        this.f9540i = num;
    }

    public final void setMTargetView$app_standardRelease(@Nullable WeakReference<View> weakReference) {
        this.f9548q = weakReference;
    }

    public final void setMTextColor$app_standardRelease(@Nullable Integer num) {
        this.f9538g = num;
    }

    public final void setMTitle$app_standardRelease(@Nullable String str) {
        this.f9534c = str;
    }

    public final void setMTitleTextSize$app_standardRelease(@Nullable Integer num) {
        this.f9539h = num;
    }

    @NotNull
    public final BubbleShowCase show() {
        final BubbleShowCase b4 = b();
        WeakReference<View> weakReference = this.f9548q;
        if (weakReference != null) {
            Intrinsics.checkNotNull(weakReference);
            final View view = weakReference.get();
            Intrinsics.checkNotNull(view);
            if (view.getHeight() != 0 && view.getWidth() != 0) {
                b4.show();
            } else {
                this.f9551t = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: w.f
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        BubbleShowCaseBuilder.c(BubbleShowCase.this, view, this);
                    }
                };
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.f9551t);
            }
        } else {
            b4.show();
        }
        return b4;
    }

    @NotNull
    public final BubbleShowCaseBuilder showOnce(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f9544m = id;
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder targetView(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.f9548q = new WeakReference<>(targetView);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder textColor(int i4) {
        this.f9538g = Integer.valueOf(i4);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder textColorResourceId(int i4) {
        WeakReference<Activity> weakReference = this.f9532a;
        Intrinsics.checkNotNull(weakReference);
        Activity activity = weakReference.get();
        Intrinsics.checkNotNull(activity);
        this.f9538g = Integer.valueOf(ContextCompat.getColor(activity, i4));
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder title(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.f9534c = title;
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder titleTextSize(int i4) {
        this.f9539h = Integer.valueOf(i4);
        return this;
    }

    @NotNull
    public final BubbleShowCaseBuilder arrowPosition(@NotNull List<? extends BubbleShowCase.ArrowPosition> arrowPosition) {
        Intrinsics.checkNotNullParameter(arrowPosition, "arrowPosition");
        this.f9547p.clear();
        this.f9547p.addAll(arrowPosition);
        return this;
    }
}
