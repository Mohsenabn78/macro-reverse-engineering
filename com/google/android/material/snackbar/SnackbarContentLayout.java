package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {

    /* renamed from: a  reason: collision with root package name */
    private TextView f24449a;

    /* renamed from: b  reason: collision with root package name */
    private Button f24450b;

    /* renamed from: c  reason: collision with root package name */
    private int f24451c;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    private static void b(@NonNull View view, int i4, int i5) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i4, ViewCompat.getPaddingEnd(view), i5);
        } else {
            view.setPadding(view.getPaddingLeft(), i4, view.getPaddingRight(), i5);
        }
    }

    private boolean c(int i4, int i5, int i6) {
        boolean z3;
        if (i4 != getOrientation()) {
            setOrientation(i4);
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f24449a.getPaddingTop() == i5 && this.f24449a.getPaddingBottom() == i6) {
            return z3;
        }
        b(this.f24449a, i5, i6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f4) {
        if (f4 != 1.0f) {
            this.f24450b.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.f24450b.getCurrentTextColor(), f4));
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i4, int i5) {
        this.f24449a.setAlpha(0.0f);
        long j4 = i5;
        long j5 = i4;
        this.f24449a.animate().alpha(1.0f).setDuration(j4).setStartDelay(j5).start();
        if (this.f24450b.getVisibility() == 0) {
            this.f24450b.setAlpha(0.0f);
            this.f24450b.animate().alpha(1.0f).setDuration(j4).setStartDelay(j5).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i4, int i5) {
        this.f24449a.setAlpha(1.0f);
        long j4 = i5;
        long j5 = i4;
        this.f24449a.animate().alpha(0.0f).setDuration(j4).setStartDelay(j5).start();
        if (this.f24450b.getVisibility() == 0) {
            this.f24450b.setAlpha(1.0f);
            this.f24450b.animate().alpha(0.0f).setDuration(j4).setStartDelay(j5).start();
        }
    }

    public Button getActionView() {
        return this.f24450b;
    }

    public TextView getMessageView() {
        return this.f24449a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f24449a = (TextView) findViewById(R.id.snackbar_text);
        this.f24450b = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (c(1, r0, r0 - r1) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (c(0, r0, r0) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.google.android.material.R.dimen.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f24449a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L27
            r2 = 1
            goto L28
        L27:
            r2 = 0
        L28:
            if (r2 == 0) goto L41
            int r5 = r7.f24451c
            if (r5 <= 0) goto L41
            android.widget.Button r5 = r7.f24450b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f24451c
            if (r5 <= r6) goto L41
            int r1 = r0 - r1
            boolean r0 = r7.c(r4, r0, r1)
            if (r0 == 0) goto L4c
            goto L4b
        L41:
            if (r2 == 0) goto L44
            goto L45
        L44:
            r0 = r1
        L45:
            boolean r0 = r7.c(r3, r0, r0)
            if (r0 == 0) goto L4c
        L4b:
            r3 = 1
        L4c:
            if (r3 == 0) goto L51
            super.onMeasure(r8, r9)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i4) {
        this.f24451c = i4;
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
