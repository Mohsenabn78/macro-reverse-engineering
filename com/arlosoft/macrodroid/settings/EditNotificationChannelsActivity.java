package com.arlosoft.macrodroid.settings;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.MessageDialogAction;
import com.arlosoft.macrodroid.action.NotificationAction;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityEditNotificationChannelsBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.notification.NotificationChannel;
import com.arlosoft.macrodroid.notification.NotificationChannelList;
import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EditNotificationChannelsActivity.kt */
@StabilityInferred(parameters = 0)
@RequiresApi(26)
/* loaded from: classes3.dex */
public final class EditNotificationChannelsActivity extends MacroDroidDaggerBaseActivity implements com.arlosoft.macrodroid.settings.a {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private ActivityEditNotificationChannelsBinding f13425f;

    /* renamed from: g  reason: collision with root package name */
    private NotificationChannelList f13426g;
    @Inject
    public NotificationChannelUtil notificationChannelUtil;

    /* compiled from: EditNotificationChannelsActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditNotificationChannelsActivity.t(EditNotificationChannelsActivity.this, null, 1, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void p(boolean z3) {
        ActivityEditNotificationChannelsBinding activityEditNotificationChannelsBinding = null;
        if (z3) {
            ActivityEditNotificationChannelsBinding activityEditNotificationChannelsBinding2 = this.f13425f;
            if (activityEditNotificationChannelsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditNotificationChannelsBinding2 = null;
            }
            activityEditNotificationChannelsBinding2.emptyView.setVisibility(0);
            ActivityEditNotificationChannelsBinding activityEditNotificationChannelsBinding3 = this.f13425f;
            if (activityEditNotificationChannelsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityEditNotificationChannelsBinding = activityEditNotificationChannelsBinding3;
            }
            activityEditNotificationChannelsBinding.recyclerView.setVisibility(8);
            return;
        }
        ActivityEditNotificationChannelsBinding activityEditNotificationChannelsBinding4 = this.f13425f;
        if (activityEditNotificationChannelsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditNotificationChannelsBinding4 = null;
        }
        activityEditNotificationChannelsBinding4.emptyView.setVisibility(8);
        ActivityEditNotificationChannelsBinding activityEditNotificationChannelsBinding5 = this.f13425f;
        if (activityEditNotificationChannelsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityEditNotificationChannelsBinding = activityEditNotificationChannelsBinding5;
        }
        activityEditNotificationChannelsBinding.recyclerView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String[] options, EditNotificationChannelsActivity this$0, NotificationChannel notificationChannel, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(notificationChannel, "$notificationChannel");
        if (Intrinsics.areEqual(options[i4], this$0.getString(R.string.edit))) {
            this$0.s(notificationChannel);
        } else if (Intrinsics.areEqual(options[i4], this$0.getString(R.string.delete))) {
            this$0.getNotificationChannelUtil().deleteNotificationChannel(notificationChannel.getChannelName());
            this$0.refresh();
        }
    }

    private final void r(String str, String str2) {
        boolean z3 = false;
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            Iterator<Action> it = macro.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if ((next instanceof NotificationAction) && !(next instanceof MessageDialogAction)) {
                    if (!z3 && !((NotificationAction) next).setNotificationChannelRenamed(str, str2)) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                }
            }
        }
        if (z3) {
            MacroStore.getInstance().writeToJSON();
        }
    }

    private final void refresh() {
        this.f13426g = getNotificationChannelUtil().getNotificationChannelList();
        ActivityEditNotificationChannelsBinding activityEditNotificationChannelsBinding = this.f13425f;
        NotificationChannelList notificationChannelList = null;
        if (activityEditNotificationChannelsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditNotificationChannelsBinding = null;
        }
        RecyclerView recyclerView = activityEditNotificationChannelsBinding.recyclerView;
        NotificationChannelList notificationChannelList2 = this.f13426g;
        if (notificationChannelList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationChannelList");
            notificationChannelList2 = null;
        }
        recyclerView.setAdapter(new v(notificationChannelList2, this));
        NotificationChannelList notificationChannelList3 = this.f13426g;
        if (notificationChannelList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationChannelList");
        } else {
            notificationChannelList = notificationChannelList3;
        }
        p(notificationChannelList.getNotificationChannels().isEmpty());
    }

    private final void s(final NotificationChannel notificationChannel) {
        boolean z3;
        List list;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this);
        appCompatDialog.setContentView(R.layout.notification_channel_dialog);
        appCompatDialog.setTitle(R.string.notification_channel);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        View findViewById = appCompatDialog.findViewById(R.id.noticationChannel);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.prioritySpinner);
        editText.setHint(R.string.trigger_cell_tower_enter_group_name_hint);
        final int[] intArray = getResources().getIntArray(R.array.notification_priority_values_int);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…tion_priority_values_int)");
        if (notificationChannel != null) {
            editText.setText(notificationChannel.getChannelName());
            ViewExtensionsKt.setCursorAtEnd(editText);
            list = ArraysKt___ArraysKt.toList(intArray);
            int indexOf = list.indexOf(Integer.valueOf(notificationChannel.getPriority()));
            if (spinner != null) {
                spinner.setSelection(indexOf);
            }
        } else if (spinner != null) {
            spinner.setSelection(2);
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.settings.EditNotificationChannelsActivity$showEditChannelDialog$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                boolean z4;
                Intrinsics.checkNotNullParameter(s3, "s");
                Button button3 = button;
                if (button3 != null) {
                    if (editText.getText().length() > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    button3.setEnabled(z4);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }
        });
        if (button != null) {
            if (editText.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditNotificationChannelsActivity.u(editText, notificationChannel, this, spinner, intArray, appCompatDialog, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditNotificationChannelsActivity.v(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
    }

    static /* synthetic */ void t(EditNotificationChannelsActivity editNotificationChannelsActivity, NotificationChannel notificationChannel, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            notificationChannel = null;
        }
        editNotificationChannelsActivity.s(notificationChannel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(EditText notificationChannel, NotificationChannel notificationChannel2, EditNotificationChannelsActivity this$0, Spinner spinner, int[] priorityValues, AppCompatDialog dialog, View view) {
        int i4;
        Intrinsics.checkNotNullParameter(notificationChannel, "$notificationChannel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(priorityValues, "$priorityValues");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        String obj = notificationChannel.getText().toString();
        if (notificationChannel2 == null && this$0.getNotificationChannelUtil().doesChannelExist(obj)) {
            ToastCompat.makeText(this$0.getApplicationContext(), (int) R.string.notification_channel_already_exists, 1).show();
            return;
        }
        if (notificationChannel2 != null) {
            this$0.getNotificationChannelUtil().deleteNotificationChannel(notificationChannel2.getChannelName());
            if (!Intrinsics.areEqual(notificationChannel2.getChannelName(), obj)) {
                this$0.r(notificationChannel2.getChannelName(), obj);
            }
        }
        if (spinner != null) {
            i4 = spinner.getSelectedItemPosition();
        } else {
            i4 = 0;
        }
        this$0.getNotificationChannelUtil().createNotificationChannel(obj, priorityValues[i4]);
        dialog.dismiss();
        this$0.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    @NotNull
    public final NotificationChannelUtil getNotificationChannelUtil() {
        NotificationChannelUtil notificationChannelUtil = this.notificationChannelUtil;
        if (notificationChannelUtil != null) {
            return notificationChannelUtil;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationChannelUtil");
        return null;
    }

    @Override // com.arlosoft.macrodroid.settings.a
    public void onChannelSelected(@NotNull final NotificationChannel notificationChannel) {
        Intrinsics.checkNotNullParameter(notificationChannel, "notificationChannel");
        final String[] strArr = {getString(R.string.edit), getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(notificationChannel.getChannelName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                EditNotificationChannelsActivity.q(strArr, this, notificationChannel, dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityEditNotificationChannelsBinding inflate = ActivityEditNotificationChannelsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13425f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setTitle(R.string.notification_channels);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActivityEditNotificationChannelsBinding activityEditNotificationChannelsBinding = this.f13425f;
        if (activityEditNotificationChannelsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditNotificationChannelsBinding = null;
        }
        FloatingActionButton floatingActionButton = activityEditNotificationChannelsBinding.addChannelFab;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.addChannelFab");
        ViewExtensionsKt.onClick$default(floatingActionButton, null, new a(null), 1, null);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refresh();
    }

    public final void setNotificationChannelUtil(@NotNull NotificationChannelUtil notificationChannelUtil) {
        Intrinsics.checkNotNullParameter(notificationChannelUtil, "<set-?>");
        this.notificationChannelUtil = notificationChannelUtil;
    }
}
