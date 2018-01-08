/**
 * Copyright 2017- Mark C. Slee, Heron Arts LLC
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

package heronarts.lx.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import heronarts.lx.LX;

public class LXScriptEngine {

  private ScriptEngine engine;

  private String scriptPath = ".";

  public LXScriptEngine(LX lx) {
  }

  public LXScriptEngine setScriptPath(String path) {
    this.scriptPath = path;
    return this;
  }

  public String getScriptPath() {
    return this.scriptPath;
  }

  public ScriptEngine getEngine() {
    if (this.engine == null) {
      this.engine = new ScriptEngineManager().getEngineByName("nashorn");
    }
    return this.engine;
  }

}
