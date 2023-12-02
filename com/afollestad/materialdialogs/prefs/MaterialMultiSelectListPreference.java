package com.afollestad.materialdialogs.prefs;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import java.util.ArrayList;
import java.util.HashSet;

@TargetApi(11)
/* loaded from: classes2.dex */
public class MaterialMultiSelectListPreference extends MultiSelectListPreference {

    /* renamed from: a  reason: collision with root package name */
    private Context f1182a;

    /* renamed from: b  reason: collision with root package name */
    private MaterialDialog f1183b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements MaterialDialog.ListCallbackMultiChoice {
        a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallbackMultiChoice
        public boolean onSelection(MaterialDialog materialDialog, Integer[] numArr, CharSequence[] charSequenceArr) {
            MaterialMultiSelectListPreference.this.onClick(null, -1);
            materialDialog.dismiss();
            HashSet hashSet = new HashSet();
            for (Integer num : numArr) {
                hashSet.add(MaterialMultiSelectListPreference.this.getEntryValues()[num.intValue()].toString());
            }
            if (MaterialMultiSelectListPreference.this.callChangeListener(hashSet)) {
                MaterialMultiSelectListPreference.this.setValues(hashSet);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements MaterialDialog.SingleButtonCallback {
        b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            int i4 = c.f1188a[dialogAction.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    MaterialMultiSelectListPreference.this.onClick(materialDialog, -1);
                    return;
                } else {
                    MaterialMultiSelectListPreference.this.onClick(materialDialog, -2);
                    return;
                }
            }
            MaterialMultiSelectListPreference.this.onClick(materialDialog, -3);
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1188a;

        static {
            int[] iArr = new int[DialogAction.values().length];
            f1188a = iArr;
            try {
                iArr[DialogAction.NEUTRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1188a[DialogAction.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MaterialMultiSelectListPreference(Context context) {
        super(context);
        b(context, null);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f1182a = context;
        com.afollestad.materialdialogs.prefs.a.b(context, this, attributeSet);
    }

    @Override // android.preference.DialogPreference
    public Dialog getDialog() {
        return this.f1183b;
    }

    @Override // android.preference.DialogPreference, android.preference.PreferenceManager.OnActivityDestroyListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        MaterialDialog materialDialog = this.f1183b;
        if (materialDialog != null && materialDialog.isShowing()) {
            this.f1183b.dismiss();
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
            if (savedState.f1184a) {
                showDialog(savedState.f1185b);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.preference.MultiSelectListPreference, android.preference.DialogPreference, android.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            SavedState savedState = new SavedState(onSaveInstanceState);
            savedState.f1184a = true;
            savedState.f1185b = dialog.onSaveInstanceState();
            return savedState;
        }
        return onSaveInstanceState;
    }

    @Override // android.preference.MultiSelectListPreference
    public void setEntries(CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        MaterialDialog materialDialog = this.f1183b;
        if (materialDialog != null) {
            materialDialog.setItems(charSequenceArr);
        }
    }

    @Override // android.preference.DialogPreference
    protected void showDialog(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        for (String str : getValues()) {
            if (findIndexOfValue(str) >= 0) {
                arrayList.add(Integer.valueOf(findIndexOfValue(str)));
            }
        }
        MaterialDialog.Builder dismissListener = new MaterialDialog.Builder(this.f1182a).title(getDialogTitle()).icon(getDialogIcon()).negativeText(getNegativeButtonText()).positiveText(getPositiveButtonText()).onAny(new b()).items(getEntries()).itemsCallbackMultiChoice((Integer[]) arrayList.toArray(new Integer[arrayList.size()]), new a()).dismissListener(this);
        View onCreateDialogView = onCreateDialogView();
        if (onCreateDialogView != null) {
            onBindDialogView(onCreateDialogView);
            dismissListener.customView(onCreateDialogView, false);
        } else {
            dismissListener.content(getDialogMessage());
        }
        com.afollestad.materialdialogs.prefs.a.a(this, this);
        MaterialDialog build = dismissListener.build();
        this.f1183b = build;
        if (bundle != null) {
            build.onRestoreInstanceState(bundle);
        }
        this.f1183b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f1184a;

        /* renamed from: b  reason: collision with root package name */
        Bundle f1185b;

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
            this.f1184a = parcel.readInt() == 1;
            this.f1185b = parcel.readBundle();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f1184a ? 1 : 0);
            parcel.writeBundle(this.f1185b);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialMultiSelectListPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        b(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialMultiSelectListPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        b(context, attributeSet);
    }
}
