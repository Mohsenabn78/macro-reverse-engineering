package com.arlosoft.macrodroid.logging.systemlog;

import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.database.room.LogFlag;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.databinding.ViewSystemLogEntryBinding;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

/* compiled from: SystemLogViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSystemLogViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemLogViewHolder.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,105:1\n262#2,2:106\n262#2,2:108\n262#2,2:110\n262#2,2:112\n262#2,2:114\n262#2,2:116\n*S KotlinDebug\n*F\n+ 1 SystemLogViewHolder.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogViewHolder\n*L\n56#1:106,2\n57#1:108,2\n60#1:110,2\n61#1:112,2\n65#1:114,2\n66#1:116,2\n*E\n"})
/* loaded from: classes3.dex */
public final class SystemLogViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewSystemLogEntryBinding f12713a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MacroMovementMethod f12714b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final SimpleDateFormat f12715c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final SimpleDateFormat f12716d;

    /* renamed from: e  reason: collision with root package name */
    private final DateTimeFormatter f12717e;

    /* compiled from: SystemLogViewHolder.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LogFlag.values().length];
            try {
                iArr[LogFlag.TRIGGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogFlag.ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogFlag.CONSTRAINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogFlag.LOCAL_VARIABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogFlag.GLOBAL_VARIABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LogLevel.values().length];
            try {
                iArr2[LogLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[LogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[LogLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[LogLevel.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemLogViewHolder(@NotNull ViewSystemLogEntryBinding binding, @NotNull MacroMovementMethod macroMovementMethod) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(macroMovementMethod, "macroMovementMethod");
        this.f12713a = binding;
        this.f12714b = macroMovementMethod;
        this.f12715c = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        this.f12716d = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
        this.f12717e = DateTimeFormatter.ofPattern("EEEE d MMMM y");
    }

    private final void a(SystemLogEntry systemLogEntry) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[systemLogEntry.getFlag().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4 && i4 != 5) {
                        b(systemLogEntry);
                        return;
                    }
                    ViewSystemLogEntryBinding viewSystemLogEntryBinding = this.f12713a;
                    viewSystemLogEntryBinding.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding.getRoot().getContext(), R.color.log_variable));
                    return;
                }
                ViewSystemLogEntryBinding viewSystemLogEntryBinding2 = this.f12713a;
                viewSystemLogEntryBinding2.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding2.getRoot().getContext(), R.color.log_text_action_constraint_fail));
                return;
            }
            ViewSystemLogEntryBinding viewSystemLogEntryBinding3 = this.f12713a;
            viewSystemLogEntryBinding3.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding3.getRoot().getContext(), R.color.log_text_action));
            return;
        }
        ViewSystemLogEntryBinding viewSystemLogEntryBinding4 = this.f12713a;
        viewSystemLogEntryBinding4.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding4.getRoot().getContext(), R.color.log_text_trigger));
    }

    private final void b(SystemLogEntry systemLogEntry) {
        int i4 = WhenMappings.$EnumSwitchMapping$1[systemLogEntry.getLogLevel().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        ViewSystemLogEntryBinding viewSystemLogEntryBinding = this.f12713a;
                        viewSystemLogEntryBinding.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding.getRoot().getContext(), R.color.default_text_color));
                        return;
                    }
                    ViewSystemLogEntryBinding viewSystemLogEntryBinding2 = this.f12713a;
                    viewSystemLogEntryBinding2.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding2.getRoot().getContext(), R.color.log_debug));
                    return;
                }
                ViewSystemLogEntryBinding viewSystemLogEntryBinding3 = this.f12713a;
                viewSystemLogEntryBinding3.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding3.getRoot().getContext(), R.color.log_text_error));
                return;
            }
            ViewSystemLogEntryBinding viewSystemLogEntryBinding4 = this.f12713a;
            viewSystemLogEntryBinding4.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding4.getRoot().getContext(), R.color.log_text_warning));
            return;
        }
        ViewSystemLogEntryBinding viewSystemLogEntryBinding5 = this.f12713a;
        viewSystemLogEntryBinding5.logText.setTextColor(ContextCompat.getColor(viewSystemLogEntryBinding5.getRoot().getContext(), R.color.log_detailed));
    }

    public static /* synthetic */ void bind$default(SystemLogViewHolder systemLogViewHolder, SystemLogEntry systemLogEntry, LocalDate localDate, boolean z3, float f4, boolean z4, boolean z5, int i4, Object obj) {
        boolean z6;
        if ((i4 & 2) != 0) {
            localDate = null;
        }
        LocalDate localDate2 = localDate;
        if ((i4 & 16) != 0) {
            z6 = true;
        } else {
            z6 = z4;
        }
        systemLogViewHolder.bind(systemLogEntry, localDate2, z3, f4, z6, z5);
    }

    private final String c(String str, boolean z3) {
        String str2;
        if (str.length() < 25) {
            str2 = str;
        } else {
            String substring = str.substring(0, 23);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            str2 = substring + "..";
        }
        if (!z3) {
            str2 = "<b>" + str2 + "</b>";
        }
        try {
            return "<a href=\"macrodroid://www.macrodroid.com/macro/" + URLEncoder.encode(str, "UTF-8") + "\">" + str2 + "</a>";
        } catch (Exception unused) {
            return "<a href=\"macrodroid://www.macrodroid.com/macro/" + str + "\">" + str2 + "</a>";
        }
    }

    private final String d(String str) {
        return "<a href=\"" + str + "\">" + str + "</a>";
    }

    public final void bind(@NotNull SystemLogEntry logEntry, @Nullable LocalDate localDate, boolean z3, float f4, boolean z4, boolean z5) {
        SimpleDateFormat simpleDateFormat;
        Date date;
        Intrinsics.checkNotNullParameter(logEntry, "logEntry");
        this.f12713a.timeText.setTextSize(f4 - 2);
        this.f12713a.logText.setTextSize(f4);
        TextView textView = this.f12713a.timeText;
        if (z5) {
            simpleDateFormat = this.f12716d;
            date = new Date(logEntry.getTimeStamp());
        } else {
            simpleDateFormat = this.f12715c;
            date = new Date(logEntry.getTimeStamp());
        }
        textView.setText(simpleDateFormat.format(date));
        String logText = logEntry.getLogText();
        if (logEntry.getVariableName() != null) {
            logText = logEntry.getVariableName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((Object) logText);
        }
        if (logEntry.getMacroId() != 0 && logEntry.getFlag() != LogFlag.GLOBAL_VARIABLE) {
            Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(logEntry.getMacroId());
            if (macroByGUID != null) {
                String name = macroByGUID.getName();
                Intrinsics.checkNotNullExpressionValue(name, "macro.name");
                logText = ((Object) logText) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + c(name, z4);
            }
        } else {
            String webLink = logEntry.getWebLink();
            if (webLink != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this.f12713a.getRoot().getContext().getString(R.string.system_log_please_see_link);
                Intrinsics.checkNotNullExpressionValue(string, "binding.root.context.get…stem_log_please_see_link)");
                String format = String.format(string, Arrays.copyOf(new Object[]{d(webLink)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                logText = ((Object) logText) + ". " + format;
            }
        }
        this.f12713a.logText.setText(Html.fromHtml(logText));
        this.f12713a.logText.setMovementMethod(this.f12714b);
        if (localDate != null) {
            if (z3) {
                LinearLayout linearLayout = this.f12713a.dateHeaderBottom;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.dateHeaderBottom");
                linearLayout.setVisibility(0);
                LinearLayout linearLayout2 = this.f12713a.dateHeader;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.dateHeader");
                linearLayout2.setVisibility(8);
                this.f12713a.dateTextBottom.setText(localDate.format(this.f12717e));
            } else {
                LinearLayout linearLayout3 = this.f12713a.dateHeader;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.dateHeader");
                linearLayout3.setVisibility(0);
                LinearLayout linearLayout4 = this.f12713a.dateHeaderBottom;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.dateHeaderBottom");
                linearLayout4.setVisibility(8);
                this.f12713a.dateText.setText(localDate.format(this.f12717e));
            }
        } else {
            LinearLayout linearLayout5 = this.f12713a.dateHeader;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.dateHeader");
            linearLayout5.setVisibility(8);
            LinearLayout linearLayout6 = this.f12713a.dateHeaderBottom;
            Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.dateHeaderBottom");
            linearLayout6.setVisibility(8);
        }
        a(logEntry);
    }
}
