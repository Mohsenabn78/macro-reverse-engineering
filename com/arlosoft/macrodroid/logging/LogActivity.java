package com.arlosoft.macrodroid.logging;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.LogAction;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.EventLogging;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.LogUpdateEvent;
import com.arlosoft.macrodroid.logging.LogActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class LogActivity extends MacroDroidBaseActivity {
    public static final String ACTION_RUN_TEXT_NEW = "A: ";
    public static String EXTRA_IS_USER_LOG = "UserLog";
    public static final String TRIGGER_FIRED_TEXT_NEW = "T: ";
    @BindView(R.id.animation_view)
    LottieAnimationView emptyView;

    /* renamed from: f  reason: collision with root package name */
    private int f12657f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12658g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12659h;

    /* renamed from: i  reason: collision with root package name */
    private LogEntryAdapter f12660i;
    @BindView(R.id.infoCardDetail)
    TextView infoCardDetail;
    @BindView(R.id.infoCardGotIt)
    Button infoCardGotIt;
    @BindView(R.id.infoCardTitle)
    TextView infoCardTitle;
    @BindView(R.id.infoCardView)
    CardView infoCardView;

    /* renamed from: j  reason: collision with root package name */
    private LinkMovementMethod f12661j = new b();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.view_flipper)
    ViewFlipper viewFlipper;

    /* loaded from: classes3.dex */
    public static class LogEntryAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

        /* renamed from: a  reason: collision with root package name */
        private Context f12662a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f12663b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private int f12664c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f12665d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f12666e;

        /* renamed from: f  reason: collision with root package name */
        private LinkMovementMethod f12667f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.date_header)
            ViewGroup dateHeader;
            @BindView(R.id.date_text)
            TextView dateText;
            @BindView(R.id.log_text)
            TextView logText;
            @BindView(R.id.timestamp_text)
            TextView timeStampText;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        /* loaded from: classes3.dex */
        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: a  reason: collision with root package name */
            private ViewHolder f12669a;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f12669a = viewHolder;
                viewHolder.logText = (TextView) Utils.findRequiredViewAsType(view, R.id.log_text, "field 'logText'", TextView.class);
                viewHolder.timeStampText = (TextView) Utils.findRequiredViewAsType(view, R.id.timestamp_text, "field 'timeStampText'", TextView.class);
                viewHolder.dateHeader = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.date_header, "field 'dateHeader'", ViewGroup.class);
                viewHolder.dateText = (TextView) Utils.findRequiredViewAsType(view, R.id.date_text, "field 'dateText'", TextView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.f12669a;
                if (viewHolder != null) {
                    this.f12669a = null;
                    viewHolder.logText = null;
                    viewHolder.timeStampText = null;
                    viewHolder.dateHeader = null;
                    viewHolder.dateText = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public LogEntryAdapter(Context context, boolean z3, LinkMovementMethod linkMovementMethod) {
            this.f12662a = context;
            this.f12666e = z3;
            this.f12667f = linkMovementMethod;
        }

        private String a(boolean z3, int i4) {
            String str;
            if (z3) {
                if (i4 == 0) {
                    String str2 = this.f12663b.get(i4);
                    return str2.substring(0, Math.min(21, str2.length()));
                }
                int itemCount = getItemCount();
                while (true) {
                    int i5 = itemCount - i4;
                    if (i5 < 0) {
                        return null;
                    }
                    str = this.f12663b.get(i5);
                    if (str.contains("] - ")) {
                        break;
                    }
                    i4++;
                }
            } else {
                int i6 = 1;
                while (true) {
                    int i7 = i4 - i6;
                    if (i7 < 0) {
                        return null;
                    }
                    str = this.f12663b.get(i7);
                    if (str.contains("] - ")) {
                        break;
                    }
                    i6++;
                }
            }
            return str;
        }

        private String b(String str) {
            try {
                return "<a href=\"macrodroid://www.macrodroid.com/macro/" + URLEncoder.encode(str, "UTF-8") + "\">" + str + "</a>";
            } catch (Exception unused) {
                return "<a href=\"macrodroid://www.macrodroid.com/macro/" + str + "\">" + str + "</a>";
            }
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f12663b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        public void setLogEntries(List<String> list, boolean z3) {
            this.f12663b = list;
            this.f12665d = z3;
            notifyDataSetChanged();
        }

        public void setTextSize(int i4) {
            this.f12664c = i4;
            notifyDataSetChanged();
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0160  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBindViewHolder(com.arlosoft.macrodroid.logging.LogActivity.LogEntryAdapter.ViewHolder r13, int r14) {
            /*
                Method dump skipped, instructions count: 715
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.logging.LogActivity.LogEntryAdapter.onBindViewHolder(com.arlosoft.macrodroid.logging.LogActivity$LogEntryAdapter$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
            return new ViewHolder(LayoutInflater.from(this.f12662a).inflate(R.layout.list_item_log_entry, viewGroup, false));
        }
    }

    /* loaded from: classes3.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
            super.onScrollStateChanged(recyclerView, i4);
            LogActivity.this.f12659h = true;
        }
    }

    private void B() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.clear_log);
        builder.setMessage(R.string.are_you_sure_clear_log);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: b0.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LogActivity.this.z(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: b0.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void C(boolean z3) {
        int i4;
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            macro.setExcludeFromLog(z3);
        }
        MacroStore.getInstance().writeToJSON();
        if (z3) {
            i4 = R.string.disabled;
        } else {
            i4 = R.string.enabled;
        }
        ToastCompat.makeText(this, i4, 0).show();
    }

    private void D(boolean z3) {
        int i4;
        File file;
        File file2;
        boolean z4;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        int currentLogFile = Settings.getCurrentLogFile(this);
        if (currentLogFile == 1) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        DataInputStream dataInputStream3 = null;
        if (this.f12658g) {
            file2 = new File(getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + LogAction.LOG_FILE_NAME);
            file = null;
        } else {
            file = new File(getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + EventLogging.getLogFile(i4));
            file2 = new File(getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + EventLogging.getLogFile(currentLogFile));
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (file != null && file.exists()) {
                try {
                    dataInputStream2 = new DataInputStream(openFileInput(EventLogging.getLogFile(i4)));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            arrayList.add(readLine);
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    }
                    dataInputStream2.close();
                    z4 = true;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream3 = dataInputStream2;
                    try {
                        dataInputStream3.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } else {
                z4 = false;
            }
            if (file2.exists()) {
                if (this.f12658g) {
                    dataInputStream = new DataInputStream(MacroDroidApplication.getInstance().openFileInput(LogAction.LOG_FILE_NAME));
                } else {
                    dataInputStream = new DataInputStream(openFileInput(EventLogging.getLogFile(currentLogFile)));
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(dataInputStream));
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (Exception unused3) {
                        }
                    }
                }
                dataInputStream.close();
                z4 = true;
            }
            boolean v3 = v(this, this.f12658g);
            if (z4) {
                this.f12660i.setLogEntries(arrayList, v3);
                if (z3 && !this.f12659h) {
                    if (v3) {
                        this.recyclerView.scrollToPosition(0);
                    } else {
                        this.recyclerView.scrollToPosition(arrayList.size() - 1);
                    }
                }
                this.viewFlipper.setDisplayedChild(0);
                return;
            }
            this.viewFlipper.setDisplayedChild(1);
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to read in error log: " + e4.getMessage()));
            this.viewFlipper.setDisplayedChild(1);
        }
    }

    public static String constructUserLogOutput(Context context) {
        String readLine;
        ArrayList arrayList = new ArrayList();
        String str = context.getExternalFilesDir(null) + RemoteSettings.FORWARD_SLASH_STRING + LogAction.LOG_FILE_NAME;
        try {
            FileInputStream openFileInput = MacroDroidApplication.getInstance().openFileInput(LogAction.LOG_FILE_NAME);
            if (openFileInput == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DataInputStream(openFileInput)));
            while (true) {
                if (bufferedReader.readLine() == null) {
                    break;
                }
                arrayList.add(readLine.replace("\\\\n", "\n") + "\n");
            }
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(str)));
            if (v(context, true)) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    dataOutputStream.write(((String) arrayList.get(size)).getBytes());
                }
            } else {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    dataOutputStream.write(((String) arrayList.get(i4)).getBytes());
                }
            }
            dataOutputStream.close();
            return str;
        } catch (Exception e4) {
            if (!(e4 instanceof FileNotFoundException)) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to output user log file: " + e4.getMessage()));
            }
            return null;
        }
    }

    private void s() {
        int i4;
        int i5;
        int i6;
        if ((this.f12658g && Settings.shouldHideInfoCardUserLog(this)) || (!this.f12658g && Settings.shouldHideInfoCardSystemLog(this))) {
            this.infoCardView.setVisibility(8);
            return;
        }
        CardView cardView = this.infoCardView;
        if (this.f12658g) {
            i4 = R.color.user_log_primary;
        } else {
            i4 = R.color.system_log_primary;
        }
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, i4));
        TextView textView = this.infoCardTitle;
        if (this.f12658g) {
            i5 = R.string.user_log;
        } else {
            i5 = R.string.system_log;
        }
        textView.setText(i5);
        TextView textView2 = this.infoCardDetail;
        if (this.f12658g) {
            i6 = R.string.user_log_info_card;
        } else {
            i6 = R.string.system_log_info_card;
        }
        textView2.setText(i6);
        this.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: b0.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LogActivity.this.w(view);
            }
        });
    }

    private void t() {
        if (this.f12658g) {
            Settings.setReverseUserLog(this, !Settings.getReverseUserLog(this));
        } else {
            Settings.setReverseSystemLog(this, !Settings.getReverseSystemLog(this));
        }
        D(true);
    }

    private void u() {
        String constructSystemLogOutput;
        if (this.f12658g) {
            constructSystemLogOutput = constructUserLogOutput(this);
        } else {
            constructSystemLogOutput = EventLogging.constructSystemLogOutput(this);
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "MacroDroid Log");
            intent.putExtra("android.intent.extra.TEXT", "Here is the MacroDroid log file.");
            FileUtils.addFileStreamToIntent(this, intent, new File(constructSystemLogOutput));
            startActivity(Intent.createChooser(intent, getString(R.string.share_log)));
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.no_app_found_to_share), 0).show();
        } catch (Exception e4) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.export_failed, 0).show();
            SystemLog.logError("Failed to export file: " + e4.toString());
        }
    }

    private static boolean v(Context context, boolean z3) {
        if (z3) {
            return Settings.getReverseUserLog(context);
        }
        return Settings.getReverseSystemLog(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        if (this.f12658g) {
            Settings.hideInfoCardUserLog(getApplicationContext());
        } else {
            Settings.hideInfoCardSystemLog(getApplicationContext());
        }
        this.infoCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ColorFilter x(LottieFrameInfo lottieFrameInfo) {
        return new PorterDuffColorFilter(ContextCompat.getColor(this, R.color.white_transparent), PorterDuff.Mode.SRC_ATOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean y(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_large /* 2131363403 */:
                this.f12657f = 14;
                break;
            case R.id.menu_medium /* 2131363411 */:
                this.f12657f = 12;
                break;
            case R.id.menu_small /* 2131363436 */:
                this.f12657f = 10;
                break;
            case R.id.menu_very_large /* 2131363447 */:
                this.f12657f = 16;
                break;
        }
        this.f12660i.setTextSize(this.f12657f);
        if (this.f12658g) {
            Settings.setUserLogTextSize(this, this.f12657f);
            return true;
        }
        Settings.setLogTextSize(this, this.f12657f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(DialogInterface dialogInterface, int i4) {
        try {
            if (this.f12658g) {
                new File(getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + LogAction.LOG_FILE_NAME).delete();
            } else {
                File file = new File(getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + EventLogging.getLogFile(1));
                File file2 = new File(getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + EventLogging.getLogFile(2));
                file.delete();
                file2.delete();
            }
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Log file deletion failed: " + e4.getMessage()));
            Util.displayNotification(this, "Clear Log Failed", "The log file could not be cleared", false);
        }
        this.f12660i.setLogEntries(new ArrayList(), true);
        this.viewFlipper.setDisplayedChild(1);
        dialogInterface.dismiss();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int logTextSize;
        int i4;
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_IS_USER_LOG, false);
        this.f12658g = booleanExtra;
        if (booleanExtra) {
            setTheme(R.style.Theme_App_UserLogs);
        }
        super.onCreate(bundle);
        setContentView(R.layout.event_log);
        ButterKnife.bind(this);
        if (this.f12658g) {
            logTextSize = Settings.getUserLogTextSize(this);
        } else {
            logTextSize = Settings.getLogTextSize(this);
        }
        this.f12657f = logTextSize;
        if (this.f12658g) {
            i4 = R.string.user_log;
        } else {
            i4 = R.string.system_log;
        }
        setTitle(i4);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LogEntryAdapter logEntryAdapter = new LogEntryAdapter(this, this.f12658g, this.f12661j);
        this.f12660i = logEntryAdapter;
        logEntryAdapter.setTextSize(this.f12657f);
        this.recyclerView.setAdapter(this.f12660i);
        D(true);
        EventBusUtils.getEventBus().register(this);
        s();
        if (getResources().getBoolean(R.bool.is_night_mode)) {
            this.emptyView.addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback() { // from class: b0.a
                @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                    ColorFilter x3;
                    x3 = LogActivity.this.x(lottieFrameInfo);
                    return x3;
                }
            });
        }
        this.recyclerView.addOnScrollListener(new a());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        int i4;
        getMenuInflater().inflate(R.menu.log_menu, menu);
        MenuItem findItem = menu.findItem(R.id.menu_log_triggers);
        MenuItem findItem2 = menu.findItem(R.id.menu_log_actions);
        MenuItem findItem3 = menu.findItem(R.id.menu_log_constraints);
        MenuItem findItem4 = menu.findItem(R.id.menu_date_layout);
        MenuItem findItem5 = menu.findItem(R.id.menu_toggle_macro_logging);
        findItem4.setVisible(false);
        if (this.f12658g) {
            findItem.setVisible(false);
            findItem2.setVisible(false);
            findItem3.setVisible(false);
            findItem5.setVisible(false);
            return true;
        }
        findItem.setChecked(Settings.getTriggerLoggingEnabled(this));
        findItem2.setChecked(Settings.getActionLoggingEnabled(this));
        findItem3.setChecked(Settings.getConstraintLoggingEnabled(this));
        if (Settings.getMenuItemMacroLoggingIsDisable(this)) {
            i4 = R.string.disable_logging_in_all_macros;
        } else {
            i4 = R.string.enable_logging_in_all_macros;
        }
        findItem5.setTitle(i4);
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBusUtils.getEventBus().unregister(this);
        super.onDestroy();
    }

    public void onEventMainThread(LogUpdateEvent logUpdateEvent) {
        D(true);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i4;
        boolean z6 = false;
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            case R.id.menu_clear_log /* 2131363380 */:
                B();
                return true;
            case R.id.menu_date_layout /* 2131363386 */:
                boolean z7 = !Settings.getUserLogDateLayoutEnabled(this);
                Settings.setUserLogDateLayoutEnabled(this, z7);
                menuItem.setChecked(z7);
                D(false);
                return true;
            case R.id.menu_log_actions /* 2131363408 */:
                boolean z8 = !Settings.getActionLoggingEnabled(this);
                Settings.setActionLoggingEnabled(this, z8);
                menuItem.setChecked(z8);
                return true;
            case R.id.menu_log_constraints /* 2131363409 */:
                boolean z9 = !Settings.getConstraintLoggingEnabled(this);
                Settings.setConstraintLoggingEnabled(this, z9);
                menuItem.setChecked(z9);
                return true;
            case R.id.menu_log_triggers /* 2131363410 */:
                boolean z10 = !Settings.getTriggerLoggingEnabled(this);
                Settings.setTriggerLoggingEnabled(this, z10);
                menuItem.setChecked(z10);
                return true;
            case R.id.menu_reorder /* 2131363417 */:
                t();
                return true;
            case R.id.menu_share_log /* 2131363429 */:
                u();
                return true;
            case R.id.menu_text_size /* 2131363440 */:
                PopupMenu popupMenu = new PopupMenu(this, findViewById(R.id.menu_share_log));
                popupMenu.inflate(R.menu.text_size_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: b0.b
                    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem2) {
                        boolean y3;
                        y3 = LogActivity.this.y(menuItem2);
                        return y3;
                    }
                });
                popupMenu.show();
                MenuItem findItem = popupMenu.getMenu().findItem(R.id.menu_small);
                if (this.f12657f == 10) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                findItem.setChecked(z3);
                MenuItem findItem2 = popupMenu.getMenu().findItem(R.id.menu_medium);
                if (this.f12657f == 12) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                findItem2.setChecked(z4);
                MenuItem findItem3 = popupMenu.getMenu().findItem(R.id.menu_large);
                if (this.f12657f == 14) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                findItem3.setChecked(z5);
                MenuItem findItem4 = popupMenu.getMenu().findItem(R.id.menu_very_large);
                if (this.f12657f == 16) {
                    z6 = true;
                }
                findItem4.setChecked(z6);
                return true;
            case R.id.menu_toggle_macro_logging /* 2131363442 */:
                boolean menuItemMacroLoggingIsDisable = Settings.getMenuItemMacroLoggingIsDisable(this);
                C(menuItemMacroLoggingIsDisable);
                Settings.setMenuItemMacroLoggingIsDisable(this, !menuItemMacroLoggingIsDisable);
                if (Settings.getMenuItemMacroLoggingIsDisable(this)) {
                    i4 = R.string.disable_logging_in_all_macros;
                } else {
                    i4 = R.string.enable_logging_in_all_macros;
                }
                menuItem.setTitle(i4);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* loaded from: classes3.dex */
    class b extends LinkMovementMethod {
        b() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            Category categoryByName;
            int x3 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y3 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x3 + textView.getScrollX();
            int scrollY = y3 + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, URLSpan.class);
            if (uRLSpanArr.length > 0) {
                Uri parse = Uri.parse(uRLSpanArr[0].getURL());
                String lastPathSegment = parse.getLastPathSegment();
                try {
                    lastPathSegment = URLDecoder.decode(lastPathSegment);
                } catch (Exception unused) {
                }
                Macro macroByName = MacroStore.getInstance().getMacroByName(lastPathSegment);
                if (macroByName != null) {
                    String category = macroByName.getCategory();
                    Cache cache = MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE);
                    CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
                    if (categoryList != null && (categoryByName = categoryList.getCategoryByName(category)) != null && categoryByName.isLocked()) {
                        if (motionEvent.getAction() != 1) {
                            CategoryPasswordHelper categoryPasswordHelper = new CategoryPasswordHelper(cache, null);
                            LogActivity logActivity = LogActivity.this;
                            categoryPasswordHelper.promptForCategoryPassword(logActivity, logActivity.getString(R.string.enter_category_lock_password), category, Settings.getLockedCategoryPassword(LogActivity.this), 0, new a(parse));
                        }
                        return false;
                    }
                }
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }

        /* loaded from: classes3.dex */
        class a implements CategoryPasswordHelper.PasswordListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Uri f12672a;

            a(Uri uri) {
                this.f12672a = uri;
            }

            @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
            public void passwordCorrect() {
                LogActivity.this.startActivity(new Intent("android.intent.action.VIEW", this.f12672a));
            }

            @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
            public void passwordCancelled() {
            }
        }
    }
}
