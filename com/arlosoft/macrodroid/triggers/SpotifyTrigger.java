package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.SpotifyTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.SpotifyReceiver;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpotifyTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SpotifyTrigger extends Trigger {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SpotifyTrigger> CREATOR;
    @NotNull
    private static final String[] OPTIONS;
    public static final int OPTION_PLAYBACK_SONG_CHANGED = 2;
    public static final int OPTION_PLAYBACK_STARTED = 0;
    public static final int OPTION_PLAYBACK_STOPPED = 1;
    @Nullable
    private static SpotifyReceiver spotifyReceiver;
    private static int triggerCount;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    static {
        String r4 = SelectableItem.r(R.string.trigger_drawer_open_close_drawer_openend);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigg…pen_close_drawer_openend)");
        String r5 = SelectableItem.r(R.string.trigger_drawer_open_close_drawer_closed);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigg…open_close_drawer_closed)");
        OPTIONS = new String[]{r4, r5};
        CREATOR = new Parcelable.Creator<SpotifyTrigger>() { // from class: com.arlosoft.macrodroid.triggers.SpotifyTrigger$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public SpotifyTrigger createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SpotifyTrigger(parcel, (DefaultConstructorMarker) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public SpotifyTrigger[] newArray(int i4) {
                return new SpotifyTrigger[i4];
            }
        };
    }

    public /* synthetic */ SpotifyTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] N() {
        String r4 = SelectableItem.r(R.string.trigger_spotify_option_playback_started);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigg…_option_playback_started)");
        String r5 = SelectableItem.r(R.string.trigger_spotify_option_playback_stopped);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigg…_option_playback_stopped)");
        String r6 = SelectableItem.r(R.string.trigger_spotify_option_song_changed);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.trigg…tify_option_song_changed)");
        return new String[]{r4, r5, r6};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(SpotifyTrigger this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.handleItemSelected();
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
            try {
                MacroDroidApplication.Companion.getInstance().unregisterReceiver(spotifyReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            spotifyReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            spotifyReceiver = new SpotifyReceiver();
            IntentFilter intentFilter = new IntentFilter(SpotifyReceiver.BroadcastTypes.PLAYBACK_STATE_CHANGED);
            intentFilter.addAction(SpotifyReceiver.BroadcastTypes.METADATA_CHANGED);
            intentFilter.addAction(SpotifyReceiver.BroadcastTypes.QUEUE_CHANGED);
            MacroDroidApplication.Companion.getInstance().registerReceiver(spotifyReceiver, intentFilter);
        }
        triggerCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getEditModeWarning() {
        if (!ApplicationChecker.isSpotifyInstalled()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String r4 = SelectableItem.r(R.string.spotify_not_installed_click_here_warning);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.spoti…alled_click_here_warning)");
            String format = String.format(r4, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return super.getEditModeWarning();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return N()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SpotifyTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + "})";
    }

    public final int getOption() {
        return this.option;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.trigger_spotify);
        builder.setMessage(R.string.trigger_spotify_must_enable_device_broadcast);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.t7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SpotifyTrigger.O(SpotifyTrigger.this, dialogInterface, i4);
            }
        });
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.spotify.music"));
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.spotify.music"));
            intent2.addFlags(268435456);
            getContext().startActivity(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return N();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public SpotifyTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SpotifyTrigger() {
    }

    private SpotifyTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: SpotifyTrigger.kt */
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
