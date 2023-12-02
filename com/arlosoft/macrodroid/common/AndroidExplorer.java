package com.arlosoft.macrodroid.common;

import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class AndroidExplorer extends ListActivity {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f9823a = null;

    /* renamed from: b  reason: collision with root package name */
    private final String f9824b = RemoteSettings.FORWARD_SLASH_STRING;

    /* renamed from: c  reason: collision with root package name */
    private TextView f9825c;

    /* renamed from: d  reason: collision with root package name */
    private String f9826d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9827e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9828f;

    /* renamed from: g  reason: collision with root package name */
    private String f9829g;

    /* renamed from: h  reason: collision with root package name */
    private String f9830h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9831i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends ArrayAdapter<String> {
        a(Context context, int i4, List list) {
            super(context, i4, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) AndroidExplorer.this.getSystemService("layout_inflater")).inflate(R.layout.explorer_row, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.rowtext);
            String str = (String) getItem(i4);
            textView.setText(str);
            if (str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                textView.setTextColor(-16777216);
                textView.setTypeface(null, 0);
                textView.setTextSize(20.0f);
            } else if (AndroidExplorer.this.f9827e) {
                textView.setTextColor(Color.rgb(96, 96, 96));
                textView.setTextSize(16.0f);
            } else {
                textView.setTextColor(Color.rgb(32, 32, 160));
                textView.setTypeface(null, 1);
                textView.setTextSize(20.0f);
            }
            return view;
        }
    }

    private void f(String str) {
        String str2;
        String[] strArr;
        this.f9825c.setText(str);
        ArrayList arrayList = new ArrayList();
        this.f9823a = new ArrayList();
        File file = new File(str);
        File[] fileArr = new File[0];
        if (file.isDirectory()) {
            if (!file.canRead()) {
                fileArr = FileUtils.rootGetFilesInDir(file);
            } else {
                fileArr = file.listFiles();
                if (fileArr != null) {
                    Arrays.sort(fileArr, new Comparator() { // from class: com.arlosoft.macrodroid.common.d
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int g4;
                            g4 = AndroidExplorer.g((File) obj, (File) obj2);
                            return g4;
                        }
                    });
                }
            }
        }
        if (!str.equals(RemoteSettings.FORWARD_SLASH_STRING)) {
            arrayList.add(RemoteSettings.FORWARD_SLASH_STRING);
            this.f9823a.add(RemoteSettings.FORWARD_SLASH_STRING);
            arrayList.add("../");
            this.f9823a.add(file.getParent());
        }
        if (fileArr != null) {
            for (File file2 : fileArr) {
                if (file2.isDirectory()) {
                    if (file2.canRead() || this.f9831i) {
                        arrayList.add(file2.getName() + RemoteSettings.FORWARD_SLASH_STRING);
                        this.f9823a.add(file2.getPath());
                    }
                } else if (this.f9828f) {
                    for (String str3 : Util.AUDIO_FILE_TYPES) {
                        if (this.f9827e || file2.getName().toLowerCase().endsWith(str3.toLowerCase())) {
                            arrayList.add(file2.getName());
                            this.f9823a.add(file2.getPath());
                            break;
                        }
                    }
                } else {
                    String str4 = this.f9829g;
                    if (str4 == null && (str2 = this.f9830h) == null) {
                        if (str2 != null) {
                            if (this.f9827e || file2.getName().endsWith(this.f9830h)) {
                                arrayList.add(file2.getName());
                                this.f9823a.add(file2.getPath());
                            }
                        } else {
                            arrayList.add(file2.getName());
                            this.f9823a.add(file2.getPath());
                        }
                    } else if (this.f9827e || ((str4 != null && file2.getName().endsWith(this.f9829g)) || (this.f9829g != null && file2.getName().endsWith(this.f9830h)))) {
                        arrayList.add(file2.getName());
                        this.f9823a.add(file2.getPath());
                    }
                }
            }
        }
        setListAdapter(new a(this, R.layout.explorer_row, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(File file, File file2) {
        if (file.isDirectory() && !file2.isDirectory()) {
            return -1;
        }
        if (file2.isDirectory() && !file.isDirectory()) {
            return 1;
        }
        return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        Intent intent = new Intent();
        intent.putExtra(Util.FILE_SELECTION_EXTRA, this.f9825c.getText().toString());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setContentView(R.layout.android_explorer);
        this.f9825c = (TextView) findViewById(R.id.path);
        this.f9831i = RootToolsHelper.isAccessGiven();
        if (bundle != null) {
            this.f9826d = bundle.getString("Title");
            this.f9827e = bundle.getBoolean(Util.FOLDER_EXTRA);
            this.f9828f = bundle.getBoolean(Util.USE_AUDIO_FILTER_EXTRA, false);
            this.f9829g = bundle.getString(Util.FILE_EXTENSION_FILTER);
            this.f9830h = getIntent().getExtras().getString(Util.FILE_EXTENSION_FILTER2);
            string = bundle.getString(Util.PATH_EXTRA);
        } else {
            if (getIntent().getExtras() == null) {
                finish();
            }
            this.f9826d = getIntent().getExtras().getString("Title");
            this.f9827e = getIntent().getExtras().getBoolean(Util.FOLDER_EXTRA);
            this.f9828f = getIntent().getExtras().getBoolean(Util.USE_AUDIO_FILTER_EXTRA, false);
            this.f9829g = getIntent().getExtras().getString(Util.FILE_EXTENSION_FILTER);
            this.f9830h = getIntent().getExtras().getString(Util.FILE_EXTENSION_FILTER2);
            string = getIntent().getExtras().getString(Util.PATH_EXTRA);
        }
        if (string == null) {
            f(RemoteSettings.FORWARD_SLASH_STRING);
        } else {
            this.f9825c.setText(string);
            f(string);
        }
        setTitle(this.f9826d);
        ((TextView) findViewById(R.id.top_label)).setText(this.f9826d);
        Button button = (Button) findViewById(R.id.okButton);
        Button button2 = (Button) findViewById(R.id.cancelButton);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.button_bar);
        if (!this.f9827e) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.setVisibility(0);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.common.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidExplorer.this.h(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.common.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidExplorer.this.i(view);
            }
        });
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i4, long j4) {
        File file = new File(this.f9823a.get(i4));
        if (file.isDirectory()) {
            if (file.canRead()) {
                f(this.f9823a.get(i4));
            } else if (this.f9831i) {
                f(this.f9823a.get(i4));
            } else {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("AndroidExplorer: onListItemClick cannot read directory"));
                AlertDialog.Builder icon = new AlertDialog.Builder(this).setIcon(17301543);
                icon.setTitle("[" + file.getName() + "] " + getString(R.string.folder_cant_be_read)).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        dialogInterface.dismiss();
                    }
                }).show();
            }
        } else if (!this.f9827e) {
            Intent intent = new Intent();
            intent.putExtra(Util.FILE_SELECTION_EXTRA, this.f9823a.get(i4));
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("Title", this.f9826d);
        super.onSaveInstanceState(bundle);
    }
}
