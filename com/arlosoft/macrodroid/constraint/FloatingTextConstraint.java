package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.FloatingTextConstraintInfo;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.database.FloatingTextData;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatingTextConstraint.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FloatingTextConstraint extends Constraint implements SupportsMagicText {
    @NotNull
    private final transient Database database;
    @NotNull
    private String identifier;
    private boolean isShowing;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<FloatingTextConstraint> CREATOR = new Parcelable.Creator<FloatingTextConstraint>() { // from class: com.arlosoft.macrodroid.constraint.FloatingTextConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FloatingTextConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FloatingTextConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FloatingTextConstraint[] newArray(int i4) {
            return new FloatingTextConstraint[i4];
        }
    };

    public /* synthetic */ FloatingTextConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(FloatingTextConstraint this$0, RadioButton showingRadioButton, EditText identifierText, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(showingRadioButton, "$showingRadioButton");
        Intrinsics.checkNotNullParameter(identifierText, "$identifierText");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.isShowing = showingRadioButton.isChecked();
        this$0.identifier = identifierText.getText().toString();
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(EditText identifierText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(identifierText, "$identifierText");
        int max = Math.max(identifierText.getSelectionStart(), 0);
        int max2 = Math.max(identifierText.getSelectionEnd(), 0);
        Editable text = identifierText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Activity activity, MagicText.MagicTextListener magicTextListener, FloatingTextConstraint this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.identifier, triggerContextInfo, getMacro());
        for (FloatingTextData floatingTextData : this.database.getFloatingTexts(true)) {
            if (Intrinsics.areEqual(floatingTextData.getId(), replaceMagicText)) {
                if (floatingTextData.isVisible() == this.isShowing) {
                    return true;
                }
                return false;
            }
        }
        return !this.isShowing;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String r4;
        String str = this.identifier;
        if (this.isShowing) {
            r4 = SelectableItem.r(R.string.constraint_floating_text_is_showing);
        } else {
            r4 = SelectableItem.r(R.string.constraint_floating_text_not_showing);
        }
        return str + " (" + r4 + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return FloatingTextConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.identifier};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        WindowManager.LayoutParams layoutParams;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_floating_text_constraint);
        appCompatDialog.setTitle(R.string.constraint_floating_text);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = appCompatDialog.findViewById(R.id.identifier);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.magicTextButton);
        Intrinsics.checkNotNull(findViewById4);
        View findViewById5 = appCompatDialog.findViewById(R.id.showingRadioButton);
        Intrinsics.checkNotNull(findViewById5);
        final RadioButton radioButton = (RadioButton) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.notShowingRadioButton);
        Intrinsics.checkNotNull(findViewById6);
        editText.setText(this.identifier);
        ((Button) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingTextConstraint.S(FloatingTextConstraint.this, radioButton, editText, appCompatDialog, view);
            }
        });
        radioButton.setChecked(this.isShowing);
        ((RadioButton) findViewById6).setChecked(!this.isShowing);
        ((Button) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingTextConstraint.T(AppCompatDialog.this, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.h1
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                FloatingTextConstraint.U(editText, magicTextPair);
            }
        };
        ((Button) findViewById4).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingTextConstraint.V(activity, magicTextListener, this, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.identifier = magicText[0];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.identifier);
        out.writeInt(this.isShowing ? 1 : 0);
    }

    public FloatingTextConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private FloatingTextConstraint() {
        Database database = Database.getInstance();
        Intrinsics.checkNotNullExpressionValue(database, "getInstance()");
        this.database = database;
        this.identifier = "";
    }

    private FloatingTextConstraint(Parcel parcel) {
        super(parcel);
        Database database = Database.getInstance();
        Intrinsics.checkNotNullExpressionValue(database, "getInstance()");
        this.database = database;
        this.identifier = "";
        String readString = parcel.readString();
        this.identifier = readString != null ? readString : "";
        this.isShowing = parcel.readInt() != 0;
    }

    /* compiled from: FloatingTextConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
