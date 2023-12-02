package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.os.ParcelCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.clipboard.ClipboardDataStore;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.ClipboardConstraintInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClipboardConstraint.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nClipboardConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClipboardConstraint.kt\ncom/arlosoft/macrodroid/constraint/ClipboardConstraint\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,194:1\n262#2,2:195\n262#2,2:197\n262#2,2:199\n262#2,2:201\n*S KotlinDebug\n*F\n+ 1 ClipboardConstraint.kt\ncom/arlosoft/macrodroid/constraint/ClipboardConstraint\n*L\n143#1:195,2\n144#1:197,2\n145#1:199,2\n146#1:201,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ClipboardConstraint extends Constraint implements SupportsMagicText {
    @NotNull
    private final transient ClipboardManager clipboardManager;
    private boolean enableRegex;
    private boolean ignoreCase;
    @NotNull
    private String text;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ClipboardConstraint> CREATOR = new Parcelable.Creator<ClipboardConstraint>() { // from class: com.arlosoft.macrodroid.constraint.ClipboardConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ClipboardConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ClipboardConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ClipboardConstraint[] newArray(int i4) {
            return new ClipboardConstraint[i4];
        }
    };

    public /* synthetic */ ClipboardConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(CheckBox ignoreCaseCheckBox, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(ignoreCaseCheckBox, "$ignoreCaseCheckBox");
        ignoreCaseCheckBox.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ClipboardConstraint this$0, EditText editText, CheckBox checkBox, CheckBox ignoreCaseCheckBox, AppCompatDialog dialog, View view) {
        Editable editable;
        boolean z3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ignoreCaseCheckBox, "$ignoreCaseCheckBox");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        this$0.text = String.valueOf(editable);
        if (checkBox != null) {
            z3 = checkBox.isChecked();
        } else {
            z3 = false;
        }
        this$0.enableRegex = z3;
        this$0.ignoreCase = ignoreCaseCheckBox.isChecked();
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Activity activity, MagicText.MagicTextListener magicTextListener, ClipboardConstraint this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        ClipData.Item itemAt;
        String obj;
        String str = "";
        if (Build.VERSION.SDK_INT >= 29) {
            if (ClipboardDataStore.getClipboardText() != null) {
                obj = ClipboardDataStore.getClipboardText();
            }
            obj = "";
        } else {
            ClipData primaryClip = this.clipboardManager.getPrimaryClip();
            if (primaryClip != null && (itemAt = primaryClip.getItemAt(0)) != null) {
                obj = itemAt.coerceToText(getContext()).toString();
            }
            obj = "";
        }
        String regexPattern = WildCardHelper.getRegexPattern(MagicText.replaceMagicText(getContext(), this.text, triggerContextInfo, getMacro()), this.enableRegex, this.ignoreCase);
        if (obj != null) {
            str = obj;
        }
        return WildCardHelper.matches(str, regexPattern, this.enableRegex, this.ignoreCase);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.text;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ClipboardConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String truncateIfRequired = MDTextUtils.truncateIfRequired(getExtendedDetail(), 20);
        return configuredName + " (" + truncateIfRequired + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.text};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getSystemLogEntryName(@Nullable TriggerContextInfo triggerContextInfo) {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
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
        appCompatDialog.setContentView(R.layout.dialog_clipboard_change_trigger);
        appCompatDialog.setTitle(R.string.constraint_clipboard_contents);
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
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.dialog_clipboard_change_trigger_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.dialog_clipboard_change_trigger_magic_text_button);
        CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.useLogcatCheckbox);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.useLogcatInfo);
        CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.useAccessibilityCheckbox);
        TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.useAccessibilityInfo);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.enable_regex);
        View findViewById = appCompatDialog.findViewById(R.id.ignore_case);
        Intrinsics.checkNotNull(findViewById);
        final CheckBox checkBox4 = (CheckBox) findViewById;
        if (editText != null) {
            editText.setText(this.text);
        }
        if (editText != null) {
            editText.setSelection(editText.length());
        }
        checkBox4.setEnabled(!this.enableRegex);
        checkBox4.setChecked(this.ignoreCase);
        if (checkBox3 != null) {
            checkBox3.setChecked(this.enableRegex);
        }
        if (checkBox3 != null) {
            checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.h0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    ClipboardConstraint.T(checkBox4, compoundButton, z3);
                }
            });
        }
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClipboardConstraint.U(ClipboardConstraint.this, editText, checkBox3, checkBox4, appCompatDialog, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClipboardConstraint.V(AppCompatDialog.this, view);
                }
            });
        }
        if (editText != null) {
            final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.k0
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    ClipboardConstraint.W(editText, magicTextPair);
                }
            };
            if (button3 != null) {
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.l0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClipboardConstraint.X(activity, magicTextListener, this, view);
                    }
                });
            }
        }
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.text = magicText[0];
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
        out.writeString(this.text);
        ParcelCompat.writeBoolean(out, this.enableRegex);
        out.writeInt(this.ignoreCase ? 1 : 0);
    }

    public ClipboardConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ClipboardConstraint() {
        this.text = "";
        this.ignoreCase = true;
        Object systemService = getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this.clipboardManager = (ClipboardManager) systemService;
        this.text = "";
    }

    private ClipboardConstraint(Parcel parcel) {
        super(parcel);
        this.text = "";
        this.ignoreCase = true;
        Object systemService = getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this.clipboardManager = (ClipboardManager) systemService;
        String readString = parcel.readString();
        this.text = readString != null ? readString : "";
        this.enableRegex = ParcelCompat.readBoolean(parcel);
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* compiled from: ClipboardConstraint.kt */
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
