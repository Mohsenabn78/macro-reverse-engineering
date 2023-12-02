package com.firebase.ui.auth.util.ui;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Collections;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class BucketedTextChangeListener implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f18229a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentChangeCallback f18230b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f18231c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18232d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18233e;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public interface ContentChangeCallback {
        void whenComplete();

        void whileIncomplete();
    }

    public BucketedTextChangeListener(EditText editText, int i4, String str, ContentChangeCallback contentChangeCallback) {
        this.f18229a = editText;
        this.f18233e = i4;
        this.f18231c = a(str, i4);
        this.f18230b = contentChangeCallback;
        this.f18232d = str;
    }

    private static String[] a(CharSequence charSequence, int i4) {
        String[] strArr = new String[i4 + 1];
        for (int i5 = 0; i5 <= i4; i5++) {
            strArr[i5] = TextUtils.join("", Collections.nCopies(i5, charSequence));
        }
        return strArr;
    }

    @Override // android.text.TextWatcher
    @SuppressLint({"SetTextI18n"})
    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        ContentChangeCallback contentChangeCallback;
        String replaceAll = charSequence.toString().replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "").replaceAll(this.f18232d, "");
        int min = Math.min(replaceAll.length(), this.f18233e);
        String substring = replaceAll.substring(0, min);
        this.f18229a.removeTextChangedListener(this);
        EditText editText = this.f18229a;
        editText.setText(substring + this.f18231c[this.f18233e - min]);
        this.f18229a.setSelection(min);
        this.f18229a.addTextChangedListener(this);
        if (min == this.f18233e && (contentChangeCallback = this.f18230b) != null) {
            contentChangeCallback.whenComplete();
            return;
        }
        ContentChangeCallback contentChangeCallback2 = this.f18230b;
        if (contentChangeCallback2 != null) {
            contentChangeCallback2.whileIncomplete();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }
}
