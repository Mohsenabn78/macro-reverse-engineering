package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.PreferencesActivity;
import com.arlosoft.macrodroid.triggers.info.MediaButtonV2TriggerInfo;
import com.arlosoft.macrodroid.triggers.mediabutton.MacroDroidMediaButton;
import com.arlosoft.macrodroid.triggers.mediabutton.MediaButtonDetection;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MediaButtonV2Trigger.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMediaButtonV2Trigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaButtonV2Trigger.kt\ncom/arlosoft/macrodroid/triggers/MediaButtonV2Trigger\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,156:1\n13444#2,3:157\n*S KotlinDebug\n*F\n+ 1 MediaButtonV2Trigger.kt\ncom/arlosoft/macrodroid/triggers/MediaButtonV2Trigger\n*L\n80#1:157,3\n*E\n"})
/* loaded from: classes3.dex */
public final class MediaButtonV2Trigger extends Trigger {
    private static int triggerCount;
    @Inject
    public transient MediaButtonDetection mediaButtonDetection;
    @NotNull
    private boolean[] optionsEnabledArray;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MediaButtonV2Trigger> CREATOR = new Parcelable.Creator<MediaButtonV2Trigger>() { // from class: com.arlosoft.macrodroid.triggers.MediaButtonV2Trigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MediaButtonV2Trigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaButtonV2Trigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MediaButtonV2Trigger[] newArray(int i4) {
            return new MediaButtonV2Trigger[i4];
        }
    };

    public /* synthetic */ MediaButtonV2Trigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Activity activity, View view) {
        Intent intent = new Intent(activity, PreferencesActivity.class);
        intent.putExtra(PreferencesActivity.EXTRA_SHORTCUT, 3);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ListView listView, MediaButtonV2Trigger this$0, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(listView, "$listView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        int length = this$0.optionsEnabledArray.length;
        for (int i4 = 0; i4 < length; i4++) {
            this$0.optionsEnabledArray[i4] = checkedItemPositions.get(i4);
        }
        dialog.dismiss();
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = triggerCount - 1;
        triggerCount = i4;
        if (i4 == 0) {
            try {
                getMediaButtonDetection().stopDetectingButtons();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            getMediaButtonDetection().startDetectingButtons();
        }
        triggerCount++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        boolean z3;
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = this.optionsEnabledArray;
        int length = zArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i5 + 1;
            if (zArr[i4]) {
                sb.append(Companion.a()[i5]);
                sb.append(", ");
            }
            i4++;
            i5 = i6;
        }
        if (sb.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            String substring = sb.substring(0, sb.length() - 2);
            Intrinsics.checkNotNullExpressionValue(substring, "stringBuilder.substring(…stringBuilder.length - 2)");
            return substring;
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo mediaButtonV2TriggerInfo = MediaButtonV2TriggerInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(mediaButtonV2TriggerInfo, "getInstance()");
        return mediaButtonV2TriggerInfo;
    }

    @NotNull
    public final MediaButtonDetection getMediaButtonDetection() {
        MediaButtonDetection mediaButtonDetection = this.mediaButtonDetection;
        if (mediaButtonDetection != null) {
            return mediaButtonDetection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaButtonDetection");
        return null;
    }

    public final boolean isButtonEnabled(@NotNull MacroDroidMediaButton mediaButton) {
        Intrinsics.checkNotNullParameter(mediaButton, "mediaButton");
        return this.optionsEnabledArray[mediaButton.getId()];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    protected AlertDialog l() {
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_Trigger);
        appCompatDialog.setContentView(R.layout.dialog_media_button_v2_trigger);
        appCompatDialog.setTitle(R.string.select_option);
        View findViewById = appCompatDialog.findViewById(R.id.list);
        Intrinsics.checkNotNull(findViewById);
        final ListView listView = (ListView) findViewById;
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        View findViewById2 = appCompatDialog.findViewById(R.id.triggerOptions);
        Intrinsics.checkNotNull(findViewById2);
        TextView textView = (TextView) findViewById2;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.i5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaButtonV2Trigger.P(activity, view);
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(appCompatDialog.getContext(), (int) R.layout.multi_choice_list_item, Companion.a());
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setChoiceMode(2);
        int count = arrayAdapter.getCount();
        for (int i4 = 0; i4 < count; i4++) {
            listView.setItemChecked(i4, this.optionsEnabledArray[i4]);
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.j5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaButtonV2Trigger.Q(listView, this, appCompatDialog, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.k5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaButtonV2Trigger.R(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresNotificationAccess() {
        return true;
    }

    public final void setMediaButtonDetection(@NotNull MediaButtonDetection mediaButtonDetection) {
        Intrinsics.checkNotNullParameter(mediaButtonDetection, "<set-?>");
        this.mediaButtonDetection = mediaButtonDetection;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeBooleanArray(this.optionsEnabledArray);
    }

    public MediaButtonV2Trigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public MediaButtonV2Trigger() {
        this.optionsEnabledArray = new boolean[Companion.a().length];
        init();
    }

    private MediaButtonV2Trigger(Parcel parcel) {
        super(parcel);
        Companion companion = Companion;
        this.optionsEnabledArray = new boolean[companion.a().length];
        init();
        boolean[] zArr = new boolean[companion.a().length];
        this.optionsEnabledArray = zArr;
        parcel.readBooleanArray(zArr);
    }

    /* compiled from: MediaButtonV2Trigger.kt */
    @SourceDebugExtension({"SMAP\nMediaButtonV2Trigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaButtonV2Trigger.kt\ncom/arlosoft/macrodroid/triggers/MediaButtonV2Trigger$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,156:1\n11065#2:157\n11400#2,3:158\n37#3,2:161\n*S KotlinDebug\n*F\n+ 1 MediaButtonV2Trigger.kt\ncom/arlosoft/macrodroid/triggers/MediaButtonV2Trigger$Companion\n*L\n30#1:157\n30#1:158,3\n30#1:161,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            MacroDroidMediaButton[] values = MacroDroidMediaButton.values();
            ArrayList arrayList = new ArrayList(values.length);
            for (MacroDroidMediaButton macroDroidMediaButton : values) {
                arrayList.add(SelectableItem.r(macroDroidMediaButton.getStringRes()));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
