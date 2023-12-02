package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.protocol.module.DOMStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DOMStoragePeerManager extends ChromePeerManager {
    private final Context mContext;
    private final PeerRegistrationListener mPeerListener;

    /* loaded from: classes3.dex */
    private class DevToolsSharedPreferencesListener implements SharedPreferences.OnSharedPreferenceChangeListener {
        private final Map<String, Object> mCopy;
        private final SharedPreferences mPrefs;
        private final DOMStorage.StorageId mStorageId;

        public DevToolsSharedPreferencesListener(SharedPreferences sharedPreferences, String str) {
            this.mPrefs = sharedPreferences;
            DOMStorage.StorageId storageId = new DOMStorage.StorageId();
            this.mStorageId = storageId;
            storageId.securityOrigin = str;
            storageId.isLocalStorage = true;
            this.mCopy = DOMStoragePeerManager.prefsCopy(sharedPreferences.getAll());
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            Object obj;
            Map<String, ?> all = sharedPreferences.getAll();
            boolean containsKey = this.mCopy.containsKey(str);
            boolean containsKey2 = all.containsKey(str);
            if (containsKey2) {
                obj = all.get(str);
            } else {
                obj = null;
            }
            if (containsKey && containsKey2) {
                DOMStoragePeerManager.this.signalItemUpdated(this.mStorageId, str, SharedPreferencesHelper.valueToString(this.mCopy.get(str)), SharedPreferencesHelper.valueToString(obj));
                this.mCopy.put(str, obj);
            } else if (containsKey) {
                DOMStoragePeerManager.this.signalItemRemoved(this.mStorageId, str);
                this.mCopy.remove(str);
            } else if (containsKey2) {
                DOMStoragePeerManager.this.signalItemAdded(this.mStorageId, str, SharedPreferencesHelper.valueToString(obj));
                this.mCopy.put(str, obj);
            } else {
                LogUtil.i("Detected rapid put/remove of %s", str);
            }
        }

        public void unregister() {
            this.mPrefs.unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    public DOMStoragePeerManager(Context context) {
        PeersRegisteredListener peersRegisteredListener = new PeersRegisteredListener() { // from class: com.facebook.stetho.inspector.domstorage.DOMStoragePeerManager.1
            private final List<DevToolsSharedPreferencesListener> mPrefsListeners = new ArrayList();

            @Override // com.facebook.stetho.inspector.helper.PeersRegisteredListener
            protected synchronized void onFirstPeerRegistered() {
                for (String str : SharedPreferencesHelper.getSharedPreferenceTags(DOMStoragePeerManager.this.mContext)) {
                    SharedPreferences sharedPreferences = DOMStoragePeerManager.this.mContext.getSharedPreferences(str, 0);
                    DevToolsSharedPreferencesListener devToolsSharedPreferencesListener = new DevToolsSharedPreferencesListener(sharedPreferences, str);
                    sharedPreferences.registerOnSharedPreferenceChangeListener(devToolsSharedPreferencesListener);
                    this.mPrefsListeners.add(devToolsSharedPreferencesListener);
                }
            }

            @Override // com.facebook.stetho.inspector.helper.PeersRegisteredListener
            protected synchronized void onLastPeerUnregistered() {
                for (DevToolsSharedPreferencesListener devToolsSharedPreferencesListener : this.mPrefsListeners) {
                    devToolsSharedPreferencesListener.unregister();
                }
                this.mPrefsListeners.clear();
            }
        };
        this.mPeerListener = peersRegisteredListener;
        this.mContext = context;
        setListener(peersRegisteredListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> prefsCopy(Map<String, ?> map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                hashMap.put(key, shallowCopy((Set) value));
            } else {
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }

    private static <T> Set<T> shallowCopy(Set<T> set) {
        HashSet hashSet = new HashSet();
        for (T t3 : set) {
            hashSet.add(t3);
        }
        return hashSet;
    }

    public void signalItemAdded(DOMStorage.StorageId storageId, String str, String str2) {
        DOMStorage.DomStorageItemAddedParams domStorageItemAddedParams = new DOMStorage.DomStorageItemAddedParams();
        domStorageItemAddedParams.storageId = storageId;
        domStorageItemAddedParams.key = str;
        domStorageItemAddedParams.newValue = str2;
        sendNotificationToPeers("DOMStorage.domStorageItemAdded", domStorageItemAddedParams);
    }

    public void signalItemRemoved(DOMStorage.StorageId storageId, String str) {
        DOMStorage.DomStorageItemRemovedParams domStorageItemRemovedParams = new DOMStorage.DomStorageItemRemovedParams();
        domStorageItemRemovedParams.storageId = storageId;
        domStorageItemRemovedParams.key = str;
        sendNotificationToPeers("DOMStorage.domStorageItemRemoved", domStorageItemRemovedParams);
    }

    public void signalItemUpdated(DOMStorage.StorageId storageId, String str, String str2, String str3) {
        DOMStorage.DomStorageItemUpdatedParams domStorageItemUpdatedParams = new DOMStorage.DomStorageItemUpdatedParams();
        domStorageItemUpdatedParams.storageId = storageId;
        domStorageItemUpdatedParams.key = str;
        domStorageItemUpdatedParams.oldValue = str2;
        domStorageItemUpdatedParams.newValue = str3;
        sendNotificationToPeers("DOMStorage.domStorageItemUpdated", domStorageItemUpdatedParams);
    }
}
