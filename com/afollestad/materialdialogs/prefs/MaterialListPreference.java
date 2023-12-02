package com.afollestad.materialdialogs.prefs;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.ListPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class MaterialListPreference extends ListPreference {

    /* renamed from: a  reason: collision with root package name */
    private Context f1175a;

    /* renamed from: b  reason: collision with root package name */
    private MaterialDialog f1176b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements MaterialDialog.ListCallbackSingleChoice {
        a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallbackSingleChoice
        public boolean onSelection(MaterialDialog materialDialog, View view, int i4, CharSequence charSequence) {
            MaterialListPreference.this.onClick(null, -1);
            if (i4 >= 0 && MaterialListPreference.this.getEntryValues() != null) {
                try {
                    Field declaredField = ListPreference.class.getDeclaredField("mClickedDialogEntryIndex");
                    declaredField.setAccessible(true);
                    declaredField.set(MaterialListPreference.this, Integer.valueOf(i4));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
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
            int i4 = c.f1181a[dialogAction.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    MaterialListPreference.this.onClick(materialDialog, -1);
                    return;
                } else {
                    MaterialListPreference.this.onClick(materialDialog, -2);
                    return;
                }
            }
            MaterialListPreference.this.onClick(materialDialog, -3);
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1181a;

        static {
            int[] iArr = new int[DialogAction.values().length];
            f1181a = iArr;
            try {
                iArr[DialogAction.NEUTRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1181a[DialogAction.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MaterialListPreference(Context context) {
        super(context);
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f1175a = context;
        com.afollestad.materialdialogs.prefs.a.b(context, this, attributeSet);
    }

    @Override // android.preference.DialogPreference
    public Dialog getDialog() {
        return this.f1176b;
    }

    public RecyclerView getRecyclerView() {
        if (getDialog() == null) {
            return null;
        }
        return ((MaterialDialog) getDialog()).getRecyclerView();
    }

    @Override // android.preference.DialogPreference, android.preference.PreferenceManager.OnActivityDestroyListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        MaterialDialog materialDialog = this.f1176b;
        if (materialDialog != null && materialDialog.isShowing()) {
            this.f1176b.dismiss();
        }
    }

    @Override // android.preference.DialogPreference, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.afollestad.materialdialogs.prefs.a.c(this, this);
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference, android.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.f1177a) {
                showDialog(savedState.f1178b);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference, android.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            SavedState savedState = new SavedState(onSaveInstanceState);
            savedState.f1177a = true;
            savedState.f1178b = dialog.onSaveInstanceState();
            return savedState;
        }
        return onSaveInstanceState;
    }

    @Override // android.preference.ListPreference
    public void setEntries(CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        MaterialDialog materialDialog = this.f1176b;
        if (materialDialog != null) {
            materialDialog.setItems(charSequenceArr);
        }
    }

    @Override // android.preference.DialogPreference
    protected void showDialog(Bundle bundle) {
        if (getEntries() != null && getEntryValues() != null) {
            MaterialDialog.Builder itemsCallbackSingleChoice = new MaterialDialog.Builder(this.f1175a).title(getDialogTitle()).icon(getDialogIcon()).dismissListener(this).onAny(new b()).negativeText(getNegativeButtonText()).items(getEntries()).autoDismiss(true).itemsCallbackSingleChoice(findIndexOfValue(getValue()), new a());
            View onCreateDialogView = onCreateDialogView();
            if (onCreateDialogView != null) {
                onBindDialogView(onCreateDialogView);
                itemsCallbackSingleChoice.customView(onCreateDialogView, false);
            } else {
                itemsCallbackSingleChoice.content(getDialogMessage());
            }
            com.afollestad.materialdialogs.prefs.a.a(this, this);
            MaterialDialog build = itemsCallbackSingleChoice.build();
            this.f1176b = build;
            if (bundle != null) {
                build.onRestoreInstanceState(bundle);
            }
            onClick(this.f1176b, -2);
            this.f1176b.show();
            return;
        }
        throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f1177a;

        /* renamed from: b  reason: collision with root package name */
        Bundle f1178b;

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
            this.f1177a = parcel.readInt() == 1;
            this.f1178b = parcel.readBundle();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f1177a ? 1 : 0);
            parcel.writeBundle(this.f1178b);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialListPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialListPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        a(context, attributeSet);
    }
}
