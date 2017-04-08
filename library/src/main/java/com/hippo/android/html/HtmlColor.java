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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class HtmlColor {
  private HtmlColor() {}

  /**
   * Name-value mapping of HTML/CSS colors.
   */
  private static final Map<String, Integer> sColorMap;

  static {
    sColorMap = new HashMap<>();
    sColorMap.put("aliceblue", 0xFFF0F8FF);
    sColorMap.put("antiquewhite", 0xFFFAEBD7);
    sColorMap.put("aqua", 0xFF00FFFF);
    sColorMap.put("aquamarine", 0xFF7FFFD4);
    sColorMap.put("azure", 0xFFF0FFFF);
    sColorMap.put("beige", 0xFFF5F5DC);
    sColorMap.put("bisque", 0xFFFFE4C4);
    sColorMap.put("black", 0xFF000000);
    sColorMap.put("blanchedalmond", 0xFFFFEBCD);
    sColorMap.put("blue", 0xFF0000FF);
    sColorMap.put("blueviolet", 0xFF8A2BE2);
    sColorMap.put("brown", 0xFFA52A2A);
    sColorMap.put("burlywood", 0xFFDEB887);
    sColorMap.put("cadetblue", 0xFF5F9EA0);
    sColorMap.put("chartreuse", 0xFF7FFF00);
    sColorMap.put("chocolate", 0xFFD2691E);
    sColorMap.put("coral", 0xFFFF7F50);
    sColorMap.put("cornflowerblue", 0xFF6495ED);
    sColorMap.put("cornsilk", 0xFFFFF8DC);
    sColorMap.put("crimson", 0xFFDC143C);
    sColorMap.put("cyan", 0xFF00FFFF);
    sColorMap.put("darkblue", 0xFF00008B);
    sColorMap.put("darkcyan", 0xFF008B8B);
    sColorMap.put("darkgoldenrod", 0xFFB8860B);
    sColorMap.put("darkgray", 0xFFA9A9A9);
    sColorMap.put("darkgrey", 0xFFA9A9A9);
    sColorMap.put("darkgreen", 0xFF006400);
    sColorMap.put("darkkhaki", 0xFFBDB76B);
    sColorMap.put("darkmagenta", 0xFF8B008B);
    sColorMap.put("darkolivegreen", 0xFF556B2F);
    sColorMap.put("darkorange", 0xFFFF8C00);
    sColorMap.put("darkorchid", 0xFF9932CC);
    sColorMap.put("darkred", 0xFF8B0000);
    sColorMap.put("darksalmon", 0xFFE9967A);
    sColorMap.put("darkseagreen", 0xFF8FBC8F);
    sColorMap.put("darkslateblue", 0xFF483D8B);
    sColorMap.put("darkslategray", 0xFF2F4F4F);
    sColorMap.put("darkslategrey", 0xFF2F4F4F);
    sColorMap.put("darkturquoise", 0xFF00CED1);
    sColorMap.put("darkviolet", 0xFF9400D3);
    sColorMap.put("deeppink", 0xFFFF1493);
    sColorMap.put("deepskyblue", 0xFF00BFFF);
    sColorMap.put("dimgray", 0xFF696969);
    sColorMap.put("dimgrey", 0xFF696969);
    sColorMap.put("dodgerblue", 0xFF1E90FF);
    sColorMap.put("firebrick", 0xFFB22222);
    sColorMap.put("floralwhite", 0xFFFFFAF0);
    sColorMap.put("forestgreen", 0xFF228B22);
    sColorMap.put("fuchsia", 0xFFFF00FF);
    sColorMap.put("gainsboro", 0xFFDCDCDC);
    sColorMap.put("ghostwhite", 0xFFF8F8FF);
    sColorMap.put("gold", 0xFFFFD700);
    sColorMap.put("goldenrod", 0xFFDAA520);
    sColorMap.put("gray", 0xFF808080);
    sColorMap.put("grey", 0xFF808080);
    sColorMap.put("green", 0xFF008000);
    sColorMap.put("greenyellow", 0xFFADFF2F);
    sColorMap.put("honeydew", 0xFFF0FFF0);
    sColorMap.put("hotpink", 0xFFFF69B4);
    sColorMap.put("indianred", 0xFFCD5C5C);
    sColorMap.put("indigo", 0xFF4B0082);
    sColorMap.put("ivory", 0xFFFFFFF0);
    sColorMap.put("khaki", 0xFFF0E68C);
    sColorMap.put("lavender", 0xFFE6E6FA);
    sColorMap.put("lavenderblush", 0xFFFFF0F5);
    sColorMap.put("lawngreen", 0xFF7CFC00);
    sColorMap.put("lemonchiffon", 0xFFFFFACD);
    sColorMap.put("lightblue", 0xFFADD8E6);
    sColorMap.put("lightcoral", 0xFFF08080);
    sColorMap.put("lightcyan", 0xFFE0FFFF);
    sColorMap.put("lightgoldenrodyellow", 0xFFFAFAD2);
    sColorMap.put("lightgray", 0xFFD3D3D3);
    sColorMap.put("lightgrey", 0xFFD3D3D3);
    sColorMap.put("lightgreen", 0xFF90EE90);
    sColorMap.put("lightpink", 0xFFFFB6C1);
    sColorMap.put("lightsalmon", 0xFFFFA07A);
    sColorMap.put("lightseagreen", 0xFF20B2AA);
    sColorMap.put("lightskyblue", 0xFF87CEFA);
    sColorMap.put("lightslategray", 0xFF778899);
    sColorMap.put("lightslategrey", 0xFF778899);
    sColorMap.put("lightsteelblue", 0xFFB0C4DE);
    sColorMap.put("lightyellow", 0xFFFFFFE0);
    sColorMap.put("lime", 0xFF00FF00);
    sColorMap.put("limegreen", 0xFF32CD32);
    sColorMap.put("linen", 0xFFFAF0E6);
    sColorMap.put("magenta", 0xFFFF00FF);
    sColorMap.put("maroon", 0xFF800000);
    sColorMap.put("mediumaquamarine", 0xFF66CDAA);
    sColorMap.put("mediumblue", 0xFF0000CD);
    sColorMap.put("mediumorchid", 0xFFBA55D3);
    sColorMap.put("mediumpurple", 0xFF9370DB);
    sColorMap.put("mediumseagreen", 0xFF3CB371);
    sColorMap.put("mediumslateblue", 0xFF7B68EE);
    sColorMap.put("mediumspringgreen", 0xFF00FA9A);
    sColorMap.put("mediumturquoise", 0xFF48D1CC);
    sColorMap.put("mediumvioletred", 0xFFC71585);
    sColorMap.put("midnightblue", 0xFF191970);
    sColorMap.put("mintcream", 0xFFF5FFFA);
    sColorMap.put("mistyrose", 0xFFFFE4E1);
    sColorMap.put("moccasin", 0xFFFFE4B5);
    sColorMap.put("navajowhite", 0xFFFFDEAD);
    sColorMap.put("navy", 0xFF000080);
    sColorMap.put("oldlace", 0xFFFDF5E6);
    sColorMap.put("olive", 0xFF808000);
    sColorMap.put("olivedrab", 0xFF6B8E23);
    sColorMap.put("orange", 0xFFFFA500);
    sColorMap.put("orangered", 0xFFFF4500);
    sColorMap.put("orchid", 0xFFDA70D6);
    sColorMap.put("palegoldenrod", 0xFFEEE8AA);
    sColorMap.put("palegreen", 0xFF98FB98);
    sColorMap.put("paleturquoise", 0xFFAFEEEE);
    sColorMap.put("palevioletred", 0xFFDB7093);
    sColorMap.put("papayawhip", 0xFFFFEFD5);
    sColorMap.put("peachpuff", 0xFFFFDAB9);
    sColorMap.put("peru", 0xFFCD853F);
    sColorMap.put("pink", 0xFFFFC0CB);
    sColorMap.put("plum", 0xFFDDA0DD);
    sColorMap.put("powderblue", 0xFFB0E0E6);
    sColorMap.put("purple", 0xFF800080);
    sColorMap.put("rebeccapurple", 0xFF663399);
    sColorMap.put("red", 0xFFFF0000);
    sColorMap.put("rosybrown", 0xFFBC8F8F);
    sColorMap.put("royalblue", 0xFF4169E1);
    sColorMap.put("saddlebrown", 0xFF8B4513);
    sColorMap.put("salmon", 0xFFFA8072);
    sColorMap.put("sandybrown", 0xFFF4A460);
    sColorMap.put("seagreen", 0xFF2E8B57);
    sColorMap.put("seashell", 0xFFFFF5EE);
    sColorMap.put("sienna", 0xFFA0522D);
    sColorMap.put("silver", 0xFFC0C0C0);
    sColorMap.put("skyblue", 0xFF87CEEB);
    sColorMap.put("slateblue", 0xFF6A5ACD);
    sColorMap.put("slategray", 0xFF708090);
    sColorMap.put("slategrey", 0xFF708090);
    sColorMap.put("snow", 0xFFFFFAFA);
    sColorMap.put("springgreen", 0xFF00FF7F);
    sColorMap.put("steelblue", 0xFF4682B4);
    sColorMap.put("tan", 0xFFD2B48C);
    sColorMap.put("teal", 0xFF008080);
    sColorMap.put("thistle", 0xFFD8BFD8);
    sColorMap.put("tomato", 0xFFFF6347);
    sColorMap.put("turquoise", 0xFF40E0D0);
    sColorMap.put("violet", 0xFFEE82EE);
    sColorMap.put("wheat", 0xFFF5DEB3);
    sColorMap.put("white", 0xFFFFFFFF);
    sColorMap.put("whitesmoke", 0xFFF5F5F5);
    sColorMap.put("yellow", 0xFFFFFF00);
    sColorMap.put("yellowgreen", 0xFF9ACD32);
  }

  public static int parseColor(String color) throws NumberFormatException {
    if (color.charAt(0) == '#') {
      if (color.length() >= 7) {
        // #ff0000
        return 0xFF000000 | Integer.parseInt(color.substring(1, 7), 16);
      } else if (color.length() >= 4) {
        // #f00
        int c = Integer.parseInt(color.substring(1, 4), 16);
        int r = c & 0xF00;
        int g = c & 0xF0;
        int b = c & 0xF;
        return 0xFF000000 | r << 12 | r << 8 | g << 8 | g << 4 | b << 4 | b;
      }
    } else if (color.startsWith("rgb(") && color.endsWith(")")) {
      // rgb(255, 0, 0)
      // rgb(100%, 0%, 0%)
      String str = color.substring(4, color.length() - 1);
      String[] colors = str.split(",");
      if (colors.length >= 3) {
        int r = parseRGB(colors[0]);
        int g = parseRGB(colors[1]);
        int b = parseRGB(colors[2]);
        return argb(0xFF, r, g, b);
      }
    } else if (color.startsWith("rgba(") && color.endsWith(")")) {
      // rgba(255, 0, 0, 0.6)
      // rgba(100%, 0%, 0%, 0.6)
      String str = color.substring(5, color.length() - 1);
      String[] colors = str.split(",");
      if (colors.length >= 4) {
        int r = parseRGB(colors[0]);
        int g = parseRGB(colors[1]);
        int b = parseRGB(colors[2]);
        int a = parseA(colors[3]);
        return argb(a, r, g, b);
      }
    } else if (color.startsWith("hsl(") && color.endsWith(")")) {
      // hsl(120, 100%, 50%)
      String str = color.substring(4, color.length() - 1);
      String[] colors = str.split(",");
      if (colors.length >= 3) {
        float h = parseH(colors[0]);
        float s = parseSL(colors[1]);
        float l = parseSL(colors[2]);
        return HSLToColor(h, s, l, 0xFF);
      }
    } else if (color.startsWith("hsla(") && color.endsWith(")")) {
      // hsla(120, 100%, 25%, 0.3)
      String str = color.substring(5, color.length() - 1);
      String[] colors = str.split(",");
      if (colors.length >= 4) {
        float h = parseH(colors[0]);
        float s = parseSL(colors[1]);
        float l = parseSL(colors[2]);
        int a = parseA(colors[3]);
        return HSLToColor(h, s, l, a);
      }
    } else {
      Integer c = sColorMap.get(color.toLowerCase(Locale.US));
      if (c != null) {
        return c;
      }
    }
    throw new NumberFormatException();
  }

  private static int parseRGB(String str) {
    str = str.trim();
    int i;
    if (str.endsWith("%")) {
      i = 255 * Integer.parseInt(str.substring(0, str.length() - 1)) / 100;
    } else {
      i = Integer.parseInt(str);
    }
    return constrain(i, 0, 255);
  }

  private static int parseA(String str) {
    int a = (int) (255 * Float.parseFloat(str.trim()));
    return constrain(a, 0, 255);
  }

  private static float parseH(String str) {
    return Integer.parseInt(str.trim()) % 360;
  }

  private static float parseSL(String str) {
    str = str.trim();
    if (str.endsWith("%")) {
      float f = Integer.parseInt(str.substring(0, str.length() - 1)) / 100.0f;
      return constrain(f, 0.0f, 1.0f);
    }
    throw new NumberFormatException();
  }

  /**
   * Convert HSL (hue-saturation-lightness) components to a RGB color.
   * <ul>
   * <li>h is Hue [0...360)</li>
   * <li>s is Saturation [0...1]</li>
   * <li>l is Lightness [0...1]</li>
   * <li>a is alpha [0...255]</li>
   * </ul>
   * If hsv values are out of range, they are pinned.
   *
   * @return the resulting RGB color
   */
  private static int HSLToColor(float h, float s, float l, int a) {
    final float c = (1f - Math.abs(2 * l - 1f)) * s;
    final float m = l - 0.5f * c;
    final float x = c * (1f - Math.abs((h / 60f % 2f) - 1f));

    final int hueSegment = (int) h / 60;

    int r = 0, g = 0, b = 0;

    switch (hueSegment) {
      case 0:
        r = Math.round(255 * (c + m));
        g = Math.round(255 * (x + m));
        b = Math.round(255 * m);
        break;
      case 1:
        r = Math.round(255 * (x + m));
        g = Math.round(255 * (c + m));
        b = Math.round(255 * m);
        break;
      case 2:
        r = Math.round(255 * m);
        g = Math.round(255 * (c + m));
        b = Math.round(255 * (x + m));
        break;
      case 3:
        r = Math.round(255 * m);
        g = Math.round(255 * (x + m));
        b = Math.round(255 * (c + m));
        break;
      case 4:
        r = Math.round(255 * (x + m));
        g = Math.round(255 * m);
        b = Math.round(255 * (c + m));
        break;
      case 5:
      case 6:
        r = Math.round(255 * (c + m));
        g = Math.round(255 * m);
        b = Math.round(255 * (x + m));
        break;
    }

    r = constrain(r, 0, 255);
    g = constrain(g, 0, 255);
    b = constrain(b, 0, 255);

    return argb(a, r, g, b);
  }

  private static int argb(int alpha, int red, int green, int blue) {
    return (alpha << 24) | (red << 16) | (green << 8) | blue;
  }

  private static int constrain(int amount, int low, int high) {
    return amount < low ? low : (amount > high ? high : amount);
  }

  private static float constrain(float amount, float low, float high) {
    return amount < low ? low : (amount > high ? high : amount);
  }
}
