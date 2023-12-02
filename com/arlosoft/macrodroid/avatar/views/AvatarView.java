package com.arlosoft.macrodroid.avatar.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.arlosoft.macrodroid.R;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class AvatarView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f9440a;

    /* renamed from: b  reason: collision with root package name */
    private int f9441b;

    /* renamed from: c  reason: collision with root package name */
    private int f9442c;

    /* renamed from: d  reason: collision with root package name */
    private int f9443d;

    /* renamed from: e  reason: collision with root package name */
    private int f9444e;

    /* renamed from: f  reason: collision with root package name */
    private int f9445f;

    /* renamed from: g  reason: collision with root package name */
    private int f9446g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f9447h;

    /* renamed from: i  reason: collision with root package name */
    int f9448i;

    /* renamed from: j  reason: collision with root package name */
    int f9449j;

    /* renamed from: k  reason: collision with root package name */
    int f9450k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f9451l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f9452m;

    /* renamed from: n  reason: collision with root package name */
    private Rect f9453n;

    public AvatarView(Context context) {
        super(context);
        this.f9451l = new Paint();
        this.f9452m = new Paint();
        init(context, null);
    }

    private void a(TypedArray typedArray) {
        this.f9443d = typedArray.getColor(0, this.f9440a);
        this.f9444e = typedArray.getDimensionPixelSize(1, this.f9441b);
        this.f9445f = typedArray.getInt(2, this.f9442c);
    }

    private Bitmap b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int i4 = this.f9446g;
            Bitmap createBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            int i5 = this.f9448i;
            int i6 = this.f9444e;
            canvas.drawCircle(i5 + i6, i6 + i5, i5, this.f9451l);
            Rect rect = this.f9453n;
            canvas.drawBitmap(bitmap, rect, rect, this.f9452m);
            return createBitmap;
        } catch (OutOfMemoryError e4) {
            Timber.d(e4, "OutOfMemoryError occurred while generating bitmap", new Object[0]);
            return null;
        }
    }

    private Bitmap c(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        try {
            int i4 = this.f9446g;
            Bitmap createBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int i5 = this.f9446g;
            drawable.setBounds(0, 0, i5, i5);
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e4) {
            Timber.d(e4, "OutOfMemoryError occurred while generating bitmap", new Object[0]);
            return null;
        }
    }

    private void e(Canvas canvas) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        int min = Math.min(width, height);
        this.f9446g = min;
        this.f9449j = (width - min) / 2;
        this.f9450k = (height - min) / 2;
        this.f9448i = (min - (this.f9444e * 2)) / 2;
        int i4 = this.f9446g;
        this.f9453n = new Rect(0, 0, i4, i4);
        d();
        if (this.f9446g != 0) {
            this.f9447h = getDrawable();
        }
    }

    private void f() {
        this.f9440a = getResources().getColor(R.color.white);
        this.f9441b = getResources().getDimensionPixelSize(R.dimen.av_default_border_width);
        this.f9442c = 33;
    }

    private void init(Context context, AttributeSet attributeSet) {
        f();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AvatarView, 0, 0);
            try {
                a(obtainStyledAttributes);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f9451l.setAntiAlias(true);
        this.f9451l.setStyle(Paint.Style.FILL);
        this.f9451l.setColor(this.f9443d);
        this.f9452m.setAntiAlias(true);
        this.f9452m.setColor(getResources().getColor(R.color.av_bitmap_background_color));
        this.f9452m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    void d() {
        int i4 = this.f9446g;
        if (i4 / 3 < this.f9444e) {
            this.f9444e = i4 / 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap b4;
        e(canvas);
        if (this.f9446g == 0 || (b4 = b(c(this.f9447h))) == null) {
            return;
        }
        canvas.translate(this.f9449j, this.f9450k);
        int i4 = this.f9448i;
        int i5 = this.f9444e;
        canvas.drawCircle(i4 + i5, i4 + i5, i4 + i5, this.f9451l);
        canvas.drawBitmap(b4, 0.0f, 0.0f, (Paint) null);
    }

    public int textSizePercentage() {
        return this.f9445f;
    }

    public AvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9451l = new Paint();
        this.f9452m = new Paint();
        init(context, attributeSet);
    }

    public AvatarView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f9451l = new Paint();
        this.f9452m = new Paint();
        init(context, attributeSet);
    }
}
