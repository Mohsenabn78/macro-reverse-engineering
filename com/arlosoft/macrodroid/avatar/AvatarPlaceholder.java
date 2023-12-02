package com.arlosoft.macrodroid.avatar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.avatar.utils.StringUtils;

/* loaded from: classes3.dex */
public class AvatarPlaceholder extends Drawable {
    public static final String DEFAULT_PLACEHOLDER_STRING = "-";
    public static final int DEFAULT_TEXT_SIZE_PERCENTAGE = 33;

    /* renamed from: a  reason: collision with root package name */
    private Paint f9430a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f9431b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f9432c;

    /* renamed from: d  reason: collision with root package name */
    private String f9433d;

    /* renamed from: e  reason: collision with root package name */
    private int f9434e;

    /* renamed from: f  reason: collision with root package name */
    private String f9435f;

    /* renamed from: g  reason: collision with root package name */
    private float f9436g;

    /* renamed from: h  reason: collision with root package name */
    private float f9437h;

    /* renamed from: i  reason: collision with root package name */
    private Path f9438i;

    public AvatarPlaceholder(String str) {
        this(str, 33, "-");
    }

    private float a() {
        int i4 = this.f9434e;
        if (i4 < 0 || i4 > 100) {
            this.f9434e = 33;
        }
        return (getBounds().height() * this.f9434e) / 100.0f;
    }

    private float b() {
        return (getBounds().width() / 2.0f) - (this.f9430a.measureText(this.f9433d) / 2.0f);
    }

    private float c() {
        return (getBounds().height() / 2.0f) - ((this.f9430a.ascent() + this.f9430a.descent()) / 2.0f);
    }

    private String d(String str) {
        if (StringUtils.isNotNullOrEmpty(str)) {
            return str.substring(0, 1).toUpperCase();
        }
        return this.f9435f;
    }

    private String e(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return "#3F51B5";
        }
        return String.format("#FF%06X", Integer.valueOf(str.hashCode() & 16777215));
    }

    private String f(String str) {
        if (!StringUtils.isNotNullOrEmpty(str)) {
            return "-";
        }
        return str;
    }

    private void g() {
        this.f9430a.setTextSize(a());
        this.f9436g = b();
        this.f9437h = c();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f9432c == null) {
            this.f9432c = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            g();
        }
        canvas.drawRect(this.f9432c, this.f9431b);
        canvas.drawText(this.f9433d, this.f9436g, this.f9437h, this.f9430a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        RectF rectF = this.f9432c;
        if (rectF == null) {
            this.f9432c = new RectF(rect.left, rect.top, rect.right, rect.bottom);
        } else {
            rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        }
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f9430a.setAlpha(i4);
        this.f9431b.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9430a.setColorFilter(colorFilter);
        this.f9431b.setColorFilter(colorFilter);
    }

    public AvatarPlaceholder(String str, @IntRange int i4) {
        this(str, i4, "-");
    }

    public AvatarPlaceholder(String str, @NonNull String str2) {
        this(str, 33, str2);
    }

    public AvatarPlaceholder(String str, @IntRange int i4, @NonNull String str2) {
        this.f9438i = new Path();
        this.f9435f = f(str2);
        this.f9433d = d(str);
        this.f9434e = i4;
        Paint paint = new Paint();
        this.f9430a = paint;
        paint.setAntiAlias(true);
        this.f9430a.setColor(Color.parseColor("white"));
        this.f9430a.setTypeface(Typeface.create("sans-serif-light", 1));
        Paint paint2 = new Paint();
        this.f9431b = paint2;
        paint2.setAntiAlias(true);
        this.f9431b.setStyle(Paint.Style.FILL);
        this.f9431b.setColor(Color.parseColor(e(str)));
    }
}
