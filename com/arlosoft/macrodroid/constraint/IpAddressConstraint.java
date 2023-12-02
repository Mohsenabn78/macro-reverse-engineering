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
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.info.IpAddressConstraintInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IpAddressConstraint.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class IpAddressConstraint extends Constraint implements SupportsMagicText {
    @NotNull
    private String ipAddress;
    private boolean matches;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<IpAddressConstraint> CREATOR = new Parcelable.Creator<IpAddressConstraint>() { // from class: com.arlosoft.macrodroid.constraint.IpAddressConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IpAddressConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IpAddressConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IpAddressConstraint[] newArray(int i4) {
            return new IpAddressConstraint[i4];
        }
    };

    public /* synthetic */ IpAddressConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(IpAddressConstraint this$0, RadioButton matchesRadioButton, EditText ipAddressText, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(matchesRadioButton, "$matchesRadioButton");
        Intrinsics.checkNotNullParameter(ipAddressText, "$ipAddressText");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.matches = matchesRadioButton.isChecked();
        this$0.ipAddress = ipAddressText.getText().toString();
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(EditText ipAddressText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(ipAddressText, "$ipAddressText");
        int max = Math.max(ipAddressText.getSelectionStart(), 0);
        int max2 = Math.max(ipAddressText.getSelectionEnd(), 0);
        Editable text = ipAddressText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Activity activity, MagicText.MagicTextListener magicTextListener, IpAddressConstraint this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        String trimStart;
        String ipAddressToCheck = MagicText.replaceMagicText(getContext(), this.ipAddress, triggerContextInfo, getMacro());
        String localIpv4Address = Util.getLocalIpv4Address();
        Intrinsics.checkNotNullExpressionValue(ipAddressToCheck, "ipAddressToCheck");
        trimStart = StringsKt__StringsKt.trimStart(ipAddressToCheck, TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        if (WildCardHelper.matches(localIpv4Address, WildCardHelper.getRegexContainsPattern(trimStart, true, true), true, true) == this.matches) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.ipAddress;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return IpAddressConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.ipAddress};
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
        appCompatDialog.setContentView(R.layout.dialog_ip_address);
        appCompatDialog.setTitle(R.string.constraint_ip_address);
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
        View findViewById3 = appCompatDialog.findViewById(R.id.ipAddress);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.ipAddressMagicTextButton);
        Intrinsics.checkNotNull(findViewById4);
        View findViewById5 = appCompatDialog.findViewById(R.id.matchesRadioButton);
        Intrinsics.checkNotNull(findViewById5);
        final RadioButton radioButton = (RadioButton) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.excludesRadioButton);
        Intrinsics.checkNotNull(findViewById6);
        editText.setText(this.ipAddress);
        ((Button) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IpAddressConstraint.S(IpAddressConstraint.this, radioButton, editText, appCompatDialog, view);
            }
        });
        radioButton.setChecked(this.matches);
        ((RadioButton) findViewById6).setChecked(!this.matches);
        ((Button) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IpAddressConstraint.T(AppCompatDialog.this, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.x1
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                IpAddressConstraint.U(editText, magicTextPair);
            }
        };
        ((Button) findViewById4).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IpAddressConstraint.V(activity, magicTextListener, this, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.ipAddress = magicText[0];
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
        out.writeString(this.ipAddress);
        out.writeInt(this.matches ? 1 : 0);
    }

    public IpAddressConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private IpAddressConstraint() {
        this.ipAddress = "";
        this.matches = true;
    }

    private IpAddressConstraint(Parcel parcel) {
        super(parcel);
        this.ipAddress = "";
        this.matches = true;
        String readString = parcel.readString();
        this.ipAddress = readString != null ? readString : "";
        this.matches = parcel.readInt() != 0;
    }

    /* compiled from: IpAddressConstraint.kt */
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
