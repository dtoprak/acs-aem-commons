/*
 * #%L
 * ACS AEM Commons Bundle
 * %%
 * Copyright (C) 2013 Adobe
 * %%
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
 * #L%
 */
package com.adobe.acs.commons.designer;

import com.day.cq.wcm.api.designer.Design;
import org.apache.sling.api.SlingHttpServletRequest;

import java.io.IOException;
import java.io.Writer;

public interface DesignHtmlLibraryManager {
    public static final String RESOURCE_NAME = "clientlibs";
    public static final String PROPERTY_CSS = "css";
    public static final String PROPERTY_JS = "js";

    /**
     * Writes the CSS include snippets to the given writer.
     * The paths to the CSS libraries are included that match the given categories for client libraries (as specified on the Design page) associated with the pageRegion for the currentDesign
     *
     * @param request Sling Request obj
     * @param design the Design to look up appropriate client libs from (usually currentDesign)
     * @param pageRegion PageRegion enum
     * @param writer writer to output link and script tags to
     * @throws IOException
     */
    public void writeCssInclude(SlingHttpServletRequest request, Design design, PageRegion pageRegion, Writer writer) throws IOException;

    /**
     * Writes the JS include snippets to the given writer.
     * The paths to the JS libraries are included that match the given categories for client libraries (as specified on the Design page) associated with the pageRegion for the currentDesign
     *
     * @param request Sling Request obj
     * @param design the Design to look up appropriate client libs from (usually currentDesign)
     * @param pageRegion PageRegion enum
     * @param writer writer to output link and script tags to
     * @throws IOException
     */
    public void writeJsInclude(SlingHttpServletRequest request, Design design, PageRegion pageRegion, Writer writer) throws IOException;

    /**
     * Writes the include snippets to the given writer.
     * The paths to the libraries (CSS and JS) are included that match the given categories for client libraries (as specified on the Design page) associated with the pageRegion for the currentDesign
     *
     * @param request Sling Request obj
     * @param design the Design to look up appropriate client libs from (usually currentDesign)
     * @param pageRegion PageRegion enum
     * @param writer writer to output link and script tags to
     * @throws IOException
     */
    public void writeIncludes(SlingHttpServletRequest request, Design design, PageRegion pageRegion, Writer writer) throws IOException;

    /**
     * Returns an ordered list of all CSS (as specified on the Design page) client libraries associated with the pageRegion for the design
     *
     * @param design the Design to look up appropriate client libs from (usually currentDesign)
     * @param pageRegion PageRegion enum
     * @return an ordered array of client library category names
     */
    public String[] getCssLibraries(Design design, PageRegion pageRegion);

    /**
     * Returns an ordered list of all JS (as specified on the Design page) client libraries associated with the pageRegion for the design
     *
     * @param design the Design to look up appropriate client libs from (usually currentDesign)
     * @param pageRegion PageRegion enum
     * @return an ordered array of client library category names
     */
    public String[] getJsLibraries(Design design, PageRegion pageRegion);

    /**
     * Returns an ordered list of all (CSS and JS; as specified on the Design page) client libraries associated with the pageRegion for the design
     *
     * @param design the Design to look up appropriate client libs from (usually currentDesign)
     * @param pageRegion PageRegion enum
     * @return an ordered array of client library category names
     */
    public String[] getLibraries(Design design, PageRegion pageRegion);
}
