/*
 * Copyright 2008-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package groovy.transform;

import groovy.lang.Script;
import org.codehaus.groovy.transform.GroovyASTTransformationClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Variable annotation used for getting the URI of the current script.
 * <p>
 * The type of the variable annotated with {@BaseScript} must be assignment compatible with {@link java.net.URI}.
 * It will be used to hold a URI object that references the source for the current script.
 * </p><p>By default the URI
 * will be made absolute (which is to say it will have an authority) in the case where a relative path was used
 * for the source of the script.  If you want to leave relative URIs as relative, then set <code>allowRelative</code>
 * to <code>true</code>.
 * </p>
 *
 * Example usage:
 * <pre>
 * @groovy.transform.ScriptURI def scriptURI
 *
 * assert scriptURI instanceof java.net.URI
 * </pre>
 *
 * @author Jim White
 * @since 2.3.0
 */
@java.lang.annotation.Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD})
@GroovyASTTransformationClass("org.codehaus.groovy.transform.ScriptURIASTTransformation")
public @interface ScriptURI {
    boolean allowRelative() default false;
}
