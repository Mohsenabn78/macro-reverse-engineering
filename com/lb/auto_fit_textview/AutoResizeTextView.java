package com.lb.auto_fit_textview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes6.dex */
public class AutoResizeTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f36110a;

    /* renamed from: b  reason: collision with root package name */
    private final b f36111b;

    /* renamed from: c  reason: collision with root package name */
    private float f36112c;

    /* renamed from: d  reason: collision with root package name */
    private float f36113d;

    /* renamed from: e  reason: collision with root package name */
    private float f36114e;

    /* renamed from: f  reason: collision with root package name */
    private float f36115f;

    /* renamed from: g  reason: collision with root package name */
    private int f36116g;

    /* renamed from: h  reason: collision with root package name */
    private int f36117h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36118i;

    /* renamed from: j  reason: collision with root package name */
    private TextPaint f36119j;

    /* loaded from: classes6.dex */
    class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final RectF f36120a = new RectF();

        a() {
        }

        @Override // com.lb.auto_fit_textview.AutoResizeTextView.b
        @TargetApi(16)
        public int a(int i4, RectF rectF) {
            String charSequence;
            boolean z3;
            AutoResizeTextView.this.f36119j.setTextSize(i4);
            TransformationMethod transformationMethod = AutoResizeTextView.this.getTransformationMethod();
            if (transformationMethod != null) {
                charSequence = transformationMethod.getTransformation(AutoResizeTextView.this.getText(), AutoResizeTextView.this).toString();
            } else {
                charSequence = AutoResizeTextView.this.getText().toString();
            }
            if (AutoResizeTextView.this.getMaxLines() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                this.f36120a.bottom = AutoResizeTextView.this.f36119j.getFontSpacing();
                this.f36120a.right = AutoResizeTextView.this.f36119j.measureText(charSequence);
            } else {
                StaticLayout staticLayout = new StaticLayout(charSequence, AutoResizeTextView.this.f36119j, AutoResizeTextView.this.f36116g, Layout.Alignment.ALIGN_NORMAL, AutoResizeTextView.this.f36113d, AutoResizeTextView.this.f36114e, true);
                if (AutoResizeTextView.this.getMaxLines() != -1 && staticLayout.getLineCount() > AutoResizeTextView.this.getMaxLines()) {
                    return 1;
                }
                this.f36120a.bottom = staticLayout.getHeight();
                int lineCount = staticLayout.getLineCount();
                int i5 = -1;
                for (int i6 = 0; i6 < lineCount; i6++) {
                    int lineEnd = staticLayout.getLineEnd(i6);
                    if (i6 < lineCount - 1 && lineEnd > 0 && !AutoResizeTextView.this.isValidWordWrap(charSequence.charAt(lineEnd - 1), charSequence.charAt(lineEnd))) {
                        return 1;
                    }
                    if (i5 < staticLayout.getLineRight(i6) - staticLayout.getLineLeft(i6)) {
                        i5 = ((int) staticLayout.getLineRight(i6)) - ((int) staticLayout.getLineLeft(i6));
                    }
                }
                this.f36120a.right = i5;
            }
            this.f36120a.offsetTo(0.0f, 0.0f);
            if (!rectF.contains(this.f36120a)) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface b {
        int a(int i4, RectF rectF);
    }

    public AutoResizeTextView(Context context) {
        this(context, null, 16842884);
    }

    private void e() {
        if (!this.f36118i) {
            return;
        }
        int i4 = (int) this.f36115f;
        int measuredHeight = (getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop();
        int measuredWidth = (getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        this.f36116g = measuredWidth;
        if (measuredWidth <= 0) {
            return;
        }
        this.f36119j = new TextPaint(getPaint());
        RectF rectF = this.f36110a;
        rectF.right = this.f36116g;
        rectF.bottom = measuredHeight;
        g(i4);
    }

    private int f(int i4, int i5, b bVar, RectF rectF) {
        int i6 = i5 - 1;
        int i7 = i4;
        while (i4 <= i6) {
            i7 = (i4 + i6) >>> 1;
            int a4 = bVar.a(i7, rectF);
            if (a4 < 0) {
                int i8 = i7 + 1;
                i7 = i4;
                i4 = i8;
            } else if (a4 <= 0) {
                break;
            } else {
                i7--;
                i6 = i7;
            }
        }
        return i7;
    }

    private void g(int i4) {
        super.setTextSize(0, f(i4, (int) this.f36112c, this.f36111b, this.f36110a));
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.f36117h;
    }

    public boolean isValidWordWrap(char c4, char c5) {
        if (c4 != ' ' && c4 != '-') {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 != i6 || i5 != i7) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        e();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f4, float f5) {
        super.setLineSpacing(f4, f5);
        this.f36113d = f5;
        this.f36114e = f4;
    }

    @Override // android.widget.TextView
    public void setLines(int i4) {
        super.setLines(i4);
        this.f36117h = i4;
        e();
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i4) {
        super.setMaxLines(i4);
        this.f36117h = i4;
        e();
    }

    public void setMinTextSize(float f4) {
        this.f36115f = f4;
        e();
    }

    @Override // android.widget.TextView
    public void setSingleLine() {
        super.setSingleLine();
        this.f36117h = 1;
        e();
    }

    @Override // android.widget.TextView
    public void setTextSize(float f4) {
        this.f36112c = f4;
        e();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        e();
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f36110a = new RectF();
        this.f36113d = 1.0f;
        this.f36114e = 0.0f;
        this.f36118i = false;
        this.f36115f = TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics());
        this.f36112c = getTextSize();
        this.f36119j = new TextPaint(getPaint());
        if (this.f36117h == 0) {
            this.f36117h = -1;
        }
        this.f36111b = new a();
        this.f36118i = true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i4, float f4) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        this.f36112c = TypedValue.applyDimension(i4, f4, resources.getDisplayMetrics());
        e();
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z3) {
        super.setSingleLine(z3);
        if (z3) {
            this.f36117h = 1;
        } else {
            this.f36117h = -1;
        }
        e();
    }
}
