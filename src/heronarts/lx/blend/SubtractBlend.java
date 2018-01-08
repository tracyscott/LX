/**
 * Copyright 2016- Mark C. Slee, Heron Arts LLC
 *
 * This file is part of the LX Studio software library. By using
 * LX, you agree to the terms of the LX Studio Software License
 * and Distribution Agreement, available at: http://lx.studio/license
 *
 * Please note that the LX license is not open-source. The license
 * allows for free, non-commercial use.
 *
 * HERON ARTS MAKES NO WARRANTY, EXPRESS, IMPLIED, STATUTORY, OR
 * OTHERWISE, AND SPECIFICALLY DISCLAIMS ANY WARRANTY OF
 * MERCHANTABILITY, NON-INFRINGEMENT, OR FITNESS FOR A PARTICULAR
 * PURPOSE, WITH RESPECT TO THE SOFTWARE.
 *
 * @author Mark C. Slee <mark@heronarts.com>
 */

package heronarts.lx.blend;

import heronarts.lx.LX;

public class SubtractBlend extends LXBlend {

  public SubtractBlend(LX lx) {
    super(lx);
  }

  @Override
  public void blend(int[] dst, int[] src, double alpha, int[] output) {
    int alphaAdjust = (int) (alpha * 0x100);
    for (int i = 0; i < src.length; ++i) {
      int a = (((src[i] >>> ALPHA_SHIFT) * alphaAdjust) >> 8) & 0xff;

      int srcAlpha = a + (a >= 0x7F ? 1 : 0);

      int rb = (src[i] & RB_MASK) * srcAlpha >>> 8;
      int gn = (src[i] & G_MASK) * srcAlpha >>> 8;

      output[i] = min((dst[i] >>> ALPHA_SHIFT) + a, 0xff) << ALPHA_SHIFT |
        max((dst[i] & R_MASK) - (rb & R_MASK), 0) |
        max((dst[i] & G_MASK) - (gn & G_MASK), 0) |
        max((dst[i] & B_MASK) - (rb & B_MASK), 0);
    }
  }
}
