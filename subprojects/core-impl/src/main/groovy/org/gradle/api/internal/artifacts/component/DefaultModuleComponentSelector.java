/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.artifacts.component;

import org.gradle.api.artifacts.component.ModuleComponentSelector;

public class DefaultModuleComponentSelector implements ModuleComponentSelector {
    private final String displayName;
    private final String group;
    private final String name;
    private final String version;

    public DefaultModuleComponentSelector(String group, String name, String version) {
        assert group != null : "group cannot be null";
        assert name != null : "name cannot be null";
        assert version != null : "version cannot be null";
        displayName = String.format("%s:%s:%s", group, name, version);
        this.group = group;
        this.name = name;
        this.version = version;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DefaultModuleComponentSelector that = (DefaultModuleComponentSelector) o;

        if (!group.equals(that.group)) {
            return false;
        }
        if (!name.equals(that.name)) {
            return false;
        }
        if (!version.equals(that.version)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = group.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static ModuleComponentSelector newSelector(String group, String name, String version) {
        return new DefaultModuleComponentSelector(group, name, version);
    }
}
