package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.SleepTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.SleepReceiver;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.innovattic.rangeseekbar.RangeSeekBar;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SleepTrigger.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSleepTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SleepTrigger.kt\ncom/arlosoft/macrodroid/triggers/SleepTrigger\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,222:1\n26#2:223\n*S KotlinDebug\n*F\n+ 1 SleepTrigger.kt\ncom/arlosoft/macrodroid/triggers/SleepTrigger\n*L\n207#1:223\n*E\n"})
/* loaded from: classes3.dex */
public final class SleepTrigger extends Trigger {
    private static final int OPTION_FALL_ASLEEP = 0;
    private static final int OPTION_WAKE_UP = 1;
    @Nullable
    private static PendingIntent pendingIntent;
    private static int triggerCount;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SleepTrigger> CREATOR = new Parcelable.Creator<SleepTrigger>() { // from class: com.arlosoft.macrodroid.triggers.SleepTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SleepTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SleepTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SleepTrigger[] newArray(int i4) {
            return new SleepTrigger[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SleepTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Void, Unit> {
        a() {
            super(1);
        }

        public final void a(Void r12) {
            SystemLog.logVerbose("Sleep tracking enabled");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SleepTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Void, Unit> {
        b() {
            super(1);
        }

        public final void a(Void r12) {
            SystemLog.logDebug("Sleep tracking disabled.");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ SleepTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final boolean S() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACTIVITY_RECOGNITION") == 0) {
            return true;
        }
        return false;
    }

    private final void T() {
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_sleep_tracking_confidence);
        appCompatDialog.setTitle(getOptions()[this.option]);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        final RangeSeekBar rangeSeekBar = (RangeSeekBar) appCompatDialog.findViewById(R.id.rangeSeekBar);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final TextView textView = (TextView) appCompatDialog.findViewById(R.id.awakeThresholdValue);
        final TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.asleepThresholdValue);
        int sleepWakeUpThreshold = Settings.getSleepWakeUpThreshold(getContext());
        int sleepFallAsleepThreshold = Settings.getSleepFallAsleepThreshold(getContext());
        if (rangeSeekBar != null) {
            rangeSeekBar.setMinThumbValue(sleepWakeUpThreshold);
        }
        if (rangeSeekBar != null) {
            rangeSeekBar.setMaxThumbValue(sleepFallAsleepThreshold);
        }
        if (textView != null) {
            textView.setText(String.valueOf(sleepWakeUpThreshold));
        }
        if (textView2 != null) {
            textView2.setText(String.valueOf(sleepFallAsleepThreshold));
        }
        if (rangeSeekBar != null) {
            rangeSeekBar.setSeekBarChangeListener(new RangeSeekBar.SeekBarChangeListener() { // from class: com.arlosoft.macrodroid.triggers.SleepTrigger$displayConfidenceDialog$1
                @Override // com.innovattic.rangeseekbar.RangeSeekBar.SeekBarChangeListener
                public void onValueChanged(int i4, int i5) {
                    TextView textView3 = textView;
                    if (textView3 != null) {
                        textView3.setText(String.valueOf(i4));
                    }
                    TextView textView4 = textView2;
                    if (textView4 != null) {
                        textView4.setText(String.valueOf(i5));
                    }
                }

                @Override // com.innovattic.rangeseekbar.RangeSeekBar.SeekBarChangeListener
                public void onStartedSeeking() {
                }

                @Override // com.innovattic.rangeseekbar.RangeSeekBar.SeekBarChangeListener
                public void onStoppedSeeking() {
                }
            });
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.r7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SleepTrigger.U(AppCompatDialog.this, this, rangeSeekBar, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.s7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SleepTrigger.V(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AppCompatDialog dialog, SleepTrigger this$0, RangeSeekBar rangeSeekBar, View view) {
        int i4;
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        Context context = this$0.getContext();
        int i5 = 0;
        if (rangeSeekBar != null) {
            i4 = rangeSeekBar.getMinThumbValue();
        } else {
            i4 = 0;
        }
        Settings.setSleepWakeUpThreshold(context, i4);
        Context context2 = this$0.getContext();
        if (rangeSeekBar != null) {
            i5 = rangeSeekBar.getMaxThumbValue();
        }
        Settings.setSleepFallAsleepThreshold(context2, i5);
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    private final void W(PendingIntent pendingIntent2) {
        if (S()) {
            Task<Void> requestSleepSegmentUpdates = ActivityRecognition.getClient(getContext()).requestSleepSegmentUpdates(pendingIntent2, SleepSegmentRequest.getDefaultSleepSegmentRequest());
            Intrinsics.checkNotNullExpressionValue(requestSleepSegmentUpdates, "getClient(context).reque…quest()\n                )");
            final a aVar = new a();
            requestSleepSegmentUpdates.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.triggers.p7
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    SleepTrigger.X(Function1.this, obj);
                }
            });
            requestSleepSegmentUpdates.addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.triggers.q7
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    SleepTrigger.Y(SleepTrigger.this, exc);
                }
            });
            return;
        }
        SystemLog.logError("Cannot subscribe to sleep data, activity recognition permission has not been granted");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(SleepTrigger this$0, Exception exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(exception, "exception");
        SystemLog.logVerbose("Failed to subscribe to sleep sleep data: " + exception);
    }

    private final void Z(PendingIntent pendingIntent2) {
        try {
            Task<Void> removeSleepSegmentUpdates = ActivityRecognition.getClient(getContext()).removeSleepSegmentUpdates(pendingIntent2);
            Intrinsics.checkNotNullExpressionValue(removeSleepSegmentUpdates, "getClient(context).remov…entUpdates(pendingIntent)");
            final b bVar = new b();
            removeSleepSegmentUpdates.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.triggers.n7
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    SleepTrigger.a0(Function1.this, obj);
                }
            });
            removeSleepSegmentUpdates.addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.triggers.o7
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    SleepTrigger.b0(exc);
                }
            });
        } catch (Exception e4) {
            SystemLog.logError("Exception when unsubscribing to sleep data: " + e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        SystemLog.logError("Exception when unsubscribing to sleep data: " + exception);
    }

    private final String[] getOptions() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String r4 = SelectableItem.r(R.string.trigger_sleep_fell_asleep);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigger_sleep_fell_asleep)");
        String format = String.format(r4, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String r5 = SelectableItem.r(R.string.trigger_sleep_woke_up);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigger_sleep_woke_up)");
        String format2 = String.format(r5, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return new String[]{format, format2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = triggerCount - 1;
        triggerCount = i4;
        if (i4 == 0) {
            PendingIntent pendingIntent2 = pendingIntent;
            if (pendingIntent2 != null) {
                Z(pendingIntent2);
            }
            pendingIntent = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            SleepReceiver.Companion companion = SleepReceiver.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            PendingIntent createSleepReceiverPendingIntent = companion.createSleepReceiverPendingIntent(context);
            pendingIntent = createSleepReceiverPendingIntent;
            Intrinsics.checkNotNull(createSleepReceiverPendingIntent);
            W(createSleepReceiverPendingIntent);
        }
        triggerCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return getOptions()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SleepTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String extendedDetail = getExtendedDetail();
        return name + " (" + extendedDetail + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 29) {
            return new String[]{"android.permission.ACTIVITY_RECOGNITION"};
        }
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        T();
    }

    public final boolean triggerOnAwake() {
        if (this.option == 1) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public SleepTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SleepTrigger() {
    }

    private SleepTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: SleepTrigger.kt */
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
