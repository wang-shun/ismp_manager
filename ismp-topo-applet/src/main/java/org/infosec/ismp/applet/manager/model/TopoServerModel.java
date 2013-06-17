/**
 * 版权所有：上海鹏越惊虹信息技术发展有限公司
 */
package org.infosec.ismp.applet.manager.model;

import javax.swing.ImageIcon;

import org.infosec.ismp.applet.manager.model.image.ImagePath;

import twaver.TUIManager;
import twaver.TWaverUtil;

/**
 * @author 肖高峰
 * 服务器模型
 */
@SuppressWarnings("serial")
public class TopoServerModel extends NodeModel implements TopoNode{
	/**
	 * 模型的名字 并重写name属性
	 */
	private static final String name="服务器";
	/**
	 * 灰色小图标
	 */
	private static final ImageIcon H = new ImageIcon(ImagePath.class.getResource("TopoServerModel-H.gif"));
	/**
	 * 灰色大图标
	 */
	private static final ImageIcon DH = new ImageIcon(ImagePath.class.getResource("TopoServerModel-DH.gif"));
	
	/**
	 * 彩色小图标
	 */
	private static final ImageIcon C = new ImageIcon(ImagePath.class.getResource("TopoServerModel-C.gif"));
	/**
	 * 彩色大图标
	 */
	private static final ImageIcon DC = new ImageIcon(ImagePath.class.getResource("TopoServerModel-DC.gif"));
	
	static {
		TUIManager.registerIcon(TopoServerModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoServerModel-H.gif");
		TUIManager.registerImage(TopoServerModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoServerModel-DH.gif");
		TWaverUtil.registerImageIcon("TopoServerModel", DC);
		TWaverUtil.registerImageIcon("TopoServerModelSmall", C);
	}
	
	public TopoServerModel() {
		super.setName(name);
	}
	
	
	/**
     * 获取激活大图标
     */
    public String activeBigICO() {
		return "TopoServerModel";	
    }
    
    /**
     * 获取激活小图标
     */
    
    public String activeSmallICO() {
		return "TopoServerModelSmall";	
    }
    
    /**
	 * 获得设备大图标
	 * @return ImageIcon
	 */
    public ImageIcon getImage(){
		return DH;
    }

	/**
	 * 获得设备小图标
	 * @return ImageIcon
	 */
    public ImageIcon getIcon(){
    	return H;
	 }
}
