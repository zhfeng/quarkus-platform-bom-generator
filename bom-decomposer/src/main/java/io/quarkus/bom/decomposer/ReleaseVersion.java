package io.quarkus.bom.decomposer;

import java.util.Objects;

public interface ReleaseVersion {

    class Factory {
        public static ReleaseVersion tag(String tag) {
            return new StringReleaseVersion("Tag", tag);
        }

        public static ReleaseVersion version(String version) {
            return new StringReleaseVersion("Version", version);
        }
    }

    String asString();

    class StringReleaseVersion implements ReleaseVersion {
        final String type;
        final String value;

        StringReleaseVersion(String type, String value) {
            this.type = Objects.requireNonNull(type);
            this.value = Objects.requireNonNull(value);
        }

        @Override
        public String asString() {
            return value;
        }

        @Override
        public String toString() {
            return type + ": " + value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            StringReleaseVersion other = (StringReleaseVersion) obj;
            return Objects.equals(type, other.type) && Objects.equals(value, other.value);
        }
    }
}
