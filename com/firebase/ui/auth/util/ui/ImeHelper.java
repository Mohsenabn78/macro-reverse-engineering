package com.firebase.ui.auth.util.ui;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class ImeHelper {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public interface DonePressedListener {
        void onDonePressed();
    }

    /* loaded from: classes3.dex */
    static class a implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DonePressedListener f18234a;

        a(DonePressedListener donePressedListener) {
            this.f18234a = donePressedListener;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
            if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                if (keyEvent.getAction() == 1) {
                    this.f18234a.onDonePressed();
                }
                return true;
            } else if (i4 == 6) {
                this.f18234a.onDonePressed();
                return true;
            } else {
                return false;
            }
        }
    }

    public static void setImeOnDoneListener(EditText editText, DonePressedListener donePressedListener) {
        editText.setOnEditorActionListener(new a(donePressedListener));
    }
}
