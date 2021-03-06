/*
 * Copyright 2012-2013 the original author or authors.
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

package griffon.plugins.hibernate4;

import griffon.util.CallableWithArgs;
import groovy.lang.Closure;

/**
 * @author Andres Almiray
 */
public class Hibernate4ContributionAdapter implements Hibernate4ContributionHandler {
    private static final String DEFAULT = "default";

    private Hibernate4Provider provider = DefaultHibernate4Provider.getInstance();

    public void setHibernate4Provider(Hibernate4Provider provider) {
        this.provider = provider != null ? provider : DefaultHibernate4Provider.getInstance();
    }

    public Hibernate4Provider getHibernate4Provider() {
        return provider;
    }

    public <R> R withHibernate4(Closure<R> closure) {
        return withHibernate4(DEFAULT, closure);
    }

    public <R> R withHibernate4(String sessionFactoryName, Closure<R> closure) {
        return provider.withHibernate4(sessionFactoryName, closure);
    }

    public <R> R withHibernate4(CallableWithArgs<R> callable) {
        return withHibernate4(DEFAULT, callable);
    }

    public <R> R withHibernate4(String sessionFactoryName, CallableWithArgs<R> callable) {
        return provider.withHibernate4(sessionFactoryName, callable);
    }
}