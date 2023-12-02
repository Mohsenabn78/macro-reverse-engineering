package com.koushikdutta.async.http;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class ProtocolVersion implements Serializable, Cloneable {
    private static final long serialVersionUID = 8950662842175091068L;
    protected final int major;
    protected final int minor;
    protected final String protocol;

    public ProtocolVersion(String str, int i4, int i5) {
        if (str != null) {
            if (i4 >= 0) {
                if (i5 >= 0) {
                    this.protocol = str;
                    this.major = i4;
                    this.minor = i5;
                    return;
                }
                throw new IllegalArgumentException("Protocol minor version number may not be negative");
            }
            throw new IllegalArgumentException("Protocol major version number must not be negative.");
        }
        throw new IllegalArgumentException("Protocol name must not be null.");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int compareToVersion(ProtocolVersion protocolVersion) {
        if (protocolVersion != null) {
            if (this.protocol.equals(protocolVersion.protocol)) {
                int major = getMajor() - protocolVersion.getMajor();
                if (major == 0) {
                    return getMinor() - protocolVersion.getMinor();
                }
                return major;
            }
            throw new IllegalArgumentException("Versions for different protocols cannot be compared. " + this + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + protocolVersion);
        }
        throw new IllegalArgumentException("Protocol version must not be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProtocolVersion)) {
            return false;
        }
        ProtocolVersion protocolVersion = (ProtocolVersion) obj;
        if (this.protocol.equals(protocolVersion.protocol) && this.major == protocolVersion.major && this.minor == protocolVersion.minor) {
            return true;
        }
        return false;
    }

    public ProtocolVersion forVersion(int i4, int i5) {
        if (i4 == this.major && i5 == this.minor) {
            return this;
        }
        return new ProtocolVersion(this.protocol, i4, i5);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final boolean greaterEquals(ProtocolVersion protocolVersion) {
        if (isComparable(protocolVersion) && compareToVersion(protocolVersion) >= 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.protocol.hashCode() ^ (this.major * AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength)) ^ this.minor;
    }

    public boolean isComparable(ProtocolVersion protocolVersion) {
        if (protocolVersion != null && this.protocol.equals(protocolVersion.protocol)) {
            return true;
        }
        return false;
    }

    public final boolean lessEquals(ProtocolVersion protocolVersion) {
        if (isComparable(protocolVersion) && compareToVersion(protocolVersion) <= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.protocol + '/' + Integer.toString(this.major) + '.' + Integer.toString(this.minor);
    }
}
