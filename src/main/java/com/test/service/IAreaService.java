package com.test.service;


import com.test.domain.dto.AreaDTO;
import com.test.domain.orm.Area;

import java.util.List;

/**
 * 区域操作
 *
 * @author wangban
 * @date 10:04 2019/3/7
 */
public interface IAreaService {
    /**
     * 获取区域列表
     *
     * @return 列表
     */
    List<Area> getAreaList();

    /**
     * 获取区域数量
     *
     * @return 区域数量
     */
    int getCount();

    /**
     * 根据id获取区域数据
     *
     * @param areaId 区域id
     * @return 区域信息
     */
    Area getAreaById(int areaId);

    /**
     * 增加区域
     *
     * @param area 区域
     * @return 是否成功
     */
    boolean addArea(AreaDTO area);

    /**
     * 修改区域
     *
     * @param area 区域
     * @return 是否成功
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域
     *
     * @param areaId 区域id
     * @return 是否成功
     */
    boolean deleteAreaById(int areaId);

}
