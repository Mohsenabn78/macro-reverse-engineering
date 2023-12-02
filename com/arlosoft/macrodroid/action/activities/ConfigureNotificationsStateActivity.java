package com.arlosoft.macrodroid.action.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.AppNotificationState;
import com.arlosoft.macrodroid.common.GetAppListTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ConfigureNotificationsStateActivity extends MacroDroidDialogBaseActivity implements GetAppListTask.AppListListener {
    public static final String APP_NOTIFICATION_STATES_EXTRA = "AppNotifications";

    /* renamed from: d  reason: collision with root package name */
    private transient String[] f2809d;

    /* renamed from: e  reason: collision with root package name */
    private transient String[] f2810e;

    /* renamed from: f  reason: collision with root package name */
    private ListView f2811f;

    /* renamed from: g  reason: collision with root package name */
    private NotificationStateAdapter f2812g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<AppNotificationState> f2813h;

    /* renamed from: i  reason: collision with root package name */
    private int f2814i = 1;

    private void k() {
        AppNotificationState appNotificationState;
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f2809d.length; i4++) {
            AppNotificationState appNotificationState2 = new AppNotificationState(this.f2809d[i4], this.f2810e[i4], 0);
            Iterator<AppNotificationState> it = this.f2813h.iterator();
            while (true) {
                if (it.hasNext()) {
                    appNotificationState = it.next();
                    if (appNotificationState != null && appNotificationState.getPackageName() != null && appNotificationState.getPackageName().equals(appNotificationState2.getPackageName())) {
                        break;
                    }
                } else {
                    appNotificationState = null;
                    break;
                }
            }
            if (appNotificationState != null) {
                arrayList.add(appNotificationState);
            } else {
                arrayList.add(appNotificationState2);
            }
        }
        NotificationStateAdapter notificationStateAdapter = new NotificationStateAdapter(this, R.layout.configure_notification_states_item, R.id.configure_notification_item_app_name, arrayList);
        this.f2812g = notificationStateAdapter;
        this.f2811f.setAdapter((ListAdapter) notificationStateAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        setResult(0, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        Intent intent = new Intent();
        setResult(-1, intent);
        NotificationStateAdapter notificationStateAdapter = this.f2812g;
        if (notificationStateAdapter != null) {
            intent.putExtra(APP_NOTIFICATION_STATES_EXTRA, notificationStateAdapter.getAppNotificationStatesList());
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        Iterator<AppNotificationState> it = this.f2812g.getAppNotificationStatesList().iterator();
        while (it.hasNext()) {
            it.next().setAppNotificationState(this.f2814i);
        }
        int i4 = this.f2814i + 1;
        this.f2814i = i4;
        if (i4 > 2) {
            this.f2814i = 0;
        }
        this.f2812g.notifyDataSetChanged();
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        this.f2809d = new String[list.size()];
        this.f2810e = new String[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            AppInfo appInfo = list.get(i4);
            this.f2809d[i4] = appInfo.packageName;
            this.f2810e[i4] = appInfo.applicationName;
        }
        k();
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.configure_notification_states);
        getWindow().setLayout(-1, -1);
        this.f2811f = (ListView) findViewById(R.id.configure_notification_states);
        setTitle(R.string.configure_notifications);
        this.f2813h = new ArrayList<>();
        if (getIntent() != null) {
            Iterator it = getIntent().getParcelableArrayListExtra(APP_NOTIFICATION_STATES_EXTRA).iterator();
            while (it.hasNext()) {
                this.f2813h.add((AppNotificationState) ((Parcelable) it.next()));
            }
        }
        ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfigureNotificationsStateActivity.this.l(view);
            }
        });
        ((Button) findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfigureNotificationsStateActivity.this.m(view);
            }
        });
        ((Button) findViewById(R.id.configure_notification_states_button_toggle)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfigureNotificationsStateActivity.this.n(view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f2809d != null && this.f2810e != null) {
            k();
        } else {
            new GetAppListTask(this, this, true, false, ContextCompat.getColor(this, R.color.actions_accent)).execute((Object[]) null);
        }
    }

    /* loaded from: classes2.dex */
    public class NotificationStateAdapter extends ArrayAdapter<AppNotificationState> {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<AppNotificationState> f2815a;

        public NotificationStateAdapter(Context context, int i4, int i5, ArrayList<AppNotificationState> arrayList) {
            super(context, i4, i5, arrayList);
            this.f2815a = arrayList;
        }

        public ArrayList<AppNotificationState> getAppNotificationStatesList() {
            return this.f2815a;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            AppNotificationState appNotificationState = this.f2815a.get(i4);
            if (view == null) {
                view = ((LayoutInflater) ConfigureNotificationsStateActivity.this.getSystemService("layout_inflater")).inflate(R.layout.configure_notification_states_item, (ViewGroup) null);
            }
            ((TextView) view.findViewById(R.id.configure_notification_item_app_name)).setText(this.f2815a.get(i4).getAppName());
            Spinner spinner = (Spinner) view.findViewById(R.id.configure_notification_item_state);
            spinner.setOnItemSelectedListener(null);
            spinner.setSelection(appNotificationState.getAppNotificationState());
            spinner.setOnItemSelectedListener(new a(appNotificationState));
            return view;
        }

        /* loaded from: classes2.dex */
        class a implements AdapterView.OnItemSelectedListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AppNotificationState f2817a;

            a(AppNotificationState appNotificationState) {
                this.f2817a = appNotificationState;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
                this.f2817a.setAppNotificationState(i4);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        }
    }
}
