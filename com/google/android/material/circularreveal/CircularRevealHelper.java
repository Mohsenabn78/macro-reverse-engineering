package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Delegate f23355a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final View f23356b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Path f23357c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Paint f23358d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Paint f23359e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private CircularRevealWidget.RevealInfo f23360f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Drawable f23361g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23362h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23363i;

    /* loaded from: classes5.dex */
    public interface Delegate {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface Strategy {
    }

    public CircularRevealHelper(Delegate delegate) {
        this.f23355a = delegate;
        View view = (View) delegate;
        this.f23356b = view;
        view.setWillNotDraw(false);
        this.f23357c = new Path();
        this.f23358d = new Paint(7);
        Paint paint = new Paint(1);
        this.f23359e = paint;
        paint.setColor(0);
    }

    private void a(@NonNull Canvas canvas) {
        if (e()) {
            Rect bounds = this.f23361g.getBounds();
            float width = this.f23360f.centerX - (bounds.width() / 2.0f);
            float height = this.f23360f.centerY - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f23361g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float b(@NonNull CircularRevealWidget.RevealInfo revealInfo) {
        return MathUtils.distanceToFurthestCorner(revealInfo.centerX, revealInfo.centerY, 0.0f, 0.0f, this.f23356b.getWidth(), this.f23356b.getHeight());
    }

    private void c() {
        if (STRATEGY == 1) {
            this.f23357c.rewind();
            CircularRevealWidget.RevealInfo revealInfo = this.f23360f;
            if (revealInfo != null) {
                this.f23357c.addCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, Path.Direction.CW);
            }
        }
        this.f23356b.invalidate();
    }

    private boolean d() {
        boolean z3;
        CircularRevealWidget.RevealInfo revealInfo = this.f23360f;
        if (revealInfo != null && !revealInfo.isInvalid()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (STRATEGY == 0) {
            if (z3 || !this.f23363i) {
                return false;
            }
            return true;
        }
        return !z3;
    }

    private boolean e() {
        if (!this.f23362h && this.f23361g != null && this.f23360f != null) {
            return true;
        }
        return false;
    }

    private boolean f() {
        if (!this.f23362h && Color.alpha(this.f23359e.getColor()) != 0) {
            return true;
        }
        return false;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY == 0) {
            this.f23362h = true;
            this.f23363i = false;
            this.f23356b.buildDrawingCache();
            Bitmap drawingCache = this.f23356b.getDrawingCache();
            if (drawingCache == null && this.f23356b.getWidth() != 0 && this.f23356b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f23356b.getWidth(), this.f23356b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f23356b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f23358d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f23362h = false;
            this.f23363i = true;
        }
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY == 0) {
            this.f23363i = false;
            this.f23356b.destroyDrawingCache();
            this.f23358d.setShader(null);
            this.f23356b.invalidate();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (d()) {
            int i4 = STRATEGY;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        this.f23355a.actualDraw(canvas);
                        if (f()) {
                            canvas.drawRect(0.0f, 0.0f, this.f23356b.getWidth(), this.f23356b.getHeight(), this.f23359e);
                        }
                    } else {
                        throw new IllegalStateException("Unsupported strategy " + i4);
                    }
                } else {
                    int save = canvas.save();
                    canvas.clipPath(this.f23357c);
                    this.f23355a.actualDraw(canvas);
                    if (f()) {
                        canvas.drawRect(0.0f, 0.0f, this.f23356b.getWidth(), this.f23356b.getHeight(), this.f23359e);
                    }
                    canvas.restoreToCount(save);
                }
            } else {
                CircularRevealWidget.RevealInfo revealInfo = this.f23360f;
                canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, this.f23358d);
                if (f()) {
                    CircularRevealWidget.RevealInfo revealInfo2 = this.f23360f;
                    canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.f23359e);
                }
            }
        } else {
            this.f23355a.actualDraw(canvas);
            if (f()) {
                canvas.drawRect(0.0f, 0.0f, this.f23356b.getWidth(), this.f23356b.getHeight(), this.f23359e);
            }
        }
        a(canvas);
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f23361g;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.f23359e.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo revealInfo = this.f23360f;
        if (revealInfo == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo2 = new CircularRevealWidget.RevealInfo(revealInfo);
        if (revealInfo2.isInvalid()) {
            revealInfo2.radius = b(revealInfo2);
        }
        return revealInfo2;
    }

    public boolean isOpaque() {
        if (this.f23355a.actualIsOpaque() && !d()) {
            return true;
        }
        return false;
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f23361g = drawable;
        this.f23356b.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int i4) {
        this.f23359e.setColor(i4);
        this.f23356b.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        if (revealInfo == null) {
            this.f23360f = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo2 = this.f23360f;
            if (revealInfo2 == null) {
                this.f23360f = new CircularRevealWidget.RevealInfo(revealInfo);
            } else {
                revealInfo2.set(revealInfo);
            }
            if (MathUtils.geq(revealInfo.radius, b(revealInfo), 1.0E-4f)) {
                this.f23360f.radius = Float.MAX_VALUE;
            }
        }
        c();
    }
}
