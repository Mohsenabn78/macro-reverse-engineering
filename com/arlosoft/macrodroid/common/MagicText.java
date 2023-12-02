package com.arlosoft.macrodroid.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.stopwatch.StopWatch;
import com.arlosoft.macrodroid.triggers.ApplicationInstalledRemovedTrigger;
import com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger;
import com.arlosoft.macrodroid.triggers.BluetoothTrigger;
import com.arlosoft.macrodroid.triggers.CalendarTrigger;
import com.arlosoft.macrodroid.triggers.CallActiveTrigger;
import com.arlosoft.macrodroid.triggers.CallEndedTrigger;
import com.arlosoft.macrodroid.triggers.CallMissedTrigger;
import com.arlosoft.macrodroid.triggers.IncomingCallTrigger;
import com.arlosoft.macrodroid.triggers.IncomingSMSTrigger;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.LogcatTrigger;
import com.arlosoft.macrodroid.triggers.NotificationTrigger;
import com.arlosoft.macrodroid.triggers.OutgoingCallTrigger;
import com.arlosoft.macrodroid.triggers.SMSSentTrigger;
import com.arlosoft.macrodroid.triggers.SpotifyTrigger;
import com.arlosoft.macrodroid.triggers.SystemSettingTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.UsbDeviceConnectionTrigger;
import com.arlosoft.macrodroid.triggers.WeatherTrigger;
import com.arlosoft.macrodroid.triggers.WebHookTrigger;
import com.arlosoft.macrodroid.utils.StringManipulation;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.drakeet.support.toast.ToastCompat;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes3.dex */
public class MagicText {
    public static int DEFAULT_BRACKETS_CURLY = 0;
    public static int DEFAULT_BRACKET_SQUARE = 1;
    public static final String INCOMING_SMS_CONTACT_NAME = "[sms_name]";
    public static final String INCOMING_SMS_MESSAGE = "[sms_message]";
    public static final String INCOMING_SMS_NUMBER = "[sms_number]";
    public static final String NOTIFICATION_MAGIC_TEXT = "[notification]";

    /* renamed from: a  reason: collision with root package name */
    private static MagicTextPair f9882a;

    /* loaded from: classes3.dex */
    public static class MagicTextAdapter extends BaseAdapter implements Filterable {

        /* renamed from: a  reason: collision with root package name */
        List<MagicTextPair> f9883a;

        /* renamed from: b  reason: collision with root package name */
        List<MagicTextPair> f9884b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a extends Filter {
            a() {
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                int size = MagicTextAdapter.this.f9884b.size();
                for (int i4 = 0; i4 < size; i4++) {
                    MagicTextPair magicTextPair = MagicTextAdapter.this.f9884b.get(i4);
                    if (charSequence == null || charSequence.toString().length() == 0 || magicTextPair.name.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        arrayList.add(magicTextPair);
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                MagicTextAdapter magicTextAdapter = MagicTextAdapter.this;
                magicTextAdapter.f9883a = (List) filterResults.values;
                magicTextAdapter.notifyDataSetChanged();
            }
        }

        public MagicTextAdapter(Context context, List<MagicTextPair> list) {
            this.f9884b = list;
            this.f9883a = new ArrayList(this.f9884b);
        }

        private void a(int i4, View view) {
            ((TextView) view.findViewById(16908308)).setText(((MagicTextPair) getItem(i4)).name);
        }

        private View b(ViewGroup viewGroup) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_choice_list_item, viewGroup, false);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f9883a.size();
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return new a();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            return this.f9883a.get(i4);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        public MagicTextPair getMagicTextPair(int i4) {
            return this.f9883a.get(i4);
        }

        @Override // android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = b(viewGroup);
            }
            a(i4, view);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public interface MagicTextListener {
        void magicTextSelected(MagicTextPair magicTextPair);
    }

    /* loaded from: classes3.dex */
    public static class MagicTextPair {
        public String magicText;
        public String name;

        public MagicTextPair(String str, String str2) {
            this.magicText = str;
            this.name = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MagicTextPair)) {
                return false;
            }
            MagicTextPair magicTextPair = (MagicTextPair) obj;
            if (!magicTextPair.name.equals(this.name) || !magicTextPair.magicText.equals(this.magicText)) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f9886a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f9887b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Macro f9888c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MagicTextListener f9889d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f9890e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ IteratorType f9891f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f9892g;

        a(AppCompatDialog appCompatDialog, Activity activity, Macro macro, MagicTextListener magicTextListener, int i4, IteratorType iteratorType, boolean z3) {
            this.f9886a = appCompatDialog;
            this.f9887b = activity;
            this.f9888c = macro;
            this.f9889d = magicTextListener;
            this.f9890e = i4;
            this.f9891f = iteratorType;
            this.f9892g = z3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9886a.dismiss();
            MagicText.u(this.f9887b, this.f9888c, this.f9889d, this.f9890e, this.f9891f, this.f9892g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f9893a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f9894b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MagicTextListener f9895c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Macro f9896d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f9897e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f9898f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f9899g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f9900h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f9901i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ IteratorType f9902j;

        b(AppCompatDialog appCompatDialog, Activity activity, MagicTextListener magicTextListener, Macro macro, boolean z3, boolean z4, boolean z5, int i4, boolean z6, IteratorType iteratorType) {
            this.f9893a = appCompatDialog;
            this.f9894b = activity;
            this.f9895c = magicTextListener;
            this.f9896d = macro;
            this.f9897e = z3;
            this.f9898f = z4;
            this.f9899g = z5;
            this.f9900h = i4;
            this.f9901i = z6;
            this.f9902j = iteratorType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9893a.dismiss();
            MagicText.v(this.f9894b, this.f9895c, this.f9896d, this.f9897e, this.f9898f, this.f9899g, this.f9900h, this.f9901i, this.f9902j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements Function1<VariableHelper.ManualKeyData, Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MagicTextListener f9904a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9905b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9906c;

        d(MagicTextListener magicTextListener, String str, String str2) {
            this.f9904a = magicTextListener;
            this.f9905b = str;
            this.f9906c = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(VariableHelper.ManualKeyData manualKeyData) {
            MagicTextListener magicTextListener = this.f9904a;
            String str = this.f9905b;
            magicTextListener.magicTextSelected(new MagicTextPair(str.replace("%s", this.f9906c + manualKeyData.asString()), ""));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum e {
        VALUE,
        STRING_LENGTH,
        STRING_VALUE,
        ARRAY_DICTIONARY_SIZE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class f {
        private final MagicTextPair A1;
        private final MagicTextPair B1;
        private final MagicTextPair C1;
        private final MagicTextPair D1;
        private final MagicTextPair E1;
        private final MagicTextPair F1;
        private final MagicTextPair G1;
        private final MagicTextPair H1;
        private final MagicTextPair I1;
        private final MagicTextPair J1;
        private final String K0;
        private final MagicTextPair K1;
        private final MagicTextPair L0;
        private final MagicTextPair L1;
        private final MagicTextPair M0;
        private final MagicTextPair M1;
        private final MagicTextPair N0;
        private final MagicTextPair N1;
        private final MagicTextPair O0;
        private final MagicTextPair O1;
        private final MagicTextPair P0;
        private final MagicTextPair P1;
        private final MagicTextPair Q0;
        private final MagicTextPair Q1;
        private final MagicTextPair R0;
        private final MagicTextPair R1;
        private final MagicTextPair S0;
        private final MagicTextPair S1;
        private final MagicTextPair T0;
        private final MagicTextPair T1;
        private final MagicTextPair U0;
        private final MagicTextPair V0;
        private final MagicTextPair W0;
        private final MagicTextPair X0;
        private final MagicTextPair Y0;
        private final MagicTextPair Z0;

        /* renamed from: a1  reason: collision with root package name */
        private final MagicTextPair f9914a1;

        /* renamed from: b1  reason: collision with root package name */
        private final MagicTextPair f9917b1;

        /* renamed from: c1  reason: collision with root package name */
        private final MagicTextPair f9920c1;

        /* renamed from: d1  reason: collision with root package name */
        private final MagicTextPair f9923d1;

        /* renamed from: e1  reason: collision with root package name */
        private final MagicTextPair f9926e1;

        /* renamed from: f1  reason: collision with root package name */
        private final MagicTextPair f9929f1;

        /* renamed from: g1  reason: collision with root package name */
        private final MagicTextPair f9932g1;

        /* renamed from: h1  reason: collision with root package name */
        private final MagicTextPair f9935h1;

        /* renamed from: i1  reason: collision with root package name */
        private final MagicTextPair f9938i1;

        /* renamed from: j1  reason: collision with root package name */
        private final MagicTextPair f9941j1;

        /* renamed from: k1  reason: collision with root package name */
        private final MagicTextPair f9944k1;

        /* renamed from: l1  reason: collision with root package name */
        private final MagicTextPair f9947l1;

        /* renamed from: m1  reason: collision with root package name */
        private final MagicTextPair f9950m1;

        /* renamed from: n1  reason: collision with root package name */
        private final MagicTextPair f9953n1;

        /* renamed from: o1  reason: collision with root package name */
        private final MagicTextPair f9956o1;

        /* renamed from: p1  reason: collision with root package name */
        private final MagicTextPair f9959p1;

        /* renamed from: q1  reason: collision with root package name */
        private final MagicTextPair f9962q1;

        /* renamed from: r1  reason: collision with root package name */
        private final MagicTextPair f9965r1;

        /* renamed from: s1  reason: collision with root package name */
        private final MagicTextPair f9968s1;

        /* renamed from: t1  reason: collision with root package name */
        private final MagicTextPair f9971t1;

        /* renamed from: u1  reason: collision with root package name */
        private final MagicTextPair f9974u1;

        /* renamed from: v1  reason: collision with root package name */
        private final MagicTextPair f9977v1;

        /* renamed from: w1  reason: collision with root package name */
        private final MagicTextPair f9980w1;

        /* renamed from: x1  reason: collision with root package name */
        private final MagicTextPair f9983x1;

        /* renamed from: y1  reason: collision with root package name */
        private final MagicTextPair f9986y1;

        /* renamed from: z1  reason: collision with root package name */
        private final MagicTextPair f9989z1;

        /* renamed from: a  reason: collision with root package name */
        private final MagicTextPair f9912a = new MagicTextPair("[mode]", MagicText.Q(R.string.constraint_mode));

        /* renamed from: b  reason: collision with root package name */
        private final MagicTextPair f9915b = new MagicTextPair("[battery]", MagicText.Q(R.string.current_battery_percent));

        /* renamed from: c  reason: collision with root package name */
        private final MagicTextPair f9918c = new MagicTextPair("[battery_temp]", MagicText.Q(R.string.battery_temp_c));

        /* renamed from: d  reason: collision with root package name */
        private final MagicTextPair f9921d = new MagicTextPair("[power]", MagicText.Q(R.string.power_on_off));

        /* renamed from: e  reason: collision with root package name */
        private final MagicTextPair f9924e = new MagicTextPair("[clipboard]", MagicText.Q(R.string.clipboard_text));

        /* renamed from: f  reason: collision with root package name */
        private final MagicTextPair f9927f = new MagicTextPair("[ip]", MagicText.Q(R.string.current_ip_address));

        /* renamed from: g  reason: collision with root package name */
        private final MagicTextPair f9930g = new MagicTextPair("[ip6]", MagicText.Q(R.string.current_ip_address_v6));

        /* renamed from: h  reason: collision with root package name */
        private final MagicTextPair f9933h = new MagicTextPair("[ssid]", MagicText.Q(R.string.wifi_ssid));

        /* renamed from: i  reason: collision with root package name */
        private final MagicTextPair f9936i = new MagicTextPair("[wifi_strength]", MagicText.Q(R.string.wifi_signal_strength));

        /* renamed from: j  reason: collision with root package name */
        private final MagicTextPair f9939j = new MagicTextPair("[cell_signal_strength]", MagicText.Q(R.string.cell_tower_signal_strength));

        /* renamed from: k  reason: collision with root package name */
        private final MagicTextPair f9942k = new MagicTextPair("[dayofweek]", MagicText.Q(R.string.day_of_the_week));

        /* renamed from: l  reason: collision with root package name */
        private final MagicTextPair f9945l = new MagicTextPair("[dayofmonth]", MagicText.Q(R.string.day_of_the_month));

        /* renamed from: m  reason: collision with root package name */
        private final MagicTextPair f9948m = new MagicTextPair("[month]", MagicText.Q(R.string.month));

        /* renamed from: n  reason: collision with root package name */
        private final MagicTextPair f9951n = new MagicTextPair("[month_digit]", MagicText.Q(R.string.month_as_digit));

        /* renamed from: o  reason: collision with root package name */
        private final MagicTextPair f9954o = new MagicTextPair("[year]", MagicText.Q(R.string.year));

        /* renamed from: p  reason: collision with root package name */
        private final MagicTextPair f9957p = new MagicTextPair("[hour]", MagicText.Q(R.string.hour_of_day));

        /* renamed from: q  reason: collision with root package name */
        private final MagicTextPair f9960q = new MagicTextPair("[hour_0]", MagicText.Q(R.string.hour_of_day_leading_zero));

        /* renamed from: r  reason: collision with root package name */
        private final MagicTextPair f9963r = new MagicTextPair("[hour12]", MagicText.Q(R.string.hour_of_day_12));

        /* renamed from: s  reason: collision with root package name */
        private final MagicTextPair f9966s = new MagicTextPair("[minute]", MagicText.p(MagicText.Q(R.string.minute)));

        /* renamed from: t  reason: collision with root package name */
        private final MagicTextPair f9969t = new MagicTextPair("[second]", MagicText.p(MagicText.Q(R.string.second)));

        /* renamed from: u  reason: collision with root package name */
        private final MagicTextPair f9972u = new MagicTextPair("[week_of_year]", MagicText.Q(R.string.week_of_year));

        /* renamed from: v  reason: collision with root package name */
        private final MagicTextPair f9975v = new MagicTextPair("[am_pm]", MagicText.Q(R.string.before_midday_am) + RemoteSettings.FORWARD_SLASH_STRING + MagicText.Q(R.string.after_midday_pm));

        /* renamed from: w  reason: collision with root package name */
        private final MagicTextPair f9978w = new MagicTextPair("[system_time]", MagicText.Q(R.string.system_time));

        /* renamed from: x  reason: collision with root package name */
        private final MagicTextPair f9981x = new MagicTextPair("[system_time_ms]", MagicText.Q(R.string.system_time_ms));

        /* renamed from: y  reason: collision with root package name */
        private final MagicTextPair f9984y = new MagicTextPair("[webhook_caller_ip]", MagicText.Q(R.string.webhook_caller_ip_address));

        /* renamed from: z  reason: collision with root package name */
        private final MagicTextPair f9987z = new MagicTextPair("[not_title]", MagicText.Q(R.string.notification_title));
        private final MagicTextPair A = new MagicTextPair("[not_ticker]", MagicText.Q(R.string.notification_ticker_text));
        private final MagicTextPair B = new MagicTextPair(MagicText.NOTIFICATION_MAGIC_TEXT, MagicText.Q(R.string.notification_text));
        private final MagicTextPair C = new MagicTextPair("[not_sub_text]", MagicText.Q(R.string.notification_subtext));
        private final MagicTextPair D = new MagicTextPair("[not_app_name]", MagicText.Q(R.string.notification_app_name));
        private final MagicTextPair E = new MagicTextPair("[not_app_package]", MagicText.Q(R.string.notification_app_package));
        private final MagicTextPair F = new MagicTextPair("[not_text_lines]", MagicText.Q(R.string.notification_text_lines));
        private final MagicTextPair G = new MagicTextPair("[not_text_big]", MagicText.Q(R.string.notification_big_text));
        private final MagicTextPair H = new MagicTextPair("[not_action_names]", MagicText.Q(R.string.notification_magic_text_action_names));
        private final MagicTextPair I = new MagicTextPair(MagicText.INCOMING_SMS_CONTACT_NAME, MagicText.Q(R.string.incoming_sms_contact));
        private final MagicTextPair J = new MagicTextPair(MagicText.INCOMING_SMS_MESSAGE, MagicText.Q(R.string.incoming_sms_message));
        private final MagicTextPair K = new MagicTextPair(MagicText.INCOMING_SMS_NUMBER, MagicText.Q(R.string.incoming_sms_number));
        private final MagicTextPair L = new MagicTextPair(MagicText.INCOMING_SMS_CONTACT_NAME, MagicText.Q(R.string.outgoing_sms_contact));
        private final MagicTextPair M = new MagicTextPair(MagicText.INCOMING_SMS_MESSAGE, MagicText.Q(R.string.outgoing_sms_message));
        private final MagicTextPair N = new MagicTextPair(MagicText.INCOMING_SMS_NUMBER, MagicText.Q(R.string.outgoing_sms_number));
        private final MagicTextPair O = new MagicTextPair("[app_name]", MagicText.Q(R.string.application_name));
        private final MagicTextPair P = new MagicTextPair("[app_package]", MagicText.Q(R.string.application_package));
        private final MagicTextPair Q = new MagicTextPair("[lat_long]", MagicText.Q(R.string.location_lat_lng));
        private final MagicTextPair R = new MagicTextPair("[call_number]", MagicText.Q(R.string.call_number));
        private final MagicTextPair S = new MagicTextPair("[call_name]", MagicText.Q(R.string.call_name));
        private final MagicTextPair T = new MagicTextPair("[cell_connection_type]", MagicText.Q(R.string.cell_connection_type));
        private final MagicTextPair U = new MagicTextPair("[mcc]", MagicText.Q(R.string.mobile_country_code));
        private final MagicTextPair V = new MagicTextPair("[mnc]", MagicText.Q(R.string.mobile_network_code));
        private final MagicTextPair W = new MagicTextPair("[lac]", MagicText.Q(R.string.location_area_code));
        private final MagicTextPair X = new MagicTextPair("[cell_id]", MagicText.Q(R.string.cell_id));
        private final MagicTextPair Y = new MagicTextPair("[imei]", MagicText.Q(R.string.internation_mobil_equipment_identity));
        private final MagicTextPair Z = new MagicTextPair("[meid]", MagicText.Q(R.string.mobile_equipment_identifier));

        /* renamed from: a0  reason: collision with root package name */
        private final MagicTextPair f9913a0 = new MagicTextPair("[spotify_track_id]", MagicText.Q(R.string.spotify_magic_text_track_id));

        /* renamed from: b0  reason: collision with root package name */
        private final MagicTextPair f9916b0 = new MagicTextPair("[spotify_artist]", MagicText.Q(R.string.spotify_artist_name));

        /* renamed from: c0  reason: collision with root package name */
        private final MagicTextPair f9919c0 = new MagicTextPair("[spotify_album]", MagicText.Q(R.string.spotify_album_name));

        /* renamed from: d0  reason: collision with root package name */
        private final MagicTextPair f9922d0 = new MagicTextPair("[spotify_track]", MagicText.Q(R.string.spotify_track_name));

        /* renamed from: e0  reason: collision with root package name */
        private final MagicTextPair f9925e0 = new MagicTextPair("[spotify_track_length_s]", MagicText.Q(R.string.spotify_track_length_seconds));

        /* renamed from: f0  reason: collision with root package name */
        private final MagicTextPair f9928f0 = new MagicTextPair("[spotify_is_playing]", MagicText.Q(R.string.spotify_is_playing));

        /* renamed from: g0  reason: collision with root package name */
        private final MagicTextPair f9931g0 = new MagicTextPair("[system_setting_category]", MagicText.Q(R.string.system_setting_category));

        /* renamed from: h0  reason: collision with root package name */
        private final MagicTextPair f9934h0 = new MagicTextPair("[system_setting_key]", MagicText.Q(R.string.system_setting_key));

        /* renamed from: i0  reason: collision with root package name */
        private final MagicTextPair f9937i0 = new MagicTextPair("[system_setting_value]", MagicText.Q(R.string.system_setting_value));

        /* renamed from: j0  reason: collision with root package name */
        private final MagicTextPair f9940j0 = new MagicTextPair("[weather_temperature_c]", MagicText.Q(R.string.temp_c));

        /* renamed from: k0  reason: collision with root package name */
        private final MagicTextPair f9943k0 = new MagicTextPair("[weather_temperature_farenheit]", MagicText.Q(R.string.temp_f));

        /* renamed from: l0  reason: collision with root package name */
        private final MagicTextPair f9946l0 = new MagicTextPair("[weather_wind_speed]", MagicText.Q(R.string.wind_speed) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + MagicText.Q(R.string.trigger_weather_m_s));

        /* renamed from: m0  reason: collision with root package name */
        private final MagicTextPair f9949m0 = new MagicTextPair("[weather_wind_speed_mph]", MagicText.Q(R.string.wind_speed) + " (" + MagicText.Q(R.string.trigger_weather_miles_per_hour) + ")");

        /* renamed from: n0  reason: collision with root package name */
        private final MagicTextPair f9952n0 = new MagicTextPair("[weather_wind_speed_kmh]", MagicText.Q(R.string.wind_speed) + " (" + MagicText.Q(R.string.trigger_weather_kilometres_per_hour) + ")");

        /* renamed from: o0  reason: collision with root package name */
        private final MagicTextPair f9955o0 = new MagicTextPair("[weather_wind_direction]", MagicText.Q(R.string.trigger_weather_wind_direction) + " (" + MagicText.Q(R.string.trigger_wind_direction_degrees) + ")");

        /* renamed from: p0  reason: collision with root package name */
        private final MagicTextPair f9958p0 = new MagicTextPair("[weather_humidity]", MagicText.Q(R.string.humidity));

        /* renamed from: q0  reason: collision with root package name */
        private final MagicTextPair f9961q0 = new MagicTextPair("[weather_conditions]", MagicText.Q(R.string.weather_conditions));

        /* renamed from: r0  reason: collision with root package name */
        private final MagicTextPair f9964r0 = new MagicTextPair("[last_loc_latlong]", MagicText.Q(R.string.last_known_location) + " (" + MagicText.Q(R.string.lat_lon) + ")");

        /* renamed from: s0  reason: collision with root package name */
        private final MagicTextPair f9967s0 = new MagicTextPair("[last_loc_lat]", MagicText.Q(R.string.last_known_location) + " (" + MagicText.Q(R.string.latitude_short) + ")");

        /* renamed from: t0  reason: collision with root package name */
        private final MagicTextPair f9970t0 = new MagicTextPair("[last_loc_long]", MagicText.Q(R.string.last_known_location) + " (" + MagicText.Q(R.string.longitude_short) + ")");

        /* renamed from: u0  reason: collision with root package name */
        private final MagicTextPair f9973u0 = new MagicTextPair("[last_loc_alt]", MagicText.Q(R.string.last_known_location) + " (" + MagicText.Q(R.string.altitude) + ")");

        /* renamed from: v0  reason: collision with root package name */
        private final MagicTextPair f9976v0 = new MagicTextPair("[last_loc_accuracy]", MagicText.Q(R.string.last_known_location) + " (" + MagicText.Q(R.string.accuracy_meters) + ")");

        /* renamed from: w0  reason: collision with root package name */
        private final MagicTextPair f9979w0 = new MagicTextPair("[last_loc_link]", MagicText.Q(R.string.last_known_location) + " (" + MagicText.Q(R.string.link) + ")");

        /* renamed from: x0  reason: collision with root package name */
        private final MagicTextPair f9982x0 = new MagicTextPair("[last_loc_age_timestamp]", MagicText.Q(R.string.last_known_location) + " (" + MagicText.Q(R.string.time) + ")");

        /* renamed from: y0  reason: collision with root package name */
        private final MagicTextPair f9985y0 = new MagicTextPair("[last_loc_speed_kmh]", MagicText.Q(R.string.last_known_location_speed) + " (" + MagicText.Q(R.string.trigger_weather_kilometres_per_hour) + ")");

        /* renamed from: z0  reason: collision with root package name */
        private final MagicTextPair f9988z0 = new MagicTextPair("[last_loc_speed_mph]", MagicText.Q(R.string.last_known_location_speed) + " (" + MagicText.Q(R.string.trigger_weather_miles_per_hour) + ")");
        private final MagicTextPair A0 = new MagicTextPair("\\n", MagicText.Q(R.string.new_line));
        private final MagicTextPair B0 = new MagicTextPair("[peb_battery]", MagicText.Q(R.string.pebble_battery_level));
        public MagicTextPair C0 = new MagicTextPair("[owner_info]", "Owner Info");
        private final MagicTextPair D0 = new MagicTextPair("[battery_current_now]", MagicText.Q(R.string.battery_current_now));
        private final MagicTextPair E0 = new MagicTextPair("[uptime]", MagicText.Q(R.string.device_uptime));
        private final MagicTextPair F0 = new MagicTextPair("[uptime_secs]", MagicText.Q(R.string.device_uptime_seconds));
        private final MagicTextPair G0 = new MagicTextPair("[current_brightness]", MagicText.Q(R.string.current_brightness));
        private final MagicTextPair H0 = new MagicTextPair("[current_brightness_alternative]", MagicText.Q(R.string.current_brightness_alternative));
        private final MagicTextPair I0 = new MagicTextPair("[battery_int]", MagicText.Q(R.string.current_battery_percent));
        private final MagicTextPair J0 = new MagicTextPair("[screen_timeout]", MagicText.Q(R.string.screen_timeout_seconds));

        f() {
            String Q = MagicText.Q(R.string.current_volume);
            this.K0 = Q;
            this.L0 = new MagicTextPair("[vol_alarm]", Q + " (" + MagicText.Q(R.string.action_set_volume_alarm) + ")");
            this.M0 = new MagicTextPair("[vol_music]", Q + " (" + MagicText.Q(R.string.action_set_volume_music) + ")");
            this.N0 = new MagicTextPair("[vol_ring]", Q + " (" + MagicText.Q(R.string.action_set_volume_ringer) + ")");
            this.O0 = new MagicTextPair("[vol_notif]", Q + " (" + MagicText.Q(R.string.action_set_volume_notification) + ")");
            this.P0 = new MagicTextPair("[vol_system]", Q + " (" + MagicText.Q(R.string.action_set_volume_system_sounds) + ")");
            this.Q0 = new MagicTextPair("[vol_call]", Q + " (" + MagicText.Q(R.string.action_set_volume_voice_call) + ")");
            this.R0 = new MagicTextPair("[vol_bt_voice]", Q + " (" + MagicText.Q(R.string.action_set_volume_bluetooth_voice) + ")");
            this.S0 = new MagicTextPair("[macro_name]", MagicText.Q(R.string.macro_name));
            this.T0 = new MagicTextPair("[macro_id]", MagicText.Q(R.string.macro_id));
            this.U0 = new MagicTextPair("[macro_category]", MagicText.Q(R.string.macro_category));
            this.V0 = new MagicTextPair("[action_block_name]", MagicText.Q(R.string.action_block_name));
            this.W0 = new MagicTextPair("[device_serial]", MagicText.Q(R.string.device_serial));
            this.X0 = new MagicTextPair("[device_name]", MagicText.Q(R.string.device_name));
            this.Y0 = new MagicTextPair("[device_manufacturer]", MagicText.Q(R.string.magic_text_device_manufacturer));
            this.Z0 = new MagicTextPair("[device_model]", MagicText.Q(R.string.magic_text_device_model));
            this.f9914a1 = new MagicTextPair("[android_version]", MagicText.Q(R.string.magic_text_android_version));
            this.f9917b1 = new MagicTextPair("[android_version_sdk]", MagicText.Q(R.string.magic_text_android_version_sdk_level));
            this.f9920c1 = new MagicTextPair("[sim_operator_name]", MagicText.Q(R.string.sim_operator_name));
            this.f9923d1 = new MagicTextPair("[sim2_operator_name]", MagicText.Q(R.string.sim2_operator_name));
            this.f9926e1 = new MagicTextPair("[calendar_title]", MagicText.Q(R.string.calendar_title));
            this.f9929f1 = new MagicTextPair("[calendar_detail]", MagicText.Q(R.string.calendar_detail));
            this.f9932g1 = new MagicTextPair("[calendar_location]", MagicText.Q(R.string.calendar_location));
            this.f9935h1 = new MagicTextPair("[calendar_start_date]", MagicText.Q(R.string.calendar_start_date));
            this.f9938i1 = new MagicTextPair("[calendar_start_date_us]", MagicText.Q(R.string.calendar_start_date) + " (USA)");
            this.f9941j1 = new MagicTextPair("[calendar_start_time]", MagicText.Q(R.string.calendar_start_time));
            this.f9944k1 = new MagicTextPair("[calendar_end_date]", MagicText.Q(R.string.calendar_end_date));
            this.f9947l1 = new MagicTextPair("[calendar_end_date_us]", MagicText.Q(R.string.calendar_end_date) + " (USA)");
            this.f9950m1 = new MagicTextPair("[calendar_end_time]", MagicText.Q(R.string.calendar_end_time));
            this.f9953n1 = new MagicTextPair("[bluetooth_device_name]", MagicText.Q(R.string.bluetooth_device_name));
            this.f9956o1 = new MagicTextPair("[size=%s]", MagicText.Q(R.string.dictionary_array_size));
            this.f9959p1 = new MagicTextPair("[stringmanipulation]", MagicText.Q(R.string.string_manipulation));
            this.f9962q1 = new MagicTextPair("[strlen=%s]", MagicText.Q(R.string.string_var_length));
            this.f9965r1 = new MagicTextPair("[strval=%s]", MagicText.Q(R.string.string_var_value));
            this.f9968s1 = new MagicTextPair("[setting_system=%s]", MagicText.Q(R.string.action_system_setting) + " (System)");
            this.f9971t1 = new MagicTextPair("[setting_global=%s]", MagicText.Q(R.string.action_system_setting) + " (Global)");
            this.f9974u1 = new MagicTextPair("[setting_secure=%s]", MagicText.Q(R.string.action_system_setting) + " (Secure)");
            this.f9977v1 = new MagicTextPair("[ram_total]", MagicText.Q(R.string.ram_total_magic_text));
            this.f9980w1 = new MagicTextPair("[ram_available]", MagicText.Q(R.string.ram_available_magic_text));
            this.f9983x1 = new MagicTextPair("[storage_external_total]", MagicText.Q(R.string.external_storage_total_magic_text));
            this.f9986y1 = new MagicTextPair("[storage_external_free]", MagicText.Q(R.string.external_storage_free_magic_text));
            this.f9989z1 = new MagicTextPair("[storage_internal_total]", MagicText.Q(R.string.internal_storage_total_magic_text));
            this.A1 = new MagicTextPair("[storage_internal_free]", MagicText.Q(R.string.internal_storage_free_magic_text));
            this.B1 = new MagicTextPair("[storage_external_total_bytes]", MagicText.Q(R.string.external_storage_total_magic_text));
            this.C1 = new MagicTextPair("[storage_external_free_bytes]", MagicText.Q(R.string.external_storage_free_magic_text));
            this.D1 = new MagicTextPair("[storage_internal_total_bytes]", MagicText.Q(R.string.internal_storage_total_magic_text));
            this.E1 = new MagicTextPair("[storage_internal_free_bytes]", MagicText.Q(R.string.internal_storage_free_magic_text));
            this.F1 = new MagicTextPair("[usb_product_name]", MagicText.Q(R.string.usb_device_product_name_magic_text));
            this.G1 = new MagicTextPair("[usb_manufacturer_name]", MagicText.Q(R.string.usb_device_manufacturer_magic_text));
            this.H1 = new MagicTextPair("[usb_device_hash]", MagicText.Q(R.string.usb_device_id_hash_code));
            this.I1 = new MagicTextPair("[fg_app_name]", MagicText.Q(R.string.foreground_app_name_magic_text));
            this.J1 = new MagicTextPair("[fg_app_package]", MagicText.Q(R.string.foreground_app_package_magic_text));
            this.K1 = new MagicTextPair("[logcat_line]", MagicText.Q(R.string.logcat_entry_line_magic_text));
            this.L1 = new MagicTextPair("[macrodroid_version]", MagicText.Q(R.string.magic_text_macrodroid_version));
            this.M1 = new MagicTextPair("[macrodroid_is_pro]", MagicText.Q(R.string.magic_text_macrodroid_is_pro));
            this.N1 = new MagicTextPair("[screen_res]", MagicText.Q(R.string.screen_resolution));
            this.O1 = new MagicTextPair("[screen_res_x]", MagicText.Q(R.string.magic_text_screen_resolution_x));
            this.P1 = new MagicTextPair("[screen_res_y]", MagicText.Q(R.string.magic_text_screen_resolution_y));
            this.Q1 = new MagicTextPair("[webhook_url]", MagicText.Q(R.string.magic_text_webhook_url));
            this.R1 = new MagicTextPair("[iterator_array_index]", MagicText.Q(R.string.magic_text_iterator_array_index));
            this.S1 = new MagicTextPair("[iterator_dictionary_key]", MagicText.Q(R.string.magic_text_iterator_dictionary_key));
            this.T1 = new MagicTextPair("[iterator_value]", MagicText.Q(R.string.magic_text_iterator_value));
        }
    }

    private static String A(long j4) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        decimalFormatSymbols.setDecimalSeparator('.');
        new DecimalFormat("#.#######", decimalFormatSymbols);
        return new DecimalFormat("0.00##", decimalFormatSymbols).format(j4 / 1000.0d);
    }

    private static String B(long j4) {
        long j5 = j4 / 1000;
        return String.format("%02d", Long.valueOf(j5 / 3600)) + ":" + String.format("%02d", Long.valueOf((j5 / 60) % 60)) + ":" + String.format("%02d", Long.valueOf(j5 % 60));
    }

    private static String C(Context context) {
        if (W(context)) {
            return z(O(context).getFreeSpace());
        }
        if (y()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return z(statFs.getAvailableBlocks() * statFs.getBlockSize());
        }
        return TypeDescription.Generic.OfWildcardType.SYMBOL;
    }

    private static long D(Context context) {
        if (W(context)) {
            return O(context).getFreeSpace();
        }
        if (y()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    private static String E() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return z(statFs.getAvailableBlocks() * statFs.getBlockSize());
    }

    private static long F() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    private static String G(long j4) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j4);
            return simpleDateFormat.format(calendar.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    private static DecimalFormat H(String str) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat(str);
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat;
    }

    private static long I() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    private static List<MagicTextPair> J(Context context, boolean z3, boolean z4, Macro macro, IteratorType iteratorType) {
        f fVar = new f();
        ArrayList arrayList = new ArrayList();
        if (iteratorType == IteratorType.ARRAY) {
            arrayList.add(fVar.R1);
            arrayList.add(fVar.T1);
        } else if (iteratorType == IteratorType.DICTIONARY) {
            arrayList.add(fVar.S1);
            arrayList.add(fVar.T1);
        }
        arrayList.add(fVar.f9912a);
        for (String str : StopWatch.getStopWatches(MacroDroidApplication.getInstance())) {
            String format = String.format("[stopwatch=%s]", str);
            arrayList.add(new MagicTextPair(format, Q(R.string.action_stop_watch) + ": " + str));
        }
        if (macro != null) {
            if (macro.getLocalVariables().size() > 0) {
                arrayList.add(new MagicTextPair("[lv=%s]", Q(R.string.local_variable)));
            }
            if (MacroDroidVariableStore.getInstance().getAllVariables(false).size() > 0) {
                arrayList.add(new MagicTextPair("[v=%s]", Q(R.string.global_variable)));
            }
        }
        if (MacroDroidVariableStore.getInstance().getAllStringVariables().size() > 0 || (macro != null && macro.getLocalVariables().size() > 0)) {
            arrayList.add(fVar.f9962q1);
        }
        if (MacroDroidVariableStore.getInstance().getAllDictionaryAndArrayVariables().size() > 0 || (macro != null && macro.getLocalVariables().size() > 0)) {
            arrayList.add(fVar.f9956o1);
        }
        if (z3) {
            arrayList.add(fVar.A0);
        }
        arrayList.add(fVar.I1);
        arrayList.add(fVar.J1);
        arrayList.add(fVar.G0);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            arrayList.add(fVar.H0);
        }
        arrayList.add(fVar.J0);
        arrayList.add(fVar.f9915b);
        arrayList.add(fVar.f9918c);
        arrayList.add(fVar.D0);
        arrayList.add(fVar.f9921d);
        arrayList.add(fVar.f9924e);
        arrayList.add(fVar.f9927f);
        arrayList.add(fVar.f9930g);
        arrayList.add(fVar.f9933h);
        arrayList.add(fVar.f9936i);
        arrayList.add(fVar.f9939j);
        arrayList.add(fVar.f9942k);
        arrayList.add(fVar.f9945l);
        arrayList.add(fVar.f9972u);
        arrayList.add(fVar.f9948m);
        arrayList.add(fVar.f9951n);
        arrayList.add(fVar.f9954o);
        arrayList.add(fVar.f9957p);
        arrayList.add(fVar.f9960q);
        arrayList.add(fVar.f9963r);
        arrayList.add(fVar.f9966s);
        arrayList.add(fVar.f9969t);
        arrayList.add(fVar.f9975v);
        arrayList.add(fVar.f9978w);
        arrayList.add(fVar.f9981x);
        arrayList.add(fVar.Q1);
        arrayList.add(fVar.f9968s1);
        arrayList.add(fVar.f9971t1);
        arrayList.add(fVar.f9974u1);
        if (ApplicationChecker.isPebbleInstalled()) {
            arrayList.add(fVar.B0);
        }
        arrayList.add(fVar.T);
        TelephonyManager telephonyManager = (TelephonyManager) MacroDroidApplication.getInstance().getSystemService("phone");
        if (telephonyManager.getPhoneType() == 1) {
            arrayList.add(fVar.U);
            arrayList.add(fVar.V);
            arrayList.add(fVar.W);
            if (i4 < 29) {
                arrayList.add(fVar.Y);
            }
        } else if (telephonyManager.getPhoneType() == 2) {
            arrayList.add(fVar.Z);
        }
        if (telephonyManager.getPhoneType() == 1 || telephonyManager.getPhoneType() == 2) {
            arrayList.add(fVar.X);
        }
        arrayList.add(fVar.f9964r0);
        arrayList.add(fVar.f9967s0);
        arrayList.add(fVar.f9970t0);
        arrayList.add(fVar.f9973u0);
        arrayList.add(fVar.f9976v0);
        arrayList.add(fVar.f9979w0);
        arrayList.add(fVar.f9982x0);
        arrayList.add(fVar.f9985y0);
        arrayList.add(fVar.f9988z0);
        arrayList.add(fVar.L0);
        arrayList.add(fVar.M0);
        arrayList.add(fVar.N0);
        arrayList.add(fVar.O0);
        arrayList.add(fVar.P0);
        arrayList.add(fVar.Q0);
        arrayList.add(fVar.R0);
        if (macro != null && z4) {
            arrayList.add(fVar.S0);
            arrayList.add(fVar.T0);
            arrayList.add(fVar.U0);
            if (macro.isActionBlock) {
                arrayList.add(fVar.V0);
            }
        }
        if (i4 <= 28) {
            arrayList.add(fVar.W0);
        }
        if (i4 >= 25) {
            arrayList.add(fVar.X0);
        }
        arrayList.add(fVar.E0);
        arrayList.add(fVar.F0);
        arrayList.add(fVar.Y0);
        arrayList.add(fVar.Z0);
        arrayList.add(fVar.L1);
        arrayList.add(fVar.M1);
        arrayList.add(fVar.f9914a1);
        arrayList.add(fVar.f9917b1);
        arrayList.add(fVar.f9920c1);
        if (i4 >= 22 && P(context) > 1) {
            arrayList.add(fVar.f9923d1);
        }
        arrayList.add(fVar.N1);
        arrayList.add(fVar.O1);
        arrayList.add(fVar.P1);
        arrayList.add(fVar.f9977v1);
        arrayList.add(fVar.f9980w1);
        arrayList.add(fVar.f9983x1);
        arrayList.add(fVar.f9986y1);
        arrayList.add(fVar.f9989z1);
        arrayList.add(fVar.A1);
        return arrayList;
    }

    private static String[] K(List<MagicTextPair> list) {
        String[] strArr = new String[list.size()];
        int i4 = 0;
        for (MagicTextPair magicTextPair : list) {
            strArr[i4] = magicTextPair.name;
            i4++;
        }
        return strArr;
    }

    private static List<MagicTextPair> L(Macro macro, IteratorType iteratorType, boolean z3) {
        f fVar = new f();
        ArrayList arrayList = new ArrayList();
        if (iteratorType == IteratorType.ARRAY) {
            arrayList.add(fVar.R1);
            arrayList.add(fVar.T1);
        } else if (iteratorType == IteratorType.DICTIONARY) {
            arrayList.add(fVar.S1);
            arrayList.add(fVar.T1);
        }
        for (String str : StopWatch.getStopWatches(MacroDroidApplication.getInstance())) {
            String format = String.format("[stopwatch=%s]", str);
            arrayList.add(new MagicTextPair(format, Q(R.string.action_stop_watch) + ": " + str));
        }
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariables()) {
                if (z3 || macroDroidVariable.getHasNumericalValue() || macroDroidVariable.getHasNumericalChildren()) {
                    String format2 = String.format("[lv=%s]", macroDroidVariable.getName());
                    arrayList.add(new MagicTextPair(format2, Q(R.string.local_variable_short_name) + ": " + macroDroidVariable.getName()));
                }
            }
        }
        for (MacroDroidVariable macroDroidVariable2 : MacroDroidVariableStore.getInstance().getAllVariables(true)) {
            if (z3 || macroDroidVariable2.getHasNumericalValue() || macroDroidVariable2.getHasNumericalChildren()) {
                String format3 = String.format("[v=%s]", macroDroidVariable2.getName());
                arrayList.add(new MagicTextPair(format3, Q(R.string.variable_short_name) + ": " + macroDroidVariable2.getName()));
            }
        }
        if (macro != null) {
            arrayList.add(fVar.T0);
        }
        if (MacroDroidVariableStore.getInstance().getAllStringVariables().size() > 0 || (macro != null && macro.getLocalVariables().size() > 0)) {
            arrayList.add(fVar.f9962q1);
            arrayList.add(fVar.f9965r1);
        }
        if (MacroDroidVariableStore.getInstance().getAllDictionaryAndArrayVariables().size() > 0 || (macro != null && macro.getLocalVariables().size() > 0)) {
            arrayList.add(fVar.f9956o1);
        }
        arrayList.add(fVar.G0);
        arrayList.add(fVar.J0);
        arrayList.add(fVar.I0);
        arrayList.add(fVar.f9918c);
        arrayList.add(fVar.D0);
        arrayList.add(fVar.f9967s0);
        arrayList.add(fVar.f9970t0);
        arrayList.add(fVar.f9973u0);
        arrayList.add(fVar.f9982x0);
        arrayList.add(fVar.f9985y0);
        arrayList.add(fVar.f9988z0);
        arrayList.add(fVar.L0);
        arrayList.add(fVar.Q0);
        arrayList.add(fVar.M0);
        arrayList.add(fVar.O0);
        arrayList.add(fVar.N0);
        arrayList.add(fVar.P0);
        arrayList.add(fVar.R0);
        arrayList.add(fVar.f9936i);
        arrayList.add(fVar.f9939j);
        arrayList.add(fVar.f9945l);
        arrayList.add(fVar.f9972u);
        arrayList.add(fVar.f9948m);
        arrayList.add(fVar.f9951n);
        arrayList.add(fVar.f9954o);
        arrayList.add(fVar.f9957p);
        arrayList.add(fVar.f9963r);
        arrayList.add(fVar.f9966s);
        arrayList.add(fVar.f9969t);
        arrayList.add(fVar.f9978w);
        arrayList.add(fVar.f9981x);
        arrayList.add(fVar.F0);
        arrayList.add(fVar.f9917b1);
        arrayList.add(fVar.O1);
        arrayList.add(fVar.P1);
        arrayList.add(fVar.B1);
        arrayList.add(fVar.C1);
        arrayList.add(fVar.D1);
        arrayList.add(fVar.E1);
        return arrayList;
    }

    private static String M(Context context, boolean z3) {
        long j4;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        if (z3) {
            j4 = memoryInfo.totalMem;
        } else {
            j4 = memoryInfo.availMem;
        }
        return String.format("%.2fGB", Double.valueOf(j4 / 1.0E9d));
    }

    private static Point N(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point;
    }

    private static File O(Context context) {
        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, null);
        if (externalFilesDirs.length < 2) {
            return null;
        }
        return externalFilesDirs[1];
    }

    private static int P(Context context) {
        int phoneCount;
        int activeModemCount;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            activeModemCount = telephonyManager.getActiveModemCount();
            return activeModemCount;
        } else if (i4 >= 23) {
            phoneCount = telephonyManager.getPhoneCount();
            return phoneCount;
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Q(int i4) {
        return MacroDroidApplication.getInstance().getString(i4);
    }

    private static String R(Context context) {
        if (W(context)) {
            return z(O(context).getTotalSpace());
        }
        if (y()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return z(statFs.getBlockCount() * statFs.getBlockSize());
        }
        return TypeDescription.Generic.OfWildcardType.SYMBOL;
    }

    private static long S(Context context) {
        if (W(context)) {
            return O(context).getTotalSpace();
        }
        if (y()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        }
        return 0L;
    }

    private static String T() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return z(statFs.getBlockCount() * statFs.getBlockSize());
    }

    private static List<MagicTextPair> U(List<Trigger> list, boolean z3) {
        if (list != null && list.size() != 0) {
            f fVar = new f();
            ArrayList<MagicTextPair> arrayList = new ArrayList();
            int i4 = 0;
            boolean z4 = false;
            while (i4 < list.size()) {
                Trigger trigger = list.get(i4);
                i4++;
                for (int i5 = i4; i5 < list.size(); i5++) {
                    if (!trigger.getClass().equals(list.get(i5).getClass())) {
                        z4 = true;
                    }
                }
                if (trigger instanceof WebHookTrigger) {
                    o(arrayList, fVar.f9984y);
                } else if (trigger instanceof NotificationTrigger) {
                    o(arrayList, fVar.f9987z);
                    o(arrayList, fVar.A);
                    o(arrayList, fVar.B);
                    o(arrayList, fVar.C);
                    o(arrayList, fVar.F);
                    o(arrayList, fVar.G);
                    o(arrayList, fVar.H);
                    o(arrayList, fVar.D);
                    o(arrayList, fVar.E);
                } else if (trigger instanceof IncomingSMSTrigger) {
                    o(arrayList, fVar.I);
                    o(arrayList, fVar.J);
                    o(arrayList, fVar.K);
                } else if (trigger instanceof SMSSentTrigger) {
                    o(arrayList, fVar.L);
                    o(arrayList, fVar.M);
                    o(arrayList, fVar.N);
                } else if (!(trigger instanceof IncomingCallTrigger) && !(trigger instanceof OutgoingCallTrigger) && !(trigger instanceof CallEndedTrigger) && !(trigger instanceof CallActiveTrigger) && !(trigger instanceof CallMissedTrigger)) {
                    if (trigger instanceof ApplicationLaunchedTrigger) {
                        o(arrayList, fVar.O);
                        o(arrayList, fVar.P);
                    } else if (trigger instanceof ApplicationInstalledRemovedTrigger) {
                        if (((ApplicationInstalledRemovedTrigger) trigger).getApplicationInstalled()) {
                            o(arrayList, fVar.O);
                        }
                        o(arrayList, fVar.P);
                    } else if (trigger instanceof LocationTrigger) {
                        o(arrayList, fVar.Q);
                    } else if (trigger instanceof WeatherTrigger) {
                        o(arrayList, fVar.f9940j0);
                        o(arrayList, fVar.f9943k0);
                        o(arrayList, fVar.f9946l0);
                        o(arrayList, fVar.f9949m0);
                        o(arrayList, fVar.f9952n0);
                        o(arrayList, fVar.f9955o0);
                        o(arrayList, fVar.f9958p0);
                        o(arrayList, fVar.f9961q0);
                    } else if (trigger instanceof CalendarTrigger) {
                        o(arrayList, fVar.f9926e1);
                        o(arrayList, fVar.f9929f1);
                        o(arrayList, fVar.f9932g1);
                        o(arrayList, fVar.f9935h1);
                        o(arrayList, fVar.f9938i1);
                        o(arrayList, fVar.f9941j1);
                        o(arrayList, fVar.f9944k1);
                        o(arrayList, fVar.f9947l1);
                        o(arrayList, fVar.f9950m1);
                    } else if (trigger instanceof BluetoothTrigger) {
                        BluetoothTrigger bluetoothTrigger = (BluetoothTrigger) trigger;
                        if (bluetoothTrigger.getState() == 2 || bluetoothTrigger.getState() == 3) {
                            o(arrayList, fVar.f9953n1);
                        }
                    } else if (trigger instanceof UsbDeviceConnectionTrigger) {
                        o(arrayList, fVar.F1);
                        o(arrayList, fVar.G1);
                        o(arrayList, fVar.H1);
                    } else if (trigger instanceof SpotifyTrigger) {
                        o(arrayList, fVar.f9913a0);
                        o(arrayList, fVar.f9916b0);
                        o(arrayList, fVar.f9919c0);
                        o(arrayList, fVar.f9922d0);
                        o(arrayList, fVar.f9925e0);
                        o(arrayList, fVar.f9928f0);
                    } else if (trigger instanceof SystemSettingTrigger) {
                        o(arrayList, fVar.f9931g0);
                        o(arrayList, fVar.f9934h0);
                        o(arrayList, fVar.f9937i0);
                    } else if (!z3 && (trigger instanceof LogcatTrigger)) {
                        o(arrayList, fVar.K1);
                    }
                } else {
                    o(arrayList, fVar.R);
                    o(arrayList, fVar.S);
                }
            }
            if (z4) {
                for (MagicTextPair magicTextPair : arrayList) {
                    if (!magicTextPair.name.startsWith("*")) {
                        magicTextPair.name = "*" + magicTextPair.name;
                    }
                }
            } else {
                for (MagicTextPair magicTextPair2 : arrayList) {
                    if (magicTextPair2.name.startsWith("*")) {
                        magicTextPair2.name = magicTextPair2.name.substring(1);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    private static String V(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static boolean W(Context context) {
        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, null);
        if (externalFilesDirs.length >= 2 && externalFilesDirs[1] != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(String[] strArr, Activity activity, MagicTextListener magicTextListener, String str, String str2, VariableValue.Dictionary dictionary, int i4, MacroDroidVariable macroDroidVariable, Macro macro, boolean z3, boolean z4, VariableValue.DictionaryEntry[] dictionaryEntryArr, boolean z5, boolean z6, DialogInterface dialogInterface, int i5) {
        int i6;
        int i7;
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (strArr[checkedItemPosition].equals(activity.getString(R.string.variable_output_all_entries))) {
            magicTextListener.magicTextSelected(new MagicTextPair(str.replace("%s", str2), ""));
            return;
        }
        String str3 = strArr[checkedItemPosition];
        if (dictionary.isArray()) {
            i6 = R.string.variable_this_array;
        } else {
            i6 = R.string.variable_this_dictionary;
        }
        if (str3.equals(activity.getString(i6))) {
            magicTextListener.magicTextSelected(new MagicTextPair(str.replace("%s", str2), ""));
        } else if (strArr[checkedItemPosition].equals(activity.getString(R.string.variable_dictionary_array_define_indexes_or_keys_manually))) {
            VariableHelper.defineKeysManually(activity, i4, macroDroidVariable, dictionary, macro, null, null, false, null, false, new d(magicTextListener, str, str2));
        } else {
            if (!z3 && !z4) {
                i7 = 0;
            } else {
                i7 = 1;
            }
            int i8 = (checkedItemPosition - i7) - 1;
            VariableValue variable = dictionaryEntryArr[i8].getVariable();
            if (variable != null && (variable instanceof VariableValue.Dictionary)) {
                diplayDictionaryChildrenDialog(activity, str, macro, macroDroidVariable, str2 + "[" + dictionaryEntryArr[i8].getKey() + "]", (VariableValue.Dictionary) variable, magicTextListener, z5, z6, z3, z4, i4);
                return;
            }
            magicTextListener.magicTextSelected(new MagicTextPair(str.replace("%s", strArr[checkedItemPosition]), ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(MagicTextListener magicTextListener, String str, String[] strArr, DialogInterface dialogInterface, int i4) {
        magicTextListener.magicTextSelected(new MagicTextPair(str.replace("%s", strArr[((AlertDialog) dialogInterface).getListView().getCheckedItemPosition()]), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(List list, DialogInterface dialogInterface, int i4) {
        f9882a = (MagicTextPair) list.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(Activity activity, Macro macro, MagicTextListener magicTextListener, int i4, DialogInterface dialogInterface, int i5) {
        if (!x(f9882a.magicText, "[strval=%s]") && !x(f9882a.magicText, "[strlen=%s]")) {
            if (x(f9882a.magicText, "[size=%s]")) {
                displayDictionaryArrayVarSelectionDialog(activity, macro, f9882a.magicText, magicTextListener, i4);
                return;
            } else if (l0(f9882a.magicText, "[v=")) {
                String str = f9882a.magicText;
                MacroDroidVariable variableByName = MacroDroidVariableStore.getInstance().getVariableByName(str.substring(str.indexOf(61) + 1, w(f9882a.magicText)));
                if (variableByName != null && (variableByName.isDictionary() || variableByName.isArray())) {
                    diplayDictionaryChildrenDialog(activity, "[v=%s]", macro, variableByName, variableByName.getName(), variableByName.getDictionary(), magicTextListener, true, false, false, false, i4);
                    return;
                } else {
                    magicTextListener.magicTextSelected(f9882a);
                    return;
                }
            } else if (l0(f9882a.magicText, "[lv=")) {
                String str2 = f9882a.magicText;
                MacroDroidVariable variableByName2 = macro.getVariableByName(str2.substring(str2.indexOf(61) + 1, w(f9882a.magicText)));
                if (variableByName2 != null && (variableByName2.isDictionary() || variableByName2.isArray())) {
                    diplayDictionaryChildrenDialog(activity, "[lv=%s]", macro, variableByName2, variableByName2.getName(), variableByName2.getDictionary(), magicTextListener, true, false, false, false, i4);
                    return;
                } else {
                    magicTextListener.magicTextSelected(f9882a);
                    return;
                }
            } else {
                magicTextListener.magicTextSelected(f9882a);
                return;
            }
        }
        displayStringVarSelectionDialog(activity, macro, f9882a.magicText, magicTextListener, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(List list, Activity activity, Macro macro, MagicTextListener magicTextListener, int i4, DialogInterface dialogInterface, int i5) {
        ListView listView = ((AlertDialog) dialogInterface).getListView();
        MacroDroidVariable macroDroidVariable = (MacroDroidVariable) list.get(listView.getCheckedItemPosition());
        if (!macroDroidVariable.isArray() && !macroDroidVariable.isDictionary()) {
            magicTextListener.magicTextSelected(new MagicTextPair((String) listView.getAdapter().getItem(listView.getCheckedItemPosition()), ""));
        } else {
            diplayDictionaryChildrenDialog(activity, "%s", macro, macroDroidVariable, macroDroidVariable.getName(), macroDroidVariable.getDictionary(), magicTextListener, true, true, false, false, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void diplayDictionaryChildrenDialog(@androidx.annotation.NonNull final android.app.Activity r17, @androidx.annotation.NonNull java.lang.String r18, final com.arlosoft.macrodroid.macro.Macro r19, @androidx.annotation.NonNull final com.arlosoft.macrodroid.common.MacroDroidVariable r20, @androidx.annotation.NonNull final java.lang.String r21, @androidx.annotation.NonNull final com.arlosoft.macrodroid.variables.VariableValue.Dictionary r22, @androidx.annotation.NonNull final com.arlosoft.macrodroid.common.MagicText.MagicTextListener r23, final boolean r24, final boolean r25, final boolean r26, final boolean r27, final int r28) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.MagicText.diplayDictionaryChildrenDialog(android.app.Activity, java.lang.String, com.arlosoft.macrodroid.macro.Macro, com.arlosoft.macrodroid.common.MacroDroidVariable, java.lang.String, com.arlosoft.macrodroid.variables.VariableValue$Dictionary, com.arlosoft.macrodroid.common.MagicText$MagicTextListener, boolean, boolean, boolean, boolean, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
        if (r2 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void displayAndroidSettingsDialog(@androidx.annotation.NonNull android.app.Activity r10, @androidx.annotation.NonNull final java.lang.String r11, @androidx.annotation.NonNull final com.arlosoft.macrodroid.common.MagicText.MagicTextListener r12, int r13) {
        /*
            java.lang.String r0 = "name"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 95
            r3 = 0
            int r2 = r11.indexOf(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            int r2 = r2 + 1
            java.lang.String r4 = "="
            int r4 = r11.indexOf(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            java.lang.String r2 = r11.substring(r2, r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            r5.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            java.lang.String r7 = "content://settings/"
            r5.append(r7)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            r5.append(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            android.net.Uri r5 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5c
        L3e:
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            if (r4 == 0) goto L60
            int r4 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r1.add(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            goto L3e
        L50:
            r10 = move-exception
            r3 = r2
            goto L56
        L53:
            goto L5e
        L55:
            r10 = move-exception
        L56:
            if (r3 == 0) goto L5b
            r3.close()
        L5b:
            throw r10
        L5c:
            r2 = r3
        L5e:
            if (r2 == 0) goto L63
        L60:
            r2.close()
        L63:
            java.util.Collections.sort(r1)
            r0 = 0
            java.lang.String[] r2 = new java.lang.String[r0]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            androidx.appcompat.app.AlertDialog$Builder r2 = new androidx.appcompat.app.AlertDialog$Builder
            r2.<init>(r10, r13)
            r10 = 2131954390(0x7f130ad6, float:1.9545278E38)
            java.lang.String r10 = Q(r10)
            r2.setTitle(r10)
            r2.setSingleChoiceItems(r1, r0, r3)
            com.arlosoft.macrodroid.common.v r10 = new com.arlosoft.macrodroid.common.v
            r10.<init>()
            r11 = 17039370(0x104000a, float:2.42446E-38)
            r2.setPositiveButton(r11, r10)
            androidx.appcompat.app.AlertDialog r10 = r2.create()
            r10.show()
            android.view.WindowManager$LayoutParams r11 = new android.view.WindowManager$LayoutParams
            r11.<init>()
            android.view.Window r12 = r10.getWindow()
            android.view.WindowManager$LayoutParams r12 = r12.getAttributes()
            r11.copyFrom(r12)
            r12 = -1
            r11.width = r12
            android.view.Window r10 = r10.getWindow()
            r10.setAttributes(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.MagicText.displayAndroidSettingsDialog(android.app.Activity, java.lang.String, com.arlosoft.macrodroid.common.MagicText$MagicTextListener, int):void");
    }

    public static void displayDictionaryArrayVarSelectionDialog(@NonNull Activity activity, Macro macro, @NonNull String str, @NonNull MagicTextListener magicTextListener, int i4) {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList();
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
                if (macroDroidVariable.isDictionary() || macroDroidVariable.isArray()) {
                    arrayList.add(macroDroidVariable);
                }
            }
        }
        for (MacroDroidVariable macroDroidVariable2 : MacroDroidVariableStore.getInstance().getAllVariables(true)) {
            if (macroDroidVariable2.isDictionary() || macroDroidVariable2.isArray()) {
                arrayList.add(macroDroidVariable2);
            }
        }
        if (arrayList.size() == 0) {
            ToastCompat.makeText(activity, (int) R.string.no_variables_configured, 1).show();
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (MacroDroidVariable macroDroidVariable3 : arrayList) {
            arrayList2.add(new MagicTextPair(String.format("[size=%s]", macroDroidVariable3.getName()), macroDroidVariable3.getName()));
        }
        k0(activity, activity.getString(R.string.dictionary_array_size), i4, arrayList2, macro, false, magicTextListener);
    }

    public static void displayGlobalVarSelectionDialog(@NonNull Activity activity, Macro macro, @NonNull String str, @NonNull MagicTextListener magicTextListener, int i4) {
        ArrayList<MagicTextPair> arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : MacroDroidVariableStore.getInstance().getAllVariables(true)) {
            arrayList.add(new MagicTextPair(String.format("[v=%s]", macroDroidVariable.getName()), macroDroidVariable.getName()));
        }
        if (Settings.getMagicTextDefaultBrackets(activity) == DEFAULT_BRACKETS_CURLY) {
            for (MagicTextPair magicTextPair : arrayList) {
                magicTextPair.magicText = magicTextPair.magicText.replace("[", "{").replace("]", "}");
            }
        }
        k0(activity, activity.getString(R.string.global_variable), i4, arrayList, macro, false, magicTextListener);
    }

    public static void displayLocalVarSelectionDialog(@NonNull Activity activity, Macro macro, @NonNull String str, @NonNull MagicTextListener magicTextListener, int i4) {
        ArrayList<MagicTextPair> arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
            arrayList.add(new MagicTextPair(String.format("[lv=%s]", macroDroidVariable.getName()), macroDroidVariable.getName()));
        }
        if (Settings.getMagicTextDefaultBrackets(activity) == DEFAULT_BRACKETS_CURLY) {
            for (MagicTextPair magicTextPair : arrayList) {
                magicTextPair.magicText = magicTextPair.magicText.replace("[", "{").replace("]", "}");
            }
        }
        k0(activity, activity.getString(R.string.local_variable), i4, arrayList, macro, false, magicTextListener);
    }

    public static void displayNumberVariableSelectionDialog(Activity activity, Macro macro, MagicTextListener magicTextListener, int i4, IteratorType iteratorType, boolean z3) {
        if (!Settings.getShownMagicTextBracketInfo(activity)) {
            AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
            appCompatDialog.setContentView(R.layout.dialog_simple_text_message);
            appCompatDialog.setTitle(R.string.magic_text_title);
            ((TextView) appCompatDialog.findViewById(R.id.text)).setText(R.string.magic_text_brackets_information);
            ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new a(appCompatDialog, activity, macro, magicTextListener, i4, iteratorType, z3));
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
            layoutParams.width = -1;
            appCompatDialog.getWindow().setAttributes(layoutParams);
            appCompatDialog.show();
            Settings.setShownMagicTextBracketInfo(activity, true);
            return;
        }
        u(activity, macro, magicTextListener, i4, iteratorType, z3);
    }

    public static void displayNumericalVarSelectionDialog(@NonNull final Activity activity, final Macro macro, @NonNull final MagicTextListener magicTextListener, final int i4) {
        List<MacroDroidVariable> allNumericalVariablesWithChildren;
        if (macro != null) {
            allNumericalVariablesWithChildren = macro.getAllNumericalVariablesIncludingWithChildren();
        } else {
            allNumericalVariablesWithChildren = MacroDroidVariableStore.getInstance().getAllNumericalVariablesWithChildren();
        }
        final List<MacroDroidVariable> list = allNumericalVariablesWithChildren;
        if (list.size() == 0) {
            ToastCompat.makeText(activity, (int) R.string.no_integer_variables_defined, 0).show();
            return;
        }
        String[] strArr = new String[list.size()];
        for (int i5 = 0; i5 < list.size(); i5++) {
            strArr[i5] = list.get(i5).getName();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
        builder.setTitle(R.string.variable);
        builder.setSingleChoiceItems(strArr, 0, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MagicText.c0(list, activity, macro, magicTextListener, i4, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.a0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public static void displaySelectionDialog(Activity activity, MagicTextListener magicTextListener, Macro macro, int i4, IteratorType iteratorType) {
        displaySelectionDialog(activity, magicTextListener, macro, false, true, true, i4, iteratorType);
    }

    public static void displayStopwatchOptionsDialog(@NonNull Activity activity, @NonNull final String str, @NonNull final MagicTextListener magicTextListener, int i4) {
        String[] strArr = {activity.getString(R.string.seconds), activity.getString(R.string.hours_minutes_seconds)};
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
        builder.setTitle(R.string.action_stop_watch);
        builder.setSingleChoiceItems(strArr, 0, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MagicText.e0(MagicText.MagicTextListener.this, str, dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    public static void displayStringVarSelectionDialog(@NonNull Activity activity, Macro macro, @NonNull String str, @NonNull MagicTextListener magicTextListener, int i4) {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList();
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariablesSorted()) {
                if (macroDroidVariable.isString() || macroDroidVariable.getHasStringChildren()) {
                    arrayList.add(macroDroidVariable);
                }
            }
            for (MacroDroidVariable macroDroidVariable2 : MacroDroidVariableStore.getInstance().getAllVariables(true)) {
                if (macroDroidVariable2.isString() || macroDroidVariable2.getHasStringChildren()) {
                    arrayList.add(macroDroidVariable2);
                }
            }
        } else {
            for (MacroDroidVariable macroDroidVariable3 : MacroDroidVariableStore.getInstance().getAllVariables(true)) {
                if (macroDroidVariable3.isString() || macroDroidVariable3.getHasStringChildren()) {
                    arrayList.add(macroDroidVariable3);
                }
            }
        }
        if (arrayList.size() == 0) {
            ToastCompat.makeText(activity, (int) R.string.no_string_variables_defined, 1).show();
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (MacroDroidVariable macroDroidVariable4 : arrayList) {
            arrayList2.add(new MagicTextPair(String.format(str, macroDroidVariable4.getName()), macroDroidVariable4.getName()));
        }
        k0(activity, activity.getString(R.string.string_var_length), i4, arrayList2, macro, false, magicTextListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(MagicTextListener magicTextListener, String str, DialogInterface dialogInterface, int i4) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition == 0) {
            magicTextListener.magicTextSelected(new MagicTextPair(str, ""));
        } else if (checkedItemPosition == 1) {
            magicTextListener.magicTextSelected(new MagicTextPair(str.replace("stopwatch=", "stopwatchtime="), ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(ListView listView, MagicTextAdapter magicTextAdapter, Activity activity, int i4, MagicTextListener magicTextListener, Macro macro, AppCompatDialog appCompatDialog, View view) {
        if (listView.getCount() == 0) {
            return;
        }
        MagicTextPair magicTextPair = magicTextAdapter.getMagicTextPair(listView.getCheckedItemPosition());
        f9882a = magicTextPair;
        if (x(magicTextPair.magicText, "[stringmanipulation]")) {
            StringManipulation.showTextManipulationOptions(activity, i4, magicTextListener);
        } else if (l0(f9882a.magicText, "[stopwatch=")) {
            displayStopwatchOptionsDialog(activity, f9882a.magicText, magicTextListener, i4);
        } else if (l0(f9882a.magicText, "[setting_")) {
            displayAndroidSettingsDialog(activity, f9882a.magicText, magicTextListener, i4);
        } else if (x(f9882a.magicText, "[lv=%s]")) {
            displayLocalVarSelectionDialog(activity, macro, f9882a.magicText, magicTextListener, i4);
        } else if (x(f9882a.magicText, "[v=%s]")) {
            displayGlobalVarSelectionDialog(activity, macro, f9882a.magicText, magicTextListener, i4);
        } else if (!x(f9882a.magicText, "[strval=%s]") && !x(f9882a.magicText, "[strlen=%s]")) {
            if (x(f9882a.magicText, "[size=%s]")) {
                displayDictionaryArrayVarSelectionDialog(activity, macro, f9882a.magicText, magicTextListener, i4);
            } else if (!x(f9882a.magicText, "[fg_app_name]") && !x(f9882a.magicText, "[fg_app_package]")) {
                if (l0(f9882a.magicText, "[v=")) {
                    String str = f9882a.magicText;
                    MacroDroidVariable variableByName = MacroDroidVariableStore.getInstance().getVariableByName(str.substring(str.indexOf(61) + 1, w(f9882a.magicText)));
                    if (variableByName != null && (variableByName.isDictionary() || variableByName.isArray())) {
                        diplayDictionaryChildrenDialog(activity, "[v=%s]", macro, variableByName, variableByName.getName(), variableByName.getDictionary(), magicTextListener, false, false, true, false, i4);
                    } else {
                        magicTextListener.magicTextSelected(f9882a);
                    }
                } else if (l0(f9882a.magicText, "[lv=")) {
                    String str2 = f9882a.magicText;
                    MacroDroidVariable variableByName2 = macro.getVariableByName(str2.substring(str2.indexOf(61) + 1, w(f9882a.magicText)));
                    if (variableByName2 != null && (variableByName2.isDictionary() || variableByName2.isArray())) {
                        diplayDictionaryChildrenDialog(activity, "[lv=%s]", macro, variableByName2, variableByName2.getName(), variableByName2.getDictionary(), magicTextListener, false, false, true, false, i4);
                    } else {
                        magicTextListener.magicTextSelected(f9882a);
                    }
                } else {
                    magicTextListener.magicTextSelected(f9882a);
                }
            } else if (!Util.isMacroDroidAccessibilityEnabled(activity)) {
                PermissionsHelper.showAccessibilityRequiredDialog(activity, false, false, false, false, false);
                magicTextListener.magicTextSelected(f9882a);
            } else {
                magicTextListener.magicTextSelected(f9882a);
            }
        } else {
            displayStringVarSelectionDialog(activity, macro, f9882a.magicText, magicTextListener, i4);
        }
        appCompatDialog.dismiss();
    }

    private static String h0(String str, String str2, String str3, boolean z3) {
        int indexOf;
        if (str3 == null) {
            return str;
        }
        try {
            String replace = str.replace("[", "{").replace("]", "}");
            String replace2 = str2.replace("[", "{").replace("]", "}");
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!replace.contains(replace2)) {
                return str;
            }
            if (z3) {
                try {
                    str3 = URLEncoder.encode(str3, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
            }
            StringBuffer stringBuffer = new StringBuffer(replace);
            StringBuffer stringBuffer2 = new StringBuffer(str);
            ArrayList arrayList = new ArrayList();
            do {
                indexOf = stringBuffer.indexOf(replace2);
                if (indexOf >= 0) {
                    arrayList.add(Integer.valueOf(indexOf));
                    int length = replace2.length() + indexOf;
                    stringBuffer.delete(indexOf, length);
                    stringBuffer2.delete(indexOf, length);
                    continue;
                }
            } while (indexOf >= 0);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                stringBuffer2.insert(((Integer) arrayList.get(size)).intValue(), str3);
            }
            return stringBuffer2.toString();
        } catch (OutOfMemoryError e4) {
            SystemLog.logError("Out of memory when attempting to apply magic text: " + e4.toString());
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String i0(android.content.Context r12, java.lang.String r13, com.arlosoft.macrodroid.triggers.TriggerContextInfo r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 1329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.MagicText.i0(android.content.Context, java.lang.String, com.arlosoft.macrodroid.triggers.TriggerContextInfo, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x020d A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0223 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String j0(java.util.List<com.arlosoft.macrodroid.common.MacroDroidVariable> r21, java.lang.String r22, java.lang.String r23, boolean r24, java.lang.String r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.MagicText.j0(java.util.List, java.lang.String, java.lang.String, boolean, java.lang.String, boolean):java.lang.String");
    }

    private static void k0(final Activity activity, String str, final int i4, List<MagicTextPair> list, final Macro macro, boolean z3, final MagicTextListener magicTextListener) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
        appCompatDialog.setContentView(R.layout.dialog_magic_text_selection);
        appCompatDialog.setTitle(str);
        final ListView listView = (ListView) appCompatDialog.findViewById(R.id.listView);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.multiTriggerWarning);
        EditText editText = (EditText) appCompatDialog.findViewById(R.id.searchText);
        final MagicTextAdapter magicTextAdapter = new MagicTextAdapter(activity, list);
        listView.setAdapter((ListAdapter) magicTextAdapter);
        int i5 = 0;
        listView.setItemChecked(0, true);
        f9882a = list.get(0);
        if (!z3) {
            i5 = 8;
        }
        textView.setVisibility(i5);
        editText.addTextChangedListener(new c(magicTextAdapter));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.common.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.common.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MagicText.g0(listView, magicTextAdapter, activity, i4, magicTextListener, macro, appCompatDialog, view);
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -1;
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    private static boolean l0(String str, String str2) {
        if (!str.startsWith(str2) && !str.startsWith(str2.replace("[", "{").replace("]", "}"))) {
            return false;
        }
        return true;
    }

    private static void o(List<MagicTextPair> list, MagicTextPair magicTextPair) {
        if (!list.contains(magicTextPair)) {
            list.add(magicTextPair);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String p(String str) {
        if (str != null && str.length() != 0) {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String q(com.arlosoft.macrodroid.variables.VariableValue.Dictionary r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.arlosoft.macrodroid.common.MagicText.e r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.MagicText.q(com.arlosoft.macrodroid.variables.VariableValue$Dictionary, java.lang.String, java.lang.String, java.lang.String, com.arlosoft.macrodroid.common.MagicText$e, boolean):java.lang.String");
    }

    private static boolean r(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (!wifiManager.isWifiEnabled() || wifiManager.getConnectionInfo().getNetworkId() == -1) {
            return false;
        }
        return true;
    }

    public static String replaceMagicText(Context context, String str, TriggerContextInfo triggerContextInfo, Macro macro) {
        return replaceMagicText(context, str, triggerContextInfo, macro, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0699  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x096b  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x097c  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0a0c  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0a2b  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0a77  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0a81  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0a9a  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0ab5  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0aef  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0b28  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0b61  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0b9b  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0bcd  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0bd6  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0c0e  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0c48 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0c6e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0c87 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0cb1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0cd6  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0d0b  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0d1d  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0d26  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0d36  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0d46  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0d56  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0d6a  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0dbe  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0dca  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0dd0  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0e11  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0e33  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0e3c  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0e54  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0e6c  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0e7f  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0e91  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0ea3  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x0eb9  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0ecb  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0ee1  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0ef3  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x0f09  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0f1b  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0f31  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0f69  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x0f9c  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0fa7  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x10ca  */
    /* JADX WARN: Removed duplicated region for block: B:586:0x05a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:591:0x0fc5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:593:0x099d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:595:0x09db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v9, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String replaceNonVariableMagicText(android.content.Context r23, java.lang.String r24, com.arlosoft.macrodroid.triggers.TriggerContextInfo r25, boolean r26, com.arlosoft.macrodroid.macro.Macro r27, boolean r28, java.util.Locale r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 4365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.MagicText.replaceNonVariableMagicText(android.content.Context, java.lang.String, com.arlosoft.macrodroid.triggers.TriggerContextInfo, boolean, com.arlosoft.macrodroid.macro.Macro, boolean, java.util.Locale, boolean):java.lang.String");
    }

    private static boolean s(String str, String str2) {
        try {
            if (!str.contains(str2.substring(1, str2.length() - 1))) {
                return false;
            }
            if (!str.replace("[", "{").replace("]", "}").contains(str2.replace("[", "{").replace("]", "}"))) {
                if (!str.contains(str2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int t(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.split(Pattern.quote(str2), -1).length - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(final Activity activity, final Macro macro, final MagicTextListener magicTextListener, final int i4, IteratorType iteratorType, boolean z3) {
        final List<MagicTextPair> L = L(macro, iteratorType, z3);
        if (Settings.getMagicTextDefaultBrackets(activity) == DEFAULT_BRACKETS_CURLY) {
            for (MagicTextPair magicTextPair : L) {
                magicTextPair.magicText = magicTextPair.magicText.replace("[", "{").replace("]", "}");
            }
        }
        f9882a = L.get(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
        builder.setTitle(R.string.action_set_variable_select);
        builder.setSingleChoiceItems(K(L), 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MagicText.Z(L, dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MagicText.b0(activity, macro, magicTextListener, i4, dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(Activity activity, MagicTextListener magicTextListener, @Nullable Macro macro, boolean z3, boolean z4, boolean z5, int i4, boolean z6, IteratorType iteratorType) {
        boolean z7;
        List<MagicTextPair> U;
        List<MagicTextPair> J = J(activity, z3, z5, macro, iteratorType);
        int i5 = 0;
        if (z4 && macro != null && (U = U(macro.getTriggerList(), z6)) != null) {
            for (int size = U.size() - 1; size >= 0; size--) {
                J.add(0, U.get(size));
            }
        }
        if (macro != null) {
            boolean z8 = false;
            while (i5 < macro.getTriggerList().size()) {
                Trigger trigger = macro.getTriggerList().get(i5);
                i5++;
                int i6 = i5;
                while (true) {
                    if (i6 >= macro.getTriggerList().size()) {
                        break;
                    } else if (!trigger.getClass().equals(macro.getTriggerList().get(i6).getClass())) {
                        z8 = true;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            z7 = z8;
        } else {
            z7 = false;
        }
        if (Settings.getMagicTextDefaultBrackets(activity) == DEFAULT_BRACKETS_CURLY) {
            for (MagicTextPair magicTextPair : J) {
                magicTextPair.magicText = magicTextPair.magicText.replace("[", "{").replace("]", "}");
            }
        }
        k0(activity, activity.getString(R.string.select_option), i4, J, macro, z7, magicTextListener);
    }

    private static int w(String str) {
        if (str.startsWith("[")) {
            return str.indexOf("]");
        }
        return str.indexOf("}");
    }

    private static boolean x(String str, String str2) {
        if (!str.equals(str2) && !str.equals(str2.replace("[", "{").replace("]", "}"))) {
            return false;
        }
        return true;
    }

    private static boolean y() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static String z(long j4) {
        String str;
        if (j4 >= 1024) {
            j4 /= 1024;
            if (j4 >= 1024) {
                j4 /= 1024;
                str = "MB";
            } else {
                str = "KB";
            }
            if (j4 >= 1024) {
                j4 /= 1024;
                str = "GB";
            }
        } else {
            str = null;
        }
        StringBuilder sb = new StringBuilder(Long.toString(j4));
        for (int length = sb.length() - 3; length > 0; length -= 3) {
            sb.insert(length, ',');
        }
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void displaySelectionDialog(Activity activity, MagicTextListener magicTextListener, Macro macro, int i4, boolean z3, IteratorType iteratorType) {
        displaySelectionDialog(activity, magicTextListener, macro, false, true, true, i4, z3, iteratorType);
    }

    public static String replaceMagicText(Context context, String str, TriggerContextInfo triggerContextInfo, Macro macro, boolean z3) {
        return replaceMagicText(context, str, triggerContextInfo, false, macro, z3);
    }

    public static void displaySelectionDialog(Activity activity, MagicTextListener magicTextListener, @Nullable Macro macro, boolean z3, boolean z4, boolean z5, int i4, IteratorType iteratorType) {
        displaySelectionDialog(activity, magicTextListener, macro, z3, z4, z5, i4, false, iteratorType);
    }

    public static String replaceMagicText(Context context, String str, TriggerContextInfo triggerContextInfo, boolean z3, Macro macro) {
        return replaceMagicText(context, str, triggerContextInfo, z3, macro, false);
    }

    public static void displaySelectionDialog(Activity activity, MagicTextListener magicTextListener, @Nullable Macro macro, boolean z3, boolean z4, boolean z5, int i4, boolean z6, IteratorType iteratorType) {
        if (!Settings.getShownMagicTextBracketInfo(activity)) {
            AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
            appCompatDialog.setContentView(R.layout.dialog_simple_text_message);
            appCompatDialog.setTitle(R.string.magic_text_title);
            ((TextView) appCompatDialog.findViewById(R.id.text)).setText(R.string.magic_text_brackets_information);
            ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new b(appCompatDialog, activity, magicTextListener, macro, z3, z4, z5, i4, z6, iteratorType));
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
            layoutParams.width = -1;
            appCompatDialog.getWindow().setAttributes(layoutParams);
            appCompatDialog.show();
            Settings.setShownMagicTextBracketInfo(activity, true);
            return;
        }
        v(activity, magicTextListener, macro, z3, z4, z5, i4, z6, iteratorType);
    }

    public static String replaceMagicText(Context context, String str, TriggerContextInfo triggerContextInfo, boolean z3, Macro macro, boolean z4) {
        return replaceMagicText(context, str, triggerContextInfo, z3, macro, z4, Locale.getDefault(), false);
    }

    public static String replaceMagicText(Context context, String str, TriggerContextInfo triggerContextInfo, boolean z3, Macro macro, boolean z4, boolean z5) {
        return replaceMagicText(context, str, triggerContextInfo, z3, macro, z4, Locale.getDefault(), z5);
    }

    @SuppressLint({"NewApi"})
    public static String replaceMagicText(Context context, String str, TriggerContextInfo triggerContextInfo, boolean z3, Macro macro, boolean z4, Locale locale, boolean z5) {
        String str2;
        if (str == null) {
            return "";
        }
        if (str.contains("}") || str.contains("]")) {
            String replaceNonVariableMagicText = replaceNonVariableMagicText(context, str, triggerContextInfo, z3, macro, z4, locale, z5);
            if (macro != null) {
                List<MacroDroidVariable> localVariables = macro.getLocalVariables();
                String j02 = j0(localVariables, replaceNonVariableMagicText, replaceNonVariableMagicText, z3, "[lv=%s]", z5);
                int t3 = t(j02, "{lv=") + t(j02, "[lv=") + t(j02, "size=") + t(j02, "strlen=") + t(j02, "strval=");
                str2 = j02;
                for (int i4 = 0; i4 < t3; i4++) {
                    if (str2.contains("[lv=") || str2.contains("{lv=") || str2.contains("size=") || str2.contains("strlen=") || str2.contains("strval=")) {
                        str2 = j0(localVariables, replaceNonVariableMagicText, str2, z3, "[lv=%s]", z5);
                    }
                }
            } else {
                str2 = replaceNonVariableMagicText;
            }
            List<MacroDroidVariable> allVariables = MacroDroidVariableStore.getInstance().getAllVariables(false);
            String j03 = j0(allVariables, replaceNonVariableMagicText, str2, z3, "[v=%s]", z5);
            int t4 = t(j03, "{v=") + t(j03, "[v=") + t(j03, "size=") + t(j03, "strlen=") + t(j03, "strval=");
            String str3 = j03;
            for (int i5 = 0; i5 < t4; i5++) {
                if (str3.contains("{v=") || str3.contains("[v=") || str3.contains("size=") || str3.contains("strlen=") || str3.contains("strval=")) {
                    str3 = j0(allVariables, replaceNonVariableMagicText, str3, z3, "[v=%s]", z5);
                }
            }
            return replaceNonVariableMagicText(context, (macro == null || !(str3.contains("lv=") || str3.contains("size=") || str3.contains("strlen=") || str3.contains("strval="))) ? str3 : j0(macro.getLocalVariables(), replaceNonVariableMagicText, str3, z3, "[lv=%s]", z5), triggerContextInfo, z3, macro, z4, locale, z5);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MagicTextAdapter f9903a;

        c(MagicTextAdapter magicTextAdapter) {
            this.f9903a = magicTextAdapter;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            this.f9903a.getFilter().filter(charSequence);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
