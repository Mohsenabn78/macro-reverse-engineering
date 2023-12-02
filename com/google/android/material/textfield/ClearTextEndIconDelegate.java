package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ClearTextEndIconDelegate extends EndIconDelegate {

    /* renamed from: e  reason: collision with root package name */
    private final TextWatcher f24548e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnFocusChangeListener f24549f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.OnEditTextAttachedListener f24550g;

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.OnEndIconChangedListener f24551h;

    /* renamed from: i  reason: collision with root package name */
    private AnimatorSet f24552i;

    /* renamed from: j  reason: collision with root package name */
    private ValueAnimator f24553j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClearTextEndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i4) {
        super(textInputLayout, i4);
        this.f24548e = new TextWatcher() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NonNull Editable editable) {
                if (ClearTextEndIconDelegate.this.f24595a.getSuffixText() != null) {
                    return;
                }
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                clearTextEndIconDelegate.i(clearTextEndIconDelegate.m());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }
        };
        this.f24549f = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z3) {
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                clearTextEndIconDelegate.i(clearTextEndIconDelegate.m());
            }
        };
        this.f24550g = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout2) {
                EditText editText = textInputLayout2.getEditText();
                textInputLayout2.setEndIconVisible(ClearTextEndIconDelegate.this.m());
                textInputLayout2.setEndIconCheckable(false);
                editText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.f24549f);
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                clearTextEndIconDelegate.f24597c.setOnFocusChangeListener(clearTextEndIconDelegate.f24549f);
                editText.removeTextChangedListener(ClearTextEndIconDelegate.this.f24548e);
                editText.addTextChangedListener(ClearTextEndIconDelegate.this.f24548e);
            }
        };
        this.f24551h = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout2, int i5) {
                final EditText editText = textInputLayout2.getEditText();
                if (editText != null && i5 == 2) {
                    editText.post(new Runnable() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.f24548e);
                        }
                    });
                    if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.f24549f) {
                        editText.setOnFocusChangeListener(null);
                    }
                    if (ClearTextEndIconDelegate.this.f24597c.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.f24549f) {
                        ClearTextEndIconDelegate.this.f24597c.setOnFocusChangeListener(null);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z3) {
        boolean z4;
        if (this.f24595a.isEndIconVisible() == z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 && !this.f24552i.isRunning()) {
            this.f24553j.cancel();
            this.f24552i.start();
            if (z4) {
                this.f24552i.end();
            }
        } else if (!z3) {
            this.f24552i.cancel();
            this.f24553j.start();
            if (z4) {
                this.f24553j.end();
            }
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.f24597c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ClearTextEndIconDelegate.this.f24597c.setScaleX(floatValue);
                ClearTextEndIconDelegate.this.f24597c.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    private void l() {
        ValueAnimator k4 = k();
        ValueAnimator j4 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f24552i = animatorSet;
        animatorSet.playTogether(k4, j4);
        this.f24552i.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.f24595a.setEndIconVisible(true);
            }
        });
        ValueAnimator j5 = j(1.0f, 0.0f);
        this.f24553j = j5;
        j5.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.f24595a.setEndIconVisible(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        EditText editText = this.f24595a.getEditText();
        if (editText != null && ((editText.hasFocus() || this.f24597c.hasFocus()) && editText.getText().length() > 0)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void a() {
        TextInputLayout textInputLayout = this.f24595a;
        int i4 = this.f24598d;
        if (i4 == 0) {
            i4 = R.drawable.mtrl_ic_cancel;
        }
        textInputLayout.setEndIconDrawable(i4);
        TextInputLayout textInputLayout2 = this.f24595a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f24595a.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Editable text = ClearTextEndIconDelegate.this.f24595a.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
                ClearTextEndIconDelegate.this.f24595a.refreshEndIconDrawableState();
            }
        });
        this.f24595a.addOnEditTextAttachedListener(this.f24550g);
        this.f24595a.addOnEndIconChangedListener(this.f24551h);
        l();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void c(boolean z3) {
        if (this.f24595a.getSuffixText() == null) {
            return;
        }
        i(z3);
    }
}
