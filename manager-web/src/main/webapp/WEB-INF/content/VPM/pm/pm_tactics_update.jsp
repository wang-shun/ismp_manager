<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
function checkeddiv(data){
    data.getContent().find("td").find("#optionalAddress").slideToggle('slow');
}
</script>
     <div  id="data" class="pad1">
      <h2>策略定制详细信息</h2>
          <form id="tfrom">
              <table>
                  <tr>
                    <th>策略名称</th>
                    <td> <input type="text" id="tname" name="t.name"/>  <input name="globalDefaultPolicy" class="noneborder" type="checkbox"/>全局默认策略</td>
                  </tr>
                  <tr>
                    <th>是否自动更新</th>
                    <td><input name="t.isAutoUpdate" id="ites1" type="radio" class="noneborder"  value="1"/>是 <input name="t.isAutoUpdate" id="ites0" class="noneborder"  type="radio" value="0" />否</td>
                  </tr>
                  <tr>
                    <th>更新方式</th>
                    <td><select id="tupW" name="t.updateWay"><Option value="2">通知下载并通知安装</Option><Option value="3">自动下载并通知安装</Option><Option value="4">自动下载并计划安装（在计划时间安装） 推荐</Option></select></td>
                  </tr>
                  <tr>
                    <th>更新地址</th>
                    <td><input name="t.updateAddress" class="noneborder" id="qdpt" onclick="checkeddiv(Boxy.get(this))" type="checkbox" value=""/>启用平台默认地址(<span id="ipdress"></span>)<div id="optionalAddress" style="display:none">自选地址:&nbsp;<input name="t.updateAddress" id="xyaddress" type="text" size="16" /></div></td>
                  </tr>
                  <tr>
                    <th>更新时间</th>
                    <td><input size="16" type="text" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'H:00'})" class="Wdate" value="12:00" id="uptime" name="t.updateTime" realvalue="08:mm:ss">
                    </td>
                  </tr>
            </table>
        </form>
     <a href="javascript:void(0)" onclick="sht.upajax(Boxy.get(this),Boxy.getEleValue(this))" class="R6 martop10">确定</a>
    </div>