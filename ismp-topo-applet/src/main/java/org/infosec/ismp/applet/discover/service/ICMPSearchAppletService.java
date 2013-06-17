package org.infosec.ismp.applet.discover.service;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.applet.comm.util.HttpInvokerProxyFactoryBeanUtil;
import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.applet.discover.listener.SearchListener;
import org.infosec.ismp.applet.discover.thread.ICMPSearchThread;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.ICMPAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.service.applet.ICMPSearchService;

/**
 * ICMP搜索方法类service类
 * @author Wu Guojie
 * @date 2009-6-11
 * @version 1.0
 */
public class ICMPSearchAppletService {
	/**
	 * 搜索线程
	 */
	private static ICMPSearchThread icmpSearchThread = null;
	/**
	 * 搜索方法service
	 */
	private static ICMPSearchAppletService service = null;
	/**
	 * 构造器
	 */
	private ICMPSearchAppletService(){}
	/**
	 * 实例化搜索方法service
	 * @return 搜索方法service
	 */
	public static ICMPSearchAppletService getInstance(){
	    if(service==null){
	        service = new ICMPSearchAppletService();
	    }
	    return service;
	}
	
	/**
	 * 创建icmpSearchService
	 */
	ICMPSearchService icmpSearchService = getICMPSearchService();

	/**
	 * 远程获取icmpSearchService
	 * @return ICMPSearchService实例
	 */
	public ICMPSearchService getICMPSearchService(){
		try{
			ICMPSearchService service = (ICMPSearchService)HttpInvokerProxyFactoryBeanUtil
			.getService(ServerConfig.getServerPath()+"/remoting/icmpSearchServiceRemoting", ICMPSearchService.class);
			
			return service;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 搜索
	 * @param icmpAppletForm
	 * icmpAppletForm
	 * @return 搜索结果list
	 */
	public List<Node> doSearch(ICMPAppletForm icmpAppletForm, SearchListener listener) {
		icmpSearchThread = new ICMPSearchThread(icmpAppletForm, listener);
		icmpSearchThread.start();
		/**
		 * 结果list
		 */
		List<Node> list = new ArrayList<Node>();
		list = icmpSearchThread.getList();
//		listener.onSearchFinished();
		return list;
	}
	
	/**
	 * 停止搜索
	 */
	public void stopSearch(boolean silent){
		icmpSearchThread.stopped(silent);
	}
	/**
	 * 保存节点
	 */
	public void addNodeList(List<Node> list){
		icmpSearchThread.addNodeList(list);
	}
	/**
	 * 是否有人正在执行搜索功能
	 * @return 是/否
	 */
	public boolean isSearching(){
		boolean isSearching = false;
		try{
			if(icmpSearchService!=null){
				try{
					isSearching = icmpSearchService.isSearching();
				}catch(Exception e1){
					throw new Exception("远程服务icmpSearchService不可用！");
				}
			}else{
				throw new Exception("未能获取远程服务icmpSearchService！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSearching;
	}
	/**
	 * 是否有人正在执行搜索功能
	 * @param listener
	 * 监听器
	 * @return 是/否
	 */
	public boolean isSearching(SearchListener listener){
		boolean isSearching = false;
		try{
			if(icmpSearchService!=null){
				try{
					isSearching = icmpSearchService.isSearching();
				}catch(Exception e1){
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务icmpSearchService.isSearching不可用！");
				}
			}else{
				listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
				throw new Exception("未能获取远程服务icmpSearchService！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSearching;
	}
	
	/**
	 * 方法说明：获取所有已经向Manager注册的AgentBO列表（邓东和数据库的交际）
	 * @return
	 */
//	public List<AgentBO> getAllRegisteredAgentBO(){
//		List<AgentBO> list = new ArrayList<AgentBO>();
//		try{
//			list = icmpSearchService.getAllRegisteredAgentBO();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return list;
//	}
}
