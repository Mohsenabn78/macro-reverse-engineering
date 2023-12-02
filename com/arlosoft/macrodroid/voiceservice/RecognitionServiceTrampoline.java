package com.arlosoft.macrodroid.voiceservice;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.speech.RecognitionListener;
import android.speech.RecognitionService;
import android.speech.SpeechRecognizer;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class RecognitionServiceTrampoline extends RecognitionService {
    public final ConcurrentHashMap<RecognitionService.Callback, SpeechRecognizer> recognizerMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface b {
        void run() throws RemoteException;
    }

    private RecognitionListener a(RecognitionService.Callback callback) {
        return new a(callback);
    }

    private String b() {
        if (Build.VERSION.SDK_INT >= 31) {
            return "com.google.android.tts";
        }
        return "com.google.android.googlequicksearchbox";
    }

    private String c() {
        if (Build.VERSION.SDK_INT >= 31) {
            return "com.google.android.apps.speech.tts.googletts.service.GoogleTTSRecognitionService";
        }
        return "com.google.android.voicesearch.serviceapi.GoogleRecognitionService";
    }

    @Override // android.speech.RecognitionService
    protected void onCancel(RecognitionService.Callback callback) {
        SpeechRecognizer remove = this.recognizerMap.remove(callback);
        if (remove != null) {
            remove.cancel();
        }
    }

    @Override // android.speech.RecognitionService
    protected void onStartListening(Intent intent, RecognitionService.Callback callback) {
        if (!this.recognizerMap.containsKey(callback) || this.recognizerMap.get(callback) == null) {
            SpeechRecognizer createSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getApplicationContext(), new ComponentName(b(), c()));
            createSpeechRecognizer.setRecognitionListener(a(callback));
            this.recognizerMap.put(callback, createSpeechRecognizer);
        }
        this.recognizerMap.get(callback).startListening(intent);
    }

    @Override // android.speech.RecognitionService
    protected void onStopListening(RecognitionService.Callback callback) {
        SpeechRecognizer speechRecognizer = this.recognizerMap.get(callback);
        if (speechRecognizer != null) {
            speechRecognizer.stopListening();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements RecognitionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecognitionService.Callback f16443a;

        a(RecognitionService.Callback callback) {
            this.f16443a = callback;
        }

        private void m(b bVar) {
            try {
                bVar.run();
            } catch (RemoteException unused) {
            }
        }

        @Override // android.speech.RecognitionListener
        public void onBeginningOfSpeech() {
            final RecognitionService.Callback callback = this.f16443a;
            Objects.requireNonNull(callback);
            m(new b() { // from class: com.arlosoft.macrodroid.voiceservice.g
                @Override // com.arlosoft.macrodroid.voiceservice.RecognitionServiceTrampoline.b
                public final void run() {
                    callback.beginningOfSpeech();
                }
            });
        }

        @Override // android.speech.RecognitionListener
        public void onBufferReceived(final byte[] bArr) {
            final RecognitionService.Callback callback = this.f16443a;
            m(new b() { // from class: com.arlosoft.macrodroid.voiceservice.e
                @Override // com.arlosoft.macrodroid.voiceservice.RecognitionServiceTrampoline.b
                public final void run() {
                    callback.bufferReceived(bArr);
                }
            });
        }

        @Override // android.speech.RecognitionListener
        public void onEndOfSpeech() {
            final RecognitionService.Callback callback = this.f16443a;
            Objects.requireNonNull(callback);
            m(new b() { // from class: com.arlosoft.macrodroid.voiceservice.a
                @Override // com.arlosoft.macrodroid.voiceservice.RecognitionServiceTrampoline.b
                public final void run() {
                    callback.endOfSpeech();
                }
            });
        }

        @Override // android.speech.RecognitionListener
        public void onError(final int i4) {
            final RecognitionService.Callback callback = this.f16443a;
            m(new b() { // from class: com.arlosoft.macrodroid.voiceservice.c
                @Override // com.arlosoft.macrodroid.voiceservice.RecognitionServiceTrampoline.b
                public final void run() {
                    callback.error(i4);
                }
            });
        }

        @Override // android.speech.RecognitionListener
        public void onPartialResults(final Bundle bundle) {
            final RecognitionService.Callback callback = this.f16443a;
            m(new b() { // from class: com.arlosoft.macrodroid.voiceservice.b
                @Override // com.arlosoft.macrodroid.voiceservice.RecognitionServiceTrampoline.b
                public final void run() {
                    callback.partialResults(bundle);
                }
            });
        }

        @Override // android.speech.RecognitionListener
        public void onReadyForSpeech(final Bundle bundle) {
            final RecognitionService.Callback callback = this.f16443a;
            m(new b() { // from class: com.arlosoft.macrodroid.voiceservice.f
                @Override // com.arlosoft.macrodroid.voiceservice.RecognitionServiceTrampoline.b
                public final void run() {
                    callback.readyForSpeech(bundle);
                }
            });
        }

        @Override // android.speech.RecognitionListener
        public void onResults(final Bundle bundle) {
            final RecognitionService.Callback callback = this.f16443a;
            m(new b() { // from class: com.arlosoft.macrodroid.voiceservice.h
                @Override // com.arlosoft.macrodroid.voiceservice.RecognitionServiceTrampoline.b
                public final void run() {
                    callback.results(bundle);
                }
            });
        }

        @Override // android.speech.RecognitionListener
        public void onRmsChanged(final float f4) {
            final RecognitionService.Callback callback = this.f16443a;
            m(new b() { // from class: com.arlosoft.macrodroid.voiceservice.d
                @Override // com.arlosoft.macrodroid.voiceservice.RecognitionServiceTrampoline.b
                public final void run() {
                    callback.rmsChanged(f4);
                }
            });
        }

        @Override // android.speech.RecognitionListener
        public void onEvent(int i4, Bundle bundle) {
        }
    }
}
