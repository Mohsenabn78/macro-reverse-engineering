package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";

    /* renamed from: b  reason: collision with root package name */
    static final boolean f194b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a  reason: collision with root package name */
    private final c f195a;

    /* loaded from: classes.dex */
    private static class CustomActionResultReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f197d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f198e;

        /* renamed from: f  reason: collision with root package name */
        private final CustomActionCallback f199f;

        CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.f197d = str;
            this.f198e = bundle;
            this.f199f = customActionCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i4, Bundle bundle) {
            if (this.f199f == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        Log.w("MediaBrowserCompat", "Unknown result code: " + i4 + " (extras=" + this.f198e + ", resultData=" + bundle + ")");
                        return;
                    }
                    this.f199f.onProgressUpdate(this.f197d, this.f198e, bundle);
                    return;
                }
                this.f199f.onResult(this.f197d, this.f198e, bundle);
                return;
            }
            this.f199f.onError(this.f197d, this.f198e, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ItemReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f202d;

        /* renamed from: e  reason: collision with root package name */
        private final ItemCallback f203e;

        ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.f202d = str;
            this.f203e = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i4, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i4 == 0 && bundle != null && bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
                if (parcelable != null && !(parcelable instanceof MediaItem)) {
                    this.f203e.onError(this.f202d);
                    return;
                } else {
                    this.f203e.onItemLoaded((MediaItem) parcelable);
                    return;
                }
            }
            this.f203e.onError(this.f202d);
        }
    }

    /* loaded from: classes.dex */
    private static class SearchResultReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f206d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f207e;

        /* renamed from: f  reason: collision with root package name */
        private final SearchCallback f208f;

        SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.f206d = str;
            this.f207e = bundle;
            this.f208f = searchCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i4, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i4 == 0 && bundle != null && bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
                if (parcelableArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add((MediaItem) parcelable);
                    }
                    this.f208f.onSearchResult(this.f206d, this.f207e, arrayList);
                    return;
                }
                this.f208f.onError(this.f206d, this.f207e);
                return;
            }
            this.f208f.onError(this.f206d, this.f207e);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SubscriptionCallback {

        /* renamed from: a  reason: collision with root package name */
        final MediaBrowser.SubscriptionCallback f209a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f210b = new Binder();

        /* renamed from: c  reason: collision with root package name */
        WeakReference<i> f211c;

        @RequiresApi(21)
        /* loaded from: classes.dex */
        private class a extends MediaBrowser.SubscriptionCallback {
            a() {
            }

            List<MediaItem> a(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i4 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int i5 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i4 == -1 && i5 == -1) {
                    return list;
                }
                int i6 = i5 * i4;
                int i7 = i6 + i5;
                if (i4 >= 0 && i5 >= 1 && i6 < list.size()) {
                    if (i7 > list.size()) {
                        i7 = list.size();
                    }
                    return list.subList(i6, i7);
                }
                return Collections.emptyList();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                i iVar;
                WeakReference<i> weakReference = SubscriptionCallback.this.f211c;
                if (weakReference == null) {
                    iVar = null;
                } else {
                    iVar = weakReference.get();
                }
                if (iVar == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                List<SubscriptionCallback> b4 = iVar.b();
                List<Bundle> c4 = iVar.c();
                for (int i4 = 0; i4 < b4.size(); i4++) {
                    Bundle bundle = c4.get(i4);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(str, a(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str) {
                SubscriptionCallback.this.onError(str);
            }
        }

        @RequiresApi(26)
        /* loaded from: classes.dex */
        private class b extends a {
            b() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public SubscriptionCallback() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f209a = new b();
            } else {
                this.f209a = new a();
            }
        }

        void a(i iVar) {
            this.f211c = new WeakReference<>(iVar);
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onError(@NonNull String str) {
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }

        public void onError(@NonNull String str, @NonNull Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class a {
        @DoNotInline
        static MediaDescription a(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        @DoNotInline
        static int b(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<g> f214a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Messenger> f215b;

        b(g gVar) {
            this.f214a = new WeakReference<>(gVar);
        }

        void a(Messenger messenger) {
            this.f215b = new WeakReference<>(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            WeakReference<Messenger> weakReference = this.f215b;
            if (weakReference != null && weakReference.get() != null && this.f214a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                g gVar = this.f214a.get();
                Messenger messenger = this.f215b.get();
                try {
                    int i4 = message.what;
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                            } else {
                                Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                                MediaSessionCompat.ensureClassLoader(bundle);
                                Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                                MediaSessionCompat.ensureClassLoader(bundle2);
                                gVar.g(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle, bundle2);
                            }
                        } else {
                            gVar.f(messenger);
                        }
                    } else {
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        gVar.i(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        gVar.f(messenger);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        @NonNull
        MediaSessionCompat.Token a();

        void b(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback);

        void c(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback);

        void connect();

        ComponentName d();

        void disconnect();

        @Nullable
        Bundle getExtras();

        @NonNull
        String getRoot();

        boolean isConnected();

        void j(@NonNull String str, @NonNull ItemCallback itemCallback);

        void k(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback);

        void l(@NonNull String str, SubscriptionCallback subscriptionCallback);

        @Nullable
        Bundle m();
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    static class e extends d {
        e(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d, android.support.v4.media.MediaBrowserCompat.c
        public void j(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (this.f222g == null) {
                this.f217b.getItem(str, itemCallback.f200a);
            } else {
                super.j(str, itemCallback);
            }
        }
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    static class f extends e {
        f(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d, android.support.v4.media.MediaBrowserCompat.c
        public void k(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            if (this.f222g != null && this.f221f >= 2) {
                super.k(str, bundle, subscriptionCallback);
            } else if (bundle != null) {
                this.f217b.subscribe(str, bundle, subscriptionCallback.f209a);
            } else {
                this.f217b.subscribe(str, subscriptionCallback.f209a);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d, android.support.v4.media.MediaBrowserCompat.c
        public void l(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            if (this.f222g != null && this.f221f >= 2) {
                super.l(str, subscriptionCallback);
            } else if (subscriptionCallback != null) {
                this.f217b.unsubscribe(str, subscriptionCallback.f209a);
            } else {
                this.f217b.unsubscribe(str);
            }
        }
    }

    /* loaded from: classes.dex */
    interface g {
        void f(Messenger messenger);

        void g(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void i(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f251a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f252b;

        public h(IBinder iBinder, Bundle bundle) {
            this.f251a = new Messenger(iBinder);
            this.f252b = bundle;
        }

        private void g(int i4, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i4;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f251a.send(obtain);
        }

        void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            g(3, bundle2, messenger);
        }

        void b(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            g(5, bundle, messenger);
        }

        void c(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f252b);
            g(6, bundle, messenger);
        }

        void d(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            g(4, bundle, messenger);
        }

        void e(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            g(8, bundle2, messenger);
        }

        void f(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            g(9, bundle2, messenger);
        }

        void h(Messenger messenger) throws RemoteException {
            g(7, null, messenger);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        private final List<SubscriptionCallback> f253a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<Bundle> f254b = new ArrayList();

        public SubscriptionCallback a(Bundle bundle) {
            for (int i4 = 0; i4 < this.f254b.size(); i4++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f254b.get(i4), bundle)) {
                    return this.f253a.get(i4);
                }
            }
            return null;
        }

        public List<SubscriptionCallback> b() {
            return this.f253a;
        }

        public List<Bundle> c() {
            return this.f254b;
        }

        public boolean d() {
            return this.f253a.isEmpty();
        }

        public void e(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            for (int i4 = 0; i4 < this.f254b.size(); i4++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f254b.get(i4), bundle)) {
                    this.f253a.set(i4, subscriptionCallback);
                    return;
                }
            }
            this.f253a.add(subscriptionCallback);
            this.f254b.add(bundle);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            this.f195a = new f(context, componentName, connectionCallback, bundle);
        } else if (i4 >= 23) {
            this.f195a = new e(context, componentName, connectionCallback, bundle);
        } else {
            this.f195a = new d(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        this.f195a.connect();
    }

    public void disconnect() {
        this.f195a.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.f195a.getExtras();
    }

    public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        this.f195a.j(str, itemCallback);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getNotifyChildrenChangedOptions() {
        return this.f195a.m();
    }

    @NonNull
    public String getRoot() {
        return this.f195a.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.f195a.d();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.f195a.a();
    }

    public boolean isConnected() {
        return this.f195a.isConnected();
    }

    public void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
        if (!TextUtils.isEmpty(str)) {
            if (searchCallback != null) {
                this.f195a.c(str, bundle, searchCallback);
                return;
            }
            throw new IllegalArgumentException("callback cannot be null");
        }
        throw new IllegalArgumentException("query cannot be empty");
    }

    public void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.f195a.b(str, bundle, customActionCallback);
            return;
        }
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.f195a.k(str, null, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public void unsubscribe(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f195a.l(str, null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.f195a.l(str, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public void subscribe(@NonNull String str, @NonNull Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle != null) {
            this.f195a.k(str, bundle, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("options are null");
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;

        /* renamed from: a  reason: collision with root package name */
        private final int f204a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f205b;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<MediaItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public MediaItem[] newArray(int i4) {
                return new MediaItem[i4];
            }
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i4) {
            if (mediaDescriptionCompat != null) {
                if (!TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                    this.f204a = i4;
                    this.f205b = mediaDescriptionCompat;
                    return;
                }
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj != null) {
                MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
                return new MediaItem(MediaDescriptionCompat.fromMediaDescription(a.a(mediaItem)), a.b(mediaItem));
            }
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(fromMediaItem(it.next()));
                }
                return arrayList;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.f205b;
        }

        public int getFlags() {
            return this.f204a;
        }

        @Nullable
        public String getMediaId() {
            return this.f205b.getMediaId();
        }

        public boolean isBrowsable() {
            if ((this.f204a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isPlayable() {
            if ((this.f204a & 2) != 0) {
                return true;
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "MediaItem{mFlags=" + this.f204a + ", mDescription=" + this.f205b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f204a);
            this.f205b.writeToParcel(parcel, i4);
        }

        MediaItem(Parcel parcel) {
            this.f204a = parcel.readInt();
            this.f205b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }

    /* loaded from: classes.dex */
    public static class ConnectionCallback {
        final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new a();
        b mConnectionCallbackInternal;

        @RequiresApi(21)
        /* loaded from: classes.dex */
        private class a extends MediaBrowser.ConnectionCallback {
            a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                b bVar = ConnectionCallback.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    bVar.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                b bVar = ConnectionCallback.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    bVar.h();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                b bVar = ConnectionCallback.this.mConnectionCallbackInternal;
                if (bVar != null) {
                    bVar.e();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void e();

            void h();

            void onConnected();
        }

        void setInternalConnectionCallback(b bVar) {
            this.mConnectionCallbackInternal = bVar;
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    static class d implements c, g, ConnectionCallback.b {

        /* renamed from: a  reason: collision with root package name */
        final Context f216a;

        /* renamed from: b  reason: collision with root package name */
        protected final MediaBrowser f217b;

        /* renamed from: c  reason: collision with root package name */
        protected final Bundle f218c;

        /* renamed from: d  reason: collision with root package name */
        protected final b f219d = new b(this);

        /* renamed from: e  reason: collision with root package name */
        private final ArrayMap<String, i> f220e = new ArrayMap<>();

        /* renamed from: f  reason: collision with root package name */
        protected int f221f;

        /* renamed from: g  reason: collision with root package name */
        protected h f222g;

        /* renamed from: h  reason: collision with root package name */
        protected Messenger f223h;

        /* renamed from: i  reason: collision with root package name */
        private MediaSessionCompat.Token f224i;

        /* renamed from: j  reason: collision with root package name */
        private Bundle f225j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ItemCallback f226a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f227b;

            a(ItemCallback itemCallback, String str) {
                this.f226a = itemCallback;
                this.f227b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f226a.onError(this.f227b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ItemCallback f229a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f230b;

            b(ItemCallback itemCallback, String str) {
                this.f229a = itemCallback;
                this.f230b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f229a.onError(this.f230b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ItemCallback f232a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f233b;

            c(ItemCallback itemCallback, String str) {
                this.f232a = itemCallback;
                this.f233b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f232a.onError(this.f233b);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$d$d  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0000d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SearchCallback f235a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f236b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f237c;

            RunnableC0000d(SearchCallback searchCallback, String str, Bundle bundle) {
                this.f235a = searchCallback;
                this.f236b = str;
                this.f237c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f235a.onError(this.f236b, this.f237c);
            }
        }

        /* loaded from: classes.dex */
        class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SearchCallback f239a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f240b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f241c;

            e(SearchCallback searchCallback, String str, Bundle bundle) {
                this.f239a = searchCallback;
                this.f240b = str;
                this.f241c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f239a.onError(this.f240b, this.f241c);
            }
        }

        /* loaded from: classes.dex */
        class f implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CustomActionCallback f243a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f244b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f245c;

            f(CustomActionCallback customActionCallback, String str, Bundle bundle) {
                this.f243a = customActionCallback;
                this.f244b = str;
                this.f245c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f243a.onError(this.f244b, this.f245c, null);
            }
        }

        /* loaded from: classes.dex */
        class g implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CustomActionCallback f247a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f248b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f249c;

            g(CustomActionCallback customActionCallback, String str, Bundle bundle) {
                this.f247a = customActionCallback;
                this.f248b = str;
                this.f249c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f247a.onError(this.f248b, this.f249c, null);
            }
        }

        d(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Bundle bundle2;
            this.f216a = context;
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            this.f218c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
            connectionCallback.setInternalConnectionCallback(this);
            this.f217b = new MediaBrowser(context, componentName, connectionCallback.mConnectionCallbackFwk, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        @NonNull
        public MediaSessionCompat.Token a() {
            if (this.f224i == null) {
                this.f224i = MediaSessionCompat.Token.fromToken(this.f217b.getSessionToken());
            }
            return this.f224i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void b(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
            if (isConnected()) {
                if (this.f222g == null) {
                    Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
                    if (customActionCallback != null) {
                        this.f219d.post(new f(customActionCallback, str, bundle));
                    }
                }
                try {
                    this.f222g.f(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.f219d), this.f223h);
                    return;
                } catch (RemoteException e4) {
                    Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e4);
                    if (customActionCallback != null) {
                        this.f219d.post(new g(customActionCallback, str, bundle));
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void c(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
            if (isConnected()) {
                if (this.f222g == null) {
                    Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
                    this.f219d.post(new RunnableC0000d(searchCallback, str, bundle));
                    return;
                }
                try {
                    this.f222g.e(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.f219d), this.f223h);
                    return;
                } catch (RemoteException e4) {
                    Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e4);
                    this.f219d.post(new e(searchCallback, str, bundle));
                    return;
                }
            }
            throw new IllegalStateException("search() called while not connected");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void connect() {
            this.f217b.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public ComponentName d() {
            return this.f217b.getServiceComponent();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void disconnect() {
            Messenger messenger;
            h hVar = this.f222g;
            if (hVar != null && (messenger = this.f223h) != null) {
                try {
                    hVar.h(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            this.f217b.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.b
        public void e() {
            this.f222g = null;
            this.f223h = null;
            this.f224i = null;
            this.f219d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void g(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.f223h != messenger) {
                return;
            }
            i iVar = this.f220e.get(str);
            if (iVar == null) {
                if (MediaBrowserCompat.f194b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onLoadChildren for id that isn't subscribed id=");
                    sb.append(str);
                    return;
                }
                return;
            }
            SubscriptionCallback a4 = iVar.a(bundle);
            if (a4 != null) {
                if (bundle == null) {
                    if (list == null) {
                        a4.onError(str);
                        return;
                    }
                    this.f225j = bundle2;
                    a4.onChildrenLoaded(str, list);
                    this.f225j = null;
                } else if (list == null) {
                    a4.onError(str, bundle);
                } else {
                    this.f225j = bundle2;
                    a4.onChildrenLoaded(str, list, bundle);
                    this.f225j = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        @Nullable
        public Bundle getExtras() {
            return this.f217b.getExtras();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        @NonNull
        public String getRoot() {
            return this.f217b.getRoot();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public boolean isConnected() {
            return this.f217b.isConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void j(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (!TextUtils.isEmpty(str)) {
                if (itemCallback != null) {
                    if (!this.f217b.isConnected()) {
                        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                        this.f219d.post(new a(itemCallback, str));
                        return;
                    } else if (this.f222g == null) {
                        this.f219d.post(new b(itemCallback, str));
                        return;
                    } else {
                        try {
                            this.f222g.b(str, new ItemReceiver(str, itemCallback, this.f219d), this.f223h);
                            return;
                        } catch (RemoteException unused) {
                            Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                            this.f219d.post(new c(itemCallback, str));
                            return;
                        }
                    }
                }
                throw new IllegalArgumentException("cb is null");
            }
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void k(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Bundle bundle2;
            i iVar = this.f220e.get(str);
            if (iVar == null) {
                iVar = new i();
                this.f220e.put(str, iVar);
            }
            subscriptionCallback.a(iVar);
            if (bundle == null) {
                bundle2 = null;
            } else {
                bundle2 = new Bundle(bundle);
            }
            iVar.e(bundle2, subscriptionCallback);
            h hVar = this.f222g;
            if (hVar == null) {
                this.f217b.subscribe(str, subscriptionCallback.f209a);
                return;
            }
            try {
                hVar.a(str, subscriptionCallback.f210b, bundle2, this.f223h);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void l(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            i iVar = this.f220e.get(str);
            if (iVar == null) {
                return;
            }
            h hVar = this.f222g;
            if (hVar == null) {
                if (subscriptionCallback == null) {
                    this.f217b.unsubscribe(str);
                } else {
                    List<SubscriptionCallback> b4 = iVar.b();
                    List<Bundle> c4 = iVar.c();
                    for (int size = b4.size() - 1; size >= 0; size--) {
                        if (b4.get(size) == subscriptionCallback) {
                            b4.remove(size);
                            c4.remove(size);
                        }
                    }
                    if (b4.size() == 0) {
                        this.f217b.unsubscribe(str);
                    }
                }
            } else {
                try {
                    if (subscriptionCallback == null) {
                        hVar.d(str, null, this.f223h);
                    } else {
                        List<SubscriptionCallback> b5 = iVar.b();
                        List<Bundle> c5 = iVar.c();
                        for (int size2 = b5.size() - 1; size2 >= 0; size2--) {
                            if (b5.get(size2) == subscriptionCallback) {
                                this.f222g.d(str, subscriptionCallback.f210b, this.f223h);
                                b5.remove(size2);
                                c5.remove(size2);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("removeSubscription failed with RemoteException parentId=");
                    sb.append(str);
                }
            }
            if (iVar.d() || subscriptionCallback == null) {
                this.f220e.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public Bundle m() {
            return this.f225j;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.b
        public void onConnected() {
            try {
                Bundle extras = this.f217b.getExtras();
                if (extras == null) {
                    return;
                }
                this.f221f = extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.f222g = new h(binder, this.f218c);
                    Messenger messenger = new Messenger(this.f219d);
                    this.f223h = messenger;
                    this.f219d.a(messenger);
                    try {
                        this.f222g.c(this.f216a, this.f223h);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (asInterface != null) {
                    this.f224i = MediaSessionCompat.Token.fromToken(this.f217b.getSessionToken(), asInterface);
                }
            } catch (IllegalStateException e4) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e4);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.b
        public void h() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void f(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void i(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemCallback {

        /* renamed from: a  reason: collision with root package name */
        final MediaBrowser.ItemCallback f200a;

        @RequiresApi(23)
        /* loaded from: classes.dex */
        private class a extends MediaBrowser.ItemCallback {
            a() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(@NonNull String str) {
                ItemCallback.this.onError(str);
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                ItemCallback.this.onItemLoaded(MediaItem.fromMediaItem(mediaItem));
            }
        }

        public ItemCallback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f200a = new a();
            } else {
                this.f200a = null;
            }
        }

        public void onError(@NonNull String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SearchCallback {
        public void onError(@NonNull String str, Bundle bundle) {
        }

        public void onSearchResult(@NonNull String str, Bundle bundle, @NonNull List<MediaItem> list) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }
}
