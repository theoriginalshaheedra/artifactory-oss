/*
 *
 * Artifactory is a binaries repository manager.
 * Copyright (C) 2018 JFrog Ltd.
 *
 * Artifactory is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * Artifactory is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Artifactory.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.artifactory.rest.resource.token;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

/**
 * @author Yinon Avraham
 */
public enum GrantType {

    ClientCredentials("client_credentials"),
    RefreshToken("refresh_token"),
    Password("password");

    private final String signature;

    GrantType(@Nonnull String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return signature;
    }

    @Nonnull
    public static GrantType fromSignature(@Nonnull String signature) {
        return Stream.of(values())
                .filter(grantType -> grantType.getSignature().equals(signature))
                .findFirst()
                .orElseThrow(() -> new GrantTypeNotSupportedException(signature));
    }
}