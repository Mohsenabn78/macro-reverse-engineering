package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.EventLogging;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.m;
import org.apache.commons.io.input.ReversedLinesFileReader;
import org.jetbrains.annotations.NotNull;

/* compiled from: SystemLogTile.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSystemLogTile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemLogTile.kt\ncom/arlosoft/macrodroid/homescreen/tiles/SystemLogTile\n+ 2 CustomServices.kt\norg/jetbrains/anko/CustomServicesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n26#2:66\n1#3:67\n*S KotlinDebug\n*F\n+ 1 SystemLogTile.kt\ncom/arlosoft/macrodroid/homescreen/tiles/SystemLogTile\n*L\n26#1:66\n*E\n"})
/* loaded from: classes3.dex */
public final class SystemLogTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12533c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12534d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12535e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12536f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12537g;

    public SystemLogTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12533c = activity;
        String string = activity.getString(R.string.system_log);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.system_log)");
        this.f12534d = string;
        this.f12535e = R.drawable.ic_text_box;
        this.f12536f = 11L;
        this.f12537g = ContextCompat.getColor(activity, R.color.system_log_primary);
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12533c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12537g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12535e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12536f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12534d;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.f12533c.startActivity(new Intent(this.f12533c, SystemLogActivity.class));
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void setCustomViewContents(@NotNull FrameLayout view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            ((LayoutInflater) systemService).inflate(R.layout.home_tile_custom_log, (ViewGroup) view, true);
            ((TextView) view.findViewById(R.id.logText)).setText(updateLogText());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public final String updateLogText() {
        String replace$default;
        int indexOf$default;
        int currentLogFile = Settings.getCurrentLogFile(this.f12533c);
        try {
            File filesDir = this.f12533c.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(filesDir, "activity.getFilesDir()");
            String file = filesDir.toString();
            String logFile = EventLogging.getLogFile(currentLogFile);
            File file2 = new File(file + RemoteSettings.FORWARD_SLASH_STRING + logFile);
            StringBuilder sb = new StringBuilder();
            if (file2.exists()) {
                ReversedLinesFileReader reversedLinesFileReader = new ReversedLinesFileReader(file2, 4096, "utf-8");
                int i4 = 0;
                while (true) {
                    String it = reversedLinesFileReader.readLine();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it == null || i4 >= 10) {
                        break;
                    }
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) it, "] - ", 0, false, 6, (Object) null);
                    if (indexOf$default != -1) {
                        String substring = it.substring(indexOf$default + 4);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        sb.append(substring);
                        sb.append("\n");
                    } else {
                        sb.append(it);
                        sb.append("\n");
                    }
                    i4++;
                }
            }
            if (sb.length() > 0) {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
                replace$default = m.replace$default(sb2, "\\n", "\n", false, 4, (Object) null);
                return replace$default;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
