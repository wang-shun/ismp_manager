package org.infosec.ismp.applet.discover.ui;

import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;

/**
 * SNMPEntryData
 * @author sshanshan
 * @date 2009-06-18
 * @version 1.0
 */

public class SNMPEntryData {
		/**
		 * 是否选中
		 */
        private Boolean isSelect = new Boolean(false);
        /**
         * id
         */
        private Integer id = null;
        /**
         * ip
         */
		private String ip = null;
		/**
		 * 端口
		 */
        private Integer port = null;
        /**
         * 节点类型
         */
        private NodeType type = null;
        /**
         * 尝试次数
         */
        private Integer tryTimes = null;
        /**
         * 应答时间
         */
        private String responseTime = null;
    	/**
    	 * 获取SNMP信息的团体名
    	 */
    	private String community;
        /**
         * 节点描述
         */
        private String description = null;
        
        /**
         * 构造函数
         */
        public SNMPEntryData(){
            
        }

        /**
         * 获取是否选中
         * @return isSelect
         */
        public Boolean getIsSelect() {
            return isSelect;
        }
        /**
         * 设置是否选中
         * @param isSelect
         */
        public void setIsSelect(Boolean isSelect) {
            this.isSelect = isSelect;
        }

        /**
         * 获取端口
         * @return port
         */
        public Integer getPort() {
			return port;
		}

        /**
         * 设置端口
         * @param port
         */
		public void setPort(Integer port) {
			this.port = port;
		}
        
		/**
		 * 获取id
		 * @return id
		 */
        public Integer getId() {
			return id;
		}

        /**
         * 设置id
         * @param id
         */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * 获取ip
		 * @return ip
		 */
		public String getIp() {
            return ip;
        }

		/**
		 * 设置ip
		 * @param ip
		 */
        public void setIp(String ip) {
            this.ip = ip;
        }

        /**
         * 获取节点类型
         * @return type
         */
        public NodeType getType() {
            return type;
        }

        /**
         * 设置节点类型
         * @param type
         */
        public void setType(NodeType type) {
            this.type = type;
        }

        /**
         * 获取尝试次数
         * @return tryTimes
         */
        public Integer getTryTimes() {
            return tryTimes;
        }

        /**
         * 设置尝试次数
         * @param tryTimes
         */
        public void setTryTimes(Integer tryTimes) {
            this.tryTimes = tryTimes;
        }

        /**
         * 获取应答时间
         * @return responseTime
         */
        public String getResponseTime() {
            return responseTime;
        }

        /**
         * 设置应答时间
         * @param responseTime
         */
        public void setResponseTime(String responseTime) {
            this.responseTime = responseTime;
        }

    	public String getCommunity() {
    		return community;
    	}

    	public void setCommunity(String community) {
    		this.community = community;
    	}

        /**
         * 获取节点描述
         * @return
         */
        public String getDescription() {
            return description;
        }

        /**
         * 设置节点描述
         * @param description
         */
        public void setDescription(String description) {
            this.description = description;
        }
    
}
