package com.afollestad.materialdialogs.prefs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;

/* loaded from: classes2.dex */
public class MaterialEditTextPreference extends EditTextPreference {

    /* renamed from: a  reason: collision with root package name */
    private int f1168a;

    /* renamed from: b  reason: collision with root package name */
    private MaterialDialog f1169b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f1170c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements MaterialDialog.SingleButtonCallback {
        a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            int i4 = b.f1174a[dialogAction.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    MaterialEditTextPreference.this.onClick(materialDialog, -1);
                    return;
                } else {
                    MaterialEditTextPreference.this.onClick(materialDialog, -2);
                    return;
                }
            }
            MaterialEditTextPreference.this.onClick(materialDialog, -3);
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1174a;

        static {
            int[] iArr = new int[DialogAction.values().length];
            f1174a = iArr;
            try {
                iArr[DialogAction.NEUTRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1174a[DialogAction.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MaterialEditTextPreference(Context context) {
        super(context);
        this.f1168a = 0;
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        com.afollestad.materialdialogs.prefs.a.b(context, this, attributeSet);
        this.f1168a = DialogUtils.resolveColor(context, R.attr.md_widget_color, DialogUtils.resolveColor(context, R.attr.colorAccent, DialogUtils.resolveColor(context, 16843829)));
        AppCompatEditText appCompatEditText = new AppCompatEditText(context, attributeSet);
        this.f1170c = appCompatEditText;
        appCompatEditText.setId(16908291);
        this.f1170c.setEnabled(true);
    }

    private void b(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setSoftInputMode(5);
    }

    @Override // android.preference.DialogPreference
    public Dialog getDialog() {
        return this.f1169b;
    }

    @Override // android.preference.EditTextPreference
    public EditText getEditText() {
        return this.f1170c;
    }

    @Override // android.preference.DialogPreference, android.preference.PreferenceManager.OnActivityDestroyListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        MaterialDialog materialDialog = this.f1169b;
        if (materialDialog != null && materialDialog.isShowing()) {
            this.f1169b.dismiss();
        }
    }

    @Override // android.preference.EditTextPreference
    protected void onAddEditTextToDialogView(@NonNull View view, @NonNull EditText editText) {
        ((ViewGroup) view).addView(editText, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    @SuppressLint({"MissingSuperCall"})
    protected void onBindDialogView(@NonNull View view) {
        EditText editText = this.f1170c;
        editText.setText(getText());
        if (editText.getText().length() > 0) {
            editText.setSelection(editText.length());
        }
        ViewParent parent = editText.getParent();
        if (parent != view) {
            if (parent != null) {
                ((ViewGroup) parent).removeView(editText);
            }
            onAddEditTextToDialogView(view, editText);
        }
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    protected void onDialogClosed(boolean z3) {
        if (z3) {
            String obj = this.f1170c.getText().toString();
            if (callChangeListener(obj)) {
                setText(obj);
            }
        }
    }

    @Override // android.preference.DialogPreference, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.afollestad.materialdialogs.prefs.a.c(this, this);
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference, android.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.f1171a) {
                showDialog(savedState.f1172b);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference, android.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            SavedState savedState = new SavedState(onSaveInstanceState);
            savedState.f1171a = true;
            savedState.f1172b = dialog.onSaveInstanceState();
            return savedState;
        }
        return onSaveInstanceState;
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    protected void showDialog(Bundle bundle) {
        MaterialDialog.Builder dismissListener = new MaterialDialog.Builder(getContext()).title(getDialogTitle()).icon(getDialogIcon()).positiveText(getPositiveButtonText()).negativeText(getNegativeButtonText()).dismissListener(this).onAny(new a()).dismissListener(this);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.md_stub_inputpref, (ViewGroup) null);
        onBindDialogView(inflate);
        MDTintHelper.setTint(this.f1170c, this.f1168a);
        TextView textView = (TextView) inflate.findViewById(16908299);
        if (getDialogMessage() != null && getDialogMessage().toString().length() > 0) {
            textView.setVisibility(0);
            textView.setText(getDialogMessage());
        } else {
            textView.setVisibility(8);
        }
        dismissListener.customView(inflate, false);
        com.afollestad.materialdialogs.prefs.a.a(this, this);
        MaterialDialog build = dismissListener.build();
        this.f1169b = build;
        if (bundle != null) {
            build.onRestoreInstanceState(bundle);
        }
        b(this.f1169b);
        this.f1169b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f1171a;

        /* renamed from: b  reason: collision with root package name */
        Bundle f1172b;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1171a = parcel.readInt() == 1;
            this.f1172b = parcel.readBundle();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f1171a ? 1 : 0);
            parcel.writeBundle(this.f1172b);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1168a = 0;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialEditTextPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1168a = 0;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialEditTextPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f1168a = 0;
        a(context, attributeSet);
    }
}
