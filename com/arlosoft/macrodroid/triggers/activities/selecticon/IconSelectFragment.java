package com.arlosoft.macrodroid.triggers.activities.selecticon;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindDimen;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.events.CloseDrawerEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.IconSelectedEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermListener;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.IconPackManager;
import com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.Response;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.CustomMaxSize;
import com.yalantis.ucrop.UCrop;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;
import me.drakeet.support.toast.ToastCompat;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class IconSelectFragment extends Fragment implements SearchTermListener {
    public static final String EXTRA_ICON_PACK_NAME = "IconPackName";
    public static final String EXTRA_ICON_TYPES = "IconTypes";
    public static final String EXTRA_RETURN_RESULT = "ReturnResult";
    public static final int ICON_TYPE_MACRODROID = 2;
    public static final int ICON_TYPE_MATERIAL = 4;
    public static final int ICON_TYPE_NOTIFICATION = 3;
    public static final int ICON_TYPE_USER = 1;

    /* renamed from: b  reason: collision with root package name */
    private IconPackManager.IconPack f14599b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f14600c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f14601d;

    /* renamed from: e  reason: collision with root package name */
    private Button f14602e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14603f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Integer> f14604g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f14605h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f14606i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private int f14607j;

    /* renamed from: k  reason: collision with root package name */
    private SearchTermProvider f14608k;

    /* renamed from: l  reason: collision with root package name */
    private List<com.arlosoft.macrodroid.triggers.activities.selecticon.a> f14609l;

    /* renamed from: m  reason: collision with root package name */
    private SelectIconAdapter f14610m;

    /* renamed from: n  reason: collision with root package name */
    private a f14611n;
    @BindDimen(R.dimen.user_icon_size)
    int userIconSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void t() {
        try {
            FileUtils.deleteDirectory(new File(Environment.getExternalStorageDirectory(), Constants.RX_PAPARAZZO_DIRECTORY));
        } catch (Exception unused) {
        }
        try {
            FileUtils.deleteDirectory(new File(requireContext().getExternalFilesDir(null), Constants.RX_PAPARAZZO_DIRECTORY));
        } catch (Exception unused2) {
        }
    }

    private void r(int i4, String str) {
        a aVar = this.f14611n;
        if (aVar != null) {
            aVar.cancel(true);
        }
        a aVar2 = new a(getActivity().getApplicationContext(), i4, str);
        this.f14611n = aVar2;
        aVar2.execute((Object[]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(int i4, DialogInterface dialogInterface, int i5) {
        try {
            new File(this.f14605h.get(i4)).delete();
            r(this.f14607j, "");
        } catch (Exception e4) {
            SystemLog.logError("Failed to delete user icon: " + e4.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(Response response) throws Exception {
        if (response.resultCode() != -1) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(((FileData) response.data()).getFile().getAbsolutePath(), options);
        int i4 = this.userIconSize;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i4, i4, true);
        File userIconDir = com.arlosoft.macrodroid.utils.FileUtils.getUserIconDir(getContext());
        if (!userIconDir.exists()) {
            userIconDir.mkdirs();
        }
        File file = new File(userIconDir, UUID.randomUUID() + ".png");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        r(this.f14607j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(Throwable th) throws Exception {
        Context context = getContext();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (getString(R.string.error) + ": " + th.toString()), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        EventBusUtils.getEventBus().post(new CloseDrawerEvent());
        UCrop.Options options = new UCrop.Options();
        options.withAspectRatio(1.0f, 1.0f);
        options.setCompressionFormat(Bitmap.CompressFormat.PNG);
        options.setToolbarTitle(getString(R.string.edit_image));
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        ((RxPaparazzo.SingleSelectionBuilder) ((RxPaparazzo.SingleSelectionBuilder) ((RxPaparazzo.SingleSelectionBuilder) RxPaparazzo.single(getActivity()).crop(options)).size(new CustomMaxSize(point.x / 2))).useInternalStorage()).usingGallery().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                IconSelectFragment.this.t();
            }
        }).subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IconSelectFragment.this.u((Response) obj);
            }
        }, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IconSelectFragment.this.v((Throwable) obj);
            }
        });
    }

    public void handleLongClick(final int i4) {
        if (this.f14607j == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog);
            builder.setTitle(R.string.delete_icon);
            builder.setMessage(R.string.delete_icon_confirm);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    IconSelectFragment.this.s(i4, dialogInterface, i5);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (requireActivity() instanceof SearchTermProvider) {
            SearchTermProvider searchTermProvider = (SearchTermProvider) requireActivity();
            this.f14608k = searchTermProvider;
            searchTermProvider.addSearchTermListener(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.select_icon, viewGroup, false);
        ButterKnife.bind(this, viewGroup2);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f14607j = arguments.getInt(EXTRA_ICON_TYPES);
            this.f14603f = arguments.getBoolean(EXTRA_RETURN_RESULT, true);
            String string = arguments.getString(EXTRA_ICON_PACK_NAME);
            if (string != null) {
                IconPackManager iconPackManager = new IconPackManager();
                iconPackManager.setContext(getContext().getApplicationContext());
                this.f14599b = iconPackManager.getAvailableIconPacks(false).get(string);
            }
        } else {
            this.f14607j = 0;
        }
        this.f14600c = (RecyclerView) viewGroup2.findViewById(R.id.select_icon_list);
        this.f14601d = (ProgressBar) viewGroup2.findViewById(R.id.progress_spinner);
        Button button = (Button) viewGroup2.findViewById(R.id.add_user_icon_button);
        this.f14602e = button;
        if (this.f14607j == 1) {
            button.setVisibility(0);
        }
        r(this.f14607j, "");
        this.f14602e.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IconSelectFragment.this.w(view);
            }
        });
        return viewGroup2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        setHasOptionsMenu(true);
        SearchTermProvider searchTermProvider = this.f14608k;
        if (searchTermProvider != null) {
            searchTermProvider.removeSearchTermListener(this);
            this.f14608k = null;
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermListener
    public void onSearchTermUpdated(@NonNull String str) {
        r(this.f14607j, str);
    }

    public void setIcon(int i4) {
        if (this.f14603f) {
            Intent intent = new Intent();
            intent.putExtra(Util.DRAWABLE_ID_EXTRA, this.f14604g.get(i4).intValue());
            intent.putExtra(Util.DRAWABLE_NAME_EXTRA, this.f14605h.get(i4));
            intent.putExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA, this.f14606i.get(i4));
            getActivity().setResult(-1, intent);
            getActivity().finish();
            return;
        }
        EventBusUtils.getEventBus().post(new IconSelectedEvent(this.f14606i.get(i4), this.f14605h.get(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final int f14612a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14613b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Integer> f14614c;

        /* renamed from: d  reason: collision with root package name */
        private String f14615d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0128a implements Runnable {
            RunnableC0128a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IconSelectFragment.this.f14610m.updateItems(IconSelectFragment.this.f14604g, IconSelectFragment.this.f14606i, IconSelectFragment.this.f14605h);
            }
        }

        public a(Context context, int i4, String str) {
            ArrayList arrayList = new ArrayList();
            this.f14614c = arrayList;
            this.f14615d = str;
            this.f14612a = i4;
            this.f14613b = false;
            Macro macro = new Macro();
            arrayList.add(Integer.valueOf((int) R.drawable.active_icon_new));
            arrayList.add(Integer.valueOf((int) R.drawable.active_icon_new_alternative));
            for (SelectableItemInfo selectableItemInfo : Trigger.getAllTriggersInfo(context)) {
                int icon = selectableItemInfo.getIcon();
                if (!this.f14614c.contains(Integer.valueOf(icon))) {
                    this.f14614c.add(Integer.valueOf(icon));
                }
            }
            for (SelectableItemInfo selectableItemInfo2 : com.arlosoft.macrodroid.action.Action.getAllActionsInfo(context, macro, true)) {
                int icon2 = selectableItemInfo2.getIcon();
                if (!this.f14614c.contains(Integer.valueOf(icon2))) {
                    this.f14614c.add(Integer.valueOf(icon2));
                }
            }
            for (SelectableItemInfo selectableItemInfo3 : Constraint.getAllConstraintsInfo(context, macro, false)) {
                if (!this.f14614c.contains(Integer.valueOf(selectableItemInfo3.getIcon()))) {
                    this.f14614c.add(Integer.valueOf(selectableItemInfo3.getIcon()));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            Field[] fields;
            boolean z3;
            Field[] fields2;
            boolean z4;
            Field[] fields3;
            boolean z5;
            File[] listFiles;
            String attributeValue;
            FragmentActivity activity = IconSelectFragment.this.getActivity();
            if (activity == null) {
                return null;
            }
            IconSelectFragment.this.f14604g.clear();
            IconSelectFragment.this.f14605h.clear();
            IconSelectFragment.this.f14606i.clear();
            try {
                PackageManager packageManager = activity.getApplicationContext().getPackageManager();
                if (IconSelectFragment.this.f14599b != null) {
                    IconSelectFragment.this.f14599b.load();
                    try {
                        Resources resourcesForApplication = IconSelectFragment.this.getActivity().getPackageManager().getResourcesForApplication(IconSelectFragment.this.f14599b.packageName);
                        XmlResourceParser xml = resourcesForApplication.getXml(resourcesForApplication.getIdentifier("appfilter", "xml", IconSelectFragment.this.f14599b.packageName));
                        TreeSet<String> treeSet = new TreeSet();
                        while (xml.getEventType() != 1) {
                            try {
                                if (xml.getEventType() == 2 && xml.getName().equals("item") && (attributeValue = xml.getAttributeValue(null, "drawable")) != null && (TextUtils.isEmpty(this.f14615d) || attributeValue.contains(this.f14615d))) {
                                    treeSet.add(attributeValue);
                                }
                                xml.next();
                            } catch (XmlPullParserException e4) {
                                e4.printStackTrace();
                            }
                        }
                        for (String str : treeSet) {
                            int identifier = resourcesForApplication.getIdentifier(str, "drawable", IconSelectFragment.this.f14599b.packageName);
                            if (identifier != 0) {
                                IconSelectFragment.this.f14605h.add(str);
                                IconSelectFragment.this.f14606i.add(IconSelectFragment.this.f14599b.packageName);
                                IconSelectFragment.this.f14604g.add(Integer.valueOf(identifier));
                            }
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    int i4 = this.f14612a;
                    if (i4 == 2) {
                        for (Field field : R.drawable.class.getFields()) {
                            int i5 = field.getInt(null);
                            String name = field.getName();
                            if (name.startsWith("notification_icon_")) {
                                if (TextUtils.isEmpty(this.f14615d) || name.contains(this.f14615d)) {
                                    IconSelectFragment.this.f14604g.add(Integer.valueOf(field.getInt(null)));
                                    IconSelectFragment.this.f14605h.add(field.getName());
                                    IconSelectFragment.this.f14606i.add(null);
                                }
                            } else if (!name.startsWith("not_icon")) {
                                Iterator<Integer> it = this.f14614c.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    } else if (it.next().intValue() == i5) {
                                        if (TextUtils.isEmpty(this.f14615d) || name.contains(this.f14615d)) {
                                            z5 = true;
                                        }
                                    }
                                }
                            }
                            z5 = false;
                            if (z5) {
                                IconSelectFragment.this.f14604g.add(Integer.valueOf(i5));
                                IconSelectFragment.this.f14605h.add(field.getName());
                                IconSelectFragment.this.f14606i.add(BuildConfig.APPLICATION_ID);
                            }
                        }
                    } else if (i4 == 3) {
                        for (Field field2 : R.drawable.class.getFields()) {
                            String name2 = field2.getName();
                            if (name2.startsWith("not_icon_") && (TextUtils.isEmpty(this.f14615d) || name2.contains(this.f14615d))) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                IconSelectFragment.this.f14604g.add(Integer.valueOf(field2.getInt(null)));
                                IconSelectFragment.this.f14605h.add(field2.getName());
                                IconSelectFragment.this.f14606i.add(null);
                            }
                        }
                    } else if (i4 == 0) {
                        try {
                            if (IconSelectFragment.this.f14609l == null) {
                                IconSelectFragment.this.f14609l = new ArrayList();
                                for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(0)) {
                                    if (applicationInfo.icon > 0) {
                                        IconSelectFragment.this.f14609l.add(new com.arlosoft.macrodroid.triggers.activities.selecticon.a(applicationInfo.icon, applicationInfo.packageName, applicationInfo.loadLabel(packageManager).toString()));
                                    }
                                }
                            }
                            for (com.arlosoft.macrodroid.triggers.activities.selecticon.a aVar : IconSelectFragment.this.f14609l) {
                                if (TextUtils.isEmpty(this.f14615d) || aVar.f14636c.toLowerCase().contains(this.f14615d.toLowerCase())) {
                                    IconSelectFragment.this.f14604g.add(Integer.valueOf(aVar.f14634a));
                                    IconSelectFragment.this.f14605h.add(aVar.f14635b);
                                    IconSelectFragment.this.f14606i.add(aVar.f14635b);
                                }
                            }
                        } catch (Exception unused2) {
                            this.f14613b = true;
                        }
                    } else if (i4 == 4) {
                        for (Field field3 : R.drawable.class.getFields()) {
                            String name3 = field3.getName();
                            if (name3.startsWith("material_") && (TextUtils.isEmpty(this.f14615d) || name3.contains(this.f14615d))) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                IconSelectFragment.this.f14604g.add(Integer.valueOf(field3.getInt(null)));
                                IconSelectFragment.this.f14605h.add(field3.getName());
                                IconSelectFragment.this.f14606i.add(null);
                            }
                        }
                    }
                }
                if (this.f14612a == 1) {
                    File userIconDir = com.arlosoft.macrodroid.utils.FileUtils.getUserIconDir(IconSelectFragment.this.getContext());
                    if (userIconDir.exists() && (listFiles = userIconDir.listFiles()) != null) {
                        for (File file : listFiles) {
                            if (TextUtils.isEmpty(this.f14615d) || file.getName().toLowerCase().contains(this.f14615d.toLowerCase())) {
                                IconSelectFragment.this.f14605h.add(file.getAbsolutePath());
                                IconSelectFragment.this.f14606i.add(Constants.USER_ICON_OPTION_PACKAGE);
                                IconSelectFragment.this.f14604g.add(0);
                            }
                        }
                    }
                }
            } catch (IllegalAccessException e5) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("IconSelectFragment: IllegalAccessException when selecting icon: " + e5.getMessage()));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r7) {
            if (!isCancelled()) {
                IconSelectFragment.this.f14601d.setVisibility(8);
                if (IconSelectFragment.this.getActivity() != null && !IconSelectFragment.this.getActivity().isFinishing()) {
                    int dimensionPixelSize = IconSelectFragment.this.getResources().getDimensionPixelSize(R.dimen.select_icon_size);
                    Display defaultDisplay = IconSelectFragment.this.getActivity().getWindowManager().getDefaultDisplay();
                    Point point = new Point();
                    defaultDisplay.getSize(point);
                    if (IconSelectFragment.this.f14610m == null) {
                        IconSelectFragment iconSelectFragment = IconSelectFragment.this;
                        iconSelectFragment.f14610m = new SelectIconAdapter(iconSelectFragment, iconSelectFragment.f14604g, IconSelectFragment.this.f14606i, IconSelectFragment.this.f14605h);
                        IconSelectFragment.this.f14600c.setLayoutManager(new GridLayoutManager(IconSelectFragment.this.getActivity(), point.x / dimensionPixelSize));
                        IconSelectFragment.this.f14600c.setAdapter(IconSelectFragment.this.f14610m);
                    } else {
                        IconSelectFragment.this.f14600c.post(new RunnableC0128a());
                    }
                    if (this.f14613b) {
                        ToastCompat.makeText(IconSelectFragment.this.getActivity().getApplicationContext(), (CharSequence) IconSelectFragment.this.getString(R.string.android_issue_requesting_installed_apps), 1).show();
                    }
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            IconSelectFragment.this.f14601d.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Void... voidArr) {
        }
    }
}
