package com.google.android.gms.nearby.messages.audio;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class AudioBytes {
    public static final int MAX_SIZE = 10;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f22413a;

    public AudioBytes(@NonNull byte[] bArr) {
        boolean z3;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        if (length <= 10) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Given byte array longer than 10 bytes, given by AudioBytes.MAX_SIZE.");
        Preconditions.checkArgument(length > 0, "Given byte array is of zero length.");
        this.f22413a = bArr;
    }

    @NonNull
    public static AudioBytes from(@NonNull Message message) {
        Preconditions.checkNotNull(message);
        boolean zza = message.zza(Message.MESSAGE_TYPE_AUDIO_BYTES);
        String type = message.getType();
        Preconditions.checkArgument(zza, "Message type '" + type + "' is not Message.MESSAGE_TYPE_AUDIO_BYTES.");
        return new AudioBytes(message.getContent());
    }

    @NonNull
    public byte[] getBytes() {
        return this.f22413a;
    }

    @NonNull
    public Message toMessage() {
        return new Message(this.f22413a, Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
    }

    @NonNull
    public String toString() {
        String arrays = Arrays.toString(this.f22413a);
        return "AudioBytes [" + arrays + " ]";
    }
}
