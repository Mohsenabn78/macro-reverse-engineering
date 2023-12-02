package com.arlosoft.macrodroid.logcat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityLogcatMessageSelectBinding;
import com.arlosoft.macrodroid.logcat.LogcatMessageAdapter;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.LogcatTrigger;
import com.arlosoft.macrodroid.triggers.activities.LogcatConfigActivity;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogcatMessageSelectActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LogcatMessageSelectActivity extends MacroDroidDaggerBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private ActivityLogcatMessageSelectBinding f12647f;

    /* renamed from: g  reason: collision with root package name */
    private LogcatMessageAdapter f12648g;

    /* renamed from: h  reason: collision with root package name */
    private Macro f12649h;

    /* renamed from: i  reason: collision with root package name */
    private LogcatTrigger f12650i;

    /* renamed from: j  reason: collision with root package name */
    private int f12651j;
    @Inject
    public LogcatMessageRepository logcatMessageRepository;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: LogcatMessageSelectActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void createInstance(@NotNull Context context, @NotNull Macro macro, @NotNull LogcatTrigger trigger, int i4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(macro, "macro");
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            Intent intent = new Intent(context, LogcatMessageSelectActivity.class);
            intent.putExtra("trigger", trigger);
            intent.putExtra("Macro", macro);
            intent.putExtra("enabled_buffers", i4);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBackPressed() {
        Macro macro;
        LogcatTrigger logcatTrigger;
        getLogcatMessageRepository().clearMessageList();
        finish();
        LogcatConfigActivity.Companion companion = LogcatConfigActivity.Companion;
        Macro macro2 = this.f12649h;
        if (macro2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        } else {
            macro = macro2;
        }
        LogcatTrigger logcatTrigger2 = this.f12650i;
        if (logcatTrigger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trigger");
            logcatTrigger = null;
        } else {
            logcatTrigger = logcatTrigger2;
        }
        companion.launchActivity(this, macro, logcatTrigger, null, this.f12651j, true);
    }

    @NotNull
    public final LogcatMessageRepository getLogcatMessageRepository() {
        LogcatMessageRepository logcatMessageRepository = this.logcatMessageRepository;
        if (logcatMessageRepository != null) {
            return logcatMessageRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logcatMessageRepository");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityLogcatMessageSelectBinding inflate = ActivityLogcatMessageSelectBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12647f = inflate;
        LogcatMessageAdapter logcatMessageAdapter = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        List<LogcatMessage> logcatMessageList = getLogcatMessageRepository().getLogcatMessageList();
        Parcelable parcelableExtra = getIntent().getParcelableExtra("trigger");
        Intrinsics.checkNotNull(parcelableExtra);
        this.f12650i = (LogcatTrigger) parcelableExtra;
        Parcelable parcelableExtra2 = getIntent().getParcelableExtra("Macro");
        Intrinsics.checkNotNull(parcelableExtra2);
        this.f12649h = (Macro) parcelableExtra2;
        this.f12651j = getIntent().getIntExtra("enabled_buffers", 0);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.logcat.LogcatMessageSelectActivity$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                LogcatMessageSelectActivity.this.handleBackPressed();
            }
        });
        this.f12648g = new LogcatMessageAdapter(logcatMessageList, new LogcatMessageAdapter.LogcatMessageClickListener() { // from class: com.arlosoft.macrodroid.logcat.LogcatMessageSelectActivity$onCreate$2
            @Override // com.arlosoft.macrodroid.logcat.LogcatMessageAdapter.LogcatMessageClickListener
            public void onLogcatMessageClicked(@NotNull LogcatMessage logcatMessage) {
                Macro macro;
                LogcatTrigger logcatTrigger;
                int i4;
                Intrinsics.checkNotNullParameter(logcatMessage, "logcatMessage");
                LogcatMessageSelectActivity.this.getLogcatMessageRepository().clearMessageList();
                LogcatMessageSelectActivity.this.finish();
                LogcatConfigActivity.Companion companion = LogcatConfigActivity.Companion;
                LogcatMessageSelectActivity logcatMessageSelectActivity = LogcatMessageSelectActivity.this;
                macro = logcatMessageSelectActivity.f12649h;
                if (macro == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro = null;
                }
                logcatTrigger = LogcatMessageSelectActivity.this.f12650i;
                if (logcatTrigger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("trigger");
                    logcatTrigger = null;
                }
                i4 = LogcatMessageSelectActivity.this.f12651j;
                companion.launchActivity(logcatMessageSelectActivity, macro, logcatTrigger, logcatMessage, i4, true);
            }
        });
        ActivityLogcatMessageSelectBinding activityLogcatMessageSelectBinding = this.f12647f;
        if (activityLogcatMessageSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLogcatMessageSelectBinding = null;
        }
        RecyclerView recyclerView = activityLogcatMessageSelectBinding.recyclerView;
        LogcatMessageAdapter logcatMessageAdapter2 = this.f12648g;
        if (logcatMessageAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            logcatMessageAdapter = logcatMessageAdapter2;
        }
        recyclerView.setAdapter(logcatMessageAdapter);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.logcat_select_menu, menu);
        View actionView = menu.findItem(R.id.menu_search).getActionView();
        Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        SearchView searchView = (SearchView) actionView;
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.logcat.LogcatMessageSelectActivity$onCreateOptionsMenu$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@NotNull String newText) {
                LogcatMessageAdapter logcatMessageAdapter;
                Intrinsics.checkNotNullParameter(newText, "newText");
                logcatMessageAdapter = LogcatMessageSelectActivity.this.f12648g;
                if (logcatMessageAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    logcatMessageAdapter = null;
                }
                logcatMessageAdapter.getFilter().filter(newText);
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@NotNull String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return false;
            }
        });
        return true;
    }

    public final void setLogcatMessageRepository(@NotNull LogcatMessageRepository logcatMessageRepository) {
        Intrinsics.checkNotNullParameter(logcatMessageRepository, "<set-?>");
        this.logcatMessageRepository = logcatMessageRepository;
    }
}
