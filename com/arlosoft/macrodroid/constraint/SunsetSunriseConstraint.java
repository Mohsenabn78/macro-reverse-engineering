package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.SunsetSunriseConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.activities.LocationChooserActivity;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.luckycatlabs.sunrisesunset.dto.Location;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SunsetSunriseConstraint.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSunsetSunriseConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunsetSunriseConstraint.kt\ncom/arlosoft/macrodroid/constraint/SunsetSunriseConstraint\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,170:1\n731#2,9:171\n37#3,2:180\n*S KotlinDebug\n*F\n+ 1 SunsetSunriseConstraint.kt\ncom/arlosoft/macrodroid/constraint/SunsetSunriseConstraint\n*L\n71#1:171,9\n71#1:180,2\n*E\n"})
/* loaded from: classes3.dex */
public final class SunsetSunriseConstraint extends Constraint {
    private static final int OPTION_AFTER_SUNRISE = 1;
    private static final int OPTION_AFTER_SUNSET = 3;
    private static final int OPTION_BEFORE_SUNRISE = 0;
    private static final int OPTION_BEFORE_SUNSET = 2;
    private static final int SET_LOCATION = 1;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SunsetSunriseConstraint> CREATOR = new Parcelable.Creator<SunsetSunriseConstraint>() { // from class: com.arlosoft.macrodroid.constraint.SunsetSunriseConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SunsetSunriseConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SunsetSunriseConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SunsetSunriseConstraint[] newArray(int i4) {
            return new SunsetSunriseConstraint[i4];
        }
    };

    public /* synthetic */ SunsetSunriseConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void P(final Activity activity) {
        Intrinsics.checkNotNull(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(R.string.trigger_weather_set_location);
        builder.setMessage(R.string.trigger_sunrise_sunset_location_set_message).setCancelable(true).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.i4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SunsetSunriseConstraint.Q(activity, this, dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Activity activity, SunsetSunriseConstraint this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            activity.startActivityForResult(new Intent(activity, LocationChooserActivity.class), 1);
        } catch (NoClassDefFoundError unused) {
            ToastCompat.makeText(this$0.getContext().getApplicationContext(), (CharSequence) this$0.getContext().getString(R.string.toast_broken_map_activity), 0).show();
        }
        dialogInterface.dismiss();
    }

    private final String[] getOptions() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String r4 = SelectableItem.r(R.string.before_sunrise_option);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.before_sunrise_option)");
        String format = String.format(r4, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String r5 = SelectableItem.r(R.string.after_sunrise_option);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.after_sunrise_option)");
        String format2 = String.format(r5, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        String r6 = SelectableItem.r(R.string.before_sunset_option);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.before_sunset_option)");
        String format3 = String.format(r6, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        String r7 = SelectableItem.r(R.string.after_sunset_option);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.after_sunset_option)");
        String format4 = String.format(r7, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
        return new String[]{format, format2, format3, format4};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        List emptyList;
        boolean z3;
        String locationString = Settings.getSunriseSunsetLatLon(getContext());
        if (TextUtils.isEmpty(locationString)) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Failed to evaluate sunset/sunrise constraint - no location set", macroGuid.longValue());
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(locationString, "locationString");
        List<String> split = new Regex(",").split(locationString, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (!z3) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        String[] strArr = (String[]) emptyList.toArray(new String[0]);
        Double lat = Double.valueOf(strArr[0]);
        Double lon = Double.valueOf(strArr[1]);
        Intrinsics.checkNotNullExpressionValue(lat, "lat");
        double doubleValue = lat.doubleValue();
        Intrinsics.checkNotNullExpressionValue(lon, "lon");
        SunriseSunsetCalculator sunriseSunsetCalculator = new SunriseSunsetCalculator(new Location(doubleValue, lon.doubleValue()), TimeZone.getDefault());
        Calendar calendar = Calendar.getInstance();
        int i4 = this.option;
        if (i4 != 0 && i4 != 1) {
            boolean before = calendar.before(sunriseSunsetCalculator.getOfficialSunsetCalendarForDate(calendar));
            if (this.option == 2) {
                return before;
            }
            if (before) {
                return false;
            }
            return true;
        }
        boolean before2 = calendar.before(sunriseSunsetCalculator.getOfficialSunriseCalendarForDate(calendar));
        if (this.option == 0) {
            return before2;
        }
        if (before2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        return getOptions()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SunsetSunriseConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i4 == 1 && i5 == -1 && intent != null) {
            double doubleExtra = intent.getDoubleExtra(LocationTrigger.LATITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double doubleExtra2 = intent.getDoubleExtra(LocationTrigger.LONGITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            Context context = getContext();
            Settings.setSunriseSunsetLatLon(context, doubleExtra + "," + doubleExtra2);
            super.itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        boolean z3;
        String sunriseSunsetLatLon = Settings.getSunriseSunsetLatLon(getContext());
        Intrinsics.checkNotNullExpressionValue(sunriseSunsetLatLon, "getSunriseSunsetLatLon(context)");
        if (sunriseSunsetLatLon.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            P(getActivity());
        } else {
            super.itemComplete();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public SunsetSunriseConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SunsetSunriseConstraint() {
    }

    private SunsetSunriseConstraint(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: SunsetSunriseConstraint.kt */
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
