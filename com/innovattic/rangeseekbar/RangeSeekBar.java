package com.innovattic.rangeseekbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.android.dx.rop.code.RegisterSpec;
import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.mlkit.nl.translate.TranslateLanguage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RangeSeekBar.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u008a\u0001\u008b\u0001B.\b\u0007\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\f\b\u0002\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001\u0012\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J(\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0003J&\u0010\u001f\u001a\u00020\u0005*\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0002J<\u0010'\u001a\u00020\u0005*\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\fH\u0002J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001bH\u0002J\u0018\u0010+\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001bH\u0002J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0018\u0010/\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0018\u00100\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0018\u00101\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0010\u00102\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020(H\u0002J\u0010\u00103\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020(H\u0002J\u0010\u00104\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(H\u0002J\u0010\u00105\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(H\u0002J\u0010\u00106\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(H\u0002J\u0010\u00107\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020(H\u0002J\u0010\u00108\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020(H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020(H\u0002R\u0014\u0010;\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010=R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010?R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010?R\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010?\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010?\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010?\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR\"\u0010N\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010?\u001a\u0004\bL\u0010B\"\u0004\bM\u0010DR\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010?\u001a\u0004\bO\u0010B\"\u0004\bP\u0010DR\"\u0010W\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010Z\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010R\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010?\u001a\u0004\b[\u0010B\"\u0004\b\\\u0010DR\"\u0010c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010^\u001a\u0004\bd\u0010`\"\u0004\be\u0010bR\"\u0010l\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010o\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010g\u001a\u0004\bm\u0010i\"\u0004\bn\u0010kR*\u0010r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010?\u001a\u0004\bp\u0010B\"\u0004\bq\u0010DR*\u0010u\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010?\u001a\u0004\bs\u0010B\"\u0004\bt\u0010DR\u0016\u0010v\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010?R\u0016\u0010w\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010?R\u0016\u0010x\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010?R\u0016\u0010z\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010?R'\u0010\u0082\u0001\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/innovattic/rangeseekbar/RangeSeekBar;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/Canvas;", "canvas", "onDraw", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onTouchEvent", "value", "setMinThumbValue", "getMinThumbValue", "setMaxThumbValue", "getMaxThumbValue", "base", "t", "cx", TranslateLanguage.WELSH, "radius", "s", "measureSpec", "u", "Landroid/graphics/drawable/Drawable;", PopUpActionActivity.EXTRA_POSITION, "Landroid/graphics/Point;", TypedValues.CycleType.S_WAVE_OFFSET, "a", "", "left", "right", "thickness", "Landroid/graphics/Paint;", "paint", "round", "b", "Landroid/content/res/TypedArray;", "defaultValue", "e", "i", "o", "m", "q", "r", "l", "k", "n", "p", "h", "g", "d", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "j", "f", "Landroid/graphics/Paint;", "trackPaint", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "helperRectF", "I", "selectedThumb", "getTrackThickness", "()I", "setTrackThickness", "(I)V", "trackThickness", "getTrackSelectedThickness", "setTrackSelectedThickness", "trackSelectedThickness", "getTrackColor", "setTrackColor", "trackColor", "getTrackSelectedColor", "setTrackSelectedColor", "trackSelectedColor", "getTouchRadius", "setTouchRadius", "touchRadius", "Landroid/graphics/drawable/Drawable;", "getMinThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setMinThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "minThumbDrawable", "getMaxThumbDrawable", "setMaxThumbDrawable", "maxThumbDrawable", "getSidePadding", "setSidePadding", "sidePadding", "Z", "getTrackRoundedCaps", "()Z", "setTrackRoundedCaps", "(Z)V", "trackRoundedCaps", "getTrackSelectedRoundedCaps", "setTrackSelectedRoundedCaps", "trackSelectedRoundedCaps", "Landroid/graphics/Point;", "getMinThumbOffset", "()Landroid/graphics/Point;", "setMinThumbOffset", "(Landroid/graphics/Point;)V", "minThumbOffset", "getMaxThumbOffset", "setMaxThumbOffset", "maxThumbOffset", "getMinRange", "setMinRange", "minRange", "getMax", "setMax", "max", "minThumbValue", "maxThumbValue", "lastMinThumbValue", RegisterSpec.PREFIX, "lastMaxThumbValue", "Lcom/innovattic/rangeseekbar/RangeSeekBar$SeekBarChangeListener;", "w", "Lcom/innovattic/rangeseekbar/RangeSeekBar$SeekBarChangeListener;", "getSeekBarChangeListener", "()Lcom/innovattic/rangeseekbar/RangeSeekBar$SeekBarChangeListener;", "setSeekBarChangeListener", "(Lcom/innovattic/rangeseekbar/RangeSeekBar$SeekBarChangeListener;)V", "seekBarChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "SeekBarChangeListener", "rangeseekbar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public class RangeSeekBar extends View {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Paint f34140a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final RectF f34141b;

    /* renamed from: c  reason: collision with root package name */
    private int f34142c;

    /* renamed from: d  reason: collision with root package name */
    private int f34143d;

    /* renamed from: e  reason: collision with root package name */
    private int f34144e;

    /* renamed from: f  reason: collision with root package name */
    private int f34145f;

    /* renamed from: g  reason: collision with root package name */
    private int f34146g;

    /* renamed from: h  reason: collision with root package name */
    private int f34147h;

    /* renamed from: i  reason: collision with root package name */
    private int f34148i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private Drawable f34149j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private Drawable f34150k;

    /* renamed from: l  reason: collision with root package name */
    private int f34151l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f34152m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f34153n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private Point f34154o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private Point f34155p;

    /* renamed from: q  reason: collision with root package name */
    private int f34156q;

    /* renamed from: r  reason: collision with root package name */
    private int f34157r;

    /* renamed from: s  reason: collision with root package name */
    private int f34158s;

    /* renamed from: t  reason: collision with root package name */
    private int f34159t;

    /* renamed from: u  reason: collision with root package name */
    private int f34160u;

    /* renamed from: v  reason: collision with root package name */
    private int f34161v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    private SeekBarChangeListener f34162w;

    /* compiled from: RangeSeekBar.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/innovattic/rangeseekbar/RangeSeekBar$Companion;", "", "()V", "THUMB_MAX", "", "THUMB_MIN", "THUMB_NONE", "rangeseekbar_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RangeSeekBar.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/innovattic/rangeseekbar/RangeSeekBar$SeekBarChangeListener;", "", "onStartedSeeking", "", "onStoppedSeeking", "onValueChanged", "minThumbValue", "", "maxThumbValue", "rangeseekbar_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public interface SeekBarChangeListener {
        void onStartedSeeking();

        void onStoppedSeeking();

        void onValueChanged(int i4, int i5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RangeSeekBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Drawable drawable, Canvas canvas, int i4, Point point) {
        int i5 = i4 + point.x;
        int height = ((getHeight() - drawable.getIntrinsicHeight()) / 2) + point.y;
        drawable.setBounds(i5, height, drawable.getIntrinsicWidth() + i5, drawable.getIntrinsicHeight() + height);
        drawable.draw(canvas);
    }

    private final void b(Canvas canvas, float f4, float f5, float f6, float f7, Paint paint, boolean z3) {
        float f8 = f7 / 2;
        float f9 = f6 - f8;
        float f10 = f6 + f8;
        if (z3) {
            canvas.drawRoundRect(f4 - f8, f9, f5 + f8, f10, f7, f7, paint);
        } else {
            canvas.drawRect(f4, f9, f5, f10, paint);
        }
    }

    private final int c(TypedArray typedArray) {
        return typedArray.getInteger(R.styleable.RangeSeekBar_rsb_initialMaxThumbValue, -1);
    }

    private final int d(TypedArray typedArray) {
        return typedArray.getInteger(R.styleable.RangeSeekBar_rsb_initialMinThumbValue, -1);
    }

    private final Drawable e(TypedArray typedArray, Drawable drawable) {
        Drawable drawable2 = typedArray.getDrawable(R.styleable.RangeSeekBar_rsb_maxThumbDrawable);
        if (drawable2 != null) {
            return drawable2;
        }
        return drawable;
    }

    private final Point f(TypedArray typedArray) {
        return new Point(typedArray.getDimensionPixelSize(R.styleable.RangeSeekBar_rsb_maxThumbOffsetHorizontal, 0), typedArray.getDimensionPixelSize(R.styleable.RangeSeekBar_rsb_maxThumbOffsetVertical, 0));
    }

    private final int g(TypedArray typedArray) {
        return typedArray.getInteger(R.styleable.RangeSeekBar_rsb_max, 100);
    }

    private final int h(TypedArray typedArray) {
        return typedArray.getInteger(R.styleable.RangeSeekBar_rsb_minRange, 1);
    }

    private final Drawable i(TypedArray typedArray, Drawable drawable) {
        Drawable drawable2 = typedArray.getDrawable(R.styleable.RangeSeekBar_rsb_minThumbDrawable);
        if (drawable2 != null) {
            return drawable2;
        }
        return drawable;
    }

    private final Point j(TypedArray typedArray) {
        return new Point(typedArray.getDimensionPixelSize(R.styleable.RangeSeekBar_rsb_minThumbOffsetHorizontal, 0), typedArray.getDimensionPixelSize(R.styleable.RangeSeekBar_rsb_minThumbOffsetVertical, 0));
    }

    private final int k(TypedArray typedArray, int i4) {
        return typedArray.getDimensionPixelSize(R.styleable.RangeSeekBar_rsb_sidePadding, i4);
    }

    private final int l(TypedArray typedArray, int i4) {
        return typedArray.getDimensionPixelSize(R.styleable.RangeSeekBar_rsb_touchRadius, i4);
    }

    private final int m(TypedArray typedArray, int i4) {
        return typedArray.getColor(R.styleable.RangeSeekBar_rsb_trackColor, i4);
    }

    private final boolean n(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.RangeSeekBar_rsb_trackRoundedCaps, false);
    }

    private final int o(TypedArray typedArray, int i4) {
        return typedArray.getColor(R.styleable.RangeSeekBar_rsb_trackSelectedColor, i4);
    }

    private final boolean p(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.RangeSeekBar_rsb_trackSelectedRoundedCaps, false);
    }

    private final int q(TypedArray typedArray, int i4) {
        return typedArray.getDimensionPixelSize(R.styleable.RangeSeekBar_rsb_trackSelectedThickness, i4);
    }

    private final int r(TypedArray typedArray, int i4) {
        return typedArray.getDimensionPixelSize(R.styleable.RangeSeekBar_rsb_trackThickness, i4);
    }

    private final boolean s(MotionEvent motionEvent, int i4, int i5, int i6) {
        float x3 = motionEvent.getX() - i4;
        float y3 = motionEvent.getY() - i5;
        if ((x3 * x3) + (y3 * y3) < i6 * i6) {
            return true;
        }
        return false;
    }

    private final void t(int i4) {
        if (i4 != 1) {
            if (i4 == 2) {
                int i5 = this.f34159t;
                int i6 = this.f34158s;
                int i7 = this.f34156q;
                if (i5 <= i6 + i7) {
                    this.f34158s = i5 - i7;
                    return;
                }
                return;
            }
            return;
        }
        int i8 = this.f34158s;
        int i9 = this.f34159t;
        int i10 = this.f34156q;
        if (i8 > i9 - i10) {
            this.f34159t = i8 + i10;
        }
    }

    @SuppressLint({"SwitchIntDef"})
    private final int u(int i4) {
        int max = Math.max(this.f34149j.getIntrinsicHeight(), this.f34150k.getIntrinsicHeight());
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode != 1073741824) {
            return this.f34151l + max;
        }
        return size;
    }

    public final int getMax() {
        return this.f34157r;
    }

    @NotNull
    public final Drawable getMaxThumbDrawable() {
        return this.f34150k;
    }

    @NotNull
    public final Point getMaxThumbOffset() {
        return this.f34155p;
    }

    public final int getMaxThumbValue() {
        return this.f34159t;
    }

    public final int getMinRange() {
        return this.f34156q;
    }

    @NotNull
    public final Drawable getMinThumbDrawable() {
        return this.f34149j;
    }

    @NotNull
    public final Point getMinThumbOffset() {
        return this.f34154o;
    }

    public final int getMinThumbValue() {
        return this.f34158s;
    }

    @Nullable
    public final SeekBarChangeListener getSeekBarChangeListener() {
        return this.f34162w;
    }

    public final int getSidePadding() {
        return this.f34151l;
    }

    public final int getTouchRadius() {
        return this.f34148i;
    }

    public final int getTrackColor() {
        return this.f34146g;
    }

    public final boolean getTrackRoundedCaps() {
        return this.f34152m;
    }

    public final int getTrackSelectedColor() {
        return this.f34147h;
    }

    public final boolean getTrackSelectedRoundedCaps() {
        return this.f34153n;
    }

    public final int getTrackSelectedThickness() {
        return this.f34145f;
    }

    public final int getTrackThickness() {
        return this.f34144e;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft() + this.f34151l;
        int width = (getWidth() - paddingLeft) - (getPaddingRight() + this.f34151l);
        float height = getHeight() / 2.0f;
        float f4 = paddingLeft;
        int i4 = this.f34157r;
        float f5 = width;
        float f6 = ((this.f34158s / i4) * f5) + f4;
        float f7 = f4 + ((this.f34159t / i4) * f5);
        this.f34140a.setColor(this.f34146g);
        b(canvas, f4 + 0.0f, f4 + f5, height, this.f34144e, this.f34140a, this.f34152m);
        this.f34140a.setColor(this.f34147h);
        b(canvas, f6, f7, height, this.f34145f, this.f34140a, this.f34153n);
        a(this.f34149j, canvas, (int) f6, this.f34154o);
        Drawable drawable = this.f34150k;
        a(drawable, canvas, ((int) f7) - drawable.getIntrinsicWidth(), this.f34155p);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i4), u(i5));
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        int paddingRight;
        int i4;
        boolean z3;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isEnabled()) {
            return false;
        }
        int paddingLeft = getPaddingLeft() + this.f34151l;
        int width = (getWidth() - paddingLeft) - (getPaddingRight() + this.f34151l);
        float f4 = paddingLeft;
        if (event.getX() < f4) {
            i4 = 0;
        } else if (f4 <= event.getX() && event.getX() <= getWidth() - paddingRight) {
            i4 = (int) (((event.getX() - f4) / width) * this.f34157r);
        } else {
            i4 = this.f34157r;
        }
        int i5 = this.f34157r;
        float f5 = width;
        int i6 = (int) (((this.f34158s / i5) * f5) + f4);
        int i7 = (int) (f4 + ((this.f34159t / i5) * f5));
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i8 = this.f34142c;
                    if (i8 == 1) {
                        this.f34158s = Math.max(Math.min(i4 - this.f34143d, this.f34157r - this.f34156q), 0);
                    } else if (i8 == 2) {
                        this.f34159t = Math.min(Math.max(i4 + this.f34143d, this.f34156q), this.f34157r);
                    }
                    z3 = true;
                }
            } else {
                this.f34142c = 0;
                SeekBarChangeListener seekBarChangeListener = this.f34162w;
                if (seekBarChangeListener != null) {
                    seekBarChangeListener.onStoppedSeeking();
                }
                setPressed(false);
            }
            z3 = false;
        } else {
            if (s(event, i6, getHeight() / 2, this.f34148i)) {
                this.f34142c = 1;
                this.f34143d = i4 - this.f34158s;
                getParent().requestDisallowInterceptTouchEvent(true);
                SeekBarChangeListener seekBarChangeListener2 = this.f34162w;
                if (seekBarChangeListener2 != null) {
                    seekBarChangeListener2.onStartedSeeking();
                }
                setPressed(true);
            } else {
                if (s(event, i7, getHeight() / 2, this.f34148i)) {
                    this.f34142c = 2;
                    this.f34143d = this.f34159t - i4;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    SeekBarChangeListener seekBarChangeListener3 = this.f34162w;
                    if (seekBarChangeListener3 != null) {
                        seekBarChangeListener3.onStartedSeeking();
                    }
                    setPressed(true);
                }
                z3 = false;
            }
            z3 = true;
        }
        t(this.f34142c);
        if (!z3) {
            return false;
        }
        invalidate();
        int i9 = this.f34160u;
        int i10 = this.f34158s;
        if (i9 != i10 || this.f34161v != this.f34159t) {
            this.f34160u = i10;
            int i11 = this.f34159t;
            this.f34161v = i11;
            SeekBarChangeListener seekBarChangeListener4 = this.f34162w;
            if (seekBarChangeListener4 != null) {
                seekBarChangeListener4.onValueChanged(i10, i11);
            }
        }
        return true;
    }

    public final void setMax(int i4) {
        this.f34157r = i4;
        this.f34158s = 0;
        this.f34159t = i4;
    }

    public final void setMaxThumbDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.f34150k = drawable;
    }

    public final void setMaxThumbOffset(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.f34155p = point;
    }

    public final void setMaxThumbValue(int i4) {
        this.f34159t = Math.min(i4, this.f34157r);
        t(2);
        invalidate();
    }

    public final void setMinRange(int i4) {
        this.f34156q = Math.max(i4, 1);
    }

    public final void setMinThumbDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.f34149j = drawable;
    }

    public final void setMinThumbOffset(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.f34154o = point;
    }

    public final void setMinThumbValue(int i4) {
        this.f34158s = Math.max(i4, 0);
        t(1);
        invalidate();
    }

    public final void setSeekBarChangeListener(@Nullable SeekBarChangeListener seekBarChangeListener) {
        this.f34162w = seekBarChangeListener;
    }

    public final void setSidePadding(int i4) {
        this.f34151l = i4;
    }

    public final void setTouchRadius(int i4) {
        this.f34148i = i4;
    }

    public final void setTrackColor(int i4) {
        this.f34146g = i4;
    }

    public final void setTrackRoundedCaps(boolean z3) {
        this.f34152m = z3;
    }

    public final void setTrackSelectedColor(int i4) {
        this.f34147h = i4;
    }

    public final void setTrackSelectedRoundedCaps(boolean z3) {
        this.f34153n = z3;
    }

    public final void setTrackSelectedThickness(int i4) {
        this.f34145f = i4;
    }

    public final void setTrackThickness(int i4) {
        this.f34144e = i4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RangeSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RangeSeekBar(Context context, AttributeSet attributeSet, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i5 & 2) != 0 ? null : attributeSet, (i5 & 4) != 0 ? 0 : i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RangeSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        Unit unit = Unit.INSTANCE;
        this.f34140a = paint;
        this.f34141b = new RectF();
        this.f34156q = 1;
        this.f34157r = 100;
        this.f34160u = this.f34158s;
        this.f34161v = this.f34159t;
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.rsb_trackDefaultThickness);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.rsb_defaultSidePadding);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.rsb_touchRadius);
        int color = ContextCompat.getColor(context, R.color.rsb_trackDefaultColor);
        int color2 = ContextCompat.getColor(context, R.color.rsb_trackSelectedDefaultColor);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.rsb_bracket_min);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(context, R.drawable.rsb_bracket_min)!!");
        Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.rsb_bracket_max);
        Intrinsics.checkNotNull(drawable2);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(context, R.drawable.rsb_bracket_max)!!");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.RangeSeekBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, R.styleable.RangeSeekBar, 0, 0)");
        try {
            setMax(g(obtainStyledAttributes));
            setMinRange(h(obtainStyledAttributes));
            this.f34151l = k(obtainStyledAttributes, dimensionPixelSize2);
            this.f34148i = l(obtainStyledAttributes, dimensionPixelSize3);
            this.f34144e = r(obtainStyledAttributes, dimensionPixelSize);
            this.f34145f = q(obtainStyledAttributes, dimensionPixelSize);
            this.f34146g = m(obtainStyledAttributes, color);
            this.f34147h = o(obtainStyledAttributes, color2);
            this.f34149j = i(obtainStyledAttributes, drawable);
            this.f34150k = e(obtainStyledAttributes, drawable2);
            this.f34154o = j(obtainStyledAttributes);
            this.f34155p = f(obtainStyledAttributes);
            this.f34152m = n(obtainStyledAttributes);
            this.f34153n = p(obtainStyledAttributes);
            int d4 = d(obtainStyledAttributes);
            int c4 = c(obtainStyledAttributes);
            if (d4 != -1) {
                this.f34158s = Math.max(0, d4);
                t(1);
            }
            if (c4 != -1) {
                this.f34159t = Math.min(this.f34157r, c4);
                t(2);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
