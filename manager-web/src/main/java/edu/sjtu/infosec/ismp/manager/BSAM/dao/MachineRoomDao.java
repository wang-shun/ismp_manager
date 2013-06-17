package edu.sjtu.infosec.ismp.manager.BSAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoom;
import edu.sjtu.infosec.ismp.security.Domain;

public interface MachineRoomDao extends BaseDao {
	
	/**
	 * 获取机房列表。
	 * Author：cchang
	 * @return
	 * 2010-10-27 15:48:45
	 */
	List getMachineRoomList();
	
	/**
	 * 获取机房列表（分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-1 19:56:41
	 */
	List getMachineRoomList(int startResult, int maxResult);
	
	
	/**
	 * 获取机房列表（分页  分域）。
	 * Author：cchang
	 * @return
	 * 2010-12-3 15:05:16
	 */
	List getMachineRoomListByDomain(List<Domain> userDomainList, int startResult, int maxResult);
	
	/**
	 * 获取机房列表（分域）。
	 * Author：cchang
	 * @return
	 * 2010-12-3 15:05:16
	 */
	List getMachineRoomListByDomain(List<Domain> userDomainList);
	
	/**
	 * 保存或者更新机房信息
	 * Author：cchang
	 * @param machineRoom
	 * 2010-11-25 18:33:50
	 */
	void saveOrUpdateMachineRoom(MachineRoom machineRoom);
	/**
	 * 取得机房列表总记录条数
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	int getCount();
	
	/**
	 * 取得机房列表总记录条数（分域）
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	int getCountByDomain(List<Domain> userDomainList);
	
	/**
	 * 获取机房下的子单位(机柜和主机)列表（分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-20 10:42:47
	 */
	List getSubUnitById(String id,int startResult, int maxResult);

	/**
	 * 获取机房下的子单位(机柜和主机)列表（不分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-20 10:42:47
	 */
	List getSubUnitById(String id);
	
	/**
	 * 获取机房下的子单位总个数(机柜和主机)。
	 * Author：cchang
	 * @return
	 * 2010-12-20 16:06:02
	 */
	int getSubUnitCountById(String id);
	
	/**
	 * 根据机房的name查找机房列表
	 * Author：cchang
	 * @param name
	 * @return
	 * 2010-11-25 18:38:04
	 */
	List<MachineRoom> getMachineRoomByName(String name);
	
//	======================================================
}
