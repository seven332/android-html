/*
 * Copyright 2017 Hippo Seven
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

package com.hippo.android.html;

/*
 * Created by Hippo on 2/9/2017.
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HtmlColorTest {

  @Test
  public void testParseColor() {
    assertEquals(0xFFFF44AA, HtmlColor.parseColor("#F4A"));
    assertEquals(0xFFFB4BAB, HtmlColor.parseColor("#FB4BAB"));
    assertEquals(0xFFFF2A57, HtmlColor.parseColor("rgb(255, 42, 87)"));
    assertEquals(0xFFFF6BDD, HtmlColor.parseColor("rgb(100%, 42%, 87%)"));
    assertEquals(0xB2FF2A57, HtmlColor.parseColor("rgba(255, 42, 87, 0.7)"));
    assertEquals(0xB2FF6BDD, HtmlColor.parseColor("rgba(100%, 42%, 87%, 0.7)"));
    assertEquals(0xFF00FF00, HtmlColor.parseColor("hsl(120, 100%, 50%)"));
    assertEquals(0xB200FF00, HtmlColor.parseColor("hsla(120, 100%, 50%, 0.7)"));
  }
}
