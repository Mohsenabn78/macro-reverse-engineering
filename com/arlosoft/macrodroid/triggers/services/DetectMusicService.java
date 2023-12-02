package com.arlosoft.macrodroid.triggers.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.MusicPlayingTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DetectMusicService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private a f15420a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a aVar = new a(getApplicationContext());
        this.f15420a = aVar;
        aVar.d(true);
        this.f15420a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        a aVar = this.f15420a;
        if (aVar != null) {
            aVar.d(false);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        return 1;
    }

    /* loaded from: classes3.dex */
    private static class a extends AsyncTask<Void, List<Macro>, Void> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f15421a = true;

        /* renamed from: b  reason: collision with root package name */
        private final Object f15422b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<Context> f15423c;

        public a(Context context) {
            this.f15423c = new WeakReference<>(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            boolean z3;
            Context context = this.f15423c.get();
            if (context == null) {
                return null;
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            ArrayList arrayList = new ArrayList();
            boolean z4 = false;
            while (this.f15421a) {
                try {
                    Thread.sleep(1200L);
                } catch (InterruptedException unused) {
                }
                boolean isMusicActive = audioManager.isMusicActive();
                if (isMusicActive != z4) {
                    synchronized (this.f15422b) {
                        arrayList.clear();
                        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                            while (it.hasNext()) {
                                Trigger next = it.next();
                                if (next instanceof MusicPlayingTrigger) {
                                    MusicPlayingTrigger musicPlayingTrigger = (MusicPlayingTrigger) next;
                                    if (musicPlayingTrigger.getOption() == 0) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3 == isMusicActive && musicPlayingTrigger.constraintsMet()) {
                                        macro.setTriggerThatInvoked(musicPlayingTrigger);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList.add(macro);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    publishProgress(arrayList);
                    z4 = isMusicActive;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onProgressUpdate(List<Macro>... listArr) {
            synchronized (this.f15422b) {
                for (Macro macro : listArr[0]) {
                    macro.invokeActions(new TriggerContextInfo(macro.getTriggerThatInvoked()));
                }
            }
        }

        public void d(boolean z3) {
            this.f15421a = z3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r12) {
        }
    }
}
