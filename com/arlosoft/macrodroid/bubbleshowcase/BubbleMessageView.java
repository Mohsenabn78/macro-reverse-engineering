package com.arlosoft.macrodroid.bubbleshowcase;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleMessageView;
import com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BubbleMessageView.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nBubbleMessageView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BubbleMessageView.kt\ncom/arlosoft/macrodroid/bubbleshowcase/BubbleMessageView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,327:1\n1#2:328\n*E\n"})
/* loaded from: classes3.dex */
public final class BubbleMessageView extends ConstraintLayout {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private final int f9480a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private View f9481b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ImageView f9482c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private TextView f9483d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private TextView f9484e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ImageView f9485f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ConstraintLayout f9486g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private RectF f9487h;

    /* renamed from: i  reason: collision with root package name */
    private int f9488i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<BubbleShowCase.ArrowPosition> f9489j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Paint f9490k;

    /* compiled from: BubbleMessageView.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Builder {
        public static final int $stable = 8;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private RectF f9491a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Drawable f9492b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Boolean f9493c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private String f9494d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f9495e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private Drawable f9496f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private Integer f9497g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private Integer f9498h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private Integer f9499i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private Integer f9500j;
        @NotNull

        /* renamed from: k  reason: collision with root package name */
        private ArrayList<BubbleShowCase.ArrowPosition> f9501k = new ArrayList<>();
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private OnBubbleMessageViewListener f9502l;
        public WeakReference<Context> mContext;

        @NotNull
        public final Builder arrowPosition(@NotNull List<? extends BubbleShowCase.ArrowPosition> arrowPosition) {
            Intrinsics.checkNotNullParameter(arrowPosition, "arrowPosition");
            this.f9501k.clear();
            this.f9501k.addAll(arrowPosition);
            return this;
        }

        @NotNull
        public final Builder backgroundColor(@Nullable Integer num) {
            this.f9497g = num;
            return this;
        }

        @NotNull
        public final BubbleMessageView build() {
            Context context = getMContext().get();
            Intrinsics.checkNotNull(context);
            return new BubbleMessageView(context, this);
        }

        @NotNull
        public final Builder closeActionImage(@Nullable Drawable drawable) {
            this.f9496f = drawable;
            return this;
        }

        @NotNull
        public final Builder disableCloseAction(boolean z3) {
            this.f9493c = Boolean.valueOf(z3);
            return this;
        }

        @NotNull
        public final Builder from(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            setMContext(new WeakReference<>(context));
            return this;
        }

        @NotNull
        public final ArrayList<BubbleShowCase.ArrowPosition> getMArrowPosition() {
            return this.f9501k;
        }

        @Nullable
        public final Integer getMBackgroundColor() {
            return this.f9497g;
        }

        @Nullable
        public final Drawable getMCloseAction() {
            return this.f9496f;
        }

        @NotNull
        public final WeakReference<Context> getMContext() {
            WeakReference<Context> weakReference = this.mContext;
            if (weakReference != null) {
                return weakReference;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            return null;
        }

        @Nullable
        public final Boolean getMDisableCloseAction() {
            return this.f9493c;
        }

        @Nullable
        public final Drawable getMImage() {
            return this.f9492b;
        }

        @Nullable
        public final OnBubbleMessageViewListener getMListener() {
            return this.f9502l;
        }

        @Nullable
        public final String getMSubtitle() {
            return this.f9495e;
        }

        @Nullable
        public final Integer getMSubtitleTextSize() {
            return this.f9500j;
        }

        @Nullable
        public final RectF getMTargetViewScreenLocation() {
            return this.f9491a;
        }

        @Nullable
        public final Integer getMTextColor() {
            return this.f9498h;
        }

        @Nullable
        public final String getMTitle() {
            return this.f9494d;
        }

        @Nullable
        public final Integer getMTitleTextSize() {
            return this.f9499i;
        }

        @NotNull
        public final Builder image(@Nullable Drawable drawable) {
            this.f9492b = drawable;
            return this;
        }

        @NotNull
        public final Builder listener(@Nullable OnBubbleMessageViewListener onBubbleMessageViewListener) {
            this.f9502l = onBubbleMessageViewListener;
            return this;
        }

        public final void setMArrowPosition(@NotNull ArrayList<BubbleShowCase.ArrowPosition> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.f9501k = arrayList;
        }

        public final void setMBackgroundColor(@Nullable Integer num) {
            this.f9497g = num;
        }

        public final void setMCloseAction(@Nullable Drawable drawable) {
            this.f9496f = drawable;
        }

        public final void setMContext(@NotNull WeakReference<Context> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            this.mContext = weakReference;
        }

        public final void setMDisableCloseAction(@Nullable Boolean bool) {
            this.f9493c = bool;
        }

        public final void setMImage(@Nullable Drawable drawable) {
            this.f9492b = drawable;
        }

        public final void setMListener(@Nullable OnBubbleMessageViewListener onBubbleMessageViewListener) {
            this.f9502l = onBubbleMessageViewListener;
        }

        public final void setMSubtitle(@Nullable String str) {
            this.f9495e = str;
        }

        public final void setMSubtitleTextSize(@Nullable Integer num) {
            this.f9500j = num;
        }

        public final void setMTargetViewScreenLocation(@Nullable RectF rectF) {
            this.f9491a = rectF;
        }

        public final void setMTextColor(@Nullable Integer num) {
            this.f9498h = num;
        }

        public final void setMTitle(@Nullable String str) {
            this.f9494d = str;
        }

        public final void setMTitleTextSize(@Nullable Integer num) {
            this.f9499i = num;
        }

        @NotNull
        public final Builder subtitle(@Nullable String str) {
            this.f9495e = str;
            return this;
        }

        @NotNull
        public final Builder subtitleTextSize(@Nullable Integer num) {
            this.f9500j = num;
            return this;
        }

        @NotNull
        public final Builder targetViewScreenLocation(@NotNull RectF targetViewLocationOnScreen) {
            Intrinsics.checkNotNullParameter(targetViewLocationOnScreen, "targetViewLocationOnScreen");
            this.f9491a = targetViewLocationOnScreen;
            return this;
        }

        @NotNull
        public final Builder textColor(@Nullable Integer num) {
            this.f9498h = num;
            return this;
        }

        @NotNull
        public final Builder title(@Nullable String str) {
            this.f9494d = str;
            return this;
        }

        @NotNull
        public final Builder titleTextSize(@Nullable Integer num) {
            this.f9499i = num;
            return this;
        }
    }

    /* compiled from: BubbleMessageView.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BubbleShowCase.ArrowPosition.values().length];
            try {
                iArr[BubbleShowCase.ArrowPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BubbleShowCase.ArrowPosition.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BubbleShowCase.ArrowPosition.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BubbleShowCase.ArrowPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleMessageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9480a = 20;
        this.f9488i = ContextCompat.getColor(getContext(), R.color.primary);
        this.f9489j = new ArrayList<>();
        j();
    }

    private final void c() {
        this.f9482c = (ImageView) findViewById(R.id.imageViewShowCase);
        this.f9485f = (ImageView) findViewById(R.id.imageViewShowCaseClose);
        this.f9483d = (TextView) findViewById(R.id.textViewShowCaseTitle);
        this.f9484e = (TextView) findViewById(R.id.textViewShowCaseText);
        this.f9486g = (ConstraintLayout) findViewById(R.id.showCaseMessageViewLayout);
    }

    private final void d(Canvas canvas, BubbleShowCase.ArrowPosition arrowPosition, RectF rectF) {
        int margin;
        int height;
        int i4 = WhenMappings.$EnumSwitchMapping$0[arrowPosition.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        if (rectF != null) {
                            margin = g(rectF);
                        } else {
                            margin = getWidth() / 2;
                        }
                        height = getHeight() - getMargin();
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    if (rectF != null) {
                        margin = g(rectF);
                    } else {
                        margin = getWidth() / 2;
                    }
                    height = getMargin();
                }
            } else {
                margin = getViewWidth() - getMargin();
                if (rectF != null) {
                    height = h(rectF);
                } else {
                    height = getHeight() / 2;
                }
            }
        } else {
            margin = getMargin();
            if (rectF != null) {
                height = h(rectF);
            } else {
                height = getHeight() / 2;
            }
        }
        f(canvas, this.f9490k, margin, height, ScreenUtils.INSTANCE.dpToPx(this.f9480a));
    }

    private final void e(Canvas canvas) {
        RectF rectF = new RectF(getMargin(), getMargin(), getViewWidth() - getMargin(), getHeight() - getMargin());
        Paint paint = this.f9490k;
        Intrinsics.checkNotNull(paint);
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, paint);
    }

    private final void f(Canvas canvas, Paint paint, int i4, int i5, int i6) {
        int i7;
        Path path = new Path();
        float f4 = i4;
        float f5 = i5 + (i6 / 2);
        path.moveTo(f4, f5);
        float f6 = i5;
        path.lineTo(i4 - i7, f6);
        path.lineTo(f4, i5 - i7);
        path.lineTo(i4 + i7, f6);
        path.lineTo(f4, f5);
        path.close();
        Intrinsics.checkNotNull(paint);
        canvas.drawPath(path, paint);
    }

    private final int g(RectF rectF) {
        if (m(rectF)) {
            return getWidth() - getSecurityArrowMargin();
        }
        if (l(rectF)) {
            return getSecurityArrowMargin();
        }
        Intrinsics.checkNotNull(rectF);
        return Math.round(rectF.centerX() - ScreenUtils.INSTANCE.getAxisXpositionOfViewOnScreen(this));
    }

    private final int getMargin() {
        return ScreenUtils.INSTANCE.dpToPx(20);
    }

    private final int getSecurityArrowMargin() {
        return getMargin() + ScreenUtils.INSTANCE.dpToPx((this.f9480a * 2) / 3);
    }

    private final int getViewWidth() {
        return getWidth();
    }

    private final int h(RectF rectF) {
        if (k(rectF)) {
            return getHeight() - getSecurityArrowMargin();
        }
        if (n(rectF)) {
            return getSecurityArrowMargin();
        }
        Intrinsics.checkNotNull(rectF);
        float centerY = rectF.centerY();
        ScreenUtils screenUtils = ScreenUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return Math.round((centerY + screenUtils.getStatusBarHeight(context)) - screenUtils.getAxisYpositionOfViewOnScreen(this));
    }

    private final void i() {
        this.f9481b = View.inflate(getContext(), R.layout.view_bubble_message, this);
    }

    private final void j() {
        setWillNotDraw(false);
        i();
        c();
    }

    private final boolean k(RectF rectF) {
        Intrinsics.checkNotNull(rectF);
        float centerY = rectF.centerY();
        ScreenUtils screenUtils = ScreenUtils.INSTANCE;
        int axisYpositionOfViewOnScreen = (screenUtils.getAxisYpositionOfViewOnScreen(this) + getHeight()) - getSecurityArrowMargin();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (centerY > axisYpositionOfViewOnScreen - screenUtils.getStatusBarHeight(context)) {
            return true;
        }
        return false;
    }

    private final boolean l(RectF rectF) {
        Intrinsics.checkNotNull(rectF);
        if (rectF.centerX() < ScreenUtils.INSTANCE.getAxisXpositionOfViewOnScreen(this) + getSecurityArrowMargin()) {
            return true;
        }
        return false;
    }

    private final boolean m(RectF rectF) {
        Intrinsics.checkNotNull(rectF);
        if (rectF.centerX() > (ScreenUtils.INSTANCE.getAxisXpositionOfViewOnScreen(this) + getWidth()) - getSecurityArrowMargin()) {
            return true;
        }
        return false;
    }

    private final boolean n(RectF rectF) {
        Intrinsics.checkNotNull(rectF);
        float centerY = rectF.centerY();
        ScreenUtils screenUtils = ScreenUtils.INSTANCE;
        int axisYpositionOfViewOnScreen = screenUtils.getAxisYpositionOfViewOnScreen(this) + getSecurityArrowMargin();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (centerY < axisYpositionOfViewOnScreen - screenUtils.getStatusBarHeight(context)) {
            return true;
        }
        return false;
    }

    private final void o() {
        Paint paint = new Paint(1);
        this.f9490k = paint;
        paint.setColor(this.f9488i);
        Paint paint2 = this.f9490k;
        if (paint2 != null) {
            paint2.setStyle(Paint.Style.FILL);
        }
        Paint paint3 = this.f9490k;
        if (paint3 != null) {
            paint3.setStrokeWidth(4.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Builder builder, View view) {
        Intrinsics.checkNotNullParameter(builder, "$builder");
        OnBubbleMessageViewListener mListener = builder.getMListener();
        if (mListener != null) {
            mListener.onCloseActionImageClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Builder builder, View view) {
        Intrinsics.checkNotNullParameter(builder, "$builder");
        OnBubbleMessageViewListener mListener = builder.getMListener();
        if (mListener != null) {
            mListener.onBubbleClick();
        }
    }

    private final void setAttributes(Builder builder) {
        ImageView imageView;
        if (builder.getMImage() != null) {
            ImageView imageView2 = this.f9482c;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.f9482c;
            if (imageView3 != null) {
                Drawable mImage = builder.getMImage();
                Intrinsics.checkNotNull(mImage);
                imageView3.setImageDrawable(mImage);
            }
        }
        if (builder.getMCloseAction() != null) {
            ImageView imageView4 = this.f9485f;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            ImageView imageView5 = this.f9485f;
            if (imageView5 != null) {
                Drawable mCloseAction = builder.getMCloseAction();
                Intrinsics.checkNotNull(mCloseAction);
                imageView5.setImageDrawable(mCloseAction);
            }
        }
        if (builder.getMDisableCloseAction() != null) {
            Boolean mDisableCloseAction = builder.getMDisableCloseAction();
            Intrinsics.checkNotNull(mDisableCloseAction);
            if (mDisableCloseAction.booleanValue() && (imageView = this.f9485f) != null) {
                imageView.setVisibility(4);
            }
        }
        if (builder.getMTitle() != null) {
            TextView textView = this.f9483d;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.f9483d;
            if (textView2 != null) {
                textView2.setText(builder.getMTitle());
            }
        }
        if (builder.getMSubtitle() != null) {
            TextView textView3 = this.f9484e;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.f9484e;
            if (textView4 != null) {
                textView4.setText(builder.getMSubtitle());
            }
        }
        Integer mTextColor = builder.getMTextColor();
        if (mTextColor != null) {
            mTextColor.intValue();
            TextView textView5 = this.f9483d;
            if (textView5 != null) {
                Integer mTextColor2 = builder.getMTextColor();
                Intrinsics.checkNotNull(mTextColor2);
                textView5.setTextColor(mTextColor2.intValue());
            }
            TextView textView6 = this.f9484e;
            if (textView6 != null) {
                Integer mTextColor3 = builder.getMTextColor();
                Intrinsics.checkNotNull(mTextColor3);
                textView6.setTextColor(mTextColor3.intValue());
            }
        }
        Integer mTitleTextSize = builder.getMTitleTextSize();
        if (mTitleTextSize != null) {
            mTitleTextSize.intValue();
            TextView textView7 = this.f9483d;
            if (textView7 != null) {
                Integer mTitleTextSize2 = builder.getMTitleTextSize();
                Intrinsics.checkNotNull(mTitleTextSize2);
                textView7.setTextSize(2, mTitleTextSize2.intValue());
            }
        }
        Integer mSubtitleTextSize = builder.getMSubtitleTextSize();
        if (mSubtitleTextSize != null) {
            mSubtitleTextSize.intValue();
            TextView textView8 = this.f9484e;
            if (textView8 != null) {
                Integer mSubtitleTextSize2 = builder.getMSubtitleTextSize();
                Intrinsics.checkNotNull(mSubtitleTextSize2);
                textView8.setTextSize(2, mSubtitleTextSize2.intValue());
            }
        }
        Integer mBackgroundColor = builder.getMBackgroundColor();
        if (mBackgroundColor != null) {
            mBackgroundColor.intValue();
            Integer mBackgroundColor2 = builder.getMBackgroundColor();
            Intrinsics.checkNotNull(mBackgroundColor2);
            this.f9488i = mBackgroundColor2.intValue();
        }
        this.f9489j = builder.getMArrowPosition();
        this.f9487h = builder.getMTargetViewScreenLocation();
    }

    private final void setBubbleListener(final Builder builder) {
        ImageView imageView = this.f9485f;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: w.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BubbleMessageView.p(BubbleMessageView.Builder.this, view);
                }
            });
        }
        View view = this.f9481b;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: w.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BubbleMessageView.q(BubbleMessageView.Builder.this, view2);
                }
            });
        }
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        o();
        e(canvas);
        Iterator<BubbleShowCase.ArrowPosition> it = this.f9489j.iterator();
        while (it.hasNext()) {
            BubbleShowCase.ArrowPosition arrowPosition = it.next();
            Intrinsics.checkNotNullExpressionValue(arrowPosition, "arrowPosition");
            d(canvas, arrowPosition, this.f9487h);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleMessageView(@NotNull Context context, @NotNull Builder builder) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f9480a = 20;
        this.f9488i = ContextCompat.getColor(getContext(), R.color.primary);
        this.f9489j = new ArrayList<>();
        j();
        setAttributes(builder);
        setBubbleListener(builder);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9480a = 20;
        this.f9488i = ContextCompat.getColor(getContext(), R.color.primary);
        this.f9489j = new ArrayList<>();
        j();
    }
}
