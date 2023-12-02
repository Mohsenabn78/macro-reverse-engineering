package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.GeofenceConstraintInfo;
import com.arlosoft.macrodroid.geofences.GeofenceListActivity;
import com.arlosoft.macrodroid.geofences.GeofenceManager;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import javax.inject.Inject;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GeofenceConstraint.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nGeofenceConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GeofenceConstraint.kt\ncom/arlosoft/macrodroid/constraint/GeofenceConstraint\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n1#2:284\n*E\n"})
/* loaded from: classes3.dex */
public final class GeofenceConstraint extends Constraint {
    private static final int AREA_IS_INSIDE = 0;
    private static final int AREA_IS_OUTSIDE = 1;
    private static final int AREA_IS_UNKNOWN = 2;
    private static final int OPTION_INSIDE_AREA = 0;
    private static final int OPTION_OUTSIDE_AREA = 1;
    private static final int SELECT_GEOFENCE = 1;
    private boolean allowUnknown;
    @Nullable
    private String geofenceId;
    @Inject
    public transient GeofenceManager geofenceManager;
    @Nullable
    private String geofenceName;
    @Nullable
    private transient String oldGeofenceId;
    private int option;
    private int updateRateMinutes;
    @Nullable
    private String updateRateText;
    @Nullable
    private transient TextView zoneNameButton;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<GeofenceConstraint> CREATOR = new Parcelable.Creator<GeofenceConstraint>() { // from class: com.arlosoft.macrodroid.constraint.GeofenceConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public GeofenceConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GeofenceConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public GeofenceConstraint[] newArray(int i4) {
            return new GeofenceConstraint[i4];
        }
    };

    public /* synthetic */ GeofenceConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final int V() {
        int i4 = this.updateRateMinutes;
        if (i4 == 0) {
            return 30000;
        }
        return i4 * 60 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(GeofenceConstraint this$0, TextView textView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(GeofenceConstraint this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(GeofenceConstraint this$0, RadioButton radioButton, CheckBox checkBox, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (this$0.geofenceId != null && this$0.geofenceName != null) {
            String str = this$0.oldGeofenceId;
            if (str != null) {
                GeofenceManager geofenceManager = this$0.getGeofenceManager();
                long siguid = this$0.getSIGUID();
                String name = this$0.getMacro().getName();
                Intrinsics.checkNotNullExpressionValue(name, "macro.name");
                Long macroGuid = this$0.getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                geofenceManager.removeGeofenceSubscription(str, siguid, name, macroGuid.longValue());
            }
            Intrinsics.checkNotNull(radioButton);
            this$0.option = !radioButton.isChecked();
            Intrinsics.checkNotNull(checkBox);
            this$0.allowUnknown = checkBox.isChecked();
            dialog.dismiss();
            this$0.itemComplete();
            this$0.zoneNameButton = null;
            return;
        }
        ToastCompat.makeText(this$0.getContext(), (int) R.string.select_zone, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(GeofenceConstraint this$0, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.zoneNameButton = null;
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(GeofenceConstraint this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zoneNameButton = null;
    }

    private final void b0(final TextView textView) {
        final String[] stringArray = getContext().getResources().getStringArray(R.array.geofence_trigger_update_rate_names);
        Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources.getStr…rigger_update_rate_names)");
        final int[] intArray = getContext().getResources().getIntArray(R.array.geofence_trigger_update_rates_int);
        Intrinsics.checkNotNullExpressionValue(intArray, "context.resources.getInt…trigger_update_rates_int)");
        int length = intArray.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (intArray[i5] == this.updateRateMinutes) {
                i4 = i6;
                break;
            } else {
                i6++;
                i5++;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(stringArray, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.p1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                GeofenceConstraint.c0(GeofenceConstraint.this, dialogInterface, i7);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.q1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                GeofenceConstraint.d0(GeofenceConstraint.this, stringArray, intArray, textView, dialogInterface, i7);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(GeofenceConstraint this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(GeofenceConstraint this$0, String[] options, int[] values, TextView updateRateTextView, DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(values, "$values");
        Intrinsics.checkNotNullParameter(updateRateTextView, "$updateRateTextView");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        int checkedItemPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
        String str = options[checkedItemPosition];
        this$0.updateRateText = str;
        this$0.updateRateMinutes = values[checkedItemPosition];
        updateRateTextView.setText(str);
    }

    private final void e0() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, GeofenceListActivity.class);
        intent.putExtra("ThemeType", 2);
        intent.putExtra(GeofenceListActivity.EXTRA_PICKER_MODE, true);
        activity.startActivityForResult(intent, 1);
    }

    private final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.constraint_geofence_option_inside_area), SelectableItem.r(R.string.constraint_geofence_option_outside_area)};
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        if (this.geofenceId == null) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("The configured Geofence could not be found (" + getMacro().getName() + ")", macroGuid.longValue());
            return this.allowUnknown;
        }
        GeofenceManager geofenceManager = getGeofenceManager();
        String str = this.geofenceId;
        Intrinsics.checkNotNull(str);
        int checkInsideStatus = geofenceManager.checkInsideStatus(str);
        if (checkInsideStatus != 1) {
            if (checkInsideStatus != 2) {
                return this.allowUnknown;
            }
            if (this.option != 1) {
                return false;
            }
            return true;
        } else if (this.option != 0) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void disableConstraintChecking() {
        super.disableConstraintChecking();
        String str = this.geofenceId;
        if (str != null) {
            GeofenceManager geofenceManager = getGeofenceManager();
            long siguid = getSIGUID();
            String name = getMacro().getName();
            Intrinsics.checkNotNullExpressionValue(name, "macro.name");
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            geofenceManager.removeGeofenceSubscription(str, siguid, name, macroGuid.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void enableConstraintChecking(boolean z3) {
        super.enableConstraintChecking(z3);
        String str = this.geofenceId;
        if (str != null) {
            GeofenceManager geofenceManager = getGeofenceManager();
            long siguid = getSIGUID();
            int V = V();
            String macroName = getMacroName();
            Intrinsics.checkNotNullExpressionValue(macroName, "macroName");
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            geofenceManager.addGeofenceSubscription(str, siguid, V, macroName, macroGuid.longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        if (this.geofenceName != null) {
            String str = getOptions()[this.option];
            String str2 = this.geofenceName;
            return str + ": " + str2;
        }
        String str3 = getOptions()[this.option];
        String r4 = SelectableItem.r(R.string.select_zone);
        return str3 + ": <" + r4 + ">";
    }

    @NotNull
    public final GeofenceManager getGeofenceManager() {
        GeofenceManager geofenceManager = this.geofenceManager;
        if (geofenceManager != null) {
            return geofenceManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("geofenceManager");
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return GeofenceConstraintInfo.Companion.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] getPermissions() {
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    }

    @Nullable
    public final String getZoneName() {
        return this.geofenceName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i4 == 1 && i5 == -1 && intent != null) {
            this.oldGeofenceId = this.geofenceId;
            this.geofenceId = intent.getStringExtra(GeofenceListActivity.EXTRA_SELECTED_GEOFENCE_ID);
            String geofenceName = getGeofenceManager().getGeofenceName(this.geofenceId);
            this.geofenceName = geofenceName;
            TextView textView = this.zoneNameButton;
            if (textView != null) {
                textView.setText(geofenceName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String str;
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_geofence_constraint_configure);
        appCompatDialog.setTitle(R.string.select_option);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.area_inside_option);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.area_outside_option);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.location_unknown_checkbox);
        final TextView textView = (TextView) appCompatDialog.findViewById(R.id.update_frequency_link);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.update_rate_description);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.update_rate_container);
        this.zoneNameButton = (TextView) appCompatDialog.findViewById(R.id.zone_name_button);
        boolean z3 = false;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (textView != null) {
            textView.setText(this.updateRateText);
        }
        if (textView != null) {
            textView.setPaintFlags(textView.getPaintFlags() | 8);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeofenceConstraint.W(GeofenceConstraint.this, textView, view);
            }
        });
        TextView textView3 = this.zoneNameButton;
        if (textView3 != null) {
            String str2 = this.geofenceName;
            if (!((str2 == null || str2.length() == 0) ? true : true)) {
                str = this.geofenceName;
            } else {
                str = "<" + SelectableItem.r(R.string.select_zone) + ">";
            }
            textView3.setText(str);
        }
        TextView textView4 = this.zoneNameButton;
        if (textView4 != null) {
            Intrinsics.checkNotNull(textView4);
            textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        }
        TextView textView5 = this.zoneNameButton;
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.l1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GeofenceConstraint.X(GeofenceConstraint.this, view);
                }
            });
        }
        if (this.option == 0) {
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (radioButton2 != null) {
            radioButton2.setChecked(true);
        }
        if (checkBox != null) {
            checkBox.setChecked(this.allowUnknown);
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GeofenceConstraint.Y(GeofenceConstraint.this, radioButton, checkBox, appCompatDialog, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.n1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GeofenceConstraint.Z(GeofenceConstraint.this, appCompatDialog, view);
                }
            });
        }
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.constraint.o1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GeofenceConstraint.a0(GeofenceConstraint.this, dialogInterface);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        return true;
    }

    public final void setGeofenceManager(@NotNull GeofenceManager geofenceManager) {
        Intrinsics.checkNotNullParameter(geofenceManager, "<set-?>");
        this.geofenceManager = geofenceManager;
    }

    public final void setZoneName(@NotNull String zoneName) {
        Intrinsics.checkNotNullParameter(zoneName, "zoneName");
        this.geofenceName = zoneName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeString(this.geofenceId);
        out.writeString(this.geofenceName);
        out.writeInt(this.allowUnknown ? 1 : 0);
        out.writeString(this.updateRateText);
        out.writeInt(this.updateRateMinutes);
    }

    public GeofenceConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public GeofenceConstraint() {
        this.updateRateText = SelectableItem.r(R.string.minutes_5);
        this.updateRateMinutes = 5;
        init();
    }

    private GeofenceConstraint(Parcel parcel) {
        super(parcel);
        this.updateRateText = SelectableItem.r(R.string.minutes_5);
        this.updateRateMinutes = 5;
        init();
        this.option = parcel.readInt();
        this.geofenceId = parcel.readString();
        this.geofenceName = parcel.readString();
        this.allowUnknown = parcel.readInt() != 0;
        this.updateRateText = parcel.readString();
        this.updateRateMinutes = parcel.readInt();
    }

    /* compiled from: GeofenceConstraint.kt */
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
