package com.thebluealliance.spectrum;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import com.thebluealliance.spectrum.internal.ColorItem;
import com.thebluealliance.spectrum.internal.ColorUtil;
import com.thebluealliance.spectrum.internal.SelectedColorChangedEvent;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* loaded from: classes6.dex */
public class SpectrumPalette extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f38025a;

    /* renamed from: b  reason: collision with root package name */
    private int f38026b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private int[] f38027c;
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    private int f38028d;

    /* renamed from: e  reason: collision with root package name */
    private OnColorSelectedListener f38029e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38030f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f38031g;

    /* renamed from: h  reason: collision with root package name */
    private int f38032h;

    /* renamed from: i  reason: collision with root package name */
    private int f38033i;

    /* renamed from: j  reason: collision with root package name */
    private int f38034j;

    /* renamed from: k  reason: collision with root package name */
    private int f38035k;

    /* renamed from: l  reason: collision with root package name */
    private int f38036l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f38037m;

    /* renamed from: n  reason: collision with root package name */
    private int f38038n;

    /* renamed from: o  reason: collision with root package name */
    private int f38039o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f38040p;

    /* renamed from: q  reason: collision with root package name */
    private EventBus f38041q;

    /* renamed from: r  reason: collision with root package name */
    private List<ColorItem> f38042r;

    /* loaded from: classes6.dex */
    public interface OnColorSelectedListener {
        void onColorSelected(@ColorInt int i4);
    }

    public SpectrumPalette(Context context) {
        super(context);
        this.f38030f = false;
        this.f38031g = false;
        this.f38032h = -1;
        this.f38033i = 0;
        this.f38034j = 0;
        this.f38035k = 0;
        this.f38036l = 0;
        this.f38037m = false;
        this.f38038n = 2;
        this.f38039o = -1;
        this.f38040p = false;
        this.f38042r = new ArrayList();
        h();
    }

    private int a(int i4) {
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if ((this.f38025a * i6) + (i6 * 2 * this.f38026b) <= i4) {
                i5 = i6;
            } else {
                return i5;
            }
        }
    }

    private int b(int i4) {
        int[] iArr = this.f38027c;
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length / i4;
        if (iArr.length % i4 != 0) {
            length++;
        }
        return length * (this.f38025a + (this.f38026b * 2));
    }

    private int c(int i4) {
        return i4 * (this.f38025a + (this.f38026b * 2));
    }

    private ColorItem d(int i4, int i5) {
        boolean z3;
        Context context = getContext();
        if (i4 == i5) {
            z3 = true;
        } else {
            z3 = false;
        }
        ColorItem colorItem = new ColorItem(context, i4, z3, this.f38041q);
        int i6 = this.f38025a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i6);
        int i7 = this.f38026b;
        layoutParams.setMargins(i7, i7, i7, i7);
        colorItem.setLayoutParams(layoutParams);
        int i8 = this.f38033i;
        if (i8 != 0) {
            colorItem.setOutlineWidth(i8);
        }
        this.f38042r.add(colorItem);
        return colorItem;
    }

    private LinearLayout f() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setGravity(1);
        return linearLayout;
    }

    private ImageView g() {
        ImageView imageView = new ImageView(getContext());
        int i4 = this.f38025a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        int i5 = this.f38026b;
        layoutParams.setMargins(i5, i5, i5, i5);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private int getOriginalPaddingBottom() {
        return this.f38036l;
    }

    private int getOriginalPaddingTop() {
        return this.f38035k;
    }

    private void h() {
        EventBus eventBus = new EventBus();
        this.f38041q = eventBus;
        eventBus.register(this);
        this.f38025a = getResources().getDimensionPixelSize(R.dimen.color_item_small);
        this.f38026b = getResources().getDimensionPixelSize(R.dimen.color_item_margins_small);
        setOrientation(1);
    }

    private void i(int i4, int i5, int i6, int i7) {
        this.f38037m = true;
        setPadding(i4, i5, i6, i7);
    }

    protected void e() {
        if (this.f38040p && this.f38038n == this.f38039o) {
            return;
        }
        this.f38040p = true;
        this.f38039o = this.f38038n;
        removeAllViews();
        if (this.f38027c == null) {
            return;
        }
        LinearLayout f4 = f();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f38027c;
            if (i4 >= iArr.length) {
                break;
            }
            f4.addView(d(iArr[i4], this.f38028d));
            i5++;
            if (i5 == this.f38038n) {
                addView(f4);
                f4 = f();
                i5 = 0;
            }
            i4++;
        }
        if (i5 > 0) {
            while (i5 < this.f38038n) {
                f4.addView(g());
                i5++;
            }
            addView(f4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        if (!this.f38031g) {
            if (mode == 1073741824) {
                this.f38038n = a(size - (getPaddingLeft() + getPaddingRight()));
            } else if (mode == Integer.MIN_VALUE) {
                this.f38038n = a(size - (getPaddingLeft() + getPaddingRight()));
            } else {
                this.f38038n = 4;
                size = c(4) + getPaddingLeft() + getPaddingRight();
            }
        } else {
            size = c(this.f38032h) + getPaddingLeft() + getPaddingRight();
            this.f38038n = this.f38032h;
        }
        this.f38034j = (size - ((c(this.f38038n) + getPaddingLeft()) + getPaddingRight())) / 2;
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                int b4 = b(this.f38038n) + this.f38035k + this.f38036l;
                if (this.f38030f) {
                    b4 += this.f38034j * 2;
                }
                size2 = Math.min(b4, size2);
            } else {
                size2 = b(this.f38038n) + this.f38035k + this.f38036l;
                if (this.f38030f) {
                    size2 += this.f38034j * 2;
                }
            }
        }
        if (this.f38030f) {
            i(getPaddingLeft(), this.f38035k + this.f38034j, getPaddingRight(), this.f38036l + this.f38034j);
        }
        e();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Subscribe
    public void onSelectedColorChanged(SelectedColorChangedEvent selectedColorChangedEvent) {
        int selectedColor = selectedColorChangedEvent.getSelectedColor();
        this.f38028d = selectedColor;
        OnColorSelectedListener onColorSelectedListener = this.f38029e;
        if (onColorSelectedListener != null) {
            onColorSelectedListener.onColorSelected(selectedColor);
        }
    }

    public void setColors(@ColorInt int[] iArr) {
        this.f38027c = iArr;
        this.f38040p = false;
        e();
    }

    public void setFixedColumnCount(int i4) {
        if (i4 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("set column count to ");
            sb.append(i4);
            this.f38031g = true;
            this.f38032h = i4;
            requestLayout();
            invalidate();
            return;
        }
        this.f38031g = false;
        this.f38032h = -1;
        requestLayout();
        invalidate();
    }

    public void setOnColorSelectedListener(OnColorSelectedListener onColorSelectedListener) {
        this.f38029e = onColorSelectedListener;
    }

    public void setOutlineWidth(int i4) {
        this.f38033i = i4;
        for (ColorItem colorItem : this.f38042r) {
            colorItem.setOutlineWidth(i4);
        }
    }

    @Override // android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        super.setPadding(i4, i5, i6, i7);
        if (!this.f38037m) {
            this.f38035k = i5;
            this.f38036l = i7;
        }
    }

    public void setSelectedColor(@ColorInt int i4) {
        this.f38028d = i4;
        this.f38041q.post(new SelectedColorChangedEvent(i4));
    }

    public boolean usesDarkCheckmark(@ColorInt int i4) {
        return ColorUtil.isColorDark(i4);
    }

    public SpectrumPalette(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38030f = false;
        this.f38031g = false;
        this.f38032h = -1;
        this.f38033i = 0;
        this.f38034j = 0;
        this.f38035k = 0;
        this.f38036l = 0;
        this.f38037m = false;
        this.f38038n = 2;
        this.f38039o = -1;
        this.f38040p = false;
        this.f38042r = new ArrayList();
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SpectrumPalette, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SpectrumPalette_spectrum_colors, 0);
        if (resourceId != 0) {
            this.f38027c = getContext().getResources().getIntArray(resourceId);
        }
        this.f38030f = obtainStyledAttributes.getBoolean(R.styleable.SpectrumPalette_spectrum_autoPadding, false);
        this.f38033i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SpectrumPalette_spectrum_outlineWidth, 0);
        int i4 = obtainStyledAttributes.getInt(R.styleable.SpectrumPalette_spectrum_columnCount, -1);
        this.f38032h = i4;
        if (i4 != -1) {
            this.f38031g = true;
        }
        obtainStyledAttributes.recycle();
        this.f38035k = getPaddingTop();
        this.f38036l = getPaddingBottom();
        h();
    }
}
