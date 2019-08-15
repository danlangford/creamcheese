package com.danlangford.creamcheese;

import com.avereon.product.ProductBundle;
import com.avereon.xenon.Mod;
import com.avereon.xenon.tool.ToolMetadata;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program extends Mod {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Override
  public ClassLoader getClassLoader() {
    return null;
  }

  @Override
  public ProductBundle getResourceBundle() {
    return null;
  }

  @Override
  public void register() {
    log.info("Register MouseMod");
    this.getProgram().getIconLibrary().register("mouse-maze", MouseMazeIcon.class);
    this.mouseMazeResourceType = new MouseMazeResourceType(this);
    this.getProgram().getResourceManager().addResourceType(this.mouseMazeResourceType);
    ResourceBundle.getBundle("com/avereon/mouse/bundles/tool");
    ResourceBundle rb = ResourceBundle.getBundle("com/avereon/mouse/bundles/tool", this.getClass().getModule());

    ToolMetadata metadata = new ToolMetadata(this, MouseMazeTool.class);
    metadata.setIcon(this.getProgram().getIconLibrary().getIcon("mouse-maze"));
    metadata.setName(rb.getString("mouse-maze-name"));
    this.getProgram().getToolManager().registerTool(this.mouseMazeResourceType, metadata);
    ProductBundle var10001 = this.getProgram().getResourceBundle();
    log.warn("Program RB: " + var10001.getString("label", "available"));
    log.warn("Registered tool: " + metadata.getName());
  }

  @Override
  public void startup() {

  }

  @Override
  public void shutdown() {

  }

  @Override
  public void unregister() {

  }
}
