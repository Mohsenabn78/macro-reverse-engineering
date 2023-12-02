package com.afollestad.materialdialogs.prefs;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

/* loaded from: classes2.dex */
public class MaterialDialogPreference extends DialogPreference {

    /* renamed from: a  reason: collision with root package name */
    private Context f1162a;

    /* renamed from: b  reason: collision with root package name */
    private MaterialDialog f1163b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements MaterialDialog.SingleButtonCallback {
        a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            int i4 = b.f1167a[dialogAction.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    MaterialDialogPreference.this.onClick(materialDialog, -1);
                    return;
                } else {
                    MaterialDialogPreference.this.onClick(materialDialog, -2);
                    return;
                }
            }
            MaterialDialogPreference.this.onClick(materialDialog, -3);
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1167a;

        static {
            int[] iArr = new int[DialogAction.values().length];
            f1167a = iArr;
            try {
                iArr[DialogAction.NEUTRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1167a[DialogAction.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @TargetApi(21)
    public MaterialDialogPreference(Context context) {
        super(context);
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f1162a = context;
        com.afollestad.materialdialogs.prefs.a.b(context, this, attributeSet);
    }

    @Override // android.preference.DialogPreference
    public Dialog getDialog() {
        return this.f1163b;
    }

    @Override // android.preference.DialogPreference, android.preference.PreferenceManager.OnActivityDestroyListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        MaterialDialog materialDialog = this.f1163b;
        if (materialDialog != null && materialDialog.isShowing()) {
            this.f1163b.dismiss();
        }
    }

    @Override // android.preference.DialogPreference, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.afollestad.materialdialogs.prefs.a.c(this, this);
    }

    @Override // android.preference.DialogPreference, android.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.f1164a) {
                showDialog(savedState.f1165b);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.preference.DialogPreference, android.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            SavedState savedState = new SavedState(onSaveInstanceState);
            savedState.f1164a = true;
            savedState.f1165b = dialog.onSaveInstanceState();
            return savedState;
        }
        return onSaveInstanceState;
    }

    @Override // android.preference.DialogPreference
    protected void showDialog(Bundle bundle) {
        MaterialDialog.Builder autoDismiss = new MaterialDialog.Builder(this.f1162a).title(getDialogTitle()).icon(getDialogIcon()).dismissListener(this).onAny(new a()).positiveText(getPositiveButtonText()).negativeText(getNegativeButtonText()).autoDismiss(true);
        View onCreateDialogView = onCreateDialogView();
        if (onCreateDialogView != null) {
            onBindDialogView(onCreateDialogView);
            autoDismiss.customView(onCreateDialogView, false);
        } else {
            autoDismiss.content(getDialogMessage());
        }
        com.afollestad.materialdialogs.prefs.a.a(this, this);
        MaterialDialog build = autoDismiss.build();
        this.f1163b = build;
        if (bundle != null) {
            build.onRestoreInstanceState(bundle);
        }
        this.f1163b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f1164a;

        /* renamed from: b  reason: collision with root package name */
        Bundle f1165b;

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
            this.f1164a = parcel.readInt() == 1;
            this.f1165b = parcel.readBundle();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f1164a ? 1 : 0);
            parcel.writeBundle(this.f1165b);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialDialogPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MaterialDialogPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialDialogPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        a(context, attributeSet);
    }
}
